package dingw.com.newversion.fragment.platform;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dingw.com.newversion.R;
import dingw.com.newversion.activity.StartCommonActivity;
import dingw.com.newversion.activity.work.WorkTwoActivity;
import dingw.com.newversion.base.BaseFragment;
import dingw.com.newversion.customview.IAVview_Horizontal;
import dingw.com.newversion.customview.MyBanner;

/**
 * Created by 12348 on 2017/5/10 0010.
 * plateform fragment
 */

public class PlateformFragment extends BaseFragment {

    @BindView(R.id.mybanner_activity)
    MyBanner mybanner;
    @BindView(R.id.imageaddtext_fragplateform1)
    IAVview_Horizontal clickEvent1;
    @BindView(R.id.imageaddtext_fragplateform2)
    IAVview_Horizontal clickEvent2;
    @BindView(R.id.imageaddtext_fragplateform3)
    IAVview_Horizontal clickEvent3;
    @BindView(R.id.imageaddtext_fragplateform4)
    IAVview_Horizontal clickEvent4;
    @BindView(R.id.imageaddtext_fragplateform5)
    IAVview_Horizontal clickEvent5;
    @BindView(R.id.imageaddtext_fragplateform6)
    IAVview_Horizontal clickEvent6;
    @BindView(R.id.imageaddtext_fragplateform7)
    IAVview_Horizontal clickEvent7;
    @BindView(R.id.imageaddtext_fragplateform8)
    IAVview_Horizontal clickEvent8;
    @BindView(R.id.imageaddtext_fragplateform9)
    IAVview_Horizontal clickEvent9;
    @BindView(R.id.imageaddtext_fragplateform10)
    IAVview_Horizontal clickEvent10;
    @BindView(R.id.imageaddtext_fragplateform11)
    IAVview_Horizontal clickEvent11;
    @BindView(R.id.imageaddtext_fragplateform12)
    IAVview_Horizontal clickEvent12;



    @Override
    public int setResid() {
        return R.layout.frag_plateform;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
//            case R.id.imageaddtext_fragplateform1:
//                StartCommonActivity.startAct(getActivity(),new String[]{"未处理","已联系","已完成"},new int[]{0,49,50},"网民委托",false,"");
//                break;
//            case R.id.imageaddtext_fragplateform2:
//                StartCommonActivity.startAct(getActivity(),new String[]{"待支付","待确认","重新上传","已完成"},new int[]{51,0,0,52},"委托订单",false,"");
//                break;
            case R.id.imageaddtext_fragplateform3:
                StartCommonActivity.startAct(getActivity(),new String[]{"未受理","已受理"},new int[]{0,0},"法律服务订单",true,"产品");
                break;
//            case R.id.imageaddtext_fragplateform4:
//                StartCommonActivity.startAct(getActivity(),new String[]{"我的标书","所有标书"},new int[]{53,53},"法律服务招投标管理",true,"招标说明");
//                break;
//            case R.id.imageaddtext_fragplateform5:
//                StartCommonActivity.startAct(getActivity(),new String[]{""},new int[]{3},"案件进度",false,"");
//                break;
            case R.id.imageaddtext_fragplateform6:
                StartCommonActivity.startAct(getActivity(),new String[]{""},new int[]{0},"网上开庭",false,"");
                break;
            case R.id.imageaddtext_fragplateform7:
                StartCommonActivity.startAct(getActivity(),new String[]{""},new int[]{0},"网上立案",false,"");
                break;
            case R.id.imageaddtext_fragplateform8:
                StartCommonActivity.startAct(getActivity(),new String[]{""},new int[]{0},"关联案件查询",false,"");
                break;
            case R.id.imageaddtext_fragplateform9:
                startMyActivity("新法速递",0, WorkTwoActivity.class,new int[]{36},1,"",1);
                break;
//            case R.id.imageaddtext_fragplateform10:
//                startMyActivity("合同范本",0, WorkTwoActivity.class,new int[]{54},1,"",1);
//                break;
//            case R.id.imageaddtext_fragplateform11:
//                StartCommonActivity.startAct(getActivity(),new String[]{"刑事","民事","行政","仲裁"},new int[]{55,55,55,55},"文书",false,"");
//                break;
//            case R.id.imageaddtext_fragplateform12:
//                StartCommonActivity.startAct(getActivity(),new String[]{""},new int[]{4},"法律计算器",false,"");
//                break;
        }
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {
        clickEvent1.setOnClickListener(this);
        clickEvent2.setOnClickListener(this);
        clickEvent3.setOnClickListener(this);
        clickEvent4.setOnClickListener(this);
        clickEvent5.setOnClickListener(this);
        clickEvent6.setOnClickListener(this);
        clickEvent7.setOnClickListener(this);
        clickEvent8.setOnClickListener(this);
        clickEvent9.setOnClickListener(this);
        clickEvent10.setOnClickListener(this);
        clickEvent11.setOnClickListener(this);
        clickEvent12.setOnClickListener(this);
    }

    @Override
    public void initLoad() {

    }

    /**start next activity*/
    private void startMyActivity(String title,int type,Class activity,
                                 int[] fragmenttype ,int fragmentCount,String url,int searchacttype){
        Intent intent=new Intent(getActivity(),activity);
        intent.putExtra("title",title);
        intent.putExtra("type",type);
        intent.putExtra("fragmenttype",fragmenttype);
        intent.putExtra("fragmentCount",fragmentCount);
        intent.putExtra("url",url);
        intent.putExtra("searchacttype",searchacttype);
        startActivity(intent);

    }


}
