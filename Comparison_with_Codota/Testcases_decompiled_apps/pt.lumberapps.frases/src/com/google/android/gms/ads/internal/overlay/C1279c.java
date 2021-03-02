package com.google.android.gms.ads.internal.overlay;

/* renamed from: com.google.android.gms.ads.internal.overlay.c */
class C1279c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f3733a;

    /* renamed from: b */
    final /* synthetic */ String f3734b;

    /* renamed from: c */
    final /* synthetic */ zzc f3735c;

    C1279c(zzc zzc, String str, String str2) {
        this.f3735c = zzc;
        this.f3733a = str;
        this.f3734b = str2;
    }

    public void run() {
        if (this.f3735c.f3777s != null) {
            this.f3735c.f3777s.zzl(this.f3733a, this.f3734b);
        }
    }
}
