package dingw.com.newversion.base;

import android.content.Context;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by 12348 on 2017/5/3 0003.
 * adapter 基类
 */

public abstract class CustomAdapter extends BaseAdapter {
    public Context context;
    protected List<Object> list;

    public CustomAdapter(Context context, List<Object> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public Context getContext() {
        return context;
    }

    public List<Object> getList() {
        return list;
    }


}
