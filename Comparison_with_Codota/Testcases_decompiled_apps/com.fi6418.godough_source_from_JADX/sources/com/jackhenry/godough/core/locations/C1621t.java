package com.jackhenry.godough.core.locations;

import android.text.Editable;
import android.text.TextWatcher;

/* renamed from: com.jackhenry.godough.core.locations.t */
class C1621t implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ LocationZipFragment f6257a;

    C1621t(LocationZipFragment locationZipFragment) {
        this.f6257a = locationZipFragment;
    }

    public void afterTextChanged(Editable editable) {
        this.f6257a.m6258n();
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
