package com.google.android.gms.ads.internal.request;

import com.google.android.gms.internal.zzfs;

/* renamed from: com.google.android.gms.ads.internal.request.o */
class C1314o implements Runnable {

    /* renamed from: a */
    final /* synthetic */ zzn f3931a;

    C1314o(zzn zzn) {
        this.f3931a = zzn;
    }

    public void run() {
        if (this.f3931a.f3966l != null) {
            this.f3931a.f3966l.release();
            zzfs.zzc unused = this.f3931a.f3966l = null;
        }
    }
}
