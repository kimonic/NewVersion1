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
import dingw.com.newversion.bean.community.LawyerMediaBean;
import dingw.com.newversion.utils.GlideImageLoader;

/**
 * Created by 12348 on 2017/5/18 0018.
 * 律师自媒体 adapter
 */

public class LawyerMediaXLVAdapter extends CustomAdapter {
    public LawyerMediaXLVAdapter(Context context, List<BaseBean> list) {
        super(context, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder viewHolder;
        if (convertView==null){
            view= LayoutInflater.from(context).inflate(R.layout.xlvitem_lawyermedia,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.textView1= (TextView) view.findViewById(R.id.textview_xlistlawyermidea1);
            viewHolder.textView2= (TextView) view.findViewById(R.id.textview_xlistlawyermidea2);
            viewHolder.textView3= (TextView) view.findViewById(R.id.textview_xlistlawyermidea3);
            viewHolder.textView4= (TextView) view.findViewById(R.id.textview_xlistlawyermidea4);
            viewHolder.textView5= (TextView) view.findViewById(R.id.textview_xlistlawyermidea5);
            viewHolder.textView6= (TextView) view.findViewById(R.id.textview_xlistlawyermidea6);
            viewHolder.imageView= (ImageView) view.findViewById(R.id.imageview_xlistlawyermidea);
            view.setTag(viewHolder);
        }else {
            view=convertView;
            viewHolder= (ViewHolder) view.getTag();
        }
        viewHolder.textView1.setText(((LawyerMediaBean.ListBean)list.get(position)).getTitle());
        viewHolder.textView2.setText(((LawyerMediaBean.ListBean)list.get(position)).getCreate_time());
        viewHolder.textView3.setText(((LawyerMediaBean.ListBean)list.get(position)).getUuid());
        viewHolder.textView4.setText(((LawyerMediaBean.ListBean)list.get(position)).getReview_counts());
        viewHolder.textView5.setText(((LawyerMediaBean.ListBean)list.get(position)).getComment_counts());
        viewHolder.textView6.setText(((LawyerMediaBean.ListBean)list.get(position)).getUser_name());
        GlideImageLoader.getInstance().displayCircleImage(context,R.drawable.icon_girl,viewHolder.imageView);



        return view;
    }

    class  ViewHolder{
        TextView textView1,textView2,textView3,textView4,textView5,textView6;
        ImageView imageView;
    }
}
