package com.jackhenry.godough.core.rda;

import android.view.View;

/* renamed from: com.jackhenry.godough.core.rda.e */
class C1814e implements View.OnFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ View.OnFocusChangeListener f6652a;

    /* renamed from: b */
    final /* synthetic */ DepositCheckFragment f6653b;

    C1814e(DepositCheckFragment depositCheckFragment, View.OnFocusChangeListener onFocusChangeListener) {
        this.f6653b = depositCheckFragment;
        this.f6652a = onFocusChangeListener;
    }

    public void onFocusChange(View view, boolean z) {
        if (this.f6652a != null) {
            this.f6652a.onFocusChange(view, z);
        }
        this.f6653b.m6688n();
    }
}
