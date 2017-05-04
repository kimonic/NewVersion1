package dingw.com.newversion.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatSpinner;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import dingw.com.newversion.DevelopKit.AutoBindUnbind;
import dingw.com.newversion.R;
import dingw.com.newversion.base.BaseActivity;
import dingw.com.newversion.customview.TopBar;
import dingw.com.newversion.fragment.wait.WaitFragment;

/**
 * Created by 12348 on 2017/5/3 0003.
 * 主界面
 */

public class HomeActivity extends BaseActivity {
    @BindView(R.id.topbar_homactivity)
    TopBar topbar;
    @BindView(R.id.spinner_home)
    AppCompatSpinner spinnerHome;
    @BindView(R.id.imageview_homeadd)
    TextView ivHomeadd;
    @BindView(R.id.framelayout_home)
    FrameLayout flHome;
    @BindView(R.id.fragment_container)
    FrameLayout fragContainer;
    @BindView(R.id.linearlayout_waitimage)
    ImageView llWaitIv;
    @BindView(R.id.linearlayout_waittext)
    TextView llWaitTv;
    @BindView(R.id.linearlayout_workimage)
    ImageView llWorkIv;
    @BindView(R.id.linearlayout_worktext)
    TextView llWorkTv;
    @BindView(R.id.linearlayout_work)
    LinearLayout llWork;
    @BindView(R.id.linearlayout_complateimage)
    ImageView llComplateIv;
    @BindView(R.id.linearlayout_complatetext)
    TextView llComplateTv;
    @BindView(R.id.linearlayout_complateform)
    LinearLayout llComplate;
    @BindView(R.id.linearlayout_comimage)
    ImageView llCominutyIv;
    @BindView(R.id.linearlayout_comtext)
    TextView llCominutyTv;
    @BindView(R.id.linearlayout_community)
    LinearLayout llCominuty;
    @BindView(R.id.linearlayout_wait)
    LinearLayout llWait;

    /**注销本次登录标志*/
    private int loginCancel;

    /**
     * 当前点击的按钮
     */
    private int currentLinear = 0;
    /**
     * 喜爱个点击按钮
     */
    private int nextlinear = 0;
    /**
     * fragment管理器
     */
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    /**
     * 工作fragment
     */
//    private WorkFragment fragment_work;
    /**
     * 待办fragment
     */
    private WaitFragment fragment_wait;
//    /**
//     * 平台fragment
//     */
//    private Fragment_Plateform fragment_plateform;
//    /**
//     * 律师自媒体fragment
//     */
////    private Fragment_Community fragment_community;
//    private FragmentlawyerMidea   fragment_community;
    /**
     * 社区--topbar-add--type
     */
    private int addType = 0;
//    /**
//     * 网民咨询区fragment------------------------------------------------------------
//     */
//    private FragmentNetizenConsult fragmentNetizenConsult;
//    /**
//     * 交流区fragment------------------------------------------------------------
//     */
//    private FragmentInterflowArea fragmentInterflowArea;
//    /**
//     * 协助区与分享区fragment,目前无内容------------------------------------------------------------
//     */
//    private Fragment_NoContent fragment_noContent1,fragment_noContent2;
      private AlertDialog dialog;


    @Override
    public void initContentView() {
        setContentView(R.layout.act_home);
        ButterKnife.bind(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        fragmentManager = getSupportFragmentManager();
        fragment_wait = new WaitFragment();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment_wait);
        fragmentTransaction.commit();
    }

    @Override
    public void initListener() {
        llCominuty.setOnClickListener(this);
        llWork.setOnClickListener(this);
        llWait.setOnClickListener(this);
        llComplate.setOnClickListener(this);
        initSpiner();
        ivHomeadd.setOnClickListener(this);
    }

    /**
     * 社区菜单点击事件-----------------------------------------------------------------------------
     */

