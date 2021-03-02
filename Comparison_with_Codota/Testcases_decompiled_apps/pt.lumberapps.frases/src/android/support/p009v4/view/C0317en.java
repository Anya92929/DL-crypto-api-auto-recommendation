package android.support.p009v4.view;

import android.view.View;
import java.lang.ref.WeakReference;

/* renamed from: android.support.v4.view.en */
class C0317en implements Runnable {

    /* renamed from: a */
    WeakReference f389a;

    /* renamed from: b */
    C0314ek f390b;

    /* renamed from: c */
    final /* synthetic */ C0316em f391c;

    private C0317en(C0316em emVar, C0314ek ekVar, View view) {
        this.f391c = emVar;
        this.f389a = new WeakReference(view);
        this.f390b = ekVar;
    }

    public void run() {
        View view = (View) this.f389a.get();
        if (view != null) {
            this.f391c.m1218d(this.f390b, view);
        }
    }
}
