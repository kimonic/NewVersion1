package dingw.com.newversion.customview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import dingw.com.newversion.R;

/**
 * Created by 12348 on 2017/5/10 0010.
 * 图片加文字视图,左边图片右边文字
 */

public class IAVview_Horizontal extends LinearLayout {
    /**textview文本内容*/
    private String textContent;
    /**textview文字大小*/
    private float textSize;
    /**textview文字颜色*/
    private int textColor;
    /**imageview图片资源*/
    private Drawable res;
    /**imageview图片宽度*/
    private float width;
    /**imageview图片高度*/
    private float height;
    public IAVview_Horizontal(Context context) {
        this(context, null,0);
    }

    public IAVview_Horizontal(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public IAVview_Horizontal(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context,attrs);
    }



    @TargetApi(21)
    public IAVview_Horizontal(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context,attrs);
    }

    private void initView(Context context,AttributeSet attrs) {
        View view=LayoutInflater.from(context).inflate(R.layout.view_iavview_horizontal,this,false);
        TextView textView= (TextView) view.findViewById(R.id.tv_iavhorizontal);
        ImageView imageView= (ImageView) view.findViewById(R.id.iv_iavhorizontal);

        TypedArray ta=context.obtainStyledAttributes(attrs,R.styleable.ImageAddText_Horizontal);

        textContent=ta.getString(R.styleable.ImageAddText_Horizontal_it_text);
        textColor=ta.getColor(R.styleable.ImageAddText_text_color,0);
        textSize=ta.getDimension(R.styleable.ImageAddText_Horizontal_it_textsize,0);
        res=ta.getDrawable(R.styleable.ImageAddText_Horizontal_it_background);


        ta.recycle();

        textView.setText(textContent);
        if (textColor!=0){
            textView.setTextColor(textColor);
        }
        if (textSize!=0){
            textView.setTextSize(textSize);
        }

        imageView.setBackground(res);

        this.addView(view);




    }
}
