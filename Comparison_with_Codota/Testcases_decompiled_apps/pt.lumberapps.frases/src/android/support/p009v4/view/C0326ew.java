package android.support.p009v4.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* renamed from: android.support.v4.view.ew */
final class C0326ew extends AnimatorListenerAdapter {

    /* renamed from: a */
    final /* synthetic */ C0332fb f395a;

    /* renamed from: b */
    final /* synthetic */ View f396b;

    C0326ew(C0332fb fbVar, View view) {
        this.f395a = fbVar;
        this.f396b = view;
    }

    public void onAnimationCancel(Animator animator) {
        this.f395a.onAnimationCancel(this.f396b);
    }

    public void onAnimationEnd(Animator animator) {
        this.f395a.onAnimationEnd(this.f396b);
    }

    public void onAnimationStart(Animator animator) {
        this.f395a.onAnimationStart(this.f396b);
    }
}
