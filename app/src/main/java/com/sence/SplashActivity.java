package com.sence;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.blankj.utilcode.util.PhoneUtils;
import com.blankj.utilcode.util.SPUtils;
import com.sence.activity.WebActivity;
import com.sence.activity.web.WebConstans;
import com.sence.activity.web.WebLinkActivity;
import com.sence.bean.request.RStartPictureBean;
import com.sence.bean.response.PStartPictureBean;
import com.sence.net.HttpCode;
import com.sence.net.HttpManager;
import com.sence.net.manager.ApiCallBack;
import com.sence.utils.*;

import java.util.concurrent.TimeUnit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


public class SplashActivity extends AppCompatActivity {
    private PermissionUtil permissionUtil;
    private Disposable disposable;
    private ImageView ivPicture, ivFullPicture;
    private PStartPictureBean bean;
    private boolean isload = true;
    private boolean isloadpic = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        if (NavigationBarUtil.hasNavigationBar(this)) {
            NavigationBarUtil.initActivity(findViewById(android.R.id.content));
        }
        StatusBarUtil.setTranslucentForCoordinatorLayout(this, 0);
        StatusBarUtil.setLightMode(this);
        ivPicture = findViewById(R.id.iv_picture);
        ivFullPicture = findViewById(R.id.iv_full_picture);
        permissionUtil = new PermissionUtil(this);
        ivFullPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isload){
                   return;
                }
                if(bean.getLink()!=null){
                    disposable.dispose();
                    Intent intent = new Intent(SplashActivity.this, WebLinkActivity.class);
                    intent.putExtra("url", bean.getLink());
                    startActivity(intent);
                    finish();
                }
            }
        });
        ivPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isloadpic){
                    return;
                }
                if(bean.getLink()!=null){
                    disposable.dispose();
                    Intent intent = new Intent(SplashActivity.this, WebLinkActivity.class);
                    intent.putExtra("url", bean.getLink());
                    startActivity(intent);
                    finish();
                }
            }
        });
        if (permissionUtil.requestPermissions(PermissionUtil.READ_PHONE_STATE,
                new String[]{Manifest.permission.READ_PHONE_STATE,Manifest.permission.WRITE_EXTERNAL_STORAGE})) {
            getStartPicture();
            disposable =
                    Observable.interval(2, TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<Long>() {
                        @Override
                        public void accept(Long aLong) {
                            disposable.dispose();
                            startActivity(new Intent(SplashActivity.this, MainActivity.class));
                            finish();
                        }
                    });
        }
        getSystemTime();
    }

    private void getStartPicture() {
        HttpManager.getInstance().PlayNetCode(HttpCode.START_PICTURE, new RStartPictureBean(PhoneUtils.getIMEI(),
                LoginStatus.getUid())).request(new ApiCallBack<PStartPictureBean>() {
            @Override
            public void onFinish() {

            }

            @Override
            public void Message(int code, String message) {

            }

            @Override
            public void onSuccess(PStartPictureBean o, String msg) {
                bean = o;
                if ("0".equals(o.getIs_full())) {
                    if(o.getLink()!=null||"".equals(o.getLink())){
                        isload=false;
                    }
                    GlideUtils.getInstance().loadNormal(o.getImg(), ivFullPicture);
                } else {
                    if(o.getLink()!=null||"".equals(o.getLink())){
                        isloadpic=false;
                    }
                    GlideUtils.getInstance().loadNormal(o.getImg(), ivPicture);
                }

            }
        });
    }

    private void getSystemTime() {
        HttpManager.getInstance().PlayNetCode(HttpCode.GET_SYSTEM_TIME).request(new ApiCallBack<String>() {
            @Override
            public void onFinish() {

            }

            @Override
            public void Message(int code, String message) {

            }

            @Override
            public void onSuccess(String time, String msg) {
                long sys_time = System.currentTimeMillis() / 1000;
                long resu = Long.parseLong(time) - sys_time;
                SPUtils.getInstance().put("sysTime", String.valueOf(resu));
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        permissionUtil.onRequestPermissionsResult(requestCode, permissions, grantResults);
        disposable =
                Observable.interval(2, TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) {
                        disposable.dispose();
                        startActivity(new Intent(SplashActivity.this, MainActivity.class));
                        finish();
                    }
                });
    }

    @Override
    protected void onDestroy() {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
        super.onDestroy();
    }
}
