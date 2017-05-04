package dingw.com.newversion.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.util.Log;
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
 * Created by 12348 on 2017/5/2 0002.
 * 登录界面
 *
 * ----临时登录按钮需删除-----
 */

public class LoginActivity extends BaseActivity {


    @BindView(R.id.tb_loginact)
    TopBar topbar;
    @BindView(R.id.iv_headact)
    ImageView ivHead;
    @BindView(R.id.et_zhiyezhenghao)
    EditText etZhengHao;
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_loginpassword)
    EditText etPassword;
    @BindView(R.id.bt_login)
    Button btLogin;
    @BindView(R.id.tv_unbind)
    TextView tvUnbind;
    @BindView(R.id.tv_temp)
    TextView tvTemp;

    /**
     * 参数存储map
     */
    private Map<String, String> map;
    /**设备唯一编号*/
    private String androidId;
    private Map<String,String> info;
    /**保存的职业证号与姓名的key值*/
    String key[]=new String[]{"license","name"};
    private boolean clickAble = false;
    /**
     * 判断是否需要绑定账号
     */
    private boolean ifBind = true;



    @Override
    public void initContentView() {
        setContentView(R.layout.act_login);
        ButterKnife.bind(this);
    }

    @Override
    public void initData() {
        map=new HashMap<>();
        androidId = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
        map.put("mac_address", androidId);

        ifBind = judgeInfo();

    }

    @Override
    public void initView() {

        /**------------------------------需删除-------------------------------------------------------*/
        Log.e(TAG, "initView: "+androidId+"-----"+ tvTemp);
        tvTemp.setText("临时按钮可绕过登录直接进入主界面--显示设备的Androidid---"+androidId);
        tvTemp.setOnClickListener(this);
        /**------------------------------需删除-------------------------------------------------------*/
        //设置圆形图片
        GlideImageLoader.getInstance().displayCircleImage(this, R.drawable.test2, ivHead);
        //设置绑定右侧图片
        Drawable drawable;
        if (Build.VERSION.SDK_INT<21){
            drawable= getResources().getDrawable(R.drawable.right);
        }else {
            drawable= getResources().getDrawable(R.drawable.right,null);
        }
        drawable.setBounds(0, 0, 50, 50);
        tvUnbind.setCompoundDrawables(null, null, drawable, null);
        //根据用户登录信息是否存在进行相关操作
        if (ifBind) {//存在--读取信息--填写密码后登录
            showSaveInfo();
        } else {//不存在--展示dialog询问是否进行账号绑定
            etZhengHao.setFocusable(true);
            etName.setFocusable(true);
            tvUnbind.setText(R.string.bangding);
            DialogUtils.showDialog(this,R.string.bangdinghoucai,R.string.bangding,new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
//                    启动绑定界面
                    Intent intent_unbind = new Intent(LoginActivity.this, BindOrUnbindActivity.class);
                    intent_unbind.putExtra("bind", 1);
                    startActivity(intent_unbind);
                    closeActivity();
                }
            });

        }

    }

    @Override
    public void initListener() {
        topbar.setListener(new TopBar.ClickEvent() {
            @Override
            public void tvfinishClick() {
                DialogUtils.showDialog(LoginActivity.this, R.string.shifoutuichu, R.string.queding, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        closeActivity();
                    }
                });
            }

            @Override
            public void tvtextClick() {

            }

            @Override
            public void tvaddClick() {

            }
        });
        btLogin.setOnClickListener(this);
        tvUnbind.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_temp://不需要密码直接进入主界面
//                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
//                startActivity(intent);
                openActivity(HomeActivity.class);
                closeActivity();
                break;
            case R.id.bt_login://登录点击
                login();
                break;
            case R.id.tv_unbind://解绑绑定点击
                bindOrUnbind();
                break;
        }
    }
    /**解绑绑定逻辑*/
    private void bindOrUnbind() {
        if (!ifBind) {//启动绑定界面
            Intent intent_unbind = new Intent(LoginActivity.this, BindOrUnbindActivity.class);
            intent_unbind.putExtra("bind", 1);
            startActivity(intent_unbind);
        } else {//启动解绑界面
            Intent intent_unbind = new Intent(LoginActivity.this, BindOrUnbindActivity.class);
            intent_unbind.putExtra("bind", 2);
            startActivity(intent_unbind);
        }
        closeActivity();
    }

    /**登录逻辑*/
    private void login() {

        if (ifBind) {//已绑定账号
            if (inputPass()) {
                /*      登录回调接口     */
                LoginHttp.LoginListener listener = new LoginHttp.LoginListener() {
                    @Override
                    public void loginInfo(final LoginBean bean) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if ("200".equals(bean.getState())) {
                                    openActivity(HomeActivity.class);
                                    closeActivity();
                                } else if ("600".equals(bean.getState())) {
                                    ToastUtils.showToast(LoginActivity.this, bean.getError());
                                } else if ("204".equals(bean.getState())) {
                                    ToastUtils.showToast(LoginActivity.this, bean.getError());
                                } else {
                                    ToastUtils.showToast(LoginActivity.this, "联网失败,请检查网络连接!");
                                }

                            }
                        });
                    }
                };
                /*      请求登录连接     */
                LoginHttp loginHttp = new LoginHttp(listener, this);
                loginHttp.senLoginRequest(Constant.NEWBASEURL + Constant.LOGIN_URL, map, 1);
            }


        } else {//未绑定账号
            ToastUtils.showToast(this, "账号必须绑定后才能登录,请先绑定账号!");
        }
    }

    /**
     * 判断密码是否为空,不为空则存储参数
     */
    public boolean inputPass() {
        if (etPassword.getText().toString().trim().equals("")) {
            ToastUtils.showToast(this,"请输入密码进行登录,密码:123456");
            return false;
        } else {
            String pwdmd5 = MD5Utils.md5(etPassword.getText().toString().trim());
            map.put("pwd", pwdmd5);
            return true;
        }
    }

    /**
     * 取出存储信息并显示到edittext中
     */
    private void showSaveInfo() {
        etZhengHao.setText(info.get(key[0]));
        etZhengHao.setFocusable(false);
        clickAble = true;
        etZhengHao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickAble) {
                    DialogUtils.showDialog(LoginActivity.this, R.string.qiehuanzhanghao,
                            R.string.jiechubangding, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent_unbind = new Intent(LoginActivity.this, BindOrUnbindActivity.class);
                            intent_unbind.putExtra("bind", 2);
                            startActivity(intent_unbind);
                            closeActivity();
                        }
                    });
                }
            }
        });
        etName.setText(info.get(key[1]));
        etName.setFocusable(false);
        tvUnbind.setText(R.string.jiechubangding);
    }

    /**
     * 判断用户登录信息是否存在
     */
    private boolean judgeInfo() {
        SaveUtils save = new SaveUtils(this,"userinfo");
        info = save.getManyStringInfo(key);
        map.put("license", info.get(key[0]));//输入参数职业证号
        map.put("name", info.get(key[1]));//输入参数姓名
        if (!info.get(key[0]).equals("") && !info.get(key[1]).equals("")) {//绑定状态
            return true;//存在信息
        } else {
            return false;//不存在信息
        }
    }

    @Override
    public void onBackPressed() {
        DialogUtils.showDialog(this, R.string.shifoutuichu, R.string.queding, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                closeActivity();
            }
        });
    }
}
