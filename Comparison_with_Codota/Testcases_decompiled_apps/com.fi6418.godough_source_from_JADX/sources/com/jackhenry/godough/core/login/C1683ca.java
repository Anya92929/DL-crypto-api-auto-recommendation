package com.jackhenry.godough.core.login;

import android.view.View;
import com.jackhenry.godough.core.model.MFAPhone;

/* renamed from: com.jackhenry.godough.core.login.ca */
class C1683ca implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MFARecollectPhoneNumbersFragment f6422a;

    C1683ca(MFARecollectPhoneNumbersFragment mFARecollectPhoneNumbersFragment) {
        this.f6422a = mFARecollectPhoneNumbersFragment;
    }

    public void onClick(View view) {
        C1684cb cbVar = new C1684cb(this.f6422a);
        int i = -1;
        if (!cbVar.mo9989a()) {
            i = MFAPhone.PhoneType.Mobile.ordinal();
        } else if (!cbVar.mo9990b()) {
            i = MFAPhone.PhoneType.Home.ordinal();
        } else if (!cbVar.mo9991c()) {
            i = MFAPhone.PhoneType.Work.ordinal();
        } else if (!cbVar.mo9992d()) {
            i = MFAPhone.PhoneType.Other.ordinal();
        }
        this.f6422a.addPhoneNumberEntry(Integer.valueOf(i));
    }
}
