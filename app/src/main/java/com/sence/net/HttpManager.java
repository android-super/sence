package com.sence.net;

import android.widget.Toast;

import com.blankj.utilcode.util.NetworkUtils;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.orhanobut.logger.Logger;
import com.sence.base.BaseApp;
import com.sence.bean.base.BaseRequestBean;
import com.sence.bean.base.BaseResponseBean;
import com.sence.net.bean.ErrorConstants;
import com.sence.net.bean.HttpJsonErrorBean;
import com.sence.net.manager.ApiCallBack;
import com.sence.net.manager.HttpClientManager;

import java.net.SocketTimeoutException;
import java.util.concurrent.TimeoutException;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by zwy on 2019/3/19.
 * package_name is com.sence.net
 * 描述:SenceGit
 */
public class HttpManager<P> {
    private static HttpManager httpManager;

    public static HttpManager getInstance() {
        if (httpManager == null) {
            synchronized (HttpManager.class) {
                if (httpManager == null) {
                    httpManager = new HttpManager();
                }
            }
        }
        return httpManager;
    }

    private Observable observable;

    /**
     * 添加请求识别Code
     *
     * @param code
     * @return
     */
    public HttpManager PlayNetCode(HttpCode code, BaseRequestBean requestBean) {
        HttpService httpService = HttpClientManager.Instance.httpService;
        switch (code) {
            case IS_REGISTER:
                observable = httpService.IsRegister(requestBean.getMap());
                break;
            case ADDRESS_ADD:
                observable = httpService.AddressAdd(requestBean.getMap());
                break;
            case ORDER_LIST:
                observable = httpService.OrderList(requestBean.getMap());
                break;
            case ADDRESS_LIST:
                observable = httpService.AddressList(requestBean.getMap());
                break;
            case ADDRESS_DELETE:
                observable = httpService.AddressDelete(requestBean.getMap());
                break;
            case SEND_VERIFY_CODE:
                observable = httpService.SendVerifyCode(requestBean.getMap());
                break;
            case REGISTER:
                observable = httpService.Register(requestBean.getMap());
                break;
            case GOOD_DETAIL:
                observable = HttpClientManager.Instance.httpService.GoodDetail(requestBean.getMap());
                break;
            case SERVE_DETAIL:
                observable = HttpClientManager.Instance.httpService.ServeDetail(requestBean.getMap());
                break;
            case COMMENT_SHOP_LIST:
                observable = HttpClientManager.Instance.httpService.CommentShopList(requestBean.getMap());
                break;
            case SERVE_COMMENT_LIST:
                observable = HttpClientManager.Instance.httpService.ServeCommentList(requestBean.getMap());
                break;
            case ORDER_DETAIL:
                observable = HttpClientManager.Instance.httpService.OrderDetail(requestBean.getMap());
                break;
        }
        observable = observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        return this;
    }

    /**
     * 添加请求识别Code
     *
     * @param code
     * @return
     */
    public HttpManager PlayNetCode(HttpCode code) {
        switch (code) {
            case GET_SYSTEM_TIME:
                observable = HttpClientManager.Instance.httpService.getSystemTime();
                break;
        }
        observable = observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        return this;
    }


    /**
     * 去请求
     *
     * @param apiCallBack
     */
    public void request(final ApiCallBack<P> apiCallBack) {
        if (apiCallBack == null) {
            return;
        }
        observable.subscribe(new Observer<BaseResponseBean<P>>() {
            Disposable disposable = null;

            @Override
            public void onSubscribe(Disposable d) {
                disposable = d;
            }

            @Override
            public void onNext(BaseResponseBean<P> result) {
                Logger.e("status is " + result.getStatus() + "\nmsg is " + result.getMsg() + "\ndata is " + result.getData().toString());
                if (!disposable.isDisposed()) {
                    if (result.getStatus() == 1) {
                        apiCallBack.onSuccess(result.getData(), result.getMsg());
                    } else {
                        apiCallBack.Message(result.getStatus(), result.getMsg());
                    }
                    disposable.dispose();
                }
            }


            @Override
            public void onError(Throwable e) {
                Logger.e(e.toString());
                if (!NetworkUtils.isConnected()) {
                    Toast.makeText(BaseApp.INSTANCE,
                            "无法连接网络",
                            Toast.LENGTH_SHORT).show();
                } else if (e instanceof SocketTimeoutException
                        || e instanceof TimeoutException) {
                    Toast.makeText(BaseApp.INSTANCE,
                            "网络不给力",
                            Toast.LENGTH_SHORT).show();
                } else if (e instanceof JsonSyntaxException) {
                    Logger.e("error_content====" + ErrorConstants.error_content);
                    HttpJsonErrorBean errorBean = new Gson().fromJson(ErrorConstants.error_content,
                            HttpJsonErrorBean.class);
                    apiCallBack.Message(errorBean.getStatus(), errorBean.getMsg());
                } else {
                    Toast.makeText(BaseApp.INSTANCE,
                            "请求失败", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onComplete() {
                apiCallBack.onFinish();
            }
        });
    }

}
