package org.p004a.p005a.p025g.p026a;

import org.p004a.p005a.C0344e;
import org.p004a.p005a.C0568q;
import org.p004a.p005a.p006a.C0229j;
import org.p004a.p005a.p006a.C0233n;
import org.p004a.p005a.p006a.C0234o;
import org.p004a.p005a.p006a.C0235p;
import org.p004a.p005a.p006a.C0236q;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p033i.C0536o;
import org.p004a.p005a.p037m.C0563b;

/* renamed from: org.a.a.g.a.x */
public final class C0412x extends C0385a {

    /* renamed from: a */
    private final C0402n f329a;

    /* renamed from: b */
    private C0413y f330b;

    /* renamed from: c */
    private String f331c;

    public C0412x() {
        this(new C0404p());
    }

    private C0412x(C0402n nVar) {
        C0250b.m84a((Object) nVar, "NTLM engine");
        this.f329a = nVar;
        this.f330b = C0413y.UNINITIATED;
        this.f331c = null;
    }

    /* renamed from: a */
    public final String mo4808a() {
        return "ntlm";
    }

    /* renamed from: a */
    public final C0344e mo4809a(C0233n nVar, C0568q qVar) {
        String a;
        try {
            C0236q qVar2 = (C0236q) nVar;
            if (this.f330b == C0413y.FAILED) {
                throw new C0229j("NTLM authentication failed");
            }
            if (this.f330b == C0413y.CHALLENGE_RECEIVED) {
                a = this.f329a.mo5154a(qVar2.mo4840d(), qVar2.mo4841e());
                this.f330b = C0413y.MSG_TYPE1_GENERATED;
            } else if (this.f330b == C0413y.MSG_TYPE2_RECEVIED) {
                a = this.f329a.mo5155a(qVar2.mo4839c(), qVar2.mo4838b(), qVar2.mo4840d(), qVar2.mo4841e(), this.f331c);
                this.f330b = C0413y.MSG_TYPE3_GENERATED;
            } else {
                throw new C0229j("Unexpected state: " + this.f330b);
            }
            C0563b bVar = new C0563b(32);
            if (mo5141e()) {
                bVar.mo5428a("Proxy-Authorization");
            } else {
                bVar.mo5428a("Authorization");
            }
            bVar.mo5428a(": NTLM ");
            bVar.mo5428a(a);
            return new C0536o(bVar);
        } catch (ClassCastException e) {
            throw new C0234o("Credentials cannot be used for NTLM authentication: " + nVar.getClass().getName());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo5140a(C0563b bVar, int i, int i2) {
        this.f331c = bVar.mo5432b(i, i2);
        if (this.f331c.length() == 0) {
            if (this.f330b == C0413y.UNINITIATED) {
                this.f330b = C0413y.CHALLENGE_RECEIVED;
            } else {
                this.f330b = C0413y.FAILED;
            }
        } else if (this.f330b.compareTo(C0413y.MSG_TYPE1_GENERATED) < 0) {
            this.f330b = C0413y.FAILED;
            throw new C0235p("Out of sequence NTLM response message");
        } else if (this.f330b == C0413y.MSG_TYPE1_GENERATED) {
            this.f330b = C0413y.MSG_TYPE2_RECEVIED;
        }
    }

    /* renamed from: b */
    public final String mo4811b() {
        return null;
    }

    /* renamed from: c */
    public final boolean mo4812c() {
        return true;
    }

    /* renamed from: d */
    public final boolean mo4813d() {
        return this.f330b == C0413y.MSG_TYPE3_GENERATED || this.f330b == C0413y.FAILED;
    }
}
