package android.support.p000v4.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;

/* renamed from: android.support.v4.content.res.ResourcesCompatApi23 */
class ResourcesCompatApi23 {
    ResourcesCompatApi23() {
    }

    public static int getColor(Resources res, int id, Resources.Theme theme) throws Resources.NotFoundException {
        return res.getColor(id, theme);
    }

    public static ColorStateList getColorStateList(Resources res, int id, Resources.Theme theme) throws Resources.NotFoundException {
        return res.getColorStateList(id, theme);
    }
}
