package com.google.android.gms.p018c;

import android.content.res.Configuration;
import android.content.res.Resources;

/* renamed from: com.google.android.gms.c.af */
public final class C0617af {
    /* renamed from: a */
    public static boolean m3560a(Resources resources) {
        if (resources == null) {
            return false;
        }
        return (C0618ag.m3562a() && ((resources.getConfiguration().screenLayout & 15) > 3)) || m3561b(resources);
    }

    /* renamed from: b */
    private static boolean m3561b(Resources resources) {
        Configuration configuration = resources.getConfiguration();
        return C0618ag.m3564b() && (configuration.screenLayout & 15) <= 3 && configuration.smallestScreenWidthDp >= 600;
    }
}
