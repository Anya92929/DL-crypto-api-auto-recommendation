package com.jackhenry.godough.core.login;

import android.view.View;
import android.widget.AdapterView;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.model.MFAPhone;

/* renamed from: com.jackhenry.godough.core.login.bv */
class C1677bv implements AdapterView.OnItemSelectedListener {

    /* renamed from: a */
    final /* synthetic */ MFAPhoneNumberEntry f6417a;

    C1677bv(MFAPhoneNumberEntry mFAPhoneNumberEntry) {
        this.f6417a = mFAPhoneNumberEntry;
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        if (!this.f6417a.f6309d.getSelectedItem().toString().equals(this.f6417a.f6319n)) {
            this.f6417a.f6306a.setType(MFAPhone.PhoneType.Other.ordinal());
            this.f6417a.f6311f.setVisibility(0);
            if (this.f6417a.m6335a(C1506am.lbl_work)) {
                this.f6417a.f6306a.setType(MFAPhone.PhoneType.Work.ordinal());
            } else if (this.f6417a.m6335a(C1506am.lbl_home)) {
                this.f6417a.f6306a.setType(MFAPhone.PhoneType.Home.ordinal());
                this.f6417a.f6311f.setVisibility(4);
            } else if (this.f6417a.m6335a(C1506am.lbl_mobile)) {
                this.f6417a.f6306a.setType(MFAPhone.PhoneType.Mobile.ordinal());
                this.f6417a.f6311f.setVisibility(4);
                if (this.f6417a.f6314i != null) {
                    this.f6417a.f6314i.checkPermissionGetDevicePhoneNumber(this.f6417a.f6315j);
                }
            }
            this.f6417a.f6314i.updatePhoneEntryTypes();
            if (adapterView == this.f6417a.f6309d) {
                if (this.f6417a.f6306a.getType() == MFAPhone.PhoneType.Mobile.ordinal() || this.f6417a.f6306a.getType() == MFAPhone.PhoneType.Home.ordinal()) {
                    if (this.f6417a.f6311f.getVisibility() == 4) {
                        this.f6417a.f6306a.setExtension("");
                    } else {
                        this.f6417a.f6306a.setExtension((String) null);
                    }
                    this.f6417a.f6308c.setText("");
                    this.f6417a.f6320o = false;
                    this.f6417a.m6337b();
                }
                this.f6417a.setFocusOnNumberField();
                if (this.f6417a.f6319n.equals("")) {
                    this.f6417a.f6307b.setSelection(this.f6417a.f6307b.getText().toString().length());
                } else {
                    this.f6417a.f6307b.setSelection(0, this.f6417a.f6307b.getText().toString().length());
                }
            }
            this.f6417a.f6319n = this.f6417a.f6309d.getSelectedItem().toString();
        }
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
