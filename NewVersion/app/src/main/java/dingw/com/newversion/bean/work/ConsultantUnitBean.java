package dingw.com.newversion.bean.work;

import dingw.com.newversion.base.BaseBean;

/**
 * Created by 12348 on 2017/4/10 0010.
 * 主页--工作--顾问单位--bean
 */

public class ConsultantUnitBean extends BaseBean{
    private String  unitName;
    private String  liaison;
    private String  endTime;
    private String  isSave;
    private String  phoneNum;
    private String  landline;
    private String  qqNum;

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getLiaison() {
        return liaison;
    }

    public void setLiaison(String liaison) {
        this.liaison = liaison;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getIsSave() {
        return isSave;
    }

    public void setIsSave(String isSave) {
        this.isSave = isSave;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getLandline() {
        return landline;
    }

    public void setLandline(String landline) {
        this.landline = landline;
    }

    public String getQqNum() {
        return qqNum;
    }

    public void setQqNum(String qqNum) {
        this.qqNum = qqNum;
    }
}
