package android.support.p021v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.p009v4.view.C0241bs;
import android.util.AttributeSet;
import android.widget.TextView;

/* renamed from: android.support.v7.widget.bq */
public class C0619bq extends TextView implements C0241bs {

    /* renamed from: a */
    private C0591ap f1481a;

    /* renamed from: b */
    private C0585aj f1482b;

    /* renamed from: c */
    private C0617bo f1483c;

    public C0619bq(Context context) {
        this(context, (AttributeSet) null);
    }

    public C0619bq(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public C0619bq(Context context, AttributeSet attributeSet, int i) {
        super(C0667dk.m3010a(context), attributeSet, i);
        this.f1481a = C0591ap.m2736a();
        this.f1482b = new C0585aj(this, this.f1481a);
        this.f1482b.mo2954a(attributeSet, i);
        this.f1483c = C0617bo.m2797a((TextView) this);
        this.f1483c.mo3075a(attributeSet, i);
        this.f1483c.mo3072a();
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1482b != null) {
            this.f1482b.mo2957c();
        }
        if (this.f1483c != null) {
            this.f1483c.mo3072a();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        if (this.f1482b != null) {
            return this.f1482b.mo2949a();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.f1482b != null) {
            return this.f1482b.mo2955b();
        }
        return null;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f1482b != null) {
            this.f1482b.mo2953a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f1482b != null) {
            this.f1482b.mo2950a(i);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1482b != null) {
            this.f1482b.mo2951a(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f1482b != null) {
            this.f1482b.mo2952a(mode);
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f1483c != null) {
            this.f1483c.mo3073a(context, i);
        }
    }
}
