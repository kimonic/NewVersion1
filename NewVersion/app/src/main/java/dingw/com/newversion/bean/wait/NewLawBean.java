package dingw.com.newversion.bean.wait;

import dingw.com.newversion.base.BaseBean;

/**
 * Created by 12348 on 2017/4/8 0008.
 * 待办--新法速递  bean
 */

public class NewLawBean extends BaseBean {
    private String title;
    private String type;
    private String time;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
