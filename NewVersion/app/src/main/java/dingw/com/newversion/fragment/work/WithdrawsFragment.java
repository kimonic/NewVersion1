package dingw.com.newversion.fragment.work;

import android.content.Intent;
import android.content.res.TypedArray;
import android.view.View;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import dingw.com.newversion.adapter.work.WithdrawsXLVAdapter;
import dingw.com.newversion.base.BaseBean;
import dingw.com.newversion.base.RefreshBaseFragment;
import dingw.com.newversion.bean.work.WithdrawsBean;

/**
 * Created by 12348 on 2017/5/9 0009.
 * 主页--工作--提现管理--
 */

public class WithdrawsFragment extends RefreshBaseFragment {

    private List<BaseBean> list;
    private int type;

    @Override
    public BaseAdapter setAdapter() {
        WithdrawsXLVAdapter adapter=new WithdrawsXLVAdapter(getActivity(),list);
        adapter.setColType(type);
        return adapter;
    }

    @Override
    public void setItemClick(int position) {
//        Intent intent=new Intent(getActivity(), WithdrawsDetailsActivity.class);
//        startActivity(intent);
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
        if (getArguments()!=null){
            type=getArguments().getInt("type",1);
        }
        list=new ArrayList<>();//数据源
        for (int i = 0; i < 30; i++) {
            WithdrawsBean bean=new WithdrawsBean();
            bean.setBianHao("编号  201609200000000958845407");
            bean.setFenPeiZonge("100元");
            bean.setTotal("91元");
            bean.setSubmitTime("2016-09-20 10:12");
            list.add(bean);
        }
    }

    @Override
    public void initLoad() {
        showXlistview();
    }
}
