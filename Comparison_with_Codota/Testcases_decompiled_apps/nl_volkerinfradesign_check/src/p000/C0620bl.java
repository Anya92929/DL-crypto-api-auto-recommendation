package p000;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.Rect;
import android.support.p001v4.graphics.drawable.RoundedBitmapDrawable;
import android.view.Gravity;

/* renamed from: bl */
public class C0620bl extends RoundedBitmapDrawable {
    public C0620bl(Resources resources, Bitmap bitmap) {
        super(resources, bitmap);
    }

    public void getOutline(Outline outline) {
        mo883a();
        outline.setRoundRect(this.f492b, getCornerRadius());
    }

    public void setMipMap(boolean z) {
        if (this.f491a != null) {
            this.f491a.setHasMipMap(z);
            invalidateSelf();
        }
    }

    public boolean hasMipMap() {
        return this.f491a != null && this.f491a.hasMipMap();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo884a(int i, int i2, int i3, Rect rect, Rect rect2) {
        Gravity.apply(i, i2, i3, rect, rect2, 0);
    }
}
