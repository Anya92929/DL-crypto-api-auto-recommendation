package org.p004a.p005a.p025g.p028c;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.p004a.p005a.C0344e;
import org.p004a.p005a.C0565n;
import org.p004a.p005a.C0568q;
import org.p004a.p005a.C0570s;
import org.p004a.p005a.C0571t;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p014d.C0340n;
import org.p004a.p005a.p014d.C0341o;
import org.p004a.p005a.p025g.C0498f;
import org.p004a.p005a.p032h.C0516c;
import org.p004a.p005a.p032h.C0519f;
import org.p004a.p005a.p032h.C0520g;
import org.p004a.p005a.p033i.C0540s;
import org.p004a.p005a.p034j.C0544b;
import org.p004a.p005a.p036l.C0553e;

/* renamed from: org.a.a.g.c.d */
public final class C0445d extends C0498f implements C0340n, C0341o, C0553e {

    /* renamed from: a */
    private final Log f421a = LogFactory.getLog(getClass());

    /* renamed from: b */
    private final Log f422b = LogFactory.getLog("org.apache.http.headers");

    /* renamed from: c */
    private final Log f423c = LogFactory.getLog("org.apache.http.wire");

    /* renamed from: d */
    private volatile Socket f424d;

    /* renamed from: e */
    private boolean f425e;

    /* renamed from: f */
    private volatile boolean f426f;

    /* renamed from: g */
    private final Map f427g = new HashMap();

    /* renamed from: a */
    public final Object mo5221a(String str) {
        return this.f427g.get(str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final C0516c mo5129a(C0519f fVar, C0571t tVar, C0544b bVar) {
        return new C0447f(fVar, (C0540s) null, tVar, bVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final C0519f mo5222a(Socket socket, int i, C0544b bVar) {
        if (i <= 0) {
            i = 8192;
        }
        C0519f a = super.mo5222a(socket, i, bVar);
        return this.f423c.isDebugEnabled() ? new C0451j(a, new C0455n(this.f423c), C0250b.m112e(bVar)) : a;
    }

    /* renamed from: a */
    public final C0570s mo5130a() {
        C0570s a = super.mo5130a();
        if (this.f421a.isDebugEnabled()) {
            this.f421a.debug("Receiving response: " + a.mo5345a());
        }
        if (this.f422b.isDebugEnabled()) {
            this.f422b.debug("<< " + a.mo5345a().toString());
            C0344e[] d = a.mo5328d();
            int length = d.length;
            for (int i = 0; i < length; i++) {
                this.f422b.debug("<< " + d[i].toString());
            }
        }
        return a;
    }

    /* renamed from: a */
    public final void mo5223a(String str, Object obj) {
        this.f427g.put(str, obj);
    }

    /* renamed from: a */
    public final void mo5034a(Socket socket, C0565n nVar) {
        mo5276l();
        this.f424d = socket;
        if (this.f426f) {
            socket.close();
            throw new InterruptedIOException("Connection already shutdown");
        }
    }

    /* renamed from: a */
    public final void mo5035a(Socket socket, C0565n nVar, boolean z, C0544b bVar) {
        mo5138j();
        C0250b.m84a((Object) nVar, "Target host");
        C0250b.m84a((Object) bVar, "Parameters");
        if (socket != null) {
            this.f424d = socket;
            mo5275a(socket, bVar);
        }
        this.f425e = z;
    }

    /* renamed from: a */
    public final void mo5133a(C0568q qVar) {
        if (this.f421a.isDebugEnabled()) {
            this.f421a.debug("Sending request: " + qVar.mo4902g());
        }
        super.mo5133a(qVar);
        if (this.f422b.isDebugEnabled()) {
            this.f422b.debug(">> " + qVar.mo4902g().toString());
            C0344e[] d = qVar.mo5328d();
            int length = d.length;
            for (int i = 0; i < length; i++) {
                this.f422b.debug(">> " + d[i].toString());
            }
        }
    }

    /* renamed from: a */
    public final void mo5036a(boolean z, C0544b bVar) {
        C0250b.m84a((Object) bVar, "Parameters");
        mo5276l();
        this.f425e = z;
        mo5275a(this.f424d, bVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final C0520g mo5224b(Socket socket, int i, C0544b bVar) {
        if (i <= 0) {
            i = 8192;
        }
        C0520g b = super.mo5224b(socket, i, bVar);
        return this.f423c.isDebugEnabled() ? new C0452k(b, new C0455n(this.f423c), C0250b.m112e(bVar)) : b;
    }

    public final void close() {
        try {
            super.close();
            if (this.f421a.isDebugEnabled()) {
                this.f421a.debug("Connection " + this + " closed");
            }
        } catch (IOException e) {
            this.f421a.debug("I/O error closing connection", e);
        }
    }

    /* renamed from: e */
    public final void mo5226e() {
        this.f426f = true;
        try {
            super.mo5226e();
            if (this.f421a.isDebugEnabled()) {
                this.f421a.debug("Connection " + this + " shut down");
            }
            Socket socket = this.f424d;
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            this.f421a.debug("I/O error shutting down connection", e);
        }
    }

    /* renamed from: h */
    public final boolean mo5037h() {
        return this.f425e;
    }

    /* renamed from: i */
    public final Socket mo5038i() {
        return this.f424d;
    }

    /* renamed from: m */
    public final SSLSession mo5033m() {
        if (this.f424d instanceof SSLSocket) {
            return ((SSLSocket) this.f424d).getSession();
        }
        return null;
    }
}
