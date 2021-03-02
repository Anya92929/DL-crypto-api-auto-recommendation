package android.support.p000v4.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.Rect;
import android.view.Gravity;

/* renamed from: android.support.v4.graphics.drawable.RoundedBitmapDrawable21 */
class RoundedBitmapDrawable21 extends RoundedBitmapDrawable {
    protected RoundedBitmapDrawable21(Resources resources, Bitmap bitmap) {
        super(resources, bitmap);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1287a(int i, int i2, int i3, Rect rect, Rect rect2) {
        Gravity.apply(i, i2, i3, rect, rect2, 0);
    }

    public void getOutline(Outline outline) {
        mo1286a();
        outline.setRoundRect(this.f796b, getCornerRadius());
    }

    public boolean hasMipMap() {
        return this.f795a != null && this.f795a.hasMipMap();
    }

    public void setMipMap(boolean z) {
        if (this.f795a != null) {
            this.f795a.setHasMipMap(z);
            invalidateSelf();
        }
    }
}
