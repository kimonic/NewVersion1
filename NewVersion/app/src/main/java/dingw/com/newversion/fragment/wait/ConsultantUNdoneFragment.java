package dingw.com.newversion.fragment.wait;

import android.view.View;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import dingw.com.newversion.adapter.wait.ConsultantUnDoneXLVAdapter;
import dingw.com.newversion.base.BaseBean;
import dingw.com.newversion.base.RefreshBaseFragment;
import dingw.com.newversion.bean.wait.ConsultantUnDoneBean;

/**
 * Created by 12348 on 2017/5/8 0008.
 * 首页--待办--顾问---未完成工单
 */

public class ConsultantUNdoneFragment extends RefreshBaseFragment {
    private List<BaseBean> list;


    @Override
    public BaseAdapter setAdapter() {
        return new ConsultantUnDoneXLVAdapter(getActivity(), list);
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
        list = new ArrayList<>(30);
        for (int i = 0; i < 30; i++) {
            ConsultantUnDoneBean recycData = new ConsultantUnDoneBean();
            recycData.setGongDanTitle("3123");
            recycData.setConsulantUnit("山东达成律所");
            recycData.setGongDanType("3123");
            recycData.setCreateTime("2016-09-13 17:15");
            list.add(recycData);
        }
    }

    @Override
    public void initLoad() {
        showXlistview();
    }
}
