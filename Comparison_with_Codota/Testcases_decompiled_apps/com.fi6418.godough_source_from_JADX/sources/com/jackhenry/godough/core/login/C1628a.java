package com.jackhenry.godough.core.login;

import com.jackhenry.godough.core.C1758o;
import com.jackhenry.godough.core.C1759p;
import com.jackhenry.godough.core.model.MFA;
import com.jackhenry.godough.core.model.Redirect;
import com.jackhenry.godough.core.p038e.C1588q;
import com.jackhenry.godough.p027b.C1392g;
import com.jackhenry.godough.p027b.C1394i;
import com.jackhenry.godough.p027b.C1395j;
import com.jackhenry.godough.p043d.C1945a;

/* renamed from: com.jackhenry.godough.core.login.a */
public abstract class C1628a<T> extends C1758o<Void, T> {
    public C1628a(C1759p<T> pVar) {
        super(pVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public T mo9592a(Void... voidArr) {
        T t;
        try {
            t = mo9943b(voidArr);
        } catch (C1392g e) {
            C1945a.m6996a("Getting redirect");
            if (Redirect.RedirectType.getEnum(e.getMessage().toUpperCase()) == Redirect.RedirectType.MFA) {
                MFA e2 = new C1689cg().mo10007e();
                if (e2.isChallenged() || e2.isCollect() || e2.isCollectPhone()) {
                    C1394i iVar = new C1394i(e.getMessage(), e.mo9435b());
                    iVar.mo9437a(e2);
                    throw iVar;
                }
                t = null;
            } else if (Redirect.RedirectType.getEnum(e.getMessage().toUpperCase()) == Redirect.RedirectType.CREDENTIALS) {
                C1689cg cgVar = new C1689cg();
                C1945a.m6996a("Handling Password Change redirect");
                C1395j jVar = new C1395j(e.getMessage(), e.mo9435b());
                jVar.mo9439a(cgVar.mo10006d());
                throw jVar;
            } else {
                throw e;
            }
        }
        if (t != null && !t.equals("")) {
            return t;
        }
        C1588q.m6215a();
        return null;
    }

    /* renamed from: b */
    public abstract T mo9943b(Void... voidArr);
}
