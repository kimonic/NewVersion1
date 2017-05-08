package dingw.com.newversion.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 12348 on 2017/5/3 0003.
 * fragment 基类
 */

public abstract class BaseFragment extends Fragment implements BaseFunc,View.OnClickListener {
    private View view;
    private ViewGroup container;
    private LayoutInflater inflater;
    private int resId;
    Unbinder unbinder;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.container=container;
        this.inflater=inflater;
        this.resId=setResid();
        initContentView();
        initData();
        initView();
        initListener();
        initLoad();
        return view;
    }
    @Override
    public View getView() {
        return view;
    }

    /**设置布局文件*/
    public abstract int setResid();

    @Override
    public void initContentView() {
        if (resId!=0){
            view=inflater.inflate(resId,container,false);
        }
        if (getView()!=null){
            unbinder = ButterKnife.bind(this, getView());
        }

    }
    /**启动下一个activity*/
    protected void openActivity(Class<? extends BaseActivity> toActivity) {
        openActivity(toActivity, null);
    }

    /**启动下一个activity*/
    protected void openActivity(Class<? extends BaseActivity> toActivity, Bundle parameters) {
        Intent intent = new Intent(getActivity(), toActivity);
        if (parameters != null) {
            intent.putExtras(parameters);
        }
        startActivity(intent);
    }
    /**关闭activity*/
    protected void closeActivity(){
        if (getActivity()!=null){
            getActivity().finish();
        }
    }
    /**获取当前系统时间*/
    public String getTime() {
        return new SimpleDateFormat("MM-dd HH:mm", Locale.CHINA).format(new Date());
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


}
