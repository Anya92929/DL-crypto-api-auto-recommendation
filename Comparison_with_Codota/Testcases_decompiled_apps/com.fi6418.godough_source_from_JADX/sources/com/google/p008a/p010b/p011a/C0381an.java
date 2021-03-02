package com.google.p008a.p010b.p011a;

import com.google.p008a.C0363al;
import com.google.p008a.p013d.C0470a;
import com.google.p008a.p013d.C0472c;
import com.google.p008a.p013d.C0473d;
import java.util.UUID;

/* renamed from: com.google.a.b.a.an */
final class C0381an extends C0363al<UUID> {
    C0381an() {
    }

    /* renamed from: a */
    public UUID mo6310b(C0470a aVar) {
        if (aVar.mo6381f() != C0472c.NULL) {
            return UUID.fromString(aVar.mo6383h());
        }
        aVar.mo6385j();
        return null;
    }

    /* renamed from: a */
    public void mo6309a(C0473d dVar, UUID uuid) {
        dVar.mo6400b(uuid == null ? null : uuid.toString());
    }
}
