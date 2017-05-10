package dingw.com.newversion.bean.wait;

import java.util.List;

import dingw.com.newversion.base.BaseBean;

/**
 * Created by 12348 on 2017/5/10 0010.
 * 主页--待办--网民咨询
 */

public class NetizenConsultGbean {

    private String state;
    private List<ListBean> list;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean extends BaseBean{
        /**
         * uuid : 19a75c73-3892-67ad-08d0-3eaab369be8c
         * content : 实话实说加班
         * specialities_name : 保险理赔
         * city_name : 济南市
         * user_name : 1**
         * user_img : http://oafile.weihuoliao.com/ueditor/1474963605979.jpg
         * portrait_uuid :
         * create_time : 4月27日 22:24
         * reply_num : 2
         * review_nums : 123
         */

        private String uuid;
        private String content;
        private String specialities_name;
        private String city_name;
        private String user_name;
        private String user_img;
        private String portrait_uuid;
        private String create_time;
        private String reply_num;
        private String review_nums;

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getSpecialities_name() {
            return specialities_name;
        }

        public void setSpecialities_name(String specialities_name) {
            this.specialities_name = specialities_name;
        }

        public String getCity_name() {
            return city_name;
        }

        public void setCity_name(String city_name) {
            this.city_name = city_name;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public String getUser_img() {
            return user_img;
        }

        public void setUser_img(String user_img) {
            this.user_img = user_img;
        }

        public String getPortrait_uuid() {
            return portrait_uuid;
        }

        public void setPortrait_uuid(String portrait_uuid) {
            this.portrait_uuid = portrait_uuid;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public String getReply_num() {
            return reply_num;
        }

        public void setReply_num(String reply_num) {
            this.reply_num = reply_num;
        }

        public String getReview_nums() {
            return review_nums;
        }

        public void setReview_nums(String review_nums) {
            this.review_nums = review_nums;
        }
    }
}
