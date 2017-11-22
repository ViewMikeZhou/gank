package com.chad.library.adapter.base.App.base;

import android.content.Context;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;


/**
 * Created by zhou on 2017/9/12.
 */

public abstract class BaseWebFragment extends BaseFragment {
    protected WebView mWebView;
    protected RelativeLayout mLlWebContainer;


    public void showWeb(Context context) {
        ViewGroup.LayoutParams layoutParams = mLlWebContainer.getLayoutParams();
        mWebView = new WebView(context);
        mWebView.setLayoutParams(layoutParams);
        initWebViewSetting();

    }

    private void initWebViewSetting() {
        //加载webview
        WebSettings webSettings = mWebView.getSettings();
        //设置自适应屏幕，两者合用
        webSettings.setUseWideViewPort(true); //将图片调整到适合webview的大小
        webSettings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);//设定可以缩放
        webSettings.setDisplayZoomControls(false);
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);  //设置自适应屏幕
        webSettings.setJavaScriptEnabled(true);
        //   String url = "http://" + (String) AppSP.get(Contact.APP_IP, "192.168.10.33:9032") + "/HDCWCount/mobile.html";
        mWebView.loadUrl(getUrl());
        useLocationOpen();
    }

    /**
     * 本地打开,每次请求会调用
     */
    private void useLocationOpen() {
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            //加载失败是调用
           /* @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                view.loadUrl("file:///android_asset/failload.html");
            }*/
        });
    }

    protected abstract String getUrl();

    /**
     * 释放资源
     */
    @Override
    public void replease() {

        if (mWebView == null) {
            return;
        }
        mWebView.loadUrl("about:blank");
        //  mWebView.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
        mWebView.removeAllViews();
        mWebView.clearHistory();
        if (mLlWebContainer != null) {
            mLlWebContainer.removeView(mWebView);
        }
        mWebView.destroy();
        mWebView = null;

    }
}
