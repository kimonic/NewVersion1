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
import dingw.com.newversion.bean.work.LawsuitBean;

/**
 * Created by 12348 on 2017/5/8 0008.
 *  * 主页--工作--诉讼案件--xlistview  adapter
 */

public class LawsuitXLVAdapter extends CustomAdapter {
    
    public LawsuitXLVAdapter(Context context, List<BaseBean> list) {
        super(context, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder viewHolder;
        if (convertView==null){
            view= LayoutInflater.from(context).inflate(R.layout.xlvitem_lawsuit,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.textView1= (TextView) view.findViewById(R.id.textview_fraglawsuititem1);
            viewHolder.textView2= (TextView) view.findViewById(R.id.textview_fraglawsuititem2);
            viewHolder.textView3= (TextView) view.findViewById(R.id.textview_fraglawsuititem3);
            viewHolder.textView4= (TextView) view.findViewById(R.id.textview_fraglawsuititem4);
            viewHolder.textView5= (TextView) view.findViewById(R.id.textview_fraglawsuititem5);
            viewHolder.textView6= (TextView) view.findViewById(R.id.textview_fraglawsuititem6);
            viewHolder.textView7= (TextView) view.findViewById(R.id.textview_fraglawsuititem7);
            viewHolder.textView8= (TextView) view.findViewById(R.id.textview_fraglawsuititem8);
            view.setTag(viewHolder);

        }else {
            view=convertView;
            viewHolder= (ViewHolder) view.getTag();
        }
        viewHolder.textView1.setText(((LawsuitBean)list.get(position)).getTitle());
        viewHolder.textView2.setText(((LawsuitBean)list.get(position)).getYear());
        viewHolder.textView3.setText(((LawsuitBean)list.get(position)).getName());
        viewHolder.textView4.setText(((LawsuitBean)list.get(position)).getParty());
        viewHolder.textView5.setText(((LawsuitBean)list.get(position)).getType());
        viewHolder.textView6.setText(((LawsuitBean)list.get(position)).getInterpose());
        viewHolder.textView7.setText(((LawsuitBean)list.get(position)).getTime());
        viewHolder.textView8.setText(((LawsuitBean)list.get(position)).getState());


        return view;
    }
    class ViewHolder{
        TextView textView1,textView2,textView3,textView4,textView5,textView6,textView7,textView8;
    }
}
