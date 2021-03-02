package com.appbrain.p037f;

import com.appbrain.p033b.C1014r;

/* renamed from: com.appbrain.f.ax */
public enum C1058ax {
    DIALOG(0),
    SLIDER(1),
    INTERSTITIAL_DEPRECATED(2),
    NOTIFICATION(3),
    WEB_VIEW(4);
    

    /* renamed from: f */
    private static C1014r f2916f;

    /* renamed from: g */
    private final int f2918g;

    static {
        f2916f = new C1059ay();
    }

    private C1058ax(int i) {
        this.f2918g = i;
    }

    /* renamed from: a */
    public static C1058ax m4732a(int i) {
        switch (i) {
            case 0:
                return DIALOG;
            case 1:
                return SLIDER;
            case 2:
                return INTERSTITIAL_DEPRECATED;
            case 3:
                return NOTIFICATION;
            case 4:
                return WEB_VIEW;
            default:
                return null;
        }
    }

    /* renamed from: a */
    public final int mo4257a() {
        return this.f2918g;
    }
}
