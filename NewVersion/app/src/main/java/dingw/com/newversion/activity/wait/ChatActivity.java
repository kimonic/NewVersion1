package dingw.com.newversion.activity.wait;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import dingw.com.newversion.R;
import dingw.com.newversion.adapter.wait.FaceGVAdapter;
import dingw.com.newversion.adapter.wait.FaceVPAdapter;
import dingw.com.newversion.base.BaseActivity;
import dingw.com.newversion.bean.wait.Chatbean;
import dingw.com.newversion.fragment.wait.ChatFragment;
import dingw.com.newversion.gif.SingleGif;
import dingw.com.newversion.utils.MyDbHelper;

/**
 * Created by 12348 on 2017/5/4 0004.
 * 主页--待办--email点击--消息--聊天详情
 */

public class ChatActivity extends BaseActivity {

    @BindView(R.id.textview_chatact1)
    TextView title1;
    @BindView(R.id.textview_chatact2)
    TextView title2;
    @BindView(R.id.textview_chatactfinish)
    TextView actFinish;
    @BindView(R.id.framelayout_chatact)
    FrameLayout fragContainer;
    @BindView(R.id.imageview_chatact1)
    ImageView leftImage;
    @BindView(R.id.edittext_chatact1)
    EditText edit;
    @BindView(R.id.imageview_chatact2)
    ImageView rightImage;
    @BindView(R.id.textview_chatact3)
    TextView send;
    @BindView(R.id.linearlayout_xiangce)
    LinearLayout photo;
    @BindView(R.id.linearlayout_dakai)
    LinearLayout showPhoto;
    @BindView(R.id.viewpager_chatact)
    ViewPager faceViewpager;
    @BindView(R.id.linearlayout_chatact)
    LinearLayout faceBottom;


    /**
     * 聊天列表fragment
     */
    private ChatFragment fragmentChat;
    // 7列3行
    private int columns = 6;
    private int rows = 4;
    private List<String> staticFacesList;

    private List<View> views = new ArrayList<>();
    private String TAG = "chatlog";
    private String reply = "";//模拟回复
    private SimpleDateFormat sd;
    /**
     * 表情打开或者关闭计数
     */
    private int faceCount = 0;
    private int showPhotoCount = 0;

    private MyDbHelper helper = new MyDbHelper(this);

    /**消息序号*/
    private int xuhao=0;

    /**相册图片路径*/
    private String photoPath;



    @Override
    public void initContentView() {
        setContentView(R.layout.act_chat);
        ButterKnife.bind(this);
    }

    @Override
    public void initData() {
        helper.open();
        xuhao=helper.getTotalCount("zhitong");
        helper.close();
        sd = new SimpleDateFormat("MM-dd HH:mm", Locale.getDefault());

    }

    @Override
    public void initView() {
        FragmentManager manager = getSupportFragmentManager();
        fragmentChat = new ChatFragment();
        manager.beginTransaction().replace(R.id.framelayout_chatact, fragmentChat).commit();


        initStaticFaces();//初始化表情数据源
        initViewPager();//初始化表情展示
    }

