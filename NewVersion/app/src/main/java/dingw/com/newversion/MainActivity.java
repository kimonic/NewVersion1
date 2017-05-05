package dingw.com.newversion;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;

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














    }









}
