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
import android.widget.CheckBox;

/* renamed from: android.support.v7.widget.AppCompatCheckBox */
public class AppCompatCheckBox extends CheckBox implements TintableCompoundButton {

    /* renamed from: a */
    private TintManager f2661a;

    /* renamed from: b */
    private AppCompatCompoundButtonHelper f2662b;

    public AppCompatCheckBox(Context context) {
        this(context, (AttributeSet) null);
    }

    public AppCompatCheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0235R.attr.checkboxStyle);
    }

    public AppCompatCheckBox(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2661a = TintManager.get(context);
        this.f2662b = new AppCompatCompoundButtonHelper(this, this.f2661a);
        this.f2662b.mo5125a(attributeSet, i);
    }

    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        return this.f2662b != null ? this.f2662b.mo5121a(compoundPaddingLeft) : compoundPaddingLeft;
    }

    public ColorStateList getSupportButtonTintList() {
        if (this.f2662b != null) {
            return this.f2662b.mo5122a();
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        if (this.f2662b != null) {
            return this.f2662b.mo5126b();
        }
        return null;
    }

    public void setButtonDrawable(int i) {
        setButtonDrawable(this.f2661a != null ? this.f2661a.getDrawable(i) : ContextCompat.getDrawable(getContext(), i));
    }

    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        if (this.f2662b != null) {
            this.f2662b.mo5127c();
        }
    }

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        if (this.f2662b != null) {
            this.f2662b.mo5123a(colorStateList);
        }
    }

    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        if (this.f2662b != null) {
            this.f2662b.mo5124a(mode);
        }
    }
}
