package com.google.android.gms.common;

import com.google.android.gms.common.internal.C1009bf;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.common.k */
abstract class C1078k {

    /* renamed from: a */
    private int f4806a;

    protected C1078k(byte[] bArr) {
        C1009bf.m4537b(bArr.length == 25, "cert hash data has incorrect length");
        this.f4806a = Arrays.hashCode(bArr);
    }

    /* renamed from: a */
    protected static byte[] m4722a(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract byte[] mo7461a();

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof C1078k)) {
            return false;
        }
        return Arrays.equals(mo7461a(), ((C1078k) obj).mo7461a());
    }

    public int hashCode() {
        return this.f4806a;
    }
}
