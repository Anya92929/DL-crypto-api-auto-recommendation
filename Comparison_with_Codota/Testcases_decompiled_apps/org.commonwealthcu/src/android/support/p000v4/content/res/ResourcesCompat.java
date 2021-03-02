package android.support.p000v4.content.res;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;

/* renamed from: android.support.v4.content.res.ResourcesCompat */
public class ResourcesCompat {
    public static Drawable getDrawable(Resources resources, int i, Resources.Theme theme) {
        return Build.VERSION.SDK_INT >= 21 ? ResourcesCompatApi21.getDrawable(resources, i, theme) : resources.getDrawable(i);
    }

    public static Drawable getDrawableForDensity(Resources resources, int i, int i2, Resources.Theme theme) {
        int i3 = Build.VERSION.SDK_INT;
        return i3 >= 21 ? ResourcesCompatApi21.getDrawableForDensity(resources, i, i2, theme) : i3 >= 15 ? ResourcesCompatIcsMr1.getDrawableForDensity(resources, i, i2) : resources.getDrawable(i);
    }
}
