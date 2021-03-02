package android.support.p003v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.p000v4.view.TintableBackgroundView;
import android.support.p003v7.appcompat.C0235R;
import android.support.p003v7.internal.widget.TintContextWrapper;
import android.support.p003v7.internal.widget.TintManager;
import android.support.p003v7.internal.widget.TintTypedArray;
import android.util.AttributeSet;
import android.widget.MultiAutoCompleteTextView;

/* renamed from: android.support.v7.widget.AppCompatMultiAutoCompleteTextView */
public class AppCompatMultiAutoCompleteTextView extends MultiAutoCompleteTextView implements TintableBackgroundView {

    /* renamed from: a */
    private static final int[] f2675a = {16843126};

    /* renamed from: b */
    private TintManager f2676b;

    /* renamed from: c */
    private AppCompatBackgroundHelper f2677c;

    /* renamed from: d */
    private AppCompatTextHelper f2678d;

    public AppCompatMultiAutoCompleteTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public AppCompatMultiAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0235R.attr.autoCompleteTextViewStyle);
    }

    public AppCompatMultiAutoCompleteTextView(Context context, AttributeSet attributeSet, int i) {
        super(TintContextWrapper.wrap(context), attributeSet, i);
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(getContext(), attributeSet, f2675a, i, 0);
        this.f2676b = obtainStyledAttributes.getTintManager();
        if (obtainStyledAttributes.hasValue(0)) {
            setDropDownBackgroundDrawable(obtainStyledAttributes.getDrawable(0));
        }
        obtainStyledAttributes.recycle();
        this.f2677c = new AppCompatBackgroundHelper(this, this.f2676b);
        this.f2677c.mo5106a(attributeSet, i);
        this.f2678d = new AppCompatTextHelper(this);
        this.f2678d.mo5186a(attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f2677c != null) {
            this.f2677c.mo5109c();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        if (this.f2677c != null) {
            return this.f2677c.mo5101a();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.f2677c != null) {
            return this.f2677c.mo5107b();
        }
        return null;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f2677c != null) {
            this.f2677c.mo5105a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f2677c != null) {
            this.f2677c.mo5102a(i);
        }
    }

    public void setDropDownBackgroundResource(int i) {
        if (this.f2676b != null) {
            setDropDownBackgroundDrawable(this.f2676b.getDrawable(i));
        } else {
            super.setDropDownBackgroundResource(i);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f2677c != null) {
            this.f2677c.mo5103a(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f2677c != null) {
            this.f2677c.mo5104a(mode);
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f2678d != null) {
            this.f2678d.mo5185a(context, i);
        }
    }
}
