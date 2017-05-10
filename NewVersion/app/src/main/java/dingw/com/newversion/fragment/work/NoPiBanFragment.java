package dingw.com.newversion.fragment.work;

import android.view.View;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import dingw.com.newversion.adapter.work.NoPiBanXLVAdapter;
import dingw.com.newversion.base.BaseBean;
import dingw.com.newversion.base.RefreshBaseFragment;
import dingw.com.newversion.bean.work.NoPiBanBean;

/**
 * Created by 12348 on 2017/5/8 0008.
 * 主页--工作--我要批办--非诉讼批办--已批办
 */

public class NoPiBanFragment extends RefreshBaseFragment {

    private List<BaseBean> list;



    @Override
    public BaseAdapter setAdapter() {
        return new NoPiBanXLVAdapter(getActivity(),list);
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
            NoPiBanBean bean=new NoPiBanBean();
            bean.setTitle("我");
            bean.setType("出具法律意见");
            bean.setUnit("你");
            bean.setLawyer("张子唐,张瑞月");
            bean.setTime("2017-04-05 12:05");
            list.add(bean);
        }
    }

    @Override
    public void initLoad() {
            showXlistview();
    }
}