    private void initSpiner() {
        spinnerHome.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {//律师自媒体下拉菜单点击事件
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView tv=null;
                if(view!=null){
                    //设置spiner首项的显示状态
                    tv= (TextView) view.findViewById(android.R.id.text1);
                    tv.setTextColor(getResources().getColor(R.color.mytextcolorwhite));
                    tv.setTextSize(18f);
                    tv.setGravity(Gravity.CENTER);
                }

                fragmentTransaction = fragmentManager.beginTransaction();
                hideFragments(fragmentTransaction);

                //单项点击事件
                switch (position) {
//                    case 0://律师自媒体
//                        if (fragment_community == null) {
//                            fragment_community = new FragmentlawyerMidea();
//                            fragmentTransaction.add(R.id.fragment_container, fragment_community);
//                        } else {
//                            fragmentTransaction.show(fragment_community);
//                        }
//                        break;
//                    case 1://分享区
////                        addNewFragment(fragment_noContent1);//使用封装方法fragment作为参数不能实例化
//                        if (fragment_noContent1 == null) {
//                            fragment_noContent1 = new Fragment_NoContent();
//                            fragmentTransaction.add(R.id.fragment_container, fragment_noContent1);
//                        } else {
//                            fragmentTransaction.show(fragment_noContent2);
//                        }
//                        break;
//                    case 2://协助区
////                        addNewFragment(fragment_noContent2);
//                        if (fragment_noContent2 == null) {
//                            fragment_noContent2 = new Fragment_NoContent();
//                            fragmentTransaction.add(R.id.fragment_container, fragment_noContent2);
//                        } else {
//                            fragmentTransaction.show(fragment_noContent2);
//                        }
//                        break;
//                    case 3://交流区
//                        if (fragmentInterflowArea == null) {
//                            fragmentInterflowArea = new FragmentInterflowArea();
//                            fragmentTransaction.add(R.id.fragment_container, fragmentInterflowArea);
//                        } else {
//                            fragmentTransaction.show(fragmentInterflowArea);
//                        }
//                        break;
//                    case 4://网民咨询区
//                        imageViewAdd.setVisibility(View.GONE);
//                        if (fragmentNetizenConsult == null) {
//                            fragmentNetizenConsult = new FragmentNetizenConsult();
//                            fragmentTransaction.add(R.id.fragment_container, fragmentNetizenConsult);
//                        } else {
//                            fragmentTransaction.show(fragmentNetizenConsult);
//                        }
//                        break;
//                    case 5://我的收藏
//                        if (tv!=null){
//                            tv.setText(getResources().getTextArray(R.array.lvshizimeiti)[addType]);
//                        }
//                        spinner.setSelection(addType);//将选中位置设为上一个
//                        StartCommonActivity.startCommonActivity(HomeActivity.this,
//                                new String[]{"分享区", "协助区", "交流区", "自媒体", "咨询区"}, new int[]{0, 0, 0, 0, 0}, "我的收藏",false, "");
//                        break;
                }
                fragmentTransaction.commitAllowingStateLoss();

                if (position != 4) {
                    ivHomeadd.setVisibility(View.VISIBLE);
                }
                addType = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    /**
     * 底部导航条按钮点击事件
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageview_homeadd:
                startAddType();
                break;
            case R.id.textview_dialog1://dialog按钮点击事件处理
//                startMyActivity("发布分享", 1, CommunityTwoActivity.class);
//                dialog.dismiss();
                break;
            case R.id.textview_dialog2://dialog按钮点击事件处理
//                startMyActivity("转载分享", 2, CommunityTwoActivity.class);
//                dialog.dismiss();
                break;
            default:
                fragmentTransaction = fragmentManager.beginTransaction();
                hideFragments(fragmentTransaction);//隐藏所有fragment
                nextlinear = v.getId();
                if (currentLinear == 0) {
                    currentLinear = R.id.linearlayout_wait;
                }
                changeButtonStateUp();
                changeButtonStateDown(v);
                fragmentTransaction.commitAllowingStateLoss();

                break;
        }

    }

    /**
     * 顶部标题栏右侧添加按钮事件
     */
    private void startAddType() {
        switch (addType) {
            case 0:
//                startMyActivity("律师自媒体", 0, CommunityTwoActivity.class);
                break;
            case 1:
                View view = LayoutInflater.from(this).inflate(R.layout.dialog_item1, null);
                dialog=new AlertDialog.Builder(this)
                        .setView(view)
                        .show();
                TextView textView1 = (TextView) view.findViewById(R.id.textview_dialog1);
                TextView textView2 = (TextView) view.findViewById(R.id.textview_dialog2);
                textView1.setOnClickListener(this);
                textView2.setOnClickListener(this);
                break;
            case 2:
//                startMyActivity("协助发布", 3, CommunityTwoActivity.class);
                break;
            case 3:
//                startMyActivity("发布交流", 4, CommunityTwoActivity.class);
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
        }
    }

    private void startMyActivity(String title, int type, Class activity) {
        Intent intent = new Intent(HomeActivity.this, activity);
        intent.putExtra("type", type);
        intent.putExtra("title", title);
        startActivity(intent);
    }

    /**
     * 改变button状态为按下
     */
    private void changeButtonStateDown(View v) {
        switch (v.getId()) {
            case R.id.linearlayout_wait://待办点击事件
                changeBack(llWaitTv, llWaitIv, true, R.drawable.wait_pre);
                currentLinear = v.getId();
                topbar.setVisibility(View.GONE);
                flHome.setVisibility(View.GONE);
                if (fragment_wait == null) {
                    fragment_wait = new WaitFragment();
                    fragmentTransaction.add(R.id.fragment_container, fragment_wait);
                } else {
                    fragmentTransaction.show(fragment_wait);
                }

                break;
            case R.id.linearlayout_work://工作点击事件
                changeBack(llWorkTv, llWorkIv, true, R.drawable.work_pre);
                topbar.setVisibility(View.VISIBLE);
                topbar.setTvText("工作");
                currentLinear = v.getId();
                flHome.setVisibility(View.GONE);

//                if (fragment_work == null) {
//                    fragment_work = new Fragment_Work();
//                    fragmentTransaction.add(R.id.fragment_container, fragment_work);
//                } else {
//                    fragmentTransaction.show(fragment_work);
//                }

                break;
            case R.id.linearlayout_community://社区点击事件
                communityClickEvent();
                spinnerHome.setSelection(0);
                currentLinear = v.getId();
                break;

            case R.id.linearlayout_complateform://平台点击事件
                changeBack(llComplateTv, llComplateIv, true, R.drawable.plateform_pre);
                currentLinear = v.getId();
                topbar.setVisibility(View.VISIBLE);
                topbar.setTvText("平台");
                flHome.setVisibility(View.GONE);


//                if (fragment_plateform == null) {
//                    fragment_plateform = new Fragment_Plateform();
//                    fragmentTransaction.add(R.id.fragment_container, fragment_plateform);
//                } else {
//                    fragmentTransaction.show(fragment_plateform);
//                }
                break;
        }
    }
    /**
     * 社区点击事件,默认自媒体点击
     */
    private void communityClickEvent() {
        changeBack(llCominutyTv, llCominutyIv, true, R.drawable.community_pre);
        topbar.setVisibility(View.GONE);
        flHome.setVisibility(View.VISIBLE);
//                topBar.setText("律师自媒体");----------------------------------
//        if (fragment_community == null) {
//            fragment_community = new FragmentlawyerMidea();
//            fragmentTransaction.add(R.id.fragment_container, fragment_community);
//        } else {
//            fragmentTransaction.show(fragment_community);
//        }
    }
    /**
     * 改变button状态为抬起
     */
    private void changeButtonStateUp() {
        if (currentLinear != 0 && currentLinear != nextlinear) {
            switch (currentLinear) {
                case R.id.linearlayout_wait:
                    changeBack(llWaitTv, llWaitIv, false, R.drawable.wait_up);
                    break;
                case R.id.linearlayout_work:
                    changeBack(llWorkTv, llWorkIv, false, R.drawable.work_up);
                    break;
                case R.id.linearlayout_community:
                    changeBack(llCominutyTv, llCominutyIv, false, R.drawable.community_up);
                    break;
                case R.id.linearlayout_complateform:
                    changeBack(llComplateTv, llComplateIv, false, R.drawable.plateform_up);
                    break;
            }
        }

    }

    /**
     * 隐藏所有的fragment
     */
    private void hideFragments(FragmentTransaction fragmentTransaction) {
        if (fragment_wait != null) {
            fragmentTransaction.hide(fragment_wait);
        }
//        if (fragment_work != null) {
//            fragmentTransaction.hide(fragment_work);
//        }
//        if (fragment_plateform != null) {
//            fragmentTransaction.hide(fragment_plateform);
//        }
//        if (fragment_community != null) {
//            fragmentTransaction.hide(fragment_community);
//        }
//        if (fragmentNetizenConsult != null) {
//            fragmentTransaction.hide(fragmentNetizenConsult);
//        }
//        if (fragmentInterflowArea!=null){
//            fragmentTransaction.hide(fragmentInterflowArea);
//        }
//        if (fragment_noContent1!=null){
//            fragmentTransaction.hide(fragment_noContent1);
//        }
//        if (fragment_noContent2!=null){
//            fragmentTransaction.hide(fragment_noContent2);
//        }

    }

    /**
     * 改变按钮的图片和文字颜色
     */
    public void changeBack(TextView textView, ImageView imageView, boolean bol, int res) {
        if (bol) {
            imageView.setImageResource(res);
            textView.setTextColor(getResources().getColor(R.color.mytextcolorblue));
        } else {
            imageView.setImageResource(res);
            textView.setTextColor(getResources().getColor(R.color.mytextcolorgray));
        }
    }

    /**接收myactivity传回的注销本次登录操作*/
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==1){
            loginCancel=data.getIntExtra("flag",0);
            if (loginCancel==1){
                openActivity(LoginActivity.class);
                closeActivity();
            }
        }
    }

    /**销毁activity*/
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (loginCancel!=1){
            /**--------------------------------------自动解绑设备(需删除)-------------------------------------*/
            AutoBindUnbind unbind=new AutoBindUnbind(this);
            unbind.unBindDevice();
            Log.e("TAG", "onDestroy: --------home--------------------" );
            /**--------------------------------------自动解绑设备(需删除)-------------------------------------*/
        }


    }

}
