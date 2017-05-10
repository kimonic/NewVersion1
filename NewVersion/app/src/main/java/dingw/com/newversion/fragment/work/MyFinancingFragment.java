package dingw.com.newversion.fragment.work;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;

import butterknife.BindView;
import butterknife.Unbinder;
import dingw.com.newversion.R;
import dingw.com.newversion.base.BaseFragment;
import dingw.com.newversion.bean.work.FinanceBean;
import dingw.com.newversion.constant.Constant;
import dingw.com.newversion.http.HttpGP;
import dingw.com.newversion.utils.ToastUtils;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by 12348 on 2017/5/9 0009.
 * 主页--工作--我的财务
 */

public class MyFinancingFragment extends BaseFragment {
    @BindView(R.id.textview_fragmyfinancing1)
    TextView financing1;
    @BindView(R.id.textview_fragmyfinancing2)
    TextView financing2;
    @BindView(R.id.textview_fragmyfinancing3)
    TextView financing3;
    @BindView(R.id.textview_fragmyfinancing4)
    TextView financing4;
    @BindView(R.id.textview_fragmyfinancing5)
    TextView financing5;
    @BindView(R.id.textview_fragmyfinancing6)
    TextView financing6;
    @BindView(R.id.textview_fragmyfinancing7)
    TextView financing7;
    @BindView(R.id.textview_fragmyfinancing8)
    TextView financing8;
    @BindView(R.id.textview_fragmyfinancing9)
    TextView financing9;
    @BindView(R.id.textview_fragmyfinancing10)
    TextView financing10;
    @BindView(R.id.textview_fragmyfinancing11)
    TextView financing11;
    @BindView(R.id.textview_fragmyfinancing12)
    TextView financing12;
    @BindView(R.id.textview_fragmyfinancing13)
    TextView financing13;
    @BindView(R.id.textview_fragmyfinancing14)
    TextView financing14;
    @BindView(R.id.textview_fragmyfinancing15)
    TextView financing15;

    private String top;
    private FinanceBean  bean;
    Handler handler=new Handler(){
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

    public void setTop(String top) {
        this.top = top;
    }
    @Override
    public int setResid() {
        return R.layout.frag_myfinancing;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void initData() {
        HttpGP.sendOkhttpGetRequest(Constant.FINANCE, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                ToastUtils.showToast(getActivity(),R.string.shujujiazaishibai);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson=new Gson();
                bean=gson.fromJson(response.body().string(),new TypeToken<FinanceBean>(){}.getType());
                Message msg=Message.obtain();
                msg.what=1;
                handler.sendMessage(msg);



            }
        }, getActivity());


    }

    @Override
    public void initView() {
        financing1.setText(top);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initLoad() {
        if (bean!=null){
            financing1.setText(bean.getState());
            financing2.setText(bean.getYear());
            financing3.setText(bean.getForegif_statistics().getAmount());
            financing4.setText(bean.getForegif_statistics().getArrival_amount());
            financing5.setText(bean.getForegif_statistics().getNon_amount());
            financing6.setText(bean.getMy_statistics().getNon_amount());
            financing7.setText(bean.getMy_statistics().getArrival_amount());
            financing8.setText(bean.getMy_statistics().getAmount());
            financing9.setText(bean.getOther_statistics().getAmount());
            financing10.setText(bean.getOther_statistics().getExpenditure());
            financing11.setText(bean.getOther_statistics().getIncome());
            financing12.setText(bean.getYears().get(0));
            financing13.setText(bean.getYears().get(1));
            financing14.setText(bean.getYears().get(2));
            financing15.setText(bean.getState());

        }
    }
}
