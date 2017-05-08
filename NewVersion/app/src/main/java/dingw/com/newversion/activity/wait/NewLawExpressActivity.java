package dingw.com.newversion.activity.wait;

import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import dingw.com.newversion.R;
import dingw.com.newversion.base.BaseActivity;

/**
 * Created by 12348 on 2017/5/8 0008.
 * 待办--新法速递--详情activity
 */

public class NewLawExpressActivity extends BaseActivity {
    @BindView(R.id.textview_newlawexpress1)
    TextView title;
    @BindView(R.id.textview_newlawexpress2)
    TextView createTime;
    @BindView(R.id.textview_newlawexpress3)
    TextView content;
    @BindView(R.id.textview_newlawexpressfinish)
    TextView actFinish;
    @Override
    public void initContentView() {
        setContentView(R.layout.act_newlawexpress);
        ButterKnife.bind(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {
        actFinish.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.textview_newlawexpressfinish:
                closeActivity();
                break;
        }
    }
}
