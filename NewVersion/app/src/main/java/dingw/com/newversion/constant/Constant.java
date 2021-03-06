package dingw.com.newversion.constant;

/**
 * Created by 12348 on 2017/4/5 0005.
 * 常量
 */

public class Constant {
    public static final String BASEurl="http://ceshi.12348oa.com/v1.4/lawyerapp/";
//    public static final String NEWBASEURL="http://ceshi.12348oa.com/flfw/";
    public static final String NEWBASEURL="https://develapi.12348oa.com/flfw/";
    public static final String WORK_BASEURL="http://ceshi.12348oa.com/flfw/";
    public static final String NOTICE_SEARCH_URL="http://ceshi.12348oa.com/flfw/bulletin/getList?seach=";
    public static final String MINUTE_SEARCH_URL="http://ceshi.12348oa.com/flfw/minute/getList??seach=";
    public static final String TAG="icon_boy tag------------";
    /**登录url连接*/
    public static final String LOGIN_URL="login/lawyerLoginApp";
    /**绑定解绑url连接*/
    public static final String BIND_URL="login/bindLawyer";
    /**解除绑定url连接*/
    public static final String UNBIND_URL="login/relieveBindLawyer";
    /**律师自媒体列表*/
    public static final String LAWYER_ZIMEITI=NEWBASEURL+"selfmedia/getList";
    /**律师自媒体列表详情*/
    public static final String LAWYER_ZIMEITI_DETAILS="selfmedia/getDetails";
    /**修改密码获取验证码*/
    public static final String CHANGE_PASSWORD_VERIFY_CODE="login/getVerifyCode";
    /**修改密码提交*/
    public static final String CHANGE_PASSWORD="login/updatePwd";
    /**我的财务*/
    public static final String FINANCE=NEWBASEURL+"finance_personal/total";
    /**主页--待办--网民咨询*/
    public static final String WANGMINZIXUN=NEWBASEURL+"consult/getList";
    /**主页--工作--本所公告--详情*/
    public static final String BENSUOGONGGAO_DEETAILS=NEWBASEURL+"bulletin/getDetails?id=";
    /**主页--平台--文书*/
    public static final String WENSHU=NEWBASEURL+"document/getList?type=";



}
