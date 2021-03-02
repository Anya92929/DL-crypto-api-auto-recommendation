package com.google.android.gms.internal;

/* renamed from: com.google.android.gms.internal.ho */
class C1612ho implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f5101a;

    /* renamed from: b */
    final /* synthetic */ zzfr f5102b;

    C1612ho(zzfr zzfr, String str) {
        this.f5102b = zzfr;
        this.f5101a = str;
    }

    public void run() {
        this.f5102b.f6192a.loadData(this.f5101a, "text/html", "UTF-8");
    }
}
