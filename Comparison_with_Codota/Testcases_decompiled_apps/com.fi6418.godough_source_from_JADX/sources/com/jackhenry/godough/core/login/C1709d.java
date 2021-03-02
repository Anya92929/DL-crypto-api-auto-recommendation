package com.jackhenry.godough.core.login;

import android.text.Editable;
import android.text.TextWatcher;

/* renamed from: com.jackhenry.godough.core.login.d */
class C1709d implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ EmailAddressFragment f6451a;

    C1709d(EmailAddressFragment emailAddressFragment) {
        this.f6451a = emailAddressFragment;
    }

    public void afterTextChanged(Editable editable) {
        this.f6451a.m6292n();
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
