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
import dingw.com.newversion.bean.work.Depositbean;

/**
 * Created by 12348 on 2017/5/9 0009.
 * 主页--工作--押金管理--xlistview adapter
 */

public class DepositXLVAdapter extends CustomAdapter {
    
    private int colType;

    public void setColType(int colType) {
        this.colType = colType;
    }

    public DepositXLVAdapter(Context context, List<BaseBean> list) {
        super(context, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.xlvitem_deposit, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.textView1 = (TextView) view.findViewById(R.id.textview_fragdeposit1);
            viewHolder.textView2 = (TextView) view.findViewById(R.id.textview_fragdeposit2);
            viewHolder.textView3 = (TextView) view.findViewById(R.id.textview_fragdeposit3);
            viewHolder.textView4 = (TextView) view.findViewById(R.id.textview_fragdeposit4);
            viewHolder.textView5 = (TextView) view.findViewById(R.id.textview_fragdeposit5);
            viewHolder.textView6 = (TextView) view.findViewById(R.id.textview_fragdeposit6);
            viewHolder.textView7 = (TextView) view.findViewById(R.id.textview_fragdeposit7);
            view.setTag(viewHolder);

        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.textView1.setText(((Depositbean)list.get(position)).getBianHao());
        viewHolder.textView2.setText(((Depositbean)list.get(position)).getFenPeiZonge());
        viewHolder.textView3.setText(((Depositbean)list.get(position)).getDepositScale());
        viewHolder.textView4.setText(((Depositbean)list.get(position)).getDepositNum());
        viewHolder.textView6.setText(((Depositbean)list.get(position)).getTime());
        viewHolder.textView7.setText(((Depositbean)list.get(position)).getTotal());


        switch (colType){
            case 1:
                viewHolder.textView5.setText("审核中");
                viewHolder.textView5.setTextColor(context.getResources().getColor(R.color.red2));
                break;
            case 2:
                viewHolder.textView5.setText("已审核");
                viewHolder.textView5.setTextColor(context.getResources().getColor(R.color.blue5));
                break;
            case 3:
                viewHolder.textView5.setText("已提取");
                viewHolder.textView5.setTextColor(context.getResources().getColor(R.color.green));
                break;
        }




        return view;
    }

    class ViewHolder {
        TextView textView1, textView2, textView3, textView4, textView5, textView6, textView7;
    }
}
