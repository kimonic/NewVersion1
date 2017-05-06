package dingw.com.newversion.fragment;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import dingw.com.newversion.R;
import dingw.com.newversion.adapter.wait.Viewpager_Adapter;
import dingw.com.newversion.base.BaseFragment;
import dingw.com.newversion.utils.ScreenUtils;

/**
 * Created by 12348 on 2017/5/6 0006.
 * viewpager+fragmen可滑动组合
 */

public class VPScallFraqment extends BaseFragment {
    @BindView(R.id.linearlayout_fragcasetwo)
    LinearLayout linearlayout;
    @BindView(R.id.horizontalscrollview_fragcasetwo)
    HorizontalScrollView horizontalscrollview;
    @BindView(R.id.viewpager_fragcasetwo)
    ViewPager viewpager;

    /**
     * 导航按钮的个数(与需要加载的fragment的个数相同)
     */
    private int fragmentCount;
    /**
     * 需要加载的fragment的类型数组
     */
    private int fragType[];

    /**
     * 导航条的宽度和高度
     */
    private int viewWidth;
    private int viewHeight;
    /**
     * view的选中标识
     */
    private final static int SELECT_TRUE = 1;
    /**
     * view的选中标识
     */
    private final static int SELECT_FALSE = 0;
    /**
     * 导航标签内容list
     */
    private List<String> labelList;
    /**
     * 导航条view list集合
     */
    private List<View> list;
    /**
     * 上一次点击的view
     */
    private int beforeClickView = 0;
    /**
     * fragmnet list
     */
    private List<Fragment> fragmentList;


    @Override
    public int setResid() {
        return R.layout.frag_vpscall;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() < 20) {
            if (beforeClickView != (int) v.getTag()) {
                for (int i = 0; i < fragmentCount; i++) {
                    if (i == beforeClickView) {
                        setViewStytle(list.get(i), 0);
                    }
                }
            }
            for (int i = 0; i < fragmentCount; i++) {
                if ((int) v.getTag() == i) {
                    setViewStytle(list.get(i), 1);
                    viewpager.setCurrentItem(i);
                }
            }
            beforeClickView = (int) v.getTag();
        }
    }

    @Override
    public void initData() {
        Bundle bundle = getArguments();
        fragmentCount = bundle.getInt("fragmentcount", 0);
        fragType = bundle.getIntArray("fragtype");
        labelList = bundle.getStringArrayList("label");
    }


    @Override
    public void initView() {
        initNavigation();
        horizontalscrollview.setHorizontalScrollBarEnabled(false);
        initFragment();

        /*      viewpager适配器     */
        Viewpager_Adapter adapter = new Viewpager_Adapter(getChildFragmentManager(), fragmentList, getActivity());
        viewpager.setAdapter(adapter);

    }

    @Override
    public void initListener() {
        initViewClickEvent();
        viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {//viewpager改变时导航条的位置相应改变
                setViewStytle(list.get(position), 1);

                setViewStytle(list.get(beforeClickView), 0);
                beforeClickView = position;
                if (position > 4) {
                    horizontalscrollview.scrollTo(viewWidth * position, 0);
                } else {
                    horizontalscrollview.fullScroll(ScrollView.FOCUS_LEFT);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    public void initLoad() {

    }

    /**
     * 解决导航条选中错位
     */
    @Override
    public void onStart() {
        setViewStytle(list.get(beforeClickView), 1);
        super.onStart();
    }

    /**
     * 初始化要加载的fragment
     */
    private void initFragment() {

        FragmentFactory fragmentCollection = new FragmentFactory(fragType);
        fragmentList = fragmentCollection.getFragmentList();
    }

    /**
     * 初始化navigation 个数,内容
     */
    private void initNavigation() {
        if (!(labelList.size() == 1 && labelList.get(0).equals(""))) {
            list = new ArrayList<>();
            confirmWidthAndHeight();
            for (int i = 0; i < fragmentCount; i++) {

                View view = LayoutInflater.from(getActivity()).inflate(R.layout.view_navigation, null);
                if (i == 0) {
                    if (beforeClickView == 0) {
                        setViewStytle(view, 1);
                    } else {
                        setViewStytle(view, 0);
                    }
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(viewWidth, viewHeight);
                    view.setLayoutParams(layoutParams);
                } else {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(viewWidth, viewHeight);
                    view.setLayoutParams(layoutParams);

                    setViewStytle(view, 0);


                }
                TextView textView = (TextView) view.findViewById(R.id.textitem_content);
                textView.setText(labelList.get(i));//设置内容文本
                view.setTag(i);//设置标记
                list.add(view);
                linearlayout.addView(view);
            }
        }

    }

    /**
     * 设置view的显示外观
     */
    public void setViewStytle(View view, int flag) {
        TextView textView1 = (TextView) view.findViewById(R.id.textitem_content);
        TextView textView2 = (TextView) view.findViewById(R.id.textitem_fengexian);
        switch (flag) {
            case SELECT_TRUE:
                if (Build.VERSION.SDK_INT < 23) {
                    textView1.setTextColor(getResources().getColor(R.color.mytextcolororange));
                    textView2.setBackgroundColor(getResources().getColor(R.color.myxiahuaxian));
                } else {
                    textView1.setTextColor(getResources().getColor(R.color.mytextcolororange,null));
                    textView2.setBackgroundColor(getResources().getColor(R.color.myxiahuaxian,null));
                }
                break;
            case SELECT_FALSE:
                if (Build.VERSION.SDK_INT > 22) {
                    textView1.setTextColor(getResources().getColor(R.color.mytextcolorblack1, null));
                    textView2.setBackgroundColor(getResources().getColor(R.color.mycolorhui, null));
                } else {
                    textView1.setTextColor(getResources().getColor(R.color.mytextcolorblack1));
                    textView2.setBackgroundColor(getResources().getColor(R.color.mycolorhui));
                }


                break;
        }

    }

    /**
     * 根据加载fragment的个数确定view的宽度和高度
     */
    public void confirmWidthAndHeight() {

        int px = ScreenUtils.getScreenWidth(getActivity());
        if (fragmentCount < 6) {
            viewWidth = px / fragmentCount;
        } else {
            viewWidth = px / 5;
        }
        viewHeight = 40 * ScreenUtils.getDensity(getActivity());
    }

    /**
     * 初始化view点击事件
     */
    private void initViewClickEvent() {
        if (!(labelList.size() == 1 && labelList.get(0).equals(""))) {
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setOnClickListener(this);
            }
        }

    }
}