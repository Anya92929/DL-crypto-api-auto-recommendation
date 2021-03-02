package com.google.android.gms.internal;

import android.util.Base64;

/* renamed from: com.google.android.gms.internal.a */
class C0197a implements C0601j {
    C0197a() {
    }

    /* renamed from: a */
    public String mo4005a(byte[] bArr, boolean z) {
        return Base64.encodeToString(bArr, z ? 11 : 2);
    }

    /* renamed from: a */
    public byte[] mo4006a(String str, boolean z) throws IllegalArgumentException {
        return Base64.decode(str, z ? 11 : 2);
    }
}
