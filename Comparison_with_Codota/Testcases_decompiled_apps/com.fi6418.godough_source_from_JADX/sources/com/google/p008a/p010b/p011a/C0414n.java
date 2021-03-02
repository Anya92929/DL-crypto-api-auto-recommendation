package com.google.p008a.p010b.p011a;

import com.google.p008a.C0363al;
import com.google.p008a.C0364am;
import com.google.p008a.C0481k;
import com.google.p008a.p010b.C0463w;
import com.google.p008a.p013d.C0470a;
import com.google.p008a.p013d.C0473d;
import java.util.ArrayList;

/* renamed from: com.google.a.b.a.n */
public final class C0414n extends C0363al<Object> {

    /* renamed from: a */
    public static final C0364am f3423a = new C0415o();

    /* renamed from: b */
    private final C0481k f3424b;

    private C0414n(C0481k kVar) {
        this.f3424b = kVar;
    }

    /* synthetic */ C0414n(C0481k kVar, C0415o oVar) {
        this(kVar);
    }

    /* renamed from: a */
    public void mo6309a(C0473d dVar, Object obj) {
        if (obj == null) {
            dVar.mo6405f();
            return;
        }
        C0363al<?> a = this.f3424b.mo6512a(obj.getClass());
        if (a instanceof C0414n) {
            dVar.mo6403d();
            dVar.mo6404e();
            return;
        }
        a.mo6309a(dVar, obj);
    }

    /* renamed from: b */
    public Object mo6310b(C0470a aVar) {
        switch (C0416p.f3425a[aVar.mo6381f().ordinal()]) {
            case 1:
                ArrayList arrayList = new ArrayList();
                aVar.mo6375a();
                while (aVar.mo6380e()) {
                    arrayList.add(mo6310b(aVar));
                }
                aVar.mo6376b();
                return arrayList;
            case 2:
                C0463w wVar = new C0463w();
                aVar.mo6377c();
                while (aVar.mo6380e()) {
                    wVar.put(aVar.mo6382g(), mo6310b(aVar));
                }
                aVar.mo6379d();
                return wVar;
            case 3:
                return aVar.mo6383h();
            case 4:
                return Double.valueOf(aVar.mo6386k());
            case 5:
                return Boolean.valueOf(aVar.mo6384i());
            case 6:
                aVar.mo6385j();
                return null;
            default:
                throw new IllegalStateException();
        }
    }
}
