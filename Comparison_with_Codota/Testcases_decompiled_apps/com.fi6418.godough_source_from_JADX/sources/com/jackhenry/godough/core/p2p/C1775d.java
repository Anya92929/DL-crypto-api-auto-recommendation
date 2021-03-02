package com.jackhenry.godough.core.p2p;

import android.text.Editable;
import android.text.TextWatcher;

/* renamed from: com.jackhenry.godough.core.p2p.d */
class C1775d implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ P2PAddPersonFragment f6573a;

    C1775d(P2PAddPersonFragment p2PAddPersonFragment) {
        this.f6573a = p2PAddPersonFragment;
    }

    public void afterTextChanged(Editable editable) {
        this.f6573a.m6547p();
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
