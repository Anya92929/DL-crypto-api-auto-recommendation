package android.support.p000v4.graphics.drawable;

import android.graphics.drawable.Drawable;

/* renamed from: android.support.v4.graphics.drawable.DrawableWrapperKitKat */
class DrawableWrapperKitKat extends DrawableWrapperHoneycomb {
    DrawableWrapperKitKat(Drawable drawable) {
        super(drawable);
    }

    public boolean isAutoMirrored() {
        return this.f789b.isAutoMirrored();
    }

    public void setAutoMirrored(boolean z) {
        this.f789b.setAutoMirrored(z);
    }
}