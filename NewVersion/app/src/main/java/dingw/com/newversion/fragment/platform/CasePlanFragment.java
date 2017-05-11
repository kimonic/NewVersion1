package dingw.com.newversion.fragment.platform;

import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import dingw.com.newversion.R;
import dingw.com.newversion.base.BaseFragment;

/**
 * Created by 12348 on 2017/5/11 0011.
 * plateform--案件进度
 */

public class CasePlanFragment extends BaseFragment {
    @BindView(R.id.textview_fragcaseplan1)
    TextView caseNum;
    @BindView(R.id.textview_fragcaseplan2)
    TextView casePassword;
    @BindView(R.id.textview_fragcaseplan3)
    TextView courthouse;
    @BindView(R.id.textview_fragcaseplan4)
    TextView select;
    @BindView(R.id.textview_fragcaseplan5)
    TextView search;
    @BindView(R.id.textview_fragcaseplan6)
    TextView clean;
    @BindView(R.id.edittext_fragcaseplan1)
    EditText editCaeNum;
    @BindView(R.id.edittext_fragcaseplan2)
    EditText editPassword;


    /**
     * 案件编号
     */
    private String number;
    /**
     * 案件密码
     */
    private String password;
    /**
     * 法院
     */
    private String mcourthouse;
    /**
     * 判断信息是否填写完整
     */
    private boolean ifInput = false;

    private AlertDialog.Builder builder;
    private AlertDialog dialog;


    @Override
    public int setResid() {
        return R.layout.frag_caseplan;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.textview_fragcaseplan4:
                builder=new AlertDialog.Builder(getActivity());
                View view= LayoutInflater.from(getActivity()).inflate(R.layout.dialog_item3,null);
                builder.setView(view);
                TextView textView1= (TextView) view.findViewById(R.id.textview_courthousedialog1);
                TextView textView2= (TextView) view.findViewById(R.id.textview_courthousedialog2);
                TextView textView3= (TextView) view.findViewById(R.id.textview_courthousedialog3);
                textView1.setOnClickListener(this);
                textView2.setOnClickListener(this);
                textView3.setOnClickListener(this);
                dialog=builder.show();


                break;
            case R.id.textview_fragcaseplan5:

                number = editCaeNum.getText().toString().trim();
                password = editPassword.getText().toString().trim();
                mcourthouse = select.getText().toString().trim();

                ifInput = judgeInput();
                if (ifInput) {
                    //执行查询逻辑
                } else {
                    Toast.makeText(getActivity(), "请填写信息进行查询", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.textview_fragcaseplan6:
                caseNum.setTextColor(getResources().getColor(R.color.mytextcolorblack));
                editCaeNum.setText("");

                casePassword.setTextColor(getResources().getColor(R.color.mytextcolorblack));
                editPassword.setText("");

                courthouse.setTextColor(getResources().getColor(R.color.mytextcolorblack));
                select.setText("请选择");
                break;
            case R.id.textview_courthousedialog1:
                select.setText(R.string.shenggaoyuan);
                dialog.dismiss();
                break;
            case R.id.textview_courthousedialog2:
                select.setText(R.string.weihaizhongyuan);
                dialog.dismiss();
                break;
            case R.id.textview_courthousedialog3:
                dialog.dismiss();
                break;
        }
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {
        select.setOnClickListener(this);
        search.setOnClickListener(this);
        clean.setOnClickListener(this);
    }

    @Override
    public void initLoad() {

    }

    /**
     * 判断信息是否填写完整,并调整相应字体颜色
     */
    private boolean judgeInput() {
        if ("".equals(number)) {
            caseNum.setTextColor(getResources().getColor(R.color.mytextcolorred1));
        } else {
            caseNum.setTextColor(getResources().getColor(R.color.mytextcolorblack));
        }
        if ("".equals(password)) {
            casePassword.setTextColor(getResources().getColor(R.color.mytextcolorred1));
        } else {
            casePassword.setTextColor(getResources().getColor(R.color.mytextcolorblack));
        }
        if ("请选择".equals(mcourthouse)) {
            courthouse.setTextColor(getResources().getColor(R.color.mytextcolorred1));
        } else {
            courthouse.setTextColor(getResources().getColor(R.color.mytextcolorblack));
        }
        if (!"".equals(number) && !"".equals(password) && !"请选择".equals(mcourthouse)) {
            return true;
        }
        return false;
    }
}
