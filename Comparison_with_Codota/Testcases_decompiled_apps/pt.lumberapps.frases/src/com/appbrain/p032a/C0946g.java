package com.appbrain.p032a;

import android.view.animation.Animation;

/* renamed from: com.appbrain.a.g */
final class C0946g implements Animation.AnimationListener {

    /* renamed from: a */
    final /* synthetic */ C0919f f2503a;

    C0946g(C0919f fVar) {
        this.f2503a = fVar;
    }

    public final void onAnimationEnd(Animation animation) {
        this.f2503a.f2410a.f2364c.f2303a.setText(this.f2503a.f2410a.f2363b);
        this.f2503a.f2410a.f2364c.f2305c.removeView(this.f2503a.f2410a.f2364c.f2303a);
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationStart(Animation animation) {
    }
}
