package android.support.p021v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.p009v4.p010a.C0025a;
import android.support.p009v4.widget.C0397bm;
import android.support.p021v7.p023b.C0506b;
import android.util.AttributeSet;
import android.widget.RadioButton;

/* renamed from: android.support.v7.widget.bd */
public class C0606bd extends RadioButton implements C0397bm {

    /* renamed from: a */
    private C0591ap f1435a;

    /* renamed from: b */
    private C0590ao f1436b;

    public C0606bd(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0506b.radioButtonStyle);
    }

    public C0606bd(Context context, AttributeSet attributeSet, int i) {
        super(C0667dk.m3010a(context), attributeSet, i);
        this.f1435a = C0591ap.m2736a();
        this.f1436b = new C0590ao(this, this.f1435a);
        this.f1436b.mo2977a(attributeSet, i);
    }

    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        return this.f1436b != null ? this.f1436b.mo2973a(compoundPaddingLeft) : compoundPaddingLeft;
    }

    public ColorStateList getSupportButtonTintList() {
        if (this.f1436b != null) {
            return this.f1436b.mo2974a();
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        if (this.f1436b != null) {
            return this.f1436b.mo2978b();
        }
        return null;
    }

    public void setButtonDrawable(int i) {
        setButtonDrawable(this.f1435a != null ? this.f1435a.mo2982a(getContext(), i) : C0025a.getDrawable(getContext(), i));
    }

    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        if (this.f1436b != null) {
            this.f1436b.mo2979c();
        }
    }

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        if (this.f1436b != null) {
            this.f1436b.mo2975a(colorStateList);
        }
    }

    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        if (this.f1436b != null) {
            this.f1436b.mo2976a(mode);
        }
    }
}
