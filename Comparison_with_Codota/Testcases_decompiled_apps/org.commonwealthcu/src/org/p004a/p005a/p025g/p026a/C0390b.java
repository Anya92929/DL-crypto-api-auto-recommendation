package org.p004a.p005a.p025g.p026a;

import java.nio.charset.Charset;
import org.apache.commons.codec.binary.Base64;
import org.p004a.p005a.C0297c;
import org.p004a.p005a.C0344e;
import org.p004a.p005a.C0568q;
import org.p004a.p005a.p006a.C0233n;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p033i.C0536o;
import org.p004a.p005a.p036l.C0549a;
import org.p004a.p005a.p036l.C0553e;
import org.p004a.p005a.p037m.C0563b;

/* renamed from: org.a.a.g.a.b */
public final class C0390b extends C0386aa {

    /* renamed from: a */
    private final Base64 f252a;

    /* renamed from: b */
    private boolean f253b;

    public C0390b() {
        this(C0297c.f130b);
    }

    public C0390b(Charset charset) {
        super(charset);
        this.f252a = new Base64(0);
        this.f253b = false;
    }

    /* renamed from: a */
    public final String mo4808a() {
        return "basic";
    }

    /* renamed from: a */
    public final C0344e mo4809a(C0233n nVar, C0568q qVar) {
        return mo4836a(nVar, qVar, new C0549a());
    }

    /* renamed from: a */
    public final C0344e mo4836a(C0233n nVar, C0568q qVar, C0553e eVar) {
        C0250b.m84a((Object) nVar, "Credentials");
        C0250b.m84a((Object) qVar, "HTTP request");
        StringBuilder sb = new StringBuilder();
        sb.append(nVar.mo4837a().getName());
        sb.append(":");
        sb.append(nVar.mo4838b() == null ? "null" : nVar.mo4838b());
        byte[] encode = this.f252a.encode(C0250b.m100a(sb.toString(), mo5144a(qVar)));
        C0563b bVar = new C0563b(32);
        if (mo5141e()) {
            bVar.mo5428a("Proxy-Authorization");
        } else {
            bVar.mo5428a("Authorization");
        }
        bVar.mo5428a(": Basic ");
        bVar.mo5430a(encode, 0, encode.length);
        return new C0536o(bVar);
    }

    /* renamed from: a */
    public final void mo4810a(C0344e eVar) {
        super.mo4810a(eVar);
        this.f253b = true;
    }

    /* renamed from: c */
    public final boolean mo4812c() {
        return false;
    }

    /* renamed from: d */
    public final boolean mo4813d() {
        return this.f253b;
    }
}
