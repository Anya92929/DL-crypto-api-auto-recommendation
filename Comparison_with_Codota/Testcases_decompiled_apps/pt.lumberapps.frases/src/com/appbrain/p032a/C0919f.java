package com.appbrain.p032a;

import android.view.animation.AlphaAnimation;
import android.widget.TextView;

/* renamed from: com.appbrain.a.f */
final class C0919f implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0892e f2410a;

    C0919f(C0892e eVar) {
        this.f2410a = eVar;
    }

    public final void run() {
        TextView textView = this.f2410a.f2364c.f2303a;
        C0946g gVar = new C0946g(this);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(200);
        alphaAnimation.startNow();
        alphaAnimation.setAnimationListener(gVar);
        textView.startAnimation(alphaAnimation);
    }
}
