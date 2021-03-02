package com.google.android.gms.internal;

import android.content.Context;
import java.util.regex.Pattern;

/* renamed from: com.google.android.gms.internal.jt */
public final class C1384jt {

    /* renamed from: MJ */
    private static Pattern f4135MJ = null;

    /* renamed from: K */
    public static boolean m5212K(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.type.watch");
    }

    /* renamed from: aN */
    public static int m5213aN(int i) {
        return i / 1000;
    }

    /* renamed from: aO */
    public static int m5214aO(int i) {
        return (i % 1000) / 100;
    }

    /* renamed from: aP */
    public static boolean m5215aP(int i) {
        return m5214aO(i) == 3;
    }
}
