package com.google.android.gms.tagmanager;

import android.os.Build;
import java.io.File;

/* renamed from: com.google.android.gms.tagmanager.ak */
class C1999ak {
    /* renamed from: ag */
    static boolean m6755ag(String str) {
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
            C2028bh.m6816T("Invalid version number: " + Build.VERSION.SDK);
            return 0;
        }
    }
}
