package dingw.com.newversion.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by 12348 on 2017/5/2 0002.
 * toast 辅助类
 */

public class ToastUtils {
    public static void showToast(Context context,String content){
        Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
    }
    public static void showToast(Context context,int resId){
        Toast.makeText(context, resId, Toast.LENGTH_SHORT).show();
    }
}
