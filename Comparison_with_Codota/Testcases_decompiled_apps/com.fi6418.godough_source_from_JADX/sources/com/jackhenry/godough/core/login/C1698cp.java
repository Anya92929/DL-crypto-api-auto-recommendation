package com.jackhenry.godough.core.login;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/* renamed from: com.jackhenry.godough.core.login.cp */
class C1698cp implements TextWatcher {

    /* renamed from: a */
    EditText f6440a;

    /* renamed from: b */
    final /* synthetic */ PasswordChangeFragment f6441b;

    public C1698cp(PasswordChangeFragment passwordChangeFragment, EditText editText) {
        this.f6441b = passwordChangeFragment;
        this.f6440a = editText;
    }

    public void afterTextChanged(Editable editable) {
        if (this.f6440a != this.f6441b.f6342a && editable.length() > this.f6441b.f6348g.getPasswordMaximumLength()) {
            editable.delete(this.f6441b.f6348g.getPasswordMaximumLength(), editable.length());
        }
        this.f6441b.m6362a(this.f6440a);
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
