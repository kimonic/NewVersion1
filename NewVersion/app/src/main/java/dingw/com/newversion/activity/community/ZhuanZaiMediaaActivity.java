package dingw.com.newversion.activity.community;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import dingw.com.newversion.R;
import dingw.com.newversion.base.BaseActivity;
import dingw.com.newversion.utils.DialogUtils;

/**
 * Created by 12348 on 2017/5/18 0018.
 * 转载自媒体 activity
 */

public class ZhuanZaiMediaaActivity extends BaseActivity {
    @BindView(R.id.imageview_communitytwoback)
    ImageView imageViewBac;
    @BindView(R.id.edittext_communitytwo1)
    EditText editText1;
    @BindView(R.id.edittext_communitytwo2)    EditText editText2;
    @BindView(R.id.edittext_communitytwo3)    EditText editText3;
    @BindView(R.id.edittext_communitytwo4)    EditText editText4;
    @BindView(R.id.edittext_communitytwo5)    EditText editText5;
    @BindView(R.id.edittext_communitytwo6)    EditText editText6;

    @BindView(R.id.textview_communitytwo1)
    TextView textView1;
    @BindView(R.id.textview_communitytwo2)    TextView textView2;
    @BindView(R.id.textview_communitytwo3)    TextView textView3;
    @BindView(R.id.textview_communitytwo4)    TextView textView4;
    @BindView(R.id.textview_communitytwo5)    TextView textView5;
    @BindView(R.id.textview_communitytwo6)    TextView textView6;

    @BindView(R.id.linearlayout_communitytwo3)
    LinearLayout linearLayout3;
    @BindView(R.id.linearlayout_communitytwo4)    LinearLayout linearLayout4;
    @BindView(R.id.linearlayout_communitytwo5)    LinearLayout linearLayout5;


    @BindView(R.id.textview_communitytwo)    TextView announce;
    @BindView(R.id.textview_communitytwotitle)    TextView title;

    /**标题栏设置类型*/
    private int titleType=0;
    /**标题*/
    private String titleContent;
    @Override
    public void initContentView() {
        setContentView(R.layout.act_communitytwo);
        ButterKnife.bind(this);
    }

    @Override
    public void initData() {
        titleType=getIntent().getIntExtra("type",0);
        titleContent=getIntent().getStringExtra("title");
    }

    @Override
    public void initView() {
        titleSet();
        imageViewBac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMyDialog();
            }
        });
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initLoad() {

    }

    @Override
    public void onClick(View v) {

    }

    private void showMyDialog(){
        DialogUtils.showDialog(this, R.string.shifoufangqi, R.string.fangqi, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                closeActivity();
            }
        });
    }
    @Override
    public void onBackPressed() {
        showMyDialog();
    }
    private void titleSet(){
        switch (titleType){
            case 0:
                break;
            case 1:

                break;
            case 2:
                textView6.setText("内        容");
                editText6.setHint("请填写详细内容");
                break;
            case 3:
                linearLayout4.setVisibility(View.VISIBLE);
                linearLayout5.setVisibility(View.VISIBLE);
                textView2.setText(R.string.diqu);
                editText2.setHint(R.string.xuanzediqu);
                textView3.setText(R.string.xiezhufenlei);
                editText3.setHint(R.string.xiezhulvshi);
                textView4.setText(R.string.qitatiaojian);
                editText4.setHint(R.string.qitaxiezhu);
                textView5.setText(R.string.label);
                editText5.setHint(R.string.labelhint);
                break;
            case 4:
                linearLayout3.setVisibility(View.GONE);
                break;
            case 5:break;
            case 6:break;
        }
        title.setText(titleContent);

    }
}
