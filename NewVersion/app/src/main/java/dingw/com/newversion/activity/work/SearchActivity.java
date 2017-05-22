package dingw.com.newversion.activity.work;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import dingw.com.newversion.R;
import dingw.com.newversion.activity.LocalFileRepositoryUtil;
import dingw.com.newversion.adapter.work.FileReposXLVAdapter;
import dingw.com.newversion.base.BaseActivity;
import dingw.com.newversion.base.BaseBean;
import dingw.com.newversion.bean.work.FileRepositoryGBean;
import dingw.com.newversion.http.HttpGP;
import dingw.com.newversion.utils.OrderList;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by 12348 on 2017/5/22 0022.
 * 本所文件库搜索
 */

public class SearchActivity extends BaseActivity {


    /**
     * 输入搜索内容edittext
     */
    @BindView(R.id.edittext_search)
    EditText editText;
    /**
     * 搜索点击按钮
     */
    @BindView(R.id.textview_search)
    TextView textView;
    /**
     * 结束本activity按钮
     */
    @BindView(R.id.imageview_search)
    ImageView imageView;

    @BindView(R.id.textview_pleaseinput)
    TextView textviewPleaseinput;
    @BindView(R.id.listview_search)
    ListView listviewSearch;
    @BindView(R.id.progressbar_search)
    ProgressBar progressbarSearch;

    @BindView(R.id.textview_searchtop)
    TextView topBar;
    /**
     * 基础url,搜索接口
     */
    private String baseUrl = "https://develapi.12348oa.com/flfw/file/getList?page=1&super_path=0&state=1&name=";
    /**基础URL,访问文件夹接口*/
    private String baseUrl1 = "https://develapi.12348oa.com/flfw/file/getList?page=1&state=1&super_path=";
    /**搜索的接口地址*/
    private String searchUrl;
    /**第一次listview展示的数据源*/
    private List<BaseBean> list;
    /**listview适配器*/
    private FileReposXLVAdapter adapter;
    /**本所文件库内处理二级加载和回退的辅助类*/
    private LocalFileRepositoryUtil localFileRepositoryUtil;

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
    private boolean proFlag=false;

    @Override
    public void initContentView() {
        setContentView(R.layout.act_search);
        ButterKnife.bind(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        backText = new ArrayList<>();
        backPosition = new ArrayList<>();
        backList = new ArrayList<>();
        list = new ArrayList<>();

        backList.add(list);
        backText.add(topBar.getText().toString());

        adapter = new FileReposXLVAdapter(this, list);
        listviewSearch.setAdapter(adapter);

        //结束本activity点击事件
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                localFileRepositoryUtil.backEvent();//---------------------------------
//                SearchActivity.this.finish();
            }
        });

        //搜索按钮点击事件
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (editText.getText().toString().trim().equals("")) {
                    showMyDialog();
                } else {
                    if (backList.size() > 1) {//再次搜索时相关逻辑处理
                        for (int i = backList.size() - 1; i > 0; i--) {
                            backList.remove(i);
                            backText.remove(i);
                        }
                        topBar.setText(backText.get(0));
                        list.clear();
                        adapter.setList(list);
                        adapter.notifyDataSetChanged();
                        listviewSearch.setVisibility(View.GONE);
                    }
                    proFlag=false;
                    progressbarSearch.setVisibility(View.VISIBLE);
                    textviewPleaseinput.setVisibility(View.GONE);
                    searchUrl = baseUrl + editText.getText().toString().trim();

                    HttpGP.sendOkhttpGetRequest(searchUrl, new Callback() {//发起网络请求
                        @Override
                        public void onFailure(Call call, IOException e) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(SearchActivity.this, "获取数据失败,请检查网络连接", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            final String jsonContent = response.body().string();
                            list.clear();
                            if (getSeachState(jsonContent)) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        listviewSearch.setVisibility(View.GONE);
                                        //解析json数据

                                        Gson gson=new Gson();
                                        FileRepositoryGBean bean=gson.fromJson(jsonContent,new TypeToken<FileRepositoryGBean>(){}.getType());

                                        if (bean.getList()!=null&&bean.getList().size() > 0) {
                                            OrderList.order(bean.getList());
                                            for (int i = 0; i < bean.getList().size(); i++) {
                                                list.add(bean.getList().get(i));
                                            }
                                            listviewSearch.setVisibility(View.VISIBLE);//
                                            adapter.notifyDataSetChanged();
                                        } else {
                                            listviewSearch.setVisibility(View.GONE);
                                            textviewPleaseinput.setVisibility(View.VISIBLE);
                                            textviewPleaseinput.setText("没有找到任何信息");
                                        }
                                        progressbarSearch.setVisibility(View.GONE);
                                        proFlag=true;

                                    }
                                });

                            } else {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        listviewSearch.setVisibility(View.GONE);
                                        textviewPleaseinput.setVisibility(View.VISIBLE);
                                        textviewPleaseinput.setText("没有找到任何信息");
                                        progressbarSearch.setVisibility(View.GONE);
                                        proFlag=true;
                                    }
                                });
                            }
                        }
                    }, SearchActivity.this);
//                    Toast.makeText(SearchActivity.this, "开始搜索", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //listview点击事件
        listviewSearch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (proFlag){
                    localFileRepositoryUtil.showJson2Listview(position+1);//------------------------

                }
            }
        });
        /**--------------------------------------------------------------------------*/
        localFileRepositoryUtil = new LocalFileRepositoryUtil(list, adapter, baseUrl1, backList, backPosition
                , backText, this, progressbarSearch, listviewSearch, topBar);
        /**--------------------------------------------------------------------------*/
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initLoad() {

    }

    @Override
    public void onClick(View v) {

    }

    /**
     * 设置搜索条件提示dialog
     */
    private void showMyDialog() {
        new AlertDialog.Builder(this)
                .setMessage("请先设置搜索条件")
                .setNegativeButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();
    }

    /**
     * 获得搜索结果的state,非200直接显示无搜索内容
     */
    private boolean getSeachState(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            if (jsonObject.getInt("state") != 200) {
                return false;
            } else {
                return true;
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }
    /**回退事件处理*/
    @Override
    public void onBackPressed() {
        localFileRepositoryUtil.backEvent();//----------------------------------------------
    }
}
