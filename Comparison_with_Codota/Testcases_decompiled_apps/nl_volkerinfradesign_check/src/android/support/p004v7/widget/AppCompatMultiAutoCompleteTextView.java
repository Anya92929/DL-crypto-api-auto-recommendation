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
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

/* renamed from: android.support.v7.widget.AppCompatMultiAutoCompleteTextView */
public class AppCompatMultiAutoCompleteTextView extends MultiAutoCompleteTextView implements TintableBackgroundView {

    /* renamed from: a */
    private static final int[] f2021a = {16843126};

    /* renamed from: b */
    private TintManager f2022b;

    /* renamed from: c */
    private C1172gp f2023c;

    /* renamed from: d */
    private C1177gu f2024d;

    public AppCompatMultiAutoCompleteTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public AppCompatMultiAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0505R.attr.autoCompleteTextViewStyle);
    }

    public AppCompatMultiAutoCompleteTextView(Context context, AttributeSet attributeSet, int i) {
        super(C1189hb.m5259a(context), attributeSet, i);
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(getContext(), attributeSet, f2021a, i, 0);
        this.f2022b = obtainStyledAttributes.getTintManager();
        if (obtainStyledAttributes.hasValue(0)) {
            setDropDownBackgroundDrawable(obtainStyledAttributes.getDrawable(0));
        }
        obtainStyledAttributes.recycle();
        this.f2023c = new C1172gp(this, this.f2022b);
        this.f2023c.mo8186a(attributeSet, i);
        this.f2024d = C1177gu.m5217a((TextView) this);
        this.f2024d.mo8205a(attributeSet, i);
        this.f2024d.mo8202a();
    }

    public void setDropDownBackgroundResource(@DrawableRes int i) {
        if (this.f2022b != null) {
            setDropDownBackgroundDrawable(this.f2022b.getDrawable(i));
        } else {
            super.setDropDownBackgroundResource(i);
        }
    }

    public void setBackgroundResource(@DrawableRes int i) {
        super.setBackgroundResource(i);
        if (this.f2023c != null) {
            this.f2023c.mo8182a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f2023c != null) {
            this.f2023c.mo8185a(drawable);
        }
    }

    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        if (this.f2023c != null) {
            this.f2023c.mo8183a(colorStateList);
        }
    }

    @Nullable
    public ColorStateList getSupportBackgroundTintList() {
        if (this.f2023c != null) {
            return this.f2023c.mo8181a();
        }
        return null;
    }

    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.f2023c != null) {
            this.f2023c.mo8184a(mode);
        }
    }

    @Nullable
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.f2023c != null) {
            return this.f2023c.mo8187b();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f2023c != null) {
            this.f2023c.mo8189c();
        }
        if (this.f2024d != null) {
            this.f2024d.mo8202a();
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f2024d != null) {
            this.f2024d.mo8203a(context, i);
        }
    }
}
