package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebView;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@zzin
public class zzhm implements zzhk {

    /* renamed from: a */
    final Set f6349a = Collections.synchronizedSet(new HashSet());

    /* renamed from: b */
    private final Context f6350b;

    public zzhm(Context context) {
        this.f6350b = context;
    }

    public void zza(String str, String str2, String str3) {
        zzkd.zzcv("Fetching assets for the given html");
        zzkh.zzclc.post(new C1670js(this, str2, str3));
    }

    public WebView zzpl() {
        WebView webView = new WebView(this.f6350b);
        webView.getSettings().setJavaScriptEnabled(true);
        return webView;
    }
}
