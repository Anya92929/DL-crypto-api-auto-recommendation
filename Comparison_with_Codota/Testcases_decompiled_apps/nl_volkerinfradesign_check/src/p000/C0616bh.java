package p000;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.support.p001v4.graphics.drawable.DrawableWrapper;

/* renamed from: bh */
class C0616bh extends Drawable implements Drawable.Callback, DrawableWrapper {

    /* renamed from: a */
    static final PorterDuff.Mode f2402a = PorterDuff.Mode.SRC_IN;

    /* renamed from: b */
    Drawable f2403b;

    /* renamed from: c */
    private ColorStateList f2404c;

    /* renamed from: d */
    private PorterDuff.Mode f2405d = f2402a;

    /* renamed from: e */
    private int f2406e;

    /* renamed from: f */
    private PorterDuff.Mode f2407f;

    /* renamed from: g */
    private boolean f2408g;

    C0616bh(Drawable drawable) {
        setWrappedDrawable(drawable);
    }

    public void draw(Canvas canvas) {
        this.f2403b.draw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.f2403b.setBounds(rect);
    }

    public void setChangingConfigurations(int i) {
        this.f2403b.setChangingConfigurations(i);
    }

    public int getChangingConfigurations() {
        return this.f2403b.getChangingConfigurations();
    }

    public void setDither(boolean z) {
        this.f2403b.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.f2403b.setFilterBitmap(z);
    }

    public void setAlpha(int i) {
        this.f2403b.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f2403b.setColorFilter(colorFilter);
    }

    public boolean isStateful() {
        return (this.f2404c != null && this.f2404c.isStateful()) || this.f2403b.isStateful();
    }

    public boolean setState(int[] iArr) {
        return m3433a(iArr) || this.f2403b.setState(iArr);
    }

    public int[] getState() {
        return this.f2403b.getState();
    }

    public Drawable getCurrent() {
        return this.f2403b.getCurrent();
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f2403b.setVisible(z, z2);
    }

    public int getOpacity() {
        return this.f2403b.getOpacity();
    }

    public Region getTransparentRegion() {
        return this.f2403b.getTransparentRegion();
    }

    public int getIntrinsicWidth() {
        return this.f2403b.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        return this.f2403b.getIntrinsicHeight();
    }

    public int getMinimumWidth() {
        return this.f2403b.getMinimumWidth();
    }

    public int getMinimumHeight() {
        return this.f2403b.getMinimumHeight();
    }

    public boolean getPadding(Rect rect) {
        return this.f2403b.getPadding(rect);
    }

    public Drawable mutate() {
        Drawable drawable = this.f2403b;
        Drawable mutate = drawable.mutate();
        if (mutate != drawable) {
            setWrappedDrawable(mutate);
        }
        return this;
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i) {
        return this.f2403b.setLevel(i);
    }

    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f2404c = colorStateList;
        m3433a(getState());
    }

    public void setTintMode(PorterDuff.Mode mode) {
        this.f2405d = mode;
        m3433a(getState());
    }

    /* renamed from: a */
    private boolean m3433a(int[] iArr) {
        if (this.f2404c == null || this.f2405d == null) {
            this.f2408g = false;
            clearColorFilter();
        } else {
            int colorForState = this.f2404c.getColorForState(iArr, this.f2404c.getDefaultColor());
            PorterDuff.Mode mode = this.f2405d;
            if (!(this.f2408g && colorForState == this.f2406e && mode == this.f2407f)) {
                setColorFilter(colorForState, mode);
                this.f2406e = colorForState;
                this.f2407f = mode;
                this.f2408g = true;
                return true;
            }
        }
        return false;
    }

    public Drawable getWrappedDrawable() {
        return this.f2403b;
    }

    public void setWrappedDrawable(Drawable drawable) {
        if (this.f2403b != null) {
            this.f2403b.setCallback((Drawable.Callback) null);
        }
        this.f2403b = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        invalidateSelf();
    }
}
