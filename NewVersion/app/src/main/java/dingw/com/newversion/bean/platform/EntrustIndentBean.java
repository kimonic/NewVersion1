package dingw.com.newversion.bean.platform;

import dingw.com.newversion.base.BaseBean;

/**
 * Created by 12348 on 2017/4/11 0011.
 * 主页--平台--委托订单bean
 */

public class EntrustIndentBean extends BaseBean{
    private String indentnum;
    private String title;
    private String time;
    private String money;
    private String name;
    private String phone;

    public String getIndentnum() {
        return indentnum;
    }

    public void setIndentnum(String indentnum) {
        this.indentnum = indentnum;
    }

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

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
