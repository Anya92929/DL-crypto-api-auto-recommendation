package org.p004a.p005a.p007b.p011d;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.p004a.p005a.C0344e;
import org.p004a.p005a.C0561m;
import org.p004a.p005a.C0565n;
import org.p004a.p005a.C0568q;
import org.p004a.p005a.C0569r;
import org.p004a.p005a.p007b.C0286f;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p007b.p010c.C0265l;
import org.p004a.p005a.p013c.C0298a;
import org.p004a.p005a.p014d.p016b.C0309e;
import org.p004a.p005a.p021e.C0346b;
import org.p004a.p005a.p021e.C0349e;
import org.p004a.p005a.p021e.C0352h;
import org.p004a.p005a.p021e.C0354j;
import org.p004a.p005a.p021e.C0359o;
import org.p004a.p005a.p036l.C0553e;

/* renamed from: org.a.a.b.d.b */
public final class C0271b implements C0569r {

    /* renamed from: a */
    private final Log f97a = LogFactory.getLog(getClass());

    /* renamed from: a */
    public final void mo4917a(C0568q qVar, C0553e eVar) {
        URI uri;
        C0344e b;
        C0250b.m84a((Object) qVar, "HTTP request");
        C0250b.m84a((Object) eVar, "HTTP context");
        if (!qVar.mo4902g().mo4863a().equalsIgnoreCase("CONNECT")) {
            C0270a a = C0270a.m151a(eVar);
            C0286f b2 = a.mo4909b();
            if (b2 == null) {
                this.f97a.debug("Cookie store not specified in HTTP context");
                return;
            }
            C0298a c = a.mo4910c();
            if (c == null) {
                this.f97a.debug("CookieSpec registry not specified in HTTP context");
                return;
            }
            C0565n k = a.mo5410k();
            if (k == null) {
                this.f97a.debug("Target host not set in the context");
                return;
            }
            C0309e a2 = a.mo4908a();
            if (a2 == null) {
                this.f97a.debug("Connection route not set in the context");
                return;
            }
            String a3 = a.mo4916i().mo4875a();
            String str = a3 == null ? "best-match" : a3;
            if (this.f97a.isDebugEnabled()) {
                this.f97a.debug("CookieSpec selected: " + str);
            }
            if (qVar instanceof C0265l) {
                uri = ((C0265l) qVar).mo4903i();
            } else {
                try {
                    uri = new URI(qVar.mo4902g().mo4865c());
                } catch (URISyntaxException e) {
                    uri = null;
                }
            }
            String path = uri != null ? uri.getPath() : null;
            String a4 = k.mo5441a();
            int b3 = k.mo5442b();
            if (b3 < 0) {
                b3 = a2.mo4964a().mo5442b();
            }
            if (b3 < 0) {
                b3 = 0;
            }
            if (C0250b.m96a((CharSequence) path)) {
                path = "/";
            }
            C0349e eVar2 = new C0349e(a4, b3, path, a2.mo4973g());
            C0354j jVar = (C0354j) c.mo4816a(str);
            if (jVar == null) {
                throw new C0561m("Unsupported cookie policy: " + str);
            }
            C0352h a5 = jVar.mo5070a(a);
            ArrayList<C0346b> arrayList = new ArrayList<>(b2.mo4932a());
            ArrayList<C0346b> arrayList2 = new ArrayList<>();
            Date date = new Date();
            for (C0346b bVar : arrayList) {
                if (!bVar.mo5046a(date)) {
                    if (a5.mo5068b(bVar, eVar2)) {
                        if (this.f97a.isDebugEnabled()) {
                            this.f97a.debug("Cookie " + bVar + " match " + eVar2);
                        }
                        arrayList2.add(bVar);
                    }
                } else if (this.f97a.isDebugEnabled()) {
                    this.f97a.debug("Cookie " + bVar + " expired");
                }
            }
            if (!arrayList2.isEmpty()) {
                for (C0344e a6 : a5.mo5064a(arrayList2)) {
                    qVar.mo5320a(a6);
                }
            }
            int a7 = a5.mo5063a();
            if (a7 > 0) {
                boolean z = false;
                for (C0346b bVar2 : arrayList2) {
                    z = (a7 != bVar2.mo5052g() || !(bVar2 instanceof C0359o)) ? true : z;
                }
                if (z && (b = a5.mo5067b()) != null) {
                    qVar.mo5320a(b);
                }
            }
            eVar.mo5223a("http.cookie-spec", a5);
            eVar.mo5223a("http.cookie-origin", eVar2);
        }
    }
}
