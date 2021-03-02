package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/* renamed from: com.google.android.gms.internal.ct */
public final class C0359ct extends C0348cr {
    public C0359ct(C0347cq cqVar, boolean z) {
        super(cqVar, z);
    }

    /* renamed from: b */
    private static WebResourceResponse m775b(Context context, String str, String str2) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
        try {
            C0337ci.m694a(context, str, true, httpURLConnection);
            httpURLConnection.connect();
            return new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(C0337ci.m688a((Readable) new InputStreamReader(httpURLConnection.getInputStream())).getBytes("UTF-8")));
        } finally {
            httpURLConnection.disconnect();
        }
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String url) {
        try {
            if (!"mraid.js".equalsIgnoreCase(new File(url).getName())) {
                return super.shouldInterceptRequest(webView, url);
            }
            if (!(webView instanceof C0347cq)) {
                C0344cn.m737q("Tried to intercept request from a WebView that wasn't an AdWebView.");
                return super.shouldInterceptRequest(webView, url);
            }
            C0347cq cqVar = (C0347cq) webView;
            cqVar.mo4212aw().mo4221S();
            if (cqVar.mo4211av().f1582ex) {
                C0344cn.m736p("shouldInterceptRequest(http://media.admob.com/mraid/v1/mraid_app_interstitial.js)");
                return m775b(cqVar.getContext(), this.f1029fG.mo4214ay().f1014hP, "http://media.admob.com/mraid/v1/mraid_app_interstitial.js");
            } else if (cqVar.mo4215az()) {
                C0344cn.m736p("shouldInterceptRequest(http://media.admob.com/mraid/v1/mraid_app_expanded_banner.js)");
                return m775b(cqVar.getContext(), this.f1029fG.mo4214ay().f1014hP, "http://media.admob.com/mraid/v1/mraid_app_expanded_banner.js");
            } else {
                C0344cn.m736p("shouldInterceptRequest(http://media.admob.com/mraid/v1/mraid_app_banner.js)");
                return m775b(cqVar.getContext(), this.f1029fG.mo4214ay().f1014hP, "http://media.admob.com/mraid/v1/mraid_app_banner.js");
            }
        } catch (IOException e) {
            C0344cn.m737q("Could not fetching MRAID JS. " + e.getMessage());
            return super.shouldInterceptRequest(webView, url);
        }
    }
}
