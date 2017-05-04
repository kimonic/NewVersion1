package dingw.com.newversion.adapter.wait;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dingw.com.newversion.R;
import dingw.com.newversion.base.CustomAdapter;
import dingw.com.newversion.bean.wait.Chatbean;
import dingw.com.newversion.gif.AnimatedGifDrawable;
import dingw.com.newversion.gif.AnimatedImageSpan;
import dingw.com.newversion.gif.SingleGif;
import dingw.com.newversion.utils.GlideImageLoader;
import dingw.com.newversion.utils.ReduceBitmapUtil;

/**
 * Created by 12348 on 2017/5/4 0004.
 *
 */

public class ChatXLVAdapter  extends BaseAdapter {
    private List<Chatbean> list;
    private Context context;
    /**
     * 左聊天布局
     */
    private static final int TYPE_ONE = 0;
    /**
     * 右聊天布局
     */
    private static final int TYPE_TWO = 1;
    /**
     * 日期布局
     */
    private static final int TYPE_THREE = 2;


    /**
     * 测试update的跟新频率
     */
    private int cou = 0;
    /**
     * 关闭update线程
     */
    private boolean upClose = true;
    /**判断listview是否在滑动----false停止状态*/
    private boolean scrollState=false;
    private String TAG="adpterchat";

    private ViewGroup viewgroup;

    public boolean isScrollState() {
        return scrollState;
    }

    public void setScrollState(boolean scrollState) {
        this.scrollState = scrollState;
    }

    public void setUpClose(boolean upClose) {
        this.upClose = upClose;
    }

//    Handler handler=new Handler();

    public ChatXLVAdapter(List<Chatbean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position-2;
    }

    @Override
    public int getItemViewType(int position) {

        switch (list.get(position).getFlag()) {
            case 1:
                return TYPE_ONE;
            case 2:
                return TYPE_TWO;
            case 3:
                return TYPE_THREE;
        }
        return TYPE_ONE;


    }

    @Override
    public int getViewTypeCount() {
        return 3;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewgroup=parent;
        View view = null;
        ViewHolder viewHolder = null;
        ViewHolder1 viewHolder1 = null;
        ViewHolder2 viewHolder2 = null;
        switch (getItemViewType(position)) {
            case TYPE_ONE://左侧聊天布局
                if (convertView == null||!(convertView.getTag() instanceof ViewHolder)) {
                    view = LayoutInflater.from(context).inflate(R.layout.xlvitem_leftchat, parent, false);
                    viewHolder = new ViewHolder();
                    viewHolder.textView1 = (TextView) view.findViewById(R.id.textview_leftchat1);
                    viewHolder.textView2 = (TextView) view.findViewById(R.id.textview_leftchat2);
                    viewHolder.imageView = (ImageView) view.findViewById(R.id.imageview_leftchat);
                    view.setTag(viewHolder);

                } else {
                    view = convertView;
                    viewHolder = (ViewHolder) view.getTag();
                }
                if(scrollState){

                }else {
                    viewHolder.textView2.setText(list.get(position).getTime());

                    // 对内容做处理
//                SpannableStringBuilder sb = handler(viewHolder.textView1,list.get(position).getTitle());
                    viewHolder.sb = handler(viewHolder.textView1,list.get(position).getTitle(),viewHolder.sb);
                    viewHolder.textView1.setText(viewHolder.sb);

                    if (list.get(position).getPhotoPath() != null) {//将相册图片作为背景展示
                        viewHolder.textView1.setText("");
                        BitmapFactory.Options options=new BitmapFactory.Options();
                        options.inJustDecodeBounds=true;
                        BitmapFactory.decodeFile(list.get(position).getPhotoPath(),options);
                        Bitmap bitmap=BitmapFactory.decodeFile(list.get(position).getPhotoPath());
                        ReduceBitmapUtil util=new ReduceBitmapUtil(bitmap);
                        Drawable drawable;
                        if (options.outWidth>648){
                            drawable=new BitmapDrawable(context.getResources(), util.scaleReduce(648f/(float) (options.outWidth),1152f/(float) (options.outHeight)));
                        }else {
                            drawable=new BitmapDrawable(context.getResources(),util.createReduce(options.outWidth,options.outHeight));
                        }
                        viewHolder.textView1.setBackground(drawable);
                    }else if (viewHolder.textView1.getBackground()!=null){
                        viewHolder.textView1.getBackground().setCallback(null);
                        viewHolder.textView1.setBackground(null);
                    }


                    GlideImageLoader.getInstance().displayCircleImage(context, list.get(position).getResId(), viewHolder.imageView);
                }



                break;
            case TYPE_TWO://右侧聊天布局
                if (convertView == null||!(convertView.getTag() instanceof ViewHolder1)) {
                    view = LayoutInflater.from(context).inflate(R.layout.xlvitem_rightchat, parent, false);
                    viewHolder1 = new ViewHolder1();
                    viewHolder1.textView1 = (TextView) view.findViewById(R.id.textview_rightchat1);
                    viewHolder1.textView2 = (TextView) view.findViewById(R.id.textview_rightchat2);
                    viewHolder1.imageView = (ImageView) view.findViewById(R.id.imageview_rightchat);
                    view.setTag(viewHolder1);

                } else {
                    view = convertView;
                    viewHolder1 = (ViewHolder1) view.getTag();
                }

                if (scrollState){//正在滚动

                }else {
                    viewHolder1.textView2.setText(list.get(position).getTime());
                    GlideImageLoader.getInstance().displayCircleImage(context, list.get(position).getResId(), viewHolder1.imageView);


                    // 对内容做处理
//                SpannableStringBuilder sb1 = handler(viewHolder1.textView1,list.get(position).getTitle());
                    viewHolder1.sb = handler(viewHolder1.textView1,list.get(position).getTitle(),viewHolder1.sb);

                    viewHolder1.textView1.setText(viewHolder1.sb);
                }

                break;
            case TYPE_THREE://日期布局
                if (convertView == null||!(convertView.getTag() instanceof ViewHolder2)) {
                    view = LayoutInflater.from(context).inflate(R.layout.xlvitem_date, parent, false);
                    viewHolder2 = new ViewHolder2();
                    viewHolder2.textView1 = (TextView) view.findViewById(R.id.textview_date);
                    view.setTag(viewHolder2);

                } else {
                    view = convertView;
                    viewHolder2 = (ViewHolder2) view.getTag();
                }
                viewHolder2.textView1.setText(list.get(position).getTime());
                break;
        }


        return view;
    }


