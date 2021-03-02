package com.google.p008a.p010b.p011a;

import com.google.p008a.C0363al;
import com.google.p008a.p013d.C0470a;
import com.google.p008a.p013d.C0472c;
import com.google.p008a.p013d.C0473d;
import java.net.InetAddress;

/* renamed from: com.google.a.b.a.am */
final class C0380am extends C0363al<InetAddress> {
    C0380am() {
    }

    /* renamed from: a */
    public InetAddress mo6310b(C0470a aVar) {
        if (aVar.mo6381f() != C0472c.NULL) {
            return InetAddress.getByName(aVar.mo6383h());
        }
        aVar.mo6385j();
        return null;
    }

    /* renamed from: a */
    public void mo6309a(C0473d dVar, InetAddress inetAddress) {
        dVar.mo6400b(inetAddress == null ? null : inetAddress.getHostAddress());
    }
}
