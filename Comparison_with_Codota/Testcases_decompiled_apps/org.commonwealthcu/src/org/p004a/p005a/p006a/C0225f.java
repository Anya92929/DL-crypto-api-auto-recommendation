package org.p004a.p005a.p006a;

import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p013c.C0298a;
import org.p004a.p005a.p034j.C0544b;

/* renamed from: org.a.a.a.f */
public final class C0225f implements C0298a {

    /* renamed from: a */
    private final ConcurrentHashMap f22a = new ConcurrentHashMap();

    /* renamed from: a */
    public final /* synthetic */ Object mo4816a(String str) {
        return new C0226g(this, str);
    }

    /* renamed from: a */
    public final C0222c mo4817a(String str, C0544b bVar) {
        C0250b.m84a((Object) str, "Name");
        C0223d dVar = (C0223d) this.f22a.get(str.toLowerCase(Locale.ENGLISH));
        if (dVar != null) {
            return dVar.mo4814a();
        }
        throw new IllegalStateException("Unsupported authentication scheme: " + str);
    }

    /* renamed from: a */
    public final void mo4818a(String str, C0223d dVar) {
        C0250b.m84a((Object) str, "Name");
        C0250b.m84a((Object) dVar, "Authentication scheme factory");
        this.f22a.put(str.toLowerCase(Locale.ENGLISH), dVar);
    }
}
