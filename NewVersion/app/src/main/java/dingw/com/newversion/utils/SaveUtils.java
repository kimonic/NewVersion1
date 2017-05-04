package dingw.com.newversion.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 12348 on 2017/5/2 0002.
 * 轻量级存储工具
 */

public class SaveUtils {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public SaveUtils(Context context,String filename) {
        sharedPreferences=context.getSharedPreferences(filename,Context.MODE_PRIVATE);
    }

    /**存入数据*/
    public void saveInfo(Map<String,String> map){
        editor=sharedPreferences.edit();
        for (String key:map.keySet()) {
            editor.putString(key,map.get(key));
        }
        editor.apply();
    }

    /**存入数据*/
    public void saveInfo(String key,String value){
        editor=sharedPreferences.edit();
        editor.putString(key,value);
        editor.apply();
    }
    /**存入数据*/
    public void saveInfo(String key,int value){
        editor=sharedPreferences.edit();
        editor.putInt(key,value);
        editor.apply();
    }

    /**删除所有信息*/
    public void deletAllInfo(){
        editor=sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
    /**取出数据*/
    public String getStringInfo(String key){
        return sharedPreferences.getString(key,"");
    }
    /**取出数据*/
    public Map<String,String> getManyStringInfo(String[] key){
        Map<String,String> info=new HashMap<>(2);
        for (int i = 0; i < key.length; i++) {
            info.put(key[i],sharedPreferences.getString(key[i],""));
        }
        return info;
    }


    /**取出数据*/
    public int getIntInfo(String key){
        return sharedPreferences.getInt(key,-1);
    }

}
