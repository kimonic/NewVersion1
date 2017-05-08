package dingw.com.newversion.bean.wait;

import dingw.com.newversion.base.BaseBean;

/**
 * Created by 12348 on 2017/4/6 0006.
 * 主页--社区--网民咨询bean
 *
 */

public class NetizenConsultBean extends BaseBean{
    private String title;
    private String time;
    private String type;
    private String content;
    private String browseNum;
    private String commentNum;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getBrowseNum() {
        return browseNum;
    }

    public void setBrowseNum(String browseNum) {
        this.browseNum = browseNum;
    }

    public String getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(String commentNum) {
        this.commentNum = commentNum;
    }
}
