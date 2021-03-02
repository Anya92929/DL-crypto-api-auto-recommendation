package com.jackhenry.godough.core.login;

import android.view.animation.Animation;

/* renamed from: com.jackhenry.godough.core.login.cz */
class C1708cz implements Animation.AnimationListener {

    /* renamed from: a */
    final /* synthetic */ SplashActivity f6450a;

    C1708cz(SplashActivity splashActivity) {
        this.f6450a = splashActivity;
    }

    public void onAnimationEnd(Animation animation) {
        this.f6450a.f6354m.setVisibility(0);
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
