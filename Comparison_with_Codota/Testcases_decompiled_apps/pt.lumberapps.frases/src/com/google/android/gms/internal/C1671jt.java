package com.google.android.gms.internal;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/* renamed from: com.google.android.gms.internal.jt */
class C1671jt extends WebViewClient {

    /* renamed from: a */
    final /* synthetic */ WebView f5188a;

    /* renamed from: b */
    final /* synthetic */ C1670js f5189b;

    C1671jt(C1670js jsVar, WebView webView) {
        this.f5189b = jsVar;
        this.f5188a = webView;
    }

    public void onPageFinished(WebView webView, String str) {
        zzkd.zzcv("Loading assets have finished");
        this.f5189b.f5187c.f6349a.remove(this.f5188a);
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        zzkd.zzcx("Loading assets have failed.");
        this.f5189b.f5187c.f6349a.remove(this.f5188a);
    }
}
