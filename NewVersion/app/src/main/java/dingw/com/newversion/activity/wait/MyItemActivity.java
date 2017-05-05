package dingw.com.newversion.activity.wait;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import dingw.com.newversion.R;
import dingw.com.newversion.adapter.wait.MyItemLVAdapter;
import dingw.com.newversion.base.BaseActivity;
import dingw.com.newversion.base.BaseBean;
import dingw.com.newversion.bean.wait.MyItemBean;
import dingw.com.newversion.customview.TopBar;
import dingw.com.newversion.utils.SaveUtils;

/**
 * Created by 12348 on 2017/5/5 0005.
 * my page item activity
 */

public class MyItemActivity extends BaseActivity {


    @BindView(R.id.textview_myfavorite)
    TextView textView;
    @BindView(R.id.imageview_myfavorite)
    ImageView imageView;
    @BindView(R.id.topbar_myfavorite)
    TopBar topbar;
    @BindView(R.id.listview_myactivityitem)
    ListView listView;

    /**启动activity时不同内容的标识*/
    private int flag;
    /**listview适配器数据源*/
    private List<BaseBean> list;
    /**存取信息*/
    private SaveUtils saveLoginInfo;
    /**listview的上次点击位置*/
    private int beforePosition=0;
    /**listview的适配器*/
    private MyItemLVAdapter adapter;

    private int content[]={
            R.string.xiaoxituisong,
            R.string.tuisongmiandarao,
            R.string.bensuogonggaotuisong,
            R.string.huiyituisong,
            R.string.kaitingtuisong,
            R.string.baoquantuisong,
            R.string.pibantuisong,
            R.string.guwentuisong,
            R.string.falvtuisong,
            R.string.xinfatuisong,
            R.string.wangmintuisong,
            R.string.goumaituisong
    };

    @Override
    public void initContentView() {
        setContentView(R.layout.act_myitem);
        ButterKnife.bind(this);
    }

    @Override
    public void initData() {
        flag=getIntent().getIntExtra("name",-1);


    }

    @Override
    public void initView() {
        switch (flag){
            case 0:
                textView.setVisibility(View.VISIBLE);
                imageView.setVisibility(View.VISIBLE);
                break;
            case 1:
                topbar.setTvText(R.string.yixiazai);
                break;
            case 2:
                listView.setVisibility(View.VISIBLE);
                saveLoginInfo=new SaveUtils(this,"tuisongshezhi");
                initList();
                adapter=new MyItemLVAdapter(this,list);
                listView.setAdapter(adapter);
                SetTwoListviewClickListener();
                topbar.setTvText(R.string.tuisongtongzhi);
                break;
            case 3:
                break;
            case 4:break;
            case 5:break;
            case 6:break;
            case 7:
                topbar.setTvText(R.string.shoujishiyong);
                break;
            case 8:
                topbar.setTvText(R.string.diannaoshiyong);
                break;
            case 9:break;
            case 10:break;
            case 11:break;
        }
    }

    private void initList() {
        list=new ArrayList<>();
        for (int i = 0; i < content.length; i++) {
            MyItemBean simpleBean=new MyItemBean(content[i],saveLoginInfo.getIntInfo(""+i,0));
            list.add(simpleBean);
        }
    }

    @Override
    public void initListener() {
        topbar.setListener(new TopBar.ClickEvent() {
            @Override
            public void tvfinishClick() {
                closeActivity();
            }

            @Override
            public void tvtextClick() {

            }

            @Override
            public void tvaddClick() {

            }
        });
    }

    @Override
    public void onClick(View v) {

    }


    private void SetTwoListviewClickListener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            private  int count=1;
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (beforePosition!=position&&saveLoginInfo.getIntInfo(""+position,0)==0
                        ){
                    count=1;
                    beforePosition=position;
                }else if (beforePosition!=position&&
                        saveLoginInfo.getIntInfo(""+position,0)==0){
                    count=1;
                    beforePosition=position;
                }else if (beforePosition!=position){
                    count=0;
                    beforePosition=position;
                }
                if (count%2==0){
                    saveLoginInfo.saveInfo(""+position,0);
                    ((MyItemBean)list.get(position)).setFlag(0);

                }else{
                    saveLoginInfo.saveInfo(""+position,1);
                    ((MyItemBean)list.get(position)).setFlag(1);
                }
                count++;
                adapter.notifyDataSetChanged();
            }
        });
    }
}
