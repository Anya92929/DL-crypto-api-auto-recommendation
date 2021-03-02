package org.p004a.p005a.p033i;

import org.p004a.p005a.C0241ac;
import org.p004a.p005a.C0243ae;
import org.p004a.p005a.C0568q;
import org.p004a.p005a.C0573v;
import org.p004a.p005a.p007b.p008a.C0250b;

/* renamed from: org.a.a.i.f */
public final class C0527f extends C0522a implements C0568q {

    /* renamed from: c */
    private final String f573c;

    /* renamed from: d */
    private final String f574d;

    /* renamed from: e */
    private C0243ae f575e;

    public C0527f(String str, String str2, C0241ac acVar) {
        this(new C0533l(str, str2, acVar));
    }

    private C0527f(C0243ae aeVar) {
        this.f575e = (C0243ae) C0250b.m84a((Object) aeVar, "Request line");
        this.f573c = aeVar.mo4863a();
        this.f574d = aeVar.mo4865c();
    }

    /* renamed from: c */
    public final C0241ac mo4901c() {
        return mo4902g().mo4864b();
    }

    /* renamed from: g */
    public final C0243ae mo4902g() {
        if (this.f575e == null) {
            this.f575e = new C0533l(this.f573c, this.f574d, C0573v.f645b);
        }
        return this.f575e;
    }

    public final String toString() {
        return this.f573c + " " + this.f574d + " " + this.f563a;
    }
}
