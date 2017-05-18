package dingw.com.newversion.fragment.community;

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
import dingw.com.newversion.adapter.community.LawyerMediaXLVAdapter;
import dingw.com.newversion.base.BaseBean;
import dingw.com.newversion.base.RefreshBaseFragment;
import dingw.com.newversion.bean.community.LawyerMediaBean;
import dingw.com.newversion.constant.Constant;
import dingw.com.newversion.http.HttpGP;
import dingw.com.newversion.utils.ToastUtils;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by 12348 on 2017/5/18 0018.
 * 主页--社区--律师自媒体
 */

public class LawyerMideaFragment extends RefreshBaseFragment {
    private List<BaseBean> list;
    private LawyerMediaBean bean;
    private LawyerMediaXLVAdapter adapter;
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
        adapter=new LawyerMediaXLVAdapter(getActivity(),list);
        return adapter;
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
        list=new ArrayList<>();//数据源

        HttpGP.sendOkhttpGetRequest(Constant.LAWYER_ZIMEITI, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                ToastUtils.showToast(getActivity(), R.string.shujujiazaishibai);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson=new Gson();
                bean=gson.fromJson(response.body().string(),new TypeToken<LawyerMediaBean>(){}.getType());
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
