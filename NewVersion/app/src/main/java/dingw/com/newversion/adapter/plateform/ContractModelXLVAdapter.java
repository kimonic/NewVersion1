package dingw.com.newversion.adapter.plateform;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import dingw.com.newversion.R;
import dingw.com.newversion.base.BaseBean;
import dingw.com.newversion.base.CustomAdapter;
import dingw.com.newversion.bean.platform.ContractModelBean;

/**
 * Created by 12348 on 2017/5/11 0011.
 * 主页--平台--合同范本xlistview adapter
 */

public class ContractModelXLVAdapter extends CustomAdapter implements View.OnClickListener {
    public ContractModelXLVAdapter(Context context, List<BaseBean> list) {
        super(context, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder viewHolder;
        if (convertView==null){
            view= LayoutInflater.from(context).inflate(R.layout.xlvitem_contractmodel,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.textView1= (TextView) view.findViewById(R.id.textview_fragcontractmodel1);
            viewHolder.textView2= (TextView) view.findViewById(R.id.textview_fragcontractmodel2);
            viewHolder.textView3= (TextView) view.findViewById(R.id.textview_fragcontractmodel3);
            viewHolder.textView4= (TextView) view.findViewById(R.id.textview_fragcontractmodel4);
            viewHolder.textView5= (TextView) view.findViewById(R.id.textview_fragcontractmodel5);


            viewHolder.textView6= (TextView) view.findViewById(R.id.textview_fragcontractmodel6);
            viewHolder.textView7= (TextView) view.findViewById(R.id.textview_fragcontractmodel7);
            viewHolder.textView8= (TextView) view.findViewById(R.id.textview_fragcontractmodel8);
            view.setTag(viewHolder);

        }else {
            view=convertView;
            viewHolder= (ViewHolder) view.getTag();
        }
        viewHolder.textView1.setText(((ContractModelBean)list.get(position)).getTitle());
        viewHolder.textView2.setText(((ContractModelBean)list.get(position)).getAuthor());
        viewHolder.textView3.setText(((ContractModelBean)list.get(position)).getLawyerOffice());
        viewHolder.textView4.setText(((ContractModelBean)list.get(position)).getTime());
        viewHolder.textView5.setText(((ContractModelBean)list.get(position)).getType());


        viewHolder.textView6.setOnClickListener(this);
        viewHolder.textView7.setOnClickListener(this);
        viewHolder.textView8.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.textview_fragcontractmodel6:
                //点击事件
                break;
            case R.id.textview_fragcontractmodel7:
                //点击事件
                break;
            case R.id.textview_fragcontractmodel8:
                //点击事件
                break;
        }

    }

    class ViewHolder{
        TextView textView1,textView2,textView3,textView4,textView5,textView6,textView7,textView8;
    }
}
