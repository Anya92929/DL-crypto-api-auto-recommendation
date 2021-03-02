package com.google.p008a.p010b.p011a;

import com.google.p008a.C0353ab;
import com.google.p008a.C0363al;
import com.google.p008a.C0490t;
import com.google.p008a.C0493w;
import com.google.p008a.C0495y;
import com.google.p008a.C0496z;
import com.google.p008a.p010b.C0462v;
import com.google.p008a.p013d.C0470a;
import com.google.p008a.p013d.C0473d;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.google.a.b.a.as */
final class C0386as extends C0363al<C0493w> {
    C0386as() {
    }

    /* renamed from: a */
    public C0493w mo6310b(C0470a aVar) {
        switch (aVar.mo6381f()) {
            case NUMBER:
                return new C0353ab((Number) new C0462v(aVar.mo6383h()));
            case BOOLEAN:
                return new C0353ab(Boolean.valueOf(aVar.mo6384i()));
            case STRING:
                return new C0353ab(aVar.mo6383h());
            case NULL:
                aVar.mo6385j();
                return C0495y.f3650a;
            case BEGIN_ARRAY:
                C0490t tVar = new C0490t();
                aVar.mo6375a();
                while (aVar.mo6380e()) {
                    tVar.mo6532a(mo6310b(aVar));
                }
                aVar.mo6376b();
                return tVar;
            case BEGIN_OBJECT:
                C0496z zVar = new C0496z();
                aVar.mo6377c();
                while (aVar.mo6380e()) {
                    zVar.mo6546a(aVar.mo6382g(), mo6310b(aVar));
                }
                aVar.mo6379d();
                return zVar;
            default:
                throw new IllegalArgumentException();
        }
    }

    /* renamed from: a */
    public void mo6309a(C0473d dVar, C0493w wVar) {
        if (wVar == null || wVar.mo6539j()) {
            dVar.mo6405f();
        } else if (wVar.mo6538i()) {
            C0353ab m = wVar.mo6542m();
            if (m.mo6307p()) {
                dVar.mo6395a(m.mo6296a());
            } else if (m.mo6306o()) {
                dVar.mo6397a(m.mo6303f());
            } else {
                dVar.mo6400b(m.mo6298b());
            }
        } else if (wVar.mo6536g()) {
            dVar.mo6399b();
            Iterator<C0493w> it = wVar.mo6541l().iterator();
            while (it.hasNext()) {
                mo6309a(dVar, it.next());
            }
            dVar.mo6401c();
        } else if (wVar.mo6537h()) {
            dVar.mo6403d();
            for (Map.Entry next : wVar.mo6540k().mo6549o()) {
                dVar.mo6396a((String) next.getKey());
                mo6309a(dVar, (C0493w) next.getValue());
            }
            dVar.mo6404e();
        } else {
            throw new IllegalArgumentException("Couldn't write " + wVar.getClass());
        }
    }
}
