package com.sence.net;

import com.google.gson.JsonObject;
import com.sence.bean.base.BaseResponseBean;
import com.sence.bean.response.*;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by zwy on 2019/3/19.
 * package_name is com.sence.net
 * 描述:SenceGit
 */
public interface HttpService {
    @GET(Urls.SYSTEM_TIME)
    Observable<BaseResponseBean<String>> getSystemTime();//获取系统时间

    @FormUrlEncoded
    @POST(Urls.USER_IS_REGISTER)
    Observable<BaseResponseBean<String>> IsRegister(@FieldMap Map<String, Object> map);//用户是否注册

    @FormUrlEncoded
    @GET(Urls.ADDRESS_ADD)
    Observable<BaseResponseBean<String>> AddressAdd(@FieldMap Map<String, Object> map);//添加收货地址

    @FormUrlEncoded
    @POST(Urls.ORDER_LIST)
    Observable<BaseResponseBean<PMyOrderBean>> OrderList(@FieldMap Map<String, Object> map);//订单列表

    @FormUrlEncoded
    @POST(Urls.ADDRESS_LIST)
    Observable<BaseResponseBean<List<PManageAddressBean>>> AddressList(@FieldMap Map<String, Object> map);//用户地址列表

    @FormUrlEncoded
    @POST(Urls.ADDRESS_DELETE)
    Observable<BaseResponseBean<String>> AddressDelete(@FieldMap Map<String, Object> map);//删除收货地址

    @FormUrlEncoded
    @POST(Urls.GOOD_DETAIL)
    Observable<BaseResponseBean<String>> GoodDetail(@FieldMap Map<String, Object> map);//商品详情

    @FormUrlEncoded
    @POST(Urls.USER_SEND_CODE)
    Observable<BaseResponseBean<PVerifyCodeBean>> SendVerifyCode(@FieldMap Map<String, Object> map);//发送验证码

    @FormUrlEncoded
    @POST(Urls.USER_LOGIN)
    Observable<BaseResponseBean<PUserBean>> Login(@FieldMap Map<String, Object> map);//登录

    @FormUrlEncoded
    @POST(Urls.USER_SIGN_UP)
    Observable<BaseResponseBean<PUserBean>> Register(@FieldMap Map<String, Object> map);//注册

    @FormUrlEncoded
    @POST(Urls.USER_INFO)
    Observable<BaseResponseBean<PUserInfoBean>> UserInfo(@FieldMap Map<String, Object> map);//我的信息

    @FormUrlEncoded
    @POST(Urls.USER_PW_CHANGE)
    Observable<BaseResponseBean<String>> ChangeLoginPW(@FieldMap Map<String, Object> map);//修改登录密码

    @FormUrlEncoded
    @POST(Urls.USER_PAY_PW_CHANGE)
    Observable<BaseResponseBean<String>> ChangePayPW(@FieldMap Map<String, Object> map);//修改支付密码

    @FormUrlEncoded
    @POST(Urls.USER_UP_HEAD)
    Observable<BaseResponseBean<String>> UpHead(@FieldMap Map<String, Object> map);//编辑个人资料，上传头像

    @FormUrlEncoded
    @POST(Urls.USER_GET_REAL_NAME)
    Observable<BaseResponseBean<String>> GetRealName(@FieldMap Map<String, Object> map);//获取用户真实姓名

    @FormUrlEncoded
    @POST(Urls.USER_VERIFY_CHECK)
    Observable<BaseResponseBean<String>> CheckVerify(@FieldMap Map<String, Object> map);//检查验证码（忘记密码时）

    @FormUrlEncoded
    @POST(Urls.USER_ACCOUNT)
    Observable<BaseResponseBean<PAccountBean>> MyAccount(@FieldMap Map<String, Object> map);//我的账户

    @FormUrlEncoded
    @POST(Urls.USER_CARD_LIST)
    Observable<BaseResponseBean<String>> BankCardList(@FieldMap Map<String, Object> map);//银行卡列表

    @FormUrlEncoded
    @POST(Urls.USER_CARD_DELETE)
    Observable<BaseResponseBean<String>> BankCardDelete(@FieldMap Map<String, Object> map);//删除银行卡

    @FormUrlEncoded
    @POST(Urls.COMMENT_LIST)
    Observable<BaseResponseBean<List<PCommentBean>>> CommentList(@FieldMap Map<String, Object> map);//评论列表

