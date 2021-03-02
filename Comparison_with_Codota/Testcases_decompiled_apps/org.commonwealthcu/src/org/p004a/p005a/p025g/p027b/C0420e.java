package org.p004a.p005a.p025g.p027b;

import java.util.concurrent.ConcurrentHashMap;
import org.p004a.p005a.p006a.C0227h;
import org.p004a.p005a.p006a.C0233n;
import org.p004a.p005a.p007b.C0287g;
import org.p004a.p005a.p007b.p008a.C0250b;

/* renamed from: org.a.a.g.b.e */
public final class C0420e implements C0287g {

    /* renamed from: a */
    private final ConcurrentHashMap f363a = new ConcurrentHashMap();

    /* renamed from: a */
    public final C0233n mo4934a(C0227h hVar) {
        int i;
        C0250b.m84a((Object) hVar, "Authentication scope");
        ConcurrentHashMap concurrentHashMap = this.f363a;
        C0233n nVar = (C0233n) concurrentHashMap.get(hVar);
        if (nVar != null) {
            return nVar;
        }
        int i2 = -1;
        C0227h hVar2 = null;
        for (C0227h hVar3 : concurrentHashMap.keySet()) {
            int a = hVar.mo4819a(hVar3);
            if (a > i2) {
                i = a;
            } else {
                hVar3 = hVar2;
                i = i2;
            }
            i2 = i;
            hVar2 = hVar3;
        }
        return hVar2 != null ? (C0233n) concurrentHashMap.get(hVar2) : nVar;
    }

    public final String toString() {
        return this.f363a.toString();
    }
}
