package com.jackhenry.godough.core.rda.registration;

import com.jackhenry.godough.core.C1593j;

/* renamed from: com.jackhenry.godough.core.rda.registration.b */
class C1851b implements C1593j {

    /* renamed from: a */
    final /* synthetic */ AbstractRDAVerifyRegistrationActivity f6737a;

    C1851b(AbstractRDAVerifyRegistrationActivity abstractRDAVerifyRegistrationActivity) {
        this.f6737a = abstractRDAVerifyRegistrationActivity;
    }

    public void run() {
        this.f6737a.checkRDAEnrollmentStatus();
    }
}
