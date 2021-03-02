package com.jackhenry.godough.core.login;

import android.view.View;

/* renamed from: com.jackhenry.godough.core.login.cv */
class C1704cv implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SplashActivity f6446a;

    C1704cv(SplashActivity splashActivity) {
        this.f6446a = splashActivity;
    }

    public void onClick(View view) {
        this.f6446a.onLoginClicked(view);
    }
}