    @Override
    public void initListener() {
        actFinish.setOnClickListener(this);
        leftImage.setOnClickListener(this);
        rightImage.setOnClickListener(this);
        send.setOnClickListener(this);
        photo.setOnClickListener(this);

        edit.addTextChangedListener(new TextWatcher() {//当有输入内容时,显示发送按钮
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 0) {
                    rightImage.setVisibility(View.GONE);
                    send.setVisibility(View.VISIBLE);
                } else {
                    rightImage.setVisibility(View.VISIBLE);
                    send.setVisibility(View.GONE);
                }
            }
        });
        faceViewpager.setOnPageChangeListener(new PageChange());

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.textview_chatactfinish://结束activity按钮
                this.finish();
                break;
            case R.id.imageview_chatact1://左侧点击发送表情的按钮
                if (faceCount % 2 == 0) {
                    if (showPhotoCount%2==1){
                        showPhoto.setVisibility(View.GONE);
                        showPhotoCount++;
                    }
                    faceViewpager.setVisibility(View.VISIBLE);
                    faceBottom.setVisibility(View.VISIBLE);

                } else {
                    faceViewpager.setVisibility(View.GONE);
                    faceBottom.setVisibility(View.GONE);
                }
                faceCount++;

                break;
            case R.id.imageview_chatact2://右侧点击选择图片按钮
                if (showPhotoCount%2==0){
                    if (faceCount % 2 == 1){
                        faceViewpager.setVisibility(View.GONE);
                        faceBottom.setVisibility(View.GONE);
                        faceCount++;
                    }
                    showPhoto.setVisibility(View.VISIBLE);
                }else {
                    showPhoto.setVisibility(View.GONE);
                }



                showPhotoCount++;


                break;
            case R.id.linearlayout_xiangce://打开手机相册
                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i,2);
                break;


            case R.id.textview_chatact3://点击发送消息按钮

                reply = edit.getText().toString();
                if (!TextUtils.isEmpty(reply)) {
                    Chatbean chat=getChatInfoTo(reply, 1);
                    fragmentChat.getList().add(chat);
                    Log.e(TAG, "onClick: ---"+ chat.toString());
                    fragmentChat.getAdapter().notifyDataSetChanged();
                    fragmentChat.getMyListview().setSelection(fragmentChat.getList().size() - 1);
                    fragmentChat.getMyListview().smoothScrollToPosition(fragmentChat.getList().size());

                    helper.open();
                    helper.createChatContent(chat);



/**--------------------------------------------模拟回复-------------------------------------------------*/
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Chatbean chat=getChatInfoTo(reply, 2);
                            fragmentChat.getList().add(chat);
//                            mLvAdapter.setList(infos);
                            fragmentChat.getAdapter().notifyDataSetChanged();
                            fragmentChat.getMyListview().setSelection(fragmentChat.getList().size() - 1);
                            fragmentChat.getMyListview().smoothScrollToPosition(fragmentChat.getList().size());
                            helper.createChatContent(chat);
                            Log.e(TAG, "onClick: -------"+ helper.getTotalCount("zhitong") );
                            helper.close();


                        }
                    }, 1000);
                    edit.setText("");
                }

/**------------------------------------------------------------------------------------------------------*/

                break;

        }
    }

    //获得被选择图片的相应路径相应的路径
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode ==2 && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };
            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            photoPath = cursor.getString(columnIndex);
            cursor.close();
            /**----------------------------------------------------------------------*/

            fragmentChat.getList().add(getChatInfoTo("",1));
            fragmentChat.getAdapter().notifyDataSetChanged();
            fragmentChat.getMyListview().setSelection(fragmentChat.getList().size() - 1);
            fragmentChat.getMyListview().smoothScrollToPosition(fragmentChat.getList().size());


            /**----------------------------------------------------------------------*/


