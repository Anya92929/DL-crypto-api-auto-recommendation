package android.support.p003v7.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.p000v4.view.ViewCompat;
import android.support.p003v7.appcompat.C0235R;
import android.support.p003v7.graphics.drawable.DrawableUtils;
import android.support.p003v7.internal.widget.TintInfo;
import android.support.p003v7.internal.widget.TintManager;
import android.util.AttributeSet;
import android.view.View;

/* renamed from: android.support.v7.widget.AppCompatBackgroundHelper */
class AppCompatBackgroundHelper {

    /* renamed from: a */
    private final View f2654a;

    /* renamed from: b */
    private final TintManager f2655b;

    /* renamed from: c */
    private TintInfo f2656c;

    /* renamed from: d */
    private TintInfo f2657d;

    AppCompatBackgroundHelper(View view, TintManager tintManager) {
        this.f2654a = view;
        this.f2655b = tintManager;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public ColorStateList mo5101a() {
        if (this.f2657d != null) {
            return this.f2657d.mTintList;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5102a(int i) {
        mo5108b(this.f2655b != null ? this.f2655b.getTintList(i) : null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5103a(ColorStateList colorStateList) {
        if (this.f2657d == null) {
            this.f2657d = new TintInfo();
        }
        this.f2657d.mTintList = colorStateList;
        this.f2657d.mHasTintList = true;
        mo5109c();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5104a(PorterDuff.Mode mode) {
        if (this.f2657d == null) {
            this.f2657d = new TintInfo();
        }
        this.f2657d.mTintMode = mode;
        this.f2657d.mHasTintMode = true;
        mo5109c();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5105a(Drawable drawable) {
        mo5108b((ColorStateList) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5106a(AttributeSet attributeSet, int i) {
        ColorStateList tintList;
        TypedArray obtainStyledAttributes = this.f2654a.getContext().obtainStyledAttributes(attributeSet, C0235R.styleable.ViewBackgroundHelper, i, 0);
        try {
            if (obtainStyledAttributes.hasValue(C0235R.styleable.ViewBackgroundHelper_android_background) && (tintList = this.f2655b.getTintList(obtainStyledAttributes.getResourceId(C0235R.styleable.ViewBackgroundHelper_android_background, -1))) != null) {
                mo5108b(tintList);
            }
            if (obtainStyledAttributes.hasValue(C0235R.styleable.ViewBackgroundHelper_backgroundTint)) {
                ViewCompat.setBackgroundTintList(this.f2654a, obtainStyledAttributes.getColorStateList(C0235R.styleable.ViewBackgroundHelper_backgroundTint));
            }
            if (obtainStyledAttributes.hasValue(C0235R.styleable.ViewBackgroundHelper_backgroundTintMode)) {
                ViewCompat.setBackgroundTintMode(this.f2654a, DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(C0235R.styleable.ViewBackgroundHelper_backgroundTintMode, -1), (PorterDuff.Mode) null));
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public PorterDuff.Mode mo5107b() {
        if (this.f2657d != null) {
            return this.f2657d.mTintMode;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo5108b(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f2656c == null) {
                this.f2656c = new TintInfo();
            }
            this.f2656c.mTintList = colorStateList;
            this.f2656c.mHasTintList = true;
        } else {
            this.f2656c = null;
        }
        mo5109c();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo5109c() {
        if (this.f2654a.getBackground() == null) {
            return;
        }
        if (this.f2657d != null) {
            TintManager.tintViewBackground(this.f2654a, this.f2657d);
        } else if (this.f2656c != null) {
            TintManager.tintViewBackground(this.f2654a, this.f2656c);
        }
    }
}
