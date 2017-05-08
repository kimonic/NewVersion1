package dingw.com.newversion.http;

import android.content.Context;
import android.util.Log;

import java.io.IOException;
import java.util.Map;

import dingw.com.newversion.bean.OkHttpPostBean;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by 12348 on 2017/5/8 0008.
 */

public class HttpGP {
    private static String TAG="httputils";
    /**
     * 回调接口
     */
    public interface HttpGPListener {
        void postInfo(OkHttpPostBean bean);
    }


    /**发送http  get请求*/
    public static void sendOkhttpGetRequest(String adress, Callback callback, Context context){
        OkHttpClient client= MyOkHttpSingleton.getInstance(context).getOkHttpClient();
        Request request= new Request.Builder()
                .url(adress)
                .build();
        client.newCall(request).enqueue(callback);
    }
    /**发送http post请求    返回响应字符串*/
    public static void sendOkhttpPostRequest(final String url, final Map<String, String> paramsMap, final Context context, final HttpGPListener listener){
        final Context context1=context.getApplicationContext();
        new Thread(){
            @Override
            public void run() {
                OkHttpClient client = MyOkHttpSingleton.getInstance(context1).getOkHttpClient();
                FormBody.Builder builder = new FormBody.Builder();
                for (String key:paramsMap.keySet()){
                    builder.add(key,paramsMap.get(key));
                }
                RequestBody formBody = builder.build();
                String requestUrl = url;
                final Request request = new Request.Builder().url(requestUrl).post(formBody).build();
                final Call call = client.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        OkHttpPostBean bean=new OkHttpPostBean();
                        listener.postInfo(bean);//回调bean
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String jsonStr=response.body().string();
                        Log.e(TAG, "response ----->" + jsonStr);
                        OkHttpPostBean bean=new OkHttpPostBean();
                        bean.setResponseStr(jsonStr);
                        listener.postInfo(bean);//回调bean
                    }
                });

            }
        }.start();
    }

}
