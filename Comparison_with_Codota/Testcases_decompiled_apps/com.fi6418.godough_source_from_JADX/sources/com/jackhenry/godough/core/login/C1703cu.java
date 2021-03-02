package com.jackhenry.godough.core.login;

import android.view.View;

/* renamed from: com.jackhenry.godough.core.login.cu */
class C1703cu implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SplashActivity f6445a;

    C1703cu(SplashActivity splashActivity) {
        this.f6445a = splashActivity;
    }

    public void onClick(View view) {
        this.f6445a.onLocationClicked(view);
    }
}
