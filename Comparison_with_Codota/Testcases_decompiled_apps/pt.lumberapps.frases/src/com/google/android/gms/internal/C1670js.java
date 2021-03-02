package com.google.android.gms.internal;

import android.webkit.WebView;

/* renamed from: com.google.android.gms.internal.js */
class C1670js implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f5185a;

    /* renamed from: b */
    final /* synthetic */ String f5186b;

    /* renamed from: c */
    final /* synthetic */ zzhm f5187c;

    C1670js(zzhm zzhm, String str, String str2) {
        this.f5187c = zzhm;
        this.f5185a = str;
        this.f5186b = str2;
    }

    public void run() {
        WebView zzpl = this.f5187c.zzpl();
        zzpl.setWebViewClient(new C1671jt(this, zzpl));
        this.f5187c.f6349a.add(zzpl);
        zzpl.loadDataWithBaseURL(this.f5185a, this.f5186b, "text/html", "UTF-8", (String) null);
        zzkd.zzcv("Fetching assets finished.");
    }
}
