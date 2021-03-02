package org.p004a.p005a.p014d.p017c;

import java.util.concurrent.ConcurrentHashMap;
import org.p004a.p005a.C0565n;
import org.p004a.p005a.p007b.p008a.C0250b;

/* renamed from: org.a.a.d.c.f */
public final class C0319f {

    /* renamed from: a */
    private final ConcurrentHashMap f163a = new ConcurrentHashMap();

    /* renamed from: a */
    public final C0316c mo5004a(String str) {
        C0250b.m84a((Object) str, "Scheme name");
        C0316c cVar = (C0316c) this.f163a.get(str);
        if (cVar != null) {
            return cVar;
        }
        throw new IllegalStateException("Scheme '" + str + "' not registered.");
    }

    /* renamed from: a */
    public final C0316c mo5005a(C0316c cVar) {
        C0250b.m84a((Object) cVar, "Scheme");
        return (C0316c) this.f163a.put(cVar.mo4998c(), cVar);
    }

    /* renamed from: a */
    public final C0316c mo5006a(C0565n nVar) {
        C0250b.m84a((Object) nVar, "Host");
        return mo5004a(nVar.mo5443c());
    }
}
