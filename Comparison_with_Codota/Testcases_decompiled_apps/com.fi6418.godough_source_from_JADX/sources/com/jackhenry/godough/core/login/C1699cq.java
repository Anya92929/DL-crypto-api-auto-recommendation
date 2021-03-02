package com.jackhenry.godough.core.login;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/* renamed from: com.jackhenry.godough.core.login.cq */
class C1699cq implements TextWatcher {

    /* renamed from: a */
    EditText f6442a;

    /* renamed from: b */
    final /* synthetic */ PasswordChangeFragment f6443b;

    public C1699cq(PasswordChangeFragment passwordChangeFragment, EditText editText) {
        this.f6443b = passwordChangeFragment;
        this.f6442a = editText;
    }

    public void afterTextChanged(Editable editable) {
        if (editable.length() > this.f6443b.f6348g.getUserNameMaximumLength()) {
            editable.delete(this.f6443b.f6348g.getUserNameMaximumLength(), editable.length());
        }
        this.f6443b.m6362a(this.f6442a);
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
