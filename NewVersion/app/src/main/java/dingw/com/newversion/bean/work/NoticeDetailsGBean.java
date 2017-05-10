package dingw.com.newversion.bean.work;

import java.util.List;

/**
 * Created by 12348 on 2017/5/10 0010.
 */

public class NoticeDetailsGBean {


    /**
     * state : 200
     * officeoa_details : {"title":"根据韩国","content":"<p>会根据韩国看， 很关键<\/p>","create_time":"2017-05-10 10:00","num":"1","lawyer_name":"张子唐"}
     * file : []
     */

    private int state;
    private OfficeoaDetailsBean officeoa_details;
    private List<?> file;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public OfficeoaDetailsBean getOfficeoa_details() {
        return officeoa_details;
    }

    public void setOfficeoa_details(OfficeoaDetailsBean officeoa_details) {
        this.officeoa_details = officeoa_details;
    }

    public List<?> getFile() {
        return file;
    }

    public void setFile(List<?> file) {
        this.file = file;
    }

    public static class OfficeoaDetailsBean {
        /**
         * title : 根据韩国
         * content : <p>会根据韩国看， 很关键</p>
         * create_time : 2017-05-10 10:00
         * num : 1
         * lawyer_name : 张子唐
         */

        private String title;
        private String content;
        private String create_time;
        private String num;
        private String lawyer_name;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public String getNum() {
            return num;
        }

        public void setNum(String num) {
            this.num = num;
        }

        public String getLawyer_name() {
            return lawyer_name;
        }

        public void setLawyer_name(String lawyer_name) {
            this.lawyer_name = lawyer_name;
        }
    }
}
