package android.support.design.widget;

import android.support.p000v4.view.ViewPropertyAnimatorListenerAdapter;
import android.view.View;

/* renamed from: android.support.design.widget.t */
class C0072t extends ViewPropertyAnimatorListenerAdapter {

    /* renamed from: a */
    final /* synthetic */ Snackbar f219a;

    C0072t(Snackbar snackbar) {
        this.f219a = snackbar;
    }

    public void onAnimationEnd(View view) {
        if (this.f219a.f70d != null) {
            this.f219a.f70d.mo320a(this.f219a);
        }
        C0009aa.m171a().mo171b(this.f219a.f71e);
    }

    public void onAnimationStart(View view) {
        this.f219a.f69c.mo134a(70, 180);
    }
}
