package com.appbrain.p039h;

import com.appbrain.p033b.C1014r;

/* renamed from: com.appbrain.h.f */
public enum C1113f {
    INTEGRITY_ONLY(1),
    SHARED_KEY(2);
    

    /* renamed from: c */
    private static C1014r f3129c;

    /* renamed from: d */
    private final int f3131d;

    static {
        f3129c = new C1114g();
    }

    private C1113f(int i) {
        this.f3131d = i;
    }

    /* renamed from: a */
    public static C1113f m5201a(int i) {
        switch (i) {
            case 1:
                return INTEGRITY_ONLY;
            case 2:
                return SHARED_KEY;
            default:
                return null;
        }
    }

    /* renamed from: a */
    public final int mo4427a() {
        return this.f3131d;
    }
}
