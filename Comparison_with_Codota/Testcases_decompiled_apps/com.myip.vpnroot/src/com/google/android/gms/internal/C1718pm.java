package com.google.android.gms.internal;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.pm */
public abstract class C1718pm {
    protected volatile int awJ = -1;

    /* renamed from: a */
    public static final <T extends C1718pm> T m6089a(T t, byte[] bArr) throws C1717pl {
        return m6091b(t, bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public static final void m6090a(C1718pm pmVar, byte[] bArr, int i, int i2) {
        try {
            C1710pf b = C1710pf.m6000b(bArr, i, i2);
            pmVar.mo4922a(b);
            b.mo10073qw();
        } catch (IOException e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    /* renamed from: b */
    public static final <T extends C1718pm> T m6091b(T t, byte[] bArr, int i, int i2) throws C1717pl {
        try {
            C1709pe a = C1709pe.m5964a(bArr, i, i2);
            t.mo4923b(a);
            a.mo10021gl(0);
            return t;
        } catch (C1717pl e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    /* renamed from: f */
    public static final byte[] m6092f(C1718pm pmVar) {
        byte[] bArr = new byte[pmVar.mo10106qG()];
        m6090a(pmVar, bArr, 0, bArr.length);
        return bArr;
    }

    /* renamed from: a */
    public void mo4922a(C1710pf pfVar) throws IOException {
    }

    /* renamed from: b */
    public abstract C1718pm mo4923b(C1709pe peVar) throws IOException;

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public int mo4924c() {
        return 0;
    }

    /* renamed from: qF */
    public int mo10105qF() {
        if (this.awJ < 0) {
            mo10106qG();
        }
        return this.awJ;
    }

    /* renamed from: qG */
    public int mo10106qG() {
        int c = mo4924c();
        this.awJ = c;
        return c;
    }

    public String toString() {
        return C1719pn.m6103g(this);
    }
}
