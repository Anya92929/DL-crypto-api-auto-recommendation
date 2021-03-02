package com.appbrain.p033b;

import java.io.IOException;

/* renamed from: com.appbrain.b.a */
public abstract class C0985a implements C1020x {

    /* renamed from: a */
    protected int f2597a = 0;

    /* renamed from: a */
    public final C1002f mo3914a() {
        try {
            C1004h a = C1002f.m4163a(mo4026c());
            mo4025a(a.mo3973b());
            return a.mo3972a();
        } catch (IOException e) {
            throw new RuntimeException("Serializing to a ByteString threw an IOException (should never happen).", e);
        }
    }

    /* renamed from: b */
    public final byte[] mo3915b() {
        try {
            byte[] bArr = new byte[mo4026c()];
            C1008l a = C1008l.m4213a(bArr);
            mo4025a(a);
            a.mo4001b();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }
}
