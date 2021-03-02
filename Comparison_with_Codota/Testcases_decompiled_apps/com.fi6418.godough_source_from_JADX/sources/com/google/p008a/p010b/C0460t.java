package com.google.p008a.p010b;

import com.google.p008a.C0363al;
import com.google.p008a.C0364am;
import com.google.p008a.C0481k;
import com.google.p008a.p012c.C0468a;
import com.google.p008a.p013d.C0470a;
import com.google.p008a.p013d.C0473d;

/* renamed from: com.google.a.b.t */
class C0460t extends C0363al<T> {

    /* renamed from: a */
    final /* synthetic */ boolean f3551a;

    /* renamed from: b */
    final /* synthetic */ boolean f3552b;

    /* renamed from: c */
    final /* synthetic */ C0481k f3553c;

    /* renamed from: d */
    final /* synthetic */ C0468a f3554d;

    /* renamed from: e */
    final /* synthetic */ C0459s f3555e;

    /* renamed from: f */
    private C0363al<T> f3556f;

    C0460t(C0459s sVar, boolean z, boolean z2, C0481k kVar, C0468a aVar) {
        this.f3555e = sVar;
        this.f3551a = z;
        this.f3552b = z2;
        this.f3553c = kVar;
        this.f3554d = aVar;
    }

    /* renamed from: a */
    private C0363al<T> m2778a() {
        C0363al<T> alVar = this.f3556f;
        if (alVar != null) {
            return alVar;
        }
        C0363al<T> a = this.f3553c.mo6510a((C0364am) this.f3555e, this.f3554d);
        this.f3556f = a;
        return a;
    }

    /* renamed from: a */
    public void mo6309a(C0473d dVar, T t) {
        if (this.f3552b) {
            dVar.mo6405f();
        } else {
            m2778a().mo6309a(dVar, t);
        }
    }

    /* renamed from: b */
    public T mo6310b(C0470a aVar) {
        if (!this.f3551a) {
            return m2778a().mo6310b(aVar);
        }
        aVar.mo6389n();
        return null;
    }
}
