package dingw.com.newversion.fragment.wait;

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
import dingw.com.newversion.adapter.wait.ChatXLVAdapter;
import dingw.com.newversion.base.BaseFragment;
import dingw.com.newversion.bean.wait.Chatbean;
import dingw.com.newversion.gif.SingleGif;
import dingw.com.newversion.utils.MyDbHelper;
import dingw.com.newversion.widget.XListView;

/**
 * Created by 12348 on 2017/5/4 0004.
 * 主页--待办--email点击--消息item点击--details  fragment
 */

public class ChatFragment extends BaseFragment implements XListView.IXListViewListener {
    @BindView(R.id.xlv_fragcommon)
    XListView xlvFragcommon;
    @BindView(R.id.pgb_fragcommon)
    ProgressBar pgbFragcommon;
    Unbinder unbinder;

    private ChatXLVAdapter adapter;
    private List<Chatbean> list;
    private String TAG="fragchat";

    public XListView getMyListview() {
        return xlvFragcommon;
    }

    public ChatXLVAdapter getAdapter() {
        return adapter;
    }

    public List<Chatbean> getList() {
        return list;
    }
    /**存储滚动结束后显示的item的position*/
    private List<Integer> positionList;


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
        list=new ArrayList<Chatbean>();
        MyDbHelper helper1=new MyDbHelper(getActivity());
        helper1.open();
        //从数据库加载聊天信息
        list=helper1.getChatContent("zhitong");
//        list.add(0,new Chatbean());
//        list.add(1,new Chatbean());

        helper1.close();
    }

    @Override
    public void initView() {
        positionList=new ArrayList<Integer>(10);
        xlvFragcommon.setPullRefreshEnable(true);//下拉刷新
        xlvFragcommon.setPullLoadEnable(true);//上拉加载
        xlvFragcommon.setAutoLoadEnable(false);//底部自动加载
        xlvFragcommon.setRefreshTime(getTime());//加载时间
        adapter=new ChatXLVAdapter(list,getActivity());//适配器

        xlvFragcommon.setAdapter(adapter);

        xlvFragcommon.setSelection(list.size()-1);




        //-----------------------------------------------------
        pgbFragcommon.setVisibility(View.GONE);
        xlvFragcommon.setVisibility(View.VISIBLE);
    }

    @Override
    public void initListener() {
        xlvFragcommon.setXListViewListener(this);//监听器
        xlvFragcommon.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent=new Intent(getActivity(), InterflowAreaDetailsActivity.class);
//                startActivity(intent);
            }
        });
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
    /**获取当前系统时间*/
    private String getTime() {
        return new SimpleDateFormat("MM-dd HH:mm", Locale.CHINA).format(new Date());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        adapter.setUpClose(false);
        adapter=null;
        SingleGif.getInstance(getActivity()).clearAll();
    }


}
