package dingw.com.newversion.activity.wait;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import dingw.com.newversion.R;
import dingw.com.newversion.base.BaseActivity;
import dingw.com.newversion.bean.LoginBean;
import dingw.com.newversion.constant.Constant;
import dingw.com.newversion.customview.SuperTextView;
import dingw.com.newversion.customview.TopBar;
import dingw.com.newversion.http.HttpGP;
import dingw.com.newversion.http.LoginHttp;
import dingw.com.newversion.utils.MD5Utils;
import dingw.com.newversion.utils.ToastUtils;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by 12348 on 2017/5/19 0019.
 * 修改密码
 */

public class ChangePasswordActivity extends BaseActivity {
    /**
     * 顶部bar
     */
    @BindView(R.id.topbar_changepasswordact)
    TopBar topBar;
    /**
     * 原密码edittext
     */
    @BindView(R.id.edittext_changepassword_oldpassword)
    EditText editTextOld;
    /**
     * 新密码edittext,第一次输入
     */
    @BindView(R.id.edittext_changepassword_newpassword1)
    EditText editTextNew1;
    /**
     * 新密码edittext,第二次输入
     */
    @BindView(R.id.edittext_changepassword_newpassword2)
    EditText editTextNew2;
    /**
     * 验证码输入edittext
     */
    @BindView(R.id.edittext_changepassword_verifycode)
    EditText editTextVerify;
    /**
     * 获得验证码按钮
     */
    @BindView(R.id.textview_changepassword_getcode)
    SuperTextView textViewObtain;
    /**
     * 密码设置完成按钮
     */
    @BindView(R.id.textview_changepassword_complete)
    SuperTextView textViewComplete;
    /**
     * 修改密码提交参数
     */
    private Map<String, String> map;
    private String oldPass;
    private String newPass1;
    private String verrify;
    private boolean flag=true;
    /**
     * 是否正在进行倒计时
     */
    private boolean countdownFlag = true;
    /**
     * 倒计时计数
     */
    private int countdownNum = 60;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    countdownNum--;
                    if (flag){
                        textViewObtain.setText("倒数" + countdownNum + "秒");
                    }else {
                        flag=true;
                    }
                    if (countdownNum < 1) {
                        countdownFlag = false;
                        textViewObtain.setClickable(true);
                        textViewObtain.setText(R.string.huoquyanzhengma);
                        countdownNum = 60;
                        flag=false;
                    }
                    break;
            }
        }
    };

    @Override
    public void initContentView() {
        setContentView(R.layout.act_changepassword);
        ButterKnife.bind(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {
        textViewObtain.setOnClickListener(this);
        textViewComplete.setOnClickListener(this);
        topBar.setListener(new TopBar.ClickEvent() {
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

    }

    @Override
    public void initLoad() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.textview_changepassword_getcode:

//                countdownNum = 60;
//                textViewObtain.setClickable(false);
//                textViewObtain.setText("倒数" + countdownNum + "秒");
//                countdownFlag = true;
//                countdown();

                HttpGP.sendOkhttpGetRequest(Constant.NEWBASEURL + Constant.CHANGE_PASSWORD_VERIFY_CODE,
                        new Callback() {
                            @Override
                            public void onFailure(Call call, IOException e) {
                                ToastUtils.showToast(ChangePasswordActivity.this, R.string.wangluolianjieshibai);
                            }

                            @Override
                            public void onResponse(Call call, Response response) throws IOException {
                                String str = response.body().string();
                                try {
                                    JSONObject jsonObject = new JSONObject(str);
                                    final String state = jsonObject.getString("state");
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            if (state.equals("200")) {
                                                ToastUtils.showToast(ChangePasswordActivity.this, R.string.huoquchenggong);
                                                textViewObtain.setClickable(false);
                                                textViewObtain.setText("倒数" + countdownNum  + "秒");
                                                countdownFlag = true;
                                                countdown();

                                            } else {
                                                ToastUtils.showToast(ChangePasswordActivity.this, R.string.huoqushibai);
                                            }
                                        }
                                    });
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }, this);
                ToastUtils.showToast(ChangePasswordActivity.this, R.string.yitijiao);

                break;
            case R.id.textview_changepassword_complete:
                if (checkInput()) {
                    atrList();
                    LoginHttp.LoginListener listener = new LoginHttp.LoginListener() {
                        @Override
                        public void loginInfo(final LoginBean bean) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    ToastUtils.showToast(ChangePasswordActivity.this, bean.getError() + "---" + bean.getState());

                                }
                            });
                        }
                    };
                    LoginHttp loginHttp = new LoginHttp(listener, this);
                    loginHttp.senLoginRequest(Constant.NEWBASEURL + Constant.CHANGE_PASSWORD, map, 3);
                }

                break;
        }
    }


    /**
     * 请求验证码倒计时
     */
    private void countdown() {
        new Thread() {
            @Override
            public void run() {
                while (countdownFlag) {
                    try {
                        Thread.sleep(1000);
                        Message msg = Message.obtain();
                        msg.what = 1;
                        handler.sendMessage(msg);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    /**
     * 检测参数是否符合修改密码要求
     */
    private boolean checkInput() {
        oldPass = editTextOld.getText().toString().trim();
        newPass1 = editTextNew1.getText().toString().trim();
        String newPass2 = editTextNew2.getText().toString().trim();
        verrify = editTextVerify.getText().toString().trim();
        if (oldPass.equals("") || newPass1.equals("") || newPass2.equals("")) {
            ToastUtils.showToast(this, R.string.btxbnwk);
        } else if (verrify.equals("")) {//判断验证码是否输入为空
            ToastUtils.showToast(this, R.string.yzmsrcw);
        } else if (!newPass1.equals(newPass2)) {
            ToastUtils.showToast(this, R.string.xmmlcsrbyz);
        } else if (oldPass.equals(newPass1)) {
            ToastUtils.showToast(this, R.string.xmmbngymmyz);
        } else if (newPass1.length() < 6) {
            ToastUtils.showToast(this, R.string.mmcdbyxylw);
        } else if (newPass1.length() > 16) {
            ToastUtils.showToast(this, R.string.mmcdbydyslw);
        } else if (allNum(newPass1)) {
            ToastUtils.showToast(this, R.string.mmbxwzmyszdzh);
        } else {//提交修改密码请求
            ToastUtils.showToast(this, R.string.mmxgqqytj);
            return true;
        }

        return false;
    }

    /**
     * 修改密码请求参数
     */
    private void atrList() {
        map = new HashMap<>();
        map.put("old_pwd", MD5Utils.md5(oldPass));
        map.put("new_pwd", MD5Utils.md5(newPass1));
        map.put("verify_code", verrify);

    }

    /**
     * 判断密码是否为纯数字
     */
    private boolean allNum(String pass) {
        try {
            Double.parseDouble(pass);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        countdownFlag = false;
    }
}

