package dingw.com.newversion.adapter.wait;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import dingw.com.newversion.R;
import dingw.com.newversion.base.BaseBean;
import dingw.com.newversion.base.CustomAdapter;
import dingw.com.newversion.bean.wait.NewsBean;
import dingw.com.newversion.utils.GlideImageLoader;

/**
 * Created by 12348 on 2017/5/4 0004.
 *
 * 主页--待办--email图标点击---消息fragment  xlistview adapter
 */

public class NewsXLVAdapter extends CustomAdapter {

    public NewsXLVAdapter(Context context, List<BaseBean> list) {
        super(context, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder viewHolder;
        if (convertView==null){
            view= LayoutInflater.from(context).inflate(R.layout.xlvitem_news,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.textView1= (TextView) view.findViewById(R.id.textview_fragnewsitem1);
            viewHolder.textView2= (TextView) view.findViewById(R.id.textview_fragnewsitem2);
            viewHolder.imageView= (ImageView) view.findViewById(R.id.imageview_fragnewsitem);
            view.setTag(viewHolder);
        }else {
            view=convertView;
            viewHolder= (ViewHolder) view.getTag();
        }
        viewHolder.textView1.setText(((NewsBean)list.get(position)).getName());
        viewHolder.textView2.setText(((NewsBean)list.get(position)).getState());
        GlideImageLoader.getInstance().displayCircleImage(context,((NewsBean)list.get(position)).getResId(),viewHolder.imageView);



        return view;
    }
    class ViewHolder{
        TextView textView1,textView2;
        ImageView imageView;
    }
}
