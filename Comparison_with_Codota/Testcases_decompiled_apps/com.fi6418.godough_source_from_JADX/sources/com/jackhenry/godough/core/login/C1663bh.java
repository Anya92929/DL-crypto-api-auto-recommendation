package com.jackhenry.godough.core.login;

import android.text.Editable;
import android.text.TextWatcher;

/* renamed from: com.jackhenry.godough.core.login.bh */
class C1663bh implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ MFAActivity f6401a;

    C1663bh(MFAActivity mFAActivity) {
        this.f6401a = mFAActivity;
    }

    public void afterTextChanged(Editable editable) {
        this.f6401a.m6330h();
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
