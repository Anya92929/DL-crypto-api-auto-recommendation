package com.jackhenry.godough.core.widgets;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class GoDoughWebView extends WebView {
    public GoDoughWebView(Context context) {
        super(context);
        setupWebview();
    }

    public GoDoughWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setupWebview();
    }

    public GoDoughWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setupWebview();
    }

    @TargetApi(21)
    public GoDoughWebView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        setupWebview();
    }

    public GoDoughWebView(Context context, AttributeSet attributeSet, int i, boolean z) {
        super(context, attributeSet, i, z);
        setupWebview();
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public void setupWebview() {
        getSettings().setPluginState(WebSettings.PluginState.OFF);
        getSettings().setAppCacheEnabled(false);
        getSettings().setCacheMode(2);
        getSettings().setDatabaseEnabled(false);
        getSettings().setGeolocationEnabled(false);
        getSettings().setAllowContentAccess(false);
        getSettings().setAllowFileAccessFromFileURLs(false);
        getSettings().setJavaScriptCanOpenWindowsAutomatically(false);
        getSettings().setDomStorageEnabled(false);
        getSettings().setAllowUniversalAccessFromFileURLs(false);
        getSettings().setBuiltInZoomControls(true);
        getSettings().setDisplayZoomControls(false);
        getSettings().setUseWideViewPort(true);
        getSettings().setLoadWithOverviewMode(true);
        getSettings().setBlockNetworkLoads(true);
        getSettings().setJavaScriptEnabled(false);
        setWebViewClient(new C1921c(this));
        clearCache(true);
        getSettings().setLoadsImagesAutomatically(false);
        getSettings().setAllowFileAccess(false);
    }
}
