package com.google.android.gms.ads.internal.overlay;

import android.graphics.drawable.Drawable;

/* renamed from: com.google.android.gms.ads.internal.overlay.l */
class C1288l implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Drawable f3744a;

    /* renamed from: b */
    final /* synthetic */ C1287k f3745b;

    C1288l(C1287k kVar, Drawable drawable) {
        this.f3745b = kVar;
        this.f3744a = drawable;
    }

    public void run() {
        this.f3745b.f3743a.f3792o.getWindow().setBackgroundDrawable(this.f3744a);
    }
}
