package org.p004a.p005a.p021e;

import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p013c.C0298a;
import org.p004a.p005a.p034j.C0544b;

/* renamed from: org.a.a.e.k */
public final class C0355k implements C0298a {

    /* renamed from: a */
    private final ConcurrentHashMap f182a = new ConcurrentHashMap();

    /* renamed from: a */
    public final /* synthetic */ Object mo4816a(String str) {
        return new C0356l(this, str);
    }

    /* renamed from: a */
    public final C0352h mo5071a(String str, C0544b bVar) {
        C0250b.m84a((Object) str, "Name");
        C0353i iVar = (C0353i) this.f182a.get(str.toLowerCase(Locale.ENGLISH));
        if (iVar != null) {
            return iVar.mo5069a(bVar);
        }
        throw new IllegalStateException("Unsupported cookie spec: " + str);
    }

    /* renamed from: a */
    public final void mo5072a(String str, C0353i iVar) {
        C0250b.m84a((Object) str, "Name");
        C0250b.m84a((Object) iVar, "Cookie spec factory");
        this.f182a.put(str.toLowerCase(Locale.ENGLISH), iVar);
    }
}
