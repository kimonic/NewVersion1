package dingw.com.newversion.fragment.work;

import android.view.View;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import dingw.com.newversion.adapter.work.DepositXLVAdapter;
import dingw.com.newversion.base.BaseBean;
import dingw.com.newversion.base.RefreshBaseFragment;
import dingw.com.newversion.bean.work.Depositbean;

/**
 * Created by 12348 on 2017/5/9 0009.
 * 主页--工作--押金管理--
 */

public class DepositFragment extends RefreshBaseFragment {
    private DepositXLVAdapter adapter;
    private List<BaseBean> list;
    private int type;

    @Override
    public BaseAdapter setAdapter() {
        adapter=new DepositXLVAdapter(getActivity(),list);
        adapter.setColType(type);
        return adapter;
    }

    @Override
    public void setItemClick() {

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
            Depositbean bean=new Depositbean();
            bean.setBianHao("编号  201609200000000958845407");
            bean.setFenPeiZonge("100");
            bean.setDepositScale("1");
            bean.setDepositNum("0.01");
            bean.setTotal("91元");
            bean.setTime("2016-09-20 10:12");
            list.add(bean);
        }
    }

    @Override
    public void initLoad() {
        showXlistview();
    }
}
