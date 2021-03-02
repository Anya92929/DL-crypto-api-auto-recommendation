package com.google.android.gms.p018c;

import android.content.Context;
import java.util.regex.Pattern;

/* renamed from: com.google.android.gms.c.ab */
public final class C0613ab {

    /* renamed from: a */
    private static Pattern f4217a = null;

    /* renamed from: a */
    public static int m3549a(int i) {
        return i / 1000;
    }

    /* renamed from: a */
    public static boolean m3550a(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.type.watch");
    }

    /* renamed from: b */
    public static int m3551b(int i) {
        return (i % 1000) / 100;
    }

    /* renamed from: c */
    public static boolean m3552c(int i) {
        return m3551b(i) == 3;
    }
}
