package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* renamed from: android.support.design.widget.bf */
class C0041bf extends AnimatorListenerAdapter {

    /* renamed from: a */
    final /* synthetic */ C0034az f179a;

    /* renamed from: b */
    final /* synthetic */ C0039bd f180b;

    C0041bf(C0039bd bdVar, C0034az azVar) {
        this.f180b = bdVar;
        this.f179a = azVar;
    }

    public void onAnimationCancel(Animator animator) {
        this.f179a.mo236c();
    }

    public void onAnimationEnd(Animator animator) {
        this.f179a.mo235b();
    }

    public void onAnimationStart(Animator animator) {
        this.f179a.mo234a();
    }
}
