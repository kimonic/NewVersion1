package dingw.com.newversion.adapter.community;

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
import dingw.com.newversion.bean.community.InterflowAreaBean;
import dingw.com.newversion.utils.GlideImageLoader;

/**
 * Created by 12348 on 2017/5/18 0018.
 * 交流区 adapter
 */

public class InterflowAreaXLVAdapter extends CustomAdapter {
    public InterflowAreaXLVAdapter(Context context, List<BaseBean> list) {
        super(context, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder viewHolder;
        if (convertView==null){
            view= LayoutInflater.from(context).inflate(R.layout.xlvitem_interflow,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.textView1= (TextView) view.findViewById(R.id.textview_fraginterflowareaname);
            viewHolder.textView2= (TextView) view.findViewById(R.id.textview_fraginterflowareatime);
            viewHolder.textView3= (TextView) view.findViewById(R.id.textview_fraginterflowareatitle);
            viewHolder.textView4= (TextView) view.findViewById(R.id.textview_fraginterflowareacontent);
            viewHolder.textView5= (TextView) view.findViewById(R.id.textview_fraginterflowareabrowsenum);
            viewHolder.textView6= (TextView) view.findViewById(R.id.textview_fraginterflowareacommentnum);
            viewHolder.imageView= (ImageView) view.findViewById(R.id.imageview_fraginterflowareaicon);
            view.setTag(viewHolder);
        }else {
            view=convertView;
            viewHolder= (ViewHolder) view.getTag();
        }
        viewHolder.textView1.setText(((InterflowAreaBean)list.get(position)).getName());
        viewHolder.textView2.setText(((InterflowAreaBean)list.get(position)).getTime());
        viewHolder.textView3.setText(((InterflowAreaBean)list.get(position)).getTitle());
        viewHolder.textView4.setText(((InterflowAreaBean)list.get(position)).getContent());
        viewHolder.textView5.setText(((InterflowAreaBean)list.get(position)).getBrowseNum());
        viewHolder.textView6.setText(((InterflowAreaBean)list.get(position)).getCommentNum());
        GlideImageLoader.getInstance().displayCircleImage(context,R.drawable.icon_girl,viewHolder.imageView);


        return view;
    }

    class  ViewHolder{
        TextView textView1,textView2,textView3,textView4,textView5,textView6;
        ImageView imageView;
    }
}
