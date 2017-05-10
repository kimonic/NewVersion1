package dingw.com.newversion.fragment.wait;

import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dingw.com.newversion.R;
import dingw.com.newversion.adapter.wait.NoticeXLVAdapter;
import dingw.com.newversion.base.BaseBean;
import dingw.com.newversion.base.RefreshBaseFragment;
import dingw.com.newversion.http.HttpGP;
import dingw.com.newversion.jsonparse.NoticeJsonParse;
import dingw.com.newversion.utils.ToastUtils;
import dingw.com.newversion.widget.XListView;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by 12348 on 2017/5/8 0008.
 * 工作--本所公告加载fragment
 */

public class NoticeFragment extends RefreshBaseFragment {

    private List<BaseBean> list;
    private FragmentActivity activity;
    private NoticeXLVAdapter adapter;
    private int page=1;

    private String url;
    private int type;
    private XListView xlvList;
    private ProgressBar pgb;

    @Override
    public BaseAdapter setAdapter() {
        list=new ArrayList<>();//数据源
        adapter=new NoticeXLVAdapter(getActivity(),list);
        adapter.setType(type);
        return adapter;
    }

    @Override
    public void setItemClick() {

    }
    /**xlistview下拉刷新监听*/
    @Override
    public void newRefresh() {
        page=1;
        HttpGP.sendOkhttpGetRequest(url + "1", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                loadFailure();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                loadSuccessful(response,"刷新成功!",true);
            }
        },activity);
    }

    /**xlistview加载更多监听*/
    @Override
    public void newLoadMore() {
        page=page+1;
        HttpGP.sendOkhttpGetRequest(url + page, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                loadFailure();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                loadSuccessful(response,"加载数据成功!",false);
            }
        },activity);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void initData() {
        if (getArguments()!=null){
            type=getArguments().getInt("type",1);
        }
        url=getArguments().getString("url");

    }

    @Override
    public void initLoad() {
        String newUrl=url+page;
        HttpGP.sendOkhttpGetRequest(newUrl , new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                loadFailure();
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                loadSuccessful(response,"",false);
            }
        },activity);
    }
    /**加载数据失败*/
    private void loadFailure() {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                pgb.setVisibility(View.GONE);
                ToastUtils.showToast(activity, R.string.jiazaichucuo);
            }
        });
    }


    /**加载成功相关数据处理*/
    private void loadSuccessful(Response response, final String toastString,boolean refresh) {
        String res= null;
        if (refresh){
            list.clear();//下拉刷新时清空lsit
        }
        try {
            res = response.body().string();
            try {
                JSONObject jsonObject=new JSONObject(res);
                if (jsonObject.getInt("state")==200){
                    //开始解析json数据
                    NoticeJsonParse noticeJsonParse=new NoticeJsonParse(res,list,activity);
                    noticeJsonParse.getParseJson();
                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            xlvList.setVisibility(View.VISIBLE);
                            pgb.setVisibility(View.GONE);
                            adapter.notifyDataSetChanged();
                            if (!toastString.equals("")){
                                Toast.makeText(activity, toastString, Toast.LENGTH_SHORT).show();
                                onLoad();
                            }
                        }
                    });
                }else {
                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            pgb.setVisibility(View.GONE);
                            ToastUtils.showToast(activity,R.string.meiyougenguo);
                            onLoad();
                        }
                    });
                }
            } catch (JSONException e) {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        pgb.setVisibility(View.GONE);
                        ToastUtils.showToast(activity,R.string.jsonerror);
                    }
                });
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void initContentView() {
        super.initContentView();
        activity=getActivity();
        xlvList=getXlvFragcommon();
        pgb=getPgbFragcommon();
    }
}
