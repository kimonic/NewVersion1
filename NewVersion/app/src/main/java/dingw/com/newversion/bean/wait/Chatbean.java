package dingw.com.newversion.bean.wait;

/**
 * Created by 12348 on 2017/4/17 0017.
 * 聊天详情bean
 */

public class Chatbean {
    private String name;
    private String title;
    private String time;
    private String date;
    private int  flag;
    private int  resId;
    private int  xuhao;//和某个人聊天信息的插入序号



    /**相册图片路径*/
    private String photoPath;
    public int getXuhao() {
        return xuhao;
    }

    public void setXuhao(int xuhao) {
        this.xuhao = xuhao;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    @Override
    public String toString() {

        return getName()+"---"+getTitle()+"---"+getDate()+"---"+getTime()+"---"+getFlag()+"---"+getResId()+"-----"+getXuhao();
    }
}
