package dingw.com.newversion.adapter.wait;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by 12348 on 2017/3/27 0027.
 * viewpager fragmentadapter
 */

public class Viewpager_Adapter extends FragmentPagerAdapter {
    private List<Fragment> list;
    private Context context;

    public Viewpager_Adapter(FragmentManager fm, List<Fragment> list, Context context) {
        super(fm);
        this.list = list;
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
