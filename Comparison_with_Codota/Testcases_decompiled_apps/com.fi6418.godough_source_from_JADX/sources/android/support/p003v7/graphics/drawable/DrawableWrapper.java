package android.support.p003v7.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.support.p000v4.graphics.drawable.DrawableCompat;

/* renamed from: android.support.v7.graphics.drawable.DrawableWrapper */
public class DrawableWrapper extends Drawable implements Drawable.Callback {

    /* renamed from: a */
    private Drawable f1884a;

    public DrawableWrapper(Drawable drawable) {
        setWrappedDrawable(drawable);
    }

    public void draw(Canvas canvas) {
        this.f1884a.draw(canvas);
    }

    public int getChangingConfigurations() {
        return this.f1884a.getChangingConfigurations();
    }

    public Drawable getCurrent() {
        return this.f1884a.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.f1884a.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.f1884a.getIntrinsicWidth();
    }

    public int getMinimumHeight() {
        return this.f1884a.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.f1884a.getMinimumWidth();
    }

    public int getOpacity() {
        return this.f1884a.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.f1884a.getPadding(rect);
    }

    public int[] getState() {
        return this.f1884a.getState();
    }

    public Region getTransparentRegion() {
        return this.f1884a.getTransparentRegion();
    }

    public Drawable getWrappedDrawable() {
        return this.f1884a;
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public boolean isAutoMirrored() {
        return DrawableCompat.isAutoMirrored(this.f1884a);
    }

    public boolean isStateful() {
        return this.f1884a.isStateful();
    }

    public void jumpToCurrentState() {
        DrawableCompat.jumpToCurrentState(this.f1884a);
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.f1884a.setBounds(rect);
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i) {
        return this.f1884a.setLevel(i);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    public void setAlpha(int i) {
        this.f1884a.setAlpha(i);
    }

    public void setAutoMirrored(boolean z) {
        DrawableCompat.setAutoMirrored(this.f1884a, z);
    }

    public void setChangingConfigurations(int i) {
        this.f1884a.setChangingConfigurations(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f1884a.setColorFilter(colorFilter);
    }

    public void setDither(boolean z) {
        this.f1884a.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.f1884a.setFilterBitmap(z);
    }

    public void setHotspot(float f, float f2) {
        DrawableCompat.setHotspot(this.f1884a, f, f2);
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        DrawableCompat.setHotspotBounds(this.f1884a, i, i2, i3, i4);
    }

    public boolean setState(int[] iArr) {
        return this.f1884a.setState(iArr);
    }

    public void setTint(int i) {
        DrawableCompat.setTint(this.f1884a, i);
    }

    public void setTintList(ColorStateList colorStateList) {
        DrawableCompat.setTintList(this.f1884a, colorStateList);
    }

    public void setTintMode(PorterDuff.Mode mode) {
        DrawableCompat.setTintMode(this.f1884a, mode);
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f1884a.setVisible(z, z2);
    }

    public void setWrappedDrawable(Drawable drawable) {
        if (this.f1884a != null) {
            this.f1884a.setCallback((Drawable.Callback) null);
        }
        this.f1884a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
