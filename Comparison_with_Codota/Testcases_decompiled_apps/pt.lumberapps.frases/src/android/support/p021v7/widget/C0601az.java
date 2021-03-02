package android.support.p021v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.p009v4.view.C0241bs;
import android.support.p021v7.p023b.C0506b;
import android.util.AttributeSet;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

/* renamed from: android.support.v7.widget.az */
public class C0601az extends MultiAutoCompleteTextView implements C0241bs {

    /* renamed from: a */
    private static final int[] f1419a = {16843126};

    /* renamed from: b */
    private C0591ap f1420b;

    /* renamed from: c */
    private C0585aj f1421c;

    /* renamed from: d */
    private C0617bo f1422d;

    public C0601az(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0506b.autoCompleteTextViewStyle);
    }

    public C0601az(Context context, AttributeSet attributeSet, int i) {
        super(C0667dk.m3010a(context), attributeSet, i);
        this.f1420b = C0591ap.m2736a();
        C0670dn a = C0670dn.m3014a(getContext(), attributeSet, f1419a, i, 0);
        if (a.mo3332g(0)) {
            setDropDownBackgroundDrawable(a.mo3318a(0));
        }
        a.mo3319a();
        this.f1421c = new C0585aj(this, this.f1420b);
        this.f1421c.mo2954a(attributeSet, i);
        this.f1422d = C0617bo.m2797a((TextView) this);
        this.f1422d.mo3075a(attributeSet, i);
        this.f1422d.mo3072a();
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1421c != null) {
            this.f1421c.mo2957c();
        }
        if (this.f1422d != null) {
            this.f1422d.mo3072a();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        if (this.f1421c != null) {
            return this.f1421c.mo2949a();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.f1421c != null) {
            return this.f1421c.mo2955b();
        }
        return null;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f1421c != null) {
            this.f1421c.mo2953a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f1421c != null) {
            this.f1421c.mo2950a(i);
        }
    }

    public void setDropDownBackgroundResource(int i) {
        if (this.f1420b != null) {
            setDropDownBackgroundDrawable(this.f1420b.mo2982a(getContext(), i));
        } else {
            super.setDropDownBackgroundResource(i);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1421c != null) {
            this.f1421c.mo2951a(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f1421c != null) {
            this.f1421c.mo2952a(mode);
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f1422d != null) {
            this.f1422d.mo3073a(context, i);
        }
    }
}
