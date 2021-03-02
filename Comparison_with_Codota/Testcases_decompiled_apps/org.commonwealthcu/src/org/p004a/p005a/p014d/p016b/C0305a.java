package org.p004a.p005a.p014d.p016b;

import org.p004a.p005a.p007b.p008a.C0250b;

/* renamed from: org.a.a.d.b.a */
public final class C0305a implements C0307c {
    /* renamed from: a */
    public final int mo4963a(C0309e eVar, C0309e eVar2) {
        int i = -1;
        C0250b.m84a((Object) eVar, "Planned route");
        if (eVar2 == null || eVar2.mo4967c() <= 0) {
            return eVar.mo4967c() > 1 ? 2 : 1;
        }
        if (eVar.mo4967c() <= 1) {
            if (eVar2.mo4967c() <= 1 && eVar.mo4964a().equals(eVar2.mo4964a()) && eVar.mo4973g() == eVar2.mo4973g() && (eVar.mo4966b() == null || eVar.mo4966b().equals(eVar2.mo4966b()))) {
                i = 0;
            }
            return i;
        } else if (eVar2.mo4967c() <= 1) {
            return -1;
        } else {
            if (!eVar.mo4964a().equals(eVar2.mo4964a())) {
                return -1;
            }
            int c = eVar.mo4967c();
            int c2 = eVar2.mo4967c();
            if (c < c2) {
                return -1;
            }
            for (int i2 = 0; i2 < c2 - 1; i2++) {
                if (!eVar.mo4965a(i2).equals(eVar2.mo4965a(i2))) {
                    return -1;
                }
            }
            if (c > c2) {
                return 4;
            }
            if ((eVar2.mo4970e() && !eVar.mo4970e()) || (eVar2.mo4972f() && !eVar.mo4972f())) {
                return -1;
            }
            if (eVar.mo4970e() && !eVar2.mo4970e()) {
                return 3;
            }
            if (!eVar.mo4972f() || eVar2.mo4972f()) {
                return eVar.mo4973g() != eVar2.mo4973g() ? -1 : 0;
            }
            return 5;
        }
    }
}
