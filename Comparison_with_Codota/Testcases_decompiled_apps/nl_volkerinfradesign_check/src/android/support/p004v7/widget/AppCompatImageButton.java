package android.support.p004v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.p001v4.view.TintableBackgroundView;
import android.support.p004v7.appcompat.C0505R;
import android.util.AttributeSet;
import android.widget.ImageButton;

/* renamed from: android.support.v7.widget.AppCompatImageButton */
public class AppCompatImageButton extends ImageButton implements TintableBackgroundView {

    /* renamed from: a */
    private C1172gp f2017a;

    /* renamed from: b */
    private C1174gr f2018b;

    public AppCompatImageButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public AppCompatImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0505R.attr.imageButtonStyle);
    }

    public AppCompatImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TintManager tintManager = TintManager.get(context);
        this.f2017a = new C1172gp(this, tintManager);
        this.f2017a.mo8186a(attributeSet, i);
        this.f2018b = new C1174gr(this, tintManager);
        this.f2018b.mo8199a(attributeSet, i);
    }

    public void setImageResource(@DrawableRes int i) {
        this.f2018b.mo8198a(i);
    }

    public void setBackgroundResource(@DrawableRes int i) {
        super.setBackgroundResource(i);
        if (this.f2017a != null) {
            this.f2017a.mo8182a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f2017a != null) {
            this.f2017a.mo8185a(drawable);
        }
    }

    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        if (this.f2017a != null) {
            this.f2017a.mo8183a(colorStateList);
        }
    }

    @Nullable
    public ColorStateList getSupportBackgroundTintList() {
        if (this.f2017a != null) {
            return this.f2017a.mo8181a();
        }
        return null;
    }

    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.f2017a != null) {
            this.f2017a.mo8184a(mode);
        }
    }

    @Nullable
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.f2017a != null) {
            return this.f2017a.mo8187b();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f2017a != null) {
            this.f2017a.mo8189c();
        }
    }
}
