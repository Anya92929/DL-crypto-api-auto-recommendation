package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.internal.zzli;

/* renamed from: com.google.android.gms.internal.nb */
class C1761nb implements Runnable {

    /* renamed from: a */
    final /* synthetic */ zzli f5379a;

    C1761nb(zzli zzli) {
        this.f5379a = zzli;
    }

    public void run() {
        this.f5379a.f6681a.zzuu();
        zzd zzuh = this.f5379a.f6681a.zzuh();
        if (zzuh != null) {
            zzuh.zznx();
        }
        if (this.f5379a.f6689k != null) {
            this.f5379a.f6689k.zzen();
            zzli.zzb unused = this.f5379a.f6689k = null;
        }
    }
}
