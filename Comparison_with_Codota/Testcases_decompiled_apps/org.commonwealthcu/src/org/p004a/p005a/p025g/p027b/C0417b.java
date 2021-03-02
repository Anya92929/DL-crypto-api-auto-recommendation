package org.p004a.p005a.p025g.p027b;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.p004a.p005a.C0301d;
import org.p004a.p005a.C0344e;
import org.p004a.p005a.C0565n;
import org.p004a.p005a.C0570s;
import org.p004a.p005a.p006a.C0220a;
import org.p004a.p005a.p006a.C0222c;
import org.p004a.p005a.p006a.C0224e;
import org.p004a.p005a.p006a.C0227h;
import org.p004a.p005a.p006a.C0233n;
import org.p004a.p005a.p006a.C0235p;
import org.p004a.p005a.p007b.C0248a;
import org.p004a.p005a.p007b.C0253c;
import org.p004a.p005a.p007b.C0287g;
import org.p004a.p005a.p007b.p008a.C0249a;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p007b.p011d.C0270a;
import org.p004a.p005a.p013c.C0298a;
import org.p004a.p005a.p036l.C0552d;
import org.p004a.p005a.p036l.C0553e;
import org.p004a.p005a.p037m.C0563b;

/* renamed from: org.a.a.g.b.b */
abstract class C0417b implements C0253c {

    /* renamed from: b */
    private static final List f356b = Collections.unmodifiableList(Arrays.asList(new String[]{"negotiate", "Kerberos", "NTLM", "Digest", "Basic"}));

    /* renamed from: a */
    private final Log f357a = LogFactory.getLog(getClass());

    /* renamed from: c */
    private final int f358c;

    /* renamed from: d */
    private final String f359d;

    C0417b(int i, String str) {
        this.f358c = i;
        this.f359d = str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract Collection mo5192a(C0249a aVar);

    /* renamed from: a */
    public Queue mo4884a(Map map, C0565n nVar, C0570s sVar, C0553e eVar) {
        C0250b.m84a((Object) map, "Map of auth challenges");
        C0250b.m84a((Object) nVar, "Host");
        C0250b.m84a((Object) sVar, "HTTP response");
        C0250b.m84a((Object) eVar, "HTTP context");
        C0270a a = C0270a.m151a(eVar);
        LinkedList linkedList = new LinkedList();
        C0298a d = a.mo4911d();
        if (d == null) {
            this.f357a.debug("Auth scheme registry not set in the context");
            return linkedList;
        }
        C0287g e = a.mo4912e();
        if (e == null) {
            this.f357a.debug("Credentials provider not set in the context");
            return linkedList;
        }
        Collection<String> a2 = mo5192a(a.mo4916i());
        if (a2 == null) {
            a2 = f356b;
        }
        if (this.f357a.isDebugEnabled()) {
            this.f357a.debug("Authentication schemes in the order of preference: " + a2);
        }
        for (String str : a2) {
            C0344e eVar2 = (C0344e) map.get(str.toLowerCase(Locale.US));
            if (eVar2 != null) {
                C0224e eVar3 = (C0224e) d.mo4816a(str);
                if (eVar3 != null) {
                    C0222c a3 = eVar3.mo4815a(eVar);
                    a3.mo4810a(eVar2);
                    C0233n a4 = e.mo4934a(new C0227h(nVar.mo5441a(), nVar.mo5442b(), a3.mo4811b(), a3.mo4808a()));
                    if (a4 != null) {
                        linkedList.add(new C0220a(a3, a4));
                    }
                } else if (this.f357a.isWarnEnabled()) {
                    this.f357a.warn("Authentication scheme " + str + " not supported");
                }
            } else if (this.f357a.isDebugEnabled()) {
                this.f357a.debug("Challenge for " + str + " authentication scheme not available");
            }
        }
        return linkedList;
    }

    /* renamed from: a */
    public void mo4885a(C0565n nVar, C0222c cVar, C0553e eVar) {
        boolean z = false;
        C0250b.m84a((Object) nVar, "Host");
        C0250b.m84a((Object) cVar, "Auth scheme");
        C0250b.m84a((Object) eVar, "HTTP context");
        C0270a a = C0270a.m151a(eVar);
        if (cVar != null && cVar.mo4813d()) {
            String a2 = cVar.mo4808a();
            if (a2.equalsIgnoreCase("Basic") || a2.equalsIgnoreCase("Digest")) {
                z = true;
            }
        }
        if (z) {
            C0248a f = a.mo4913f();
            if (f == null) {
                f = new C0418c();
                a.mo5223a("http.auth.auth-cache", (Object) f);
            }
            if (this.f357a.isDebugEnabled()) {
                this.f357a.debug("Caching '" + cVar.mo4808a() + "' auth scheme for " + nVar);
            }
            f.mo4873a(nVar, cVar);
        }
    }

    /* renamed from: a */
    public boolean mo4886a(C0565n nVar, C0570s sVar, C0553e eVar) {
        C0250b.m84a((Object) sVar, "HTTP response");
        return sVar.mo5345a().mo4867b() == this.f358c;
    }

    /* renamed from: b */
    public Map mo4887b(C0565n nVar, C0570s sVar, C0553e eVar) {
        C0563b bVar;
        int i;
        C0250b.m84a((Object) sVar, "HTTP response");
        C0344e[] b = sVar.mo5325b(this.f359d);
        HashMap hashMap = new HashMap(b.length);
        for (C0344e eVar2 : b) {
            if (eVar2 instanceof C0301d) {
                bVar = ((C0301d) eVar2).mo4949a();
                i = ((C0301d) eVar2).mo4950b();
            } else {
                String d = eVar2.mo5041d();
                if (d == null) {
                    throw new C0235p("Header value is null");
                }
                C0563b bVar2 = new C0563b(d.length());
                bVar2.mo5428a(d);
                bVar = bVar2;
                i = 0;
            }
            while (i < bVar.mo5435c() && C0552d.m1151a(bVar.mo5423a(i))) {
                i++;
            }
            int i2 = i;
            while (i2 < bVar.mo5435c() && !C0552d.m1151a(bVar.mo5423a(i2))) {
                i2++;
            }
            hashMap.put(bVar.mo5425a(i, i2).toLowerCase(Locale.US), eVar2);
        }
        return hashMap;
    }

    /* renamed from: b */
    public void mo4888b(C0565n nVar, C0222c cVar, C0553e eVar) {
        C0250b.m84a((Object) nVar, "Host");
        C0250b.m84a((Object) eVar, "HTTP context");
        C0248a f = C0270a.m151a(eVar).mo4913f();
        if (f != null) {
            if (this.f357a.isDebugEnabled()) {
                this.f357a.debug("Clearing cached auth scheme for " + nVar);
            }
            f.mo4874b(nVar);
        }
    }
}
