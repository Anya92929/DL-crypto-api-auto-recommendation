package com.jackhenry.godough.core.login;

import android.os.Handler;
import com.jackhenry.godough.core.C1593j;

/* renamed from: com.jackhenry.godough.core.login.dk */
class C1720dk implements C1593j {

    /* renamed from: a */
    final /* synthetic */ TermsAndConditionsFragmentActivity f6464a;

    C1720dk(TermsAndConditionsFragmentActivity termsAndConditionsFragmentActivity) {
        this.f6464a = termsAndConditionsFragmentActivity;
    }

    public void run() {
        new Handler().post(new C1721dl(this));
    }
}
