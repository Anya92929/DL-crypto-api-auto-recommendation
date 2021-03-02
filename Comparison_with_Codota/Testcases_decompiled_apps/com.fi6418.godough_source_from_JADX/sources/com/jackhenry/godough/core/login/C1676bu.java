package com.jackhenry.godough.core.login;

import android.text.Editable;
import android.text.TextWatcher;

/* renamed from: com.jackhenry.godough.core.login.bu */
class C1676bu implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ MFAPhoneNumberEntry f6415a;

    /* renamed from: b */
    private boolean f6416b;

    C1676bu(MFAPhoneNumberEntry mFAPhoneNumberEntry) {
        this.f6415a = mFAPhoneNumberEntry;
    }

    public void afterTextChanged(Editable editable) {
        if (!this.f6416b) {
            this.f6416b = true;
            this.f6415a.f6307b.setText(this.f6415a.updatePhoneNumber(editable.toString()));
            this.f6415a.f6307b.setSelection(this.f6415a.f6307b.getText().length());
            this.f6416b = false;
        }
        this.f6415a.m6332a();
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
