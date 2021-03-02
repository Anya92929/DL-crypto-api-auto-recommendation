package com.google.android.gms.internal;

import android.util.Base64;

/* renamed from: com.google.android.gms.internal.an */
public final class C0422an {
    /* renamed from: a */
    public static String m903a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return Base64.encodeToString(bArr, 0);
    }

    /* renamed from: b */
    public static String m904b(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return Base64.encodeToString(bArr, 10);
    }
}
