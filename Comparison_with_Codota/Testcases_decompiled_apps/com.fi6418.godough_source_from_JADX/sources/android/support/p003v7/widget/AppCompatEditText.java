package android.support.p003v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.p000v4.view.TintableBackgroundView;
import android.support.p003v7.appcompat.C0235R;
import android.support.p003v7.internal.widget.TintContextWrapper;
import android.support.p003v7.internal.widget.TintManager;
import android.util.AttributeSet;
import android.widget.EditText;

/* renamed from: android.support.v7.widget.AppCompatEditText */
public class AppCompatEditText extends EditText implements TintableBackgroundView {

    /* renamed from: a */
    private TintManager f2672a;

    /* renamed from: b */
    private AppCompatBackgroundHelper f2673b;

    /* renamed from: c */
    private AppCompatTextHelper f2674c;

    public AppCompatEditText(Context context) {
        this(context, (AttributeSet) null);
    }

    public AppCompatEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0235R.attr.editTextStyle);
    }

    public AppCompatEditText(Context context, AttributeSet attributeSet, int i) {
        super(TintContextWrapper.wrap(context), attributeSet, i);
        this.f2672a = TintManager.get(getContext());
        this.f2673b = new AppCompatBackgroundHelper(this, this.f2672a);
        this.f2673b.mo5106a(attributeSet, i);
        this.f2674c = new AppCompatTextHelper(this);
        this.f2674c.mo5186a(attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f2673b != null) {
            this.f2673b.mo5109c();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        if (this.f2673b != null) {
            return this.f2673b.mo5101a();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.f2673b != null) {
            return this.f2673b.mo5107b();
        }
        return null;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f2673b != null) {
            this.f2673b.mo5105a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f2673b != null) {
            this.f2673b.mo5102a(i);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f2673b != null) {
            this.f2673b.mo5103a(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f2673b != null) {
            this.f2673b.mo5104a(mode);
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f2674c != null) {
            this.f2674c.mo5185a(context, i);
        }
    }
}
