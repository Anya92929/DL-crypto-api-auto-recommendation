package com.jackhenry.godough.core.login;

import android.view.View;
import com.jackhenry.p021a.C1347a;

/* renamed from: com.jackhenry.godough.core.login.da */
class C1710da implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SplashActivity f6452a;

    C1710da(SplashActivity splashActivity) {
        this.f6452a = splashActivity;
    }

    public void onClick(View view) {
        this.f6452a.startActivityForResult(C1347a.m5548a(this.f6452a.getApplicationContext().getPackageName()), 2);
    }
}
