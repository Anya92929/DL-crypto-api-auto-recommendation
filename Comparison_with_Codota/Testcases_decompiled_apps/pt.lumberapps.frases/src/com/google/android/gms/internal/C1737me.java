package com.google.android.gms.internal;

import android.content.Context;

/* renamed from: com.google.android.gms.internal.me */
class C1737me implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f5336a;

    /* renamed from: b */
    final /* synthetic */ zzkh f5337b;

    C1737me(zzkh zzkh, Context context) {
        this.f5337b = zzkh;
        this.f5336a = context;
    }

    public void run() {
        synchronized (this.f5337b.f6612a) {
            String unused = this.f5337b.f6614c = this.f5337b.mo8669a(this.f5336a);
            this.f5337b.f6612a.notifyAll();
        }
    }
}
