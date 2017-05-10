package dingw.com.newversion.adapter.wait;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import dingw.com.newversion.R;
import dingw.com.newversion.base.BaseBean;
import dingw.com.newversion.base.CustomAdapter;
import dingw.com.newversion.bean.wait.NetizenConsultGbean.ListBean;
import dingw.com.newversion.bean.wait.NetizenConsultGbean;

/**
 * Created by 12348 on 2017/5/8 0008.
 * 主页---社区---网民咨询区--xlistview adapter
 */

public class NetizenConsultXLVAdapter extends CustomAdapter {
    public NetizenConsultXLVAdapter(Context context, List<BaseBean> list) {
        super(context, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder viewHolder;
        if (convertView==null){
            view= LayoutInflater.from(context).inflate(R.layout.xlvitem_netizen,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.textView1= (TextView) view.findViewById(R.id.textview_netizenitem1);
            viewHolder.textView2= (TextView) view.findViewById(R.id.textview_netizenitem2);
            viewHolder.textView3= (TextView) view.findViewById(R.id.textview_netizenitem3);
            viewHolder.textView4= (TextView) view.findViewById(R.id.textview_netizenitem4);
            viewHolder.textView5= (TextView) view.findViewById(R.id.textview_netizenitem5);
            viewHolder.textView6= (TextView) view.findViewById(R.id.textview_netizenitem6);
            view.setTag(viewHolder);
        }else {
            view=convertView;
            viewHolder= (ViewHolder) view.getTag();
        }
        viewHolder.textView1.setText(((NetizenConsultGbean.ListBean)list.get(position)).getSpecialities_name());
        viewHolder.textView2.setText(((NetizenConsultGbean.ListBean)list.get(position)).getCreate_time());
        viewHolder.textView3.setText(((NetizenConsultGbean.ListBean)list.get(position)).getCity_name());
        viewHolder.textView4.setText(((NetizenConsultGbean.ListBean)list.get(position)).getContent());
        viewHolder.textView5.setText(((NetizenConsultGbean.ListBean)list.get(position)).getReview_nums());
        viewHolder.textView6.setText(((NetizenConsultGbean.ListBean)list.get(position)).getReply_num());


        return view;
    }

    class  ViewHolder{
        public TextView textView1,textView2,textView3,textView4,textView5,textView6;
    }
}
