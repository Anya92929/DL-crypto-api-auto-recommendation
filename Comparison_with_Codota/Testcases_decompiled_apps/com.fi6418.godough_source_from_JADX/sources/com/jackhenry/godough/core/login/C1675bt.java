package com.jackhenry.godough.core.login;

import android.view.View;

/* renamed from: com.jackhenry.godough.core.login.bt */
class C1675bt implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MFAPhoneNumberEntry f6414a;

    C1675bt(MFAPhoneNumberEntry mFAPhoneNumberEntry) {
        this.f6414a = mFAPhoneNumberEntry;
    }

    public void onClick(View view) {
        this.f6414a.f6320o = false;
        this.f6414a.f6311f.setVisibility(0);
        this.f6414a.f6306a.setExtension((String) null);
        this.f6414a.m6337b();
    }
}
