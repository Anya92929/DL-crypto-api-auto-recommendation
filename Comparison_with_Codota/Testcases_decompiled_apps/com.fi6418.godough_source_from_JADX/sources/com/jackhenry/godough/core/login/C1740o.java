package com.jackhenry.godough.core.login;

import android.os.Handler;
import com.jackhenry.godough.core.C1593j;

/* renamed from: com.jackhenry.godough.core.login.o */
class C1740o implements C1593j {

    /* renamed from: a */
    final /* synthetic */ EnrollmentFragmentActivity f6483a;

    C1740o(EnrollmentFragmentActivity enrollmentFragmentActivity) {
        this.f6483a = enrollmentFragmentActivity;
    }

    public void run() {
        new Handler().post(new C1741p(this));
    }
}
