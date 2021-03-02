package com.google.android.gms.internal;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.p */
class C1700p implements C1582n {

    /* renamed from: kY */
    private C1710pf f4355kY;

    /* renamed from: kZ */
    private byte[] f4356kZ;

    /* renamed from: la */
    private final int f4357la;

    public C1700p(int i) {
        this.f4357la = i;
        reset();
    }

    /* renamed from: A */
    public byte[] mo9487A() throws IOException {
        int qv = this.f4355kY.mo10072qv();
        if (qv < 0) {
            throw new IOException();
        } else if (qv == 0) {
            return this.f4356kZ;
        } else {
            byte[] bArr = new byte[(this.f4356kZ.length - qv)];
            System.arraycopy(this.f4356kZ, 0, bArr, 0, bArr.length);
            return bArr;
        }
    }

    /* renamed from: b */
    public void mo9488b(int i, long j) throws IOException {
        this.f4355kY.mo10057b(i, j);
    }

    /* renamed from: b */
    public void mo9489b(int i, String str) throws IOException {
        this.f4355kY.mo10058b(i, str);
    }

    public void reset() {
        this.f4356kZ = new byte[this.f4357la];
        this.f4355kY = C1710pf.m6017q(this.f4356kZ);
    }
}
