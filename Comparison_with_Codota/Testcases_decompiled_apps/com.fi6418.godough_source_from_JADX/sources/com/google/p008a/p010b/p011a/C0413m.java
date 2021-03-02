package com.google.p008a.p010b.p011a;

import com.google.p008a.C0353ab;
import com.google.p008a.C0356ae;
import com.google.p008a.C0363al;
import com.google.p008a.C0481k;
import com.google.p008a.C0493w;
import com.google.p008a.p010b.C0431ae;
import com.google.p008a.p010b.C0433ag;
import com.google.p008a.p010b.C0461u;
import com.google.p008a.p013d.C0470a;
import com.google.p008a.p013d.C0472c;
import com.google.p008a.p013d.C0473d;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

/* renamed from: com.google.a.b.a.m */
final class C0413m<K, V> extends C0363al<Map<K, V>> {

    /* renamed from: a */
    final /* synthetic */ C0412l f3419a;

    /* renamed from: b */
    private final C0363al<K> f3420b;

    /* renamed from: c */
    private final C0363al<V> f3421c;

    /* renamed from: d */
    private final C0431ae<? extends Map<K, V>> f3422d;

    public C0413m(C0412l lVar, C0481k kVar, Type type, C0363al<K> alVar, Type type2, C0363al<V> alVar2, C0431ae<? extends Map<K, V>> aeVar) {
        this.f3419a = lVar;
        this.f3420b = new C0425y(kVar, alVar, type);
        this.f3421c = new C0425y(kVar, alVar2, type2);
        this.f3422d = aeVar;
    }

    /* renamed from: a */
    private String m2675a(C0493w wVar) {
        if (wVar.mo6538i()) {
            C0353ab m = wVar.mo6542m();
            if (m.mo6307p()) {
                return String.valueOf(m.mo6296a());
            }
            if (m.mo6306o()) {
                return Boolean.toString(m.mo6303f());
            }
            if (m.mo6308q()) {
                return m.mo6298b();
            }
            throw new AssertionError();
        } else if (wVar.mo6539j()) {
            return "null";
        } else {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    public Map<K, V> mo6310b(C0470a aVar) {
        C0472c f = aVar.mo6381f();
        if (f == C0472c.NULL) {
            aVar.mo6385j();
            return null;
        }
        Map<K, V> map = (Map) this.f3422d.mo6436a();
        if (f == C0472c.BEGIN_ARRAY) {
            aVar.mo6375a();
            while (aVar.mo6380e()) {
                aVar.mo6375a();
                K b = this.f3420b.mo6310b(aVar);
                if (map.put(b, this.f3421c.mo6310b(aVar)) != null) {
                    throw new C0356ae("duplicate key: " + b);
                }
                aVar.mo6376b();
            }
            aVar.mo6376b();
            return map;
        }
        aVar.mo6377c();
        while (aVar.mo6380e()) {
            C0461u.f3557a.mo6466a(aVar);
            K b2 = this.f3420b.mo6310b(aVar);
            if (map.put(b2, this.f3421c.mo6310b(aVar)) != null) {
                throw new C0356ae("duplicate key: " + b2);
            }
        }
        aVar.mo6379d();
        return map;
    }

    /* renamed from: a */
    public void mo6309a(C0473d dVar, Map<K, V> map) {
        int i = 0;
        if (map == null) {
            dVar.mo6405f();
        } else if (!this.f3419a.f3418b) {
            dVar.mo6403d();
            for (Map.Entry next : map.entrySet()) {
                dVar.mo6396a(String.valueOf(next.getKey()));
                this.f3421c.mo6309a(dVar, next.getValue());
            }
            dVar.mo6404e();
        } else {
            ArrayList arrayList = new ArrayList(map.size());
            ArrayList arrayList2 = new ArrayList(map.size());
            boolean z = false;
            for (Map.Entry next2 : map.entrySet()) {
                C0493w a = this.f3420b.mo6312a(next2.getKey());
                arrayList.add(a);
                arrayList2.add(next2.getValue());
                z = (a.mo6536g() || a.mo6537h()) | z;
            }
            if (z) {
                dVar.mo6399b();
                while (i < arrayList.size()) {
                    dVar.mo6399b();
                    C0433ag.m2723a((C0493w) arrayList.get(i), dVar);
                    this.f3421c.mo6309a(dVar, arrayList2.get(i));
                    dVar.mo6401c();
                    i++;
                }
                dVar.mo6401c();
                return;
            }
            dVar.mo6403d();
            while (i < arrayList.size()) {
                dVar.mo6396a(m2675a((C0493w) arrayList.get(i)));
                this.f3421c.mo6309a(dVar, arrayList2.get(i));
                i++;
            }
            dVar.mo6404e();
        }
    }
}
