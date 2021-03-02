package org.p004a.p005a.p025g.p027b;

import java.net.URI;
import java.net.URISyntaxException;
import org.p004a.p005a.C0240ab;
import org.p004a.p005a.C0241ac;
import org.p004a.p005a.C0243ae;
import org.p004a.p005a.C0568q;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p007b.p010c.C0265l;
import org.p004a.p005a.p033i.C0522a;
import org.p004a.p005a.p033i.C0533l;

/* renamed from: org.a.a.g.b.v */
public class C0437v extends C0522a implements C0265l {

    /* renamed from: c */
    private final C0568q f402c;

    /* renamed from: d */
    private URI f403d;

    /* renamed from: e */
    private String f404e;

    /* renamed from: f */
    private C0241ac f405f;

    /* renamed from: g */
    private int f406g;

    public C0437v(C0568q qVar) {
        C0250b.m84a((Object) qVar, "HTTP request");
        this.f402c = qVar;
        mo5321a(qVar.mo5331f());
        mo5322a(qVar.mo5328d());
        if (qVar instanceof C0265l) {
            this.f403d = ((C0265l) qVar).mo4903i();
            this.f404e = ((C0265l) qVar).mo4897a_();
            this.f405f = null;
        } else {
            C0243ae g = qVar.mo4902g();
            try {
                this.f403d = new URI(g.mo4865c());
                this.f404e = g.mo4863a();
                this.f405f = qVar.mo4901c();
            } catch (URISyntaxException e) {
                throw new C0240ab("Invalid request URI: " + g.mo4865c(), e);
            }
        }
        this.f406g = 0;
    }

    /* renamed from: a */
    public final void mo5210a(URI uri) {
        this.f403d = uri;
    }

    /* renamed from: a_ */
    public final String mo4897a_() {
        return this.f404e;
    }

    /* renamed from: c */
    public final C0241ac mo4901c() {
        if (this.f405f == null) {
            this.f405f = C0250b.m113f(mo5331f());
        }
        return this.f405f;
    }

    /* renamed from: g */
    public final C0243ae mo4902g() {
        String str = this.f404e;
        C0241ac c = mo4901c();
        String str2 = null;
        if (this.f403d != null) {
            str2 = this.f403d.toASCIIString();
        }
        if (str2 == null || str2.length() == 0) {
            str2 = "/";
        }
        return new C0533l(str, str2, c);
    }

    /* renamed from: h */
    public final boolean mo4905h() {
        return false;
    }

    /* renamed from: i */
    public final URI mo4903i() {
        return this.f403d;
    }

    /* renamed from: j */
    public boolean mo5200j() {
        return true;
    }

    /* renamed from: k */
    public final void mo5211k() {
        this.f563a.mo5371a();
        mo5322a(this.f402c.mo5328d());
    }

    /* renamed from: l */
    public final C0568q mo5212l() {
        return this.f402c;
    }

    /* renamed from: m */
    public final int mo5213m() {
        return this.f406g;
    }

    /* renamed from: n */
    public final void mo5214n() {
        this.f406g++;
    }
}
