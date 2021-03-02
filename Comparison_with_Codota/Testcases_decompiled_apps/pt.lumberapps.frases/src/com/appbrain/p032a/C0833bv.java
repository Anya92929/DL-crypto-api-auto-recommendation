package com.appbrain.p032a;

import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

/* renamed from: com.appbrain.a.bv */
final class C0833bv extends WebChromeClient {

    /* renamed from: a */
    final /* synthetic */ C0829br f2196a;

    private C0833bv(C0829br brVar) {
        this.f2196a = brVar;
    }

    /* synthetic */ C0833bv(C0829br brVar, byte b) {
        this(brVar);
    }

    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        jsResult.confirm();
        return true;
    }

    public final void onProgressChanged(WebView webView, int i) {
        if (i > 20 && this.f2196a.f2189e.getVisibility() != 8) {
            this.f2196a.f2189e.setVisibility(8);
        }
        super.onProgressChanged(webView, i);
    }
}
