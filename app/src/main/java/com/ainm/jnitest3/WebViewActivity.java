package com.ainm.jnitest3;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.Toast;

public class WebViewActivity extends Activity {

    private WebView webView;
    private FrameLayout fullVideo;
    private View customView = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        Log.e("tag","WebViewActivity------onCreate");
        webView=findViewById(R.id.webView);
        fullVideo=findViewById(R.id.full_video);

        webView.loadUrl("https://www.iqiyi.com/");

        webView.setWebChromeClient(new MyWebChromeClient());
        webView.setWebViewClient(new WebViewClient());
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl("http://video.sina.com.cn/p/mil/doc/2018-09-28/135669028892.html");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("tag","WebViewActivity------onStart");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        String message=newConfig.orientation==Configuration.ORIENTATION_LANDSCAPE ? "屏幕设置为：横屏" : "屏幕设置为：竖屏";
        Log.e("tag","WebViewActivity----"+message);
    }

    private class MyWebChromeClient extends WebChromeClient {
        @Override public void onHideCustomView() {
            //退出全屏
            if (customView == null){ return; }
            //移除全屏视图并隐藏
            fullVideo.removeView(customView);
            fullVideo.setVisibility(View.GONE);
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            //设置竖屏
             getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
             //清除全屏
            } @Override
        public void onShowCustomView(View view, CustomViewCallback callback) {
            //进入全屏
            customView = view;
            fullVideo.setVisibility(View.VISIBLE);
            fullVideo.addView(customView);
            fullVideo.bringToFront();
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            //设置横屏
             getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//设置全屏
             }
        }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("tag","WebViewActivity------onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("tag","WebViewActivity------onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("tag","WebViewActivity------onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("tag","WebViewActivity------onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("tag","WebViewActivity------onDestroy");
    }
}
