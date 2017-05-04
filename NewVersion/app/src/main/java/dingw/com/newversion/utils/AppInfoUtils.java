package dingw.com.newversion.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

/**
 * Created by 12348 on 2017/4/14 0014.
 * app信息相关操作
 */

public class AppInfoUtils {

    private static String TAG="apputils";
    /**无法获取wlan0/adress下的地址,返回值为空*/
    public static String getMac() {
        String macSerial = "";
        try {
            Process pp = Runtime.getRuntime().exec(
                    "cat /sys/class/net/eth0/address");
            InputStreamReader ir = new InputStreamReader(pp.getInputStream());
            LineNumberReader input = new LineNumberReader(ir);

            String line;
            while ((line = input.readLine()) != null) {
                macSerial += line.trim();
            }

            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return macSerial;
    }

    /**获得手机设备的mac地址1111111111111111*/
    public static String getMacAddress() {
        String result = "";
        String Mac = "";
        result = callCmd("busybox ifconfig", "HWaddr");
        Log.e(TAG, "getMacAddress: ----" +result);
        if (result == null) {
            return "网络出错，请检查网络";
        }
        if (result.length() > 0 && result.contains("HWaddr")) {
            Mac = result.substring(result.indexOf("HWaddr") + 6, result.length() - 1);
            if (Mac.length() > 1) {
                result = Mac.toLowerCase();
            }
        }
        return result.trim();
    }

    /**获得手机设备的mac地址22222222222222222222*/
    public static String callCmd(String cmd,String filter) {
        String result = "";
        String line = "";
        try {
            Process proc = Runtime.getRuntime().exec(cmd);
            InputStreamReader is = new InputStreamReader(proc.getInputStream());
            BufferedReader br = new BufferedReader (is);

            //执行命令cmd，只取结果中含有filter的这一行
            while ((line = br.readLine ()) != null && line.contains(filter)== false) {
//            while ((line = br.readLine ()) != null ) {
//                result += line;
            }
            result = line;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    /**
     * 获取App版本码
     *
     * @param context     上下文
     * @return App版本码
     */
    public static int getAppVersionCode(Context context) {
        if (isSpace(context.getPackageName())) return -1;
        try {
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);
            return pi == null ? -1 : pi.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return -1;
        }
    }
    private static boolean isSpace(String s) {
        if (s == null) return true;
        for (int i = 0, len = s.length(); i < len; ++i) {
            if (!Character.isWhitespace(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    /**
     * 获取手机品牌
     *
     * @return
     */
    public static String getPhoneName() {
        return Build.MANUFACTURER;
    }


    /**
     * 获取手机品牌型号
     *
     * @return
     */
    public static String getPhoneVersion() {
        return Build.MODEL;
    }


    /**
     * 获取手机系统版本号
     *
     * @return
     */
    public static String getPhoneSystemVersion() {
        return Build.VERSION.RELEASE;
    }
}
