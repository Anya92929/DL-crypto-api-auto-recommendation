package android.support.p004v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.p001v4.view.TintableBackgroundView;
import android.util.AttributeSet;
import android.widget.TextView;

/* renamed from: android.support.v7.widget.AppCompatTextView */
public class AppCompatTextView extends TextView implements TintableBackgroundView {

    /* renamed from: a */
    private TintManager f2061a;

    /* renamed from: b */
    private C1172gp f2062b;

    /* renamed from: c */
    private C1177gu f2063c;

    public AppCompatTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2061a = TintManager.get(getContext());
        this.f2062b = new C1172gp(this, this.f2061a);
        this.f2062b.mo8186a(attributeSet, i);
        this.f2063c = C1177gu.m5217a((TextView) this);
        this.f2063c.mo8205a(attributeSet, i);
        this.f2063c.mo8202a();
    }

    public void setBackgroundResource(@DrawableRes int i) {
        super.setBackgroundResource(i);
        if (this.f2062b != null) {
            this.f2062b.mo8182a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f2062b != null) {
            this.f2062b.mo8185a(drawable);
        }
    }

    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        if (this.f2062b != null) {
            this.f2062b.mo8183a(colorStateList);
        }
    }

    @Nullable
    public ColorStateList getSupportBackgroundTintList() {
        if (this.f2062b != null) {
            return this.f2062b.mo8181a();
        }
        return null;
    }

    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.f2062b != null) {
            this.f2062b.mo8184a(mode);
        }
    }

    @Nullable
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.f2062b != null) {
            return this.f2062b.mo8187b();
        }
        return null;
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f2063c != null) {
            this.f2063c.mo8203a(context, i);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f2062b != null) {
            this.f2062b.mo8189c();
        }
        if (this.f2063c != null) {
            this.f2063c.mo8202a();
        }
    }
}
