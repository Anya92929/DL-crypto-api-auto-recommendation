package android.support.p009v4.p010a.p011a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;

/* renamed from: android.support.v4.a.a.i */
public final class C0034i {
    /* renamed from: a */
    public static Drawable m141a(Resources resources, int i, Resources.Theme theme) {
        return Build.VERSION.SDK_INT >= 21 ? C0035j.m142a(resources, i, theme) : resources.getDrawable(i);
    }
}
