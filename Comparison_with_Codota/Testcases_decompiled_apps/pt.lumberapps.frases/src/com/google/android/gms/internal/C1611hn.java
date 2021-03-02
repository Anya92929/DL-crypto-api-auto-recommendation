package com.google.android.gms.internal;

/* renamed from: com.google.android.gms.internal.hn */
class C1611hn implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f5098a;

    /* renamed from: b */
    final /* synthetic */ String f5099b;

    /* renamed from: c */
    final /* synthetic */ zzfr f5100c;

    C1611hn(zzfr zzfr, String str, String str2) {
        this.f5100c = zzfr;
        this.f5098a = str;
        this.f5099b = str2;
    }

    public void run() {
        this.f5100c.f6192a.zzj(this.f5098a, this.f5099b);
    }
}
