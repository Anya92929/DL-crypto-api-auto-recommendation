package android.support.p021v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.p009v4.view.C0241bs;
import android.support.p021v7.p023b.C0506b;
import android.util.AttributeSet;
import android.widget.ImageButton;

/* renamed from: android.support.v7.widget.aw */
public class C0598aw extends ImageButton implements C0241bs {

    /* renamed from: a */
    private C0585aj f1413a;

    /* renamed from: b */
    private C0599ax f1414b;

    public C0598aw(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0506b.imageButtonStyle);
    }

    public C0598aw(Context context, AttributeSet attributeSet, int i) {
        super(C0667dk.m3010a(context), attributeSet, i);
        C0591ap a = C0591ap.m2736a();
        this.f1413a = new C0585aj(this, a);
        this.f1413a.mo2954a(attributeSet, i);
        this.f1414b = new C0599ax(this, a);
        this.f1414b.mo2998a(attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1413a != null) {
            this.f1413a.mo2957c();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        if (this.f1413a != null) {
            return this.f1413a.mo2949a();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.f1413a != null) {
            return this.f1413a.mo2955b();
        }
        return null;
    }

    public boolean hasOverlappingRendering() {
        return this.f1414b.mo2999a() && super.hasOverlappingRendering();
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f1413a != null) {
            this.f1413a.mo2953a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f1413a != null) {
            this.f1413a.mo2950a(i);
        }
    }

    public void setImageResource(int i) {
        this.f1414b.mo2997a(i);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1413a != null) {
            this.f1413a.mo2951a(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f1413a != null) {
            this.f1413a.mo2952a(mode);
        }
    }
}
