package android.support.p009v4.p012b.p013a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;

/* renamed from: android.support.v4.b.a.aa */
class C0096aa extends C0121y {
    C0096aa(Drawable drawable) {
        super(drawable);
    }

    C0096aa(C0115s sVar, Resources resources) {
        super(sVar, resources);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C0115s mo952b() {
        return new C0097ab(this.f173b, (Resources) null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public boolean mo953c() {
        if (Build.VERSION.SDK_INT != 21) {
            return false;
        }
        Drawable drawable = this.f174c;
        return (drawable instanceof GradientDrawable) || (drawable instanceof DrawableContainer) || (drawable instanceof InsetDrawable);
    }

    public Rect getDirtyBounds() {
        return this.f174c.getDirtyBounds();
    }

    public void getOutline(Outline outline) {
        this.f174c.getOutline(outline);
    }

    public void setHotspot(float f, float f2) {
        this.f174c.setHotspot(f, f2);
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        this.f174c.setHotspotBounds(i, i2, i3, i4);
    }

    public boolean setState(int[] iArr) {
        if (!super.setState(iArr)) {
            return false;
        }
        invalidateSelf();
        return true;
    }

    public void setTint(int i) {
        if (mo953c()) {
            mo980a(i);
        } else {
            this.f174c.setTint(i);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        if (mo953c()) {
            mo981a(colorStateList);
        } else {
            this.f174c.setTintList(colorStateList);
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        if (mo953c()) {
            mo982a(mode);
        } else {
            this.f174c.setTintMode(mode);
        }
    }
}
