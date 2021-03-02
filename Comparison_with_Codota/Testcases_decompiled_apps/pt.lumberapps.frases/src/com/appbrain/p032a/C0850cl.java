package com.appbrain.p032a;

import android.app.ActivityManager;
import android.content.Context;
import android.os.SystemClock;
import cmn.C0719an;
import cmn.C0752n;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* renamed from: com.appbrain.a.cl */
public class C0850cl {

    /* renamed from: a */
    static long f2253a = 0;

    /* renamed from: b */
    static long f2254b = 0;

    /* renamed from: c */
    private static final String f2255c = C0850cl.class.getSimpleName();

    private C0850cl() {
    }

    /* renamed from: a */
    private static int m3743a(int i) {
        try {
            return Math.max(0, 1440 - ((int) ((SystemClock.elapsedRealtime() / 60000) - (Long.parseLong(m3744a(m3748b("/proc/" + i + "/stat"))) / 6000))));
        } catch (Exception e) {
            return 0;
        }
    }

    /* renamed from: a */
    private static String m3744a(String str) {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 <= 21) {
            i = i3;
            while (!Character.isSpaceChar(str.charAt(i))) {
                i++;
            }
            int i5 = i;
            while (Character.isSpaceChar(str.charAt(i5))) {
                i5++;
            }
            i2++;
            int i6 = i5;
            i4 = i3;
            i3 = i6;
        }
        return str.substring(i4, i);
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.List m3745a() {
        /*
            r2 = 0
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.ProcessBuilder r1 = new java.lang.ProcessBuilder     // Catch:{ Throwable -> 0x00bb }
            r3 = 0
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ Throwable -> 0x00bb }
            r1.<init>(r3)     // Catch:{ Throwable -> 0x00bb }
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ Throwable -> 0x00bb }
            r4 = 0
            java.lang.String r5 = "ps"
            r3[r4] = r5     // Catch:{ Throwable -> 0x00bb }
            java.lang.ProcessBuilder r1 = r1.command(r3)     // Catch:{ Throwable -> 0x00bb }
            r3 = 1
            java.lang.ProcessBuilder r1 = r1.redirectErrorStream(r3)     // Catch:{ Throwable -> 0x00bb }
            java.lang.Process r4 = r1.start()     // Catch:{ Throwable -> 0x00bb }
            java.io.InputStream r1 = r4.getInputStream()     // Catch:{ all -> 0x00b6 }
            r4.getOutputStream()     // Catch:{ all -> 0x00b6 }
            java.lang.String r3 = new java.lang.String     // Catch:{ all -> 0x00b6 }
            byte[] r1 = cmn.C0719an.m3212a((java.io.InputStream) r1)     // Catch:{ all -> 0x00b6 }
            r3.<init>(r1)     // Catch:{ all -> 0x00b6 }
            java.lang.String r1 = "\n"
            java.lang.String[] r5 = r3.split(r1)     // Catch:{ all -> 0x00b6 }
            int r6 = r5.length     // Catch:{ all -> 0x00b6 }
            r3 = r2
        L_0x003b:
            if (r3 >= r6) goto L_0x00b2
            r7 = r5[r3]     // Catch:{ all -> 0x00b6 }
            java.lang.String r1 = "USER"
            boolean r1 = r7.startsWith(r1)     // Catch:{ all -> 0x00b6 }
            if (r1 != 0) goto L_0x00ae
            java.lang.String r1 = "root"
            boolean r1 = r7.startsWith(r1)     // Catch:{ all -> 0x00b6 }
            if (r1 != 0) goto L_0x00ae
            r1 = r2
        L_0x0050:
            int r8 = r1 + 1
            int r9 = r7.length()     // Catch:{ all -> 0x00b6 }
            if (r8 >= r9) goto L_0x0065
            char r8 = r7.charAt(r1)     // Catch:{ all -> 0x00b6 }
            boolean r8 = java.lang.Character.isSpaceChar(r8)     // Catch:{ all -> 0x00b6 }
            if (r8 != 0) goto L_0x0065
            int r1 = r1 + 1
            goto L_0x0050
        L_0x0065:
            int r8 = r1 + 1
            int r9 = r7.length()     // Catch:{ all -> 0x00b6 }
            if (r8 >= r9) goto L_0x007a
            char r8 = r7.charAt(r1)     // Catch:{ all -> 0x00b6 }
            boolean r8 = java.lang.Character.isSpaceChar(r8)     // Catch:{ all -> 0x00b6 }
            if (r8 == 0) goto L_0x007a
            int r1 = r1 + 1
            goto L_0x0065
        L_0x007a:
            r8 = 32
            int r8 = r7.indexOf(r8, r1)     // Catch:{ all -> 0x00b6 }
            java.lang.String r1 = r7.substring(r1, r8)     // Catch:{ all -> 0x00b6 }
            r8 = 32
            int r8 = r7.lastIndexOf(r8)     // Catch:{ all -> 0x00b6 }
            int r8 = r8 + 1
            java.lang.String r7 = r7.substring(r8)     // Catch:{ all -> 0x00b6 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b6 }
            r8.<init>()     // Catch:{ all -> 0x00b6 }
            java.lang.StringBuilder r8 = r8.append(r1)     // Catch:{ all -> 0x00b6 }
            java.lang.String r9 = " "
            java.lang.StringBuilder r8 = r8.append(r9)     // Catch:{ all -> 0x00b6 }
            r8.append(r7)     // Catch:{ all -> 0x00b6 }
            com.appbrain.a.cm r8 = new com.appbrain.a.cm     // Catch:{ all -> 0x00b6 }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ all -> 0x00b6 }
            r8.<init>(r1, r7)     // Catch:{ all -> 0x00b6 }
            r0.add(r8)     // Catch:{ all -> 0x00b6 }
        L_0x00ae:
            int r1 = r3 + 1
            r3 = r1
            goto L_0x003b
        L_0x00b2:
            r4.destroy()     // Catch:{ Throwable -> 0x00bb }
        L_0x00b5:
            return r0
        L_0x00b6:
            r0 = move-exception
            r4.destroy()     // Catch:{ Throwable -> 0x00bb }
            throw r0     // Catch:{ Throwable -> 0x00bb }
        L_0x00bb:
            r0 = move-exception
            java.lang.String r1 = f2255c
            java.lang.String r0 = r0.getMessage()
            android.util.Log.e(r1, r0)
            java.util.List r0 = java.util.Collections.emptyList()
            goto L_0x00b5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appbrain.p032a.C0850cl.m3745a():java.util.List");
    }

    /* renamed from: a */
    private static List m3746a(Context context) {
        ArrayList arrayList = new ArrayList();
        for (ActivityManager.RunningAppProcessInfo next : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
            for (String cnVar : next.pkgList) {
                arrayList.add(new C0852cn(cnVar, next.importance));
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static List m3747a(Context context, Set set) {
        boolean z = true;
        C0752n.m3278b();
        int a = C0932fm.m3968a().mo3840a("procrd", -1);
        if (a == -1) {
            z = false;
        } else if (a != 1) {
            z = false;
        }
        if (!z) {
            return m3746a(context);
        }
        List<C0851cm> a2 = m3745a();
        ArrayList arrayList = new ArrayList();
        for (C0851cm cmVar : a2) {
            if (set.contains(cmVar.f2257b)) {
                arrayList.add(new C0852cn(cmVar.f2257b, m3743a(cmVar.f2256a)));
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    /* renamed from: b */
    private static String m3748b(String str) {
        BufferedInputStream bufferedInputStream;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
            try {
                String trim = new String(C0719an.m3212a((InputStream) bufferedInputStream)).trim();
                C0719an.m3210a((Closeable) bufferedInputStream);
                return trim;
            } catch (Throwable th) {
                th = th;
                C0719an.m3210a((Closeable) bufferedInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream = null;
            C0719an.m3210a((Closeable) bufferedInputStream);
            throw th;
        }
    }
}
