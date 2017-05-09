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
import dingw.com.newversion.bean.work.WithdrawsBean;

/**
 * Created by 12348 on 2017/5/9 0009.
 * 
 */

public class WithdrawsXLVAdapter extends CustomAdapter {
    private int colType;

    public void setColType(int colType) {
        this.colType = colType;
    }

    public WithdrawsXLVAdapter(Context context, List<BaseBean> list) {
        super(context, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.xlvitem_withdraws, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.textView1 = (TextView) view.findViewById(R.id.textview_fragwithdraws1);
            viewHolder.textView2 = (TextView) view.findViewById(R.id.textview_fragwithdraws2);
            viewHolder.textView3 = (TextView) view.findViewById(R.id.textview_fragwithdraws3);
            viewHolder.textView4 = (TextView) view.findViewById(R.id.textview_fragwithdraws4);
            viewHolder.textView5 = (TextView) view.findViewById(R.id.textview_fragwithdraws5);
            view.setTag(viewHolder);

        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.textView1.setText(((WithdrawsBean)list.get(position)).getBianHao());
        viewHolder.textView2.setText(((WithdrawsBean)list.get(position)).getFenPeiZonge());
        viewHolder.textView3.setText(((WithdrawsBean)list.get(position)).getTotal());
        if (colType == 2) {
            viewHolder.textView4.setTextColor(context.getResources().getColor(R.color.mytextcolorgreen));
        }
        viewHolder.textView5.setText(((WithdrawsBean)list.get(position)).getSubmitTime());
        return view;
    }

    class ViewHolder {
        TextView textView1, textView2, textView3, textView4, textView5;
    }
}
