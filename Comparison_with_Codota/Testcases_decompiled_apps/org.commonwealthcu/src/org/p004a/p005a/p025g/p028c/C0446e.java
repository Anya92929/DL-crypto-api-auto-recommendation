package org.p004a.p005a.p025g.p028c;

import java.net.Socket;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.p004a.p005a.C0565n;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p007b.p010c.C0266m;
import org.p004a.p005a.p014d.C0313c;
import org.p004a.p005a.p014d.C0334h;
import org.p004a.p005a.p014d.C0341o;
import org.p004a.p005a.p014d.p017c.C0316c;
import org.p004a.p005a.p014d.p017c.C0317d;
import org.p004a.p005a.p014d.p017c.C0319f;
import org.p004a.p005a.p014d.p018d.C0322a;
import org.p004a.p005a.p034j.C0544b;
import org.p004a.p005a.p036l.C0553e;

/* renamed from: org.a.a.g.c.e */
public final class C0446e implements C0313c {

    /* renamed from: a */
    private final Log f428a = LogFactory.getLog(getClass());

    /* renamed from: b */
    private C0319f f429b;

    /* renamed from: c */
    private C0334h f430c;

    public C0446e(C0319f fVar) {
        C0250b.m84a((Object) fVar, "Scheme registry");
        this.f429b = fVar;
        this.f430c = new C0454m();
    }

    /* renamed from: a */
    private C0319f m755a(C0553e eVar) {
        C0319f fVar = (C0319f) eVar.mo5221a("http.scheme-registry");
        return fVar == null ? this.f429b : fVar;
    }

    /* renamed from: a */
    private static void m756a(Socket socket, C0544b bVar) {
        boolean z = true;
        C0250b.m84a((Object) bVar, "HTTP parameters");
        socket.setTcpNoDelay(bVar.mo5390a("http.tcp.nodelay", true));
        socket.setSoTimeout(C0250b.m108c(bVar));
        C0250b.m84a((Object) bVar, "HTTP parameters");
        int a = bVar.mo5389a("http.socket.linger", -1);
        if (a >= 0) {
            if (a <= 0) {
                z = false;
            }
            socket.setSoLinger(z, a);
        }
    }

