package dingw.com.newversion.fragment.platform;

import android.content.Intent;
import android.view.View;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import dingw.com.newversion.adapter.plateform.NetizenEntrustXLVAdapter;
import dingw.com.newversion.base.BaseBean;
import dingw.com.newversion.base.RefreshBaseFragment;
import dingw.com.newversion.bean.platform.NetizenEntrustBean;

/**
 * Created by 12348 on 2017/5/11 0011.
 * 平台--网民委托--fragment
 */

public class NetizenEntrustFragment extends RefreshBaseFragment {

    private List<BaseBean> list;
    private int type;

    @Override
    public BaseAdapter setAdapter() {
        return new NetizenEntrustXLVAdapter(getActivity(),list);
    }

    @Override
    public void setItemClick(int position) {
//        Intent intent = new Intent(getActivity(), NetizenEntrustDetailsActivity.class);
//        intent.putExtra("type",type);
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
            type=getArguments().getInt("type",0);
        }


        list = new ArrayList<>();//数据源
        for (int i = 0; i < 30; i++) {
            NetizenEntrustBean bean = new NetizenEntrustBean();
            bean.setProceeding("预约见面");
            bean.setTime("2017-04-05 12:05");
            bean.setName("彭龙");
            bean.setPhone("1846311237"+i);
            bean.setDetails("关于买彩票中奖被诈骗.骗了我20万");
            list.add(bean);
        }
    }

    @Override
    public void initLoad() {
        showXlistview();
    }
}
