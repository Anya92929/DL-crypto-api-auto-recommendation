package android.support.p004v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.p001v4.view.TintableBackgroundView;
import android.util.AttributeSet;
import android.widget.ImageView;

/* renamed from: android.support.v7.widget.AppCompatImageView */
public class AppCompatImageView extends ImageView implements TintableBackgroundView {

    /* renamed from: a */
    private C1172gp f2019a;

    /* renamed from: b */
    private C1174gr f2020b;

    public AppCompatImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public AppCompatImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppCompatImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TintManager tintManager = TintManager.get(context);
        this.f2019a = new C1172gp(this, tintManager);
        this.f2019a.mo8186a(attributeSet, i);
        this.f2020b = new C1174gr(this, tintManager);
        this.f2020b.mo8199a(attributeSet, i);
    }

    public void setImageResource(@DrawableRes int i) {
        this.f2020b.mo8198a(i);
    }

    public void setBackgroundResource(@DrawableRes int i) {
        super.setBackgroundResource(i);
        if (this.f2019a != null) {
            this.f2019a.mo8182a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f2019a != null) {
            this.f2019a.mo8185a(drawable);
        }
    }

    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        if (this.f2019a != null) {
            this.f2019a.mo8183a(colorStateList);
        }
    }

    @Nullable
    public ColorStateList getSupportBackgroundTintList() {
        if (this.f2019a != null) {
            return this.f2019a.mo8181a();
        }
        return null;
    }

    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.f2019a != null) {
            this.f2019a.mo8184a(mode);
        }
    }

    @Nullable
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.f2019a != null) {
            return this.f2019a.mo8187b();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f2019a != null) {
            this.f2019a.mo8189c();
        }
    }
}
