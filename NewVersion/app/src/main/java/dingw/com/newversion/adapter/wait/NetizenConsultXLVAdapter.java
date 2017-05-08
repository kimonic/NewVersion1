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
import dingw.com.newversion.bean.wait.NetizenConsultBean;

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
        viewHolder.textView1.setText(((NetizenConsultBean)list.get(position)).getTitle());
        viewHolder.textView2.setText(((NetizenConsultBean)list.get(position)).getTime());
        viewHolder.textView3.setText(((NetizenConsultBean)list.get(position)).getType());
        viewHolder.textView4.setText(((NetizenConsultBean)list.get(position)).getContent());
        viewHolder.textView5.setText(((NetizenConsultBean)list.get(position)).getBrowseNum());
        viewHolder.textView6.setText(((NetizenConsultBean)list.get(position)).getCommentNum());


        return view;
    }

    class  ViewHolder{
        public TextView textView1,textView2,textView3,textView4,textView5,textView6;
    }
}
