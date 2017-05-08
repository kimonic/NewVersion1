package dingw.com.newversion.activity.work;

import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import dingw.com.newversion.R;
import dingw.com.newversion.activity.LocalFileRepositoryUtil;
import dingw.com.newversion.adapter.work.FileReposXLVAdapter;
import dingw.com.newversion.base.BaseActivity;
import dingw.com.newversion.base.BaseBean;
import dingw.com.newversion.customview.TopBar;
import dingw.com.newversion.http.HttpGP;
import dingw.com.newversion.jsonparse.LocalFileRepositoryJsonParse;
import dingw.com.newversion.widget.XListView;
import okhttp3.Call;
import okhttp3.Callback;

/**
 * Created by 12348 on 2017/5/8 0008.
 * 本所文件库activity
 */

public class FileRepositoryActivity extends BaseActivity implements XListView.IXListViewListener {
    @BindView(R.id.topbar_filerepositoryact)
    TopBar topBar;
    /**
     * 搜索按钮
     */
    @BindView(R.id.linearlayout_filerepository_search)
    LinearLayout linearLayout;

    @BindView(R.id.listview_filerepository)
    XListView listView;
    /**
     * 进度条
     */
    @BindView(R.id.progressbar_filerepository)
    ProgressBar progressbar;

    /**
     * json数据解析bean list 数据源
     */
    private List<BaseBean> list;
    /**
     * listview适配器
     */
    private FileReposXLVAdapter adapter;
    /**
     * 基础URL连接--打开文件夹
     */
    private String baseUrl = "http://ceshi.12348oa.com/v1.4/lawyerapp/Wenjian/BenSuoWenJianKuLieBiao1?folder_uuid=";
    /**
     * 保存要返回的listview的数据源
     */
    private List<List<BaseBean>> backList;
    /**
     * 保存要返回的listview的显示位置
     */
    private List<Integer> backPosition;
    /**
     * 保存要返回的topbar中间文本内容
     */
    private List<String> backText;

    private LocalFileRepositoryUtil localFileRepositoryUtil;
    private String topTitle;


    @Override
    public void initContentView() {
        setContentView(R.layout.act_filerepository);
        ButterKnife.bind(this);
    }

    @Override
    public void initData() {
        topTitle=getIntent().getStringExtra("title");
        backText = new ArrayList<>();
        backPosition = new ArrayList<>();
        backList = new ArrayList<>();
        list = new ArrayList<>();

        backList.add(list);
        backText.add(topTitle);

    }

    @Override
    public void initView() {

        initXListview();
        adapter = new FileReposXLVAdapter(FileRepositoryActivity.this, list);
        listView.setAdapter(adapter);
        topBar.setTvText(topTitle);

        /**--------------------------------------------------------------------------*/
        localFileRepositoryUtil = new LocalFileRepositoryUtil(list, adapter, baseUrl, backList, backPosition
                , backText, this, progressbar, listView, topBar);
        /**--------------------------------------------------------------------------*/

    }

    private void initXListview() {
        listView.setPullRefreshEnable(true);//下拉刷新
        listView.setPullLoadEnable(true);//上拉加载
        listView.setAutoLoadEnable(true);//底部自动加载
        listView.setXListViewListener(this);//监听器
        listView.setRefreshTime(getTime());//加载时间

        //-----------------------------------------------------
    }

    @Override
    public void onRefresh() {
        onLoad();
    }

    @Override
    public void onLoadMore() {
        onLoad();
    }
    /**xlistview加载完成后取消加载提示*/
    public void onLoad() {
        listView.stopRefresh();
        listView.stopLoadMore();
        listView.setRefreshTime(getTime());
        showXlistview();

    }
    /**获取当前系统时间*/
    public String getTime() {
        return new SimpleDateFormat("MM-dd HH:mm", Locale.CHINA).format(new Date());
    }
    /**隐藏progressbar,显示xlistview*/
    public void showXlistview(){
        progressbar.setVisibility(View.GONE);
        listView.setVisibility(View.VISIBLE);
    }

    /**显示progressbar,隐藏xlistview*/
    public void showProgressbar(){
        progressbar.setVisibility(View.VISIBLE);
        listView.setVisibility(View.GONE);
    }

    @Override
    public void initListener() {
        topBar.setListener(new TopBar.ClickEvent() {

            @Override
            public void tvfinishClick() {
                localFileRepositoryUtil.backEvent();
            }

            @Override
            public void tvtextClick() {

            }

            @Override
            public void tvaddClick() {

            }
        });

        //启动搜索查询
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                switch (v.getId()) {
//                    case R.id.linearlayout_filerepository_search:
//                        Intent intent = new Intent(FileRepositoryActivity.this, SearchActivity.class);
//                        startActivity(intent);
//                        break;
//                }
            }
        });

        //listview 点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /**--------------------------------------------------------------------------*/
                localFileRepositoryUtil.showJson2Listview(position);

            }
        });
    }

    @Override
    public void onClick(View v) {

    }
    @Override
    protected void onResume() {
        test();//加载网络数据
        super.onResume();
    }
    /**
     * 网络加载数据模拟测试
     */
    private void test() {
        showProgressbar();

        String url = "http://ceshi.12348oa.com/v1.4/lawyerapp/Wenjian/BenSuoWenJianKuLieBiao1";

        HttpGP.sendOkhttpGetRequest(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(FileRepositoryActivity.this, "连接失败,请检查您的网络连接", Toast.LENGTH_SHORT).show();
                        showXlistview();
                    }
                });

            }

            @Override
            public void onResponse(Call call, okhttp3.Response response) throws IOException {


                final String jsonContent = response.body().string();


                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        LocalFileRepositoryJsonParse jsonparse = new LocalFileRepositoryJsonParse(jsonContent, list);
                        jsonparse.getParseJson();
                        if (list.size() > 0) {
                            progressbar.setVisibility(View.GONE);
                        } else {
                            Toast.makeText(FileRepositoryActivity.this, "当前没有显示内容", Toast.LENGTH_SHORT).show();
                        }
                        adapter.notifyDataSetChanged();
                        showXlistview();
                    }
                });

            }
        }, this);
    }


    /**
     * 按下返回键时,处理相应的回退事件
     */
    @Override
    public void onBackPressed() {
        /**--------------------------------------------------------------------------*/
        localFileRepositoryUtil.backEvent();
    }
}
