package android.support.p000v4.content.res;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

/* renamed from: android.support.v4.content.res.ResourcesCompatIcsMr1 */
class ResourcesCompatIcsMr1 {
    ResourcesCompatIcsMr1() {
    }

    public static Drawable getDrawableForDensity(Resources res, int id, int density) throws Resources.NotFoundException {
        return res.getDrawableForDensity(id, density);
    }
}
