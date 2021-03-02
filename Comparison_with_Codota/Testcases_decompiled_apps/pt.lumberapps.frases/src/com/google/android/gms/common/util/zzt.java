package com.google.android.gms.common.util;

import android.os.Binder;
import android.os.Process;

public class zzt {

    /* renamed from: a */
    private static String f4739a = null;

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0060 A[SYNTHETIC, Splitter:B:24:0x0060] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m6203a(int r5) {
        /*
            r0 = 0
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ IOException -> 0x003f, all -> 0x005b }
            java.io.FileReader r1 = new java.io.FileReader     // Catch:{ IOException -> 0x003f, all -> 0x005b }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x003f, all -> 0x005b }
            r4 = 25
            r3.<init>(r4)     // Catch:{ IOException -> 0x003f, all -> 0x005b }
            java.lang.String r4 = "/proc/"
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ IOException -> 0x003f, all -> 0x005b }
            java.lang.StringBuilder r3 = r3.append(r5)     // Catch:{ IOException -> 0x003f, all -> 0x005b }
            java.lang.String r4 = "/cmdline"
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ IOException -> 0x003f, all -> 0x005b }
            java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x003f, all -> 0x005b }
            r1.<init>(r3)     // Catch:{ IOException -> 0x003f, all -> 0x005b }
            r2.<init>(r1)     // Catch:{ IOException -> 0x003f, all -> 0x005b }
            java.lang.String r1 = r2.readLine()     // Catch:{ IOException -> 0x0071 }
            java.lang.String r0 = r1.trim()     // Catch:{ IOException -> 0x0071 }
            if (r2 == 0) goto L_0x0033
            r2.close()     // Catch:{ Exception -> 0x0034 }
        L_0x0033:
            return r0
        L_0x0034:
            r1 = move-exception
            java.lang.String r2 = "ProcessUtils"
            java.lang.String r3 = r1.getMessage()
            android.util.Log.w(r2, r3, r1)
            goto L_0x0033
        L_0x003f:
            r1 = move-exception
            r2 = r0
        L_0x0041:
            java.lang.String r3 = "ProcessUtils"
            java.lang.String r4 = r1.getMessage()     // Catch:{ all -> 0x006f }
            android.util.Log.e(r3, r4, r1)     // Catch:{ all -> 0x006f }
            if (r2 == 0) goto L_0x0033
            r2.close()     // Catch:{ Exception -> 0x0050 }
            goto L_0x0033
        L_0x0050:
            r1 = move-exception
            java.lang.String r2 = "ProcessUtils"
            java.lang.String r3 = r1.getMessage()
            android.util.Log.w(r2, r3, r1)
            goto L_0x0033
        L_0x005b:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L_0x005e:
            if (r2 == 0) goto L_0x0063
            r2.close()     // Catch:{ Exception -> 0x0064 }
        L_0x0063:
            throw r0
        L_0x0064:
            r1 = move-exception
            java.lang.String r2 = "ProcessUtils"
            java.lang.String r3 = r1.getMessage()
            android.util.Log.w(r2, r3, r1)
            goto L_0x0063
        L_0x006f:
            r0 = move-exception
            goto L_0x005e
        L_0x0071:
            r1 = move-exception
            goto L_0x0041
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.zzt.m6203a(int):java.lang.String");
    }

    public static String zzavz() {
        return m6203a(Binder.getCallingPid());
    }

    public static String zzawa() {
        if (f4739a == null) {
            f4739a = m6203a(Process.myPid());
        }
        return f4739a;
    }
}
