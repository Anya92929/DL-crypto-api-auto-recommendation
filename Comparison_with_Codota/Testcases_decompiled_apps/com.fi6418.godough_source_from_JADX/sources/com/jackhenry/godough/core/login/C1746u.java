package com.jackhenry.godough.core.login;

import android.text.Editable;
import android.text.TextWatcher;

/* renamed from: com.jackhenry.godough.core.login.u */
class C1746u implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ EnrollmentSettingsFragment f6492a;

    /* renamed from: b */
    private boolean f6493b;

    C1746u(EnrollmentSettingsFragment enrollmentSettingsFragment) {
        this.f6492a = enrollmentSettingsFragment;
    }

    public void afterTextChanged(Editable editable) {
        if (!this.f6493b) {
            this.f6493b = true;
            this.f6492a.f6283f.setText(this.f6492a.updatePhoneNumber(editable.toString()));
            this.f6492a.f6283f.setSelection(this.f6492a.f6283f.getText().length());
            this.f6493b = false;
        }
        this.f6492a.m6309o();
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
