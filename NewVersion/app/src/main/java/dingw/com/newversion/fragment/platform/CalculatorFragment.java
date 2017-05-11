package dingw.com.newversion.fragment.platform;

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import butterknife.BindView;
import butterknife.Unbinder;
import dingw.com.newversion.R;
import dingw.com.newversion.base.BaseFragment;

/**
 * Created by 12348 on 2017/5/11 0011.
 * 法律计算器二级页面fragment(webview 展示)
 */

public class CalculatorFragment extends BaseFragment {


    @BindView(R.id.webview_fragcalculator)
    WebView webview;
    @BindView(R.id.progressbar_fragcalculator)
    ProgressBar progressbar;

    private String url;
    @Override
    public int setResid() {
        return R.layout.frag_calculator;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void initData() {
        url = this.getArguments().getString("url");
    }

    @Override
    public void initView() {

        webview.loadUrl(url);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webview.getSettings().setUseWideViewPort(true);
//        webview.getSettings().setLoadWithOverviewMode(true);
        webview.getSettings().setUseWideViewPort(true);
        webview.getSettings().setSupportZoom(true);
        webview.getSettings().setBuiltInZoomControls(true);

    }

    @Override
    public void initListener() {

    }

    @Override
    public void initLoad() {
        webview.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressbar.setVisibility(View.GONE);
                webview.setVisibility(View.VISIBLE);

            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressbar.setVisibility(View.VISIBLE);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;

            }
        });
    }
}
