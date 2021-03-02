package p000;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.p001v4.graphics.drawable.DrawableCompat;
import android.support.p001v4.widget.CompoundButtonCompat;
import android.support.p004v7.appcompat.C0505R;
import android.support.p004v7.graphics.drawable.DrawableUtils;
import android.support.p004v7.widget.TintManager;
import android.util.AttributeSet;
import android.widget.CompoundButton;

/* renamed from: gq */
public class C1173gq {

    /* renamed from: a */
    private final CompoundButton f4174a;

    /* renamed from: b */
    private final TintManager f4175b;

    /* renamed from: c */
    private ColorStateList f4176c = null;

    /* renamed from: d */
    private PorterDuff.Mode f4177d = null;

    /* renamed from: e */
    private boolean f4178e = false;

    /* renamed from: f */
    private boolean f4179f = false;

    /* renamed from: g */
    private boolean f4180g;

    public C1173gq(CompoundButton compoundButton, TintManager tintManager) {
        this.f4174a = compoundButton;
        this.f4175b = tintManager;
    }

    /* renamed from: a */
    public void mo8194a(AttributeSet attributeSet, int i) {
        int resourceId;
        TypedArray obtainStyledAttributes = this.f4174a.getContext().obtainStyledAttributes(attributeSet, C0505R.styleable.CompoundButton, i, 0);
        try {
            if (obtainStyledAttributes.hasValue(C0505R.styleable.CompoundButton_android_button) && (resourceId = obtainStyledAttributes.getResourceId(C0505R.styleable.CompoundButton_android_button, 0)) != 0) {
                this.f4174a.setButtonDrawable(this.f4175b.getDrawable(resourceId));
            }
            if (obtainStyledAttributes.hasValue(C0505R.styleable.CompoundButton_buttonTint)) {
                CompoundButtonCompat.setButtonTintList(this.f4174a, obtainStyledAttributes.getColorStateList(C0505R.styleable.CompoundButton_buttonTint));
            }
            if (obtainStyledAttributes.hasValue(C0505R.styleable.CompoundButton_buttonTintMode)) {
                CompoundButtonCompat.setButtonTintMode(this.f4174a, DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(C0505R.styleable.CompoundButton_buttonTintMode, -1), (PorterDuff.Mode) null));
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: a */
    public void mo8192a(ColorStateList colorStateList) {
        this.f4176c = colorStateList;
        this.f4178e = true;
        mo8197d();
    }

    /* renamed from: a */
    public ColorStateList mo8191a() {
        return this.f4176c;
    }

    /* renamed from: a */
    public void mo8193a(@Nullable PorterDuff.Mode mode) {
        this.f4177d = mode;
        this.f4179f = true;
        mo8197d();
    }

    /* renamed from: b */
    public PorterDuff.Mode mo8195b() {
        return this.f4177d;
    }

    /* renamed from: c */
    public void mo8196c() {
        if (this.f4180g) {
            this.f4180g = false;
            return;
        }
        this.f4180g = true;
        mo8197d();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo8197d() {
        Drawable buttonDrawable = CompoundButtonCompat.getButtonDrawable(this.f4174a);
        if (buttonDrawable == null) {
            return;
        }
        if (this.f4178e || this.f4179f) {
            Drawable mutate = DrawableCompat.wrap(buttonDrawable).mutate();
            if (this.f4178e) {
                DrawableCompat.setTintList(mutate, this.f4176c);
            }
            if (this.f4179f) {
                DrawableCompat.setTintMode(mutate, this.f4177d);
            }
            if (mutate.isStateful()) {
                mutate.setState(this.f4174a.getDrawableState());
            }
            this.f4174a.setButtonDrawable(mutate);
        }
    }

    /* renamed from: a */
    public int mo8190a(int i) {
        Drawable buttonDrawable;
        if (Build.VERSION.SDK_INT >= 17 || (buttonDrawable = CompoundButtonCompat.getButtonDrawable(this.f4174a)) == null) {
            return i;
        }
        return i + buttonDrawable.getIntrinsicWidth();
    }
}
