package android.support.p009v4.view;

import android.os.Build;
import android.view.View;
import android.view.ViewParent;

/* renamed from: android.support.v4.view.ed */
public final class C0307ed {

    /* renamed from: a */
    static final C0309ef f382a;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            f382a = new C0311eh();
        } else if (i >= 19) {
            f382a = new C0310eg();
        } else if (i >= 14) {
            f382a = new C0308ee();
        } else {
            f382a = new C0312ei();
        }
    }

    /* renamed from: a */
    public static void m1165a(ViewParent viewParent, View view) {
        f382a.mo1544a(viewParent, view);
    }

    /* renamed from: a */
    public static void m1166a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
        f382a.mo1545a(viewParent, view, i, i2, i3, i4);
    }

    /* renamed from: a */
    public static void m1167a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
        f382a.mo1546a(viewParent, view, i, i2, iArr);
    }

    /* renamed from: a */
    public static boolean m1168a(ViewParent viewParent, View view, float f, float f2) {
        return f382a.mo1547a(viewParent, view, f, f2);
    }

    /* renamed from: a */
    public static boolean m1169a(ViewParent viewParent, View view, float f, float f2, boolean z) {
        return f382a.mo1548a(viewParent, view, f, f2, z);
    }

    /* renamed from: a */
    public static boolean m1170a(ViewParent viewParent, View view, View view2, int i) {
        return f382a.mo1549a(viewParent, view, view2, i);
    }

    /* renamed from: b */
    public static void m1171b(ViewParent viewParent, View view, View view2, int i) {
        f382a.mo1550b(viewParent, view, view2, i);
    }
}
