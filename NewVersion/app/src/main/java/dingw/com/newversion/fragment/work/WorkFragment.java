package dingw.com.newversion.fragment.work;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import dingw.com.newversion.R;
import dingw.com.newversion.activity.StartCommonActivity;
import dingw.com.newversion.activity.TwoTopButtonActivity;
import dingw.com.newversion.activity.work.FileRepositoryActivity;
import dingw.com.newversion.activity.work.WorkTwoActivity;
import dingw.com.newversion.adapter.work.WorkGVAdapter;
import dingw.com.newversion.base.BaseFragment;
import dingw.com.newversion.bean.work.GridViewBean;
import dingw.com.newversion.constant.Constant;
import dingw.com.newversion.customview.IAVview;
import dingw.com.newversion.utils.HeightUtils;
import dingw.com.newversion.utils.LunarCalendarUtils;
import dingw.com.newversion.utils.TimeUtils;

/**
 * Created by 12348 on 2017/5/8 0008.
 * fragment work
 */

public class WorkFragment extends BaseFragment implements Runnable{
    @BindView(R.id.textview_fragwork_time)
    TextView textView_time;
    @BindView(R.id.textview_fragwork_timedetail)
    TextView textView_timeDetail;
    @BindView(R.id.imageaddtext_fragwork1)
    IAVview imageAddText1;
    @BindView(R.id.imageaddtext_fragwork2)
    IAVview imageAddText2;
    @BindView(R.id.imageaddtext_fragwork3)
    IAVview imageAddText3;
    @BindView(R.id.gridview_fragmentwork)
    GridView gridView;


    int pic[] = {
            R.drawable.work_othercase,//非诉讼案件
            R.drawable.work_mycontrol,//我要批办
            R.drawable.work_localfile,//本所文件库

            R.drawable.work_waitdiscuss,      //待讨论文件
            R.drawable.work_consultantunit,      //顾问单位
            R.drawable.work_consultantmenu,      //顾问工单
            R.drawable.work_myfinance,            //我的财务
            R.drawable.work_getmoney,            //提现管理

            R.drawable.work_cashpledge,          //押金管理
            R.drawable.work_othermoney,          //其他费用
            R.drawable.work_meetingjilu,         //会议记录
            R.drawable.work_qianyue,   //顾问签约
            R.drawable.work_addfinance,            //添加财务
            R.drawable.work_invoice,             //补开发票管理
    };

    int text[] = {
            R.string.othercase,
            R.string.mycontrol,
            R.string.localfile,
            R.string.daitaolunwenjian,
            R.string.guwendanwei,
            R.string.guwengongdan,
            R.string.wodecaiwu,

            R.string.tixianguali,
            R.string.yajinguanli,
            R.string.qitafeiyong,
            R.string.huiyijilu,

            R.string.guwenqianyue,
            R.string.tianjiacaiwu,
            R.string.bukaifapiaoguanli
    };

