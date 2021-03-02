package com.google.android.gms.internal;

import android.os.Build;

/* renamed from: com.google.android.gms.internal.as */
public final class C0427as {
    /* renamed from: an */
    public static boolean m909an() {
        return m915x(11);
    }

    /* renamed from: ao */
    public static boolean m910ao() {
        return m915x(12);
    }

    /* renamed from: ap */
    public static boolean m911ap() {
        return m915x(13);
    }

    /* renamed from: aq */
    public static boolean m912aq() {
        return m915x(14);
    }

    /* renamed from: ar */
    public static boolean m913ar() {
        return m915x(16);
    }

    /* renamed from: as */
    public static boolean m914as() {
        return m915x(17);
    }

    /* renamed from: x */
    private static boolean m915x(int i) {
        return Build.VERSION.SDK_INT >= i;
    }
}
