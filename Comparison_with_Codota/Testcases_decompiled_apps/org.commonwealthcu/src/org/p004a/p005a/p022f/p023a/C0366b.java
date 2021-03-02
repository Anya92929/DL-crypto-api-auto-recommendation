package org.p004a.p005a.p022f.p023a;

import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p022f.p023a.p024a.C0363a;

/* renamed from: org.a.a.f.a.b */
public final class C0366b {

    /* renamed from: a */
    private final String f197a;

    /* renamed from: b */
    private final C0367c f198b = new C0367c();

    /* renamed from: c */
    private final C0363a f199c;

    public C0366b(String str, C0363a aVar) {
        C0250b.m84a((Object) str, "Name");
        C0250b.m84a((Object) aVar, "Body");
        this.f197a = str;
        this.f199c = aVar;
        StringBuilder sb = new StringBuilder();
        sb.append("form-data; name=\"");
        sb.append(this.f197a);
        sb.append("\"");
        if (aVar.mo5102e() != null) {
            sb.append("; filename=\"");
            sb.append(aVar.mo5102e());
            sb.append("\"");
        }
        m425a("Content-Disposition", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(aVar.mo5097a());
        if (aVar.mo5099b() != null) {
            sb2.append("; charset=");
            sb2.append(aVar.mo5099b());
        }
        m425a("Content-Type", sb2.toString());
        m425a("Content-Transfer-Encoding", aVar.mo5100c());
    }

    /* renamed from: a */
    private void m425a(String str, String str2) {
        C0250b.m84a((Object) str, "Field name");
        this.f198b.mo5106a(new C0373i(str, str2));
    }

    /* renamed from: a */
    public final C0363a mo5103a() {
        return this.f199c;
    }

    /* renamed from: b */
    public final C0367c mo5104b() {
        return this.f198b;
    }
}
