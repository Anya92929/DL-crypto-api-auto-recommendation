package android.support.p004v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.p001v4.content.ContextCompat;
import android.support.p001v4.widget.TintableCompoundButton;
import android.support.p004v7.appcompat.C0505R;
import android.util.AttributeSet;
import android.widget.RadioButton;

/* renamed from: android.support.v7.widget.AppCompatRadioButton */
public class AppCompatRadioButton extends RadioButton implements TintableCompoundButton {

    /* renamed from: a */
    private TintManager f2030a;

    /* renamed from: b */
    private C1173gq f2031b;

    public AppCompatRadioButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public AppCompatRadioButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0505R.attr.radioButtonStyle);
    }

    public AppCompatRadioButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2030a = TintManager.get(context);
        this.f2031b = new C1173gq(this, this.f2030a);
        this.f2031b.mo8194a(attributeSet, i);
    }

    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        if (this.f2031b != null) {
            this.f2031b.mo8196c();
        }
    }

    public void setButtonDrawable(@DrawableRes int i) {
        setButtonDrawable(this.f2030a != null ? this.f2030a.getDrawable(i) : ContextCompat.getDrawable(getContext(), i));
    }

    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        return this.f2031b != null ? this.f2031b.mo8190a(compoundPaddingLeft) : compoundPaddingLeft;
    }

    public void setSupportButtonTintList(@Nullable ColorStateList colorStateList) {
        if (this.f2031b != null) {
            this.f2031b.mo8192a(colorStateList);
        }
    }

    @Nullable
    public ColorStateList getSupportButtonTintList() {
        if (this.f2031b != null) {
            return this.f2031b.mo8191a();
        }
        return null;
    }

    public void setSupportButtonTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.f2031b != null) {
            this.f2031b.mo8193a(mode);
        }
    }

    @Nullable
    public PorterDuff.Mode getSupportButtonTintMode() {
        if (this.f2031b != null) {
            return this.f2031b.mo8195b();
        }
        return null;
    }
}
