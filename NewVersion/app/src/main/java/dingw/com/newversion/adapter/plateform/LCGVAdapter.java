package dingw.com.newversion.adapter.plateform;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import dingw.com.newversion.R;
import dingw.com.newversion.base.BaseBean;
import dingw.com.newversion.base.CustomAdapter;
import dingw.com.newversion.bean.platform.GridViewBean;

/**
 * Created by 12348 on 2017/5/11 0011.
 * 平台---法律计算器展示页GridView adapter
 */

public class LCGVAdapter extends CustomAdapter {
    public LCGVAdapter(Context context, List<BaseBean> list) {
        super(context, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        View view=null;
        if (convertView!=null){
            view=convertView;
            viewHolder= (ViewHolder) convertView.getTag();

        }else{
            viewHolder=new ViewHolder();
            view= LayoutInflater.from(context).inflate(R.layout.view_lawcalculator,null);
            viewHolder.textView= (TextView) view.findViewById(R.id.textview_recylawitem1);
            viewHolder.imageView= (ImageView) view.findViewById(R.id.imageview_recylawitem1);
            viewHolder.imageView1= (ImageView) view.findViewById(R.id.imageview_recylawitem2);
            viewHolder.imageView2= (ImageView) view.findViewById(R.id.imageview_recylawitem3);

            view.setTag(viewHolder);
        }

        viewHolder.imageView.setBackgroundColor(context.getResources().getColor(((GridViewBean)list.get(position)).getRes()));
        viewHolder.textView.setText(((GridViewBean)list.get(position)).getName());
        if ((position+1)%3==0){
            viewHolder.imageView2.setVisibility(View.GONE);
        }
        if (position==list.size()-1){
            viewHolder.imageView1.setVisibility(View.GONE);
        }


        return view;
    }
    class ViewHolder{
        public TextView textView;
        public ImageView imageView,imageView1,imageView2;

    }
}
