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
import android.widget.EditText;
import android.widget.TextView;

/* renamed from: android.support.v7.widget.AppCompatEditText */
public class AppCompatEditText extends EditText implements TintableBackgroundView {

    /* renamed from: a */
    private TintManager f2014a;

    /* renamed from: b */
    private C1172gp f2015b;

    /* renamed from: c */
    private C1177gu f2016c;

    public AppCompatEditText(Context context) {
        this(context, (AttributeSet) null);
    }

    public AppCompatEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0505R.attr.editTextStyle);
    }

    public AppCompatEditText(Context context, AttributeSet attributeSet, int i) {
        super(C1189hb.m5259a(context), attributeSet, i);
        this.f2014a = TintManager.get(getContext());
        this.f2015b = new C1172gp(this, this.f2014a);
        this.f2015b.mo8186a(attributeSet, i);
        this.f2016c = C1177gu.m5217a((TextView) this);
        this.f2016c.mo8205a(attributeSet, i);
        this.f2016c.mo8202a();
    }

    public void setBackgroundResource(@DrawableRes int i) {
        super.setBackgroundResource(i);
        if (this.f2015b != null) {
            this.f2015b.mo8182a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f2015b != null) {
            this.f2015b.mo8185a(drawable);
        }
    }

    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        if (this.f2015b != null) {
            this.f2015b.mo8183a(colorStateList);
        }
    }

    @Nullable
    public ColorStateList getSupportBackgroundTintList() {
        if (this.f2015b != null) {
            return this.f2015b.mo8181a();
        }
        return null;
    }

    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.f2015b != null) {
            this.f2015b.mo8184a(mode);
        }
    }

    @Nullable
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.f2015b != null) {
            return this.f2015b.mo8187b();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f2015b != null) {
            this.f2015b.mo8189c();
        }
        if (this.f2016c != null) {
            this.f2016c.mo8202a();
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f2016c != null) {
            this.f2016c.mo8203a(context, i);
        }
    }
}
