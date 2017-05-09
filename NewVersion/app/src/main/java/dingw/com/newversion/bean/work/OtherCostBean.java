package dingw.com.newversion.bean.work;

import dingw.com.newversion.base.BaseBean;

/**
 * Created by 12348 on 2017/4/11 0011.
 * 主页--工作--其他费用--bean
 */

public class OtherCostBean extends BaseBean{
    private String title;
    private String time;
    private String balance;
    private String cause;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }
}
