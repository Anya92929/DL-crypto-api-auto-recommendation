package org.p004a.p005a.p025g.p027b;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Locale;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.p004a.p005a.C0240ab;
import org.p004a.p005a.C0344e;
import org.p004a.p005a.C0565n;
import org.p004a.p005a.C0568q;
import org.p004a.p005a.C0570s;
import org.p004a.p005a.p007b.C0269d;
import org.p004a.p005a.p007b.C0293m;
import org.p004a.p005a.p007b.p008a.C0249a;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p007b.p010c.C0261h;
import org.p004a.p005a.p007b.p010c.C0262i;
import org.p004a.p005a.p007b.p010c.C0265l;
import org.p004a.p005a.p007b.p010c.C0266m;
import org.p004a.p005a.p007b.p011d.C0270a;
import org.p004a.p005a.p007b.p012e.C0284d;
import org.p004a.p005a.p036l.C0553e;

/* renamed from: org.a.a.g.b.m */
public final class C0428m implements C0293m {

    /* renamed from: b */
    private static final String[] f373b = {"GET", "HEAD"};

    /* renamed from: a */
    private final Log f374a = LogFactory.getLog(getClass());

    static {
        new C0428m();
    }

    /* renamed from: a */
    private static URI m684a(String str) {
        try {
            C0284d dVar = new C0284d(new URI(str).normalize());
            String c = dVar.mo4926c();
            if (c != null) {
                dVar.mo4927c(c.toLowerCase(Locale.US));
            }
            if (C0250b.m96a((CharSequence) dVar.mo4928d())) {
                dVar.mo4929d("/");
            }
            return dVar.mo4921a();
        } catch (URISyntaxException e) {
            throw new C0240ab("Invalid redirect URI: " + str, e);
        }
    }

    /* renamed from: b */
    private static boolean m685b(String str) {
        String[] strArr = f373b;
        for (int i = 0; i < 2; i++) {
            if (strArr[i].equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    private URI m686c(C0568q qVar, C0570s sVar, C0553e eVar) {
        URI uri;
        C0250b.m84a((Object) qVar, "HTTP request");
        C0250b.m84a((Object) sVar, "HTTP response");
        C0250b.m84a((Object) eVar, "HTTP context");
        C0270a a = C0270a.m151a(eVar);
        C0344e c = sVar.mo5326c("location");
        if (c == null) {
            throw new C0240ab("Received redirect response " + sVar.mo5345a() + " but no location header");
        }
        String d = c.mo5041d();
        if (this.f374a.isDebugEnabled()) {
            this.f374a.debug("Redirect requested to location '" + d + "'");
        }
        C0249a i = a.mo4916i();
        URI a2 = m684a(d);
        try {
            if (a2.isAbsolute()) {
                uri = a2;
            } else if (!i.mo4876b()) {
                throw new C0240ab("Relative redirect location '" + a2 + "' not allowed");
            } else {
                C0565n k = a.mo5410k();
                C0266m.m145a((Object) k, "Target host");
                uri = C0250b.m88a(C0250b.m89a(new URI(qVar.mo4902g().mo4865c()), k, false), a2);
            }
            C0436u uVar = (C0436u) a.mo5221a("http.protocol.redirect-locations");
            if (uVar == null) {
                uVar = new C0436u();
                eVar.mo5223a("http.protocol.redirect-locations", uVar);
            }
            if (i.mo4877c() || !uVar.mo5202a(uri)) {
                uVar.mo5204b(uri);
                return uri;
            }
            throw new C0269d("Circular redirect to '" + uri + "'");
        } catch (URISyntaxException e) {
            throw new C0240ab(e.getMessage(), e);
        }
    }

    /* renamed from: a */
    public final boolean mo4937a(C0568q qVar, C0570s sVar, C0553e eVar) {
        C0250b.m84a((Object) qVar, "HTTP request");
        C0250b.m84a((Object) sVar, "HTTP response");
        int b = sVar.mo5345a().mo4867b();
        String a = qVar.mo4902g().mo4863a();
        C0344e c = sVar.mo5326c("location");
        switch (b) {
            case 301:
            case 307:
                return m685b(a);
            case 302:
                return m685b(a) && c != null;
            case 303:
                return true;
            default:
                return false;
        }
    }

    /* renamed from: b */
    public final C0265l mo4938b(C0568q qVar, C0570s sVar, C0553e eVar) {
        URI c = m686c(qVar, sVar, eVar);
        String a = qVar.mo4902g().mo4863a();
        return a.equalsIgnoreCase("HEAD") ? new C0262i(c) : a.equalsIgnoreCase("GET") ? new C0261h(c) : sVar.mo5345a().mo4867b() == 307 ? C0266m.m144a(qVar).mo4907a(c).mo4906a() : new C0261h(c);
    }
}
