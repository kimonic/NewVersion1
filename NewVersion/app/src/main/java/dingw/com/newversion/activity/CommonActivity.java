package dingw.com.newversion.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import dingw.com.newversion.R;
import dingw.com.newversion.adapter.wait.Viewpager_Adapter;
import dingw.com.newversion.base.BaseActivity;
import dingw.com.newversion.fragment.FragmentFactory;
import dingw.com.newversion.utils.ScreenUtils;

/**
 * Created by 12348 on 2017/5/3 0003.
 * 二级页面通用activity
 */

public class CommonActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_finisht)
    TextView tvFinisht;
    @BindView(R.id.tv_open)
    TextView tvOpen;
    @BindView(R.id.ll_container)
    LinearLayout llContainer;
    @BindView(R.id.hsv_common)
    HorizontalScrollView hsvCommon;
    @BindView(R.id.vp_common)
    ViewPager vpCommon;


    /**
     * viewpager中加载的fragment的个数
     */
    private int fragmentCount;
    /**
     * 保存导航条view
     */
    private List<View> list;
    /**
     * 导航条view的高度
     */
    private int viewHeight;
    /**
     * 导航条view的宽度
     */
    private int viewWidth;
    /**
     * view的选中标识
     */
    private final static int SELECT_TRUE = 1;
    /**
     * view的选中标识
     */
    private final static int SELECT_FALSE = 0;
    /**
     * fragmnet list
     */
    private List<Fragment> fragmentList;
    /**
     * 上一次点击的view
     */
    private int beforeClickView = 0;
    /**
     * 导航条标签内容
     */
    private List<String> labelList;
    /**
     * 顶部标题
     */
    private String titleContent;
    /**
     * 加号是否显示
     */
    private boolean isOpenShow = false;

    /**
     * fragment的类型数组
     */
    private int[] fragmentType;
    /**顶部右侧为文本时*/
    private String showText;
    /**顶部按钮点击接口实例*/
    private CommonActListener listener;
    private CommonActListener listener1;
    /**顶部按钮毁掉接口*/
    public interface CommonActListener{
        void clickEvent();
    }
    /**设置点击接口*/
    public void setListener(CommonActListener listener){
        this.listener=listener;
    }
    /**设置点击接口1*/
    public void setListener1(CommonActListener listener1) {
        this.listener1 = listener1;
    }

    @Override
    public void initContentView() {
        setContentView(R.layout.act_common);
        ButterKnife.bind(this);

    }
    /**
     * 获得启动时传递的数据
     * 标签--ArrayList----label
     * fragment数量---int-----fragmentCount
     * 中间标题---String---title
     * 右侧open图片是否显示---boolean---openshow
     */
    @Override
    public void initData() {
        Intent intent = getIntent();
        labelList = intent.getStringArrayListExtra("label");
        fragmentCount = intent.getIntExtra("fragmentCount", 0);
        titleContent = intent.getStringExtra("title");
        isOpenShow = intent.getBooleanExtra("openshow", false);
        fragmentType = intent.getIntArrayExtra("fragmenttype");
        showText=intent.getStringExtra("showtext");
    }

    @Override
    public void initView() {
        initNavigation();
        hsvCommon.setHorizontalScrollBarEnabled(false);
        initFragment();
        /*viewpager适配器*/
        Viewpager_Adapter adapter = new Viewpager_Adapter(getSupportFragmentManager(), fragmentList, this);
        vpCommon.setAdapter(adapter);
        vpCommon.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setViewStytle(list.get(position), 1);
                setViewStytle(list.get(beforeClickView), 0);
                beforeClickView = position;
                if (position > 4) {
                    hsvCommon.scrollTo(viewWidth * position, 0);
                } else {
                    hsvCommon.fullScroll(ScrollView.FOCUS_LEFT);
                }
                if (position==0&&listener!=null){
                    tvOpen.setVisibility(View.VISIBLE);
                }else if (position!=0&&listener1!=null){
                    tvOpen.setVisibility(View.GONE);
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        initViewClickEvent();

        tvTitle.setText(titleContent);
        ifShowOpen();
    }

    /**
     * 初始化view点击事件
     */
    private void initViewClickEvent() {
        if (labelList.size() != 1 ||! labelList.get(0).equals("")) {
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setOnClickListener(this);
            }
        }

    }

    /**
     * 初始化fragmentlist
     */
    public void initFragment() {
        FragmentFactory fragmentCollection = new FragmentFactory(fragmentType);
        fragmentList = fragmentCollection.getFragmentList();

//        if (fragmentList.get(0) instanceof FragmentMyFinancing) {//当加载我的财务fragment时传递数据
//            for (int i = 0; i < fragmentList.size(); i++) {
//                String temp = "(" + labelList.get(i) + ")单位:元";
//                ((FragmentMyFinancing) (fragmentList.get(i))).setTop(temp);
//            }
//        }

    }
    /**
     * 初始化navigation 个数,内容
     */
    private void initNavigation() {
        if (labelList.size() != 1 || !labelList.get(0).equals("")) {
            list = new ArrayList<>();
            confirmWidthAndHeight();
            for (int i = 0; i < fragmentCount; i++) {

                View view = LayoutInflater.from(this).inflate(R.layout.item_tv, null);
                if (i == 0) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(viewWidth, viewHeight);
                    view.setLayoutParams(layoutParams);
                    setViewStytle(view, 1);
                } else {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(viewWidth, viewHeight);
                    view.setLayoutParams(layoutParams);
                    setViewStytle(view, 0);
                }
                TextView textView = (TextView) view.findViewById(R.id.textitem_content);
                textView.setText(labelList.get(i));//设置内容文本
                view.setTag(i);//设置标记
                list.add(view);
                llContainer.addView(view);
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
                textView1.setTextColor(getResources().getColor(R.color.mytextcolororange));
                textView2.setBackgroundColor(getResources().getColor(R.color.myxiahuaxian));
                break;
            case SELECT_FALSE:
                textView1.setTextColor(getResources().getColor(R.color.mytextcolorblack1));
                textView2.setBackgroundColor(getResources().getColor(R.color.mycolorhui));
                break;
        }

    }


    /**
     * 根据加载fragment的个数确定view的宽度和高度
     */
    public void confirmWidthAndHeight() {
        int px= ScreenUtils.getScreenWidth(this);
        if (fragmentCount < 6) {
            viewWidth = px / fragmentCount;
        } else {
            viewWidth = px / 5;
        }
        viewHeight = 40 * ScreenUtils.getDensity(this);

    }

    /**
     * 设置点击事件
     */
    @Override
    public void onClick(View v) {
        if (v.getId() > 20) {
            switch (v.getId()) {
                case R.id.tv_finisht:
                    this.finish();
                    break;
                case R.id.tv_open://回调
                    if (listener!=null){//执行点击事件并显示textview
                        listener.clickEvent();
                    }
                    break;
            }
        } else {
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
                    vpCommon.setCurrentItem(i);
                    if (i==0&&listener!=null){
                        tvOpen.setVisibility(View.VISIBLE);
                    }else if (i!=0&&listener1!=null){
                        tvOpen.setVisibility(View.GONE);
                    }
                }
            }
            beforeClickView = (int) v.getTag();
        }
    }

    /**
     * 是否显示顶部右侧图片
     */
    public void ifShowOpen() {
        if (isOpenShow) {
            tvOpen.setVisibility(View.VISIBLE);
            if (showText.equals("")){
                tvOpen.setBackgroundResource(R.drawable.xvector_add);
            }else {
                LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                tvOpen.setLayoutParams(layoutParams);
                tvOpen.setText(showText);
            }

        } else {
            tvOpen.setVisibility(View.GONE);
        }
    }

    @Override
    public void initListener() {
        tvFinisht.setOnClickListener(this);
        tvOpen.setOnClickListener(this);
    }




}
