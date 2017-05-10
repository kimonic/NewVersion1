package dingw.com.newversion.fragment.wait;

import android.support.v7.view.menu.ShowableListMenu;
import android.view.View;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import dingw.com.newversion.adapter.wait.YiPiBanXLVAdapter;
import dingw.com.newversion.base.BaseBean;
import dingw.com.newversion.base.RefreshBaseFragment;
import dingw.com.newversion.bean.wait.YIPiBanBean;

/**
 * Created by 12348 on 2017/5/6 0006.
 * 待办--案件--诉讼案件--已批办
 *
 */

public class YiPiBanFragment extends RefreshBaseFragment {
    private List<BaseBean> list;

    @Override
    public BaseAdapter setAdapter() {
        return new YiPiBanXLVAdapter(getActivity(),list);
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
        list=new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            YIPiBanBean bean=new YIPiBanBean();
            bean.setTitle("来看看你了");
            bean.setYear("[2017]");
            bean.setTitle1("民事诉讼2号");
            bean.setParty("当  事  人");
            bean.setContent("哭死");
            bean.setTime("接案时间");
            bean.setExactTime("2016-09-20  00:00");
            list.add(bean);
        }
    }

    @Override
    public void initLoad() {
        showXlistview();
    }
}
