package dingw.com.newversion.fragment.work;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import dingw.com.newversion.R;
import dingw.com.newversion.adapter.work.ConsultantUnitXLVAdapter;
import dingw.com.newversion.base.BaseBean;
import dingw.com.newversion.base.RefreshBaseFragment;
import dingw.com.newversion.bean.work.ConsultantUnitBean;
import dingw.com.newversion.utils.DialogUtils;
import dingw.com.newversion.utils.ToastUtils;

/**
 * Created by 12348 on 2017/5/9 0009.
 * 首页--工作---顾问单位--fragment
 *
 */

public class ConsultantUnitFragment extends RefreshBaseFragment {

    private List<BaseBean> list;
    /**一级显示dialog*/
    private AlertDialog dialog;
    /**er级显示dialog*/
    private AlertDialog dialog1;
    /**dialog中的textview*/
    private TextView textView1,textView2,textView3,textView4;
    /**判断是否存在qq号码*/
    private boolean ifExistQQ=true;
    @Override
    public BaseAdapter setAdapter() {
        return new ConsultantUnitXLVAdapter(getActivity(),list);
    }

    @Override
    public void setItemClick() {
            showMyDialog();
    }

    @Override
    public void newRefresh() {

    }

    @Override
    public void newLoadMore() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.textview_dialogcaozuo1:
                showMyDialogOne("拨打电话:15206500211");
                break;
            case R.id.textview_dialogcaozuo2:
                if (ifExistQQ){//存在qq操作
                    if (checkApkExist(getActivity(), "com.tencent.mobileqq")){
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("mqqwpa://im/chat?chat_type=wpa&uin="+"2097901861"+"&version=1")));
                    }else{
                        ToastUtils.showToast(getActivity(),R.string.benjiweianzhuang);
                    }
                }else {
                    ToastUtils.showToast(getActivity(),R.string.meiyoufaxian);
                }
                break;
            case R.id.textview_dialogcaozuo3:
                showMyDialogOne("拨打电话:15206500211");
                break;
            case R.id.textview_dialogcaozuo4:
                dialog.dismiss();
                break;
        }
    }
    /**展示自定义view*/
    private void showMyDialog() {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        View view= LayoutInflater.from(getActivity()).inflate(R.layout.dialog_item4,null);
        builder.setView(view);
        textView1= (TextView) view.findViewById(R.id.textview_dialogcaozuo1);
        textView2= (TextView) view.findViewById(R.id.textview_dialogcaozuo2);
        textView3= (TextView) view.findViewById(R.id.textview_dialogcaozuo3);
        textView4= (TextView) view.findViewById(R.id.textview_dialogcaozuo4);
        textView1.setOnClickListener(this);
        textView2.setOnClickListener(this);
        textView3.setOnClickListener(this);
        textView4.setOnClickListener(this);
        dialog=builder.show();

    }

    @Override
    public void initData() {
        list=new ArrayList<>(30);
        for (int i = 0; i < 30; i++) {
            ConsultantUnitBean recycData=new ConsultantUnitBean();
            recycData.setUnitName("山东达1234");
            recycData.setLiaison("123456");
            recycData.setEndTime("2017-07-31 未过期");
            recycData.setIsSave("未归档");
            recycData.setPhoneNum("15206500211");
            recycData.setLandline("6569556");
            recycData.setQqNum("123456789");
            list.add(recycData);
        }
    }

    @Override
    public void initLoad() {
        showXlistview();
    }

    private void showMyDialogOne(String msg) {

        DialogUtils.showDialog(getActivity(), msg, R.string.boda, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+"15206500211"));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
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
}
