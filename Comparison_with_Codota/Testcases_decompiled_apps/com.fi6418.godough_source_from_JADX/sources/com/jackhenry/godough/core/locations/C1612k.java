package com.jackhenry.godough.core.locations;

import android.view.animation.Animation;

/* renamed from: com.jackhenry.godough.core.locations.k */
class C1612k implements Animation.AnimationListener {

    /* renamed from: a */
    final /* synthetic */ String f6248a;

    /* renamed from: b */
    final /* synthetic */ LocationDetailFragment f6249b;

    C1612k(LocationDetailFragment locationDetailFragment, String str) {
        this.f6249b = locationDetailFragment;
        this.f6248a = str;
    }

    public void onAnimationEnd(Animation animation) {
        this.f6249b.f6189aq.setText(this.f6248a);
        this.f6249b.f6199g.post(new C1613l(this));
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
