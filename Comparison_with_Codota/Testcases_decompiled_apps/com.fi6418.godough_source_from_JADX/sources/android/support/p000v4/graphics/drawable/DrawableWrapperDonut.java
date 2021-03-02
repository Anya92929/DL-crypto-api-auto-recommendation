package android.support.p000v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

/* renamed from: android.support.v4.graphics.drawable.DrawableWrapperDonut */
class DrawableWrapperDonut extends Drawable implements Drawable.Callback, DrawableWrapper {

    /* renamed from: a */
    static final PorterDuff.Mode f788a = PorterDuff.Mode.SRC_IN;

    /* renamed from: b */
    Drawable f789b;

    /* renamed from: c */
    private ColorStateList f790c;

    /* renamed from: d */
    private PorterDuff.Mode f791d = f788a;

    /* renamed from: e */
    private int f792e;

    /* renamed from: f */
    private PorterDuff.Mode f793f;

    /* renamed from: g */
    private boolean f794g;

    DrawableWrapperDonut(Drawable drawable) {
        setWrappedDrawable(drawable);
    }

    /* renamed from: a */
    private boolean m658a(int[] iArr) {
        if (this.f790c == null || this.f791d == null) {
            this.f794g = false;
            clearColorFilter();
        } else {
            int colorForState = this.f790c.getColorForState(iArr, this.f790c.getDefaultColor());
            PorterDuff.Mode mode = this.f791d;
            if (!(this.f794g && colorForState == this.f792e && mode == this.f793f)) {
                setColorFilter(colorForState, mode);
                this.f792e = colorForState;
                this.f793f = mode;
                this.f794g = true;
                return true;
            }
        }
        return false;
    }

    public void draw(Canvas canvas) {
        this.f789b.draw(canvas);
    }

    public int getChangingConfigurations() {
        return this.f789b.getChangingConfigurations();
    }

    public Drawable getCurrent() {
        return this.f789b.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.f789b.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.f789b.getIntrinsicWidth();
    }

    public int getMinimumHeight() {
        return this.f789b.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.f789b.getMinimumWidth();
    }

    public int getOpacity() {
        return this.f789b.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.f789b.getPadding(rect);
    }

    public int[] getState() {
        return this.f789b.getState();
    }

    public Region getTransparentRegion() {
        return this.f789b.getTransparentRegion();
    }

    public Drawable getWrappedDrawable() {
        return this.f789b;
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public boolean isStateful() {
        return (this.f790c != null && this.f790c.isStateful()) || this.f789b.isStateful();
    }

    public Drawable mutate() {
        Drawable drawable = this.f789b;
        Drawable mutate = drawable.mutate();
        if (mutate != drawable) {
            setWrappedDrawable(mutate);
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.f789b.setBounds(rect);
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i) {
        return this.f789b.setLevel(i);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    public void setAlpha(int i) {
        this.f789b.setAlpha(i);
    }

    public void setChangingConfigurations(int i) {
        this.f789b.setChangingConfigurations(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f789b.setColorFilter(colorFilter);
    }

    public void setDither(boolean z) {
        this.f789b.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.f789b.setFilterBitmap(z);
    }

    public boolean setState(int[] iArr) {
        return m658a(iArr) || this.f789b.setState(iArr);
    }

    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f790c = colorStateList;
        m658a(getState());
    }

    public void setTintMode(PorterDuff.Mode mode) {
        this.f791d = mode;
        m658a(getState());
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f789b.setVisible(z, z2);
    }

    public void setWrappedDrawable(Drawable drawable) {
        if (this.f789b != null) {
            this.f789b.setCallback((Drawable.Callback) null);
        }
        this.f789b = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        invalidateSelf();
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
