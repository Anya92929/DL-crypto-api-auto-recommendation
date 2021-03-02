package com.appbrain.p033b;

import java.util.NoSuchElementException;

/* renamed from: com.appbrain.b.e */
final class C1001e implements C1003g {

    /* renamed from: a */
    final /* synthetic */ C1000d f2626a;

    /* renamed from: b */
    private int f2627b;

    /* renamed from: c */
    private final int f2628c;

    private C1001e(C1000d dVar) {
        this.f2626a = dVar;
        this.f2627b = dVar.mo3963b();
        this.f2628c = this.f2627b + dVar.mo3919a();
    }

    /* synthetic */ C1001e(C1000d dVar, byte b) {
        this(dVar);
    }

    /* renamed from: a */
    public final byte mo3937a() {
        if (this.f2627b >= this.f2628c) {
            throw new NoSuchElementException();
        }
        byte[] bArr = this.f2626a.f2667c;
        int i = this.f2627b;
        this.f2627b = i + 1;
        return bArr[i];
    }

    public final boolean hasNext() {
        return this.f2627b < this.f2628c;
    }

    public final /* synthetic */ Object next() {
        return Byte.valueOf(mo3937a());
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
