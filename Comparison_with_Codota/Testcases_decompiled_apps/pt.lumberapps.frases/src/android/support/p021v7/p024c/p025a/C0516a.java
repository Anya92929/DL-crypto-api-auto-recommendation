package android.support.p021v7.p024c.p025a;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.support.p009v4.p012b.p013a.C0095a;

/* renamed from: android.support.v7.c.a.a */
public class C0516a extends Drawable implements Drawable.Callback {

    /* renamed from: a */
    private Drawable f878a;

    public C0516a(Drawable drawable) {
        mo2140a(drawable);
    }

    /* renamed from: a */
    public Drawable mo2139a() {
        return this.f878a;
    }

    /* renamed from: a */
    public void mo2140a(Drawable drawable) {
        if (this.f878a != null) {
            this.f878a.setCallback((Drawable.Callback) null);
        }
        this.f878a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    public void draw(Canvas canvas) {
        this.f878a.draw(canvas);
    }

    public int getChangingConfigurations() {
        return this.f878a.getChangingConfigurations();
    }

    public Drawable getCurrent() {
        return this.f878a.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.f878a.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.f878a.getIntrinsicWidth();
    }

    public int getMinimumHeight() {
        return this.f878a.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.f878a.getMinimumWidth();
    }

    public int getOpacity() {
        return this.f878a.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.f878a.getPadding(rect);
    }

    public int[] getState() {
        return this.f878a.getState();
    }

    public Region getTransparentRegion() {
        return this.f878a.getTransparentRegion();
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public boolean isAutoMirrored() {
        return C0095a.m204b(this.f878a);
    }

    public boolean isStateful() {
        return this.f878a.isStateful();
    }

    public void jumpToCurrentState() {
        C0095a.m194a(this.f878a);
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.f878a.setBounds(rect);
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i) {
        return this.f878a.setLevel(i);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    public void setAlpha(int i) {
        this.f878a.setAlpha(i);
    }

    public void setAutoMirrored(boolean z) {
        C0095a.m202a(this.f878a, z);
    }

    public void setChangingConfigurations(int i) {
        this.f878a.setChangingConfigurations(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f878a.setColorFilter(colorFilter);
    }

    public void setDither(boolean z) {
        this.f878a.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.f878a.setFilterBitmap(z);
    }

    public void setHotspot(float f, float f2) {
        C0095a.m195a(this.f878a, f, f2);
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        C0095a.m197a(this.f878a, i, i2, i3, i4);
    }

    public boolean setState(int[] iArr) {
        return this.f878a.setState(iArr);
    }

    public void setTint(int i) {
        C0095a.m196a(this.f878a, i);
    }

    public void setTintList(ColorStateList colorStateList) {
        C0095a.m198a(this.f878a, colorStateList);
    }

    public void setTintMode(PorterDuff.Mode mode) {
        C0095a.m201a(this.f878a, mode);
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f878a.setVisible(z, z2);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
