package com.google.p008a;

import com.google.p008a.p010b.C0433ag;
import com.google.p008a.p012c.C0468a;
import com.google.p008a.p013d.C0470a;
import com.google.p008a.p013d.C0473d;

/* renamed from: com.google.a.ai */
final class C0360ai<T> extends C0363al<T> {

    /* renamed from: a */
    private final C0355ad<T> f3370a;

    /* renamed from: b */
    private final C0492v<T> f3371b;

    /* renamed from: c */
    private final C0481k f3372c;

    /* renamed from: d */
    private final C0468a<T> f3373d;

    /* renamed from: e */
    private final C0364am f3374e;

    /* renamed from: f */
    private C0363al<T> f3375f;

    private C0360ai(C0355ad<T> adVar, C0492v<T> vVar, C0481k kVar, C0468a<T> aVar, C0364am amVar) {
        this.f3370a = adVar;
        this.f3371b = vVar;
        this.f3372c = kVar;
        this.f3373d = aVar;
        this.f3374e = amVar;
    }

    /* renamed from: a */
    private C0363al<T> m2499a() {
        C0363al<T> alVar = this.f3375f;
        if (alVar != null) {
            return alVar;
        }
        C0363al<T> a = this.f3372c.mo6510a(this.f3374e, this.f3373d);
        this.f3375f = a;
        return a;
    }

    /* renamed from: a */
    public static C0364am m2500a(C0468a<?> aVar, Object obj) {
        return new C0362ak(obj, aVar, false, (Class) null);
    }

    /* renamed from: b */
    public static C0364am m2501b(C0468a<?> aVar, Object obj) {
        return new C0362ak(obj, aVar, aVar.mo6495b() == aVar.mo6494a(), (Class) null);
    }

    /* renamed from: a */
    public void mo6309a(C0473d dVar, T t) {
        if (this.f3370a == null) {
            m2499a().mo6309a(dVar, t);
        } else if (t == null) {
            dVar.mo6405f();
        } else {
            C0433ag.m2723a(this.f3370a.mo6285a(t, this.f3373d.mo6495b(), this.f3372c.f3619b), dVar);
        }
    }

    /* renamed from: b */
    public T mo6310b(C0470a aVar) {
        if (this.f3371b == null) {
            return m2499a().mo6310b(aVar);
        }
        C0493w a = C0433ag.m2721a(aVar);
        if (a.mo6539j()) {
            return null;
        }
        return this.f3371b.mo6288b(a, this.f3373d.mo6495b(), this.f3372c.f3618a);
    }
}
