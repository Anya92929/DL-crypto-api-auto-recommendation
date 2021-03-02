package android.support.p003v7.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.p000v4.graphics.drawable.DrawableCompat;
import android.support.p000v4.widget.CompoundButtonCompat;
import android.support.p003v7.appcompat.C0235R;
import android.support.p003v7.graphics.drawable.DrawableUtils;
import android.support.p003v7.internal.widget.TintManager;
import android.util.AttributeSet;
import android.widget.CompoundButton;

/* renamed from: android.support.v7.widget.AppCompatCompoundButtonHelper */
class AppCompatCompoundButtonHelper {

    /* renamed from: a */
    private final CompoundButton f2665a;

    /* renamed from: b */
    private final TintManager f2666b;

    /* renamed from: c */
    private ColorStateList f2667c = null;

    /* renamed from: d */
    private PorterDuff.Mode f2668d = null;

    /* renamed from: e */
    private boolean f2669e = false;

    /* renamed from: f */
    private boolean f2670f = false;

    /* renamed from: g */
    private boolean f2671g;

    /* renamed from: android.support.v7.widget.AppCompatCompoundButtonHelper$DirectSetButtonDrawableInterface */
    interface DirectSetButtonDrawableInterface {
        void setButtonDrawable(Drawable drawable);
    }

    AppCompatCompoundButtonHelper(CompoundButton compoundButton, TintManager tintManager) {
        this.f2665a = compoundButton;
        this.f2666b = tintManager;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = android.support.p000v4.widget.CompoundButtonCompat.getButtonDrawable(r2.f2665a);
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int mo5121a(int r3) {
        /*
            r2 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 17
            if (r0 >= r1) goto L_0x0013
            android.widget.CompoundButton r0 = r2.f2665a
            android.graphics.drawable.Drawable r0 = android.support.p000v4.widget.CompoundButtonCompat.getButtonDrawable(r0)
            if (r0 == 0) goto L_0x0013
            int r0 = r0.getIntrinsicWidth()
            int r3 = r3 + r0
        L_0x0013:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p003v7.widget.AppCompatCompoundButtonHelper.mo5121a(int):int");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public ColorStateList mo5122a() {
        return this.f2667c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5123a(ColorStateList colorStateList) {
        this.f2667c = colorStateList;
        this.f2669e = true;
        mo5128d();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5124a(PorterDuff.Mode mode) {
        this.f2668d = mode;
        this.f2670f = true;
        mo5128d();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5125a(AttributeSet attributeSet, int i) {
        int resourceId;
        TypedArray obtainStyledAttributes = this.f2665a.getContext().obtainStyledAttributes(attributeSet, C0235R.styleable.CompoundButton, i, 0);
        try {
            if (obtainStyledAttributes.hasValue(C0235R.styleable.CompoundButton_android_button) && (resourceId = obtainStyledAttributes.getResourceId(C0235R.styleable.CompoundButton_android_button, 0)) != 0) {
                this.f2665a.setButtonDrawable(this.f2666b.getDrawable(resourceId));
            }
            if (obtainStyledAttributes.hasValue(C0235R.styleable.CompoundButton_buttonTint)) {
                CompoundButtonCompat.setButtonTintList(this.f2665a, obtainStyledAttributes.getColorStateList(C0235R.styleable.CompoundButton_buttonTint));
            }
            if (obtainStyledAttributes.hasValue(C0235R.styleable.CompoundButton_buttonTintMode)) {
                CompoundButtonCompat.setButtonTintMode(this.f2665a, DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(C0235R.styleable.CompoundButton_buttonTintMode, -1), (PorterDuff.Mode) null));
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public PorterDuff.Mode mo5126b() {
        return this.f2668d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo5127c() {
        if (this.f2671g) {
            this.f2671g = false;
            return;
        }
        this.f2671g = true;
        mo5128d();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo5128d() {
        Drawable buttonDrawable = CompoundButtonCompat.getButtonDrawable(this.f2665a);
        if (buttonDrawable == null) {
            return;
        }
        if (this.f2669e || this.f2670f) {
            Drawable mutate = DrawableCompat.wrap(buttonDrawable).mutate();
            if (this.f2669e) {
                DrawableCompat.setTintList(mutate, this.f2667c);
            }
            if (this.f2670f) {
                DrawableCompat.setTintMode(mutate, this.f2668d);
            }
            if (mutate.isStateful()) {
                mutate.setState(this.f2665a.getDrawableState());
            }
            this.f2665a.setButtonDrawable(mutate);
        }
    }
}
