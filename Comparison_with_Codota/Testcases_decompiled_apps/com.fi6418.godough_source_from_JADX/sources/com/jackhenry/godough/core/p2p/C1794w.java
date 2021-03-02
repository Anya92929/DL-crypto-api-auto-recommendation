package com.jackhenry.godough.core.p2p;

import android.view.View;

/* renamed from: com.jackhenry.godough.core.p2p.w */
class C1794w implements View.OnFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ View.OnFocusChangeListener f6599a;

    /* renamed from: b */
    final /* synthetic */ P2PFragment f6600b;

    C1794w(P2PFragment p2PFragment, View.OnFocusChangeListener onFocusChangeListener) {
        this.f6600b = p2PFragment;
        this.f6599a = onFocusChangeListener;
    }

    public void onFocusChange(View view, boolean z) {
        if (this.f6599a != null) {
            this.f6599a.onFocusChange(view, z);
        }
        this.f6600b.m6597w();
    }
}
