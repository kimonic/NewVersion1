package dingw.com.newversion.customview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import dingw.com.newversion.R;

/**
 * Created by 12348 on 2017/5/2 0002.
 * 顶部标题栏
 */

public class TopBar extends LinearLayout implements View.OnClickListener {

    private TextView tvText,tvFinish,tvAdd;
    /**左侧button背景图片*/
    private Drawable leftBackground;
    /**右侧button背景图片*/
    private Drawable rightBackground;
    /**中间文字*/
    private String centerText;
    /**中间文字颜色*/
    private int centerTextColor;
    /**中间文字大小*/
    private float centerTextSize;

//    /**topbar高度*/
//    private int height;


    /**点击事件回调接口*/
    private ClickEvent listener;

    public interface ClickEvent{
        void tvfinishClick();
        void tvtextClick();
        void tvaddClick();
    }


    public TopBar(Context context) {
        this(context, null, 0);
    }

    public TopBar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TopBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);

    }

    @TargetApi(21)
    public TopBar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context,attrs);
    }

    private void initView(Context context,AttributeSet attrs) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_topbar, this,false);
        this.addView(view);

        tvAdd= (TextView) view.findViewById(R.id.tv_add);
        tvFinish= (TextView) view.findViewById(R.id.tv_finish);
        tvText= (TextView) view.findViewById(R.id.tv_text);

        TypedArray ta=context.obtainStyledAttributes(attrs,R.styleable.Topbar);//取出attrs中的属性值
        leftBackground=ta.getDrawable(R.styleable.Topbar_leftBackground);
        centerText=ta.getString(R.styleable.Topbar_centerText);
        centerTextColor=ta.getColor(R.styleable.Topbar_centerTextColor,-1);
        centerTextSize=ta.getDimension(R.styleable.Topbar_centerTextSize,-1);
        rightBackground=ta.getDrawable(R.styleable.Topbar_rightBackground);

        ta.recycle();
        setBack(tvFinish,leftBackground);
        setBack(tvAdd,rightBackground);
        if (centerText!=null){
            tvText.setText(centerText);
        }
        if (centerTextColor!=-1){
            tvText.setTextColor(centerTextColor);
        }
        if (centerTextSize!=-1){
            tvText.setTextSize(centerTextSize);
        }



        tvFinish.setOnClickListener(this);
        tvText.setOnClickListener(this);
        tvAdd.setOnClickListener(this);
//        height= ScreenUtils.getDensityDpi(context)/160*50;//50dp转化为像素
//        LayoutParams params=new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,height);
//        this.setLayoutParams(params);
    }
    /**设置图片背景*/
    private void setBack(TextView tv, Drawable drawable) {
        if (drawable!=null){
            if (Build.VERSION.SDK_INT>15){
                tv.setBackground(drawable);
            }else {
                tv.setBackgroundDrawable(drawable);
            }
        }
    }

    public void setListener(ClickEvent listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if (listener!=null){
            switch (v.getId()){
                case R.id.tv_text:
                    listener.tvtextClick();
                    break;
                case R.id.tv_finish:
                    listener.tvfinishClick();
                    break;
                case R.id.tv_add:
                    listener.tvaddClick();
                    break;
            }
        }
    }

    /**设置中间文本*/
    public void setTvText(String content){
        tvText.setText(content);
    }
    /**获得中间文本内容*/
    public String getTvText(){
        return tvText.getText().toString();
    }
    /**设置中间文本*/
    public void setTvText(int resId){
        tvText.setText(resId);
    }
    /**设置右边文本*/
    public void setTvAdd(String content){
        if (Build.VERSION.SDK_INT>15){
            tvAdd.setBackground(null);
        }else {
            tvAdd.setBackgroundDrawable(null);
        }
        tvAdd.setText(content);
    }
    /**设置add按钮是否隐藏*/
    public void setTvAddVis(boolean gv){
        if (gv){
            tvAdd.setVisibility(GONE);
        }else {
            tvAdd.setVisibility(VISIBLE);
        }

    }
}
