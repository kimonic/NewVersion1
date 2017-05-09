package dingw.com.newversion;

import java.util.List;

/**
 * Created by 12348 on 2017/5/9 0009.
 * 测试复杂gson解析
 */

public class FileBean {
    private String state;
    private List<Folder>  folder;
    private List<File>  file;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<Folder> getFolder() {
        return folder;
    }

    public void setFolder(List<Folder> folder) {
        this.folder = folder;
    }

    public List<File> getFile() {
        return file;
    }

    public void setFile(List<File> file) {
        this.file = file;
    }

    public static class Folder{
            private String folder_uuid;
            private String folder_field_uuid;
            private String folder_name;
            private String folder_inster_time;

        public String getFolder_uuid() {
            return folder_uuid;
        }

        public void setFolder_uuid(String folder_uuid) {
            this.folder_uuid = folder_uuid;
        }

        public String getFolder_field_uuid() {
            return folder_field_uuid;
        }

        public void setFolder_field_uuid(String folder_field_uuid) {
            this.folder_field_uuid = folder_field_uuid;
        }

        public String getFolder_name() {
            return folder_name;
        }

        public void setFolder_name(String folder_name) {
            this.folder_name = folder_name;
        }

        public String getFolder_inster_time() {
            return folder_inster_time;
        }

        public void setFolder_inster_time(String folder_inster_time) {
            this.folder_inster_time = folder_inster_time;
        }
    }

    public static class File{
        private String file_uuid;
        private String file_name;
        private String file_size;
        private String file_inster_time;

        public String getFile_uuid() {
            return file_uuid;
        }

        public void setFile_uuid(String file_uuid) {
            this.file_uuid = file_uuid;
        }

        public String getFile_name() {
            return file_name;
        }

        public void setFile_name(String file_name) {
            this.file_name = file_name;
        }

        public String getFile_size() {
            return file_size;
        }

        public void setFile_size(String file_size) {
            this.file_size = file_size;
        }

        public String getFile_inster_time() {
            return file_inster_time;
        }

        public void setFile_inster_time(String file_inster_time) {
            this.file_inster_time = file_inster_time;
        }
    }

}
