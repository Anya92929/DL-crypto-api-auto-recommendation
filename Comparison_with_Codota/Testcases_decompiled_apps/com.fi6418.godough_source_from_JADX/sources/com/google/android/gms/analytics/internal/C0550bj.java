package com.google.android.gms.analytics.internal;

import android.os.Build;
import java.io.File;

/* renamed from: com.google.android.gms.analytics.internal.bj */
public class C0550bj {
    /* renamed from: a */
    public static int m3206a() {
        try {
            return Integer.parseInt(Build.VERSION.SDK);
        } catch (NumberFormatException e) {
            C0561i.m3260a("Invalid version number", Build.VERSION.SDK);
            return 0;
        }
    }

    /* renamed from: a */
    public static boolean m3207a(String str) {
        if (m3206a() < 9) {
            return false;
        }
        File file = new File(str);
        file.setReadable(false, false);
        file.setWritable(false, false);
        file.setReadable(true, true);
        file.setWritable(true, true);
        return true;
    }
}
