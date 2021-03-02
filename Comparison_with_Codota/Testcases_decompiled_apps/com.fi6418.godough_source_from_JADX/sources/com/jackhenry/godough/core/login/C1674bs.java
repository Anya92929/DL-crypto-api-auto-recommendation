package com.jackhenry.godough.core.login;

import android.view.View;

/* renamed from: com.jackhenry.godough.core.login.bs */
class C1674bs implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MFAPhoneNumberEntry f6413a;

    C1674bs(MFAPhoneNumberEntry mFAPhoneNumberEntry) {
        this.f6413a = mFAPhoneNumberEntry;
    }

    public void onClick(View view) {
        this.f6413a.f6320o = true;
        this.f6413a.f6311f.setVisibility(4);
        this.f6413a.m6337b();
    }
}
