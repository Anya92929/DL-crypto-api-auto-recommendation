package com.appbrain.p037f;

import com.appbrain.p033b.C1014r;

/* renamed from: com.appbrain.f.af */
public enum C1040af {
    DEPRECATED_SELECT(1),
    DEPRECATED_IMPRESS(2),
    CLICK(3),
    INSTALL(4),
    UNINSTALL(5),
    FINAL_CHECK(6),
    INVALID_URL(7);
    

    /* renamed from: h */
    private static C1014r f2807h;

    /* renamed from: i */
    private final int f2809i;

    static {
        f2807h = new C1041ag();
    }

    private C1040af(int i) {
        this.f2809i = i;
    }

    /* renamed from: a */
    public static C1040af m4541a(int i) {
        switch (i) {
            case 1:
                return DEPRECATED_SELECT;
            case 2:
                return DEPRECATED_IMPRESS;
            case 3:
                return CLICK;
            case 4:
                return INSTALL;
            case 5:
                return UNINSTALL;
            case 6:
                return FINAL_CHECK;
            case 7:
                return INVALID_URL;
            default:
                return null;
        }
    }

    /* renamed from: a */
    public final int mo4187a() {
        return this.f2809i;
    }
}
