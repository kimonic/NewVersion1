package dingw.com.newversion.fragment.wait;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ProgressBar;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dingw.com.newversion.R;
import dingw.com.newversion.activity.CommonActivity;
import dingw.com.newversion.adapter.wait.NewsXLVAdapter;
import dingw.com.newversion.base.BaseFragment;
import dingw.com.newversion.bean.wait.NewsBean;
import dingw.com.newversion.widget.XListView;

/**
 * Created by 12348 on 2017/5/4 0004.
 * 主页--待办--email图标点击---消息fragment
 */

public class NewsFragment extends BaseFragment implements XListView.IXListViewListener {
    @BindView(R.id.xlv_fragcommon)
    XListView xlvFragcommon;
    @BindView(R.id.pgb_fragcommon)
    ProgressBar pgbFragcommon;
    Unbinder unbinder;

    private NewsXLVAdapter adapter;
    private List<Object> list;

    private CommonActivity.CommonActListener listener;



    @Override
    public int setResid() {
        return R.layout.frag_common;
    }

    @Override
    public void initContentView() {
        super.initContentView();
        if (getView()!=null){
            unbinder = ButterKnife.bind(this, getView());
        }
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void initData() {
        list=new ArrayList<>();//数据源
        for (int i = 0; i < 30; i++) {
            NewsBean bean=new NewsBean();
            bean.setName("亦筝笙");
            bean.setState("[离线]");
            bean.setResId(R.drawable.test2);
            list.add(bean);
        }
    }

    @Override
    public void initView() {
        listener =new CommonActivity.CommonActListener() {
            @Override
            public void clickEvent() {

            }
        };
        ((CommonActivity)getActivity()).setListener1(listener);
        xlvFragcommon.setPullRefreshEnable(true);//下拉刷新
        xlvFragcommon.setPullLoadEnable(true);//上拉加载
        xlvFragcommon.setAutoLoadEnable(true);//底部自动加载
        xlvFragcommon.setXListViewListener(this);//监听器
        xlvFragcommon.setRefreshTime(getTime());//加载时间
        adapter=new NewsXLVAdapter(getActivity(),list);//适配器
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
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
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

    /**获取当前系统时间*/
    private String getTime() {
        return new SimpleDateFormat("MM-dd HH:mm", Locale.CHINA).format(new Date());
    }
}
