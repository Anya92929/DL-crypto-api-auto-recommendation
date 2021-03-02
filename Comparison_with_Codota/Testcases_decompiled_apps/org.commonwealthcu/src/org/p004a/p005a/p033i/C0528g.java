package org.p004a.p005a.p033i;

import org.p004a.p005a.C0241ac;
import org.p004a.p005a.C0244af;
import org.p004a.p005a.C0546k;
import org.p004a.p005a.C0570s;
import org.p004a.p005a.C0573v;
import org.p004a.p005a.p007b.p008a.C0250b;

/* renamed from: org.a.a.i.g */
public final class C0528g extends C0522a implements C0570s {

    /* renamed from: c */
    private C0244af f576c;

    /* renamed from: d */
    private C0241ac f577d;

    /* renamed from: e */
    private int f578e;

    /* renamed from: f */
    private String f579f;

    /* renamed from: g */
    private C0546k f580g;

    public C0528g(C0244af afVar) {
        this.f576c = (C0244af) C0250b.m84a((Object) afVar, "Status line");
        this.f577d = afVar.mo4866a();
        this.f578e = afVar.mo4867b();
        this.f579f = afVar.mo4868c();
    }

    /* renamed from: a */
    public final C0244af mo5345a() {
        if (this.f576c == null) {
            this.f576c = new C0534m(this.f577d != null ? this.f577d : C0573v.f645b, this.f578e, this.f579f);
        }
        return this.f576c;
    }

    /* renamed from: a */
    public final void mo5346a(C0546k kVar) {
        this.f580g = kVar;
    }

    /* renamed from: b */
    public final C0546k mo5347b() {
        return this.f580g;
    }

    /* renamed from: c */
    public final C0241ac mo4901c() {
        return this.f577d;
    }

    public final String toString() {
        return mo5345a() + " " + this.f563a;
    }
}
