package dingw.com.newversion.http;

import android.content.Context;
import android.util.Log;


import java.io.IOException;
import java.util.Map;

import dingw.com.newversion.bean.LoginBean;
import dingw.com.newversion.jsonparse.LoginJsonParse;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


/**
 * Created by 12348 on 2017/4/14 0014.
 * 登录--绑定--解绑
 */

public class LoginHttp {

    /**
     * 回调接口
     */
    public interface LoginListener {
        void loginInfo(LoginBean bean);
    }

    private LoginListener listener;
    private Context context;

    public LoginHttp(LoginListener listener, Context context) {
        this.listener = listener;
        this.context = context;
    }

    /**
     * 发送登录--解绑--绑定请求
     *
     * @param url       发送url
     * @param paramsMap 请求参数map
     * @param flag      是绑定解绑还是登录的标志
     */
    public void senLoginRequest(final String url, final Map<String, String> paramsMap, final int flag) {
        new Thread() {
            @Override
            public void run() {
                OkHttpClient client = MyOkHttpSingleton.getInstance(context).getOkHttpClient();
                FormBody.Builder builder = new FormBody.Builder();
                for (String key : paramsMap.keySet()) {
                    builder.add(key, paramsMap.get(key));
                }

                RequestBody formBody = builder.build();
                String requestUrl = url;
                final Request request = new Request.Builder().url(requestUrl).post(formBody).build();
                final Call call = client.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        LoginBean bean = new LoginBean();
                        listener.loginInfo(bean);//回调bean
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String jsonStr = response.body().string();
                        Log.e("TAG", "response ----->" + jsonStr);
                        LoginBean bean = new LoginBean();

                        LoginJsonParse parse = new LoginJsonParse(jsonStr, bean);
                        parse.parseJson();
                        listener.loginInfo(bean);//回调bean
                    }
                });

            }
        }.start();
    }
}
