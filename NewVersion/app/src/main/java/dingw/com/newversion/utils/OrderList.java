package dingw.com.newversion.utils;


import java.util.ArrayList;
import java.util.List;

import dingw.com.newversion.bean.work.FileRepositoryGBean;

/**
 * Created by 12348 on 2017/5/22 0022.
 * 对list按照特定字符串进行排序--本所文件库
 */

public class OrderList {

    public static List<FileRepositoryGBean.ListBean> order(List<FileRepositoryGBean.ListBean> list) {
        List<FileRepositoryGBean.ListBean>  list1=new ArrayList<>();//文件夹
        List<FileRepositoryGBean.ListBean>  list2=new ArrayList<>();//".JPG",".jpg"
        List<FileRepositoryGBean.ListBean>  list3=new ArrayList<>();//".XLSX",".xlsx"
        List<FileRepositoryGBean.ListBean>  list4=new ArrayList<>();//.ZIP",".zip"
        List<FileRepositoryGBean.ListBean>  list5=new ArrayList<>();//.PNG",".png"
        List<FileRepositoryGBean.ListBean>  list6=new ArrayList<>();//".PDF",".pdf"
        List<FileRepositoryGBean.ListBean>  list7=new ArrayList<>();//".DOCX",".docx"
        List<FileRepositoryGBean.ListBean>  list8=new ArrayList<>();//不确定类型
            
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName()!=null&&!list.get(i).getName().contains(".")){
                list1.add(list.get(i));
            }else if (list.get(i).getName()!=null){

                if (getImageType(list.get(i).getName(),".jpg")){
                    list2.add(list.get(i));
                }else if (getImageType(list.get(i).getName(),".xlsx")){
                    list3.add(list.get(i));
                }else  if (getImageType(list.get(i).getName(),".zip")){
                    list4.add(list.get(i));
                }else  if (getImageType(list.get(i).getName(),".png")){
                    list5.add(list.get(i));
                }else  if (getImageType(list.get(i).getName(),".pdf")){
                    list6.add(list.get(i));
                }else  if (getImageType(list.get(i).getName(),".docx")){
                    list7.add(list.get(i));
                }else{
                    list8.add(list.get(i));
                }
            }
        }

        list.clear();
        newList(list1,list);
        newList(list2,list);
        newList(list3,list);
        newList(list4,list);
        newList(list5,list);
        newList(list6,list);
        newList(list7,list);
        newList(list8,list);

        return list;

    }

    /**设置显示图片类型*/
    public static boolean getImageType(String content,String type2){
                return content.substring(content.indexOf(".")).toLowerCase().equals(type2);
    }
    /**将集合中的元素全部添加到新集合中*/
    private  static void newList(List<FileRepositoryGBean.ListBean> li,List<FileRepositoryGBean.ListBean> li1){
        for (int i = 0; i < li.size(); i++) {
            li1.add(li.get(i));
        }
        li.clear();
    }


}
