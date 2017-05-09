package dingw.com.newversion;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import dingw.com.newversion.bean.LoginBean;
import dingw.com.newversion.developkit.AutoBindUnbind;
import dingw.com.newversion.activity.LoginActivity;

public class MainActivity extends AppCompatActivity {
    /**引导页面延迟时间*/
    private long time=1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
/**--------------------------------------自动绑定设备(需删除)-------------------------------------*/
        AutoBindUnbind bind=new AutoBindUnbind(this);
        bind.bindDevice();
/**-------------------------------------------------------------------------------------------------*/
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        Log.e("TAG", "onCreate:displayMetrics.density ------"+displayMetrics.density+"displayMetrics.densityDpi-----"+displayMetrics.densityDpi );
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
                MainActivity.this.finish();
            }
        },time);

//-----------------------------------------------------------------------------------------------------------
//        Gson gson= new  GsonBuilder()
//                .create();
//        LoginBean loginBean=new LoginBean();
//        loginBean.setError("206");
//        loginBean.setId("111");
//        loginBean.setName("李五");
//        loginBean.setTemp(new String[]{"11","22","33"});
//        String json=gson.toJson(loginBean);
//        Log.e("TAG", "onCreate: ----------"+json );
//        Log.e("TAG", "onCreate: ----------"+json.indexOf(",") );
//        Log.e("TAG", "onCreate: ----------"+"{"+json.substring(json.indexOf(",")+1));
//        for(String str:json.split(",")){
//            Log.e("TAG", "onCreate: ----------"+str);
//        }
//
//
//        String jsonstring="{\"Error123\":\"\",\"id\":\"111\",\"name\":\"李五\"}";
//        Log.e("TAG", "onCreate: "+jsonstring.indexOf(",") );
//        LoginBean login=null;
//        try {
//            login=gson.fromJson(jsonstring,LoginBean.class);
//        }catch (JsonSyntaxException e){
//            Log.e("TAG", "onCreate: ---1111-----"+e.getMessage() );
//            try {
//                JSONObject js=new JSONObject(jsonstring);
//                Log.e("TAG", "onCreate: ---2222-----" );
//                login=new LoginBean();
//                login.setError(js.getString("Error123"));
//
//            } catch (JSONException e1) {
//                Log.e("TAG", "onCreate:--"+e1.getMessage() );
//                Log.e("TAG", "onCreate:--"+e1.getLocalizedMessage() );
//                Log.e("TAG", "onCreate:--"+e1.getCause() );
//                Log.e("TAG", "onCreate:--"+e1.toString() );
//
//                e1.printStackTrace();
//            }
//        }
//        Log.e("TAG", "onCreate: -----解析---"+login.getError() );
//        Log.e("TAG", "onCreate: -----解析---"+login.getName() );
//        Log.e("TAG", "onCreate: -----解析---"+login.getId() );

//        Gson gson=new Gson();
//        String json="{\n" +
//                "    \"state\": 200,\n" +
//                "    \"folder\": [\n" +
//                "        {\n" +
//                "            \"folder_uuid\": \"221e8a4d-7b39-248d-5bc0-fe2d15cf7f28\",\n" +
//                "            \"folder_field_uuid\": \"0\",\n" +
//                "            \"folder_name\": \"开始的女刊\",\n" +
//                "            \"folder_inster_time\": \"2017-01-10 10:04:30\"\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"folder_uuid\": \"790d2604-6e7f-c9dd-e2bc-ef26e7d27e35\",\n" +
//                "            \"folder_field_uuid\": \"0\",\n" +
//                "            \"folder_name\": \"沙尘暴撒娇还不错喜欢\",\n" +
//                "            \"folder_inster_time\": \"2017-01-04 10:00:10\"\n" +
//                "        }\n" +
//                "    ],\n" +
//                "    \"file\": [\n" +
//                "        {\n" +
//                "            \"file_uuid\": \"bd80c030-60e6-8e9a-20ba-49d0c368a567\",\n" +
//                "            \"file_name\": \"275335bf3ab14282(4).jpg\",\n" +
//                "            \"file_size\": \"11.83KB\",\n" +
//                "            \"file_inster_time\": \"2017-02-07 10:51:41\"\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"file_uuid\": \"7780f3a7-1998-130e-bd62-d6f0bd41c72f\",\n" +
//                "            \"file_name\": \"(4).jpg\",\n" +
//                "            \"file_size\": \"11.75KB\",\n" +
//                "            \"file_inster_time\": \"2017-01-12 11:43:25\"\n" +
//                "        }\n" +
//                "\t]\n" +
//                "        \n" +
//                "\t}";
//        FileBean fileBean=gson.fromJson(json,new TypeToken<FileBean>(){}.getType());
//        Log.e("TAG", "onCreate: --"+fileBean.getState()+"----"+fileBean.getFile().size()
//        +"-----"+fileBean.getFolder().size());
//        Log.e("TAG", "onCreate: " +fileBean.getFolder().get(1).getFolder_field_uuid());
//        Log.e("TAG", "onCreate: " +fileBean.getFolder().get(1).getFolder_name());


//-----------------------------------------------------------------------------------------------------------












    }









}
