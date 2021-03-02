package com.google.android.gms.analytics.internal;

import android.os.Looper;

/* renamed from: com.google.android.gms.analytics.internal.bf */
class C0546bf implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0545be f3796a;

    C0546bf(C0545be beVar) {
        this.f3796a = beVar;
    }

    public void run() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.f3796a.f3792a.mo6606h().mo7018a((Runnable) this);
            return;
        }
        boolean c = this.f3796a.mo6766c();
        long unused = this.f3796a.f3794d = 0;
        if (c && !this.f3796a.f3795e) {
            this.f3796a.mo6650a();
        }
    }
}
