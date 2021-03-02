package com.google.android.gms.tagmanager;

import android.os.Build;
import java.io.File;

/* renamed from: com.google.android.gms.tagmanager.s */
class C1328s {
    /* renamed from: a */
    public static int m5434a() {
        try {
            return Integer.parseInt(Build.VERSION.SDK);
        } catch (NumberFormatException e) {
            C1333x.m5440a("Invalid version number: " + Build.VERSION.SDK);
            return 0;
        }
    }

    /* renamed from: a */
    static boolean m5435a(String str) {
        if (m5434a() < 9) {
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
