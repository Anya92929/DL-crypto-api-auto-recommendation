package android.support.p009v4.p010a.p011a;

import android.content.res.Resources;
import android.util.DisplayMetrics;

/* renamed from: android.support.v4.a.a.g */
class C0032g {
    /* renamed from: a */
    static int m135a(Resources resources) {
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return (int) (((float) displayMetrics.heightPixels) / displayMetrics.density);
    }

    /* renamed from: b */
    static int m136b(Resources resources) {
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return (int) (((float) displayMetrics.widthPixels) / displayMetrics.density);
    }

    /* renamed from: c */
    static int m137c(Resources resources) {
        return Math.min(m136b(resources), m135a(resources));
    }
}
