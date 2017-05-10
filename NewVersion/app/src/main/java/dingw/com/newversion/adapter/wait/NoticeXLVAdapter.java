package dingw.com.newversion.adapter.wait;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import dingw.com.newversion.R;
import dingw.com.newversion.base.BaseBean;
import dingw.com.newversion.base.CustomAdapter;
import dingw.com.newversion.bean.wait.NoticeBean;

/**
 * Created by 12348 on 2017/5/8 0008.
 * 主页--工作--本所公告 adapter
 */

public class NoticeXLVAdapter extends CustomAdapter {
    private int type;

    public void setType(int type) {
        this.type = type;
    }

    public NoticeXLVAdapter(Context context, List<BaseBean> list) {
        super(context, list);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        Viewholder viewholder;
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.xlvitem_notice, parent, false);
            viewholder = new Viewholder();
            viewholder.textView1 = (TextView) view.findViewById(R.id.textview_xlistitem1);
            viewholder.textView2 = (TextView) view.findViewById(R.id.textview_xlistitem2);
            viewholder.textView3 = (TextView) view.findViewById(R.id.textview_xlistitem3);
            viewholder.textView4 = (TextView) view.findViewById(R.id.textview_xlistitem4);
            viewholder.textView5 = (TextView) view.findViewById(R.id.textview_xlistitem5);
            viewholder.textView6 = (TextView) view.findViewById(R.id.textview_xlistitem6);
            viewholder.textView7 = (TextView) view.findViewById(R.id.textview_xlistitem7);
            view.setTag(viewholder);
        } else {
            view = convertView;
            viewholder = (Viewholder) view.getTag();
        }
        //---------------------------------------------------------------------------------
        viewholder.textView1.setText(((NoticeBean)list.get(position)).getTitle());
        viewholder.textView3.setText(((NoticeBean)list.get(position)).getClassify());
        viewholder.textView5.setText(((NoticeBean)list.get(position)).getCreate_time());
        viewholder.textView6.setText(Html.fromHtml("<font color='red'>" + ((NoticeBean)list.get(position)).getNum() + "</font>" + "人已读"));
        viewholder.textView7.setText(((NoticeBean)list.get(position)).getLawyer_name());
        if (type == 2) {
            viewholder.textView2.setText("会议分类");
            viewholder.textView4.setText("会议时间");
        }


        return view;
    }

    private class Viewholder {
        TextView textView1, textView2, textView3, textView4, textView5, textView6, textView7;
    }
}
