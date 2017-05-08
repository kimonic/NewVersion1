package dingw.com.newversion.adapter.work;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import dingw.com.newversion.R;
import dingw.com.newversion.base.BaseBean;
import dingw.com.newversion.base.CustomAdapter;
import dingw.com.newversion.bean.work.NoLawsuitBean;

/**
 * Created by 12348 on 2017/5/8 0008.
 * 主页--工作--非诉讼案件--xlistview  adapter
 */

public class NoLawsuitXLVAdapter extends CustomAdapter {
    
    public NoLawsuitXLVAdapter(Context context, List<BaseBean> list) {
        super(context, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder viewHolder;
        if (convertView==null){
            view= LayoutInflater.from(context).inflate(R.layout.xlvitem_nolawsuit,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.textView1= (TextView) view.findViewById(R.id.textview_fragnolawsuititem1);
            viewHolder.textView2= (TextView) view.findViewById(R.id.textview_fragnolawsuititem2);
            viewHolder.textView3= (TextView) view.findViewById(R.id.textview_fragnolawsuititem3);
            viewHolder.textView4= (TextView) view.findViewById(R.id.textview_fragnolawsuititem4);
            viewHolder.textView5= (TextView) view.findViewById(R.id.textview_fragnolawsuititem5);
            view.setTag(viewHolder);

        }else {
            view=convertView;
            viewHolder= (ViewHolder) view.getTag();
        }
        viewHolder.textView1.setText(((NoLawsuitBean)list.get(position)).getTitle());
        viewHolder.textView2.setText(((NoLawsuitBean)list.get(position)).getType());
        viewHolder.textView3.setText(((NoLawsuitBean)list.get(position)).getUnit());
        viewHolder.textView4.setText(((NoLawsuitBean)list.get(position)).getTime());
        viewHolder.textView5.setText(((NoLawsuitBean)list.get(position)).getState());


        return view;
    }
    class ViewHolder{
        TextView textView1,textView2,textView3,textView4,textView5,textView6,textView7,textView8;
    }
}
