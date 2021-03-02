package org.p004a.p005a.p025g.p027b;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.net.ssl.SSLException;
import org.p004a.p005a.C0548l;
import org.p004a.p005a.C0568q;
import org.p004a.p005a.p007b.C0289i;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p007b.p010c.C0265l;
import org.p004a.p005a.p007b.p011d.C0270a;
import org.p004a.p005a.p036l.C0553e;

/* renamed from: org.a.a.g.b.l */
public final class C0427l implements C0289i {

    /* renamed from: a */
    private final int f370a;

    /* renamed from: b */
    private final boolean f371b;

    /* renamed from: c */
    private final Set f372c;

    static {
        new C0427l();
    }

    public C0427l() {
        this(3, false);
    }

    private C0427l(int i, boolean z) {
        this(3, false, Arrays.asList(new Class[]{InterruptedIOException.class, UnknownHostException.class, ConnectException.class, SSLException.class}));
    }

    private C0427l(int i, boolean z, Collection collection) {
        this.f370a = i;
        this.f371b = z;
        this.f372c = new HashSet();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            this.f372c.add((Class) it.next());
        }
    }

    /* renamed from: a */
    public final boolean mo4936a(IOException iOException, int i, C0553e eVar) {
        C0250b.m84a((Object) iOException, "Exception parameter");
        C0250b.m84a((Object) eVar, "HTTP context");
        if (i > this.f370a) {
            return false;
        }
        if (this.f372c.contains(iOException.getClass())) {
            return false;
        }
        for (Class isInstance : this.f372c) {
            if (isInstance.isInstance(iOException)) {
                return false;
            }
        }
        C0270a a = C0270a.m151a(eVar);
        C0568q qVar = (C0568q) a.mo5408a("http.request", C0568q.class);
        C0568q l = qVar instanceof C0437v ? ((C0437v) qVar).mo5212l() : qVar;
        if ((l instanceof C0265l) && ((C0265l) l).mo4905h()) {
            return false;
        }
        if (!(qVar instanceof C0548l)) {
            return true;
        }
        Boolean bool = (Boolean) a.mo5408a("http.request_sent", Boolean.class);
        return !(bool != null && bool.booleanValue()) || this.f371b;
    }
}
