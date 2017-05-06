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
import dingw.com.newversion.bean.wait.FinancingBean;

/**
 * Created by 12348 on 2017/5/6 0006.
 * financing listview adapter
 */

public class FinancingXLVAdapter extends CustomAdapter {
    
    public FinancingXLVAdapter(Context context, List<BaseBean> list) {
        super(context, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolderFinancing viewHolderFinancing;
        if (convertView==null){
            view= LayoutInflater.from(context).inflate(R.layout.xlvitem_financing,parent,false);
            viewHolderFinancing=new ViewHolderFinancing();
            viewHolderFinancing.textView1= (TextView) view.findViewById(R.id.textview_financinglistitem1);
            viewHolderFinancing.textView2= (TextView) view.findViewById(R.id.textview_financinglistitem2);
            viewHolderFinancing.textView3= (TextView) view.findViewById(R.id.textview_financinglistitem3);
            viewHolderFinancing.textView4= (TextView) view.findViewById(R.id.textview_financinglistitem4);
            viewHolderFinancing.textView5= (TextView) view.findViewById(R.id.textview_financinglistitem5);
            viewHolderFinancing.textView6= (TextView) view.findViewById(R.id.textview_financinglistitem6);
            viewHolderFinancing.textView7= (TextView) view.findViewById(R.id.textview_financinglistitem7);
            viewHolderFinancing.textView8= (TextView) view.findViewById(R.id.textview_financinglistitem8);
            view.setTag(viewHolderFinancing);
        }else {
            view=convertView;
            viewHolderFinancing= (ViewHolderFinancing) view.getTag();
        }

        viewHolderFinancing.textView1.setText(((FinancingBean)list.get(position)).getFenPei1());
        viewHolderFinancing.textView2.setText(((FinancingBean)list.get(position)).getFenPei2());
        viewHolderFinancing.textView3.setText(((FinancingBean)list.get(position)).getFenPei3());
        viewHolderFinancing.textView4.setText(((FinancingBean)list.get(position)).getFenPei4());
        viewHolderFinancing.textView5.setText(((FinancingBean)list.get(position)).getFenPei5());
        viewHolderFinancing.textView6.setText(((FinancingBean)list.get(position)).getFenPei6());
        viewHolderFinancing.textView7.setText(((FinancingBean)list.get(position)).getFenPei7());
        viewHolderFinancing.textView8.setText(((FinancingBean)list.get(position)).getFenPei8());


        return view;
    }
    private class ViewHolderFinancing{
        TextView textView1,textView2,textView3,textView4,textView5,
                textView6,textView7,textView8;
    }
}
