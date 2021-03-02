package com.jackhenry.godough.core.rda.registration;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.jackhenry.godough.core.C1506am;

/* renamed from: com.jackhenry.godough.core.rda.registration.r */
class C1867r implements TextWatcher {

    /* renamed from: a */
    EditText f6757a;

    /* renamed from: b */
    final /* synthetic */ RDARegistrationConfirmInformationFragment f6758b;

    public C1867r(RDARegistrationConfirmInformationFragment rDARegistrationConfirmInformationFragment, EditText editText) {
        this.f6758b = rDARegistrationConfirmInformationFragment;
        this.f6757a = editText;
    }

    public void afterTextChanged(Editable editable) {
        if (this.f6757a == this.f6758b.f6716d && editable.toString().trim().length() > 0 && !editable.toString().equals(this.f6758b.f6715c.getText().toString())) {
            this.f6758b.f6716d.setError(this.f6758b.getString(C1506am.rda_email_error));
        }
        this.f6758b.f6718f.setEnabled(this.f6758b.m6790p());
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
