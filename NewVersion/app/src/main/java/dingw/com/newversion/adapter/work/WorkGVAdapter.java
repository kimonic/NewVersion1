package dingw.com.newversion.adapter.work;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

import dingw.com.newversion.R;
import dingw.com.newversion.bean.work.GridViewBean;

/**
 * Created by 12348 on 2017/3/22 0022.
 * 主页work项其他事项gridview适配器
 */

public class WorkGVAdapter extends BaseAdapter{

    private Context context;
    private List<GridViewBean>   list;

    public WorkGVAdapter(Context context, List<GridViewBean> list) {
        this.context = context;
        this.list = list;

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        View view;
        if (convertView!=null){
            view=convertView;
            viewHolder= (ViewHolder) convertView.getTag();
        }else{
            viewHolder=new ViewHolder();
            view= LayoutInflater.from(context).inflate(R.layout.gvitem,parent,false);
            viewHolder.textView= (TextView) view.findViewById(R.id.textview_griditem);
            viewHolder.imageView= (ImageView) view.findViewById(R.id.imageview_griditem);
            view.setTag(viewHolder);
        }

        viewHolder.imageView.setImageResource(list.get(position).getRes());
        viewHolder.textView.setText(list.get(position).getName());


        return view;
    }
    class ViewHolder{
        TextView textView;
        public ImageView imageView;

    }
}
