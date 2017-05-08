package dingw.com.newversion.bean.work;

import dingw.com.newversion.base.BaseBean;

/**
 * Created by 12348 on 2017/3/22 0022.
 */

public class GridViewBean extends BaseBean{
    private int name;
    private int res;

    public GridViewBean(int name, int res) {
        this.name = name;
        this.res = res;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }
}
