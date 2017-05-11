package dingw.com.newversion.adapter.plateform;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import dingw.com.newversion.R;
import dingw.com.newversion.base.BaseBean;
import dingw.com.newversion.base.CustomAdapter;
import dingw.com.newversion.bean.platform.EntrustIndentBean;

/**
 * Created by 12348 on 2017/5/11 0011.
 * 主页--平台--委托订单--XListview Adapter
 */

public class EntrustIndentXLVAdapter extends CustomAdapter {
    public EntrustIndentXLVAdapter(Context context, List<BaseBean> list) {
        super(context, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final int pos=position;
        View view;
        ViewHolder viewHolder;
        if (convertView==null){
            view= LayoutInflater.from(context).inflate(R.layout.xlvitem_entrustindent,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.textView1= (TextView) view.findViewById(R.id.textview_fragentrustindent1);
            viewHolder.textView2= (TextView) view.findViewById(R.id.textview_fragentrustindent2);
            viewHolder.textView3= (TextView) view.findViewById(R.id.textview_fragentrustindent3);
            viewHolder.textView4= (TextView) view.findViewById(R.id.textview_fragentrustindent4);
            viewHolder.textView5= (TextView) view.findViewById(R.id.textview_fragentrustindent5);
            view.setTag(viewHolder);

        }else {
            view=convertView;
            viewHolder= (ViewHolder) view.getTag();
        }
        viewHolder.textView1.setText(((EntrustIndentBean)list.get(position)).getIndentnum());
        viewHolder.textView2.setText(((EntrustIndentBean)list.get(position)).getTitle());
        viewHolder.textView3.setText(((EntrustIndentBean)list.get(position)).getTime());
        viewHolder.textView4.setText(((EntrustIndentBean)list.get(position)).getMoney());
        viewHolder.textView5.setText(Html.fromHtml(((EntrustIndentBean)list.get(position)).getName()+"  <font color='#436BC8'>"+((EntrustIndentBean)list.get(position)).getPhone()+"</font>"));

        viewHolder.textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMyDialog(((EntrustIndentBean)list.get(pos)).getPhone());
            }
        });
        return view;
    }


    private  void showMyDialog(final String phone){
        new AlertDialog.Builder(context)
                .setMessage("拨打电话:"+phone)
                .setPositiveButton("拨打", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phone));
                        context.startActivity(intent);
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();
    }



    class ViewHolder{
        TextView textView1,textView2,textView3,textView4,textView5;
    }
}
