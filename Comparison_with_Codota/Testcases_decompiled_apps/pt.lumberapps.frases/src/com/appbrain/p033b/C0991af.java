package com.appbrain.p033b;

/* renamed from: com.appbrain.b.af */
final class C0991af implements C1003g {

    /* renamed from: a */
    int f2608a;

    /* renamed from: b */
    final /* synthetic */ C0988ac f2609b;

    /* renamed from: c */
    private final C0990ae f2610c;

    /* renamed from: d */
    private C1003g f2611d;

    private C0991af(C0988ac acVar) {
        this.f2609b = acVar;
        this.f2610c = new C0990ae(acVar, (byte) 0);
        this.f2611d = this.f2610c.next().iterator();
        this.f2608a = acVar.mo3919a();
    }

    /* synthetic */ C0991af(C0988ac acVar, byte b) {
        this(acVar);
    }

    /* renamed from: a */
    public final byte mo3937a() {
        if (!this.f2611d.hasNext()) {
            this.f2611d = this.f2610c.next().iterator();
        }
        this.f2608a--;
        return this.f2611d.mo3937a();
    }

    public final boolean hasNext() {
        return this.f2608a > 0;
    }

    public final /* synthetic */ Object next() {
        return Byte.valueOf(mo3937a());
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
