package dingw.com.newversion.jsonparse;

import android.content.Context;
import android.util.Log;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import dingw.com.newversion.bean.wait.NoticeBean;
import dingw.com.newversion.bean.wait.NoticeDetailsBean;

/**
 * Created by 12348 on 2017/4/2 0002.
 * 工作---本所公告解析json数据,详情解析
 */

public class NoticeJsonParse {

    private String jsonString;
    private List list;//不约束类型
    private Context context;
    private String TAG="wait_notice and details";

    public NoticeJsonParse(String jsonString, List list, Context context) {
        this.jsonString = jsonString;
        this.list = list;
        this.context=context;
    }


    public void getParseJson(){
        JSONObject jsonObject;
        try {
            jsonObject=new JSONObject(jsonString);
            JSONArray jsonArray=jsonObject.getJSONArray("officeoa_list");
            for (int i = 0; i < jsonArray.length(); i++) {
                NoticeBean noticeBean=new NoticeBean();
                noticeBean.setId(((JSONObject)jsonArray.get(i)).getString("id"));
                noticeBean.setTitle(((JSONObject)jsonArray.get(i)).getString("title"));
                noticeBean.setCreate_time(((JSONObject)jsonArray.get(i)).getString("create_time"));
                noticeBean.setClassify(((JSONObject)jsonArray.get(i)).getString("classify"));
                noticeBean.setNum(((JSONObject)jsonArray.get(i)).getString("num"));
                noticeBean.setRead_type(((JSONObject)jsonArray.get(i)).getString("read_type"));
               JSONArray name=((JSONObject)jsonArray.get(i)).getJSONArray("lawyer_name");
                String nameTotal="";
                for (int j = 0; j <name.length() ; j++) {
                    nameTotal+=name.get(j)+"  ";
                }

                noticeBean.setLawyer_name(nameTotal);
                list.add(noticeBean);
            }

        } catch (JSONException e) {
            Log.e(TAG, "getParseJson: 解析json数据出错");
            e.printStackTrace();
        }
    }


    public void getParseJsonDetails(){
        JSONObject jsonObject;
        try {
            jsonObject=new JSONObject(jsonString);

            JSONObject jsonObject1=jsonObject.getJSONObject("officeoa_details");
            NoticeDetailsBean noticeDetailsBean=new NoticeDetailsBean();
            noticeDetailsBean.setTitle(jsonObject1.getString("title"));
            noticeDetailsBean.setContent(jsonObject1.getString("content"));
            noticeDetailsBean.setCreate_time(jsonObject1.getString("create_time"));
            noticeDetailsBean.setNum(jsonObject1.getString("num"));
            noticeDetailsBean.setLawyer_name(jsonObject1.getString("lawyer_name"));

            list.add(noticeDetailsBean);

        } catch (JSONException e) {
            e.printStackTrace();
            Log.e(TAG, "getParseJson: 解析json数据出错");
        }

    }
}
