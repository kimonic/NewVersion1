package dingw.com.newversion.bean.work;

import java.util.List;

/**
 * Created by 12348 on 2017/5/22 0022.
 */

public class FileItemBean {

    /**
     * state : 200
     * uuid : 760521b3-73dd-3381-bc01-087fb562c7a3
     * name : 测试文件
     * level : 031
     * viewer : [{"viewer_uuid":"asddddd,asdasds","viewer_type":"2"}]
     */

    private String state;
    private String uuid;
    private String name;
    private String level;
    private List<ViewerBean> viewer;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public List<ViewerBean> getViewer() {
        return viewer;
    }

    public void setViewer(List<ViewerBean> viewer) {
        this.viewer = viewer;
    }

    public static class ViewerBean {
        /**
         * viewer_uuid : asddddd,asdasds
         * viewer_type : 2
         */

        private String viewer_uuid;
        private String viewer_type;

        public String getViewer_uuid() {
            return viewer_uuid;
        }

        public void setViewer_uuid(String viewer_uuid) {
            this.viewer_uuid = viewer_uuid;
        }

        public String getViewer_type() {
            return viewer_type;
        }

        public void setViewer_type(String viewer_type) {
            this.viewer_type = viewer_type;
        }
    }
}
