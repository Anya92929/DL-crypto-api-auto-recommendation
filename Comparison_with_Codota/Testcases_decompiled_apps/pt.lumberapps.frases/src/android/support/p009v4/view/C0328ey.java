package android.support.p009v4.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* renamed from: android.support.v4.view.ey */
final class C0328ey extends AnimatorListenerAdapter {

    /* renamed from: a */
    final /* synthetic */ C0332fb f397a;

    /* renamed from: b */
    final /* synthetic */ View f398b;

    C0328ey(C0332fb fbVar, View view) {
        this.f397a = fbVar;
        this.f398b = view;
    }

    public void onAnimationCancel(Animator animator) {
        this.f397a.onAnimationCancel(this.f398b);
    }

    public void onAnimationEnd(Animator animator) {
        this.f397a.onAnimationEnd(this.f398b);
    }

    public void onAnimationStart(Animator animator) {
        this.f397a.onAnimationStart(this.f398b);
    }
}
