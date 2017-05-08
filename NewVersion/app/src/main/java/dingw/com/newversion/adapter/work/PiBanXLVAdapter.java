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
import dingw.com.newversion.bean.work.PiBanBean;

/**
 * Created by 12348 on 2017/5/8 0008.
 *
 * 工作---我要批办---批办  adapter
 */

public class PiBanXLVAdapter extends CustomAdapter {
    public PiBanXLVAdapter(Context context, List<BaseBean> list) {
        super(context, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder viewHolder;
        if (convertView==null){
            view= LayoutInflater.from(context).inflate(R.layout.xlvitem_piban,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.textView1= (TextView) view.findViewById(R.id.textview_fragpibanitem1);
            viewHolder.textView2= (TextView) view.findViewById(R.id.textview_fragpibanitem2);
            viewHolder.textView3= (TextView) view.findViewById(R.id.textview_fragpibanitem3);
            viewHolder.textView4= (TextView) view.findViewById(R.id.textview_fragpibanitem4);
            viewHolder.textView5= (TextView) view.findViewById(R.id.textview_fragpibanitem5);
            viewHolder.textView6= (TextView) view.findViewById(R.id.textview_fragpibanitem6);
            viewHolder.textView7= (TextView) view.findViewById(R.id.textview_fragpibanitem7);
            view.setTag(viewHolder);

        }else {
            view=convertView;
            viewHolder= (ViewHolder) view.getTag();
        }
        viewHolder.textView1.setText(((PiBanBean)list.get(position)).getTitle());
        viewHolder.textView2.setText(((PiBanBean)list.get(position)).getYear());
        viewHolder.textView3.setText(((PiBanBean)list.get(position)).getName());
        viewHolder.textView4.setText(((PiBanBean)list.get(position)).getParty());
        viewHolder.textView5.setText(((PiBanBean)list.get(position)).getStarTime());
        viewHolder.textView6.setText(((PiBanBean)list.get(position)).getLawyerName());
        viewHolder.textView7.setText(((PiBanBean)list.get(position)).getPiBanTime());


        return view;
    }
    class ViewHolder{
        TextView textView1,textView2,textView3,textView4,textView5,textView6,textView7;
    }
}
