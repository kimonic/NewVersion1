package dingw.com.newversion.bean.wait;

import dingw.com.newversion.base.BaseBean;

/**
 * Created by 12348 on 2017/4/2 0002.
 *
 * 工作---本所公告--xlistviewbean
 */

public class NoticeBean extends BaseBean{
    /**会议记录id*/
    private String  id;
    /**标题*/
    private String  title;
    /**创建时间*/
    private String  create_time;
    /**公告类型名字*/
    private String  classify;
    /**浏览人数*/
    private String  num;
    /**读取状态1已读0未读*/
    private String  read_type;
    /**查看律师的名字*/
    private String lawyer_name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getRead_type() {
        return read_type;
    }

    public void setRead_type(String read_type) {
        this.read_type = read_type;
    }

    public String getLawyer_name() {
        return lawyer_name;
    }

    public void setLawyer_name(String lawyer_name) {
        this.lawyer_name = lawyer_name;
    }
}
