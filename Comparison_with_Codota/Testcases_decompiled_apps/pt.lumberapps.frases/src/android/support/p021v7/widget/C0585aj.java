package android.support.p021v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.p009v4.view.C0247by;
import android.support.p021v7.p023b.C0515k;
import android.util.AttributeSet;
import android.view.View;

/* renamed from: android.support.v7.widget.aj */
class C0585aj {

    /* renamed from: a */
    private final View f1374a;

    /* renamed from: b */
    private final C0591ap f1375b;

    /* renamed from: c */
    private C0668dl f1376c;

    /* renamed from: d */
    private C0668dl f1377d;

    /* renamed from: e */
    private C0668dl f1378e;

    C0585aj(View view, C0591ap apVar) {
        this.f1374a = view;
        this.f1375b = apVar;
    }

    /* renamed from: b */
    private boolean m2706b(Drawable drawable) {
        return Build.VERSION.SDK_INT == 21 && (drawable instanceof GradientDrawable);
    }

    /* renamed from: c */
    private void m2707c(Drawable drawable) {
        if (this.f1378e == null) {
            this.f1378e = new C0668dl();
        }
        C0668dl dlVar = this.f1378e;
        dlVar.mo3315a();
        ColorStateList o = C0247by.m922o(this.f1374a);
        if (o != null) {
            dlVar.f1648d = true;
            dlVar.f1645a = o;
        }
        PorterDuff.Mode p = C0247by.m923p(this.f1374a);
        if (p != null) {
            dlVar.f1647c = true;
            dlVar.f1646b = p;
        }
        if (dlVar.f1648d || dlVar.f1647c) {
            C0591ap.m2739a(drawable, dlVar, this.f1374a.getDrawableState());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public ColorStateList mo2949a() {
        if (this.f1377d != null) {
            return this.f1377d.f1645a;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2950a(int i) {
        mo2956b(this.f1375b != null ? this.f1375b.mo2984b(this.f1374a.getContext(), i) : null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2951a(ColorStateList colorStateList) {
        if (this.f1377d == null) {
            this.f1377d = new C0668dl();
        }
        this.f1377d.f1645a = colorStateList;
        this.f1377d.f1648d = true;
        mo2957c();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2952a(PorterDuff.Mode mode) {
        if (this.f1377d == null) {
            this.f1377d = new C0668dl();
        }
        this.f1377d.f1646b = mode;
        this.f1377d.f1647c = true;
        mo2957c();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2953a(Drawable drawable) {
        mo2956b((ColorStateList) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2954a(AttributeSet attributeSet, int i) {
        ColorStateList b;
        C0670dn a = C0670dn.m3014a(this.f1374a.getContext(), attributeSet, C0515k.ViewBackgroundHelper, i, 0);
        try {
            if (a.mo3332g(C0515k.ViewBackgroundHelper_android_background) && (b = this.f1375b.mo2984b(this.f1374a.getContext(), a.mo3331g(C0515k.ViewBackgroundHelper_android_background, -1))) != null) {
                mo2956b(b);
            }
            if (a.mo3332g(C0515k.ViewBackgroundHelper_backgroundTint)) {
                C0247by.m893a(this.f1374a, a.mo3328e(C0515k.ViewBackgroundHelper_backgroundTint));
            }
            if (a.mo3332g(C0515k.ViewBackgroundHelper_backgroundTintMode)) {
                C0247by.m894a(this.f1374a, C0624bv.m2853a(a.mo3317a(C0515k.ViewBackgroundHelper_backgroundTintMode, -1), (PorterDuff.Mode) null));
            }
        } finally {
            a.mo3319a();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public PorterDuff.Mode mo2955b() {
        if (this.f1377d != null) {
            return this.f1377d.f1646b;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo2956b(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f1376c == null) {
                this.f1376c = new C0668dl();
            }
            this.f1376c.f1645a = colorStateList;
            this.f1376c.f1648d = true;
        } else {
            this.f1376c = null;
        }
        mo2957c();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo2957c() {
        Drawable background = this.f1374a.getBackground();
        if (background == null) {
            return;
        }
        if (this.f1377d != null) {
            C0591ap.m2739a(background, this.f1377d, this.f1374a.getDrawableState());
        } else if (this.f1376c != null) {
            C0591ap.m2739a(background, this.f1376c, this.f1374a.getDrawableState());
        } else if (m2706b(background)) {
            m2707c(background);
        }
    }
}
