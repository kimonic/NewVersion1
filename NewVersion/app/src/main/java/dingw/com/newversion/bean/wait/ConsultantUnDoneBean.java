package dingw.com.newversion.bean.wait;

import dingw.com.newversion.base.BaseBean;

/**
 * Created by 12348 on 2017/4/8 0008.
 *
 * 首页--待办--顾问--未完成工单--bean
 */

public class ConsultantUnDoneBean extends BaseBean{
    private String gongDanTitle;
    private String consulantUnit;
    private String gongDanType;
    private String createTime;

    public String getGongDanTitle() {
        return gongDanTitle;
    }

    public void setGongDanTitle(String gongDanTitle) {
        this.gongDanTitle = gongDanTitle;
    }

    public String getConsulantUnit() {
        return consulantUnit;
    }

    public void setConsulantUnit(String consulantUnit) {
        this.consulantUnit = consulantUnit;
    }

    public String getGongDanType() {
        return gongDanType;
    }

    public void setGongDanType(String gongDanType) {
        this.gongDanType = gongDanType;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
