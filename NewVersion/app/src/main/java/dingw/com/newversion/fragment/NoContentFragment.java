package dingw.com.newversion.fragment;

import android.view.View;

import dingw.com.newversion.R;
import dingw.com.newversion.activity.CommonActivity;
import dingw.com.newversion.activity.StartCommonActivity;
import dingw.com.newversion.base.BaseFragment;

/**
 * Created by 12348 on 2017/5/6 0006.
 * no content fragment
 */

public class NoContentFragment extends BaseFragment {
    /**CommonTwoActivity的按钮点击回调接口*/
    private CommonActivity.CommonActListener listener;
    @Override
    public int setResid() {
        return R.layout.frag_nocontent;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void initData() {
        if (getActivity() instanceof CommonActivity){
            listener=new CommonActivity.CommonActListener() {
                @Override
                public void clickEvent() {
                    StartCommonActivity.startAct(getActivity(),new String[]{""},new int[]{0},"法律服务产品管理",false,"");

                }

            };

            ((CommonActivity) getActivity()).setListener(listener);
        }
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public void initLoad() {

    }
}
