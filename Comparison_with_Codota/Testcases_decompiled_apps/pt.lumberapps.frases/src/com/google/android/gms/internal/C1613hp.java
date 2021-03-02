package com.google.android.gms.internal;

/* renamed from: com.google.android.gms.internal.hp */
class C1613hp implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f5103a;

    /* renamed from: b */
    final /* synthetic */ zzfr f5104b;

    C1613hp(zzfr zzfr, String str) {
        this.f5104b = zzfr;
        this.f5103a = str;
    }

    public void run() {
        this.f5104b.f6192a.loadData(this.f5103a, "text/html", "UTF-8");
    }
}
