package android.support.p021v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.p009v4.view.C0241bs;
import android.support.p021v7.p023b.C0506b;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

/* renamed from: android.support.v7.widget.ai */
public class C0584ai extends AutoCompleteTextView implements C0241bs {

    /* renamed from: a */
    private static final int[] f1370a = {16843126};

    /* renamed from: b */
    private C0591ap f1371b;

    /* renamed from: c */
    private C0585aj f1372c;

    /* renamed from: d */
    private C0617bo f1373d;

    public C0584ai(Context context) {
        this(context, (AttributeSet) null);
    }

    public C0584ai(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0506b.autoCompleteTextViewStyle);
    }

    public C0584ai(Context context, AttributeSet attributeSet, int i) {
        super(C0667dk.m3010a(context), attributeSet, i);
        this.f1371b = C0591ap.m2736a();
        C0670dn a = C0670dn.m3014a(getContext(), attributeSet, f1370a, i, 0);
        if (a.mo3332g(0)) {
            setDropDownBackgroundDrawable(a.mo3318a(0));
        }
        a.mo3319a();
        this.f1372c = new C0585aj(this, this.f1371b);
        this.f1372c.mo2954a(attributeSet, i);
        this.f1373d = C0617bo.m2797a((TextView) this);
        this.f1373d.mo3075a(attributeSet, i);
        this.f1373d.mo3072a();
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1372c != null) {
            this.f1372c.mo2957c();
        }
        if (this.f1373d != null) {
            this.f1373d.mo3072a();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        if (this.f1372c != null) {
            return this.f1372c.mo2949a();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.f1372c != null) {
            return this.f1372c.mo2955b();
        }
        return null;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f1372c != null) {
            this.f1372c.mo2953a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f1372c != null) {
            this.f1372c.mo2950a(i);
        }
    }

    public void setDropDownBackgroundResource(int i) {
        if (this.f1371b != null) {
            setDropDownBackgroundDrawable(this.f1371b.mo2982a(getContext(), i));
        } else {
            super.setDropDownBackgroundResource(i);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1372c != null) {
            this.f1372c.mo2951a(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f1372c != null) {
            this.f1372c.mo2952a(mode);
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f1373d != null) {
            this.f1373d.mo3073a(context, i);
        }
    }
}
