package org.p004a.p005a.p025g.p026a;

import java.util.Locale;
import java.util.Map;
import java.util.Queue;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.p004a.p005a.C0344e;
import org.p004a.p005a.C0565n;
import org.p004a.p005a.C0570s;
import org.p004a.p005a.p006a.C0221b;
import org.p004a.p005a.p006a.C0222c;
import org.p004a.p005a.p006a.C0228i;
import org.p004a.p005a.p006a.C0235p;
import org.p004a.p005a.p007b.C0253c;
import org.p004a.p005a.p036l.C0553e;

/* renamed from: org.a.a.g.a.i */
public class C0397i {

    /* renamed from: a */
    private final Log f274a;

    public C0397i() {
        this((Log) null);
    }

    public C0397i(Log log) {
        this.f274a = log == null ? LogFactory.getLog(getClass()) : log;
    }

    /* renamed from: a */
    public final boolean mo5148a(C0565n nVar, C0570s sVar, C0253c cVar, C0228i iVar, C0553e eVar) {
        if (cVar.mo4886a(nVar, sVar, eVar)) {
            this.f274a.debug("Authentication required");
            if (iVar.mo4827b() == C0221b.SUCCESS) {
                cVar.mo4888b(nVar, iVar.mo4828c(), eVar);
            }
            return true;
        }
        switch (iVar.mo4827b()) {
            case CHALLENGED:
            case HANDSHAKE:
                this.f274a.debug("Authentication succeeded");
                iVar.mo4825a(C0221b.SUCCESS);
                cVar.mo4885a(nVar, iVar.mo4828c(), eVar);
                break;
            case SUCCESS:
                break;
            default:
                iVar.mo4825a(C0221b.UNCHALLENGED);
                break;
        }
        return false;
    }

    /* renamed from: b */
    public final boolean mo5149b(C0565n nVar, C0570s sVar, C0253c cVar, C0228i iVar, C0553e eVar) {
        try {
            if (this.f274a.isDebugEnabled()) {
                this.f274a.debug(nVar.mo5445d() + " requested authentication");
            }
            Map b = cVar.mo4887b(nVar, sVar, eVar);
            if (b.isEmpty()) {
                this.f274a.debug("Response contains no authentication challenges");
                return false;
            }
            C0222c c = iVar.mo4828c();
            switch (iVar.mo4827b()) {
                case CHALLENGED:
                case HANDSHAKE:
                    if (c == null) {
                        this.f274a.debug("Auth scheme is null");
                        cVar.mo4888b(nVar, (C0222c) null, eVar);
                        iVar.mo4823a();
                        iVar.mo4825a(C0221b.FAILURE);
                        return false;
                    }
                    break;
                case SUCCESS:
                    iVar.mo4823a();
                    break;
                case FAILURE:
                    return false;
                case UNCHALLENGED:
                    break;
            }
            if (c != null) {
                C0344e eVar2 = (C0344e) b.get(c.mo4808a().toLowerCase(Locale.US));
                if (eVar2 != null) {
                    this.f274a.debug("Authorization challenge processed");
                    c.mo4810a(eVar2);
                    if (c.mo4813d()) {
                        this.f274a.debug("Authentication failed");
                        cVar.mo4888b(nVar, iVar.mo4828c(), eVar);
                        iVar.mo4823a();
                        iVar.mo4825a(C0221b.FAILURE);
                        return false;
                    }
                    iVar.mo4825a(C0221b.HANDSHAKE);
                    return true;
                }
                iVar.mo4823a();
            }
            Queue a = cVar.mo4884a(b, nVar, sVar, eVar);
            if (a == null || a.isEmpty()) {
                return false;
            }
            if (this.f274a.isDebugEnabled()) {
                this.f274a.debug("Selected authentication options: " + a);
            }
            iVar.mo4825a(C0221b.CHALLENGED);
            iVar.mo4824a(a);
            return true;
        } catch (C0235p e) {
            if (this.f274a.isWarnEnabled()) {
                this.f274a.warn("Malformed challenge: " + e.getMessage());
            }
            iVar.mo4823a();
            return false;
        }
    }
}
