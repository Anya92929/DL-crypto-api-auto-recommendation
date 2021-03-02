package com.appbrain.p032a;

import android.app.Activity;
import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import cmn.C0725at;

/* renamed from: com.appbrain.a.fc */
final class C0922fc extends WebViewClient {

    /* renamed from: a */
    final /* synthetic */ Activity f2417a;

    /* renamed from: b */
    final /* synthetic */ C0920fa f2418b;

    C0922fc(C0920fa faVar, Activity activity) {
        this.f2418b = faVar;
        this.f2417a = activity;
    }

    public final void onPageFinished(WebView webView, String str) {
        if (this.f2418b.f2415e || TextUtils.isEmpty(str) || C0725at.m3232b(this.f2417a)) {
            C0912et.f2394c.remove(this.f2418b);
            return;
        }
        boolean unused = this.f2418b.f2414d = true;
        if (this.f2418b.f2413c != null) {
            this.f2418b.f2413c.run();
        }
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        this.f2418b.m3910a();
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return C0920fa.m3911a(this.f2418b, str);
    }
}
