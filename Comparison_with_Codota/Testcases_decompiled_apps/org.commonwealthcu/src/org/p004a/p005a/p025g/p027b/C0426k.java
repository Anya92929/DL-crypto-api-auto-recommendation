package org.p004a.p005a.p025g.p027b;

import org.p004a.p005a.C0569r;
import org.p004a.p005a.C0572u;
import org.p004a.p005a.C0573v;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p007b.p011d.C0271b;
import org.p004a.p005a.p007b.p011d.C0272c;
import org.p004a.p005a.p007b.p011d.C0275f;
import org.p004a.p005a.p007b.p011d.C0276g;
import org.p004a.p005a.p007b.p011d.C0277h;
import org.p004a.p005a.p007b.p011d.C0278i;
import org.p004a.p005a.p007b.p011d.C0279j;
import org.p004a.p005a.p014d.C0304b;
import org.p004a.p005a.p034j.C0544b;
import org.p004a.p005a.p034j.C0545c;
import org.p004a.p005a.p036l.C0550b;
import org.p004a.p005a.p036l.C0552d;
import org.p004a.p005a.p036l.C0557i;
import org.p004a.p005a.p036l.C0558j;
import org.p004a.p005a.p036l.C0559k;
import org.p004a.p005a.p036l.C0560l;

/* renamed from: org.a.a.g.b.k */
public final class C0426k extends C0416a {
    public C0426k() {
        super((C0304b) null, (C0544b) null);
    }

    public C0426k(C0544b bVar) {
        super((C0304b) null, bVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final C0544b mo5186a() {
        C0545c cVar = new C0545c();
        C0573v vVar = C0573v.f645b;
        C0250b.m84a((Object) cVar, "HTTP parameters");
        cVar.mo5197a("http.protocol.version", (Object) vVar);
        String name = C0552d.f622a.name();
        C0250b.m84a((Object) cVar, "HTTP parameters");
        cVar.mo5197a("http.protocol.content-charset", (Object) name);
        C0250b.m84a((Object) cVar, "HTTP parameters");
        cVar.mo5392b("http.tcp.nodelay", true);
        C0250b.m84a((Object) cVar, "HTTP parameters");
        cVar.mo5391b("http.socket.buffer-size", 8192);
        String str = C0434s.f399a;
        C0250b.m84a((Object) cVar, "HTTP parameters");
        cVar.mo5197a("http.useragent", (Object) str);
        return cVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final C0550b mo5188b() {
        C0550b bVar = new C0550b();
        bVar.mo5402a((C0569r) new C0276g());
        bVar.mo5402a((C0569r) new C0557i());
        bVar.mo5402a((C0569r) new C0559k());
        bVar.mo5402a((C0569r) new C0275f());
        bVar.mo5402a((C0569r) new C0560l());
        bVar.mo5402a((C0569r) new C0558j());
        bVar.mo5402a((C0569r) new C0271b());
        bVar.mo5403a((C0572u) new C0279j());
        bVar.mo5402a((C0569r) new C0272c());
        bVar.mo5402a((C0569r) new C0278i());
        bVar.mo5402a((C0569r) new C0277h());
        return bVar;
    }
}
