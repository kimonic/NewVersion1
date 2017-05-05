package dingw.com.newversion.bean.wait;

import dingw.com.newversion.base.BaseBean;

/**
 * Created by 12348 on 2017/5/5 0005.
 * 主页--我的---推送设置bean
 */

public class MyItemBean extends BaseBean {
    private int content;
    private int flag;

    public MyItemBean(int content, int flag) {
        this.content = content;
        this.flag = flag;
    }

    public int getContent() {
        return content;
    }

    public void setContent(int content) {
        this.content = content;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
