package com.jackhenry.godough.core.rda.registration;

import android.os.Handler;
import com.jackhenry.godough.core.C1593j;

/* renamed from: com.jackhenry.godough.core.rda.registration.n */
class C1863n implements C1593j {

    /* renamed from: a */
    final /* synthetic */ RDARegistrationConfirmInformationFragment f6754a;

    C1863n(RDARegistrationConfirmInformationFragment rDARegistrationConfirmInformationFragment) {
        this.f6754a = rDARegistrationConfirmInformationFragment;
    }

    public void run() {
        new Handler().post(new C1864o(this));
    }
}
