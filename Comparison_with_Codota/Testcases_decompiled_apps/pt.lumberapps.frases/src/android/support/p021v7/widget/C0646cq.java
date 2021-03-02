package android.support.p021v7.widget;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.p021v7.p024c.p025a.C0516a;

/* renamed from: android.support.v7.widget.cq */
class C0646cq extends C0516a {

    /* renamed from: a */
    private boolean f1573a = true;

    public C0646cq(Drawable drawable) {
        super(drawable);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3216a(boolean z) {
        this.f1573a = z;
    }

    public void draw(Canvas canvas) {
        if (this.f1573a) {
            super.draw(canvas);
        }
    }

    public void setHotspot(float f, float f2) {
        if (this.f1573a) {
            super.setHotspot(f, f2);
        }
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        if (this.f1573a) {
            super.setHotspotBounds(i, i2, i3, i4);
        }
    }

    public boolean setState(int[] iArr) {
        if (this.f1573a) {
            return super.setState(iArr);
        }
        return false;
    }

    public boolean setVisible(boolean z, boolean z2) {
        if (this.f1573a) {
            return super.setVisible(z, z2);
        }
        return false;
    }
}
