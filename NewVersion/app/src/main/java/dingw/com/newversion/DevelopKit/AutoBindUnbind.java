package dingw.com.newversion.DevelopKit;

import android.content.Context;
import android.provider.Settings;
import android.util.Log;

import com.github.lazylibrary.util.AppUtils;

import java.util.HashMap;
import java.util.Map;

import dingw.com.newversion.bean.LoginBean;
import dingw.com.newversion.constant.Constant;
import dingw.com.newversion.http.LoginHttp;
import dingw.com.newversion.utils.MD5Utils;
import dingw.com.newversion.utils.SaveUtils;

/**
 * Created by 12348 on 2017/4/15 0015.
 * 辅助自动绑定解绑设备
 */

public class AutoBindUnbind {

    private Context context;
    private LoginHttp loginHttp;
    private LoginHttp.LoginListener listener;
    private Map<String, String> map;

    public AutoBindUnbind(Context context) {
        this.context = context;
    }

    public void bindDevice() {
        initData();
        loginHttp = new LoginHttp(listener, context);
        loginHttp.senLoginRequest(Constant.NEWBASEURL + Constant.BIND_URL, map, 2);
    }

    public void unBindDevice() {
        initData();
        loginHttp = new LoginHttp(listener, context);
        loginHttp.senLoginRequest(Constant.NEWBASEURL + Constant.UNBIND_URL, map, 1);
    }

    public void initData() {
        map = new HashMap<String, String>();
        String android= Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
        String pwdmd5 = MD5Utils.md5("123456");
        map.put("mac_address",android);//输入参数唯一标识
//        map.put("mac_address", "14ce44b74b6cc651");//输入参数唯一标识
        map.put("pwd", pwdmd5);
        map.put("license", "123456789456789");//输入参数职业证号
        map.put("name", "李五");//输入参数姓名
        map.put("device_token", "Android");
        map.put("imei", "1212121");
        map.put("device_version", "" + AppUtils.getSDKVersion());
        listener = new LoginHttp.LoginListener() {
            @Override
            public void loginInfo(LoginBean bean) {

            }
        };
        Log.e("TAG", "initData: ---"+ android);

        saveInfo(pwdmd5);
    }

    /**
     * 存储输入信息
     */
    private void saveInfo(String pwd) {
        SaveUtils saveLoginInfo = new SaveUtils(context, "userinfo");
        saveLoginInfo.saveInfo(map);
//        saveLoginInfo.setZhiyezhenghao("123456789456789");
//        saveLoginInfo.setName("李五");
//        saveLoginInfo.setPassword(pwd);
//        saveLoginInfo.saveInfo();
    }
}