    @FormUrlEncoded
    @POST(Urls.COMMENT_ADD)
    Observable<BaseResponseBean<String>> CommentAdd(@FieldMap Map<String, Object> map);//添加评论

    @FormUrlEncoded
    @POST(Urls.COMMENT_SUPPORT)
    Observable<BaseResponseBean<String>> CommentSupport(@FieldMap Map<String, Object> map);//评论点赞，取消点赞

    @FormUrlEncoded
    @POST(Urls.COMMENT_DELETE)
    Observable<BaseResponseBean<String>> CommentDelete(@FieldMap Map<String, Object> map);//删除评论

    @FormUrlEncoded
    @POST(Urls.MAIN_NOTE_DETAIL)
    Observable<BaseResponseBean<PNoteDetailBean>> NoteDetail(@FieldMap Map<String, Object> map);//笔记详情

    @FormUrlEncoded
    @POST(Urls.MAIN_RECOMMEND)
    Observable<BaseResponseBean<List<PMainRecommendBean>>> MainRecommend(@FieldMap Map<String, Object> map);//首页推荐

    @FormUrlEncoded
    @POST(Urls.MAIN_FOCUS)
    Observable<BaseResponseBean<List<PMainFocusBean>>> MainFocus(@FieldMap Map<String, Object> map);//首页关注

    @FormUrlEncoded
    @POST(Urls.NOTE_DELETE)
    Observable<BaseResponseBean<String>> NoteDelete(@FieldMap Map<String, Object> map);//删除笔记

    @FormUrlEncoded
    @POST(Urls.NOTE_ADD)
    Observable<BaseResponseBean<String>> NoteAdd(@FieldMap Map<String, Object> map);//添加笔记

    @FormUrlEncoded
    @POST(Urls.MAIN_NOTE)
    Observable<BaseResponseBean<List<PMainNoteBean>>> MainNote(@FieldMap Map<String, Object> map);//首页笔记

    @FormUrlEncoded
    @POST(Urls.SERVE_DETAIL)
    Observable<BaseResponseBean<String>> ServeDetail(@FieldMap Map<String, Object> map);//服务详情

    @FormUrlEncoded
    @POST(Urls.SERVE_COMMENT_LIST)
    Observable<BaseResponseBean<String>> ServeCommentList(@FieldMap Map<String, Object> map);//服务评价列表

    @FormUrlEncoded
    @POST(Urls.SERVE_COMMENT_ADD)
    Observable<BaseResponseBean<String>> ServeCommentAdd(@FieldMap Map<String, Object> map);//添加服务评价

    @FormUrlEncoded
    @POST(Urls.GOOD_KIND)
    Observable<BaseResponseBean<List<PKindBean>>> GoodKind(@FieldMap Map<String, Object> map);//商品分类列表

    @FormUrlEncoded
    @POST(Urls.GOOD_LIST)
    Observable<BaseResponseBean<List<PGoodListBean>>> GoodList(@FieldMap Map<String, Object> map);//分类下的商品列表

    @FormUrlEncoded
    @POST(Urls.BUS_LIST)
    Observable<BaseResponseBean<PBusBean>> BusList(@FieldMap Map<String, Object> map);//分类下的商品列表

    @FormUrlEncoded
    @POST(Urls.BUS_RECOMMEND)
    Observable<BaseResponseBean<List<PBusRecommendBean>>> BusRecommend(@FieldMap Map<String, Object> map);//分类下的商品列表

    @FormUrlEncoded
    @POST(Urls.USER_VIP)
    Observable<BaseResponseBean<PUserVipBean>> UserVip(@FieldMap Map<String, Object> map);//Sence会员

    @FormUrlEncoded
    @POST(Urls.BUS_ADD_CUT)
    Observable<BaseResponseBean<Object>> BusAddCut(@FieldMap Map<String, Object> map);//添加购物车

    @FormUrlEncoded
    @POST(Urls.USER_FANS_LIST)
    Observable<BaseResponseBean<Object>> UserFansList(@FieldMap Map<String, Object> map);//我的粉絲列表

    @FormUrlEncoded
    @POST(Urls.USER_FOCUS_LISt)
    Observable<BaseResponseBean<Object>> UserFocusList(@FieldMap Map<String, Object> map);//我的关注列表

    @FormUrlEncoded
    @POST(Urls.MAIN_CONTENT_DETAIL)
    Observable<BaseResponseBean<PContentDetailBean>> ContentDetail(@FieldMap Map<String, Object> map);//内容详情

}
