package dingw.com.newversion.adapter.wait;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import dingw.com.newversion.R;
import dingw.com.newversion.base.CustomAdapter;
import dingw.com.newversion.bean.wait.EMailBean;

/**
 * Created by 12348 on 2017/5/3 0003.
 * 主页--待办--email点击--通知fragment--xlistview  adapter
 */

public class EmailXLVAdapter extends CustomAdapter {
    public EmailXLVAdapter(Context context, List<Object> list) {
        super(context, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder viewHolder;
        if (convertView==null){
            view= LayoutInflater.from(context).inflate(R.layout.xlvitem_email,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.textView1= (TextView) view.findViewById(R.id.textview_fragemailitem1);
            viewHolder.textView2= (TextView) view.findViewById(R.id.textview_fragemailitem2);
            viewHolder.textView3= (TextView) view.findViewById(R.id.textview_fragemailitem3);
            view.setTag(viewHolder);

        }else {
            view=convertView;
            viewHolder= (ViewHolder) view.getTag();
        }
        viewHolder.textView1.setText(((EMailBean)list.get(position)).getTitle());
        viewHolder.textView2.setText(((EMailBean)list.get(position)).getTime());
        viewHolder.textView3.setText(((EMailBean)list.get(position)).getContent());


        return view;
    }
    class ViewHolder{
        TextView textView1,textView2,textView3;
    }
}
