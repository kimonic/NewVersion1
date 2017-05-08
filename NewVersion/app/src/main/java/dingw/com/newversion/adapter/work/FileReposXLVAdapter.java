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
        if (((FileRepositoryBean)list.get(position)).getFolder_name()!=null){
            viewHolder.imageView.setImageResource(R.drawable.fileicon_folder);
            viewHolder.textView_title.setText(((FileRepositoryBean)list.get(position)).getFolder_name());
            viewHolder.textView_time.setText(((FileRepositoryBean)list.get(position)).getFolder_inster_time());
            viewHolder.textView_size.setText("");
        }else if (((FileRepositoryBean)list.get(position)).getFile_name()!=null){

            if (setImageType(((FileRepositoryBean)list.get(position)).getFile_name(),".JPG",".jpg")){
                viewHolder.imageView.setImageResource(R.drawable.fileicon_jpg);
            }else if (setImageType(((FileRepositoryBean)list.get(position)).getFile_name(),".XLSX",".xlsx")){
                viewHolder.imageView.setImageResource(R.drawable.fileicon_xlsx);
            }else  if (setImageType(((FileRepositoryBean)list.get(position)).getFile_name(),".ZIP",".zip")){
                viewHolder.imageView.setImageResource(R.drawable.fileicon_zip);
            }else  if (setImageType(((FileRepositoryBean)list.get(position)).getFile_name(),".PNG",".png")){
                viewHolder.imageView.setImageResource(R.drawable.fileicon_png);
            }else  if (setImageType(((FileRepositoryBean)list.get(position)).getFile_name(),".PDF",".pdf")){
                viewHolder.imageView.setImageResource(R.drawable.fileicon_pdf);
            }else  if (setImageType(((FileRepositoryBean)list.get(position)).getFile_name(),".DOCX",".docx")){
                viewHolder.imageView.setImageResource(R.drawable.fileicon_docx);
            }else{
                viewHolder.imageView.setImageResource(R.drawable.fileicon_no);
            }
            //字符串中加空格可以解决长数字或者长字母全部不能显示的问题
            viewHolder.textView_title.setText(((FileRepositoryBean)list.get(position)).getFile_name());
            viewHolder.textView_time.setText(((FileRepositoryBean)list.get(position)).getFile_inster_time());
            viewHolder.textView_size.setText(((FileRepositoryBean)list.get(position)).getFile_size());
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
