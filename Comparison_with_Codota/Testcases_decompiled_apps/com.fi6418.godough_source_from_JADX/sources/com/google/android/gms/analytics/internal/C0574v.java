package com.google.android.gms.analytics.internal;

/* renamed from: com.google.android.gms.analytics.internal.v */
class C0574v implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f3902a;

    /* renamed from: b */
    final /* synthetic */ Runnable f3903b;

    /* renamed from: c */
    final /* synthetic */ C0572t f3904c;

    C0574v(C0572t tVar, String str, Runnable runnable) {
        this.f3904c = tVar;
        this.f3902a = str;
        this.f3903b = runnable;
    }

    public void run() {
        this.f3904c.f3899a.mo6691a(this.f3902a);
        if (this.f3903b != null) {
            this.f3903b.run();
        }
    }
}