    /**
     * 查找并展示GIF,png图片
     */
    private SpannableStringBuilder handler(final TextView gifTextView, String content, SpannableStringBuilder sq) {
        if (sq!=null){
            upClose=false;
            sq=null;

            System.gc();
        }
        SpannableStringBuilder sb = new SpannableStringBuilder(content);

        String regex = "(\\#\\[face/png/f_static_)\\d{3}(.png\\]\\#)";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(content);
        int count = 0;
        while (m.find()) {
            count++;
        }
        m.reset();
        if (count > 3) {
            while (m.find()) {
                String tempText = m.group();
                String png = tempText.substring("#[".length(), tempText.length() - "]#".length());
                Bitmap bitmap= SingleGif.getInstance(context).getGif(png);
//                try {
                sb.setSpan(new ImageSpan(context, bitmap), m.start(), m.end(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//                } catch (IOException e1) {
//                    // TODO Auto-generated catch block
//                    e1.printStackTrace();
//                }
            }
        }else {
            while (m.find()) {
                String tempText = m.group();

                try {
                    String num = tempText.substring("#[face/png/f_static_".length(), tempText.length() - ".png]#".length());
                    String gif = "face/gif/f" + num + ".gif";
                    /**
                     * 如果open这里不抛异常说明存在gif，则显示对应的gif
                     * 否则说明gif找不到，则显示png
                     * */
                    InputStream is = context.getAssets().open(gif);

                    /**---------------------------------------------------------------------*/
                    sb.setSpan(

                            new AnimatedImageSpan(new AnimatedGifDrawable(is, new AnimatedGifDrawable.UpdateListener() {
                                @Override
                                public void update() {
                                    gifTextView.postInvalidate();
                                }

                                @Override
                                public boolean stopUpdate() {
                                    if (upClose) {
                                        return true;
                                    } else {
                                        return false;
                                    }
                                }
                            },gif,context), new AnimatedImageSpan.StopRun() {
                                @Override
                                public boolean stop() {
                                    if (upClose) {
                                        return true;
                                    } else {
                                        return false;
                                    }
                                }
                            }),
                            m.start(), m.end(),
                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);


                    /**---------------------------------------------------------------------*/

                    is.close();
                } catch (Exception e) {
                    String png = tempText.substring("#[".length(), tempText.length() - "]#".length());
//                    try {
                    Bitmap bitmap= SingleGif.getInstance(context).getGif(png);
                    sb.setSpan(new ImageSpan(context, bitmap), m.start(), m.end(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//                    } catch (IOException e1) {
//                        // TODO Auto-generated catch block
//                        e1.printStackTrace();
//                    }
                    e.printStackTrace();
                }
            }
        }
        upClose=true;

        return sb;
    }


    class ViewHolder {
        TextView textView1, textView2;
        ImageView imageView;
        SpannableStringBuilder sb;
    }

    class ViewHolder1 {
        TextView textView1, textView2;
        ImageView imageView;
        SpannableStringBuilder sb;
    }

    class ViewHolder2 {
        TextView textView1;
    }
}