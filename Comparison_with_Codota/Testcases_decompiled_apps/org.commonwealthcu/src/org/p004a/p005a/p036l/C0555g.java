package org.p004a.p005a.p036l;

import java.io.IOException;
import org.p004a.p005a.C0521i;
import org.p004a.p005a.C0568q;
import org.p004a.p005a.C0569r;
import org.p004a.p005a.C0570s;
import org.p004a.p005a.p007b.p008a.C0250b;

/* renamed from: org.a.a.l.g */
public final class C0555g {

    /* renamed from: a */
    private final int f625a;

    public C0555g() {
        this(3000);
    }

    private C0555g(int i) {
        this.f625a = 3000;
    }

    /* renamed from: a */
    private static void m1159a(C0521i iVar) {
        try {
            iVar.close();
        } catch (IOException e) {
        }
    }

    /* renamed from: a */
    public static void m1160a(C0568q qVar, C0569r rVar, C0553e eVar) {
        C0250b.m84a((Object) qVar, "HTTP request");
        C0250b.m84a((Object) rVar, "HTTP processor");
        C0250b.m84a((Object) eVar, "HTTP context");
        eVar.mo5223a("http.request", qVar);
        rVar.mo4917a(qVar, eVar);
    }

    /* renamed from: a */
    public static void m1161a(C0570s sVar, C0569r rVar, C0553e eVar) {
        C0250b.m84a((Object) sVar, "HTTP response");
        C0250b.m84a((Object) rVar, "HTTP processor");
        C0250b.m84a((Object) eVar, "HTTP context");
        eVar.mo5223a("http.response", sVar);
        rVar.mo4919a(sVar, eVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0012, code lost:
        r1 = r4.mo5345a().mo4867b();
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean m1162a(org.p004a.p005a.C0568q r3, org.p004a.p005a.C0570s r4) {
        /*
            r0 = 0
            java.lang.String r1 = "HEAD"
            org.a.a.ae r2 = r3.mo4902g()
            java.lang.String r2 = r2.mo4863a()
            boolean r1 = r1.equalsIgnoreCase(r2)
            if (r1 == 0) goto L_0x0012
        L_0x0011:
            return r0
        L_0x0012:
            org.a.a.af r1 = r4.mo5345a()
            int r1 = r1.mo4867b()
            r2 = 200(0xc8, float:2.8E-43)
            if (r1 < r2) goto L_0x0011
            r2 = 204(0xcc, float:2.86E-43)
            if (r1 == r2) goto L_0x0011
            r2 = 304(0x130, float:4.26E-43)
            if (r1 == r2) goto L_0x0011
            r2 = 205(0xcd, float:2.87E-43)
            if (r1 == r2) goto L_0x0011
            r0 = 1
            goto L_0x0011
        */
        throw new UnsupportedOperationException("Method not decompiled: org.p004a.p005a.p036l.C0555g.m1162a(org.a.a.q, org.a.a.s):boolean");
    }

    /* renamed from: b */
    private C0570s m1163b(C0568q qVar, C0521i iVar, C0553e eVar) {
        C0250b.m84a((Object) qVar, "HTTP request");
        C0250b.m84a((Object) iVar, "Client connection");
        C0250b.m84a((Object) eVar, "HTTP context");
        C0570s sVar = null;
        int i = 0;
        while (true) {
            if (sVar != null && i >= 200) {
                return sVar;
            }
            sVar = iVar.mo5130a();
            if (m1162a(qVar, sVar)) {
                iVar.mo5134a(sVar);
            }
            i = sVar.mo5345a().mo4867b();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0096  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final org.p004a.p005a.C0570s mo5411a(org.p004a.p005a.C0568q r7, org.p004a.p005a.C0521i r8, org.p004a.p005a.p036l.C0553e r9) {
        /*
            r6 = this;
            r2 = 0
            java.lang.String r1 = "HTTP request"
            org.p004a.p005a.p007b.p008a.C0250b.m84a((java.lang.Object) r7, (java.lang.String) r1)
            java.lang.String r1 = "Client connection"
            org.p004a.p005a.p007b.p008a.C0250b.m84a((java.lang.Object) r8, (java.lang.String) r1)
            java.lang.String r1 = "HTTP context"
            org.p004a.p005a.p007b.p008a.C0250b.m84a((java.lang.Object) r9, (java.lang.String) r1)
            java.lang.String r1 = "HTTP request"
            org.p004a.p005a.p007b.p008a.C0250b.m84a((java.lang.Object) r7, (java.lang.String) r1)     // Catch:{ IOException -> 0x008e, m -> 0x00b2, RuntimeException -> 0x00b7 }
            java.lang.String r1 = "Client connection"
            org.p004a.p005a.p007b.p008a.C0250b.m84a((java.lang.Object) r8, (java.lang.String) r1)     // Catch:{ IOException -> 0x008e, m -> 0x00b2, RuntimeException -> 0x00b7 }
            java.lang.String r1 = "HTTP context"
            org.p004a.p005a.p007b.p008a.C0250b.m84a((java.lang.Object) r9, (java.lang.String) r1)     // Catch:{ IOException -> 0x008e, m -> 0x00b2, RuntimeException -> 0x00b7 }
            java.lang.String r1 = "http.connection"
            r9.mo5223a(r1, r8)     // Catch:{ IOException -> 0x008e, m -> 0x00b2, RuntimeException -> 0x00b7 }
            java.lang.String r1 = "http.request_sent"
            java.lang.Boolean r3 = java.lang.Boolean.FALSE     // Catch:{ IOException -> 0x008e, m -> 0x00b2, RuntimeException -> 0x00b7 }
            r9.mo5223a(r1, r3)     // Catch:{ IOException -> 0x008e, m -> 0x00b2, RuntimeException -> 0x00b7 }
            r8.mo5133a((org.p004a.p005a.C0568q) r7)     // Catch:{ IOException -> 0x008e, m -> 0x00b2, RuntimeException -> 0x00b7 }
            boolean r1 = r7 instanceof org.p004a.p005a.C0548l     // Catch:{ IOException -> 0x008e, m -> 0x00b2, RuntimeException -> 0x00b7 }
            if (r1 == 0) goto L_0x00be
            r3 = 1
            org.a.a.ae r1 = r7.mo4902g()     // Catch:{ IOException -> 0x008e, m -> 0x00b2, RuntimeException -> 0x00b7 }
            org.a.a.ac r4 = r1.mo4864b()     // Catch:{ IOException -> 0x008e, m -> 0x00b2, RuntimeException -> 0x00b7 }
            r0 = r7
            org.a.a.l r0 = (org.p004a.p005a.C0548l) r0     // Catch:{ IOException -> 0x008e, m -> 0x00b2, RuntimeException -> 0x00b7 }
            r1 = r0
            boolean r1 = r1.mo4895a()     // Catch:{ IOException -> 0x008e, m -> 0x00b2, RuntimeException -> 0x00b7 }
            if (r1 == 0) goto L_0x00bc
            org.a.a.v r1 = org.p004a.p005a.C0573v.f644a     // Catch:{ IOException -> 0x008e, m -> 0x00b2, RuntimeException -> 0x00b7 }
            boolean r1 = r4.mo4856a(r1)     // Catch:{ IOException -> 0x008e, m -> 0x00b2, RuntimeException -> 0x00b7 }
            if (r1 != 0) goto L_0x00bc
            r8.mo5136b()     // Catch:{ IOException -> 0x008e, m -> 0x00b2, RuntimeException -> 0x00b7 }
            int r1 = r6.f625a     // Catch:{ IOException -> 0x008e, m -> 0x00b2, RuntimeException -> 0x00b7 }
            boolean r1 = r8.mo5135a((int) r1)     // Catch:{ IOException -> 0x008e, m -> 0x00b2, RuntimeException -> 0x00b7 }
            if (r1 == 0) goto L_0x00bc
            org.a.a.s r4 = r8.mo5130a()     // Catch:{ IOException -> 0x008e, m -> 0x00b2, RuntimeException -> 0x00b7 }
            boolean r1 = m1162a(r7, r4)     // Catch:{ IOException -> 0x008e, m -> 0x00b2, RuntimeException -> 0x00b7 }
            if (r1 == 0) goto L_0x0065
            r8.mo5134a((org.p004a.p005a.C0570s) r4)     // Catch:{ IOException -> 0x008e, m -> 0x00b2, RuntimeException -> 0x00b7 }
        L_0x0065:
            org.a.a.af r1 = r4.mo5345a()     // Catch:{ IOException -> 0x008e, m -> 0x00b2, RuntimeException -> 0x00b7 }
            int r1 = r1.mo4867b()     // Catch:{ IOException -> 0x008e, m -> 0x00b2, RuntimeException -> 0x00b7 }
            r5 = 200(0xc8, float:2.8E-43)
            if (r1 >= r5) goto L_0x00af
            r5 = 100
            if (r1 == r5) goto L_0x0093
            org.a.a.ab r1 = new org.a.a.ab     // Catch:{ IOException -> 0x008e, m -> 0x00b2, RuntimeException -> 0x00b7 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x008e, m -> 0x00b2, RuntimeException -> 0x00b7 }
            java.lang.String r3 = "Unexpected response: "
            r2.<init>(r3)     // Catch:{ IOException -> 0x008e, m -> 0x00b2, RuntimeException -> 0x00b7 }
            org.a.a.af r3 = r4.mo5345a()     // Catch:{ IOException -> 0x008e, m -> 0x00b2, RuntimeException -> 0x00b7 }
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ IOException -> 0x008e, m -> 0x00b2, RuntimeException -> 0x00b7 }
            java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x008e, m -> 0x00b2, RuntimeException -> 0x00b7 }
            r1.<init>(r2)     // Catch:{ IOException -> 0x008e, m -> 0x00b2, RuntimeException -> 0x00b7 }
            throw r1     // Catch:{ IOException -> 0x008e, m -> 0x00b2, RuntimeException -> 0x00b7 }
        L_0x008e:
            r1 = move-exception
            m1159a(r8)
            throw r1
        L_0x0093:
            r1 = r3
        L_0x0094:
            if (r1 == 0) goto L_0x009d
            r0 = r7
            org.a.a.l r0 = (org.p004a.p005a.C0548l) r0     // Catch:{ IOException -> 0x008e, m -> 0x00b2, RuntimeException -> 0x00b7 }
            r1 = r0
            r8.mo5132a((org.p004a.p005a.C0548l) r1)     // Catch:{ IOException -> 0x008e, m -> 0x00b2, RuntimeException -> 0x00b7 }
        L_0x009d:
            r1 = r2
        L_0x009e:
            r8.mo5136b()     // Catch:{ IOException -> 0x008e, m -> 0x00b2, RuntimeException -> 0x00b7 }
            java.lang.String r2 = "http.request_sent"
            java.lang.Boolean r3 = java.lang.Boolean.TRUE     // Catch:{ IOException -> 0x008e, m -> 0x00b2, RuntimeException -> 0x00b7 }
            r9.mo5223a(r2, r3)     // Catch:{ IOException -> 0x008e, m -> 0x00b2, RuntimeException -> 0x00b7 }
            if (r1 != 0) goto L_0x00ae
            org.a.a.s r1 = r6.m1163b(r7, r8, r9)     // Catch:{ IOException -> 0x008e, m -> 0x00b2, RuntimeException -> 0x00b7 }
        L_0x00ae:
            return r1
        L_0x00af:
            r1 = 0
            r2 = r4
            goto L_0x0094
        L_0x00b2:
            r1 = move-exception
            m1159a(r8)
            throw r1
        L_0x00b7:
            r1 = move-exception
            m1159a(r8)
            throw r1
        L_0x00bc:
            r1 = r3
            goto L_0x0094
        L_0x00be:
            r1 = r2
            goto L_0x009e
        */
        throw new UnsupportedOperationException("Method not decompiled: org.p004a.p005a.p036l.C0555g.mo5411a(org.a.a.q, org.a.a.i, org.a.a.l.e):org.a.a.s");
    }
}
