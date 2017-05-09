package dingw.com.newversion.jsonparse;


import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import dingw.com.newversion.base.BaseBean;
import dingw.com.newversion.bean.work.FileRepositoryBean;

/**
 * Created by 12348 on 2017/3/30 0030.
 * 本地文件库json数据解析
 */

public class LocalFileRepositoryJsonParse {
    private String jsonString;
    private List<BaseBean> list;

    public LocalFileRepositoryJsonParse(String jsonString, List<BaseBean> list) {
        this.jsonString = jsonString;
        this.list = list;
    }

    public void getParseJson() {
        Gson gson = new Gson();
        Log.e("TAG", "getParseJson: ----"+jsonString );

        try {
            JSONObject jsonso = new JSONObject(jsonString);
            if (jsonso.getInt("state") == 200) {
                JSONArray json1 = null;
                JSONArray json2 = null;
                if (jsonString.contains("\"folder\":[")) {
                    json1 = jsonso.getJSONArray("folder");
                    if (json1.length() > 0) {
                        for (int i = 0; i < json1.length(); i++) {
                            FileRepositoryBean fileRepositoryBean = gson.fromJson(json1.get(i).toString(), FileRepositoryBean.class);
                            list.add(fileRepositoryBean);
                        }
                    }
                } else if (jsonString.contains("\"folder\"")) {
                    FileRepositoryBean fileRepositoryBean = gson.fromJson(jsonso.toString(), FileRepositoryBean.class);
                    list.add(fileRepositoryBean);
                }
                if (jsonString.contains("\"file\":[")) {
                    json2 = jsonso.getJSONArray("file");
                    if (json2.length() > 0) {
                        for (int i = 0; i < json2.length(); i++) {
                            FileRepositoryBean fileRepositoryBean = gson.fromJson(json2.get(i).toString(), FileRepositoryBean.class);
                            list.add(fileRepositoryBean);
                        }
                    }
                } else if (jsonString.contains("\"file\"")) {
                    FileRepositoryBean fileRepositoryBean = gson.fromJson(jsonso.toString(), FileRepositoryBean.class);
                    list.add(fileRepositoryBean);
            }

        }
    } catch(
    JSONException e)

    {
        e.printStackTrace();
    }

//        try {
//            JSONObject jsonso=new JSONObject(jsonString);
//            if (jsonso.getInt("state")==200){
//                JSONArray json1=null;
//                JSONArray json2=null;
//                if (jsonString.contains("\"folder\":[")) {
//                    json1 = jsonso.getJSONArray("folder");
//                    if (json1.length()>0){
//                        for (int i = 0; i < json1.length(); i++) {
//                            FileRepositoryBean fileRepositoryBean=new FileRepositoryBean();
//                            JSONObject jsonObject= (JSONObject) json1.get(i);
//                            fileRepositoryBean.setFolder_inster_time( jsonObject.getString("folder_inster_time"));
//                            fileRepositoryBean.setFolder_name(jsonObject.getString("folder_name"));
//                            fileRepositoryBean.setFolder_field_uuid( jsonObject.getString("folder_field_uuid"));
//                            fileRepositoryBean.setFolder_uuid( jsonObject.getString("folder_uuid"));
//                            list.add(fileRepositoryBean);
//                        }
//                    }
//                }else if (jsonString.contains("\"folder\"")){
//                    FileRepositoryBean fileRepositoryBean=new FileRepositoryBean();
//                    fileRepositoryBean.setFolder_inster_time( jsonso.getString("folder_inster_time"));
//                    fileRepositoryBean.setFolder_name(jsonso.getString("folder_name"));
//                    fileRepositoryBean.setFolder_field_uuid( jsonso.getString("folder_field_uuid"));
//                    fileRepositoryBean.setFolder_uuid( jsonso.getString("folder_uuid"));
//                    list.add(fileRepositoryBean);
//                }
//               if (jsonString.contains("\"file\":[")){
//                json2 =jsonso.getJSONArray("file");
//                   if (json2.length()>0){
//                       for (int i = 0; i < json2.length(); i++) {
//                           FileRepositoryBean fileRepositoryBean1=new FileRepositoryBean();
//                           JSONObject jsonObject1= (JSONObject) json2.get(i);
//                           fileRepositoryBean1.setFile_name(jsonObject1.getString("file_name"));
//                           fileRepositoryBean1.setFile_uuid(jsonObject1.getString("file_uuid"));
//                           fileRepositoryBean1.setFile_size(jsonObject1.getString("file_size"));
//                           fileRepositoryBean1.setFile_inster_time(jsonObject1.getString("file_inster_time"));
//                           list.add(fileRepositoryBean1);
//                       }
//                   }
//                  }else if (jsonString.contains("\"file\"")){
//                   FileRepositoryBean fileRepositoryBean1=new FileRepositoryBean();
//                   fileRepositoryBean1.setFile_name(jsonso.getString("file_name"));
//                   fileRepositoryBean1.setFile_uuid(jsonso.getString("file_uuid"));
//                   fileRepositoryBean1.setFile_size(jsonso.getString("file_size"));
//                   fileRepositoryBean1.setFile_inster_time(jsonso.getString("file_inster_time"));
//                   list.add(fileRepositoryBean1);
//               }
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
}
}
