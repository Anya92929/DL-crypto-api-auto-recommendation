package android.support.p009v4.view;

import android.view.View;
import android.view.animation.Interpolator;
import java.util.WeakHashMap;

/* renamed from: android.support.v4.view.em */
class C0316em implements C0324eu {

    /* renamed from: a */
    WeakHashMap f388a = null;

    C0316em() {
    }

    /* renamed from: a */
    private void m1217a(View view) {
        Runnable runnable;
        if (this.f388a != null && (runnable = (Runnable) this.f388a.get(view)) != null) {
            view.removeCallbacks(runnable);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m1218d(C0314ek ekVar, View view) {
        Object tag = view.getTag(2113929216);
        C0332fb fbVar = tag instanceof C0332fb ? (C0332fb) tag : null;
        Runnable a = ekVar.f385c;
        Runnable b = ekVar.f386d;
        Runnable unused = ekVar.f385c = null;
        Runnable unused2 = ekVar.f386d = null;
        if (a != null) {
            a.run();
        }
        if (fbVar != null) {
            fbVar.onAnimationStart(view);
            fbVar.onAnimationEnd(view);
        }
        if (b != null) {
            b.run();
        }
        if (this.f388a != null) {
            this.f388a.remove(view);
        }
    }

    /* renamed from: e */
    private void m1219e(C0314ek ekVar, View view) {
        Runnable runnable = this.f388a != null ? (Runnable) this.f388a.get(view) : null;
        if (runnable == null) {
            runnable = new C0317en(this, ekVar, view);
            if (this.f388a == null) {
                this.f388a = new WeakHashMap();
            }
            this.f388a.put(view, runnable);
        }
        view.removeCallbacks(runnable);
        view.post(runnable);
    }

    /* renamed from: a */
    public long mo1561a(C0314ek ekVar, View view) {
        return 0;
    }

    /* renamed from: a */
    public void mo1562a(C0314ek ekVar, View view, float f) {
        m1219e(ekVar, view);
    }

    /* renamed from: a */
    public void mo1563a(C0314ek ekVar, View view, long j) {
    }

    /* renamed from: a */
    public void mo1564a(C0314ek ekVar, View view, C0332fb fbVar) {
        view.setTag(2113929216, fbVar);
    }

    /* renamed from: a */
    public void mo1565a(C0314ek ekVar, View view, C0334fd fdVar) {
    }

    /* renamed from: a */
    public void mo1566a(C0314ek ekVar, View view, Interpolator interpolator) {
    }

    /* renamed from: b */
    public void mo1567b(C0314ek ekVar, View view) {
        m1219e(ekVar, view);
    }

    /* renamed from: b */
    public void mo1568b(C0314ek ekVar, View view, float f) {
        m1219e(ekVar, view);
    }

    /* renamed from: b */
    public void mo1569b(C0314ek ekVar, View view, long j) {
    }

    /* renamed from: c */
    public void mo1570c(C0314ek ekVar, View view) {
        m1217a(view);
        m1218d(ekVar, view);
    }
}
