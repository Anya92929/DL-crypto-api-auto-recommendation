package com.jackhenry.godough.core.accounts;

import android.support.p000v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.view.View;

/* renamed from: com.jackhenry.godough.core.accounts.v */
class C1467v implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ C1426f f5931a;

    /* renamed from: b */
    final /* synthetic */ C1465t f5932b;

    C1467v(C1465t tVar, C1426f fVar) {
        this.f5932b = tVar;
        this.f5931a = fVar;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (MotionEventCompat.getActionMasked(motionEvent) != 0) {
            return false;
        }
        this.f5932b.f5927c.onDragStart(this.f5931a);
        return false;
    }
}
