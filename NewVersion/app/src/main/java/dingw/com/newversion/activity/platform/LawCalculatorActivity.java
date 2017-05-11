package dingw.com.newversion.activity.platform;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import dingw.com.newversion.R;
import dingw.com.newversion.base.BaseActivity;
import dingw.com.newversion.fragment.FragmentFactory;

/**
 * Created by 12348 on 2017/5/11 0011.
 * 法律计算器通用activity
 */

public class LawCalculatorActivity extends BaseActivity {

    @BindView(R.id.textview_lawcalculatorclose)
    TextView textviewClose;

    @BindView(R.id.framlayout_container)
    FrameLayout framlayoutContainer;

    private List<Fragment> list;


    @Override
    public void initContentView() {
        setContentView(R.layout.act_lawcalculator);
        ButterKnife.bind(this);
    }

    @Override
    public void initData() {
        Intent intent=getIntent();
        int[] fragmentType = intent.getIntArrayExtra("type");
        FragmentFactory fragmentCollection=new FragmentFactory(fragmentType);
        list=fragmentCollection.getFragmentList();
    }

    @Override
    public void initView() {
        getSupportFragmentManager().beginTransaction().replace(R.id.framlayout_container,list.get(0)).commit();
    }

    @Override
    public void initListener() {
        textviewClose.setOnClickListener(this);
    }

    @Override
    public void initLoad() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.textview_lawcalculatorclose:
                closeActivity();
                break;

        }
    }
}
