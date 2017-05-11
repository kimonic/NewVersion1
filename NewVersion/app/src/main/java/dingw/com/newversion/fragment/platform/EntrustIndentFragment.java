package dingw.com.newversion.fragment.platform;

import android.content.Intent;
import android.view.View;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import dingw.com.newversion.adapter.plateform.EntrustIndentXLVAdapter;
import dingw.com.newversion.base.BaseBean;
import dingw.com.newversion.base.RefreshBaseFragment;
import dingw.com.newversion.bean.platform.EntrustIndentBean;

/**
 * Created by 12348 on 2017/5/11 0011.
 * 主页--平台--委托订单fragment
 */

public class EntrustIndentFragment extends RefreshBaseFragment {

    private List<BaseBean> list;
    private int type;

    @Override
    public BaseAdapter setAdapter() {
        return new EntrustIndentXLVAdapter(getActivity(),list);
    }

    @Override
    public void setItemClick(int position) {
//        Intent intent = new Intent(getActivity(), EntrustIndentDetailsActivity.class);
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
            EntrustIndentBean bean = new EntrustIndentBean();
            bean.setIndentnum("201603070000016436877971");
            bean.setTime("2017-04-05 12:05");
            bean.setName("彭龙");
            bean.setPhone("1846311237"+i);
            bean.setMoney("5元");
            bean.setTitle("想咨询个问题");

            list.add(bean);
        }
    }

    @Override
    public void initLoad() {
        showXlistview();
    }
}
