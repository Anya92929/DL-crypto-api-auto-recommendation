package android.support.design.widget;

import android.view.animation.Animation;

/* renamed from: android.support.design.widget.u */
class C0073u implements Animation.AnimationListener {

    /* renamed from: a */
    final /* synthetic */ Snackbar f220a;

    C0073u(Snackbar snackbar) {
        this.f220a = snackbar;
    }

    public void onAnimationEnd(Animation animation) {
        if (this.f220a.f70d != null) {
            this.f220a.f70d.mo320a(this.f220a);
        }
        C0009aa.m171a().mo171b(this.f220a.f71e);
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
