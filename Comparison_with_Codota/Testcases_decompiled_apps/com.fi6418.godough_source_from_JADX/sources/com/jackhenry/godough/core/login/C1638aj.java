package com.jackhenry.godough.core.login;

import android.text.Editable;
import android.text.TextWatcher;

/* renamed from: com.jackhenry.godough.core.login.aj */
class C1638aj implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ LoginActivity f6380a;

    C1638aj(LoginActivity loginActivity) {
        this.f6380a = loginActivity;
    }

    public void afterTextChanged(Editable editable) {
        this.f6380a.m6319h();
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
