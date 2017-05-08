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
import dingw.com.newversion.bean.wait.NewLawBean;

/**
 * Created by 12348 on 2017/5/8 0008.
 * 待办--新法速递--xlistview  adapter
 */

public class NewLawExpressXLVAdapter extends CustomAdapter {
    public NewLawExpressXLVAdapter(Context context, List<BaseBean> list) {
        super(context, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder viewHolder;
        if (convertView==null){
            view= LayoutInflater.from(context).inflate(R.layout.xlvitem_newlaw,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.textView1= (TextView) view.findViewById(R.id.textview_fragnewlawitem1);
            viewHolder.textView2= (TextView) view.findViewById(R.id.textview_fragnewlawitem2);
            viewHolder.textView3= (TextView) view.findViewById(R.id.textview_fragnewlawitem3);
            view.setTag(viewHolder);

        }else {
            view=convertView;
            viewHolder= (ViewHolder) view.getTag();
        }
        viewHolder.textView1.setText(((NewLawBean)list.get(position)).getTitle());
        viewHolder.textView2.setText(((NewLawBean)list.get(position)).getType());
        viewHolder.textView3.setText(((NewLawBean)list.get(position)).getTime());


        return view;
    }
    class ViewHolder{
        TextView textView1,textView2,textView3;
    }
}
