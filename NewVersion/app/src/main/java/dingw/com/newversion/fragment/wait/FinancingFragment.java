package dingw.com.newversion.fragment.wait;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dingw.com.newversion.R;
import dingw.com.newversion.activity.wait.ChatActivity;
import dingw.com.newversion.adapter.wait.FinancingXLVAdapter;
import dingw.com.newversion.adapter.wait.NewsXLVAdapter;
import dingw.com.newversion.base.BaseBean;
import dingw.com.newversion.base.BaseFragment;
import dingw.com.newversion.bean.wait.FinancingBean;
import dingw.com.newversion.widget.XListView;

/**
 * Created by 12348 on 2017/5/6 0006.
 * 加载fragment集合
 */

public class FinancingFragment extends BaseFragment implements XListView.IXListViewListener {
    @BindView(R.id.xlv_fragcommon)
    XListView xlvFragcommon;
    @BindView(R.id.pgb_fragcommon)
    ProgressBar pgbFragcommon;
    private List<BaseBean> list;


    @Override
    public int setResid() {
        return R.layout.frag_common;
    }

    @Override
    public void initContentView() {
        super.initContentView();
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void initData() {
        list=new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            FinancingBean financingBean=new FinancingBean("分配金额","1231元","发票编号","100","业务来源",
                    "顾问单位|测试顾问","录入时间","2016-08-29  09:54");
            list.add(financingBean);
        }
    }

    @Override
    public void initView() {

        xlvFragcommon.setPullRefreshEnable(true);//下拉刷新
        xlvFragcommon.setPullLoadEnable(true);//上拉加载
        xlvFragcommon.setAutoLoadEnable(true);//底部自动加载
        xlvFragcommon.setXListViewListener(this);//监听器
        xlvFragcommon.setRefreshTime(getTime());//加载时间
        FinancingXLVAdapter adapter=new FinancingXLVAdapter(getActivity(),list);
        xlvFragcommon.setAdapter(adapter);
        xlvFragcommon.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent=new Intent(getActivity(), ChatActivity.class);
//                startActivity(intent);
            }
        });


        //-----------------------------------------------------
        pgbFragcommon.setVisibility(View.GONE);
        xlvFragcommon.setVisibility(View.VISIBLE);

    }

    @Override
    public void initListener() {

    }

    @Override
    public void initLoad() {

    }
    @Override
    public void onRefresh() {
        onLoad();
    }

    @Override
    public void onLoadMore() {
        onLoad();
    }
    /**xlistview加载完成后取消加载提示*/
    private void onLoad() {
        xlvFragcommon.stopRefresh();
        xlvFragcommon.stopLoadMore();
        xlvFragcommon.setRefreshTime(getTime());
    }
}
