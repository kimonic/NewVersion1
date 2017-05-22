package dingw.com.newversion.bean.work;

import java.util.List;

import dingw.com.newversion.base.BaseBean;

/**
 * Created by 12348 on 2017/5/22 0022.
 */

public class FileRepositoryGBean {

    /**
     * state : 200
     * list : [{"uuid":"ed6ff4d5-475f-3b3e-4ae8-0f94ba62d6c8","name":"123456222222","super_path":"0","uploader_uuid":"1","file_type":null,"size":"","is_dir":"1","level":"311","create_time":"2017-05-05 11:14"},{"uuid":"e70ccf69-abe2-a09f-f890-e77badcfde72","name":"2.jpg","super_path":"0","uploader_uuid":"1","file_type":"jpg","size":"4.45KB","is_dir":"0","level":"111","create_time":"2017-05-02 11:45"},{"uuid":"80f07cac-c1eb-6d38-641c-d7aff03ac653","name":".jpg","super_path":"0","uploader_uuid":"62","file_type":"jpg","size":"11.75KB","is_dir":"0","level":"111","create_time":"2017-04-28 14:53"},{"uuid":"fa55ae3e-7caf-7824-0fe2-ab68757177eb","name":"文件123","super_path":"0","uploader_uuid":"62","file_type":null,"size":"","is_dir":"1","level":"311","create_time":"2017-04-28 14:52"},{"uuid":"f35cf5b0-4d18-801a-f915-ab77b549ab67","name":".jpg","super_path":"0","uploader_uuid":"62","file_type":"jpg","size":"11.75KB","is_dir":"0","level":"111","create_time":"2017-04-28 14:52"},{"uuid":"12251a93-faf0-69bc-a913-f2ea96c2c1d6","name":"a093e615f337cd34.jpg","super_path":"0","uploader_uuid":"62","file_type":"jpg","size":"5.75KB","is_dir":"0","level":"111","create_time":"2017-04-28 14:51"},{"uuid":"c8034014-ae43-2206-c041-376af5dba20e","name":"把思考才能","super_path":"0","uploader_uuid":"1","file_type":null,"size":"","is_dir":"1","level":"211","create_time":"2017-04-28 10:24"},{"uuid":"92bd7ba8-4cf2-bc06-94d4-2e272d858681","name":"asc.png","super_path":"0","uploader_uuid":"1","file_type":"png","size":"60.4KB","is_dir":"0","level":"111","create_time":"2017-04-28 09:20"},{"uuid":"ba5480f7-e732-6417-cafb-a06892e177f6","name":"a093e615f337cd34.jpg","super_path":"0","uploader_uuid":"1","file_type":"jpg","size":"5.75KB","is_dir":"0","level":"111","create_time":"2017-04-28 09:04"},{"uuid":"8322cd0f-cd2c-9b1c-986d-4b5596e01551","name":"律所建议.docx","super_path":"0","uploader_uuid":"1","file_type":"docx","size":"13.26KB","is_dir":"0","level":"111","create_time":"2017-04-27 22:13"},{"uuid":"8f84c276-3d81-1410-1b2c-a604ab9a54a1","name":"login_bg3.jpg","super_path":"0","uploader_uuid":"1","file_type":"jpg","size":"673.17KB","is_dir":"0","level":"111","create_time":"2017-04-27 22:08"},{"uuid":"0debdf9b-6a66-e19a-90a6-21298ed72013","name":"非等我v","super_path":"0","uploader_uuid":"1","file_type":null,"size":"","is_dir":"1","level":"111","create_time":"2017-04-27 16:02"},{"uuid":"7dacc7e8-38a1-024b-2899-4df36972dd5c","name":"全方位为分v","super_path":"0","uploader_uuid":"1","file_type":null,"size":"","is_dir":"1","level":"111","create_time":"2017-04-27 16:01"},{"uuid":"48e6ba28-b57e-4f7e-d50d-cbaa8b03e740","name":"宣传","super_path":"0","uploader_uuid":"62","file_type":null,"size":"","is_dir":"1","level":"111","create_time":"2017-04-27 11:01"},{"uuid":"347d9df7-d734-8ba7-1bc0-ace14000ab04","name":"2.jpg","super_path":"0","uploader_uuid":"62","file_type":"jpg","size":"4.45KB","is_dir":"0","level":"111","create_time":"2017-04-27 11:00"},{"uuid":"af0b09a6-6922-2458-c2c6-7db145c1a47c","name":"信息总结 - 副本.docx","super_path":"0","uploader_uuid":"1","file_type":"docx","size":"154.84KB","is_dir":"0","level":"111","create_time":"2017-04-27 09:15"},{"uuid":"e32b58f7-39ae-cf13-47bd-5964081703f7","name":"额分v发��","super_path":"0","uploader_uuid":"1","file_type":null,"size":"","is_dir":"1","level":"111","create_time":"2017-04-26 14:58"},{"uuid":"7e5da81c-1e2b-b0fe-c9a7-bbfc6f04c292","name":"新建文本文档.txt","super_path":"0","uploader_uuid":"1","file_type":"txt","size":"283B","is_dir":"0","level":"111","create_time":"2017-04-26 14:57"},{"uuid":"f96fd83c-dfd7-cad5-0733-7f313c46638f","name":"钛合金","super_path":"0","uploader_uuid":"1","file_type":null,"size":"","is_dir":"1","level":"111","create_time":"2017-04-26 11:34"},{"uuid":"aa7713f1-7fed-28d6-6241-30eebedb6fbf","name":"安区湖","super_path":"0","uploader_uuid":"1","file_type":null,"size":"","is_dir":"1","level":"322","create_time":"2017-04-25 20:32"}]
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

    public static class ListBean extends BaseBean{
        /**
         * uuid : ed6ff4d5-475f-3b3e-4ae8-0f94ba62d6c8
         * name : 123456222222
         * super_path : 0
         * uploader_uuid : 1
         * file_type : null
         * size : 
         * is_dir : 1
         * level : 311
         * create_time : 2017-05-05 11:14
         */

        private String uuid;
        private String name;
        private String super_path;
        private String uploader_uuid;
        private Object file_type;
        private String size;
        private String is_dir;
        private String level;
        private String create_time;

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSuper_path() {
            return super_path;
        }

        public void setSuper_path(String super_path) {
            this.super_path = super_path;
        }

        public String getUploader_uuid() {
            return uploader_uuid;
        }

        public void setUploader_uuid(String uploader_uuid) {
            this.uploader_uuid = uploader_uuid;
        }

        public Object getFile_type() {
            return file_type;
        }

        public void setFile_type(Object file_type) {
            this.file_type = file_type;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public String getIs_dir() {
            return is_dir;
        }

        public void setIs_dir(String is_dir) {
            this.is_dir = is_dir;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }
    }
}
