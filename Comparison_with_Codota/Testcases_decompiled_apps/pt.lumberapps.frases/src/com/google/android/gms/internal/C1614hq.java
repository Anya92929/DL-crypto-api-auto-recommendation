package com.google.android.gms.internal;

/* renamed from: com.google.android.gms.internal.hq */
class C1614hq implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f5105a;

    /* renamed from: b */
    final /* synthetic */ zzfr f5106b;

    C1614hq(zzfr zzfr, String str) {
        this.f5106b = zzfr;
        this.f5105a = str;
    }

    public void run() {
        this.f5106b.f6192a.loadUrl(this.f5105a);
    }
}
