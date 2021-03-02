package com.google.android.gms.analytics;

import android.os.Build;
import java.io.File;

/* renamed from: com.google.android.gms.analytics.o */
class C0181o {
    /* renamed from: ag */
    static boolean m210ag(String str) {
        if (version() < 9) {
            return false;
        }
        File file = new File(str);
        file.setReadable(false, false);
        file.setWritable(false, false);
        file.setReadable(true, true);
        file.setWritable(true, true);
        return true;
    }

    public static int version() {
        try {
            return Integer.parseInt(Build.VERSION.SDK);
        } catch (NumberFormatException e) {
            C0207z.m306T("Invalid version number: " + Build.VERSION.SDK);
            return 0;
        }
    }
}
