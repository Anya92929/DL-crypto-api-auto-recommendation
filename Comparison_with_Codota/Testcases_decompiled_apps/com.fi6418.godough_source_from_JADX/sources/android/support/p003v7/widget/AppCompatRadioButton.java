package android.support.p003v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.p000v4.content.ContextCompat;
import android.support.p000v4.widget.TintableCompoundButton;
import android.support.p003v7.appcompat.C0235R;
import android.support.p003v7.internal.widget.TintManager;
import android.util.AttributeSet;
import android.widget.RadioButton;

/* renamed from: android.support.v7.widget.AppCompatRadioButton */
public class AppCompatRadioButton extends RadioButton implements TintableCompoundButton {

    /* renamed from: a */
    private TintManager f2679a;

    /* renamed from: b */
    private AppCompatCompoundButtonHelper f2680b;

    public AppCompatRadioButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public AppCompatRadioButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0235R.attr.radioButtonStyle);
    }

    public AppCompatRadioButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2679a = TintManager.get(context);
        this.f2680b = new AppCompatCompoundButtonHelper(this, this.f2679a);
        this.f2680b.mo5125a(attributeSet, i);
    }

    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        return this.f2680b != null ? this.f2680b.mo5121a(compoundPaddingLeft) : compoundPaddingLeft;
    }

    public ColorStateList getSupportButtonTintList() {
        if (this.f2680b != null) {
            return this.f2680b.mo5122a();
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        if (this.f2680b != null) {
            return this.f2680b.mo5126b();
        }
        return null;
    }

    public void setButtonDrawable(int i) {
        setButtonDrawable(this.f2679a != null ? this.f2679a.getDrawable(i) : ContextCompat.getDrawable(getContext(), i));
    }

    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        if (this.f2680b != null) {
            this.f2680b.mo5127c();
        }
    }

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        if (this.f2680b != null) {
            this.f2680b.mo5123a(colorStateList);
        }
    }

    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        if (this.f2680b != null) {
            this.f2680b.mo5124a(mode);
        }
    }
}
