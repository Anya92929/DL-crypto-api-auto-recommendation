package android.support.p021v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.p009v4.view.C0241bs;
import android.support.p021v7.p023b.C0506b;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.TextView;

/* renamed from: android.support.v7.widget.av */
public class C0597av extends EditText implements C0241bs {

    /* renamed from: a */
    private C0591ap f1410a;

    /* renamed from: b */
    private C0585aj f1411b;

    /* renamed from: c */
    private C0617bo f1412c;

    public C0597av(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0506b.editTextStyle);
    }

    public C0597av(Context context, AttributeSet attributeSet, int i) {
        super(C0667dk.m3010a(context), attributeSet, i);
        this.f1410a = C0591ap.m2736a();
        this.f1411b = new C0585aj(this, this.f1410a);
        this.f1411b.mo2954a(attributeSet, i);
        this.f1412c = C0617bo.m2797a((TextView) this);
        this.f1412c.mo3075a(attributeSet, i);
        this.f1412c.mo3072a();
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1411b != null) {
            this.f1411b.mo2957c();
        }
        if (this.f1412c != null) {
            this.f1412c.mo3072a();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        if (this.f1411b != null) {
            return this.f1411b.mo2949a();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.f1411b != null) {
            return this.f1411b.mo2955b();
        }
        return null;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f1411b != null) {
            this.f1411b.mo2953a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f1411b != null) {
            this.f1411b.mo2950a(i);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1411b != null) {
            this.f1411b.mo2951a(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f1411b != null) {
            this.f1411b.mo2952a(mode);
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f1412c != null) {
            this.f1412c.mo3073a(context, i);
        }
    }
}
