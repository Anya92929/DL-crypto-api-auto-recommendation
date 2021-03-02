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
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

/* renamed from: android.support.v7.widget.AppCompatAutoCompleteTextView */
public class AppCompatAutoCompleteTextView extends AutoCompleteTextView implements TintableBackgroundView {

    /* renamed from: a */
    private static final int[] f1991a = {16843126};

    /* renamed from: b */
    private TintManager f1992b;

    /* renamed from: c */
    private C1172gp f1993c;

    /* renamed from: d */
    private C1177gu f1994d;

    public AppCompatAutoCompleteTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public AppCompatAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0505R.attr.autoCompleteTextViewStyle);
    }

    public AppCompatAutoCompleteTextView(Context context, AttributeSet attributeSet, int i) {
        super(C1189hb.m5259a(context), attributeSet, i);
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(getContext(), attributeSet, f1991a, i, 0);
        this.f1992b = obtainStyledAttributes.getTintManager();
        if (obtainStyledAttributes.hasValue(0)) {
            setDropDownBackgroundDrawable(obtainStyledAttributes.getDrawable(0));
        }
        obtainStyledAttributes.recycle();
        this.f1993c = new C1172gp(this, this.f1992b);
        this.f1993c.mo8186a(attributeSet, i);
        this.f1994d = C1177gu.m5217a((TextView) this);
        this.f1994d.mo8205a(attributeSet, i);
        this.f1994d.mo8202a();
    }

    public void setDropDownBackgroundResource(@DrawableRes int i) {
        if (this.f1992b != null) {
            setDropDownBackgroundDrawable(this.f1992b.getDrawable(i));
        } else {
            super.setDropDownBackgroundResource(i);
        }
    }

    public void setBackgroundResource(@DrawableRes int i) {
        super.setBackgroundResource(i);
        if (this.f1993c != null) {
            this.f1993c.mo8182a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f1993c != null) {
            this.f1993c.mo8185a(drawable);
        }
    }

    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        if (this.f1993c != null) {
            this.f1993c.mo8183a(colorStateList);
        }
    }

    @Nullable
    public ColorStateList getSupportBackgroundTintList() {
        if (this.f1993c != null) {
            return this.f1993c.mo8181a();
        }
        return null;
    }

    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.f1993c != null) {
            this.f1993c.mo8184a(mode);
        }
    }

    @Nullable
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.f1993c != null) {
            return this.f1993c.mo8187b();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1993c != null) {
            this.f1993c.mo8189c();
        }
        if (this.f1994d != null) {
            this.f1994d.mo8202a();
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f1994d != null) {
            this.f1994d.mo8203a(context, i);
        }
    }
}
