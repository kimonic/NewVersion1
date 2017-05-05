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
import dingw.com.newversion.bean.wait.MyActBean;
import dingw.com.newversion.utils.SaveUtils;

/**
 * Created by 12348 on 2017/5/5 0005.
 * 
 */

public class MyLVAdapter extends CustomAdapter {
    
    /**记录开关的点击次数*/
    private int count=0;
    /**每次登陆是否输入密码*/
    private int inputPass;
    private SaveUtils save;
    
    public MyLVAdapter(Context context, List<BaseBean> list) {
        super(context, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=null;
        final ViewHolder viewHolder;
        if (convertView==null){
            view= LayoutInflater.from(context).inflate(R.layout.lvitem_myact,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.imageView_icon= (ImageView) view.findViewById(R.id.imageview_listviewitem1);
            viewHolder.imageView_mark= (ImageView) view.findViewById(R.id.imageview_listviewitem2);
            viewHolder.textView_content= (TextView) view.findViewById(R.id.textview_listviewitem1);
            viewHolder.textView_mark= (TextView) view.findViewById(R.id.textview_listviewitem2);
            view.setTag(viewHolder);
        }
        else {
            view=convertView;
            viewHolder= (ViewHolder) view.getTag();
        }
        viewHolder.imageView_icon.setImageResource(((MyActBean)list.get(position)).getResId());
        viewHolder.textView_content.setText(((MyActBean)list.get(position)).getContent());
        if (((MyActBean)list.get(position)).getMark()!="")
        {
            viewHolder.textView_mark.setVisibility(View.VISIBLE);
            viewHolder.textView_mark.setText(((MyActBean)list.get(position)).getMark());
        }
        if (((MyActBean)list.get(position)).getResIdt()!=0){
            save=new SaveUtils(context,"favrivate");
            inputPass=save.getIntInfo("inputstate",0);

            viewHolder.imageView_mark.setVisibility(View.VISIBLE);
            if (inputPass==0){
                viewHolder.imageView_mark.setImageResource(R.drawable.myact_closebut);
                count=0;
            }else {
                viewHolder.imageView_mark.setImageResource(R.drawable.myact_openbut);
                count=1;
            }
            viewHolder.imageView_mark.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (save==null){
                        save=new SaveUtils(context,"favrivate");
                    }
                    count++;
                    if (count%2==0){
                        viewHolder.imageView_mark.setImageResource(R.drawable.myact_closebut);
                        save.saveInfo("inputstate",0);
                    }else {
                        viewHolder.imageView_mark.setImageResource(R.drawable.myact_openbut);
                        save.saveInfo("inputstate",1);
                    }

                }
            });
        }

        return view;
    }
    class ViewHolder{
        public ImageView imageView_icon;
        public ImageView imageView_mark;
        public TextView  textView_content;
        public TextView  textView_mark;



    }
}
