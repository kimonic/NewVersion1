package dingw.com.newversion.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Created by 12348 on 2017/3/24 0024.
 * 自定义跑马灯效果textview
 */

public class MarqueeText extends AppCompatTextView implements Runnable{
    private int currentScrollX;// 当前滚动的位置
    private boolean isStop = false;//是否停止,true--停止,false--不停止
    private int textWidth;//文字的宽度
    private boolean focusFlag=true;
    private boolean isMeasure = false;//控制文字宽度的获取次数,只需要获取一次

    public MarqueeText(Context context) {//继承构造方法
        super(context);
    }

    public MarqueeText(Context context, AttributeSet attrs) {//继承构造方法
        super(context, attrs);
    }

    public MarqueeText(Context context, AttributeSet attrs, int defStyleAttr) {//继承构造方法
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {//重写方法绘制文字
        super.onDraw(canvas);
        if (!isMeasure) {// 文字宽度只需获取一次就可以了
            getTextWidth();//本类的自写方法
            isMeasure = true;
        }

    }

    @Override
    public boolean isFocused() {
        if (focusFlag){
            focusFlag=false;
            return true;
        }
        return false;
    }

    private void getTextWidth() {//获得文字宽度
        Paint paint = this.getPaint();
        String str = this.getText().toString();//获得文本内容
        textWidth = (int) paint.measureText(str);
    }


    @Override
    public void run() {//线程
        currentScrollX += 2;// 滚动速度,可根据需要更改
        scrollTo(currentScrollX, 0);//滚动的位置
        if (isStop) {//为true时终止线程
            return;
        }
        if (getScrollX() <= -(this.getWidth())) {
            scrollTo(textWidth, 0);
            currentScrollX = textWidth;
// return;
        }
        postDelayed(this, 25);//暂停5ms

        if (currentScrollX>textWidth-100){
            currentScrollX=0;//显示第一个字符的位置,赋值标识显示在textView的最左边的右方
        }
    }
    // 开始滚动
    public void startScroll() {//开始滚动
        isStop = false;
        focusFlag=true;
        this.removeCallbacks(this);
        post(this);
    }
    // 停止滚动
    public void stopScroll() {//停止滚动

        focusFlag=false;
        isStop = true;
    }
    // 从头开始滚动
    public void startFor0() {//从初始位置开始滚动
        currentScrollX = 0;
        startScroll();
    }
}
