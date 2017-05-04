package dingw.com.newversion.utils;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import dingw.com.newversion.R;

/**
 * Created by 12348 on 2017/5/2 0002.
 * dialog 辅助类
 */

public class DialogUtils {


    public static void showDialog(final Activity activity,int message,int positiveText,DialogInterface.OnClickListener listener){
        AlertDialog.Builder dialog = new AlertDialog.Builder(activity);
        dialog.setMessage(message)
                .setPositiveButton(positiveText,listener)
                .setNegativeButton(R.string.cancel1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).show();
    }
    public static void showDialog(final Activity activity,int message,int positiveText,int  title,DialogInterface.OnClickListener listener){
        AlertDialog.Builder dialog = new AlertDialog.Builder(activity);
        dialog.setMessage(message)
                .setTitle(title)
                .setPositiveButton(positiveText,listener)
                .show();
    }
}
