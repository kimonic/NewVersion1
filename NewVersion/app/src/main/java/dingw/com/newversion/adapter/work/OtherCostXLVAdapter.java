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
import dingw.com.newversion.bean.work.OtherCostBean;

/**
 * Created by 12348 on 2017/5/9 0009.
 * 主页--工作--其他费用fragment
 */

public class OtherCostXLVAdapter extends CustomAdapter {
    public OtherCostXLVAdapter(Context context, List<BaseBean> list) {
        super(context, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder viewHolder;
        if (convertView==null){
            view= LayoutInflater.from(context).inflate(R.layout.xlvitem_othercost,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.textView1= (TextView) view.findViewById(R.id.textview_fragothercost1);
            viewHolder.textView2= (TextView) view.findViewById(R.id.textview_fragothercost2);
            viewHolder.textView3= (TextView) view.findViewById(R.id.textview_fragothercost3);
            viewHolder.textView4= (TextView) view.findViewById(R.id.textview_fragothercost4);
            view.setTag(viewHolder);

        }else {
            view=convertView;
            viewHolder= (ViewHolder) view.getTag();
        }
        viewHolder.textView1.setText(((OtherCostBean)list.get(position)).getTitle());
        viewHolder.textView2.setText(((OtherCostBean)list.get(position)).getTime());
        viewHolder.textView3.setText(((OtherCostBean)list.get(position)).getBalance());
        viewHolder.textView4.setText(((OtherCostBean)list.get(position)).getCause());


        return view;
    }
    class ViewHolder{
        TextView textView1,textView2,textView3,textView4;
    }
}
