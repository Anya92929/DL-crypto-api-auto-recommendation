package android.support.p009v4.view;

import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* renamed from: android.support.v4.view.ek */
public final class C0314ek {

    /* renamed from: a */
    static final C0324eu f383a;

    /* renamed from: b */
    private WeakReference f384b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Runnable f385c = null;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Runnable f386d = null;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f387e = -1;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            f383a = new C0323et();
        } else if (i >= 19) {
            f383a = new C0322es();
        } else if (i >= 18) {
            f383a = new C0320eq();
        } else if (i >= 16) {
            f383a = new C0321er();
        } else if (i >= 14) {
            f383a = new C0318eo();
        } else {
            f383a = new C0316em();
        }
    }

    C0314ek(View view) {
        this.f384b = new WeakReference(view);
    }

    /* renamed from: a */
    public long mo1551a() {
        View view = (View) this.f384b.get();
        if (view != null) {
            return f383a.mo1561a(this, view);
        }
        return 0;
    }

    /* renamed from: a */
    public C0314ek mo1552a(float f) {
        View view = (View) this.f384b.get();
        if (view != null) {
            f383a.mo1562a(this, view, f);
        }
        return this;
    }

    /* renamed from: a */
    public C0314ek mo1553a(long j) {
        View view = (View) this.f384b.get();
        if (view != null) {
            f383a.mo1563a(this, view, j);
        }
        return this;
    }

    /* renamed from: a */
    public C0314ek mo1554a(C0332fb fbVar) {
        View view = (View) this.f384b.get();
        if (view != null) {
            f383a.mo1564a(this, view, fbVar);
        }
        return this;
    }

    /* renamed from: a */
    public C0314ek mo1555a(C0334fd fdVar) {
        View view = (View) this.f384b.get();
        if (view != null) {
            f383a.mo1565a(this, view, fdVar);
        }
        return this;
    }

    /* renamed from: a */
    public C0314ek mo1556a(Interpolator interpolator) {
        View view = (View) this.f384b.get();
        if (view != null) {
            f383a.mo1566a(this, view, interpolator);
        }
        return this;
    }

    /* renamed from: b */
    public C0314ek mo1557b(float f) {
        View view = (View) this.f384b.get();
        if (view != null) {
            f383a.mo1568b(this, view, f);
        }
        return this;
    }

    /* renamed from: b */
    public C0314ek mo1558b(long j) {
        View view = (View) this.f384b.get();
        if (view != null) {
            f383a.mo1569b(this, view, j);
        }
        return this;
    }

    /* renamed from: b */
    public void mo1559b() {
        View view = (View) this.f384b.get();
        if (view != null) {
            f383a.mo1567b(this, view);
        }
    }

    /* renamed from: c */
    public void mo1560c() {
        View view = (View) this.f384b.get();
        if (view != null) {
            f383a.mo1570c(this, view);
        }
    }
}
