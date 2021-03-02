package com.jackhenry.godough.core.locations;

import android.view.animation.Animation;

/* renamed from: com.jackhenry.godough.core.locations.i */
class C1610i implements Animation.AnimationListener {

    /* renamed from: a */
    final /* synthetic */ String f6245a;

    /* renamed from: b */
    final /* synthetic */ C1609h f6246b;

    C1610i(C1609h hVar, String str) {
        this.f6246b = hVar;
        this.f6245a = str;
    }

    public void onAnimationEnd(Animation animation) {
        this.f6246b.f6243a.setText(this.f6245a);
        this.f6246b.f6244b.f6199g.post(new C1611j(this));
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
