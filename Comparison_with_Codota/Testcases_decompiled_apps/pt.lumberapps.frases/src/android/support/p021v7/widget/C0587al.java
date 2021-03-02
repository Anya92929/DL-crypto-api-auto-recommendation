package android.support.p021v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.p009v4.p010a.C0025a;
import android.support.p009v4.widget.C0397bm;
import android.support.p021v7.p023b.C0506b;
import android.util.AttributeSet;
import android.widget.CheckBox;

/* renamed from: android.support.v7.widget.al */
public class C0587al extends CheckBox implements C0397bm {

    /* renamed from: a */
    private C0591ap f1382a;

    /* renamed from: b */
    private C0590ao f1383b;

    public C0587al(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0506b.checkboxStyle);
    }

    public C0587al(Context context, AttributeSet attributeSet, int i) {
        super(C0667dk.m3010a(context), attributeSet, i);
        this.f1382a = C0591ap.m2736a();
        this.f1383b = new C0590ao(this, this.f1382a);
        this.f1383b.mo2977a(attributeSet, i);
    }

    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        return this.f1383b != null ? this.f1383b.mo2973a(compoundPaddingLeft) : compoundPaddingLeft;
    }

    public ColorStateList getSupportButtonTintList() {
        if (this.f1383b != null) {
            return this.f1383b.mo2974a();
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        if (this.f1383b != null) {
            return this.f1383b.mo2978b();
        }
        return null;
    }

    public void setButtonDrawable(int i) {
        setButtonDrawable(this.f1382a != null ? this.f1382a.mo2982a(getContext(), i) : C0025a.getDrawable(getContext(), i));
    }

    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        if (this.f1383b != null) {
            this.f1383b.mo2979c();
        }
    }

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        if (this.f1383b != null) {
            this.f1383b.mo2975a(colorStateList);
        }
    }

    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        if (this.f1383b != null) {
            this.f1383b.mo2976a(mode);
        }
    }
}
