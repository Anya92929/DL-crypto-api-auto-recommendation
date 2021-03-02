package android.support.p004v7.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.support.p001v4.graphics.drawable.DrawableCompat;

/* renamed from: android.support.v7.graphics.drawable.DrawableWrapper */
public class DrawableWrapper extends Drawable implements Drawable.Callback {

    /* renamed from: a */
    private Drawable f1614a;

    public DrawableWrapper(Drawable drawable) {
        setWrappedDrawable(drawable);
    }

    public void draw(Canvas canvas) {
        this.f1614a.draw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.f1614a.setBounds(rect);
    }

    public void setChangingConfigurations(int i) {
        this.f1614a.setChangingConfigurations(i);
    }

    public int getChangingConfigurations() {
        return this.f1614a.getChangingConfigurations();
    }

    public void setDither(boolean z) {
        this.f1614a.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.f1614a.setFilterBitmap(z);
    }

    public void setAlpha(int i) {
        this.f1614a.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f1614a.setColorFilter(colorFilter);
    }

    public boolean isStateful() {
        return this.f1614a.isStateful();
    }

    public boolean setState(int[] iArr) {
        return this.f1614a.setState(iArr);
    }

    public int[] getState() {
        return this.f1614a.getState();
    }

    public void jumpToCurrentState() {
        DrawableCompat.jumpToCurrentState(this.f1614a);
    }

    public Drawable getCurrent() {
        return this.f1614a.getCurrent();
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f1614a.setVisible(z, z2);
    }

    public int getOpacity() {
        return this.f1614a.getOpacity();
    }

    public Region getTransparentRegion() {
        return this.f1614a.getTransparentRegion();
    }

    public int getIntrinsicWidth() {
        return this.f1614a.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        return this.f1614a.getIntrinsicHeight();
    }

    public int getMinimumWidth() {
        return this.f1614a.getMinimumWidth();
    }

    public int getMinimumHeight() {
        return this.f1614a.getMinimumHeight();
    }

    public boolean getPadding(Rect rect) {
        return this.f1614a.getPadding(rect);
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
        return this.f1614a.setLevel(i);
    }

    public void setAutoMirrored(boolean z) {
        DrawableCompat.setAutoMirrored(this.f1614a, z);
    }

    public boolean isAutoMirrored() {
        return DrawableCompat.isAutoMirrored(this.f1614a);
    }

    public void setTint(int i) {
        DrawableCompat.setTint(this.f1614a, i);
    }

    public void setTintList(ColorStateList colorStateList) {
        DrawableCompat.setTintList(this.f1614a, colorStateList);
    }

    public void setTintMode(PorterDuff.Mode mode) {
        DrawableCompat.setTintMode(this.f1614a, mode);
    }

    public void setHotspot(float f, float f2) {
        DrawableCompat.setHotspot(this.f1614a, f, f2);
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        DrawableCompat.setHotspotBounds(this.f1614a, i, i2, i3, i4);
    }

    public Drawable getWrappedDrawable() {
        return this.f1614a;
    }

    public void setWrappedDrawable(Drawable drawable) {
        if (this.f1614a != null) {
            this.f1614a.setCallback((Drawable.Callback) null);
        }
        this.f1614a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }
}
