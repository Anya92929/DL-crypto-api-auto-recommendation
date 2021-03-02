package android.support.p021v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.p009v4.view.C0241bs;
import android.util.AttributeSet;
import android.widget.ImageView;

/* renamed from: android.support.v7.widget.ay */
public class C0600ay extends ImageView implements C0241bs {

    /* renamed from: a */
    private C0585aj f1417a;

    /* renamed from: b */
    private C0599ax f1418b;

    public C0600ay(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C0600ay(Context context, AttributeSet attributeSet, int i) {
        super(C0667dk.m3010a(context), attributeSet, i);
        C0591ap a = C0591ap.m2736a();
        this.f1417a = new C0585aj(this, a);
        this.f1417a.mo2954a(attributeSet, i);
        this.f1418b = new C0599ax(this, a);
        this.f1418b.mo2998a(attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1417a != null) {
            this.f1417a.mo2957c();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        if (this.f1417a != null) {
            return this.f1417a.mo2949a();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.f1417a != null) {
            return this.f1417a.mo2955b();
        }
        return null;
    }

    public boolean hasOverlappingRendering() {
        return this.f1418b.mo2999a() && super.hasOverlappingRendering();
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f1417a != null) {
            this.f1417a.mo2953a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f1417a != null) {
            this.f1417a.mo2950a(i);
        }
    }

    public void setImageResource(int i) {
        this.f1418b.mo2997a(i);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1417a != null) {
            this.f1417a.mo2951a(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f1417a != null) {
            this.f1417a.mo2952a(mode);
        }
    }
}
