package org.p004a.p005a.p007b.p011d;

import java.util.Queue;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.p004a.p005a.C0344e;
import org.p004a.p005a.C0568q;
import org.p004a.p005a.C0569r;
import org.p004a.p005a.p006a.C0220a;
import org.p004a.p005a.p006a.C0222c;
import org.p004a.p005a.p006a.C0228i;
import org.p004a.p005a.p006a.C0229j;
import org.p004a.p005a.p006a.C0232m;
import org.p004a.p005a.p006a.C0233n;
import org.p004a.p005a.p007b.p010c.C0266m;
import org.p004a.p005a.p036l.C0553e;

/* renamed from: org.a.a.b.d.d */
abstract class C0273d implements C0569r {

    /* renamed from: a */
    final Log f99a = LogFactory.getLog(getClass());

    /* renamed from: a */
    private static C0344e m165a(C0222c cVar, C0233n nVar, C0568q qVar, C0553e eVar) {
        C0266m.m145a((Object) cVar, "Auth scheme");
        return cVar instanceof C0232m ? ((C0232m) cVar).mo4836a(nVar, qVar, eVar) : cVar.mo4809a(nVar, qVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo4918a(C0228i iVar, C0568q qVar, C0553e eVar) {
        C0222c c = iVar.mo4828c();
        C0233n d = iVar.mo4829d();
        switch (C0274e.f100a[iVar.mo4827b().ordinal()]) {
            case 1:
                return;
            case 2:
                C0266m.m145a((Object) c, "Auth scheme");
                if (c.mo4812c()) {
                    return;
                }
                break;
            case 3:
                Queue e = iVar.mo4830e();
                if (e == null) {
                    C0266m.m145a((Object) c, "Auth scheme");
                    break;
                } else {
                    while (!e.isEmpty()) {
                        C0220a aVar = (C0220a) e.remove();
                        C0222c a = aVar.mo4805a();
                        C0233n b = aVar.mo4806b();
                        iVar.mo4826a(a, b);
                        if (this.f99a.isDebugEnabled()) {
                            this.f99a.debug("Generating response to an authentication challenge using " + a.mo4808a() + " scheme");
                        }
                        try {
                            qVar.mo5320a(m165a(a, b, qVar, eVar));
                            return;
                        } catch (C0229j e2) {
                            if (this.f99a.isWarnEnabled()) {
                                this.f99a.warn(a + " authentication error: " + e2.getMessage());
                            }
                        }
                    }
                    return;
                }
        }
        if (c != null) {
            try {
                qVar.mo5320a(m165a(c, d, qVar, eVar));
            } catch (C0229j e3) {
                if (this.f99a.isErrorEnabled()) {
                    this.f99a.error(c + " authentication error: " + e3.getMessage());
                }
            }
        }
    }
}
