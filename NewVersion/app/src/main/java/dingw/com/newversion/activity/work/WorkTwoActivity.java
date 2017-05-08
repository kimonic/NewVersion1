package dingw.com.newversion.activity.work;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import dingw.com.newversion.R;
import dingw.com.newversion.base.BaseActivity;
import dingw.com.newversion.fragment.FragmentFactory;

/**
 * Created by 12348 on 2017/5/8 0008.
 * work item activity
 * layout-----R.layout.act_worktwo
 * 带搜索的activity
 */

public class WorkTwoActivity extends BaseActivity {


    @BindView(R.id.linearlayout_worktwo)
    LinearLayout linearLayout_finish;
    @BindView(R.id.linearlayout_worktwo_search)    LinearLayout linearLayout_search;
    @BindView(R.id.textview_worktwo)
    TextView textView_title;
    @BindView(R.id.imageview_worktwo)
    ImageView imageView_add;
    /**fragment容器*/
    @BindView(R.id.framelayout_worktwo)
    FrameLayout fragContainer;
    /**
     * viewpager中加载的fragment的个数
     */
    private int fragmentCount;
    /**fragment的类型数组*/
    private int[] fragmentType;
    /**
     * fragmnet list
     */
    private List<Fragment> fragmentList;


    private int addType=0;
    private String title;

    private FragmentManager fragmentManager;

    private String url;

    private int searchActType=1;


    @Override
    public void initContentView() {
        setContentView(R.layout.act_worktwo);
        ButterKnife.bind(this);
    }

    @Override
    public void initData() {
        fragmentManager=getSupportFragmentManager();
        Intent intent=getIntent();
        fragmentCount=intent.getIntExtra("fragmentCount",0);
        fragmentType=intent.getIntArrayExtra("fragmenttype");
        title=getIntent().getStringExtra("title");
        url=getIntent().getStringExtra("url");
        searchActType=getIntent().getIntExtra("searchacttype",1);
        addType=getIntent().getIntExtra("type",0);
        FragmentFactory fragmentCollection=new FragmentFactory(fragmentType);
        fragmentList=fragmentCollection.getFragmentList();
    }

    @Override
    public void initView() {
        fragmentManager.beginTransaction().replace(R.id.framelayout_worktwo,fragmentList.get(0)).commit();
        textView_title.setText(title);
        switch (addType){
            case 0:imageView_add.setVisibility(View.GONE);break;
            case 1:imageView_add.setVisibility(View.VISIBLE);break;
        }
    }

    @Override
    public void initListener() {
        linearLayout_finish.setOnClickListener(this);
        linearLayout_search.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.linearlayout_worktwo:
                closeActivity();
                break;
            case R.id.linearlayout_worktwo_search:
                startMyActivity();
                break;
        }
    }

    private void startMyActivity(){
        switch (searchActType){
//            case 1:
//                Intent intent=new Intent(WorkTwoActivity.this,SearchCommonActivity.class);
//                intent.putExtra("type",new int[]{0});
//                intent.putExtra("url",url);
//                startActivity(intent);
//                break;
//            case 2:
//                Intent intent2=new Intent(WorkTwoActivity.this,MinuteSearchActivity.class);
//                intent2.putExtra("url",url);
//                startActivity(intent2);
//                break;
        }
    }
}
