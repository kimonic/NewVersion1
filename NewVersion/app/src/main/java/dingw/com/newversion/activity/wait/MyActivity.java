package dingw.com.newversion.activity.wait;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import dingw.com.newversion.Main22Activity;
import dingw.com.newversion.R;
import dingw.com.newversion.activity.BindOrUnbindActivity;
import dingw.com.newversion.adapter.wait.MyLVAdapter;
import dingw.com.newversion.base.BaseActivity;
import dingw.com.newversion.base.BaseBean;
import dingw.com.newversion.bean.wait.MyActBean;
import dingw.com.newversion.customview.SuperTextView;
import dingw.com.newversion.customview.TopBar;
import dingw.com.newversion.utils.AppInfoUtils;
import dingw.com.newversion.utils.DialogUtils;
import dingw.com.newversion.utils.HeightUtils;
import dingw.com.newversion.utils.ToastUtils;

/**
 * Created by 12348 on 2017/5/5 0005.
 * * 点击home页中的头像显示的我的activity,设置app的相关信息
 */

public class MyActivity extends BaseActivity {


    private static final String TAG = "listview";
    int content[] = {
            R.string.myfavorite,
            R.string.yixiazai,
            R.string.tuisongshezhi,
            R.string.unbind,
            R.string.changepassword,
            R.string.qingchuhuancun1,
            R.string.fenxianggei,
            R.string.shoujishiyong,
            R.string.diannaoshiyong,
            R.string.meicidenglu,
            R.string.kefuqq,
            R.string.banbengengxin,
            R.string.opinionfeedback,
    };

    int resId[] = {
            R.drawable.myact_icon1,
            R.drawable.myact_icon2,
            R.drawable.myact_icon3,
            R.drawable.myact_icon4,
            R.drawable.myact_icon5,
            R.drawable.myact_icon6,
            R.drawable.myact_icon7,
            R.drawable.myact_icon8,
            R.drawable.myact_icon9,
            R.drawable.myact_icon10,
            R.drawable.myact_icon11,
            R.drawable.myact_icon12,
            R.drawable.myact_icon13,
    };
    @BindView(R.id.topbar_myactivity)
    TopBar topbar;
    @BindView(R.id.listview_my)
    ListView lvMy;
    @BindView(R.id.textview_myactivitycancel)
    SuperTextView stvMyCancel;

    private List<BaseBean> list;

    @Override
    public void initContentView() {
        setContentView(R.layout.act_my);
        ButterKnife.bind(this);
    }

    @Override
    public void initData() {
        list=new ArrayList<>();
        for (int i = 0; i < content.length; i++) {
            MyActBean listViewBean=new MyActBean(content[i],resId[i],"",0);
            if (i==5){
                listViewBean.setMark("0M");
            }else if (i==10){
                listViewBean.setMark("2097901861");
            }else if (i==11){
                listViewBean.setMark("01.01.0221");
            }else if (i==9){
                listViewBean.setResIdt(1);
            }
            list.add(listViewBean);
        }
    }

    @Override
    public void initView() {

        MyLVAdapter adapter=new MyLVAdapter(this,list);
        lvMy.setAdapter(adapter);
        HeightUtils.setFixHeight(lvMy);

    }

