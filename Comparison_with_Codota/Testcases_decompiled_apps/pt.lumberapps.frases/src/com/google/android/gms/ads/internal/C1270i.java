package com.google.android.gms.ads.internal;

import android.view.View;

/* renamed from: com.google.android.gms.ads.internal.i */
class C1270i implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ zze f3715a;

    /* renamed from: b */
    final /* synthetic */ C1268g f3716b;

    C1270i(C1268g gVar, zze zze) {
        this.f3716b = gVar;
        this.f3715a = zze;
    }

    public void onClick(View view) {
        this.f3715a.recordClick();
    }
}
