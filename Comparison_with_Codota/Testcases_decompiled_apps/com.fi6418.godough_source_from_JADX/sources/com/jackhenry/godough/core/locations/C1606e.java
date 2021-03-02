package com.jackhenry.godough.core.locations;

import android.text.Editable;
import android.text.TextWatcher;

/* renamed from: com.jackhenry.godough.core.locations.e */
class C1606e implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ LocationCityFragment f6240a;

    C1606e(LocationCityFragment locationCityFragment) {
        this.f6240a = locationCityFragment;
    }

    public void afterTextChanged(Editable editable) {
        this.f6240a.m6228n();
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
