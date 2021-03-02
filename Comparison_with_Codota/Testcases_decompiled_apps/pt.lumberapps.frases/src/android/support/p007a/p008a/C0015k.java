package android.support.p007a.p008a;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.support.p009v4.p012b.p013a.C0095a;
import android.util.AttributeSet;

@TargetApi(21)
/* renamed from: android.support.a.a.k */
abstract class C0015k extends Drawable {

    /* renamed from: a */
    Drawable f76a;

    C0015k() {
    }

    /* renamed from: b */
    static TypedArray m72b(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public void applyTheme(Resources.Theme theme) {
        if (this.f76a != null) {
            C0095a.m199a(this.f76a, theme);
        }
    }

    public void clearColorFilter() {
        if (this.f76a != null) {
            this.f76a.clearColorFilter();
        } else {
            super.clearColorFilter();
        }
    }

    public ColorFilter getColorFilter() {
        if (this.f76a != null) {
            return C0095a.m207e(this.f76a);
        }
        return null;
    }

    public Drawable getCurrent() {
        return this.f76a != null ? this.f76a.getCurrent() : super.getCurrent();
    }

    public int getLayoutDirection() {
        if (this.f76a == null) {
            return 0;
        }
        C0095a.m209g(this.f76a);
        return 0;
    }

    public int getMinimumHeight() {
        return this.f76a != null ? this.f76a.getMinimumHeight() : super.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.f76a != null ? this.f76a.getMinimumWidth() : super.getMinimumWidth();
    }

    public boolean getPadding(Rect rect) {
        return this.f76a != null ? this.f76a.getPadding(rect) : super.getPadding(rect);
    }

    public int[] getState() {
        return this.f76a != null ? this.f76a.getState() : super.getState();
    }

    public Region getTransparentRegion() {
        return this.f76a != null ? this.f76a.getTransparentRegion() : super.getTransparentRegion();
    }

    public boolean isAutoMirrored() {
        if (this.f76a == null) {
            return false;
        }
        C0095a.m204b(this.f76a);
        return false;
    }

    public void jumpToCurrentState() {
        if (this.f76a != null) {
            C0095a.m194a(this.f76a);
        }
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        if (this.f76a != null) {
            this.f76a.setBounds(rect);
        } else {
            super.onBoundsChange(rect);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i) {
        return this.f76a != null ? this.f76a.setLevel(i) : super.onLevelChange(i);
    }

    public void setAutoMirrored(boolean z) {
        if (this.f76a != null) {
            C0095a.m202a(this.f76a, z);
        }
    }

    public void setChangingConfigurations(int i) {
        if (this.f76a != null) {
            this.f76a.setChangingConfigurations(i);
        } else {
            super.setChangingConfigurations(i);
        }
    }

    public void setColorFilter(int i, PorterDuff.Mode mode) {
        if (this.f76a != null) {
            this.f76a.setColorFilter(i, mode);
        } else {
            super.setColorFilter(i, mode);
        }
    }

    public void setFilterBitmap(boolean z) {
        if (this.f76a != null) {
            this.f76a.setFilterBitmap(z);
        }
    }

    public void setHotspot(float f, float f2) {
        if (this.f76a != null) {
            C0095a.m195a(this.f76a, f, f2);
        }
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        if (this.f76a != null) {
            C0095a.m197a(this.f76a, i, i2, i3, i4);
        }
    }

    public boolean setState(int[] iArr) {
        return this.f76a != null ? this.f76a.setState(iArr) : super.setState(iArr);
    }
}
