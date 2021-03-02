package android.support.p009v4.p012b.p013a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

/* renamed from: android.support.v4.b.a.r */
class C0114r extends Drawable implements Drawable.Callback, C0113q {

    /* renamed from: a */
    static final PorterDuff.Mode f172a = PorterDuff.Mode.SRC_IN;

    /* renamed from: b */
    C0115s f173b;

    /* renamed from: c */
    Drawable f174c;

    /* renamed from: d */
    private int f175d;

    /* renamed from: e */
    private PorterDuff.Mode f176e;

    /* renamed from: f */
    private boolean f177f;

    /* renamed from: g */
    private boolean f178g;

    C0114r(Drawable drawable) {
        if (!(drawable == null || drawable.getConstantState() == null)) {
            this.f173b = mo952b();
        }
        mo983a(drawable);
    }

    C0114r(C0115s sVar, Resources resources) {
        this.f173b = sVar;
        m297a(resources);
    }

    /* renamed from: a */
    private void m297a(Resources resources) {
        if (this.f173b != null && this.f173b.f180b != null) {
            mo983a(mo984a(this.f173b.f180b, resources));
        }
    }

    /* renamed from: a */
    private boolean m298a(int[] iArr) {
        if (!mo953c()) {
            return false;
        }
        ColorStateList colorStateList = this.f173b.f181c;
        PorterDuff.Mode mode = this.f173b.f182d;
        if (colorStateList == null || mode == null) {
            this.f177f = false;
            clearColorFilter();
            return false;
        }
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (this.f177f && colorForState == this.f175d && mode == this.f176e) {
            return false;
        }
        setColorFilter(colorForState, mode);
        this.f175d = colorForState;
        this.f176e = mode;
        this.f177f = true;
        return true;
    }

    /* renamed from: a */
    public final Drawable mo979a() {
        return this.f174c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Drawable mo984a(Drawable.ConstantState constantState, Resources resources) {
        return constantState.newDrawable();
    }

    /* renamed from: a */
    public void mo980a(int i) {
        mo981a(ColorStateList.valueOf(i));
    }

    /* renamed from: a */
    public void mo981a(ColorStateList colorStateList) {
        this.f173b.f181c = colorStateList;
        m298a(getState());
    }

    /* renamed from: a */
    public void mo982a(PorterDuff.Mode mode) {
        this.f173b.f182d = mode;
        m298a(getState());
    }

    /* renamed from: a */
    public final void mo983a(Drawable drawable) {
        if (this.f174c != null) {
            this.f174c.setCallback((Drawable.Callback) null);
        }
        this.f174c = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            drawable.setVisible(isVisible(), true);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            if (this.f173b != null) {
                this.f173b.f180b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C0115s mo952b() {
        return new C0116t(this.f173b, (Resources) null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public boolean mo953c() {
        return true;
    }

    public void draw(Canvas canvas) {
        this.f174c.draw(canvas);
    }

    public int getChangingConfigurations() {
        return (this.f173b != null ? this.f173b.getChangingConfigurations() : 0) | super.getChangingConfigurations() | this.f174c.getChangingConfigurations();
    }

    public Drawable.ConstantState getConstantState() {
        if (this.f173b == null || !this.f173b.mo1010a()) {
            return null;
        }
        this.f173b.f179a = getChangingConfigurations();
        return this.f173b;
    }

    public Drawable getCurrent() {
        return this.f174c.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.f174c.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.f174c.getIntrinsicWidth();
    }

    public int getMinimumHeight() {
        return this.f174c.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.f174c.getMinimumWidth();
    }

    public int getOpacity() {
        return this.f174c.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.f174c.getPadding(rect);
    }

    public int[] getState() {
        return this.f174c.getState();
    }

    public Region getTransparentRegion() {
        return this.f174c.getTransparentRegion();
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public boolean isStateful() {
        ColorStateList colorStateList = mo953c() ? this.f173b.f181c : null;
        return (colorStateList != null && colorStateList.isStateful()) || this.f174c.isStateful();
    }

    public Drawable mutate() {
        if (!this.f178g && super.mutate() == this) {
            this.f173b = mo952b();
            if (this.f174c != null) {
                this.f174c.mutate();
            }
            if (this.f173b != null) {
                this.f173b.f180b = this.f174c != null ? this.f174c.getConstantState() : null;
            }
            this.f178g = true;
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        if (this.f174c != null) {
            this.f174c.setBounds(rect);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i) {
        return this.f174c.setLevel(i);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    public void setAlpha(int i) {
        this.f174c.setAlpha(i);
    }

    public void setChangingConfigurations(int i) {
        this.f174c.setChangingConfigurations(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f174c.setColorFilter(colorFilter);
    }

    public void setDither(boolean z) {
        this.f174c.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.f174c.setFilterBitmap(z);
    }

    public boolean setState(int[] iArr) {
        return m298a(iArr) || this.f174c.setState(iArr);
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f174c.setVisible(z, z2);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
