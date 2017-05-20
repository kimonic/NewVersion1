package dingw.com.newversion.activity.wait;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import dingw.com.newversion.R;
import dingw.com.newversion.base.BaseActivity;
import dingw.com.newversion.customview.TopBar;

/**
 * Created by 12348 on 2017/3/25 0025.
 * 意见反馈activity
 */

public class OpinionFeedbackActivity extends BaseActivity {

    /**顶部bar*/
    @BindView(R.id.topbar_opinionfeedbackact)
    TopBar topBar;

    /**反馈信息标题*/
    @BindView(R.id.edittext_opinionfeedbackact_title)    EditText editText_title;
    /**反馈内容*/
    @BindView(R.id.edittext_opinionfeedbackact_content)    EditText editText_content;
    /**联系方式QQ/邮箱*/
    @BindView(R.id.edittext_opinionfeedbackact_contentway)    EditText editText_contentway;

    /**提交反馈按钮*/
    @BindView(R.id.textview_opinionfeedbackact_submit)    TextView textView_submit;



    @Override
    public void initContentView() {
        setContentView(R.layout.act_opinionfeedback);

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
        topBar.setListener(new TopBar.ClickEvent() {
            @Override
            public void tvfinishClick() {
                closeActivity();
            }

            @Override
            public void tvtextClick() {

            }

            @Override
            public void tvaddClick() {

            }
        });
    }

    @Override
    public void initLoad() {

    }

    @Override
    public void onClick(View v) {

    }
}
