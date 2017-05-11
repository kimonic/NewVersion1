package dingw.com.newversion.fragment.platform;

import android.view.View;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import dingw.com.newversion.adapter.plateform.ContractModelXLVAdapter;
import dingw.com.newversion.base.BaseBean;
import dingw.com.newversion.base.RefreshBaseFragment;
import dingw.com.newversion.bean.platform.ContractModelBean;

/**
 * Created by 12348 on 2017/5/11 0011.
 * 主页--平台--合同范本fragment
 */

public class ContractModelFragment extends RefreshBaseFragment {

    private List<BaseBean> list;

    @Override
    public BaseAdapter setAdapter() {
        return new ContractModelXLVAdapter(getActivity(),list);
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
        list = new ArrayList<>();//数据源
        for (int i = 0; i < 30; i++) {
            ContractModelBean bean = new ContractModelBean();
            bean.setTitle("资产评估业务约定书");
            bean.setTime("2017-04-05 12:05");
            bean.setAuthor("许雁峰");
            bean.setLawyerOffice("山东泰祥律师事务所");
            bean.setType("聘请中介类合同");
            list.add(bean);
        }
    }

    @Override
    public void initLoad() {
        showXlistview();
    }
}
