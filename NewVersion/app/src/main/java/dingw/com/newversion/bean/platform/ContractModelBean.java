package dingw.com.newversion.bean.platform;

import dingw.com.newversion.base.BaseBean;

/**
 * Created by 12348 on 2017/4/12 0012.
 * 主页--平台--合同范本bean
 */

public class ContractModelBean extends BaseBean{

    private String author;
    private String title;
    private String time;
    private String type;
    private String lawyerOffice;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLawyerOffice() {
        return lawyerOffice;
    }

    public void setLawyerOffice(String lawyerOffice) {
        this.lawyerOffice = lawyerOffice;
    }
}
