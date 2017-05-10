package dingw.com.newversion.fragment.wait;

import android.view.View;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import dingw.com.newversion.activity.wait.NewLawExpressActivity;
import dingw.com.newversion.adapter.wait.NewLawExpressXLVAdapter;
import dingw.com.newversion.base.BaseBean;
import dingw.com.newversion.base.RefreshBaseFragment;
import dingw.com.newversion.bean.wait.NewLawBean;

/**
 * Created by 12348 on 2017/5/8 0008.
 * 主页--待办--新法速递--fragment
 */

public class NewLawExpressFragment extends RefreshBaseFragment {
    private List<BaseBean> list;
    @Override
    public BaseAdapter setAdapter() {
        return new NewLawExpressXLVAdapter(getActivity(),list);
    }

    @Override
    public void setItemClick(int position) {
        openActivity(NewLawExpressActivity.class);
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
        list=new ArrayList<>(30);
        for (int i = 0; i < 30; i++) {
            NewLawBean recycData=new NewLawBean();
            recycData.setTitle("存款保险条例(国务院令第660号)");
            recycData.setType("国务院");
            recycData.setTime("2016-09-13");
            list.add(recycData);
        }
    }

    @Override
    public void initLoad() {
            showXlistview();
    }
}
