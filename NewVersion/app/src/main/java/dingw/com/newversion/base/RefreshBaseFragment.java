package dingw.com.newversion.base;

import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;

import butterknife.BindView;
import dingw.com.newversion.R;
import dingw.com.newversion.widget.XListView;

/**
 * Created by 12348 on 2017/5/6 0006.
 * 使用布局 R.layout.frag_common进行刷新的fragment
 */

public abstract class RefreshBaseFragment extends BaseFragment implements XListView.IXListViewListener {
    @BindView(R.id.xlv_fragcommon)
    XListView xlvFragcommon;
    @BindView(R.id.pgb_fragcommon)
    ProgressBar pgbFragcommon;

    public XListView getXlvFragcommon() {
        return xlvFragcommon;
    }

    public ProgressBar getPgbFragcommon() {
        return pgbFragcommon;
    }

    @Override
    public int setResid() {
        return R.layout.frag_common;
    }

    @Override
    public void initView() {
        xlvFragcommon.setPullRefreshEnable(true);//下拉刷新
        xlvFragcommon.setPullLoadEnable(true);//上拉加载
        xlvFragcommon.setAutoLoadEnable(true);//底部自动加载
        xlvFragcommon.setXListViewListener(this);//监听器
        xlvFragcommon.setRefreshTime(getTime());//加载时间
        xlvFragcommon.setAdapter(setAdapter());//设置适配器


        //-----------------------------------------------------
        showProgressbar();
    }

    /**     * 设置适配器     */
    public abstract BaseAdapter setAdapter();
    /***设置xlistview的点击事件*/
    public abstract void setItemClick();
    /**隐藏progressbar,显示xlistview*/
    public void showXlistview(){
        pgbFragcommon.setVisibility(View.GONE);
        xlvFragcommon.setVisibility(View.VISIBLE);
    }

    /**显示progressbar,隐藏xlistview*/
    public void showProgressbar(){
        pgbFragcommon.setVisibility(View.VISIBLE);
        xlvFragcommon.setVisibility(View.GONE);
    }
    /**设置收下拉刷新*/
    public abstract void newRefresh();
    /**设置上拉加载*/
    public abstract void newLoadMore();


    @Override
    public void initListener() {
        xlvFragcommon.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                setItemClick();
            }
        });
    }


    @Override
    public void onRefresh() {
        newRefresh();
        onLoad();
    }

    @Override
    public void onLoadMore() {
        newLoadMore();
        onLoad();
    }
    /**xlistview加载完成后取消加载提示*/
    public void onLoad() {
        xlvFragcommon.stopRefresh();
        xlvFragcommon.stopLoadMore();
        xlvFragcommon.setRefreshTime(getTime());
        showXlistview();

    }
}