    /* renamed from: a */
    public final C0341o mo4988a() {
        return new C0445d();
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c9 A[SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo4989a(org.p004a.p005a.p014d.C0341o r13, org.p004a.p005a.C0565n r14, java.net.InetAddress r15, org.p004a.p005a.p036l.C0553e r16, org.p004a.p005a.p034j.C0544b r17) {
        /*
            r12 = this;
            java.lang.String r1 = "Connection"
            org.p004a.p005a.p007b.p008a.C0250b.m84a((java.lang.Object) r13, (java.lang.String) r1)
            java.lang.String r1 = "Target host"
            org.p004a.p005a.p007b.p008a.C0250b.m84a((java.lang.Object) r14, (java.lang.String) r1)
            java.lang.String r1 = "HTTP parameters"
            r0 = r17
            org.p004a.p005a.p007b.p008a.C0250b.m84a((java.lang.Object) r0, (java.lang.String) r1)
            boolean r1 = r13.mo5246c()
            if (r1 != 0) goto L_0x009a
            r1 = 1
        L_0x0018:
            java.lang.String r2 = "Connection must not be open"
            org.p004a.p005a.p007b.p010c.C0266m.m146a((boolean) r1, (java.lang.String) r2)
            r0 = r16
            org.a.a.d.c.f r1 = r12.m755a(r0)
            java.lang.String r2 = r14.mo5443c()
            org.a.a.d.c.c r1 = r1.mo5004a((java.lang.String) r2)
            org.a.a.d.c.g r5 = r1.mo4997b()
            java.lang.String r2 = r14.mo5441a()
            org.a.a.d.h r3 = r12.f430c
            java.net.InetAddress[] r6 = r3.mo5017a(r2)
            int r2 = r14.mo5442b()
            int r7 = r1.mo4996a(r2)
            r1 = 0
        L_0x0042:
            int r2 = r6.length
            if (r1 >= r2) goto L_0x0099
            r3 = r6[r1]
            int r2 = r6.length
            int r2 = r2 + -1
            if (r1 != r2) goto L_0x009d
            r2 = 1
        L_0x004d:
            r0 = r17
            java.net.Socket r4 = r5.mo4993a((org.p004a.p005a.p034j.C0544b) r0)
            r13.mo5034a((java.net.Socket) r4, (org.p004a.p005a.C0565n) r14)
            org.a.a.d.k r8 = new org.a.a.d.k
            r8.<init>(r14, r3, r7)
            r3 = 0
            if (r15 == 0) goto L_0x0064
            java.net.InetSocketAddress r3 = new java.net.InetSocketAddress
            r9 = 0
            r3.<init>(r15, r9)
        L_0x0064:
            org.apache.commons.logging.Log r9 = r12.f428a
            boolean r9 = r9.isDebugEnabled()
            if (r9 == 0) goto L_0x0080
            org.apache.commons.logging.Log r9 = r12.f428a
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r11 = "Connecting to "
            r10.<init>(r11)
            java.lang.StringBuilder r10 = r10.append(r8)
            java.lang.String r10 = r10.toString()
            r9.debug(r10)
        L_0x0080:
            r0 = r17
            java.net.Socket r3 = r5.mo4992a(r4, r8, r3, r0)     // Catch:{ ConnectException -> 0x009f, e -> 0x00a3 }
            if (r4 == r3) goto L_0x00cd
            r13.mo5034a((java.net.Socket) r3, (org.p004a.p005a.C0565n) r14)     // Catch:{ ConnectException -> 0x009f, e -> 0x00a3 }
        L_0x008b:
            r0 = r17
            m756a(r3, r0)     // Catch:{ ConnectException -> 0x009f, e -> 0x00a3 }
            boolean r3 = r5.mo4994a((java.net.Socket) r3)     // Catch:{ ConnectException -> 0x009f, e -> 0x00a3 }
            r0 = r17
            r13.mo5036a((boolean) r3, (org.p004a.p005a.p034j.C0544b) r0)     // Catch:{ ConnectException -> 0x009f, e -> 0x00a3 }
        L_0x0099:
            return
        L_0x009a:
            r1 = 0
            goto L_0x0018
        L_0x009d:
            r2 = 0
            goto L_0x004d
        L_0x009f:
            r3 = move-exception
            if (r2 == 0) goto L_0x00a7
            throw r3
        L_0x00a3:
            r3 = move-exception
            if (r2 == 0) goto L_0x00a7
            throw r3
        L_0x00a7:
            org.apache.commons.logging.Log r2 = r12.f428a
            boolean r2 = r2.isDebugEnabled()
            if (r2 == 0) goto L_0x00c9
            org.apache.commons.logging.Log r2 = r12.f428a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Connect to "
            r3.<init>(r4)
            java.lang.StringBuilder r3 = r3.append(r8)
            java.lang.String r4 = " timed out. Connection will be retried using another IP address"
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.debug(r3)
        L_0x00c9:
            int r1 = r1 + 1
            goto L_0x0042
        L_0x00cd:
            r3 = r4
            goto L_0x008b
        */
        throw new UnsupportedOperationException("Method not decompiled: org.p004a.p005a.p025g.p028c.C0446e.mo4989a(org.a.a.d.o, org.a.a.n, java.net.InetAddress, org.a.a.l.e, org.a.a.j.b):void");
    }

    /* renamed from: a */
    public final void mo4990a(C0341o oVar, C0565n nVar, C0553e eVar, C0544b bVar) {
        C0250b.m84a((Object) oVar, "Connection");
        C0250b.m84a((Object) nVar, "Target host");
        C0250b.m84a((Object) bVar, "Parameters");
        C0266m.m146a(oVar.mo5246c(), "Connection must be open");
        C0316c a = m755a(eVar).mo5004a(nVar.mo5443c());
        C0266m.m146a(a.mo4997b() instanceof C0322a, "Socket factory must implement SchemeLayeredSocketFactory");
        C0317d dVar = (C0317d) a.mo4997b();
        Socket b = dVar.mo5003b(oVar.mo5038i(), nVar.mo5441a(), a.mo4996a(nVar.mo5442b()));
        m756a(b, bVar);
        oVar.mo5035a(b, nVar, dVar.mo4994a(b), bVar);
    }
}
