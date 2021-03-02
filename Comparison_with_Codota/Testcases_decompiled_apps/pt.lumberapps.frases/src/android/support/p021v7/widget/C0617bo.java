package android.support.p021v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.p021v7.p023b.C0515k;
import android.support.p021v7.p026d.C0518a;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;

/* renamed from: android.support.v7.widget.bo */
class C0617bo {

    /* renamed from: b */
    private static final int[] f1472b = {16842804, 16843119, 16843117, 16843120, 16843118};

    /* renamed from: a */
    final TextView f1473a;

    /* renamed from: c */
    private C0668dl f1474c;

    /* renamed from: d */
    private C0668dl f1475d;

    /* renamed from: e */
    private C0668dl f1476e;

    /* renamed from: f */
    private C0668dl f1477f;

    C0617bo(TextView textView) {
        this.f1473a = textView;
    }

    /* renamed from: a */
    static C0617bo m2797a(TextView textView) {
        return Build.VERSION.SDK_INT >= 17 ? new C0618bp(textView) : new C0617bo(textView);
    }

    /* renamed from: a */
    protected static C0668dl m2798a(Context context, C0591ap apVar, int i) {
        ColorStateList b = apVar.mo2984b(context, i);
        if (b == null) {
            return null;
        }
        C0668dl dlVar = new C0668dl();
        dlVar.f1648d = true;
        dlVar.f1645a = b;
        return dlVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3072a() {
        if (this.f1474c != null || this.f1475d != null || this.f1476e != null || this.f1477f != null) {
            Drawable[] compoundDrawables = this.f1473a.getCompoundDrawables();
            mo3074a(compoundDrawables[0], this.f1474c);
            mo3074a(compoundDrawables[1], this.f1475d);
            mo3074a(compoundDrawables[2], this.f1476e);
            mo3074a(compoundDrawables[3], this.f1477f);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3073a(Context context, int i) {
        ColorStateList e;
        C0670dn a = C0670dn.m3012a(context, i, C0515k.TextAppearance);
        if (a.mo3332g(C0515k.TextAppearance_textAllCaps)) {
            mo3076a(a.mo3320a(C0515k.TextAppearance_textAllCaps, false));
        }
        if (Build.VERSION.SDK_INT < 23 && a.mo3332g(C0515k.TextAppearance_android_textColor) && (e = a.mo3328e(C0515k.TextAppearance_android_textColor)) != null) {
            this.f1473a.setTextColor(e);
        }
        a.mo3319a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo3074a(Drawable drawable, C0668dl dlVar) {
        if (drawable != null && dlVar != null) {
            C0591ap.m2739a(drawable, dlVar, this.f1473a.getDrawableState());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3075a(AttributeSet attributeSet, int i) {
        boolean z;
        boolean z2;
        Context context = this.f1473a.getContext();
        C0591ap a = C0591ap.m2736a();
        C0670dn a2 = C0670dn.m3014a(context, attributeSet, f1472b, i, 0);
        int g = a2.mo3331g(0, -1);
        if (a2.mo3332g(1)) {
            this.f1474c = m2798a(context, a, a2.mo3331g(1, 0));
        }
        if (a2.mo3332g(2)) {
            this.f1475d = m2798a(context, a, a2.mo3331g(2, 0));
        }
        if (a2.mo3332g(3)) {
            this.f1476e = m2798a(context, a, a2.mo3331g(3, 0));
        }
        if (a2.mo3332g(4)) {
            this.f1477f = m2798a(context, a, a2.mo3331g(4, 0));
        }
        a2.mo3319a();
        boolean z3 = this.f1473a.getTransformationMethod() instanceof PasswordTransformationMethod;
        ColorStateList colorStateList = null;
        if (g != -1) {
            C0670dn a3 = C0670dn.m3012a(context, g, C0515k.TextAppearance);
            if (z3 || !a3.mo3332g(C0515k.TextAppearance_textAllCaps)) {
                z = false;
                z2 = false;
            } else {
                z2 = a3.mo3320a(C0515k.TextAppearance_textAllCaps, false);
                z = true;
            }
            if (Build.VERSION.SDK_INT < 23 && a3.mo3332g(C0515k.TextAppearance_android_textColor)) {
                colorStateList = a3.mo3328e(C0515k.TextAppearance_android_textColor);
            }
            a3.mo3319a();
        } else {
            z = false;
            z2 = false;
        }
        C0670dn a4 = C0670dn.m3014a(context, attributeSet, C0515k.TextAppearance, i, 0);
        if (!z3 && a4.mo3332g(C0515k.TextAppearance_textAllCaps)) {
            z2 = a4.mo3320a(C0515k.TextAppearance_textAllCaps, false);
            z = true;
        }
        if (Build.VERSION.SDK_INT < 23 && a4.mo3332g(C0515k.TextAppearance_android_textColor)) {
            colorStateList = a4.mo3328e(C0515k.TextAppearance_android_textColor);
        }
        a4.mo3319a();
        if (colorStateList != null) {
            this.f1473a.setTextColor(colorStateList);
        }
        if (!z3 && z) {
            mo3076a(z2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3076a(boolean z) {
        this.f1473a.setTransformationMethod(z ? new C0518a(this.f1473a.getContext()) : null);
    }
}
