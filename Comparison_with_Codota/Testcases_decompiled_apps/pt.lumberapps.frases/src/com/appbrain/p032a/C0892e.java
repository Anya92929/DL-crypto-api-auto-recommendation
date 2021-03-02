package com.appbrain.p032a;

import android.view.animation.Animation;

/* renamed from: com.appbrain.a.e */
final class C0892e implements Animation.AnimationListener {

    /* renamed from: a */
    final /* synthetic */ String f2362a;

    /* renamed from: b */
    final /* synthetic */ String f2363b;

    /* renamed from: c */
    final /* synthetic */ C0865d f2364c;

    C0892e(C0865d dVar, String str, String str2) {
        this.f2364c = dVar;
        this.f2362a = str;
        this.f2363b = str2;
    }

    public final void onAnimationEnd(Animation animation) {
        this.f2364c.f2303a.setText(this.f2362a);
        this.f2364c.f2303a.postDelayed(new C0919f(this), 10000);
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationStart(Animation animation) {
    }
}
