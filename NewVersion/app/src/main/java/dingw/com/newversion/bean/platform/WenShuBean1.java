package dingw.com.newversion.bean.platform;

import java.util.List;

import dingw.com.newversion.base.BaseBean;

/**
 * Created by 12348 on 2017/5/17 0017.
 * 常用文书bean
 */

public class WenShuBean1 {

    /**
     * state : 200
     * document_list : [{"uuid":"18AC523D-8C4A-8097-7B89-2BBA3D09C92C","file_type":"doc","number":"01","name":"案件批办单"},{"uuid":"AF222D9A-56FA-635E-36AF-93EBC4B91609","file_type":"doc","number":"02","name":"刑事案件委托合同"},{"uuid":"BD11C931-F379-C839-4B32-B6D3FB741D7D","file_type":"doc","number":"03","name":"授权委托书"},{"uuid":"A6311BC2-16DE-FE2D-7139-0EE31831D687","file_type":"doc","number":"04","name":"刑事案件委托人须知"},{"uuid":"5CB9650A-A648-BC68-13C3-9244A6EDBD0B","file_type":"doc","number":"05","name":"律师接待委托人谈话记录"},{"uuid":"DD0FD97B-8B80-296E-E65F-1CE95389A94E","file_type":"doc","number":"06","name":"会见当事人、犯罪嫌疑人笔录"},{"uuid":"DA1DC16A-95FF-5C4F-469D-1891568B9AB9","file_type":"doc","number":"07","name":"阅卷笔录格式"},{"uuid":"ABF874F7-DCC3-6A66-60B9-4847B6B95331","file_type":"doc","number":"08","name":"调查笔录"},{"uuid":"A922DA92-369A-FE16-D952-2627A14E507A","file_type":"doc","number":"09","name":"出庭电话通知单"},{"uuid":"CC0B5A9E-6551-8A94-AD0E-AE78BE2DF56B","file_type":"doc","number":"10","name":"律师阅卷笔录范本(刑事)"},{"uuid":"E600EB87-7635-1774-D081-0AF31D221F91","file_type":"doc","number":"11","name":"审判阶段辩护词"},{"uuid":"76D956CA-CE0D-7F11-A82D-C5D42CBB88C9","file_type":"doc","number":"12","name":"刑事案件庭审笔录"},{"uuid":"AED1D830-0F43-0138-AAB6-ADF7C2095532","file_type":"doc","number":"13","name":"刑事上诉状"},{"uuid":"5DC6D6C1-094C-0141-234B-80AAC0345611","file_type":"doc","number":"14","name":"备考表"}]
     */

    private String state;
    private List<DocumentListBean> document_list;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<DocumentListBean> getDocument_list() {
        return document_list;
    }

    public void setDocument_list(List<DocumentListBean> document_list) {
        this.document_list = document_list;
    }

    public static class DocumentListBean extends BaseBean{
        /**
         * uuid : 18AC523D-8C4A-8097-7B89-2BBA3D09C92C
         * file_type : doc
         * number : 01
         * name : 案件批办单
         */

        private String uuid;
        private String file_type;
        private String number;
        private String name;

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }

        public String getFile_type() {
            return file_type;
        }

        public void setFile_type(String file_type) {
            this.file_type = file_type;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
