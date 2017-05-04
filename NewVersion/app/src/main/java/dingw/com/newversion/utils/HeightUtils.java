package dingw.com.newversion.utils;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * Created by 12348 on 2017/5/3 0003.
 * 为listview设置固定高度
 */

public class HeightUtils {
    public static void  setFixHeight(ListView listView){
        ListAdapter adapter = listView.getAdapter();
        if (adapter != null) {
            int totalHeight = 0;
            for (int i = 0; i < adapter.getCount(); i++) {
                View listitem = adapter.getView(i, null, listView);
                listitem.measure(0, 0);
                totalHeight += listitem.getMeasuredHeight();
            }
            ViewGroup.LayoutParams params = listView.getLayoutParams();
            params.height = totalHeight + (listView.getDividerHeight() * (adapter.getCount() - 1));
            listView.setLayoutParams(params);
        }
    }
}
