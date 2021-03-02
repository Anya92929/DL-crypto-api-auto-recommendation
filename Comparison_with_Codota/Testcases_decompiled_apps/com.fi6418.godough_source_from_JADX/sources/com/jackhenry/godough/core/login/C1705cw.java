package com.jackhenry.godough.core.login;

import android.content.DialogInterface;

/* renamed from: com.jackhenry.godough.core.login.cw */
class C1705cw implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ SplashActivity f6447a;

    C1705cw(SplashActivity splashActivity) {
        this.f6447a = splashActivity;
    }

    public void onCancel(DialogInterface dialogInterface) {
        this.f6447a.finish();
    }
}
