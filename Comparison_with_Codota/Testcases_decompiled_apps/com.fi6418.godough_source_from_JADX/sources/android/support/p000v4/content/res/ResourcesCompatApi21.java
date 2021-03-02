package android.support.p000v4.content.res;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

/* renamed from: android.support.v4.content.res.ResourcesCompatApi21 */
class ResourcesCompatApi21 {
    ResourcesCompatApi21() {
    }

    public static Drawable getDrawable(Resources resources, int i, Resources.Theme theme) {
        return resources.getDrawable(i, theme);
    }

    public static Drawable getDrawableForDensity(Resources resources, int i, int i2, Resources.Theme theme) {
        return resources.getDrawableForDensity(i, i2, theme);
    }
}
