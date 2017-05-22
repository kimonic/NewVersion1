package dingw.com.newversion.adapter.work;

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
import dingw.com.newversion.bean.work.FileRepositoryBean;
import dingw.com.newversion.bean.work.FileRepositoryGBean;

/**
 * Created by 12348 on 2017/5/8 0008.
 * 本地文件库listview的adapter
 *
 */

public class FileReposXLVAdapter extends CustomAdapter {

    public FileReposXLVAdapter(Context context, List<BaseBean> list) {
        super(context, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder viewHolder;
        if (convertView==null){
            view= LayoutInflater.from(context).inflate(R.layout.xlvitem_filerepository,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.textView_title= (TextView) view.findViewById(R.id.textview_filerepos_title);
            viewHolder.textView_time= (TextView) view.findViewById(R.id.textview_filerepos_time);
            viewHolder.textView_size= (TextView) view.findViewById(R.id.textview_filerepos_size);
            viewHolder.imageView= (ImageView) view.findViewById(R.id.imageview_filerepos_icon);
            view.setTag(viewHolder);
        }else {
            view=convertView;
            viewHolder= (ViewHolder) view.getTag();
        }
        if (((FileRepositoryGBean.ListBean)list.get(position)).getName()!=null&&!((FileRepositoryGBean.ListBean)list.get(position)).getName().contains(".")){
            viewHolder.imageView.setImageResource(R.drawable.fileicon_folder);
            viewHolder.textView_title.setText(((FileRepositoryGBean.ListBean)list.get(position)).getName());
            viewHolder.textView_time.setText(((FileRepositoryGBean.ListBean)list.get(position)).getCreate_time());
            viewHolder.textView_size.setText("");
        }else if (((FileRepositoryGBean.ListBean)list.get(position)).getName()!=null){

            if (setImageType(((FileRepositoryGBean.ListBean)list.get(position)).getName(),".JPG",".jpg")){
                viewHolder.imageView.setImageResource(R.drawable.fileicon_jpg);
            }else if (setImageType(((FileRepositoryGBean.ListBean)list.get(position)).getName(),".XLSX",".xlsx")){
                viewHolder.imageView.setImageResource(R.drawable.fileicon_xlsx);
            }else  if (setImageType(((FileRepositoryGBean.ListBean)list.get(position)).getName(),".ZIP",".zip")){
                viewHolder.imageView.setImageResource(R.drawable.fileicon_zip);
            }else  if (setImageType(((FileRepositoryGBean.ListBean)list.get(position)).getName(),".PNG",".png")){
                viewHolder.imageView.setImageResource(R.drawable.fileicon_png);
            }else  if (setImageType(((FileRepositoryGBean.ListBean)list.get(position)).getName(),".PDF",".pdf")){
                viewHolder.imageView.setImageResource(R.drawable.fileicon_pdf);
            }else  if (setImageType(((FileRepositoryGBean.ListBean)list.get(position)).getName(),".DOCX",".docx")){
                viewHolder.imageView.setImageResource(R.drawable.fileicon_docx);
            }else{
                viewHolder.imageView.setImageResource(R.drawable.fileicon_no);
            }
            //字符串中加空格可以解决长数字或者长字母全部不能显示的问题
            viewHolder.textView_title.setText(((FileRepositoryGBean.ListBean)list.get(position)).getName());
            viewHolder.textView_time.setText(((FileRepositoryGBean.ListBean)list.get(position)).getCreate_time());
            viewHolder.textView_size.setText(((FileRepositoryGBean.ListBean)list.get(position)).getSize());
        }


        return view;
    }
    /**设置显示图片类型*/
    public boolean setImageType(String content,String type1,String type2){
        return content.contains(type1)||content.contains(type2);
    }
    class ViewHolder{
        public TextView textView_title,textView_time,textView_size;
        public ImageView imageView;
    }

}
