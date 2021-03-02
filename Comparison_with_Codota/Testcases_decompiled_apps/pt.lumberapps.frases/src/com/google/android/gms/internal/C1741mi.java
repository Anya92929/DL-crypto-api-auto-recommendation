package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebSettings;
import com.google.android.gms.internal.zzki;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.internal.mi */
class C1741mi implements Callable {

    /* renamed from: a */
    final /* synthetic */ Context f5342a;

    /* renamed from: b */
    final /* synthetic */ WebSettings f5343b;

    /* renamed from: c */
    final /* synthetic */ zzki.zzb f5344c;

    C1741mi(zzki.zzb zzb, Context context, WebSettings webSettings) {
        this.f5344c = zzb;
        this.f5342a = context;
        this.f5343b = webSettings;
    }

    /* renamed from: a */
    public Boolean call() {
        if (this.f5342a.getCacheDir() != null) {
            this.f5343b.setAppCachePath(this.f5342a.getCacheDir().getAbsolutePath());
            this.f5343b.setAppCacheMaxSize(0);
            this.f5343b.setAppCacheEnabled(true);
        }
        this.f5343b.setDatabasePath(this.f5342a.getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath());
        this.f5343b.setDatabaseEnabled(true);
        this.f5343b.setDomStorageEnabled(true);
        this.f5343b.setDisplayZoomControls(false);
        this.f5343b.setBuiltInZoomControls(true);
        this.f5343b.setSupportZoom(true);
        this.f5343b.setAllowContentAccess(false);
        return true;
    }
}
