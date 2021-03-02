package android.support.p021v7.widget;

import android.view.View;

/* renamed from: android.support.v7.widget.cx */
class C0653cx implements Runnable {

    /* renamed from: a */
    final /* synthetic */ View f1599a;

    /* renamed from: b */
    final /* synthetic */ C0652cw f1600b;

    C0653cx(C0652cw cwVar, View view) {
        this.f1600b = cwVar;
        this.f1599a = view;
    }

    public void run() {
        this.f1600b.smoothScrollTo(this.f1599a.getLeft() - ((this.f1600b.getWidth() - this.f1599a.getWidth()) / 2), 0);
        this.f1600b.f1590a = null;
    }
}
