package org.p004a.p005a.p036l;

import org.p004a.p005a.C0569r;

/* renamed from: org.a.a.l.k */
public final class C0559k implements C0569r {
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0069  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo4917a(org.p004a.p005a.C0568q r5, org.p004a.p005a.p036l.C0553e r6) {
        /*
            r4 = this;
            java.lang.String r0 = "HTTP request"
            org.p004a.p005a.p007b.p008a.C0250b.m84a((java.lang.Object) r5, (java.lang.String) r0)
            java.lang.String r0 = "HTTP context"
            org.p004a.p005a.p007b.p008a.C0250b.m84a((java.lang.Object) r6, (java.lang.String) r0)
            boolean r0 = r6 instanceof org.p004a.p005a.p036l.C0554f
            if (r0 == 0) goto L_0x0031
            org.a.a.l.f r6 = (org.p004a.p005a.p036l.C0554f) r6
        L_0x0010:
            org.a.a.ae r0 = r5.mo4902g()
            org.a.a.ac r3 = r0.mo4864b()
            org.a.a.ae r0 = r5.mo4902g()
            java.lang.String r0 = r0.mo4863a()
            java.lang.String r1 = "CONNECT"
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 == 0) goto L_0x0038
            org.a.a.v r0 = org.p004a.p005a.C0573v.f644a
            boolean r0 = r3.mo4856a(r0)
            if (r0 == 0) goto L_0x0038
        L_0x0030:
            return
        L_0x0031:
            org.a.a.l.f r0 = new org.a.a.l.f
            r0.<init>(r6)
            r6 = r0
            goto L_0x0010
        L_0x0038:
            java.lang.String r0 = "Host"
            boolean r0 = r5.mo5323a((java.lang.String) r0)
            if (r0 != 0) goto L_0x0030
            org.a.a.n r2 = r6.mo5410k()
            if (r2 != 0) goto L_0x0079
            org.a.a.j r1 = r6.mo5409j()
            boolean r0 = r1 instanceof org.p004a.p005a.C0566o
            if (r0 == 0) goto L_0x0084
            r0 = r1
            org.a.a.o r0 = (org.p004a.p005a.C0566o) r0
            java.net.InetAddress r0 = r0.mo5247f()
            org.a.a.o r1 = (org.p004a.p005a.C0566o) r1
            int r1 = r1.mo5248g()
            if (r0 == 0) goto L_0x0084
            org.a.a.n r2 = new org.a.a.n
            java.lang.String r0 = r0.getHostName()
            r2.<init>(r0, r1)
            r0 = r2
        L_0x0067:
            if (r0 != 0) goto L_0x007a
            org.a.a.v r0 = org.p004a.p005a.C0573v.f644a
            boolean r0 = r3.mo4856a(r0)
            if (r0 != 0) goto L_0x0030
            org.a.a.ab r0 = new org.a.a.ab
            java.lang.String r1 = "Target host missing"
            r0.<init>(r1)
            throw r0
        L_0x0079:
            r0 = r2
        L_0x007a:
            java.lang.String r1 = "Host"
            java.lang.String r0 = r0.mo5445d()
            r5.mo5319a(r1, r0)
            goto L_0x0030
        L_0x0084:
            r0 = r2
            goto L_0x0067
        */
        throw new UnsupportedOperationException("Method not decompiled: org.p004a.p005a.p036l.C0559k.mo4917a(org.a.a.q, org.a.a.l.e):void");
    }
}
