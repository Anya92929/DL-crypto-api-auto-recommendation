package android.support.p009v4.view;

import android.graphics.Paint;
import android.os.Build;
import android.view.View;

/* renamed from: android.support.v4.view.ep */
class C0319ep implements C0332fb {

    /* renamed from: a */
    C0314ek f393a;

    /* renamed from: b */
    boolean f394b;

    C0319ep(C0314ek ekVar) {
        this.f393a = ekVar;
    }

    public void onAnimationCancel(View view) {
        Object tag = view.getTag(2113929216);
        C0332fb fbVar = tag instanceof C0332fb ? (C0332fb) tag : null;
        if (fbVar != null) {
            fbVar.onAnimationCancel(view);
        }
    }

    public void onAnimationEnd(View view) {
        if (this.f393a.f387e >= 0) {
            C0247by.m892a(view, this.f393a.f387e, (Paint) null);
            int unused = this.f393a.f387e = -1;
        }
        if (Build.VERSION.SDK_INT >= 16 || !this.f394b) {
            if (this.f393a.f386d != null) {
                Runnable b = this.f393a.f386d;
                Runnable unused2 = this.f393a.f386d = null;
                b.run();
            }
            Object tag = view.getTag(2113929216);
            C0332fb fbVar = tag instanceof C0332fb ? (C0332fb) tag : null;
            if (fbVar != null) {
                fbVar.onAnimationEnd(view);
            }
            this.f394b = true;
        }
    }

    public void onAnimationStart(View view) {
        this.f394b = false;
        if (this.f393a.f387e >= 0) {
            C0247by.m892a(view, 2, (Paint) null);
        }
        if (this.f393a.f385c != null) {
            Runnable a = this.f393a.f385c;
            Runnable unused = this.f393a.f385c = null;
            a.run();
        }
        Object tag = view.getTag(2113929216);
        C0332fb fbVar = tag instanceof C0332fb ? (C0332fb) tag : null;
        if (fbVar != null) {
            fbVar.onAnimationStart(view);
        }
    }
}
