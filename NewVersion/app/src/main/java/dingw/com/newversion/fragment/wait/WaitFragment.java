package dingw.com.newversion.fragment.wait;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dingw.com.newversion.R;
import dingw.com.newversion.activity.StartCommonActivity;
import dingw.com.newversion.activity.TwoTopButtonActivity;
import dingw.com.newversion.activity.wait.MyActivity;
import dingw.com.newversion.adapter.wait.WaitLVAdapter;
import dingw.com.newversion.base.BaseBean;
import dingw.com.newversion.base.BaseFragment;
import dingw.com.newversion.bean.wait.ListViewBean;
import dingw.com.newversion.utils.HeightUtils;
import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by 12348 on 2017/5/3 0003.
 * 主页---待办fragment
 */

public class WaitFragment extends BaseFragment {
    @BindView(R.id.imageview_fragment_wait)
    ImageView ivIcon;
    @BindView(R.id.tv_totalmoney)
    TextView tvMoney;
    @BindView(R.id.imageview_fragment_waitemail)
    ImageView ivEmail;
    @BindView(R.id.tv_lvsuoname)
    TextView tvLvSuo;
    @BindView(R.id.tv_lawyername)
    TextView tvLawyer;
    @BindView(R.id.listview_wait1)
    ListView lvWait1;
    @BindView(R.id.listview_wait2)
    ListView lvWait2;
    Unbinder unbinder;

    /**
     * icon imageview
     */
    int resIdTop[] = {
            R.drawable.wait_caiwu,
            R.drawable.wait_anjian,
            R.drawable.wait_piban,
            R.drawable.wait_guwen,
            R.drawable.wait_notice,
            R.drawable.wait_newlaw
    };

    int contentIdTop[] = {
            R.string.finance,
            R.string.case2,
            R.string.resole,
            R.string.counselor,
            R.string.notice,
            R.string.newlaw
    };

    int resIdBottom[] = {
            R.drawable.wait_zixun,
            R.drawable.wait_weituo,
            R.drawable.wait_newlaw,
            R.drawable.wait_chanpin,
            R.drawable.wait_toubiao,
    };

    int contentIdBottom[] = {
            R.string.netizenconsult,
            R.string.netizenentrust,
            R.string.entrustindent,
            R.string.lawproduct,
            R.string.lawcall,
    };

    private List<BaseBean> listTop, listBottom;

    @Override
    public int setResid() {
        return R.layout.frag_wait;
    }

