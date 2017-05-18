package dingw.com.newversion.bean.community;

import java.util.List;

import dingw.com.newversion.base.BaseBean;

/**
 * Created by 12348 on 2017/5/18 0018.
 * 
 */

public class LawyerMediaBean {

    /**
     * state : 200
     */

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

    public static class ListBean extends BaseBean {
        /**
         * id : 126
         * uuid : 6627bc44-dde4-46a9-deff-8e133c80958e
         * title : Home
         * picture_type : 3
         * selfmedia_mselfmedia_path : ["https://i.ebayimg.com/images/g/1EMAAOSwBLlVd0r-/s-l225.jpg","https://i.ebayimg.com/images/g/D8EAAOSwqu9VAG5Y/s-l225.jpg","http://cdn.roma.ebay.com/assets/3bf4f33e-f55e-4f4f-9753-120203c37b8d486527.jpg"]
         * create_time : 2017-05-11 11:46
         * review_counts : 3
         * comment_counts : 0
         * url : http://www.ebay.com/rpp/home-and-garden-en#
         * user_name : 韩甜甜
         * status : 2
         * source : 0
         * del : 0
         */

        private String id;
        private String uuid;
        private String title;
        private String picture_type;
        private String create_time;
        private String review_counts;
        private String comment_counts;
        private String url;
        private String user_name;
        private String status;
        private String source;
        private String del;
        private List<String> selfmedia_mselfmedia_path;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPicture_type() {
            return picture_type;
        }

        public void setPicture_type(String picture_type) {
            this.picture_type = picture_type;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public String getReview_counts() {
            return review_counts;
        }

        public void setReview_counts(String review_counts) {
            this.review_counts = review_counts;
        }

        public String getComment_counts() {
            return comment_counts;
        }

        public void setComment_counts(String comment_counts) {
            this.comment_counts = comment_counts;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getDel() {
            return del;
        }

        public void setDel(String del) {
            this.del = del;
        }

        public List<String> getSelfmedia_mselfmedia_path() {
            return selfmedia_mselfmedia_path;
        }

        public void setSelfmedia_mselfmedia_path(List<String> selfmedia_mselfmedia_path) {
            this.selfmedia_mselfmedia_path = selfmedia_mselfmedia_path;
        }
    }
}
