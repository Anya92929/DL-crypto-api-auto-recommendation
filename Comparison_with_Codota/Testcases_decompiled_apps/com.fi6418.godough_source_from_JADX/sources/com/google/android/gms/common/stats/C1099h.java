package com.google.android.gms.common.stats;

import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;

/* renamed from: com.google.android.gms.common.stats.h */
public class C1099h {
    /* renamed from: a */
    public static String m4776a(PowerManager.WakeLock wakeLock, String str) {
        StringBuilder append = new StringBuilder().append(String.valueOf((Process.myPid() << 32) | System.identityHashCode(wakeLock)));
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return append.append(str).toString();
    }
}
