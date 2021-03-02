package android.support.p009v4.view;

import android.animation.ValueAnimator;
import android.view.View;

/* renamed from: android.support.v4.view.fa */
final class C0331fa implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a */
    final /* synthetic */ C0334fd f401a;

    /* renamed from: b */
    final /* synthetic */ View f402b;

    C0331fa(C0334fd fdVar, View view) {
        this.f401a = fdVar;
        this.f402b = view;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f401a.onAnimationUpdate(this.f402b);
    }
}
