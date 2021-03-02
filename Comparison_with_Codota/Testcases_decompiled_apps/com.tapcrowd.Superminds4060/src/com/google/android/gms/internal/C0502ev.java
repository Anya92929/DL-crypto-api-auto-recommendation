package com.google.android.gms.internal;

/* renamed from: com.google.android.gms.internal.ev */
public final class C0502ev {
    /* renamed from: R */
    public static String m1488R(int i) {
        switch (i) {
            case 0:
                return "DAILY";
            case 1:
                return "WEEKLY";
            case 2:
                return "ALL_TIME";
            default:
                throw new IllegalArgumentException("Unknown time span " + i);
        }
    }
}
