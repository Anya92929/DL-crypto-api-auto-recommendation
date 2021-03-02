package com.jackhenry.godough.core.wires;

import android.text.Editable;
import android.text.TextWatcher;

/* renamed from: com.jackhenry.godough.core.wires.c */
class C1927c implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ WireDetailsFragment f6902a;

    C1927c(WireDetailsFragment wireDetailsFragment) {
        this.f6902a = wireDetailsFragment;
    }

    public void afterTextChanged(Editable editable) {
        this.f6902a.m6965o();
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
