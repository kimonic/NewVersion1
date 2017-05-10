package dingw.com.newversion.activity.work;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import dingw.com.newversion.R;
import dingw.com.newversion.base.BaseActivity;
import dingw.com.newversion.bean.work.NoticeDetailsGBean;
import dingw.com.newversion.constant.Constant;
import dingw.com.newversion.http.HttpGP;
import dingw.com.newversion.utils.ToastUtils;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by 12348 on 2017/5/10 0010.
 * 主页--工作---本所公告详情activity
 */

public class NoticeDeActivity extends BaseActivity {
    @BindView(R.id.textview_noticedetailsact_title)
    TextView title;
    @BindView(R.id.textview_noticedetailsact_createtime)
    TextView createTime;
    @BindView(R.id.textview_noticedetailsact_content)
    TextView content;
    @BindView(R.id.textview_noticedetailsact_finish)
    TextView actFinish;
    @BindView(R.id.ll_show)
    LinearLayout llShow;
    @BindView(R.id.pgb_noticede)
    ProgressBar pgbNoticede;

    private NoticeDetailsGBean bean;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    initLoad();
                    break;
            }
        }
    };

    @Override
    public void initContentView() {
        setContentView(R.layout.actde_notice);
        ButterKnife.bind(this);
    }

    @Override
    public void initData() {
        String url = Constant.BENSUOGONGGAO_DEETAILS + getIntent().getStringExtra("id");
        HttpGP.sendOkhttpGetRequest(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                ToastUtils.showToast(NoticeDeActivity.this, R.string.shujujiazaishibai);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                bean = gson.fromJson(response.body().string(), new TypeToken<NoticeDetailsGBean>() {
                }.getType());
                Message msg = Message.obtain();
                msg.what = 1;
                handler.sendMessage(msg);
            }
        }, this);

    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {
        actFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeActivity();
            }
        });
    }

    @Override
    public void initLoad() {
        if (bean != null) {
            title.setText(bean.getOfficeoa_details().getTitle());
            createTime.setText(bean.getOfficeoa_details().getCreate_time());
            content.setText(bean.getOfficeoa_details().getContent());
            pgbNoticede.setVisibility(View.GONE);
            llShow.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onClick(View v) {

    }


}