//            iv.setImageBitmap(BitmapFactory.decodeFile(picturePath));
        }

    }

    /**
     * 发送的信息
     *
     * @param message  信息
     * @return  返回chatbean
     */
    private Chatbean getChatInfoTo(String message, int flag) {
        Chatbean info = new Chatbean();
        info.setTitle(message);
        info.setFlag(flag);
        info.setXuhao(xuhao);
        info.setTime(sd.format(new Date()));
        if (flag == 1) {
            info.setResId(R.drawable.icon_girl);
        } else {
            info.setResId(R.drawable.icon_boy);
        }

        if (photoPath!=null){
            info.setPhotoPath(photoPath);
            photoPath=null;
        }
        info.setName("zhitong");
        xuhao++;
        return info;
    }


    /**
     * 初始化viewpager---------------------------------------------------------------------------------------------
     */
    private void initViewPager() {
        // 获取页数
        for (int i = 0; i < getPagerCount(); i++) {
            views.add(viewPagerItem(i));
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            faceBottom.addView(dotsItem(i), params);
        }
        FaceVPAdapter mVpAdapter = new FaceVPAdapter(views);
        faceViewpager.setAdapter(mVpAdapter);

        if (faceBottom.getChildAt(0) != null) {
            faceBottom.getChildAt(0).setSelected(true);

        }
    }

    private ImageView dotsItem(int position) {
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.dot_image, null);
        ImageView iv = (ImageView) layout.findViewById(R.id.face_dot);
        iv.setId(position);
        return iv;
    }

    private View viewPagerItem(int position) {
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.face_gridview, null);//表情布局
        GridView gridview = (GridView) layout.findViewById(R.id.chart_face_gv);
        /**
         * 注：因为每一页末尾都有一个删除图标，所以每一页的实际表情columns *　rows　－　1; 空出最后一个位置给删除图标
         * */
        List<String> subList = new ArrayList<String>();
        subList.addAll(staticFacesList
                .subList(position * (columns * rows - 1),
                        (columns * rows - 1) * (position + 1) > staticFacesList
                                .size() ? staticFacesList.size() : (columns
                                * rows - 1)
                                * (position + 1)));
        /**
         * 末尾添加删除图标
         * */
        subList.add("emotion_del_normal.png");
        FaceGVAdapter mGvAdapter = new FaceGVAdapter(subList, this);
        gridview.setAdapter(mGvAdapter);
        gridview.setNumColumns(columns);
        // 单击表情执行的操作
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                try {
                    String png = ((TextView) ((LinearLayout) view).getChildAt(1)).getText().toString();
                    if (!png.contains("emotion_del_normal")) {// 如果不是删除图标
                        insert(getFace(png));
                    } else {
                        delete();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        return gridview;
    }

    /**
     * 删除图标执行事件
     * 注：如果删除的是表情，在删除时实际删除的是tempText即图片占位的字符串，所以必需一次性删除掉tempText，才能将图片删除
     */
    private void delete() {
        if (edit.getText().length() != 0) {
            int iCursorEnd = Selection.getSelectionEnd(edit.getText());
            int iCursorStart = Selection.getSelectionStart(edit.getText());
            if (iCursorEnd > 0) {
                if (iCursorEnd == iCursorStart) {
                    if (isDeletePng(iCursorEnd)) {
                        String st = "#[face/png/f_static_000.png]#";
                        ((Editable) edit.getText()).delete(
                                iCursorEnd - st.length(), iCursorEnd);
                    } else {
                        ((Editable) edit.getText()).delete(iCursorEnd - 1,
                                iCursorEnd);
                    }
                } else {
                    ((Editable) edit.getText()).delete(iCursorStart,
                            iCursorEnd);
                }
            }
        }
    }

    /**
     * 判断即将删除的字符串是否是图片占位字符串tempText 如果是：则将删除整个tempText
     **/
    private boolean isDeletePng(int cursor) {
        String st = "#[face/png/f_static_000.png]#";
        String content = edit.getText().toString().substring(0, cursor);
        if (content.length() >= st.length()) {
            String checkStr = content.substring(content.length() - st.length(),
                    content.length());
            String regex = "(\\#\\[face/png/f_static_)\\d{3}(.png\\]\\#)";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(checkStr);
            return m.matches();
        }
        return false;
    }

    private SpannableStringBuilder getFace(String png) {
        SpannableStringBuilder sb = new SpannableStringBuilder();
        try {
            /**
             * 格式：#[face/png/f_static_000.png]#，以方便判斷當前圖片是哪一個
             * */
            String tempText = "#[" + png + "]#";
            sb.append(tempText);

            sb.setSpan(
                    new ImageSpan(ChatActivity.this, SingleGif.getInstance(this).getGif(png)), sb.length()
                            - tempText.length(), sb.length(),
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return sb;
    }

    /**
     * 向输入框里添加表情
     */
    private void insert(CharSequence text) {
        int iCursorStart = Selection.getSelectionStart((edit.getText()));
        int iCursorEnd = Selection.getSelectionEnd((edit.getText()));
        if (iCursorStart != iCursorEnd) {
             edit.getText().replace(iCursorStart, iCursorEnd, "");
//            ((Editable) edit.getText()).replace(iCursorStart, iCursorEnd, "");
        }
        int iCursor = Selection.getSelectionEnd((edit.getText()));
         edit.getText().insert(iCursor, text);
//        ((Editable) edit.getText()).insert(iCursor, text);
    }

    /**
     * 根据表情数量以及GridView设置的行数和列数计算Pager数量
     *
     * @return   int
     */
    private int getPagerCount() {
        int count = staticFacesList.size();
        return count % (columns * rows - 1) == 0 ? count / (columns * rows - 1)
                : count / (columns * rows - 1) + 1;
    }

    /**
     * 初始化表情列表staticFacesList
     */
    private void initStaticFaces() {
        try {
            staticFacesList = new ArrayList<>();
            String[] faces = getAssets().list("face/png");
            //将Assets中的表情名称转为字符串一一添加进staticFacesList
            for (int i = 0; i < faces.length; i++) {
                staticFacesList.add(faces[i]);
            }

            //去掉删除图片
            staticFacesList.remove("emotion_del_normal.png");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class PageChange implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            for (int i = 0; i < faceBottom.getChildCount(); i++) {
                faceBottom.getChildAt(i).setSelected(false);
            }
            faceBottom.getChildAt(position).setSelected(true);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

}
