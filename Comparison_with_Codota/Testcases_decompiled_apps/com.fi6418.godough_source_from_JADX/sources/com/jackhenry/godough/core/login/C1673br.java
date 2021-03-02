package com.jackhenry.godough.core.login;

import android.view.View;

/* renamed from: com.jackhenry.godough.core.login.br */
class C1673br implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MFAPhoneNumberEntry f6412a;

    C1673br(MFAPhoneNumberEntry mFAPhoneNumberEntry) {
        this.f6412a = mFAPhoneNumberEntry;
    }

    public void onClick(View view) {
        this.f6412a.setVisibility(8);
        this.f6412a.f6306a.setExtension((String) null);
        this.f6412a.f6306a.setNumber("");
        this.f6412a.f6307b.setText("");
        this.f6412a.f6308c.setText("");
        this.f6412a.f6314i.updatePhoneEntryTypes();
        this.f6412a.f6314i.validatePhoneNumbers();
    }
}
