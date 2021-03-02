package org.p004a.p005a.p025g.p026a;

import java.util.Locale;
import org.p004a.p005a.C0301d;
import org.p004a.p005a.C0344e;
import org.p004a.p005a.C0568q;
import org.p004a.p005a.p006a.C0231l;
import org.p004a.p005a.p006a.C0232m;
import org.p004a.p005a.p006a.C0233n;
import org.p004a.p005a.p006a.C0235p;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p036l.C0552d;
import org.p004a.p005a.p036l.C0553e;
import org.p004a.p005a.p037m.C0563b;

/* renamed from: org.a.a.g.a.a */
public abstract class C0385a implements C0232m {

    /* renamed from: a */
    private int f248a;

    /* renamed from: a */
    public C0344e mo4836a(C0233n nVar, C0568q qVar, C0553e eVar) {
        return mo4809a(nVar, qVar);
    }

    /* renamed from: a */
    public void mo4810a(C0344e eVar) {
        int i;
        C0563b bVar;
        C0250b.m84a((Object) eVar, "Header");
        String c = eVar.mo5040c();
        if (c.equalsIgnoreCase("WWW-Authenticate")) {
            this.f248a = C0231l.f37a;
        } else if (c.equalsIgnoreCase("Proxy-Authenticate")) {
            this.f248a = C0231l.f38b;
        } else {
            throw new C0235p("Unexpected header name: " + c);
        }
        if (eVar instanceof C0301d) {
            bVar = ((C0301d) eVar).mo4949a();
            i = ((C0301d) eVar).mo4950b();
        } else {
            String d = eVar.mo5041d();
            if (d == null) {
                throw new C0235p("Header value is null");
            }
            bVar = new C0563b(d.length());
            bVar.mo5428a(d);
            i = 0;
        }
        while (i < bVar.mo5435c() && C0552d.m1151a(bVar.mo5423a(i))) {
            i++;
        }
        int i2 = i;
        while (i2 < bVar.mo5435c() && !C0552d.m1151a(bVar.mo5423a(i2))) {
            i2++;
        }
        String a = bVar.mo5425a(i, i2);
        if (!a.equalsIgnoreCase(mo4808a())) {
            throw new C0235p("Invalid scheme identifier: " + a);
        }
        mo5140a(bVar, i2, bVar.mo5435c());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo5140a(C0563b bVar, int i, int i2);

    /* renamed from: e */
    public final boolean mo5141e() {
        return this.f248a != 0 && this.f248a == C0231l.f38b;
    }

    public String toString() {
        return mo4808a().toUpperCase(Locale.US);
    }
}
