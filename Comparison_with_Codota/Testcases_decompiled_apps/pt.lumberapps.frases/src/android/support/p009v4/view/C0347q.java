package android.support.p009v4.view;

import android.os.Build;

/* renamed from: android.support.v4.view.q */
public final class C0347q {

    /* renamed from: a */
    static final C0348r f409a;

    static {
        if (Build.VERSION.SDK_INT >= 17) {
            f409a = new C0350t();
        } else {
            f409a = new C0349s();
        }
    }

    /* renamed from: a */
    public static int m1334a(int i, int i2) {
        return f409a.mo1628a(i, i2);
    }
}
