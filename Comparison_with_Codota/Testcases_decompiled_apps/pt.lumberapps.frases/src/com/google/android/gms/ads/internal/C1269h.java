package com.google.android.gms.ads.internal;

import android.view.MotionEvent;
import android.view.View;

/* renamed from: com.google.android.gms.ads.internal.h */
class C1269h implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ zze f3713a;

    /* renamed from: b */
    final /* synthetic */ C1268g f3714b;

    C1269h(C1268g gVar, zze zze) {
        this.f3714b = gVar;
        this.f3713a = zze;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.f3713a.recordClick();
        return false;
    }
}
