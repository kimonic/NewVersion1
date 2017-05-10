package dingw.com.newversion.fragment.work;

import android.view.View;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import dingw.com.newversion.adapter.work.PiBanXLVAdapter;
import dingw.com.newversion.base.BaseBean;
import dingw.com.newversion.base.RefreshBaseFragment;
import dingw.com.newversion.bean.work.PiBanBean;

/**
 * Created by 12348 on 2017/5/8 0008.
 */

public class PiBanFragment extends RefreshBaseFragment {
    private List<BaseBean> list;

    @Override
    public BaseAdapter setAdapter() {
        return new PiBanXLVAdapter(getActivity(),list);
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
            PiBanBean bean=new PiBanBean();
            bean.setTitle("更健康");
            bean.setStarTime("2017-04-05 12:05");
            bean.setName("刑事诉讼2号");
            bean.setYear("[2017]");
            bean.setPiBanTime("2017-04-05 12:05");
            bean.setLawyerName("赵林林,张子唐");
            bean.setParty("废话见面");
            list.add(bean);
        }
    }

    @Override
    public void initLoad() {
        showXlistview();
    }
}
