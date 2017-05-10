package dingw.com.newversion.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import dingw.com.newversion.R;
import dingw.com.newversion.base.BaseActivity;
import dingw.com.newversion.fragment.VPScallFraqment;

/**
 * Created by 12348 on 2017/5/6 0006.
 * 顶部双按钮activity
 */

public class TwoTopButtonActivity extends BaseActivity {
    @BindView(R.id.imageview_casetwo_finish)
    TextView actFinish;
    @BindView(R.id.textview_casetwo_top1)
    TextView buttonTop1;
    @BindView(R.id.textview_casetwo_top2)
    TextView buttonTop2;
    @BindView(R.id.framelayout_casetwo)
    FrameLayout framelayout;
    @BindView(R.id.framelayout_casetwoact)
    FrameLayout container;

    private FragmentManager manager;
    private Fragment fragment1, fragment2;

    /**
     * 顶部按钮对应加载的fragment的个数
     */
    private int fragmentcount1, fragmentcount2;
    /**
     * 顶部按钮对应加载的fragment的类型
     */
    private int[] fragType1, fragType2;
    /**
     * 顶部按钮对应加载的导航标签的名称
     */
    private String[] label1, label2;
    /**
     * 顶部按钮文本
     */
    private String top1, top2;

    @Override
    public void initContentView() {
        setContentView(R.layout.act_twotopbutton);
        ButterKnife.bind(this);

    }

    @Override
    public void initData() {
        manager = getSupportFragmentManager();
        Intent intent = getIntent();
        fragmentcount1 = intent.getIntArrayExtra("count")[0];
        fragmentcount2 = intent.getIntArrayExtra("count")[1];
        fragType1 = intent.getIntArrayExtra("fragType1");
        fragType2 = intent.getIntArrayExtra("fragType2");
        label1 = intent.getStringArrayExtra("label1");
        label2 = intent.getStringArrayExtra("label2");
        top1 = intent.getStringExtra("top1");
        top2 = intent.getStringExtra("top2");
    }

    @Override
    public void initView() {
        buttonTop1.setText(top1);
        buttonTop2.setText(top2);
        fragment1 = createFragment(fragmentcount1, fragType1, label1);
    }

    @Override
    public void initListener() {
        actFinish.setOnClickListener(this);
        buttonTop1.setOnClickListener(this);
        buttonTop2.setOnClickListener(this);
    }

    @Override
    public void initLoad() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageview_casetwo_finish:
                closeActivity();
                break;

            case R.id.textview_casetwo_top1://传参加载fragment
                buttonTop1.setBackgroundColor(getResources().getColor(R.color.myback1));
                buttonTop2.setBackgroundColor(getResources().getColor(R.color.myback2));

                if (fragment1 == null) {
                    fragment1 = createFragment(fragmentcount1, fragType1, label1);

                } else {
                    manager.beginTransaction().replace(R.id.framelayout_casetwoact, fragment1).commit();
                }
                break;
            case R.id.textview_casetwo_top2:
                buttonTop2.setBackgroundColor(getResources().getColor(R.color.myback1));
                buttonTop1.setBackgroundColor(getResources().getColor(R.color.myback2));
                if (fragment2 == null) {
                    fragment2 = createFragment(fragmentcount2, fragType2, label2);
                } else {
                    manager.beginTransaction().replace(R.id.framelayout_casetwoact, fragment2).commit();
                }
                break;
        }
    }

    private Fragment createFragment(int fragmentcount, int[] fragtype, String[] label) {
        VPScallFraqment two = new VPScallFraqment();
        Bundle bundle = new Bundle();
        bundle.putInt("fragmentcount", fragmentcount);
        bundle.putIntArray("fragtype", fragtype);
        ArrayList<String> list = new ArrayList<>();
        for (String element:label){
            list.add(element);
        }

        bundle.putStringArrayList("label", list);
        two.setArguments(bundle);
        manager.beginTransaction().replace(R.id.framelayout_casetwoact, two).commit();
        return two;
    }

    @Override
    protected void onPause() {
        overridePendingTransition(0, 0);//取消activity的加载动画
        super.onPause();
    }
}
