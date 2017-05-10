package dingw.com.newversion.customview;


import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;


import java.util.ArrayList;
import java.util.List;

import dingw.com.newversion.R;


/**
 * Created by 12348 on 2017/4/20 0020.
 * 轮播图片viewpager
 */

public class MyBanner extends FrameLayout implements ViewPager.OnPageChangeListener, View.OnClickListener {


    private List<ImageView> viewPagetImages;
    private List<ImageView> dotsImages;
    private ViewPager viewPager;
    private int duration;
    private boolean autoSlide;
    private  int dotsLeft;
    private Context context;
    private int imageResId[];
    private int dotsimageResId[];
    private  int beforesel=0;
    private ItemClickListener listener;
    private AttributeSet attrs;
    private Handler  handler =new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    if ((beforesel+1)<viewPagetImages.size()){
                        viewPager.setCurrentItem(beforesel+1);
                    }else {
                        viewPager.setCurrentItem(0);
                    }
                    break;
            }
        }
    };



    public MyBanner(Context context) {
        this(context, null);
    }

    public MyBanner(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        this.attrs=attrs;
        initView();
    }

    private void initView() {

        View view = LayoutInflater.from(context).inflate(R.layout.view_banner, this, false);
        viewPager= (ViewPager) view.findViewById(R.id.viewpager_banner);
        LinearLayout linear2 = (LinearLayout) view.findViewById(R.id.linearlayout_banner2);
        addView(view);
        readInitData();
        viewPagetImages=new ArrayList<ImageView>();
        dotsImages=new ArrayList<ImageView>();

        for (int i = 0; i < imageResId.length; i++) {
            ImageView imageView = new ImageView(context);
            imageView.setImageResource(imageResId[i]);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            LayoutParams params2 = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
            imageView.setLayoutParams(params2);
            imageView.setTag(i);//设置标记
            imageView.setOnClickListener(this);
            viewPagetImages.add(imageView);
        }
        MyAdpter adapter = new MyAdpter();
        viewPager.setAdapter(adapter);

        for (int i = 0; i < imageResId.length; i++) {
            ImageView imageView=new ImageView(context);
            if (i==0){
                imageView.setImageResource(dotsimageResId[0]);
            }else {
                imageView.setImageResource(dotsimageResId[1]);
            }
            LayoutParams params3=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
            if (i!=0){
                imageView.setPadding(dotsLeft,0,0,0);
            }
            imageView.setLayoutParams(params3);
            imageView.setTag(i+10);//设置标记----------------------------
            imageView.setOnClickListener(this);
            linear2.addView(imageView);
            dotsImages.add(imageView);
        }

        viewPager.setOnPageChangeListener(this);//设置监听

        startAutoSlide();

    }
    private void readInitData() {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyBanner);

        int arrayId1=typedArray.getResourceId(R.styleable.MyBanner_resid_imagearray,0);
        TypedArray ty1=context.getResources().obtainTypedArray(arrayId1);
        imageResId=new int[ty1.length()];
        for (int i = 0; i < ty1.length(); i++) {
            imageResId[i]=ty1.getResourceId(i,0);
        }
        ty1.recycle();

        int arrayId2=typedArray.getResourceId(R.styleable.MyBanner_resid_dotsarray,0);
        TypedArray ty2=context.getResources().obtainTypedArray(arrayId2);
        dotsimageResId=new int[ty2.length()];
        for (int i = 0; i < ty2.length(); i++) {
            dotsimageResId[i]=ty2.getResourceId(i,0);
        }
        ty2.recycle();

        duration=typedArray.getInt(R.styleable.MyBanner_duration,3000);
        autoSlide=typedArray.getBoolean(R.styleable.MyBanner_autoslide,true);
        dotsLeft=typedArray.getInt(R.styleable.MyBanner_dotsleft,15);

        typedArray.recycle();
    }

    @Override
    public void onClick(View v) {
        if(listener!=null){
            listener.clickEvent((Integer) v.getTag());
        }
        if ((Integer)(v.getTag())>9){

            viewPager.setCurrentItem((Integer)(v.getTag())-10);
        }
    }

    public interface ItemClickListener{
        void clickEvent(int i);
    }

    public void startAutoSlide(){
        new Thread(){
            @Override
            public void run() {
                while (isAutoSlide()){
                    try {
                        Thread.sleep(duration);
                        Message msg=Message.obtain();
                        msg.what=1;
                        handler.sendMessage(msg);
                        if (((Activity)context).isFinishing()){//所依附的activity销毁时,终止线程
                            setAutoSlide(false);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }.start();

    }
    public void setListener(ItemClickListener listener) {
        this.listener = listener;
    }

    public void setDotsLeft(int dotsLeft) {
        this.dotsLeft = dotsLeft;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }

    public boolean isAutoSlide() {
        return autoSlide;
    }
    public void setAutoSlide(boolean autoSlide) {
        this.autoSlide = autoSlide;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        changeDots(true,position);
        changeDots(false,beforesel);
        beforesel=position;
    }



    @Override
    public void onPageScrollStateChanged(int state) {

    }
    private void changeDots(boolean state,int position) {
        if (state){
            dotsImages.get(position).setImageResource(dotsimageResId[0]);
        }else {
            dotsImages.get(position).setImageResource(dotsimageResId[1]);
        }
    }

    class MyAdpter extends PagerAdapter {

        @Override
        public int getCount() {
            return viewPagetImages.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(viewPagetImages.get(position));
            return viewPagetImages.get(position);
        }

        @Override
        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }
    }
}