package dingw.com.newversion.fragment.wait;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.BaseAdapter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dingw.com.newversion.R;
import dingw.com.newversion.activity.wait.NetizenConsultDeActivity;
import dingw.com.newversion.adapter.wait.NetizenConsultXLVAdapter;
import dingw.com.newversion.base.BaseBean;
import dingw.com.newversion.base.RefreshBaseFragment;
import dingw.com.newversion.bean.wait.NetizenConsultBean;
import dingw.com.newversion.bean.wait.NetizenConsultGbean;
import dingw.com.newversion.constant.Constant;
import dingw.com.newversion.http.HttpGP;
import dingw.com.newversion.utils.ToastUtils;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by 12348 on 2017/5/8 0008.
 * homeactivity----社区---网民咨询区
 */

public class NetizenConsultFragment extends RefreshBaseFragment {
    private List<BaseBean> list;
    private NetizenConsultGbean bean;
    private NetizenConsultXLVAdapter adapter;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    initLoad();
                    ToastUtils.showToast(getActivity(),R.string.shujujiazaichenggong);
                    break;
            }
        }
    };

    @Override
    public BaseAdapter setAdapter() {
        adapter=new NetizenConsultXLVAdapter(getActivity(),list);
        return adapter;
    }

    @Override
    public void setItemClick() {
        openActivity(NetizenConsultDeActivity.class);
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
        list=new ArrayList<>();//数据源
//        for (int i = 0; i < 30; i++) {
//            NetizenConsultBean bean=new NetizenConsultBean();
//            bean.setTitle("当事人822175");
//            bean.setTime("发表:2017-04-05 12:05");
//            bean.setType("分类:交通事故");
//
//            bean.setContent("清晨，太阳还在沉睡，我便早已收拾停当，提着一只竹篓，扛着一根自制的鱼竿，" +
//                    "和一群嘎小子去荷塘钓鱼。头顶一片荷叶，嘴噙着一瓣馨香的莲子，在荷塘岸边，或坐或站，" +
//                    "光着脚板，踏着岸边潮润的大地，以少年难得的耐心和毅力与荷塘里的鱼儿周旋。");
//            bean.setBrowseNum("200");
//            bean.setCommentNum("150");
//            list.add(bean);
//        }
        HttpGP.sendOkhttpGetRequest(Constant.WANGMINZIXUN, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                ToastUtils.showToast(getActivity(), R.string.shujujiazaishibai);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson=new Gson();
                bean=gson.fromJson(response.body().string(),new TypeToken<NetizenConsultGbean>(){}.getType());
                Message msg=Message.obtain();
                msg.what=1;
                handler.sendMessage(msg);
            }
        }, getActivity());

    }

    @Override
    public void initLoad() {
        if (bean!=null){
            for (int i = 0; i < bean.getList().size(); i++) {
                list.add(bean.getList().get(i));
            }
            adapter.notifyDataSetChanged();
            showXlistview();
        }

    }
}
