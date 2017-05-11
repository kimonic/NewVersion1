package dingw.com.newversion.fragment.platform;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import dingw.com.newversion.R;
import dingw.com.newversion.activity.platform.LawCalculatorActivity;
import dingw.com.newversion.adapter.plateform.LCGVAdapter;
import dingw.com.newversion.base.BaseBean;
import dingw.com.newversion.base.BaseFragment;
import dingw.com.newversion.bean.platform.GridViewBean;
import dingw.com.newversion.utils.HeightUtils;

/**
 * Created by 12348 on 2017/5/11 0011.
 * 平台---法律计算器菜单页
 */

public class LawCalculatorFragment extends BaseFragment {


    @BindView(R.id.gridview_fragment_lawcalculator)
    GridView gridview;
    @BindView(R.id.textview_fragment_lawcalculator)
    TextView textView;
    @BindView(R.id.scrollview_fragment_lawcalculator)
    ScrollView scrollView;
    /**gridview的列数*/
    private int gridviewColumns=3;

    private int[] title = new int[]{
            R.string.costscalculator,
            R.string.lawcostcalculator,
            R.string.yinhangdaikuan,

            R.string.caichanbaoquan,
            R.string.zhixingfei,
            R.string.yibao,

            R.string.riqi,
            R.string.yanchilixi,
            R.string.weiyuejin,

            R.string.renshensunhai,
            R.string.paimaiyongjin,
            R.string.sifajianding,

            R.string.zhongcai,
            R.string.fangwuhuandai,
            R.string.lihunfangchan,

            R.string.chaiqianbuchang,
            R.string.zhengdibuchang,
            R.string.falvfagui,

            R.string.caipanwenshu,
            R.string.zhuanlixinxi,
            R.string.xueweizhengshu,

            R.string.zuzhijigou,
            R.string.shixinzhixing,
            R.string.beizhixing,
            R.string.tudizhengshu,



    };
    private int[] dataColor=new int[]{
            R.color.datacolor1,
            R.color.datacolor2,
            R.color.datacolor3,


            R.color.datacolor4,
            R.color.datacolor5,
            R.color.datacolor6,


            R.color.datacolor7,
            R.color.datacolor8,
            R.color.datacolor9,


            R.color.datacolor10,
            R.color.datacolor11,
            R.color.datacolor12,


            R.color.datacolor13,
            R.color.datacolor14,
            R.color.datacolor15,


            R.color.datacolor16,
            R.color.datacolor17,
            R.color.datacolor18,


            R.color.datacolor19,
            R.color.datacolor20,
            R.color.datacolor21,


            R.color.datacolor22,
            R.color.datacolor23,
            R.color.datacolor24,


            R.color.datacolor25,
    };

    private List<BaseBean> list;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 0:
                    textView.setVisibility(View.GONE);
                    break;
                case 1:
                    textView.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };

    private boolean  onOff=true;
    private int height;
    private boolean start=false;


    @Override
    public int setResid() {
        return R.layout.frag_lawcalculator;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void initData() {
        list=new ArrayList<>();
        for (int i = 0; i < title.length; i++) {
            GridViewBean simpleBean=new GridViewBean(title[i],dataColor[i]);
            list.add(simpleBean);
        }
    }

    @Override
    public void initView() {
        LCGVAdapter adapter=new LCGVAdapter(getActivity(),list);
        gridview.setAdapter(adapter);
        HeightUtils.setListViewHeight(gridview,gridviewColumns);
        gridviewClickEvent(gridview);
        textView.setVisibility(View.GONE);
    }

    @Override
    public void initListener() {
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollView.scrollTo(0,0);
            }
        });
    }

    @Override
    public void initLoad() {
        new Thread(){//线程中检测scrollview的位置
            @Override
            public void run() {
                while (onOff){
                    try {
                        Thread.sleep(2000);
                        if (scrollView!=null){
                            height=scrollView.getScrollY();
                            if (height>100){
                                Message msg=Message.obtain();
                                msg.what=1;
                                handler.sendMessage(msg);
                                start=true;
                            }else if (height==0&&start){
                                Message msg=Message.obtain();
                                msg.what=0;
                                handler.sendMessage(msg);
                                start=false;
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }


    private void gridviewClickEvent(GridView gridview) {
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0://诉讼费计算器
                        startMyActivity(getActivity(),LawCalculatorActivity.class,new int[]{5});
                        break;
                    case 1://律师费计算器
                        startMyActivity(getActivity(),LawCalculatorActivity.class,new int[]{6});
                        break;
                    case 2://银行贷款利息计算器
                        startMyActivity(getActivity(),LawCalculatorActivity.class,new int[]{7});
                        break;
                    case 3:
                        startMyActivity(getActivity(),LawCalculatorActivity.class,new int[]{8});
                        break;
                    case 4:
                        startMyActivity(getActivity(),LawCalculatorActivity.class,new int[]{9});
                        break;
                    case 5:
                        startMyActivity(getActivity(),LawCalculatorActivity.class,new int[]{10});
                        break;
                    case 6:
                        startMyActivity(getActivity(),LawCalculatorActivity.class,new int[]{11});
                        break;
                    case 7:
                        startMyActivity(getActivity(),LawCalculatorActivity.class,new int[]{12});
                        break;
                    case 8:
                        startMyActivity(getActivity(),LawCalculatorActivity.class,new int[]{13});
                        break;
                    case 9:
                        startMyActivity(getActivity(),LawCalculatorActivity.class,new int[]{14});
                        break;
                    case 10:
                        startMyActivity(getActivity(),LawCalculatorActivity.class,new int[]{15});
                        break;
                    case 11:
                        startMyActivity(getActivity(),LawCalculatorActivity.class,new int[]{16});
                        break;
                    case 12:
                        startMyActivity(getActivity(),LawCalculatorActivity.class,new int[]{17});
                        break;
                    case 13:
                        startMyActivity(getActivity(),LawCalculatorActivity.class,new int[]{18});
                        break;
                    case 14:
                        startMyActivity(getActivity(),LawCalculatorActivity.class,new int[]{19});
                        break;
                    case 15:
                        startMyActivity(getActivity(),LawCalculatorActivity.class,new int[]{20});
                        break;
                    case 16:
                        startMyActivity(getActivity(),LawCalculatorActivity.class,new int[]{21});
                        break;
                    case 17:
                        startMyActivity(getActivity(),LawCalculatorActivity.class,new int[]{22});
                        break;
                    case 18:
                        startMyActivity(getActivity(),LawCalculatorActivity.class,new int[]{23});
                        break;
                    case 19:
                        startMyActivity(getActivity(),LawCalculatorActivity.class,new int[]{24});
                        break;
                    case 20:
                        startMyActivity(getActivity(),LawCalculatorActivity.class,new int[]{25});
                        break;
                    case 21:
                        startMyActivity(getActivity(),LawCalculatorActivity.class,new int[]{26});
                        break;
                    case 22:
                        startMyActivity(getActivity(),LawCalculatorActivity.class,new int[]{27});
                        break;
                    case 23:
                        startMyActivity(getActivity(),LawCalculatorActivity.class,new int[]{28});
                        break;
                    case 24:
                        startMyActivity(getActivity(),LawCalculatorActivity.class,new int[]{29});
                        break;
                }
            }
        });
    }
    private void startMyActivity(Context context, Class cls, int[] type) {
        Intent intent=new Intent(context, cls);
        intent.putExtra("type",type);
        startActivity(intent);
    }

}
