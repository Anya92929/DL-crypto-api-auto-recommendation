package com.appbrain.p033b;

import java.util.NoSuchElementException;

/* renamed from: com.appbrain.b.w */
final class C1019w implements C1003g {

    /* renamed from: a */
    final /* synthetic */ C1018v f2669a;

    /* renamed from: b */
    private int f2670b;

    /* renamed from: c */
    private final int f2671c;

    private C1019w(C1018v vVar) {
        this.f2669a = vVar;
        this.f2670b = 0;
        this.f2671c = vVar.mo3919a();
    }

    /* synthetic */ C1019w(C1018v vVar, byte b) {
        this(vVar);
    }

    /* renamed from: a */
    public final byte mo3937a() {
        try {
            byte[] bArr = this.f2669a.f2667c;
            int i = this.f2670b;
            this.f2670b = i + 1;
            return bArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public final boolean hasNext() {
        return this.f2670b < this.f2671c;
    }

    public final /* synthetic */ Object next() {
        return Byte.valueOf(mo3937a());
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
