package android.support.p021v7.widget;

import android.view.View;
import android.view.ViewTreeObserver;

/* renamed from: android.support.v7.widget.bm */
class C0615bm implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a */
    final /* synthetic */ C0613bk f1469a;

    C0615bm(C0613bk bkVar) {
        this.f1469a = bkVar;
    }

    public void onGlobalLayout() {
        if (!this.f1469a.m2790a((View) this.f1469a.f1463a)) {
            this.f1469a.mo2363c();
            return;
        }
        this.f1469a.mo3068f();
        C0615bm.super.mo2362a();
    }
}
