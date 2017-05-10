package dingw.com.newversion.customview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import dingw.com.newversion.R;


/**
 * Created by 12348 on 2017/5/6 0006.
 *
 */

public class IAVview extends LinearLayout {
    private Context context;
    private float image_width;
    private float image_height;

    public IAVview(Context context) {
        this(context, null, 0);

    }

    public IAVview(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public IAVview(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initView(attrs);
    }


    @TargetApi(21)
    public IAVview(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(attrs);

    }

    private void initView(AttributeSet attrs) {
        View view=LayoutInflater.from(context).inflate(R.layout.view_iavview,this,false);
        this.addView(view);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_ivdview);
        TextView textView = (TextView) view.findViewById(R.id.tv_ivdview);

        TypedArray ta=context.obtainStyledAttributes(attrs, R.styleable.ImageAddText);
        Drawable image_background = ta.getDrawable(R.styleable.ImageAddText_image_background);
        String text_text = ta.getString(R.styleable.ImageAddText_text_text);
        int text_color = ta.getColor(R.styleable.ImageAddText_text_color, 0);
        image_width=ta.getDimension(R.styleable.ImageAddText_image_width,0);
        image_height=ta.getDimension(R.styleable.ImageAddText_image_height,0);
        ta.recycle();

        if (image_width!=0&&image_height!=0){
            LayoutParams layoutParams=new LayoutParams((int) image_width,(int) image_height);
            layoutParams.gravity= Gravity.CENTER;
            layoutParams.setMargins(0,0,0,50);//
            imageView.setLayoutParams(layoutParams);
        }


        imageView.setImageDrawable(image_background);
        textView.setTextColor(text_color);
        textView.setText(text_text);
        textView.setMaxLines(2);


    }
}
