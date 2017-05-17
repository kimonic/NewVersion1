package dingw.com.newversion.fragment.platform;

import android.animation.ValueAnimator;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;
import dingw.com.newversion.R;
import dingw.com.newversion.adapter.plateform.WenShuLVAdapter;
import dingw.com.newversion.base.BaseBean;
import dingw.com.newversion.base.BaseFragment;
import dingw.com.newversion.bean.platform.WenShuBean;
import dingw.com.newversion.bean.platform.WenShuBean1;
import dingw.com.newversion.constant.Constant;
import dingw.com.newversion.http.HttpGP;
import dingw.com.newversion.utils.ToastUtils;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by 12348 on 2017/5/11 0011.
 * 主页--平台--文书fragment
 */

public class WenShuFragment extends BaseFragment {

    @BindView(R.id.textview_fragwenshu1)
    TextView flexButton1;
    @BindView(R.id.textview_fragwenshu2)    TextView texCount1;
    @BindView(R.id.textview_fragwenshu3)    TextView flexButton2;
    @BindView(R.id.textview_fragwenshu4)    TextView texCount2;
    @BindView(R.id.listview_fragwenshu1)
    ListView listview1;
    @BindView(R.id.listview_fragwenshu2)    ListView listview2;
    @BindView(R.id.linearlayout_fragwenshu1)
    LinearLayout linearlayout1;
    @BindView(R.id.linearlayout_fragwenshu2)    LinearLayout linearlayout2;

    private WenShuLVAdapter adapter1,adapter2;
    private List<BaseBean> list1,list2;
    /**根据listview的总高度设置LinearLayout的高度*/
    private int linHeight1,linHeight2;
    /**按钮点击次数计数*/
    private int count1=0,count2=0;

    private float changeHeight;

    private int type;


    @Override
    public int setResid() {
        return R.layout.frag_wenshu;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.textview_fragwenshu1:
                count1++;
                showFlexAnimation(count1,linHeight1,linearlayout1,flexButton1);
                break;
            case R.id.textview_fragwenshu3:
                count2++;
                showFlexAnimation(count2,linHeight2,linearlayout2,flexButton2);
                break;
        }
    }

    @Override
    public void initData() {
        if (getArguments()!=null){
            type=getArguments().getInt("type",0);
        }
        String url1= Constant.WENSHU+type+"&mark=1";
        String url2= Constant.WENSHU+type+"&mark=2";

        list1 = new ArrayList<>();
        list2 = new ArrayList<>();

        HttpGP.sendOkhttpGetRequest(url1, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
               fail();

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String str1=response.body().string();
                Gson gson=new Gson();
                WenShuBean1 wen1= gson.fromJson(str1,new TypeToken<WenShuBean1>(){}.getType());
                if (wen1.getState().equals("200")){
                    for (int i = 0; i < wen1.getDocument_list().size(); i++) {
                        list1.add(wen1.getDocument_list().get(i));
                    }
                    sucess1();
                }else {
                    fail();
                }


            }
        }, getActivity());
        HttpGP.sendOkhttpGetRequest(url2, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                fail();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String str2=response.body().string();
                Gson gson=new Gson();
                WenShuBean1 wen1= gson.fromJson(str2,new TypeToken<WenShuBean1>(){}.getType());
                if (wen1.getState().equals("200")){
                    for (int i = 0; i < wen1.getDocument_list().size(); i++) {
                        list2.add(wen1.getDocument_list().get(i));
                    }
                    sucess2();
                }else {
                    fail();
                }
            }
        }, getActivity());





//        for (int i = 0; i < 15; i++) {
//            WenShuBean bean = new WenShuBean();
//            if (i<9){
//                bean.setNum("0" + (i + 1));
//            }else {
//                bean.setNum("" + (i + 1));
//            }
//            bean.setTitle("文件" + i);
//            list1.add(bean);
//            list2.add(bean);
//        }
    }
    /**加载数据成功*/
    private void sucess1() {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                texCount1.setText(""+list1.size());
                adapter1=new WenShuLVAdapter(getActivity(),list1);
                listview1.setAdapter(adapter1);
                linHeight1=getListViewHeight(listview1);
                LinearLayout.LayoutParams params1=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,linHeight1);
                linearlayout1.setLayoutParams(params1);
                adapter1.notifyDataSetChanged();


            }
        });
    }
    /**加载数据成功*/
    private void sucess2() {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                texCount2.setText(""+list2.size());
                adapter2=new WenShuLVAdapter(getActivity(),list2);
                listview2.setAdapter(adapter2);
                linHeight2=getListViewHeight(listview2);
                LinearLayout.LayoutParams params2=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,linHeight2);
                linearlayout2.setLayoutParams(params2);
                adapter2.notifyDataSetChanged();

            }
        });
    }

    @Override
    public void initView() {




    }

    @Override
    public void initListener() {
        flexButton1.setOnClickListener(this);
        flexButton2.setOnClickListener(this);
    }

    @Override
    public void initLoad() {

    }
    /**加载数据失败*/
    private void fail(){
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ToastUtils.showToast(getActivity(),R.string.shujujiazaishibai);
            }
        });
    }

    /**显示点击伸缩动画
     *
     *
     * @param flexCount  按钮点击计数
     * @param height     linearlayout 的实际高度
     * @param linearLayout   LinearLayout
     * @param textView      点击的按钮
     */
    private void showFlexAnimation(int flexCount, final int height, final LinearLayout linearLayout, TextView textView) {
        if (flexCount%2==0){//展开
            ValueAnimator animatorCompat=ValueAnimator.ofFloat(0.0f,(float)( height));
            animatorCompat.setDuration(800);
            animatorCompat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    changeHeight= (float) animation.getAnimatedValue();
                    LinearLayout.LayoutParams  params=new LinearLayout.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT, (int)changeHeight);
                    linearLayout.setLayoutParams(params);
                    linearLayout.invalidate();


                }
            });
            animatorCompat.start();
            textView.setBackgroundResource(R.drawable.xvector_xiasanjiao);

        }else {//收起
            ValueAnimator animatorCompat=ValueAnimator.ofFloat(0.0f,(float)height);
            animatorCompat.setDuration(800);
            animatorCompat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    changeHeight= height-(float) animation.getAnimatedValue();
                    LinearLayout.LayoutParams  params=new LinearLayout.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT, (int)changeHeight);
                    linearLayout.setLayoutParams(params);
                    linearLayout.invalidate();
                }
            });
            animatorCompat.start();
            textView.setBackgroundResource(R.drawable.xvector_yousanjiao);

        }
    }

    /**获得listview的总高度*/
    private int getListViewHeight(ListView listView) {
        ListAdapter adapter=listView.getAdapter();
        if (adapter==null){
        }else{
            int totalHeight=0;
            for (int i = 0; i < adapter.getCount(); i++) {
                View listitem=adapter.getView(i,null,listView);
                listitem.measure(0,0);
                totalHeight+=listitem.getMeasuredHeight();
            }
            ViewGroup.LayoutParams params=listView.getLayoutParams();
            return  totalHeight+(listView.getDividerHeight()*(adapter.getCount()-1));
        }
        return 0;
    }
}
