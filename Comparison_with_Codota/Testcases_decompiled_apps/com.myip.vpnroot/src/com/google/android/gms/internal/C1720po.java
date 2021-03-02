package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.po */
final class C1720po {
    final byte[] awK;
    final int tag;

    C1720po(int i, byte[] bArr) {
        this.tag = i;
        this.awK = bArr;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10108a(C1710pf pfVar) throws IOException {
        pfVar.mo10071gz(this.tag);
        pfVar.mo10077t(this.awK);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo10109c() {
        return 0 + C1710pf.m6011gA(this.tag) + this.awK.length;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof C1720po)) {
            return false;
        }
        C1720po poVar = (C1720po) o;
        return this.tag == poVar.tag && Arrays.equals(this.awK, poVar.awK);
    }

    public int hashCode() {
        return ((this.tag + 527) * 31) + Arrays.hashCode(this.awK);
    }
}
