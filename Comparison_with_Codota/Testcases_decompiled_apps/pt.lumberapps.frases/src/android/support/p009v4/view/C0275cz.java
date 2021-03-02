package android.support.p009v4.view;

import android.os.Build;
import android.view.ViewConfiguration;

/* renamed from: android.support.v4.view.cz */
public final class C0275cz {

    /* renamed from: a */
    static final C0281de f364a;

    static {
        if (Build.VERSION.SDK_INT >= 14) {
            f364a = new C0280dd();
        } else if (Build.VERSION.SDK_INT >= 11) {
            f364a = new C0279dc();
        } else if (Build.VERSION.SDK_INT >= 8) {
            f364a = new C0278db();
        } else {
            f364a = new C0277da();
        }
    }

    /* renamed from: a */
    public static int m1119a(ViewConfiguration viewConfiguration) {
        return f364a.mo1526a(viewConfiguration);
    }

    /* renamed from: b */
    public static boolean m1120b(ViewConfiguration viewConfiguration) {
        return f364a.mo1527b(viewConfiguration);
    }
}
