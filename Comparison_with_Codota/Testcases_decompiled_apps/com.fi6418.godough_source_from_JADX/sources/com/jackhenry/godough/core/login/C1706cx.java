package com.jackhenry.godough.core.login;

import android.os.Handler;
import com.jackhenry.godough.core.C1593j;

/* renamed from: com.jackhenry.godough.core.login.cx */
class C1706cx implements C1593j {

    /* renamed from: a */
    final /* synthetic */ SplashActivity f6448a;

    C1706cx(SplashActivity splashActivity) {
        this.f6448a = splashActivity;
    }

    public void run() {
        new Handler().post(new C1707cy(this));
    }
}
