package android.support.design.widget;

import android.view.animation.Animation;

/* renamed from: android.support.design.widget.w */
class C0075w implements Animation.AnimationListener {

    /* renamed from: a */
    final /* synthetic */ int f223a;

    /* renamed from: b */
    final /* synthetic */ Snackbar f224b;

    C0075w(Snackbar snackbar, int i) {
        this.f224b = snackbar;
        this.f223a = i;
    }

    public void onAnimationEnd(Animation animation) {
        this.f224b.m106d(this.f223a);
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
