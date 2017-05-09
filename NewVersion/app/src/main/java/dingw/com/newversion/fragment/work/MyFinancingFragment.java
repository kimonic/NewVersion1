package dingw.com.newversion.fragment.work;

import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.Unbinder;
import dingw.com.newversion.R;
import dingw.com.newversion.base.BaseFragment;

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
    Unbinder unbinder;

    private String top;

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

    }
}
