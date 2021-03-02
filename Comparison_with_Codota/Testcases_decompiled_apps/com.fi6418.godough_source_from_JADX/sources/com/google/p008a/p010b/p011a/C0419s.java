package com.google.p008a.p010b.p011a;

import com.google.p008a.C0356ae;
import com.google.p008a.C0363al;
import com.google.p008a.p010b.C0431ae;
import com.google.p008a.p013d.C0470a;
import com.google.p008a.p013d.C0472c;
import com.google.p008a.p013d.C0473d;
import java.util.Map;

/* renamed from: com.google.a.b.a.s */
public final class C0419s<T> extends C0363al<T> {

    /* renamed from: a */
    private final C0431ae<T> f3435a;

    /* renamed from: b */
    private final Map<String, C0420t> f3436b;

    private C0419s(C0431ae<T> aeVar, Map<String, C0420t> map) {
        this.f3435a = aeVar;
        this.f3436b = map;
    }

    /* synthetic */ C0419s(C0431ae aeVar, Map map, C0418r rVar) {
        this(aeVar, map);
    }

    /* renamed from: a */
    public void mo6309a(C0473d dVar, T t) {
        if (t == null) {
            dVar.mo6405f();
            return;
        }
        dVar.mo6403d();
        try {
            for (C0420t next : this.f3436b.values()) {
                if (next.f3438h) {
                    dVar.mo6396a(next.f3437g);
                    next.mo6414a(dVar, (Object) t);
                }
            }
            dVar.mo6404e();
        } catch (IllegalAccessException e) {
            throw new AssertionError();
        }
    }

    /* renamed from: b */
    public T mo6310b(C0470a aVar) {
        if (aVar.mo6381f() == C0472c.NULL) {
            aVar.mo6385j();
            return null;
        }
        T a = this.f3435a.mo6436a();
        try {
            aVar.mo6377c();
            while (aVar.mo6380e()) {
                C0420t tVar = this.f3436b.get(aVar.mo6382g());
                if (tVar == null || !tVar.f3439i) {
                    aVar.mo6389n();
                } else {
                    tVar.mo6413a(aVar, (Object) a);
                }
            }
            aVar.mo6379d();
            return a;
        } catch (IllegalStateException e) {
            throw new C0356ae((Throwable) e);
        } catch (IllegalAccessException e2) {
            throw new AssertionError(e2);
        }
    }
}
