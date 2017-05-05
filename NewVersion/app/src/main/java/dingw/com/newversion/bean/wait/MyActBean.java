package dingw.com.newversion.bean.wait;

import dingw.com.newversion.base.BaseBean;

/**
 * Created by 12348 on 2017/5/5 0005.
 * MyActivity中listview的数据对象
 */

public class MyActBean extends BaseBean {
    /**字符串内容*/
    private String content;
    /**资源id*/
    private int resId;
    /**字符串内容*/
    private String mark;
    /**资源id*/
    private int resIdt;

    public MyActBean(String content, int resId, String mark, int resIdt) {
        this.content = content;
        this.resId = resId;
        this.mark = mark;
        this.resIdt = resIdt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public int getResIdt() {
        return resIdt;
    }

    public void setResIdt(int resIdt) {
        this.resIdt = resIdt;
    }
}
