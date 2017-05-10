package dingw.com.newversion.fragment.wait;

import android.view.View;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import dingw.com.newversion.adapter.wait.FeiYiPiBanXLVAdapter;
import dingw.com.newversion.base.BaseBean;
import dingw.com.newversion.base.RefreshBaseFragment;
import dingw.com.newversion.bean.wait.YIPiBanBean;

/**
 * Created by 12348 on 2017/5/6 0006.
 *
 */

public class FeiYIPiBanFragment extends RefreshBaseFragment {
    private List<BaseBean> list;

    @Override
    public BaseAdapter setAdapter() {

        return new FeiYiPiBanXLVAdapter(getActivity(),list);
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
            bean.setTitle("你自己");
            bean.setYear("项目类型");
            bean.setTitle1("破产清算");
            bean.setParty("委托单位");
            bean.setContent("");
            bean.setTime("提交时间");
            bean.setExactTime("2016-09-20  00:00");
            list.add(bean);
        }
    }

    @Override
    public void initLoad() {
        showXlistview();
    }
}
