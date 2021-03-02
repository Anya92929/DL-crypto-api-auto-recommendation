package com.appbrain.p032a;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

/* renamed from: com.appbrain.a.cq */
final class C0855cq extends WebViewClient {

    /* renamed from: a */
    final /* synthetic */ ProgressBar f2266a;

    /* renamed from: b */
    final /* synthetic */ C0854cp f2267b;

    C0855cq(C0854cp cpVar, ProgressBar progressBar) {
        this.f2267b = cpVar;
        this.f2266a = progressBar;
    }

    public final void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.f2266a.setVisibility(8);
        this.f2267b.f2261a.removeCallbacksAndMessages((Object) null);
        this.f2267b.f2261a.postDelayed(new C0856cr(this, str), 1000);
    }

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        this.f2267b.f2261a.removeCallbacksAndMessages((Object) null);
        if (C0842cd.m3725a(str)) {
            String unused = this.f2267b.f2265e = str;
        }
        if (!C0854cp.m3756a(this.f2267b, str)) {
            this.f2266a.setVisibility(0);
            this.f2267b.f2263c.setVisibility(8);
        }
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        if (!C0884ds.m3840c()) {
            this.f2267b.f2263c.setVisibility(0);
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return C0854cp.m3756a(this.f2267b, str);
    }
}
