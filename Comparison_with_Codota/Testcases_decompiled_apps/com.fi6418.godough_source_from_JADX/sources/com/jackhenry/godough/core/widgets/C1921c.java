package com.jackhenry.godough.core.widgets;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/* renamed from: com.jackhenry.godough.core.widgets.c */
class C1921c extends WebViewClient {

    /* renamed from: a */
    final /* synthetic */ GoDoughWebView f6882a;

    C1921c(GoDoughWebView goDoughWebView) {
        this.f6882a = goDoughWebView;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return true;
    }
}
