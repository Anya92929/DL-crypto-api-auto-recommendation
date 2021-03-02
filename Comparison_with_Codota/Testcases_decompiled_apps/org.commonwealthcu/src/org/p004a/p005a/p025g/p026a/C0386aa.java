package org.p004a.p005a.p025g.p026a;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.p004a.p005a.C0297c;
import org.p004a.p005a.C0360f;
import org.p004a.p005a.C0568q;
import org.p004a.p005a.p006a.C0235p;
import org.p004a.p005a.p033i.C0526e;
import org.p004a.p005a.p033i.C0541t;
import org.p004a.p005a.p037m.C0563b;

/* renamed from: org.a.a.g.a.aa */
public abstract class C0386aa extends C0385a {

    /* renamed from: a */
    private final Map f249a = new HashMap();

    /* renamed from: b */
    private final Charset f250b;

    public C0386aa(Charset charset) {
        this.f250b = charset == null ? C0297c.f130b : charset;
    }

    /* renamed from: a */
    public final String mo5143a(String str) {
        return (String) this.f249a.get(str.toLowerCase(Locale.ENGLISH));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final String mo5144a(C0568q qVar) {
        String str = (String) qVar.mo5331f().mo5196a("http.auth.credential-charset");
        return str == null ? this.f250b.name() : str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo5140a(C0563b bVar, int i, int i2) {
        C0360f[] a = C0526e.f571a.mo5342a(bVar, new C0541t(i, bVar.mo5435c()));
        if (a.length == 0) {
            throw new C0235p("Authentication challenge is empty");
        }
        this.f249a.clear();
        for (C0360f fVar : a) {
            this.f249a.put(fVar.mo5080a(), fVar.mo5083b());
        }
    }

    /* renamed from: b */
    public final String mo4811b() {
        return mo5143a("realm");
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public final Map mo5145f() {
        return this.f249a;
    }
}
