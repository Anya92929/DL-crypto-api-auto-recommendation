package android.support.p021v7.widget;

import android.support.p009v4.view.C0333fc;
import android.view.View;

/* renamed from: android.support.v7.widget.dx */
class C0680dx extends C0333fc {

    /* renamed from: a */
    final /* synthetic */ int f1679a;

    /* renamed from: b */
    final /* synthetic */ C0678dv f1680b;

    /* renamed from: c */
    private boolean f1681c = false;

    C0680dx(C0678dv dvVar, int i) {
        this.f1680b = dvVar;
        this.f1679a = i;
    }

    public void onAnimationCancel(View view) {
        this.f1681c = true;
    }

    public void onAnimationEnd(View view) {
        if (!this.f1681c) {
            this.f1680b.f1659a.setVisibility(this.f1679a);
        }
    }

    public void onAnimationStart(View view) {
        this.f1680b.f1659a.setVisibility(0);
    }
}
