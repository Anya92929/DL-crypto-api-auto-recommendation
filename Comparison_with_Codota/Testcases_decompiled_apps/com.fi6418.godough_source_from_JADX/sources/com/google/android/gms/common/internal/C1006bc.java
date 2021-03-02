package com.google.android.gms.common.internal;

import java.util.Arrays;

/* renamed from: com.google.android.gms.common.internal.bc */
public final class C1006bc {
    /* renamed from: a */
    public static int m4523a(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    /* renamed from: a */
    public static C1008be m4524a(Object obj) {
        return new C1008be(obj);
    }

    /* renamed from: a */
    public static boolean m4525a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }
}
