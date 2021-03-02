package com.google.android.gms.ads.internal.formats;

import com.google.android.gms.internal.zzlh;

/* renamed from: com.google.android.gms.ads.internal.formats.k */
class C1267k implements Runnable {

    /* renamed from: a */
    final /* synthetic */ zzi f3637a;

    /* renamed from: b */
    final /* synthetic */ zzk f3638b;

    C1267k(zzk zzk, zzi zzi) {
        this.f3638b = zzk;
        this.f3637a = zzi;
    }

    public void run() {
        zzlh zzlb = this.f3637a.zzlb();
        if (zzlb != null && this.f3638b.f3705f != null) {
            this.f3638b.f3705f.addView(zzlb.getView());
        }
    }
}
