package dingw.com.newversion.fragment.wait;

import android.content.DialogInterface;
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
import dingw.com.newversion.adapter.wait.EmailXLVAdapter;
import dingw.com.newversion.base.BaseBean;
import dingw.com.newversion.base.BaseFragment;
import dingw.com.newversion.bean.wait.EMailBean;
import dingw.com.newversion.utils.DialogUtils;
import dingw.com.newversion.widget.XListView;

/**
 * Created by 12348 on 2017/4/15 0015.
 * 主页--待办--email图标点击---通知fragment
 */

public class EMailFragment extends BaseFragment implements XListView.IXListViewListener {
    @BindView(R.id.xlv_fragcommon)
    XListView xlvFragcommon;
    @BindView(R.id.pgb_fragcommon)
    ProgressBar pgbFragcommon;
    Unbinder unbinder;

    private EmailXLVAdapter adapter;
    private List<BaseBean> list;
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
            EMailBean bean=new EMailBean();
            bean.setTitle("开庭通知");
            bean.setTime("2017-04-05");
            bean.setContent("您承办的案件编号为[2017]刑事诉讼2号当事人为" +
                    "废话见面案由为更健康的案件,将于2017-03-02开庭,请注意时间");
            list.add(bean);
        }


    }

    @Override
    public void initView() {
        listener =new CommonActivity.CommonActListener() {
            @Override
            public void clickEvent() {
                DialogUtils.showDialog(getActivity(), R.string.meiyouweidu, R.string.queding, R.string.tishi,
                        new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                });
            }
        };


        ((CommonActivity)getActivity()).setListener(listener);
        xlvFragcommon.setPullRefreshEnable(true);//下拉刷新
        xlvFragcommon.setPullLoadEnable(true);//上拉加载
        xlvFragcommon.setAutoLoadEnable(true);//底部自动加载
        xlvFragcommon.setRefreshTime(getTime());//加载时间
        adapter=new EmailXLVAdapter(getActivity(),list);//适配器
        xlvFragcommon.setAdapter(adapter);
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


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
