package dingw.com.newversion.fragment.work;

import android.view.View;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import dingw.com.newversion.adapter.work.OtherCostXLVAdapter;
import dingw.com.newversion.base.BaseBean;
import dingw.com.newversion.base.RefreshBaseFragment;
import dingw.com.newversion.bean.work.OtherCostBean;

/**
 * Created by 12348 on 2017/5/9 0009.
 * 主页--工作--其他费用fragment
 */

public class OtherCostFragmnet extends RefreshBaseFragment {
    private List<BaseBean> list;


    @Override
    public BaseAdapter setAdapter() {
        return new OtherCostXLVAdapter(getActivity(),list);
    }

    @Override
    public void setItemClick(int position) {

    }

    @Override
    public void newRefresh() {

    }

    @Override
    public void newLoadMore() {

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void initData() {
        list=new ArrayList<>();//数据源
        for (int i = 0; i < 30; i++) {
            OtherCostBean bean=new OtherCostBean();
            bean.setTitle("加1222元");
            bean.setTime("2017-04-05 12:05");
            bean.setBalance("已结算");
            bean.setCause("清晨，太阳还在沉睡，我便早已收拾停当，提着一只竹篓，扛着一根自制的鱼竿，" +
                    "和一群嘎小子去荷塘钓鱼。头顶一片荷叶，嘴噙着一瓣馨香的莲子，在荷塘岸边，或坐或站，" +
                    "光着脚板，踏着岸边潮润的大地，以少年难得的耐心和毅力与荷塘里的鱼儿周旋。");
            list.add(bean);
        }
    }

    @Override
    public void initLoad() {
        showXlistview();
    }
}
