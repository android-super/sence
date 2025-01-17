package com.sence.net;

/**
 * Created by zwy on 2019/3/19.
 * package_name is com.sence.net
 * 描述:SenceGit
 */
public class Urls {
    public static boolean isTest = false;

    public static final String true_ip = "http://sence.forhour.com";
    public static final String test_ip = "http://192.168.1.10:8085";
    public static final String IP_TEST = "192.168.1.10";//长连接测试
    public static final String IP_TRUE = "60.205.179.160";//长连接测试
    public static final int POST_ = 6681;//端口号
    public static final String base_ip = isTest ? IP_TEST : IP_TRUE;
    public static final String base_url = isTest ? test_ip : true_ip;
    public static final String SYSTEM_TIME = "/index.php/Api/Base/getServerTime";//获取服务器时间
    public static final String SERVICE_ADDCOMMENT = "/index.php/Api/Serve/evaluateService";//服务评论
    public static final String SEARCH_RECOMMEND = "/index.php/Api/Public/homeSearchRecommend";//搜索推荐数据
    //评论
    public static final String COMMENT_DELETE = "/index.php/Api/Public/delMsg";//删除评论
    public static final String COMMENT_SUPPORT = "/index.php/Api/Public/giveLike";//评论点赞，取消点赞
    public static final String COMMENT_ADD = "/index.php/Api/Public/addMsg";//添加评论
    public static final String COMMENT_LIST = "/index.php/Api/Public/getMsgList";//评论列表
    public static final String PAY_ALI = "/index.php/Api/Alipay/alipay_sign";//支付寶支付
    public static final String PAY_WX = "/index.php/Api/Wxpay/wx_prepay";//微信支付
    public static final String PAY_BAL = "/index.php/Api/Orders/confirmBuyGoods";//余额支付
    public static final String UPDATE_APP = "/index.php/Api/Upgrade/checkVersion";//检查版本更新
    public static final String START_PICTURE = "/index.php/Api/Public/getStartImg";//启动图片
    //用户
    public static final String SHARE_ADD_WATER = "/index.php/Api/garden/addUserWateringNum";//分享商品后增加用户浇水次数
    public static final String BLACK_LIST = "/index.php/api/user/shieldList";//拉黑列表
    public static final String RACHEL = "/index.php/api/user/shield";//拉黑
    public static final String REPORT = "/index.php/api/user/report";//举报
    public static final String GET_UPNAME = "/index.php/Api/User/getUsernameByCode";//通过邀请码获得用户名
    public static final String GET_INTRODUCER = "/index.php/Api/User/bindInviteUser";//通过邀请码绑定介绍人
    public static final String MESSAGE_INFORM = "/index.php/api/mine/informDetail";//通知列表
    public static final String SYSTEM_MESSAGE = "/index.php/api/mine/systemMessage";//系统消息列表
    public static final String MESSAGE_LIST = "/index.php/api/mine/interactiveMessage";//消息中心 - 评论、点赞列表
    public static final String MESSAGE_CENTRE = "/index.php/api/mine/messageCenter";//消息中心
    public static final String USER_CARD_DELETE = "/index.php/Api/mine/delCard";//删除银行卡
    public static final String USER_CARD_LIST = "/index.php/Api/mine/myCardList";//银行卡列表
    public static final String USER_BANK_CARD_LIST = "/index.php/Api/public/bankList";//获取银行列表
    public static final String USER_ACCOUNT = "/index.php/Api/mine/myAccount";//我的账户
    public static final String USER_INFO_DATA = "/index.php/api/user/personalInfo";//我的信息
    public static final String USER_INFO_CONTENT = "/index.php/api/user/userReleas";//我的信息
    public static final String USER_VERIFY_CHECK = "/index.php/Api/mine/checkCode";//检查验证码
    public static final String USER_GET_REAL_NAME = "/index.php/Api/mine/getRealName";//获取真实姓名
    public static final String USER_UP_HEAD = "/index.php/Api/mine/uploadAvatar";//上传头像
    public static final String USER_PAY_PW_CHANGE = "/index.php/Api/mine/modPayPwd";//修改支付密码
    public static final String USER_PW_CHANGE = "/index.php/Api/mine/editLoginPwd";//修改登录密码，忘记密码
    public static final String USER_INFO = "/index.php/Api/mine/mine";//我的
    public static final String USER_AUTH = "/index.php/Api/User/realNameAuth";//添加银行卡，实名认证
    public static final String USER_IS_REGISTER = "/index.php/Api/mine/checkPhoneNum";//用户是否注册
    public static final String USER_SEND_CODE = "/index.php/Api/User/makeCode";//发送验证码
    public static final String USER_LOGIN = "/index.php/Api/User/weChatLogin";//用户登录
    public static final String USER_SIGN_UP = "/index.php/Api/User/weChatSignUp";//用户注册
    public static final String USER_VIP = "/index.php/Api/User/getMemberInfo";//Sence会员界面
    public static final String USER_ENJOY_VIP = "/index.php/Api/User/getEnjoyInfo";//尊享会员界面
    public static final String USER_FANS_LIST = "/index.php/api/user/myFansList";//我的粉丝
    public static final String USER_FOCUS_LIST = "/index.php/api/user/myFocusList";//我的关注
    public static final String USER_NOTE_LIST = "/index.php/Api/mine/myNoteList";//我的笔记列表
    public static final String USER_FOCUS_CANCEL = "/index.php/api/user/unFocus";//取消关注
    public static final String USER_FOCUS = "/index.php/api/user/focus";//关注
    public static final String USER_CASH = "/index.php/api/mine/withdraw";//提现
    public static final String USER_RECHARGE_WX = "/index.php/api/EscrowOrders/wxPrepay";//微信充值
    public static final String USER_CLIENT_BIND = "/index.php/api/link/bind";//用户绑定Client_id
    public static final String USER_VIP_OPEN = "/index.php/api/user/openSenceKol";//开通会员
    public static final String USER_DETAIL = "/index.php/Api/mine/accountDetail";//账户明细
    public static final String USER_EDIT = "/index.php/api/mine/modUserInfo";//编辑个人资料
    public static final String USER_GOOD_LIST = "/index.php/Api/User/getMemberGoodsList";//更多会员商品列表
    public static final String USER_SERVE_LIST = "/index.php/Api/User/getVipServiceList";//更多Vip服务列表
    //主页
    public static final String MAIN_CONTENT_DETAIL = "/index.php/api/notes/getArticleDetail";//
    public static final String MAIN_NOTE_DETAIL = "/index.php/Api/Notes/getNoteDetail";//笔记详情
    public static final String MAIN_RECOMMEND = "/index.php/Api/Notes/recommendNoteList";//首页--推荐
    public static final String MAIN_FOCUS = "/index.php/Api/Notes/focusNoteList";//首页--关注
    public static final String MAIN_NOTE = "/index.php/Api/Notes/getNoteList";//首页--笔记
    public static final String NOTE_DELETE = "/index.php/Api/Notes/delUserNote";//删除笔记
    public static final String NOTE_ADD = "/index.php/Api/Notes/addUserNote";//添加笔记
    public static final String SUPPORT_NOTE_RECOMMEND = "/index.php/api/notes/giveNoteLike";//笔记点赞，取消点赞
    public static final String MAIN_SEARCH = "/index.php/Api/Public/homeSearchList";//主页搜索
    //商品
    public static final String ORDER_COMMENT_SUPPORT = "/index.php/Api/Orders/praise";//订单评论点赞
    public static final String DEFAULT_ADDRESS = "/index.php/Api/Address/getDefaultAddress";//用户默认地址
    public static final String TIME_REMAINING = "/index.php/Api/Orders/getOrderTime";//订单剩余时间
    public static final String ORDER_NOTE_GOODS = "/index.php/Api/Goods/getNotesGoods";//笔记立即购买 所有商品数据
    public static final String ORDER_DETAIL = "/index.php/Api/Orders/getOrderDetail";//订单详情
    public static final String BUS_RECOMMEND = "/index.php/Api/Goods/getCommendGoods";//购物车页面推荐商品数据
    public static final String BUS_LIST = "/index.php/Api/Goods/getCartList";//购物车列表
    public static final String ORDER_PAY = "/index.php/Api/Orders/payOrder";//支付订单
    public static final String COMMENT_SHOP_LIST = "/index.php/Api/Goods/getGoodsCommentList";//商品评论列表
    public static final String ORDER_COMMENT = "/index.php/Api/Orders/evaluateOrder";//评价订单
    public static final String ORDER_COMMIT = "/index.php/Api/Orders/submitUserOrder";//提交订单
    public static final String ORDER_LIST = "/index.php/Api/Orders/getUserOrders";//订单列表
    public static final String BUS_ADD_CUT = "/index.php/Api/Goods/handleToCart";//购物车数量增加减少
    public static final String GOOD_DETAIL = "/index.php/Api/Goods/getGoodsDetail";//商品详情
    public static final String GOOD_LIST = "/index.php/Api/Goods/getGoodsList";//商品列表
    public static final String GOOD_KIND = "/index.php/Api/Goods/getGoodsClassify";//商品分类
    public static final String ADDRESS_LIST = "/index.php/Api/Address/getAddressList";//用户地址列表
    public static final String ADDRESS_DELETE = "/index.php/Api/Address/delAddress";//删除收货地址
    public static final String ADDRESS_ADD = "/index.php/Api/Address/addAddress";//添加收货地址
    public static final String ORDER_DELETE = "/index.php/Api/Orders/cancelOrder";//取消待付款，待支付订单
    public static final String ADDRESS_EDIT = "/index.php/Api/Address/editAddress";//编辑收货地址
    public static final String CONFIRM_TAKEGOOD = "/index.php/Api/Orders/confirmReceiveGoods";//确认收货
    public static final String DELETE_DONEORDER = "/index.php/Api/Orders/deleteFinishOrder";//删除已完成订单
    //服务
    public static final String SERVE_DETAIL = "/index.php/Api/Serve/getServeDetail";//服务详情
    public static final String SERVE_COMMENT_LIST = "/index.php/Api/Serve/getServiceComments";//服务评论列表
    //V群
    public static final String CHAT_BAN = "/index.php/api/VGroup/banned";//禁言
    public static final String CHAT_SEND_MESSAGE = "/index.php/api/VGroup/sendMessageToGroup";//发送消息
    public static final String CHAT_CREATE_GROUP = "/index.php/api/VGroup/createVGroup";//创建微群
    public static final String CHAT_JOIN = "/index.php/api/VGroup/joinVGroup";//加入微群
    public static final String CHAT_MEMBER_LIST = "/index.php/api/VGroup/getVGroupUserList";//微群成员列表
    public static final String CHAT_ENTER = "/index.php/api/VGroup/enterVGroup";//进入V群
    public static final String PRIVATE_CHAT_LIST = "/index.php/api/chat/privateChatList";//私聊列表
    public static final String CHAT_GROUP_LIST = "/index.php/api/VGroup/getVGroupList";//V群列表
    public static final String CHAT_READ = "/index.php/api/VGroup/readGroupMessage";//消息已读
    public static final String CHAT_PRIVATE_LIST = "/index.php/api/chat/getChatList";//私聊聊天记录
    public static final String CHAT_PRIVATE_READ = "/index.php/api/chat/messageRead";//私聊消息已读
    public static final String CHAT_PRIVATE_SEND = "/index.php/api/chat/addUserChat";//私聊发送消息
}
