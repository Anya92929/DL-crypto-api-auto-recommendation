package com.jackhenry.godough.core.login;

import com.jackhenry.godough.core.model.MFAPhone;
import java.util.Iterator;

/* renamed from: com.jackhenry.godough.core.login.cb */
class C1684cb {

    /* renamed from: a */
    boolean f6423a = false;

    /* renamed from: b */
    boolean f6424b = false;

    /* renamed from: c */
    boolean f6425c = false;

    /* renamed from: d */
    boolean f6426d = false;

    /* renamed from: e */
    final /* synthetic */ MFARecollectPhoneNumbersFragment f6427e;

    public C1684cb(MFARecollectPhoneNumbersFragment mFARecollectPhoneNumbersFragment) {
        this.f6427e = mFARecollectPhoneNumbersFragment;
        Iterator<MFAPhoneNumberEntry> it = mFARecollectPhoneNumbersFragment.f6329a.iterator();
        while (it.hasNext()) {
            MFAPhoneNumberEntry next = it.next();
            if (next.getVisibility() == 0) {
                if (next.getPhoneInfo().getType() == MFAPhone.PhoneType.Mobile.ordinal()) {
                    this.f6423a = true;
                } else if (next.getPhoneInfo().getType() == MFAPhone.PhoneType.Home.ordinal()) {
                    this.f6424b = true;
                } else if (next.getPhoneInfo().getType() == MFAPhone.PhoneType.Work.ordinal()) {
                    this.f6425c = true;
                } else if (next.getPhoneInfo().getType() == MFAPhone.PhoneType.Other.ordinal()) {
                    this.f6426d = true;
                }
            }
        }
    }

    /* renamed from: a */
    public boolean mo9989a() {
        return this.f6423a;
    }

    /* renamed from: b */
    public boolean mo9990b() {
        return this.f6424b;
    }

    /* renamed from: c */
    public boolean mo9991c() {
        return this.f6425c;
    }

    /* renamed from: d */
    public boolean mo9992d() {
        return this.f6426d;
    }
}
