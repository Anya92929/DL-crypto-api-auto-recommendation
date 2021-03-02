package com.google.android.gms.tagmanager;

import java.util.Arrays;

/* renamed from: com.google.android.gms.tagmanager.bp */
class C1310bp {

    /* renamed from: a */
    final String f5393a;

    /* renamed from: b */
    final byte[] f5394b;

    C1310bp(String str, byte[] bArr) {
        this.f5393a = str;
        this.f5394b = bArr;
    }

    public String toString() {
        return "KeyAndSerialized: key = " + this.f5393a + " serialized hash = " + Arrays.hashCode(this.f5394b);
    }
}
