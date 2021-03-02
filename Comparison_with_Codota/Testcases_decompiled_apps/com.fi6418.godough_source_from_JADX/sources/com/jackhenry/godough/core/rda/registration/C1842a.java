package com.jackhenry.godough.core.rda.registration;

import com.jackhenry.godough.core.C1593j;

/* renamed from: com.jackhenry.godough.core.rda.registration.a */
class C1842a implements C1593j {

    /* renamed from: a */
    final /* synthetic */ AbstractRDAVerifyRegistrationActivity f6729a;

    C1842a(AbstractRDAVerifyRegistrationActivity abstractRDAVerifyRegistrationActivity) {
        this.f6729a = abstractRDAVerifyRegistrationActivity;
    }

    public void run() {
        this.f6729a.checkRDAEnrollmentStatus();
    }
}