    @Override
    public void initContentView() {
        super.initContentView();
        if (getView()!=null){
            unbinder = ButterKnife.bind(this, getView());
        }

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void initData() {
        listTop = new ArrayList<>(6);
        listBottom = new ArrayList<>(5);

        for (int i = 0; i < resIdTop.length; i++) {
            ListViewBean listViewBean = new ListViewBean("可提现 1 | 可提押金 0", resIdTop[i],
                    "已批办14", contentIdTop[i]);
            listTop.add(listViewBean);
        }

        for (int i = 0; i < resIdBottom.length; i++) {
            ListViewBean listViewBean = new ListViewBean("可提现 1 | 可提押金 0", resIdBottom[i],
                    "已批办14", contentIdBottom[i]);
            listBottom.add(listViewBean);
        }

    }

    @Override
    public void initView() {
        WaitLVAdapter adapter1 = new WaitLVAdapter(getActivity(), listTop);
        WaitLVAdapter adapter2 = new WaitLVAdapter(getActivity(), listBottom);

        lvWait1.setAdapter(adapter1);
        lvWait2.setAdapter(adapter2);

        HeightUtils.setFixHeight(lvWait1);
        HeightUtils.setFixHeight(lvWait2);
        //加载圆形图片
        Glide.with(getContext())
                .load(R.drawable.icon_girl)
                .bitmapTransform(new CropCircleTransformation(getContext()))
                .into(ivIcon);



    }

    private void setListviewClick(ListView listView, final int type) {

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //text内文本是否进行跑马灯显示
//                textView = (MarqueeText) view.findViewById(R.id.textview_fragwait_right1);

//                if (beforePosition!=position){
//                    textView.startScroll();
//                    if (beforeTextView!=null){
//                        beforeTextView.stopScroll();
//                    }
//                    beforeTextView=textView;
//                    beforePosition=position;
//                    count=1;
//                }else {
//                    count++;
//                    if (count%2==0){
//                        textView.stopScroll();
//                    }else {
//                        textView.startScroll();
//                    }
//                }
                handleEvent(position, type);
            }
        });


    }

    private void handleEvent(int position, int type) {
        switch (type) {
            case 1:
                switch (position) {
                    case 0://待办--财务
                        StartCommonActivity.startAct(getActivity(), new String[]{"未到账", "可提现", "可提押金"}, new int[]{1, 0, 1}, "财务", false, "");
                        break;
                    case 1://待办--案件
                        Intent intent = new Intent(getActivity(), TwoTopButtonActivity.class);
                        intent.putExtra("count", new int[]{4, 2});
                        intent.putExtra("fragType1", new int[]{0, 32, 0, 0});
                        intent.putExtra("fragType2", new int[]{0, 33});
                        intent.putExtra("label1", new String[]{"未批办", "已批办", "一周开庭", "30天保全"});
                        intent.putExtra("label2", new String[]{"未批办", "已批办"});
                        intent.putExtra("top1", "诉讼案件");
                        intent.putExtra("top2", "非诉讼案件");
                        startActivity(intent);
                        break;
//                    case 2://待办--批办
//                        StartCommonActivity.startCommonActivity(getActivity(), new String[]{"诉讼", "非诉讼"}, new int[]{0, 0}, "未批办", false, "");
//                        break;
//                    case 3:
//                        StartCommonActivity.startCommonActivity(getActivity(), new String[]{"未受理工单", "未完成工单", "30天内到期单位"}, new int[]{0, 34, 0}, "顾问", false, "");
//                        break;
//                    case 4:
//                        StartCommonActivity.startCommonActivity(getActivity(), new String[]{"未读公告"}, new int[]{30}, "未读公告", false, "");
//                        break;
//                    case 5:
//                        StartCommonActivity.startCommonActivity(getActivity(), new String[]{"未读新法"}, new int[]{36}, "未读新法", false, "");
//                        break;
//                    case 6:
//                        break;
                }
                break;
            case 2:
                switch (position) {
//                    case 0:
//                        StartCommonActivity.startCommonActivity(getActivity(), new String[]{"等待处理"}, new int[]{35}, "网民咨询", false, "");
//                        break;
//                    case 1:
//                        StartCommonActivity.startCommonActivity(getActivity(), new String[]{""}, new int[]{0}, "网民委托", false, "");
//                        break;
//                    case 2:
//                        StartCommonActivity.startCommonActivity(getActivity(), new String[]{""}, new int[]{0}, "委托订单", false, "");
//                        break;
//                    case 3:
//                        StartCommonActivity.startCommonActivity(getActivity(), new String[]{""}, new int[]{0}, "法律服务订单", false, "");
//                        break;
//                    case 4:
//                        StartCommonActivity.startCommonActivity(getActivity(), new String[]{""}, new int[]{0}, "法律服务招投标", false, "");
//                        break;
                }
                break;
        }


    }


    @Override
    public void initListener() {
        setListviewClick(lvWait1, 1);
        setListviewClick(lvWait2, 2);
        ivIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {/**--------------------------*/
                Intent intent = new Intent(getActivity(), MyActivity.class);
                startActivityForResult(intent,1);
            }
        });
        ivEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StartCommonActivity.startAct(getActivity(), new String[]{"通知", "消息"}, new int[]{56, 57}, "通知", true, "全部已读");
            }
        });
    }

    @Override
    public void initLoad() {

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
