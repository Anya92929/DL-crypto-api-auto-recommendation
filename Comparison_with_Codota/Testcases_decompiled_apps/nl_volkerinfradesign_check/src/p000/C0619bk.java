package p000;

import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* renamed from: bk */
class C0619bk extends C0618bj {
    C0619bk(Drawable drawable) {
        super(drawable);
    }

    public void setHotspot(float f, float f2) {
        this.f2403b.setHotspot(f, f2);
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        this.f2403b.setHotspotBounds(i, i2, i3, i4);
    }

    public void getOutline(Outline outline) {
        this.f2403b.getOutline(outline);
    }

    public void applyTheme(Resources.Theme theme) {
        this.f2403b.applyTheme(theme);
    }

    public boolean canApplyTheme() {
        return this.f2403b.canApplyTheme();
    }

    public Rect getDirtyBounds() {
        return this.f2403b.getDirtyBounds();
    }
}
