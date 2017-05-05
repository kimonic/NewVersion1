package dingw.com.newversion.jsonparse;


import org.json.JSONException;
import org.json.JSONObject;

import dingw.com.newversion.bean.LoginBean;

/**
 * Created by 12348 on 2017/4/14 0014.
 * 登录,解绑,绑定返回json数据解析
 */

public class LoginJsonParse {
    private String jsonString;
    private LoginBean bean;

    public LoginJsonParse(String jsonString, LoginBean bean) {
        this.jsonString = jsonString;
        this.bean = bean;
    }
    public LoginBean parseJson(){
        try {
            JSONObject jsonObject=new JSONObject(jsonString);
            bean.setState(jsonObject.getString("state"));

            if (jsonObject.getString("state").equals("200")){
                bean.setState(jsonObject.getString("state"));

                if (jsonString.contains("type")){
                    bean.setType(jsonObject.getString("type"));

                    bean.setName(jsonObject.getString("name"));
                    bean.setId(jsonObject.getString("id"));

                    bean.setOffice_type(jsonObject.getString("office_type"));
                    bean.setSession_id(jsonObject.getString("session_id"));

                    JSONObject jsonObjectList=jsonObject.getJSONObject("list");

                    JSONObject jsonObjectZero=jsonObjectList.getJSONObject("0");
                    JSONObject jsonObjectOne=jsonObjectList.getJSONObject("1");


                    bean.setZero_office_name(jsonObjectZero.getString("office_name"));
                    bean.setZero_office_id(jsonObjectZero.getString("office_id"));


                    bean.setOne_office_name(jsonObjectOne.getString("office_name"));
                    bean.setOne_office_id(jsonObjectOne.getString("office_id"));
                }

            }else if (jsonObject.getString("state").equals("600")){
                bean.setState(jsonObject.getString("state"));
                bean.setError(jsonObject.getString("error"));

            } else if (jsonObject.getString("state").equals("error")) {

            }else if (jsonObject.getString("state").equals("204")){
                bean.setState(jsonObject.getString("state"));
                bean.setError(jsonObject.getString("error"));
            }





        } catch (JSONException e) {
            e.printStackTrace();
        }
        return bean;
    }
}
