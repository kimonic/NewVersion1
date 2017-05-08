package dingw.com.newversion.bean.work;

import dingw.com.newversion.base.BaseBean;

/**
 * Created by 12348 on 2017/4/8 0008.
 * 主页--工作--我要批办  bean
 */

public class PiBanBean extends BaseBean{
    private String title;
    private String year;
    private String name;
    private String party;
    private String starTime;
    private String lawyerName;
    private String piBanTime;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public String getStarTime() {
        return starTime;
    }

    public void setStarTime(String starTime) {
        this.starTime = starTime;
    }

    public String getLawyerName() {
        return lawyerName;
    }

    public void setLawyerName(String lawyerName) {
        this.lawyerName = lawyerName;
    }

    public String getPiBanTime() {
        return piBanTime;
    }

    public void setPiBanTime(String piBanTime) {
        this.piBanTime = piBanTime;
    }
}
