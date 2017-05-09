package dingw.com.newversion.bean.work;

import dingw.com.newversion.base.BaseBean;

/**
 * Created by 12348 on 2017/4/10 0010.
 * 主页--工作--提现管理 bean
 */

public class WithdrawsBean extends BaseBean{
    private String bianHao;
    private String fenPeiZonge;
    private String total;
    private String submitTime;

    public String getBianHao() {
        return bianHao;
    }

    public void setBianHao(String bianHao) {
        this.bianHao = bianHao;
    }

    public String getFenPeiZonge() {
        return fenPeiZonge;
    }

    public void setFenPeiZonge(String fenPeiZonge) {
        this.fenPeiZonge = fenPeiZonge;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(String submitTime) {
        this.submitTime = submitTime;
    }
}
