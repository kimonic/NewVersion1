package dingw.com.newversion.activity;

import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dingw.com.newversion.adapter.work.FileReposXLVAdapter;
import dingw.com.newversion.base.BaseActivity;
import dingw.com.newversion.base.BaseBean;
import dingw.com.newversion.bean.work.FileRepositoryBean;
import dingw.com.newversion.customview.TopBar;
import dingw.com.newversion.http.HttpGP;
import dingw.com.newversion.jsonparse.LocalFileRepositoryJsonParse;
import okhttp3.Call;
import okhttp3.Callback;


/**
 * Created by 12348 on 2017/3/31 0031.
 *
 */

public class LocalFileRepositoryUtil {
    /**json数据解析bean list 数据源*/
    private List<BaseBean> list;
    /**listview适配器*/
    private FileReposXLVAdapter adapter;
    /**基础URL连接*/
    private String baseUrl = "http://ceshi.12348oa.com/v1.4/lawyerapp/Wenjian/BenSuoWenJianKuLieBiao1";
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

    private BaseActivity activity;
    private ProgressBar progressbar;
    private ListView listView;
    private View topBar;

    public LocalFileRepositoryUtil(List<BaseBean> list, FileReposXLVAdapter adapter,
                                   String baseUrl, List<List<BaseBean>> backList,
                                   List<Integer> backPosition, List<String> backText, BaseActivity activity,
                                   ProgressBar progressbar, ListView listView, View topBar) {
        this.list = list;
        this.adapter = adapter;
        this.baseUrl = baseUrl;
        this.backList = backList;
        this.backPosition = backPosition;
        this.backText = backText;
        this.activity = activity;
        this.progressbar = progressbar;
        this.listView = listView;
        this.topBar = topBar;
    }

    /**
     * 网络加载json数据并解析展示到listview中
     */
    public void showJson2Listview(final int position) {
        //xlistview 含有一个headview,默认位置从1开始
        backPosition.add(position);
        if (((FileRepositoryBean)(backList.get(backList.size()-1).get(position-1))).getFolder_name() != null) {//-------------------
            progressbar.setVisibility(View.VISIBLE);

            //拼写新的url
            String newUrl = baseUrl  + ((FileRepositoryBean)backList.get(backList.size()-1).get(position-1)).getFolder_uuid();

            HttpGP.sendOkhttpGetRequest(newUrl, new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                    backPosition.remove(backPosition.size() - 1);
                    Toast.makeText(activity, "加载失败,请检查网络连接", Toast.LENGTH_SHORT).show();

                }

                @Override
                public void onResponse(Call call, okhttp3.Response response) throws IOException {

                    final String jsonContent = response.body().string();

                    //在此处处理根据获得json数据获得的state状态进行相应异常处理

                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            //解析json数据
                            List<BaseBean> twoList = new ArrayList<>();
                            LocalFileRepositoryJsonParse jsonparse = new LocalFileRepositoryJsonParse(jsonContent, twoList);
                            jsonparse.getParseJson();


                            if (twoList.size() > 0) {
                                if (topBar instanceof TopBar){
                                    ((TopBar)topBar).setTvText(((FileRepositoryBean)backList.get(backList.size()-1).get(position-1)).getFolder_name());//设置标题
                                    backText.add(((TopBar)topBar).getTvText());//添加回退标题
                                }else if (topBar instanceof TextView){
                                    ((TextView)topBar).setText(((FileRepositoryBean)backList.get(backList.size()-1).get(position-1)).getFolder_name());//设置标题
                                    backText.add(((TextView)topBar).getText().toString());//添加回退标题
                                }


                                adapter.setList(twoList);
                                backList.add(twoList);//有数据显示时添加回退list

                                adapter.notifyDataSetChanged();
                            } else {

                                backPosition.remove(backPosition.size() - 1);//无数据显示时移除记录的回退点击位置
                                Toast.makeText(activity, "当前没有显示内容", Toast.LENGTH_SHORT).show();

                            }
                            progressbar.setVisibility(View.GONE);
                        }
                    });

                }
            }, activity);
        } else {
            Toast.makeText(activity, "当前没有显示内容", Toast.LENGTH_SHORT).show();
            backPosition.remove(backPosition.size() - 1);//无数据显示时移除记录的回退点击位置
            //处理文件点击事件
        }
    }

    /**
     * 顶部返回键和back键回退事件处理
     */
    public void backEvent() {
        if (backList.size() > 1) {

            adapter.setList(backList.get(backList.size() - 2));//处理回退数据源
            backList.get(backList.size() - 1).clear();
            backList.remove(backList.get(backList.size() - 1));
            adapter.notifyDataSetChanged();

            listView.setSelection(backPosition.get(backList.size() - 1));//无滑动效果显示到指定位置,处理回退listview位置
            backPosition.remove(backPosition.size() - 1);
            if (topBar instanceof TopBar){
                ((TopBar)topBar).setTvText(backText.get(backText.size() - 2));//处理回退topbar标题
            }else if (topBar instanceof TextView){
                ((TextView)topBar).setText(backText.get(backText.size() - 2));//处理回退topbar标题
            }
            backText.remove(backText.size() - 1);
//            listView.post(new Runnable() {//有滑动效果显示到指定位置
//                @Override
//                public void run() {
//                    listView.smoothScrollToPosition(backPosition);
//                }
//            });

        } else {
            activity.finish();
        }
    }

}
