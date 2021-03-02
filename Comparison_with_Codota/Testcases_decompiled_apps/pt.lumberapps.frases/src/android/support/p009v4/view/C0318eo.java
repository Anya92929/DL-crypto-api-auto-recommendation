package android.support.p009v4.view;

import android.view.View;
import android.view.animation.Interpolator;
import java.util.WeakHashMap;

/* renamed from: android.support.v4.view.eo */
class C0318eo extends C0316em {

    /* renamed from: b */
    WeakHashMap f392b = null;

    C0318eo() {
    }

    /* renamed from: a */
    public long mo1561a(C0314ek ekVar, View view) {
        return C0325ev.m1251a(view);
    }

    /* renamed from: a */
    public void mo1562a(C0314ek ekVar, View view, float f) {
        C0325ev.m1252a(view, f);
    }

    /* renamed from: a */
    public void mo1563a(C0314ek ekVar, View view, long j) {
        C0325ev.m1253a(view, j);
    }

    /* renamed from: a */
    public void mo1564a(C0314ek ekVar, View view, C0332fb fbVar) {
        view.setTag(2113929216, fbVar);
        C0325ev.m1254a(view, (C0332fb) new C0319ep(ekVar));
    }

    /* renamed from: a */
    public void mo1566a(C0314ek ekVar, View view, Interpolator interpolator) {
        C0325ev.m1255a(view, interpolator);
    }

    /* renamed from: b */
    public void mo1567b(C0314ek ekVar, View view) {
        C0325ev.cancel(view);
    }

    /* renamed from: b */
    public void mo1568b(C0314ek ekVar, View view, float f) {
        C0325ev.m1256b(view, f);
    }

    /* renamed from: b */
    public void mo1569b(C0314ek ekVar, View view, long j) {
        C0325ev.m1257b(view, j);
    }

    /* renamed from: c */
    public void mo1570c(C0314ek ekVar, View view) {
        C0325ev.start(view);
    }
}
