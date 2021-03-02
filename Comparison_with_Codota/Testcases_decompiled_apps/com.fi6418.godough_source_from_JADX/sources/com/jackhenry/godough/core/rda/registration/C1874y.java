package com.jackhenry.godough.core.rda.registration;

import android.os.Handler;
import com.jackhenry.godough.core.C1593j;

/* renamed from: com.jackhenry.godough.core.rda.registration.y */
class C1874y implements C1593j {

    /* renamed from: a */
    final /* synthetic */ RDATermsAndConditionsFragment f6767a;

    C1874y(RDATermsAndConditionsFragment rDATermsAndConditionsFragment) {
        this.f6767a = rDATermsAndConditionsFragment;
    }

    public void run() {
        new Handler().post(new C1875z(this));
    }
}
