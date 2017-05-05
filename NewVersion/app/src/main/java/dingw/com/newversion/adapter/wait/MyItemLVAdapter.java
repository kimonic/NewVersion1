package dingw.com.newversion.adapter.wait;

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
import dingw.com.newversion.bean.wait.MyItemBean;

/**
 * Created by 12348 on 2017/5/5 0005.
 * myitemactivity 推送设置 listview adapter
 */

public class MyItemLVAdapter extends CustomAdapter {
    public MyItemLVAdapter(Context context, List<BaseBean> list) {
        super(context, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view;
        final ViewHolder viewHolder;
        if (convertView==null){
            view= LayoutInflater.from(context).inflate(R.layout.lvitem_myactitem,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.textView= (TextView) view.findViewById(R.id.textview_myactitem_listitem);
            viewHolder.imageView= (ImageView) view.findViewById(R.id.imageview_myactitem_listitem);
            view.setTag(viewHolder);
        }else {
            view=convertView;
            viewHolder= (ViewHolder) view.getTag();
        }

        viewHolder.textView.setText(((MyItemBean)list.get(position)).getContent());
        setImageFromSave(viewHolder.imageView,position);
        return view;
    }
    /**根据保存配置设置推送信息*/
    private void setImageFromSave(ImageView imageView,int position) {
        if (((MyItemBean)list.get(position)).getFlag()==0){
            imageView.setImageResource(R.drawable.myact_closebut);
        }else {
            imageView.setImageResource(R.drawable.myact_openbut);
        }
    }




    private class ViewHolder{
        TextView textView;
        ImageView imageView;
    }
}
