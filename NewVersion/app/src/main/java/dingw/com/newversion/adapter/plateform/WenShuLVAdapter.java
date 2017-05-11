package dingw.com.newversion.adapter.plateform;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import dingw.com.newversion.R;
import dingw.com.newversion.base.BaseBean;
import dingw.com.newversion.base.CustomAdapter;
import dingw.com.newversion.bean.platform.WenShuBean;

/**
 * Created by 12348 on 2017/5/11 0011.
 * 主页--平台--文书--listview  adapter
 */

public class WenShuLVAdapter extends CustomAdapter {
    public WenShuLVAdapter(Context context, List<BaseBean> list) {
        super(context, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder viewHolder;
        if (convertView==null){
            view= LayoutInflater.from(context).inflate(R.layout.lvitem_wenshu,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.textView1= (TextView) view.findViewById(R.id.textview_fragwenshuitem1);
            viewHolder.textView2= (TextView) view.findViewById(R.id.textview_fragwenshuitem2);
            viewHolder.textView3= (TextView) view.findViewById(R.id.textview_fragwenshuitem3);
            view.setTag(viewHolder);
        }else {
            view=convertView;
            viewHolder= (ViewHolder) view.getTag();
        }


        viewHolder.textView1.setText(((WenShuBean)list.get(position)).getNum());
        viewHolder.textView2.setText(((WenShuBean)list.get(position)).getTitle());
        viewHolder.textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击下载事件
            }
        });


        return view;
    }
    class ViewHolder{
        public TextView textView1,textView2,textView3;
    }
}
