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

@C1130ez
/* renamed from: com.google.android.gms.internal.gy */
public class C1245gy extends C1234gw {
    public C1245gy(C1232gv gvVar, boolean z) {
        super(gvVar, z);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public WebResourceResponse mo8685d(Context context, String str, String str2) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
        try {
            C1213gj.m4621a(context, str, true, httpURLConnection, true);
            httpURLConnection.addRequestProperty("Cache-Control", "max-stale=3600");
            httpURLConnection.connect();
            return new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(C1213gj.m4613a((Readable) new InputStreamReader(httpURLConnection.getInputStream())).getBytes("UTF-8")));
        } finally {
            httpURLConnection.disconnect();
        }
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String url) {
        try {
            if (!"mraid.js".equalsIgnoreCase(new File(url).getName())) {
                return super.shouldInterceptRequest(webView, url);
            }
            if (!(webView instanceof C1232gv)) {
                C1229gs.m4679W("Tried to intercept request from a WebView that wasn't an AdWebView.");
                return super.shouldInterceptRequest(webView, url);
            }
            C1232gv gvVar = (C1232gv) webView;
            gvVar.mo8631dv().mo8656bY();
            if (gvVar.mo8618Y().f2623og) {
                C1229gs.m4678V("shouldInterceptRequest(https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_interstitial.js)");
                return mo8685d(gvVar.getContext(), this.f3795md.mo8634dy().f3777wD, "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_interstitial.js");
            } else if (gvVar.mo8635dz()) {
                C1229gs.m4678V("shouldInterceptRequest(https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_expanded_banner.js)");
                return mo8685d(gvVar.getContext(), this.f3795md.mo8634dy().f3777wD, "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_expanded_banner.js");
            } else {
                C1229gs.m4678V("shouldInterceptRequest(https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_banner.js)");
                return mo8685d(gvVar.getContext(), this.f3795md.mo8634dy().f3777wD, "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_banner.js");
            }
        } catch (IOException e) {
            C1229gs.m4679W("Could not fetch MRAID JS. " + e.getMessage());
            return super.shouldInterceptRequest(webView, url);
        }
    }
}
