package dingw.com.newversion.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import dingw.com.newversion.R;
import dingw.com.newversion.base.BaseActivity;
import dingw.com.newversion.bean.LoginBean;
import dingw.com.newversion.constant.Constant;
import dingw.com.newversion.customview.TopBar;
import dingw.com.newversion.http.LoginHttp;
import dingw.com.newversion.utils.DialogUtils;
import dingw.com.newversion.utils.GlideImageLoader;
import dingw.com.newversion.utils.MD5Utils;
import dingw.com.newversion.utils.SaveUtils;
import dingw.com.newversion.utils.ToastUtils;

/**
 * Created by 12348 on 2017/5/3 0003.
 * 绑定或解绑界面
 */

public class BindOrUnbindActivity extends BaseActivity {
    @BindView(R.id.tb_loginact)
    TopBar topbar;
    @BindView(R.id.iv_headact)
    ImageView ivIcon;
    @BindView(R.id.et_zhiyezhenghao)
    EditText etZhengHao;
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_loginpassword)
    EditText etPassword;
    @BindView(R.id.bt_login)
    Button btBindOrUnbind;
    @BindView(R.id.tv_unbind)
    TextView tvTemp1;
    @BindView(R.id.tv_temp)
    TextView tvTemp2;


    private String zhiyezhenghao;
    private String name;
    private String loginpassword;
    private SaveUtils save;
    /**
     * 绑定或者解绑界面,默认为解绑界面
     */
    private int ifBind = 0;
    private Map<String, String> map;

    /**
     * 请求登录连接
     */
    private LoginHttp loginHttp;
    /**
     * 登录回调接口
     */
    private LoginHttp.LoginListener listener;
    /**
     * md5加密后的密码
     */
    private String pwdmd5;
    /**是否是来自我的activity的解除绑定调用*/
    private int myUnbind;
    /**解除绑定成功标志*/
    private int unbindSuccess;

    @Override
    public void initContentView() {
        setContentView(R.layout.act_login);
        ButterKnife.bind(this);
    }

    @Override
    public void initData() {
        Intent intent = getIntent();
        myUnbind=intent.getIntExtra("wodejiechu",0);
        ifBind = intent.getIntExtra("bind", 0);
    }

    @Override
    public void initView() {
        tvTemp1.setVisibility(View.GONE);
        tvTemp2.setVisibility(View.GONE);

        GlideImageLoader.getInstance().displayCircleImage(this, R.drawable.test2, ivIcon);


        if (ifBind == 1) {
            topbar.setTvText(getResources().getString(R.string.bangdingzhanghu));
            btBindOrUnbind.setText(R.string.bangding);
        } else {
            topbar.setTvText(getResources().getString(R.string.jiechubangding));
            btBindOrUnbind.setText(R.string.jiechubangding);
        }






    }

    @Override
    public void initListener() {
        btBindOrUnbind.setOnClickListener(this);
        topbar.setListener(new TopBar.ClickEvent() {
            @Override
            public void tvfinishClick() {
                startLoginAct();
            }

            @Override
            public void tvtextClick() {

            }

            @Override
            public void tvaddClick() {

            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_login:
                if (ifBind == 2) {//解绑逻辑
                    unBindDevice();
                } else {//绑定逻辑
                    bindDevice();
                }
                break;
        }
    }


    /**解绑账号*/
    private void unBindDevice(){
        if (getInfo()) {
            listener = new LoginHttp.LoginListener() {
                @Override
                public void loginInfo(final LoginBean bean) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (bean.getState().equals("200")) {
                                unbindSuccess=9;
                                delInfo();
                                ToastUtils.showToast(BindOrUnbindActivity.this,R.string.jiebangchenggong);
                                emptyEdittext();
                                new AlertDialog.Builder(BindOrUnbindActivity.this)
                                        .setMessage(R.string.ninyijingjiechu)
                                        .setTitle(R.string.jiechubangdingchenggong)
                                        .setPositiveButton(R.string.chongxinbangding, new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                btBindOrUnbind.setText(R.string.bangding);
                                                topbar.setTvText(R.string.bangdingzhanghu);
                                                ifBind = 1;
                                            }
                                        })
                                        .setNegativeButton(R.string.fanhui, new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                startLoginAct();
                                            }
                                        })
                                        .show();

                            } else {
                                ToastUtils.showToast(BindOrUnbindActivity.this,bean.getError());
                            }
                        }
                    });

                }
            };
            loginHttp = new LoginHttp(listener, this);
            loginHttp.senLoginRequest(Constant.NEWBASEURL + Constant.UNBIND_URL, map, 1);
        } else {
            ToastUtils.showToast(this,R.string.shurucuowu);
            setResult(1);
        }
    }


    /**
     * 绑定账号
     */
    private void bindDevice() {
        if (getInfo()) {//进行绑定
            listener = new LoginHttp.LoginListener() {
                @Override
                public void loginInfo(final LoginBean bean) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (bean.getState().equals("200")) {
                                saveInfo();
                                DialogUtils.showDialog(BindOrUnbindActivity.this, R.string.ninyijingbangding
                                        , R.string.qudenglu, R.string.bangdingchenggong, new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                startLoginAct();
                                            }
                                        }
                                );
                            } else if (bean.getState().equals("600")){
                                ToastUtils.showToast(BindOrUnbindActivity.this,bean.getError());
                            }else {
                                ToastUtils.showToast(BindOrUnbindActivity.this,R.string.qingjianchazhanghao);
                            }
                        }
                    });

                }
            };
            loginHttp = new LoginHttp(listener, this);
            loginHttp.senLoginRequest(Constant.NEWBASEURL + Constant.BIND_URL, map, 2);
        }
    }

    /**
     * 取得输入信息
     */
    private boolean getInfo() {
        map = new HashMap<>();
        //获取设备唯一id
        String androidId = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
        map.put("mac_address", androidId);//输入参数唯一标识
        zhiyezhenghao = etZhengHao.getText().toString().trim();
        name = etName.getText().toString().trim();
        loginpassword = etPassword.getText().toString().trim();
        if (!name.equals("") && !zhiyezhenghao.equals("") && !loginpassword.equals("")) {
            pwdmd5 = MD5Utils.md5(etPassword.getText().toString().trim());
            map.put("pwd", pwdmd5);
            map.put("license", zhiyezhenghao);//输入参数职业证号
            map.put("name", name);//输入参数姓名
            map.put("device_token", "Android");
            map.put("imei", "1212121");
            map.put("device_version", "" + Build.VERSION.SDK_INT);
            return true;
        } else {
            ToastUtils.showToast(this,R.string.bitianxiangbu);
            return false;
        }
    }

    /**
     * 存储输入信息
     */
    private void saveInfo() {
        save = new SaveUtils(this,"userinfo");
        if (!zhiyezhenghao.equals("") && !name.equals("") && !loginpassword.equals("")) {
            Map<String,String> tempMap=new HashMap<>(3);
            tempMap.put("license",zhiyezhenghao);
            tempMap.put("name",name);
            tempMap.put("password",pwdmd5);
            save.saveInfo(tempMap);
        } else {
            ToastUtils.showToast(this,R.string.bitianxiangbu);
        }

    }

    /**
     * 删除存储信息
     */
    private void delInfo() {
        save = new SaveUtils(this, "userinfo");
        save.deletAllInfo();
//        saveLoginInfo.setZhiyezhenghao("");
//        saveLoginInfo.setName("");
//        saveLoginInfo.setPassword("");
//        saveLoginInfo.saveInfo();

    }

    /**
     * 将edittext置空,并显示提示语
     */
    public void emptyEdittext() {
        etPassword.setText("");
        etName.setText("");
        etZhengHao.setText("");
        etZhengHao.setHint(R.string.zhenghao_hint);
        etPassword.setHint(R.string.password_hint);
        etName.setHint(R.string.name_hint);
    }
    /**
     * 启动登录界面
     */
    private void startLoginAct() {
        if (myUnbind!=9||unbindSuccess==9){
            setResult(9);
        }
        openActivity(LoginActivity.class);
    }

}
