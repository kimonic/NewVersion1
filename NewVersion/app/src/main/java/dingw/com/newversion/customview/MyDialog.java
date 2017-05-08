package dingw.com.newversion.customview;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import dingw.com.newversion.R;


/**
 * Created by 12348 on 2017/4/26 0026.
 * 自定义dialog--弹出回复对话框
 */

public class MyDialog {

    private Context context;
    /**布局文件中包含的控件*/
    private EditText dialogEdittext;
    private TextView dialogTextview;
    /**点击事件监听回调接口*/
    public interface DialogListener{
        void clickEvent();
    }
    private DialogListener listener;

    public MyDialog(Context context, DialogListener listener) {
        this.context = context;
        this.listener = listener;
    }

    /**显示评论弹出dialog*/
    public void showMyDialog() {
        View view= LayoutInflater.from(context).inflate(R.layout.dialog_item2,null);
        dialogEdittext= (EditText) view.findViewById(R.id.edittext_dialogitem);
        dialogTextview= (TextView) view.findViewById(R.id.textview_dialogitem);
        dialogTextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dialogEdittext.getText().toString().length()<5){
                    Toast.makeText(context, "评论内容不能少于5个字", Toast.LENGTH_SHORT).show();
                }
                //发表评论逻辑---------------------------成功后取消掉dialog
                listener.clickEvent();

            }
        });
        dialogEdittext.addTextChangedListener(new TextWatcher() {//监听edittext的输入变化
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length()==0){
                    dialogTextview.setBackgroundResource(R.drawable.xshape_tvrdbac_gray);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length()>0){
                    dialogTextview.setBackgroundResource(R.drawable.xshape_tvrdbac_blue);
                }
            }
        });

        AlertDialog.Builder builder=new AlertDialog.Builder(context,R.style.MyDialogTheme);
        AlertDialog dialog = builder.create();
        dialog.show();
        Window window= dialog.getWindow();
        window.setGravity(Gravity.BOTTOM);
        window.setWindowAnimations(R.style.dialogstyle);
        WindowManager.LayoutParams lp=window.getAttributes();
        lp.width=context.getResources().getDisplayMetrics().widthPixels;
        lp.height= WindowManager.LayoutParams.WRAP_CONTENT;//高
        window.setAttributes(lp);
        window.setContentView(view);
        window.clearFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
    }

}
