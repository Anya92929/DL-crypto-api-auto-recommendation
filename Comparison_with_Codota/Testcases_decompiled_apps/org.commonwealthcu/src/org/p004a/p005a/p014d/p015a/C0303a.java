package org.p004a.p005a.p014d.p015a;

import java.net.InetAddress;
import org.p004a.p005a.C0565n;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p014d.p016b.C0306b;
import org.p004a.p005a.p034j.C0544b;

/* renamed from: org.a.a.d.a.a */
public final class C0303a {

    /* renamed from: a */
    private static C0565n f138a = new C0565n("127.0.0.255", 0, "no-host");

    /* renamed from: b */
    private static C0306b f139b = new C0306b(f138a);

    /* renamed from: a */
    public static C0565n m226a(C0544b bVar) {
        C0250b.m84a((Object) bVar, "Parameters");
        C0565n nVar = (C0565n) bVar.mo5196a("http.route.default-proxy");
        if (nVar == null || !f138a.equals(nVar)) {
            return nVar;
        }
        return null;
    }

    /* renamed from: b */
    public static C0306b m227b(C0544b bVar) {
        C0250b.m84a((Object) bVar, "Parameters");
        C0306b bVar2 = (C0306b) bVar.mo5196a("http.route.forced-route");
        if (bVar2 == null || !f139b.equals(bVar2)) {
            return bVar2;
        }
        return null;
    }

    /* renamed from: c */
    public static InetAddress m228c(C0544b bVar) {
        C0250b.m84a((Object) bVar, "Parameters");
        return (InetAddress) bVar.mo5196a("http.route.local-address");
    }
}
