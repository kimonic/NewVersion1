package dingw.com.newversion.bean.platform;

import dingw.com.newversion.base.BaseBean;

/**
 * Created by 12348 on 2017/4/11 0011.
 * 平台--网民委托--bean
 */

public class NetizenEntrustBean extends BaseBean{

    private String proceeding;
    private String time;
    private String name;
    private String phone;
    private String details;

    public String getProceeding() {
        return proceeding;
    }

    public void setProceeding(String proceeding) {
        this.proceeding = proceeding;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
