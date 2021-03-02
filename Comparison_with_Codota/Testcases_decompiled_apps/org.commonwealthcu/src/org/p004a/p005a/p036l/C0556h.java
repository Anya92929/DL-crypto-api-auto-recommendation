package org.p004a.p005a.p036l;

import org.p004a.p005a.C0568q;
import org.p004a.p005a.C0569r;
import org.p004a.p005a.C0570s;
import org.p004a.p005a.C0572u;

/* renamed from: org.a.a.l.h */
public final class C0556h implements C0569r {

    /* renamed from: a */
    private final C0569r[] f626a;

    /* renamed from: b */
    private final C0572u[] f627b;

    public C0556h(C0569r[] rVarArr, C0572u[] uVarArr) {
        int length = rVarArr.length;
        this.f626a = new C0569r[length];
        System.arraycopy(rVarArr, 0, this.f626a, 0, length);
        int length2 = uVarArr.length;
        this.f627b = new C0572u[length2];
        System.arraycopy(uVarArr, 0, this.f627b, 0, length2);
    }

    /* renamed from: a */
    public final void mo4917a(C0568q qVar, C0553e eVar) {
        for (C0569r a : this.f626a) {
            a.mo4917a(qVar, eVar);
        }
    }

    /* renamed from: a */
    public final void mo4919a(C0570s sVar, C0553e eVar) {
        for (C0572u a : this.f627b) {
            a.mo4919a(sVar, eVar);
        }
    }
}