    @Override
    public void initListener() {
        topbar.setListener(new TopBar.ClickEvent() {

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
        stvMyCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("flag",1);
                setResult(1,intent);
                closeActivity();
            }
        });
        setListviewListener();
    }

    @Override
    public void initLoad() {

    }

    private void setListviewListener() {
        lvMy.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent intent=new Intent(MyActivity.this,MyItemActivity.class);
                        intent.putExtra("name",0);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent1=new Intent(MyActivity.this,MyItemActivity.class);
                        intent1.putExtra("name",1);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2=new Intent(MyActivity.this,MyItemActivity.class);
                        intent2.putExtra("name",2);
                        startActivity(intent2);
                        break;
                    case 3://解除绑定
                        Intent intent_unbind=new Intent(MyActivity.this,BindOrUnbindActivity.class);
                        intent_unbind.putExtra("wodejiechu",9);
                        startActivityForResult(intent_unbind,1);
                        break;
                    case 4:
                        Intent intent3=new Intent(MyActivity.this,ChangePasswordActivity.class);
                        startActivity(intent3);
                        break;
                    case 5:
                        showMyDialog(0,R.string.qingchuhuancun,R.string.queding);
                        break;
                    case 6://分享----------------------------------
                        showAnimDialog();
                        break;
                    case 7:
                        Intent intent7=new Intent(MyActivity.this,MyItemActivity.class);
                        intent7.putExtra("name",7);
                        startActivity(intent7);

                        break;
                    case 8:
                        Intent intent8=new Intent(MyActivity.this,MyItemActivity.class);
                        intent8.putExtra("name",8);
                        startActivity(intent8);
                        break;
                    case 9://每次登陆输入密码

                        break;
                    case 10://客服QQ
                        if (checkApkExist(MyActivity.this, "com.tencent.mobileqq")){
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("mqqwpa://im/chat?chat_type=wpa&uin="+"2097901861"+"&version=1")));
                        }else{
                            ToastUtils.showToast(MyActivity.this,R.string.benjiweianzhuang);
                        }
                        break;
                    case 11://版本更新
                        if (AppInfoUtils.getAppVersionCode(MyActivity.this)==1){
                            showMyDialog(R.string.tishi,R.string.nindebanben,R.string.ok);
                        }
                        break;
                    case 12://意见反馈
                        Intent intent12=new Intent(MyActivity.this,OpinionFeedbackActivity.class);
                        startActivity(intent12);
                        break;
                }
            }
        });
    }

    @Override
    public void onClick(View v) {

    }
    /**展示dialog提示信息*/
    private void showMyDialog(int title ,int message,int ok) {
        //网络请求获得最版本码与当前版本码进行比较决定是否需要更新
        if (title==0){
            DialogUtils.showDialog(MyActivity.this, message, ok,
                     new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
        }else{
            DialogUtils.showDialog(MyActivity.this, message, ok,
                    title, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
        }


    }


    /**友盟分享*/
    private void showAnimDialog() {
        UMWeb web=new UMWeb("http://www.12348flfw.com/html/appshare/user/?share=");
        web.setTitle("这个App很不错，你也试试看!");
        web.setThumb(new UMImage(MyActivity.this,R.mipmap.ic_launcher));//web分享的图片不能为透明,否则显示黑色
        web.setDescription("法律服务网12348");
        new ShareAction(MyActivity.this)
                .withMedia(web)
                .setDisplayList(
                        SHARE_MEDIA.WEIXIN,
                        SHARE_MEDIA.WEIXIN_CIRCLE,
                        SHARE_MEDIA.QQ,
                        SHARE_MEDIA.QZONE,
                        SHARE_MEDIA.MORE
                ).setCallback(umShareListener).open();
    }
    /**检查手机是否已经安装qq*/
    public boolean checkApkExist(Context context, String packageName) {
        if (packageName == null || "".equals(packageName))
            return false;
        try {
            if (Build.VERSION.SDK_INT<24){
                ApplicationInfo info = context.getPackageManager().getApplicationInfo(packageName,
                        PackageManager.GET_UNINSTALLED_PACKAGES);
            }else {
                ApplicationInfo info = context.getPackageManager().getApplicationInfo(packageName,
                        PackageManager.MATCH_UNINSTALLED_PACKAGES);
            }
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
//        注：qq的应用包名是：com.tencent.mobileqq
    }

    /**-----------------------------------------------------------------------------------*/
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1&&resultCode==9){//解绑成功返回
            closeActivity();
        }
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);

    }

    private UMShareListener umShareListener = new UMShareListener() {//友盟分享监听回调
        @Override
        public void onStart(SHARE_MEDIA platform) {
            //分享开始的回调
        }
        @Override
        public void onResult(SHARE_MEDIA platform) {
            ToastUtils.showToast(MyActivity.this, platform + " 分享成功啦");
        }

        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            if(t!=null){
                ToastUtils.showToast(MyActivity.this, platform + " 分享失败啦!失败原因:"+t.getMessage());
            }else {
                ToastUtils.showToast(MyActivity.this, platform + " 分享失败啦");
            }
        }

        @Override
        public void onCancel(SHARE_MEDIA platform) {
            ToastUtils.showToast(MyActivity.this, platform + " 分享取消了");
        }
    };


    @Override
    protected void onDestroy() {
        super.onDestroy();
        UMShareAPI.get(this).release();
    }

}
