package com.google.android.gms.internal;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.m */
class C0605m implements C0602k {

    /* renamed from: dD */
    private C0596gl f1552dD;

    /* renamed from: dE */
    private byte[] f1553dE;

    /* renamed from: dF */
    private final int f1554dF;

    public C0605m(int i) {
        this.f1554dF = i;
        reset();
    }

    /* renamed from: b */
    public void mo5305b(int i, long j) throws IOException {
        this.f1552dD.mo5293b(i, j);
    }

    /* renamed from: b */
    public void mo5306b(int i, String str) throws IOException {
        this.f1552dD.mo5294b(i, str);
    }

    /* renamed from: h */
    public byte[] mo5307h() throws IOException {
        int ec = this.f1552dD.mo5297ec();
        if (ec < 0) {
            throw new IOException();
        } else if (ec == 0) {
            return this.f1553dE;
        } else {
            byte[] bArr = new byte[(this.f1553dE.length - ec)];
            System.arraycopy(this.f1553dE, 0, bArr, 0, bArr.length);
            return bArr;
        }
    }

    public void reset() {
        this.f1553dE = new byte[this.f1554dF];
        this.f1552dD = C0596gl.m1864g(this.f1553dE);
    }
}
