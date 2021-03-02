package com.jackhenry.godough.core.login;

import com.jackhenry.godough.core.C1593j;

/* renamed from: com.jackhenry.godough.core.login.be */
class C1660be implements C1593j {

    /* renamed from: a */
    final /* synthetic */ MFAActivity f6398a;

    C1660be(MFAActivity mFAActivity) {
        this.f6398a = mFAActivity;
    }

    public void run() {
        this.f6398a.resetMFA();
    }
}
