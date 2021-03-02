package com.google.android.gms.internal;

import android.webkit.ValueCallback;
import android.webkit.WebView;

/* renamed from: com.google.android.gms.internal.ee */
class C1521ee implements Runnable {

    /* renamed from: a */
    ValueCallback f4959a = new C1522ef(this);

    /* renamed from: b */
    final /* synthetic */ zzcl f4960b;

    /* renamed from: c */
    final /* synthetic */ WebView f4961c;

    /* renamed from: d */
    final /* synthetic */ boolean f4962d;

    /* renamed from: e */
    final /* synthetic */ zzco f4963e;

    C1521ee(zzco zzco, zzcl zzcl, WebView webView, boolean z) {
        this.f4963e = zzco;
        this.f4960b = zzcl;
        this.f4961c = webView;
        this.f4962d = z;
    }

    public void run() {
        if (this.f4961c.getSettings().getJavaScriptEnabled()) {
            try {
                this.f4961c.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.f4959a);
            } catch (Throwable th) {
                this.f4959a.onReceiveValue("");
            }
        }
    }
}
