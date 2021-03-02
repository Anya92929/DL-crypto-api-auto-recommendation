package com.jackhenry.godough.core.login;

import android.os.Handler;
import com.jackhenry.godough.core.C1593j;

/* renamed from: com.jackhenry.godough.core.login.k */
class C1736k implements C1593j {

    /* renamed from: a */
    final /* synthetic */ EmailAddressFragmentActivity f6479a;

    C1736k(EmailAddressFragmentActivity emailAddressFragmentActivity) {
        this.f6479a = emailAddressFragmentActivity;
    }

    public void run() {
        new Handler().post(new C1737l(this));
    }
}
