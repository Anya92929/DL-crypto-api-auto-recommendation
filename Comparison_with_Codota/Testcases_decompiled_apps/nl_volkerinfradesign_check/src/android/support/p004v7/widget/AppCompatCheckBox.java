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
import android.widget.CheckBox;

/* renamed from: android.support.v7.widget.AppCompatCheckBox */
public class AppCompatCheckBox extends CheckBox implements TintableCompoundButton {

    /* renamed from: a */
    private TintManager f1998a;

    /* renamed from: b */
    private C1173gq f1999b;

    public AppCompatCheckBox(Context context) {
        this(context, (AttributeSet) null);
    }

    public AppCompatCheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0505R.attr.checkboxStyle);
    }

    public AppCompatCheckBox(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1998a = TintManager.get(context);
        this.f1999b = new C1173gq(this, this.f1998a);
        this.f1999b.mo8194a(attributeSet, i);
    }

    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        if (this.f1999b != null) {
            this.f1999b.mo8196c();
        }
    }

    public void setButtonDrawable(@DrawableRes int i) {
        setButtonDrawable(this.f1998a != null ? this.f1998a.getDrawable(i) : ContextCompat.getDrawable(getContext(), i));
    }

    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        return this.f1999b != null ? this.f1999b.mo8190a(compoundPaddingLeft) : compoundPaddingLeft;
    }

    public void setSupportButtonTintList(@Nullable ColorStateList colorStateList) {
        if (this.f1999b != null) {
            this.f1999b.mo8192a(colorStateList);
        }
    }

    @Nullable
    public ColorStateList getSupportButtonTintList() {
        if (this.f1999b != null) {
            return this.f1999b.mo8191a();
        }
        return null;
    }

    public void setSupportButtonTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.f1999b != null) {
            this.f1999b.mo8193a(mode);
        }
    }

    @Nullable
    public PorterDuff.Mode getSupportButtonTintMode() {
        if (this.f1999b != null) {
            return this.f1999b.mo8195b();
        }
        return null;
    }
}
