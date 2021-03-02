package com.jackhenry.godough.core.transfers;

import android.view.View;

/* renamed from: com.jackhenry.godough.core.transfers.e */
class C1900e implements View.OnFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ View.OnFocusChangeListener f6821a;

    /* renamed from: b */
    final /* synthetic */ TransfersFragment f6822b;

    C1900e(TransfersFragment transfersFragment, View.OnFocusChangeListener onFocusChangeListener) {
        this.f6822b = transfersFragment;
        this.f6821a = onFocusChangeListener;
    }

    public void onFocusChange(View view, boolean z) {
        if (this.f6821a != null) {
            this.f6821a.onFocusChange(view, z);
        }
        this.f6822b.m6897n();
    }
}
