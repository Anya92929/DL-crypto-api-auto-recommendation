package com.jackhenry.godough.core.login;

import com.jackhenry.godough.core.C1593j;
import com.jackhenry.godough.core.model.Carrier;

/* renamed from: com.jackhenry.godough.core.login.q */
class C1742q implements C1593j {

    /* renamed from: a */
    final /* synthetic */ Carrier f6485a;

    /* renamed from: b */
    final /* synthetic */ String f6486b;

    /* renamed from: c */
    final /* synthetic */ boolean f6487c;

    /* renamed from: d */
    final /* synthetic */ EnrollmentFragmentActivity f6488d;

    C1742q(EnrollmentFragmentActivity enrollmentFragmentActivity, Carrier carrier, String str, boolean z) {
        this.f6488d = enrollmentFragmentActivity;
        this.f6485a = carrier;
        this.f6486b = str;
        this.f6487c = z;
    }

    public void run() {
        this.f6488d.acceptSettings(this.f6485a, this.f6486b.replaceAll("[^0-9]", ""), this.f6487c);
    }
}
