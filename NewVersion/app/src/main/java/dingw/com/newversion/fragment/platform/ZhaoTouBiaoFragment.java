package dingw.com.newversion.fragment.platform;

import android.content.Intent;
import android.view.View;

import dingw.com.newversion.R;
import dingw.com.newversion.activity.CommonActivity;
import dingw.com.newversion.base.BaseFragment;

/**
 * Created by 12348 on 2017/5/11 0011.
 * 主页--平台--法律服务招投标fragment
 *
 */

public class ZhaoTouBiaoFragment extends BaseFragment {

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
//                    Intent intent=new Intent(getActivity(),ZhaoTouBiaoActivity.class);
//                    getActivity().startActivity(intent);
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
