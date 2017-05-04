package dingw.com.newversion.http;

import android.content.Context;

import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;

/**
 * Created by 12348 on 2017/3/31 0031.
 * okhttpclient singleton
 */

public class MyOkHttpSingleton {
    public static MyOkHttpSingleton instance;
    private OkHttpClient okHttpClient;
    private Context context;



    private MyOkHttpSingleton(Context context) {
        this.context=context;
    }
    public static synchronized MyOkHttpSingleton getInstance(Context context){
        if (instance==null){
            instance=new MyOkHttpSingleton(context);
        }
        return instance;
    }


    public OkHttpClient getOkHttpClient() {
        if (okHttpClient==null){
            okHttpClient=new OkHttpClient.Builder()
                    .cache(new Cache(context.getApplicationContext().getCacheDir(), 20*1024*1024))
                    .addInterceptor(new CaheInterceptor(context.getApplicationContext()))
                    .addNetworkInterceptor(new CaheInterceptor(context.getApplicationContext()))
                    .connectTimeout(10,TimeUnit.SECONDS)
                    .build();
        }
        return okHttpClient;
    }
}
