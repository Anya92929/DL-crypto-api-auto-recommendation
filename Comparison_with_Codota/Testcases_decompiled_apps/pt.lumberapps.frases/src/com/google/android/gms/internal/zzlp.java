package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.zzu;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@TargetApi(11)
@zzin
public class zzlp extends zzli {
    public zzlp(zzlh zzlh, boolean z) {
        super(zzlh, z);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public WebResourceResponse mo8878a(Context context, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("User-Agent", zzu.zzfq().zzg(context, str));
        hashMap.put("Cache-Control", "max-stale=3600");
        String str3 = (String) new zzkn(context).zzc(str2, hashMap).get(60, TimeUnit.SECONDS);
        if (str3 == null) {
            return null;
        }
        return new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(str3.getBytes("UTF-8")));
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (this.f6682b != null) {
            this.f6682b.zzcj(str);
        }
        try {
            if (!"mraid.js".equalsIgnoreCase(new File(str).getName())) {
                return super.shouldInterceptRequest(webView, str);
            }
            if (!(webView instanceof zzlh)) {
                zzkd.zzcx("Tried to intercept request from a WebView that wasn't an AdWebView.");
                return super.shouldInterceptRequest(webView, str);
            }
            zzlh zzlh = (zzlh) webView;
            zzlh.zzuj().zznx();
            String str2 = zzlh.zzdn().zzaus ? (String) zzdc.zzazd.get() : zzlh.zzun() ? (String) zzdc.zzazc.get() : (String) zzdc.zzazb.get();
            zzkd.m7303v(new StringBuilder(String.valueOf(str2).length() + 24).append("shouldInterceptRequest(").append(str2).append(")").toString());
            return mo8878a(zzlh.getContext(), this.f6681a.zzum().zzcs, str2);
        } catch (IOException | InterruptedException | ExecutionException | TimeoutException e) {
            String valueOf = String.valueOf(e.getMessage());
            zzkd.zzcx(valueOf.length() != 0 ? "Could not fetch MRAID JS. ".concat(valueOf) : new String("Could not fetch MRAID JS. "));
            return super.shouldInterceptRequest(webView, str);
        }
    }
}
