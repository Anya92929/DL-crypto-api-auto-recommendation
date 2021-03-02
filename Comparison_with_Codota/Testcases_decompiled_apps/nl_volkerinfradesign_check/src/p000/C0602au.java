package p000;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

/* renamed from: au */
public class C0602au {
    /* renamed from: a */
    public static Drawable m3404a(Resources resources, int i, Resources.Theme theme) throws Resources.NotFoundException {
        return resources.getDrawable(i, theme);
    }

    /* renamed from: a */
    public static Drawable m3403a(Resources resources, int i, int i2, Resources.Theme theme) throws Resources.NotFoundException {
        return resources.getDrawableForDensity(i, i2, theme);
    }
}
