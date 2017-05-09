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
import dingw.com.newversion.bean.work.ConsultantUnitBean;

/**
 * Created by 12348 on 2017/5/9 0009.
 * 首页--工作--顾问单位-xlistview adapter
 */

public class ConsultantUnitXLVAdapter extends CustomAdapter {
    public ConsultantUnitXLVAdapter(Context context, List<BaseBean> list) {
        super(context, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder viewHolder;
        if (convertView==null){
            view= LayoutInflater.from(context).inflate(R.layout.xlvitem_consultantunit,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.textView1= (TextView) view.findViewById(R.id.textview_fragconsultantunit1);
            viewHolder.textView2= (TextView) view.findViewById(R.id.textview_fragconsultantunit2);
            viewHolder.textView3= (TextView) view.findViewById(R.id.textview_fragconsultantunit3);
            viewHolder.textView4= (TextView) view.findViewById(R.id.textview_fragconsultantunit4);
            viewHolder.textView5= (TextView) view.findViewById(R.id.textview_fragconsultantunit5);
            viewHolder.textView6= (TextView) view.findViewById(R.id.textview_fragconsultantunit6);
            viewHolder.textView7= (TextView) view.findViewById(R.id.textview_fragconsultantunit7);
            view.setTag(viewHolder);

        }else {
            view=convertView;
            viewHolder= (ViewHolder) view.getTag();
        }
        viewHolder.textView1.setText(((ConsultantUnitBean)list.get(position)).getUnitName());
        viewHolder.textView2.setText(((ConsultantUnitBean)list.get(position)).getLiaison());
        viewHolder.textView3.setText(((ConsultantUnitBean)list.get(position)).getEndTime());
        viewHolder.textView4.setText(((ConsultantUnitBean)list.get(position)).getIsSave());
        viewHolder.textView5.setText(((ConsultantUnitBean)list.get(position)).getPhoneNum());
        viewHolder.textView6.setText(((ConsultantUnitBean)list.get(position)).getLandline());
        viewHolder.textView7.setText(((ConsultantUnitBean)list.get(position)).getQqNum());


        return view;
    }
    class ViewHolder{
        TextView textView1,textView2,textView3,textView4,textView5,textView6,textView7;
    }
}
