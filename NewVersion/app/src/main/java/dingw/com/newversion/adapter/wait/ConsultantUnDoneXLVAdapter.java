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
import dingw.com.newversion.bean.wait.ConsultantUnDoneBean;

/**
 * Created by 12348 on 2017/5/8 0008.
 * 首页--待办--顾问--未完成工单--xlistview adapter
 */

public class ConsultantUnDoneXLVAdapter extends CustomAdapter {
    public ConsultantUnDoneXLVAdapter(Context context, List<BaseBean> list) {
        super(context, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder viewHolder;
        if (convertView==null){
            view= LayoutInflater.from(context).inflate(R.layout.xlvitem_consutantundone,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.textView1= (TextView) view.findViewById(R.id.textview_fragconsultantundone1);
            viewHolder.textView2= (TextView) view.findViewById(R.id.textview_fragconsultantundone2);
            viewHolder.textView3= (TextView) view.findViewById(R.id.textview_fragconsultantundone3);
            viewHolder.textView4= (TextView) view.findViewById(R.id.textview_fragconsultantundone4);
            view.setTag(viewHolder);

        }else {
            view=convertView;
            viewHolder= (ViewHolder) view.getTag();
        }
        viewHolder.textView1.setText(((ConsultantUnDoneBean)list.get(position)).getGongDanTitle());
        viewHolder.textView2.setText(((ConsultantUnDoneBean)list.get(position)).getConsulantUnit());
        viewHolder.textView3.setText(((ConsultantUnDoneBean)list.get(position)).getGongDanType());
        viewHolder.textView4.setText(((ConsultantUnDoneBean)list.get(position)).getCreateTime());


        return view;
    }
    private class ViewHolder{
        TextView textView1,textView2,textView3,textView4;
    }
}
