package com.jackhenry.godough.core.login;

import com.jackhenry.godough.core.C1593j;

/* renamed from: com.jackhenry.godough.core.login.by */
class C1680by implements C1593j {

    /* renamed from: a */
    final /* synthetic */ MFARecollectActivity f6420a;

    C1680by(MFARecollectActivity mFARecollectActivity) {
        this.f6420a = mFARecollectActivity;
    }

    public void run() {
        this.f6420a.processMFA();
    }
}
