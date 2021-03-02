package org.p004a.p005a.p014d;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import org.p004a.p005a.C0565n;
import org.p004a.p005a.p007b.p008a.C0250b;

/* renamed from: org.a.a.d.k */
public final class C0337k extends InetSocketAddress {

    /* renamed from: a */
    private final C0565n f177a;

    public C0337k(C0565n nVar, InetAddress inetAddress, int i) {
        super(inetAddress, i);
        C0250b.m84a((Object) nVar, "HTTP host");
        this.f177a = nVar;
    }

    /* renamed from: a */
    public final C0565n mo5023a() {
        return this.f177a;
    }

    public final String toString() {
        return this.f177a.mo5441a() + ":" + getPort();
    }
}
