package android.support.p000v4.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* renamed from: android.support.v4.graphics.drawable.DrawableWrapperLollipop */
class DrawableWrapperLollipop extends DrawableWrapperKitKat {
    DrawableWrapperLollipop(Drawable drawable) {
        super(drawable);
    }

    public void applyTheme(Resources.Theme theme) {
        this.f789b.applyTheme(theme);
    }

    public boolean canApplyTheme() {
        return this.f789b.canApplyTheme();
    }

    public Rect getDirtyBounds() {
        return this.f789b.getDirtyBounds();
    }

    public void getOutline(Outline outline) {
        this.f789b.getOutline(outline);
    }

    public void setHotspot(float f, float f2) {
        this.f789b.setHotspot(f, f2);
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        this.f789b.setHotspotBounds(i, i2, i3, i4);
    }
}
