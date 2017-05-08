package dingw.com.newversion.activity.wait;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import dingw.com.newversion.R;
import dingw.com.newversion.base.BaseActivity;
import dingw.com.newversion.customview.MyDialog;
import dingw.com.newversion.utils.ToastUtils;

/**
 * Created by 12348 on 2017/5/8 0008.
 * 首页--社区--网民咨询区--详情activity
 */

public class NetizenConsultDeActivity extends BaseActivity {
    @BindView(R.id.textview_netizendetailsactfinish)
    TextView actFinish;
    @BindView(R.id.editText_netizendetailsact)
    TextView editText;
    @BindView(R.id.imageview_netizendetailsactcollect)
    ImageView collect;


    /**收藏点击次数技计数*/
    private int conllectCount=0;


    @Override
    public void initContentView() {
        setContentView(R.layout.actde_netizen);
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
        editText.setOnClickListener(this);
        collect.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.textview_netizendetailsactfinish://结束activity
                this.finish();
                break;
            case R.id.editText_netizendetailsact://展示输入评论dialog
                MyDialog myDialog=new MyDialog(this, new MyDialog.DialogListener() {
                    @Override
                    public void clickEvent() {

                    }
                });
                myDialog.showMyDialog();
                break;
            case R.id.imageview_netizendetailsactcollect://此处要将收藏保存到本地,通过读取收藏状态进行相关操作
                conllectCount++;
                if (conllectCount%2==1){
                    ToastUtils.showToast(this,R.string.shoucangchenggong);
                    collect.setImageResource(R.drawable.xvector_star_yellow);

                }else {
                    ToastUtils.showToast(this,R.string.quuxiaoshoucang);
                    collect.setImageResource(R.drawable.xvector_star_gray);
                }
                break;
        }
    }
}
