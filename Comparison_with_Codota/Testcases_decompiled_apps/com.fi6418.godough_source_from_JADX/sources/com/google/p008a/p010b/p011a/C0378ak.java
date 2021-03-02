package com.google.p008a.p010b.p011a;

import com.google.p008a.C0363al;
import com.google.p008a.C0494x;
import com.google.p008a.p013d.C0470a;
import com.google.p008a.p013d.C0472c;
import com.google.p008a.p013d.C0473d;
import java.net.URI;
import java.net.URISyntaxException;

/* renamed from: com.google.a.b.a.ak */
final class C0378ak extends C0363al<URI> {
    C0378ak() {
    }

    /* renamed from: a */
    public URI mo6310b(C0470a aVar) {
        if (aVar.mo6381f() == C0472c.NULL) {
            aVar.mo6385j();
            return null;
        }
        try {
            String h = aVar.mo6383h();
            if (!"null".equals(h)) {
                return new URI(h);
            }
            return null;
        } catch (URISyntaxException e) {
            throw new C0494x((Throwable) e);
        }
    }

    /* renamed from: a */
    public void mo6309a(C0473d dVar, URI uri) {
        dVar.mo6400b(uri == null ? null : uri.toASCIIString());
    }
}
