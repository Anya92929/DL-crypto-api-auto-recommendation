package com.appbrain.p033b;

/* renamed from: com.appbrain.b.h */
final class C1004h {

    /* renamed from: a */
    private final C1008l f2631a;

    /* renamed from: b */
    private final byte[] f2632b;

    private C1004h(int i) {
        this.f2632b = new byte[i];
        this.f2631a = C1008l.m4213a(this.f2632b);
    }

    /* synthetic */ C1004h(int i, byte b) {
        this(i);
    }

    /* renamed from: a */
    public final C1002f mo3972a() {
        this.f2631a.mo4001b();
        return new C1018v(this.f2632b);
    }

    /* renamed from: b */
    public final C1008l mo3973b() {
        return this.f2631a;
    }
}
