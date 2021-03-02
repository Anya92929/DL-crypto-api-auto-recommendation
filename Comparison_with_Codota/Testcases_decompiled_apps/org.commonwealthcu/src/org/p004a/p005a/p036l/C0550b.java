package org.p004a.p005a.p036l;

import java.util.ArrayList;
import java.util.List;
import org.p004a.p005a.C0568q;
import org.p004a.p005a.C0569r;
import org.p004a.p005a.C0570s;
import org.p004a.p005a.C0572u;

/* renamed from: org.a.a.l.b */
public final class C0550b implements Cloneable, C0569r {

    /* renamed from: a */
    private List f618a = new ArrayList();

    /* renamed from: b */
    private List f619b = new ArrayList();

    /* renamed from: a */
    public final int mo5400a() {
        return this.f618a.size();
    }

    /* renamed from: a */
    public final C0569r mo5401a(int i) {
        if (i < 0 || i >= this.f618a.size()) {
            return null;
        }
        return (C0569r) this.f618a.get(i);
    }

    /* renamed from: a */
    public final void mo4917a(C0568q qVar, C0553e eVar) {
        for (C0569r a : this.f618a) {
            a.mo4917a(qVar, eVar);
        }
    }

    /* renamed from: a */
    public final void mo5402a(C0569r rVar) {
        if (rVar != null) {
            this.f618a.add(rVar);
        }
    }

    /* renamed from: a */
    public final void mo4919a(C0570s sVar, C0553e eVar) {
        for (C0572u a : this.f619b) {
            a.mo4919a(sVar, eVar);
        }
    }

    /* renamed from: a */
    public final void mo5403a(C0572u uVar) {
        if (uVar != null) {
            this.f619b.add(uVar);
        }
    }

    /* renamed from: b */
    public final int mo5404b() {
        return this.f619b.size();
    }

    /* renamed from: b */
    public final C0572u mo5405b(int i) {
        if (i < 0 || i >= this.f619b.size()) {
            return null;
        }
        return (C0572u) this.f619b.get(i);
    }

    public final Object clone() {
        C0550b bVar = (C0550b) super.clone();
        bVar.f618a.clear();
        bVar.f618a.addAll(this.f618a);
        bVar.f619b.clear();
        bVar.f619b.addAll(this.f619b);
        return bVar;
    }
}
