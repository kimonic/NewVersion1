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
import dingw.com.newversion.bean.wait.YIPiBanBean;

/**
 * Created by 12348 on 2017/5/6 0006.
 */

public class FeiYiPiBanXLVAdapter extends CustomAdapter {
    public FeiYiPiBanXLVAdapter(Context context, List<BaseBean> list) {
        super(context, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder viewHolder;
        if (convertView==null){
            view= LayoutInflater.from(context).inflate(R.layout.xlvitem_feiyipiban,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.textView1= (TextView) view.findViewById(R.id.textview_feiyipibanitem1);
            viewHolder.textView2= (TextView) view.findViewById(R.id.textview_feiyipibanitem2);
            viewHolder.textView3= (TextView) view.findViewById(R.id.textview_feiyipibanitem3);
            viewHolder.textView4= (TextView) view.findViewById(R.id.textview_feiyipibanitem4);
            viewHolder.textView5= (TextView) view.findViewById(R.id.textview_feiyipibanitem5);
            viewHolder.textView6= (TextView) view.findViewById(R.id.textview_feiyipibanitem6);
            viewHolder.textView7= (TextView) view.findViewById(R.id.textview_feiyipibanitem7);
            view.setTag(viewHolder);

        }else {
            view=convertView;
            viewHolder= (ViewHolder) view.getTag();
        }
        viewHolder.textView1.setText(((YIPiBanBean)(list.get(position))).getTitle());
        viewHolder.textView2.setText(((YIPiBanBean)(list.get(position))).getYear());
        viewHolder.textView3.setText(((YIPiBanBean)(list.get(position))).getTitle1());
        viewHolder.textView4.setText(((YIPiBanBean)(list.get(position))).getParty());
        viewHolder.textView5.setText(((YIPiBanBean)(list.get(position))).getContent());
        viewHolder.textView6.setText(((YIPiBanBean)(list.get(position))).getTime());
        viewHolder.textView7.setText(((YIPiBanBean)(list.get(position))).getExactTime());


        return view;
    }
    class ViewHolder{
        TextView textView1,textView2,textView3,textView4,textView5,textView6,textView7;
    }
}
