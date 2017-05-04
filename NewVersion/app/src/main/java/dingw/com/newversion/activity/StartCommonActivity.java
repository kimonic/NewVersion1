package dingw.com.newversion.activity;

import android.content.Context;
import android.content.Intent;

import java.util.ArrayList;

/**
 * Created by 12348 on 2017/5/3 0003.
 * 根据参数启动二级activity commonactivity
 */

public class StartCommonActivity {
    /**
     *
     * @param label  导航条标签string数组
     * @param fragmentType  fragment类型数组
     * @param title    顶部标题
     * @param openshow  右侧图片是否显示
     */
    public static void startAct(Context context, String[] label, int[] fragmentType, String title, boolean openshow, String showText) {
        Intent intent=new Intent(context, CommonActivity.class);
        ArrayList<String> list=getLabelList(label);

        intent.putStringArrayListExtra("label",list);
        intent.putExtra("fragmentCount",fragmentType.length);
        intent.putExtra("title",title);
        intent.putExtra("openshow",openshow);
        intent.putExtra("fragmenttype",fragmentType);
        intent.putExtra("showtext",showText);
        context.startActivity(intent);
    }

    /**
     *
     * @param label  导航条label字符串数组
     * @return       返回导航条label字符串集合
     */
    private   static ArrayList<String> getLabelList(String[] label ){
        ArrayList<String> list=new ArrayList<>();
        for (int i = 0; i < label.length; i++) {
            list.add(label[i]);
        }
        return list;
    }
}
