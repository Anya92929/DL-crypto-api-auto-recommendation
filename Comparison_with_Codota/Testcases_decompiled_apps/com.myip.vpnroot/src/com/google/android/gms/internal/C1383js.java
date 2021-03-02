package com.google.android.gms.internal;

import android.util.Base64;

/* renamed from: com.google.android.gms.internal.js */
public final class C1383js {
    /* renamed from: d */
    public static String m5210d(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return Base64.encodeToString(bArr, 0);
    }

    /* renamed from: e */
    public static String m5211e(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return Base64.encodeToString(bArr, 10);
    }
}
