package org.p004a.p005a.p025g.p027b;

import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.UndeclaredThrowableException;
import java.net.URI;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.p004a.p005a.C0565n;
import org.p004a.p005a.C0568q;
import org.p004a.p005a.C0570s;
import org.p004a.p005a.p007b.C0280e;
import org.p004a.p005a.p007b.C0288h;
import org.p004a.p005a.p007b.C0295o;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p007b.p010c.C0258e;
import org.p004a.p005a.p007b.p010c.C0265l;
import org.p004a.p005a.p036l.C0553e;

/* renamed from: org.a.a.g.b.h */
public abstract class C0423h implements Closeable, C0288h {

    /* renamed from: a */
    private final Log f368a = LogFactory.getLog(getClass());

    /* renamed from: a */
    private Object m674a(C0565n nVar, C0568q qVar, C0295o oVar, C0553e eVar) {
        C0250b.m84a((Object) oVar, "Response handler");
        C0258e a = mo5185a(nVar, qVar, eVar);
        try {
            Object a2 = oVar.mo4940a(a);
            C0250b.m94a(a.mo5347b());
            return a2;
        } catch (Exception e) {
            try {
                C0250b.m94a(a.mo5347b());
            } catch (Exception e2) {
                this.f368a.warn("Error consuming content after an exception.", e2);
            }
            if (e instanceof RuntimeException) {
                throw ((RuntimeException) e);
            } else if (e instanceof IOException) {
                throw ((IOException) e);
            } else {
                throw new UndeclaredThrowableException(e);
            }
        }
    }

    /* renamed from: b */
    private static C0565n m675b(C0265l lVar) {
        C0565n nVar = null;
        URI i = lVar.mo4903i();
        if (!i.isAbsolute() || (nVar = C0250b.m103b(i)) != null) {
            return nVar;
        }
        throw new C0280e("URI does not specify a valid host name: " + i);
    }

    /* renamed from: a */
    public final Object mo4935a(C0265l lVar, C0295o oVar) {
        return m674a(m675b(lVar), lVar, oVar, (C0553e) null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract C0258e mo5185a(C0565n nVar, C0568q qVar, C0553e eVar);

    /* renamed from: a */
    public final /* synthetic */ C0570s mo5198a(C0265l lVar) {
        C0250b.m84a((Object) lVar, "HTTP request");
        return mo5185a(m675b(lVar), lVar, (C0553e) null);
    }
}
