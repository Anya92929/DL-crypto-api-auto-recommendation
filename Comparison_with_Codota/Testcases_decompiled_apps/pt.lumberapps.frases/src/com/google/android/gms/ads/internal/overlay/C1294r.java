package com.google.android.gms.ads.internal.overlay;

import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzkh;

@zzin
/* renamed from: com.google.android.gms.ads.internal.overlay.r */
class C1294r implements Runnable {

    /* renamed from: a */
    private zzk f3757a;

    /* renamed from: b */
    private boolean f3758b = false;

    C1294r(zzk zzk) {
        this.f3757a = zzk;
    }

    /* renamed from: a */
    public void mo5426a() {
        this.f3758b = true;
        zzkh.zzclc.removeCallbacks(this);
    }

    /* renamed from: b */
    public void mo5427b() {
        zzkh.zzclc.postDelayed(this, 250);
    }

    public void run() {
        if (!this.f3758b) {
            this.f3757a.mo5512a();
            mo5427b();
        }
    }
}
