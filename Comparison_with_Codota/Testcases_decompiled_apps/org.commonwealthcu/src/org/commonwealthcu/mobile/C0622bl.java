package org.commonwealthcu.mobile;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* renamed from: org.commonwealthcu.mobile.bl */
final class C0622bl extends WebViewClient {

    /* renamed from: a */
    private /* synthetic */ C0620bj f838a;

    C0622bl(C0620bj bjVar) {
        this.f838a = bjVar;
    }

    public final void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.f838a.f837c.mo5546b();
    }

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        this.f838a.f837c.mo5545a();
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str == null || str.startsWith("http")) {
            return false;
        }
        webView.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        return true;
    }
}
