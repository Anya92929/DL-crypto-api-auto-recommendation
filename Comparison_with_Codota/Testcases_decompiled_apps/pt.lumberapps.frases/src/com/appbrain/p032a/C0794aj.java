package com.appbrain.p032a;

import android.util.SparseArray;
import cmn.C0725at;
import com.appbrain.C0982ac;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.appbrain.a.aj */
public class C0794aj {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f2086a = C0794aj.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final SparseArray f2087b = new SparseArray();

    /* renamed from: c */
    private static final AtomicInteger f2088c = new AtomicInteger();

    /* renamed from: a */
    public static int m3602a(C0982ac acVar) {
        if (acVar == null) {
            return -1;
        }
        int i = -1;
        while (i == -1) {
            i = f2088c.incrementAndGet();
        }
        C0725at.m3234b((Runnable) new C0796al(i, acVar));
        return i;
    }

    /* renamed from: a */
    public static void m3604a(int i, C0799ao aoVar) {
        if (i != -1) {
            C0725at.m3234b((Runnable) new C0795ak(aoVar, i));
        }
    }
}
