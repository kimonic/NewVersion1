package dingw.com.newversion.bean.work;

import dingw.com.newversion.base.BaseBean;

/**
 * Created by 12348 on 2017/4/10 0010.
 * 主页--工作--押金管理 bean
 */

public class Depositbean extends BaseBean{
    private String bianHao;
    private String fenPeiZonge;
    private String total;
    private String time;
    private String depositScale;
    private String depositNum;

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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDepositScale() {
        return depositScale;
    }

    public void setDepositScale(String depositScale) {
        this.depositScale = depositScale;
    }

    public String getDepositNum() {
        return depositNum;
    }

    public void setDepositNum(String depositNum) {
        this.depositNum = depositNum;
    }
}
