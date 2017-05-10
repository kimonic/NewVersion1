package dingw.com.newversion.fragment.work;

import android.view.View;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import dingw.com.newversion.adapter.work.LawsuitXLVAdapter;
import dingw.com.newversion.base.BaseBean;
import dingw.com.newversion.base.RefreshBaseFragment;
import dingw.com.newversion.bean.work.LawsuitBean;

/**
 * Created by 12348 on 2017/5/8 0008.
 * 主页--工作--诉讼案件
 */

public class LawsuitFragment extends RefreshBaseFragment {
    private List<BaseBean> list;


    @Override
    public BaseAdapter setAdapter() {
        return new LawsuitXLVAdapter(getActivity(),list);
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
            LawsuitBean bean=new LawsuitBean();
            bean.setTitle("尴尬了");
            bean.setTime("2017-04-05 12:05");
            bean.setName("刑事诉讼3号");
            bean.setYear("[2017]");
            bean.setInterpose("一审");
            bean.setState("状态-完成");
            bean.setType("刑事诉讼");
            bean.setParty("根据自己");
            list.add(bean);
        }
    }

    @Override
    public void initLoad() {
        showXlistview();
    }
}
