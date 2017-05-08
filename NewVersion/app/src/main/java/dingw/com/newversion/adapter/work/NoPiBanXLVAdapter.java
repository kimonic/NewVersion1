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
import dingw.com.newversion.bean.work.NoPiBanBean;

/**
 * Created by 12348 on 2017/5/8 0008.
 * 主页--工作--我要批办--非诉讼批办--已批办 adapter
 * 
 */

public class NoPiBanXLVAdapter extends CustomAdapter {
    public NoPiBanXLVAdapter(Context context, List<BaseBean> list) {
        super(context, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder viewHolder;
        if (convertView==null){
            view= LayoutInflater.from(context).inflate(R.layout.xlvitem_nopiban,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.textView1= (TextView) view.findViewById(R.id.textview_fragnopibanitem1);
            viewHolder.textView2= (TextView) view.findViewById(R.id.textview_fragnopibanitem2);
            viewHolder.textView3= (TextView) view.findViewById(R.id.textview_fragnopibanitem3);
            viewHolder.textView4= (TextView) view.findViewById(R.id.textview_fragnopibanitem4);
            viewHolder.textView5= (TextView) view.findViewById(R.id.textview_fragnopibanitem5);
            view.setTag(viewHolder);

        }else {
            view=convertView;
            viewHolder= (ViewHolder) view.getTag();
        }
        viewHolder.textView1.setText(((NoPiBanBean)list.get(position)).getTitle());
        viewHolder.textView2.setText(((NoPiBanBean)list.get(position)).getType());
        viewHolder.textView3.setText(((NoPiBanBean)list.get(position)).getUnit());
        viewHolder.textView4.setText(((NoPiBanBean)list.get(position)).getLawyer());
        viewHolder.textView5.setText(((NoPiBanBean)list.get(position)).getTime());


        return view;
    }
    class ViewHolder{
        TextView textView1,textView2,textView3,textView4,textView5;
    }
}
