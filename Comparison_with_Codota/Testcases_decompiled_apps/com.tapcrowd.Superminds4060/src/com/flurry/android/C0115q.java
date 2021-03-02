package com.flurry.android;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/* renamed from: com.flurry.android.q */
final class C0115q extends WebViewClient {

    /* renamed from: a */
    private /* synthetic */ CatalogActivity f223a;

    C0115q(CatalogActivity catalogActivity) {
        this.f223a = catalogActivity;
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str == null) {
            return false;
        }
        if (this.f223a.f16f != null) {
            this.f223a.f16f.mo3325a(new C0104f((byte) 6, this.f223a.f15e.mo3362j()));
        }
        this.f223a.f15e.mo3341a(webView.getContext(), this.f223a.f16f, str);
        return true;
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        C0095ai.m104c("FlurryAgent", "Failed to load url: " + str2 + " with an errorCode of " + i);
        webView.loadData("Cannot find Android Market information. <p>Please check your network", "text/html", "UTF-8");
    }

    public final void onPageFinished(WebView webView, String str) {
        try {
            C0114p a = this.f223a.f16f;
            C0104f fVar = new C0104f((byte) 5, this.f223a.f15e.mo3362j());
            long j = this.f223a.f16f.f219d;
            a.f220e.add(fVar);
            a.f219d = j;
        } catch (Exception e) {
        }
    }
}
