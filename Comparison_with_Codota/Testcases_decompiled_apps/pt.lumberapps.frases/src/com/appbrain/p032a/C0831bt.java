package com.appbrain.p032a;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

/* renamed from: com.appbrain.a.bt */
final class C0831bt extends WebViewClient {

    /* renamed from: a */
    final /* synthetic */ C0829br f2193a;

    C0831bt(C0829br brVar) {
        this.f2193a = brVar;
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        if (C0884ds.m3840c() || this.f2193a.mo3829j()) {
            webView.loadData("<html><body style=\"color: #444; background-color: #fff\"><h2>There was a network error.</h2><p>Please check your internet connection and <a href=\"" + str2 + "\"> click here to try again</a>.</p><p><button onclick=\"" + "adApi.close()" + "\">Cancel</button></p></body></html>", "text/html", "utf-8");
            return;
        }
        Toast.makeText(this.f2193a.mo3827h(), "You are not connected to the internet", 0).show();
        this.f2193a.mo3727f();
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (this.f2193a.mo3829j()) {
            return true;
        }
        if (str.startsWith("/") || str.startsWith(this.f2193a.f2190f)) {
            return false;
        }
        C0842cd.m3720a(this.f2193a.mo3827h(), str, (C0844cf) null);
        return true;
    }
}
