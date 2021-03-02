package com.google.android.gms.internal;

import android.util.Base64;

/* renamed from: com.google.android.gms.internal.ef */
public final class C0436ef {
    /* renamed from: b */
    public static String m1079b(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return Base64.encodeToString(bArr, 0);
    }

    /* renamed from: c */
    public static String m1080c(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return Base64.encodeToString(bArr, 10);
    }
}
