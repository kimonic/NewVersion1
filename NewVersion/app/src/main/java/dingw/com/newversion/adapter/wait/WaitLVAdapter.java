package dingw.com.newversion.adapter.wait;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import dingw.com.newversion.R;
import dingw.com.newversion.base.CustomAdapter;
import dingw.com.newversion.bean.wait.ListViewBean;
import dingw.com.newversion.customview.MarqueeText;

/**
 * Created by 12348 on 2017/5/3 0003.
 * 主页--待办--listview adapter
 */

public class WaitLVAdapter extends CustomAdapter {

    public WaitLVAdapter(Context context, List<Object> list) {
        super(context, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder viewHolder;
        if (convertView==null){
            view= LayoutInflater.from(context).inflate(R.layout.lvitem_wait,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.imageView= (ImageView) view.findViewById(R.id.image_fragwait_icon);
            viewHolder.textView1= (TextView) view.findViewById(R.id.textview_fragwait_title);
            viewHolder.textView2= (TextView) view.findViewById(R.id.textview_fragwait_hint1);
            viewHolder.textView3= (MarqueeText) view.findViewById(R.id.textview_fragwait_right1);
            view.setTag(viewHolder);
        }else {
            view=convertView;
            viewHolder= (ViewHolder) view.getTag();
        }
        viewHolder.imageView.setImageResource(((ListViewBean)list.get(position)).getResId());
        viewHolder.textView1.setText(((ListViewBean)list.get(position)).getResIdt());
        viewHolder.textView2.setText(((ListViewBean)list.get(position)).getContent());
        viewHolder.textView3.setText(((ListViewBean)list.get(position)).getMark());
        viewHolder.textView3.stopScroll();

        return view;
    }
    class ViewHolder{
        public ImageView imageView;
        public TextView textView1;
        public TextView textView2;
        public MarqueeText textView3;

    }
}
