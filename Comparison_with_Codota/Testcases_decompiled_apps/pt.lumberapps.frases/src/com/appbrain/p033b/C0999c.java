package com.appbrain.p033b;

import java.io.InputStream;

/* renamed from: com.appbrain.b.c */
public abstract class C0999c implements C0986aa {

    /* renamed from: a */
    private static final C1010n f2623a = C1010n.m4242a();

    /* renamed from: a */
    private static C1020x m4148a(C1020x xVar) {
        if (xVar == null || xVar.mo4029e()) {
            return xVar;
        }
        throw new C1015s((xVar instanceof C0985a ? new C0992ag() : new C0992ag()).getMessage()).mo4010a(xVar);
    }

    /* renamed from: a */
    private C1020x m4149a(InputStream inputStream, C1010n nVar) {
        C1006j a = C1006j.m4186a(inputStream);
        C1020x xVar = (C1020x) mo3916a(a, nVar);
        try {
            a.mo3980a(0);
            return xVar;
        } catch (C1015s e) {
            throw e.mo4010a(xVar);
        }
    }

    /* renamed from: a */
    private C1020x m4150a(byte[] bArr, int i, C1010n nVar) {
        C1020x xVar;
        try {
            C1006j a = C1006j.m4187a(bArr, i);
            xVar = (C1020x) mo3916a(a, nVar);
            a.mo3980a(0);
            return xVar;
        } catch (C1015s e) {
            throw e.mo4010a(xVar);
        } catch (C1015s e2) {
            throw e2;
        }
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ Object mo3917a(InputStream inputStream) {
        return m4148a(m4149a(inputStream, f2623a));
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ Object mo3918a(byte[] bArr) {
        return m4148a(m4150a(bArr, bArr.length, f2623a));
    }
}
