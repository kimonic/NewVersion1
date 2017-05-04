package dingw.com.newversion.base;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by 12348 on 2017/5/2 0002.
 * activity 基类
 */

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener,BaseFunc{

    public static final String TAG = "BaseActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//强制竖屏显示
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SECURE);//禁止截屏
        initContentView();
        initData();
        initView();
        initListener();
        initLoad();
    }
    /**设置setcontentview*/
    public abstract void initContentView();

    @Override
    protected void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
    }
    /**初始化数据*/
    public abstract void initData();
    /**初始化ui控件方法*/
    public abstract void initView();
    /**初始化事件监听方法*/
    public abstract void initListener();
    /**初始化界面加载方法*/
    public  void initLoad(){

    }

    /**启动下一个activity*/
    protected void openActivity(Class<? extends BaseActivity> toActivity) {
        openActivity(toActivity, null);
    }
    /**启动下一个activity*/
    protected void openActivity(Class<? extends BaseActivity> toActivity, Bundle parameter) {
        Intent intent = new Intent(this, toActivity);
        if (parameter != null) {
            intent.putExtras(parameter);
        }
        startActivity(intent);
    }

    /**关闭activity*/
    protected void closeActivity() {
        this.finish();
    }
}