    private List<GridViewBean> list;
    /**线程控制*/
    private boolean timeStart=true;
    /**几点几分显示内容*/
    private String timeContent1;
    /**某年某月某日星期几显示内容*/
    private String timeContent2;
    /**处理时间更新*/
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {//更新时间显示
            if (msg.what==1){
                textView_time.setText(timeContent1);
            }
        }
    };
    private ArrayList<String> lsitLabel;


    @Override
    public int setResid() {
        return R.layout.frag_work;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imageaddtext_fragwork1://到账管理
                StartCommonActivity.startAct(getActivity(),new String[]{"未到账","已到账"},new int[]{1,1},"到账管理",false,"");
                break;
            case R.id.imageaddtext_fragwork2://本所公告
                startMyActivity("本所公告",0,WorkTwoActivity.class,new int[]{30}, Constant.NOTICE_SEARCH_URL,1);
                break;
            case R.id.imageaddtext_fragwork3://诉讼案件
                //----------------------------url需更改---------------------------------------
                startMyActivity("诉讼案件",1,WorkTwoActivity.class,new int[]{37},Constant.NOTICE_SEARCH_URL,1);
                break;
        }
    }

    @Override
    public void initData() {
        LunarCalendarUtils l=new LunarCalendarUtils(java.util.Calendar.getInstance());
        timeContent1= TimeUtils.getCurentTime();
        timeContent2=TimeUtils.getStringDateShort()+"    "+TimeUtils.getWeek(TimeUtils.getNowDateShort())
                +"\n"+ l.toString();

        list=new ArrayList<>();
        for (int i=0;i<pic.length;i++){
            GridViewBean gridViewBean=new GridViewBean(text[i],pic[i]);
            list.add(gridViewBean);
        }


    }

    @Override
    public void initView() {
        WorkGVAdapter adapter = new WorkGVAdapter(getActivity(), list);
        gridView.setAdapter(adapter);
        int gridviewColumns = 3;
        HeightUtils.setListViewHeight(gridView, gridviewColumns);
        textView_time.setText(timeContent1);
        textView_timeDetail.setText(timeContent2);
        new Thread(this).start();//启动更新时间线程
    }

    @Override
    public void initListener() {
        imageAddText1.setOnClickListener(this);
        imageAddText2.setOnClickListener(this);
        imageAddText3.setOnClickListener(this);
        setGridViewClickListener(gridView);
    }

    @Override
    public void initLoad() {

    }

    /**gridview子项点击事件*/
    private void setGridViewClickListener(GridView gridView) {

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0://工作--非诉讼案件
                        //-------------------url需更改-----------------------------------
                        startMyActivity("非诉讼案件",1,WorkTwoActivity.class,new int[]{38}, Constant.NOTICE_SEARCH_URL,1);
                        break;
                    case 1://工作--我要批办
                        //-------------------url需更改-----------------------------------
                        Intent intent=new Intent(getActivity(), TwoTopButtonActivity.class);
                        intent.putExtra("count",new int[]{2,2});
                        intent.putExtra("fragType1",new int[]{0,39});
                        intent.putExtra("fragType2",new int[]{0,40});
                        intent.putExtra("label1",new String[]{"未批办","已批办"});
                        intent.putExtra("label2",new String[]{"未批办","已批办"});
                        intent.putExtra("top1","诉讼批办");
                        intent.putExtra("top2","非诉讼批办");
                        startActivity(intent);
                        break;
                    case 2://工作--本所文件库
                        Intent intent2=new Intent(getActivity(), FileRepositoryActivity.class);
                        intent2.putExtra("title","本所文件库");
                        startActivity(intent2);
                        break;
                    case 3://工作--待讨论文件
                        //-------------------url需更改-----------------------------------
                        Intent intent3=new Intent(getActivity(), FileRepositoryActivity.class);
                        intent3.putExtra("title","待讨论文件");
                        startActivity(intent3);
//                        startMyActivity("待讨论文件",0,WorkTwoActivity.class,new int[]{30},Constant.NOTICE_SEARCH_URL,1);
                        break;
                    case 4:///工作--顾问单位
                        //-------------------url需更改-----------------------------------
                        startMyActivity("顾问单位",0,WorkTwoActivity.class,new int[]{41},Constant.NOTICE_SEARCH_URL,1);
                        break;
                    case 5://工作--顾问工单
                        StartCommonActivity.startAct(getActivity(),new String[]{"未受理","受理中","已完成"},new int[]{0,34,34},"顾问工单",false,"");
                        break;
                    case 6://工作--我的财务
                        StartCommonActivity.startAct(getActivity(),new String[]{"2015","2016","2017"},new int[]{42,42,42},"我的财务",false,"");
                        break;
                    case 7://工作--提现管理
                        StartCommonActivity.startAct(getActivity(),new String[]{"审核中","已审核","已提取"},new int[]{43,0,44},"提现管理",false,"");
                        break;
                    case 8://工作--押金管理
                        StartCommonActivity.startAct(getActivity(),new String[]{"审核中","已审核","已提取"},new int[]{45,46,47},"押金管理",false,"");
                        break;
                    case 9://工作--其他费用
                        StartCommonActivity.startAct(getActivity(),new String[]{""},new int[]{48},"其他费用",false,"");
                        break;
                    case 10:
                        startMyActivity("会议记录",0,WorkTwoActivity.class,new int[]{31},Constant.MINUTE_SEARCH_URL,2);
                        break;
                    case 11:
                        StartCommonActivity.startAct(getActivity(),new String[]{""},new int[]{0},"顾问签约",false,"");
                        break;
                    case 12:
                        StartCommonActivity.startAct(getActivity(),new String[]{""},new int[]{0},"添加财务",false,"");
                        break;
                    case 13:
                        StartCommonActivity.startAct(getActivity(),new String[]{""},new int[]{0},"补开发票管理",false,"");
                        break;
                }
            }
        });

    }

    @Override
    public void run() {
        while (timeStart){
            try {
                Thread.sleep(3000);
                if (!timeContent1.equals(TimeUtils.getCurentTime())){
                    timeContent1=TimeUtils.getCurentTime();
                    Message message=Message.obtain();
                    message.what=1;
                    handler.sendMessage(message);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        timeStart=false;//停止线程
    }

    /**start next activity*/
    private void startMyActivity(String title,int type,Class activity,int[] fragmenttype ,String url,int searchacttype){
        Intent intent=new Intent(getActivity(),activity);
        intent.putExtra("fragmenttype",fragmenttype);
        intent.putExtra("title",title);
        intent.putExtra("type",type);
        intent.putExtra("url",url);
        intent.putExtra("searchacttype",searchacttype);
        startActivity(intent);
    }

}
