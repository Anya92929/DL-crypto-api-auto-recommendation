package org.p004a.p005a.p025g.p026a;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ietf.jgss.GSSContext;
import org.ietf.jgss.GSSCredential;
import org.ietf.jgss.GSSManager;
import org.ietf.jgss.GSSName;
import org.ietf.jgss.Oid;
import org.p004a.p005a.C0344e;
import org.p004a.p005a.C0568q;
import org.p004a.p005a.p006a.C0233n;
import org.p004a.p005a.p036l.C0553e;
import org.p004a.p005a.p037m.C0563b;

/* renamed from: org.a.a.g.a.f */
public abstract class C0394f extends C0385a {

    /* renamed from: a */
    private final Log f263a = LogFactory.getLog(getClass());

    /* renamed from: b */
    private final Base64 f264b = new Base64(0);

    /* renamed from: c */
    private final boolean f265c;

    /* renamed from: d */
    private C0396h f266d;

    /* renamed from: e */
    private byte[] f267e;

    C0394f(boolean z) {
        this.f265c = z;
        this.f266d = C0396h.UNINITIATED;
    }

    /* renamed from: a */
    public final C0344e mo4809a(C0233n nVar, C0568q qVar) {
        return mo4836a(nVar, qVar, (C0553e) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x009a, code lost:
        r1 = r0.mo4969d();
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.p004a.p005a.C0344e mo4836a(org.p004a.p005a.p006a.C0233n r5, org.p004a.p005a.C0568q r6, org.p004a.p005a.p036l.C0553e r7) {
        /*
            r4 = this;
            java.lang.String r0 = "HTTP request"
            org.p004a.p005a.p007b.p008a.C0250b.m84a((java.lang.Object) r6, (java.lang.String) r0)
            int[] r0 = org.p004a.p005a.p025g.p026a.C0395g.f268a
            org.a.a.g.a.h r1 = r4.f266d
            int r1 = r1.ordinal()
            r0 = r0[r1]
            switch(r0) {
                case 1: goto L_0x0029;
                case 2: goto L_0x0046;
                case 3: goto L_0x0063;
                case 4: goto L_0x00da;
                default: goto L_0x0012;
            }
        L_0x0012:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Illegal state: "
            r1.<init>(r2)
            org.a.a.g.a.h r2 = r4.f266d
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0029:
            org.a.a.a.j r0 = new org.a.a.a.j
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r4.mo4808a()
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = " authentication has not been initiated"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0046:
            org.a.a.a.j r0 = new org.a.a.a.j
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r4.mo4808a()
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = " authentication has failed"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0063:
            java.lang.String r0 = "http.route"
            java.lang.Object r0 = r7.mo5221a(r0)     // Catch:{ GSSException -> 0x0075 }
            org.a.a.d.b.b r0 = (org.p004a.p005a.p014d.p016b.C0306b) r0     // Catch:{ GSSException -> 0x0075 }
            if (r0 != 0) goto L_0x0094
            org.a.a.a.j r0 = new org.a.a.a.j     // Catch:{ GSSException -> 0x0075 }
            java.lang.String r1 = "Connection route is not available"
            r0.<init>(r1)     // Catch:{ GSSException -> 0x0075 }
            throw r0     // Catch:{ GSSException -> 0x0075 }
        L_0x0075:
            r0 = move-exception
            org.a.a.g.a.h r1 = org.p004a.p005a.p025g.p026a.C0396h.FAILED
            r4.f266d = r1
            int r1 = r0.getMajor()
            r2 = 9
            if (r1 == r2) goto L_0x008a
            int r1 = r0.getMajor()
            r2 = 8
            if (r1 != r2) goto L_0x012e
        L_0x008a:
            org.a.a.a.o r1 = new org.a.a.a.o
            java.lang.String r2 = r0.getMessage()
            r1.<init>(r2, r0)
            throw r1
        L_0x0094:
            boolean r1 = r4.mo5141e()     // Catch:{ GSSException -> 0x0075 }
            if (r1 == 0) goto L_0x00a0
            org.a.a.n r1 = r0.mo4969d()     // Catch:{ GSSException -> 0x0075 }
            if (r1 != 0) goto L_0x0172
        L_0x00a0:
            org.a.a.n r0 = r0.mo4964a()     // Catch:{ GSSException -> 0x0075 }
        L_0x00a4:
            boolean r1 = r4.f265c     // Catch:{ GSSException -> 0x0075 }
            if (r1 != 0) goto L_0x0129
            int r1 = r0.mo5442b()     // Catch:{ GSSException -> 0x0075 }
            if (r1 <= 0) goto L_0x0129
            java.lang.String r0 = r0.mo5445d()     // Catch:{ GSSException -> 0x0075 }
        L_0x00b2:
            org.apache.commons.logging.Log r1 = r4.f263a     // Catch:{ GSSException -> 0x0075 }
            boolean r1 = r1.isDebugEnabled()     // Catch:{ GSSException -> 0x0075 }
            if (r1 == 0) goto L_0x00ce
            org.apache.commons.logging.Log r1 = r4.f263a     // Catch:{ GSSException -> 0x0075 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ GSSException -> 0x0075 }
            java.lang.String r3 = "init "
            r2.<init>(r3)     // Catch:{ GSSException -> 0x0075 }
            java.lang.StringBuilder r2 = r2.append(r0)     // Catch:{ GSSException -> 0x0075 }
            java.lang.String r2 = r2.toString()     // Catch:{ GSSException -> 0x0075 }
            r1.debug(r2)     // Catch:{ GSSException -> 0x0075 }
        L_0x00ce:
            byte[] r1 = r4.f267e     // Catch:{ GSSException -> 0x0075 }
            byte[] r0 = r4.mo5146a((byte[]) r1, (java.lang.String) r0)     // Catch:{ GSSException -> 0x0075 }
            r4.f267e = r0     // Catch:{ GSSException -> 0x0075 }
            org.a.a.g.a.h r0 = org.p004a.p005a.p025g.p026a.C0396h.TOKEN_GENERATED     // Catch:{ GSSException -> 0x0075 }
            r4.f266d = r0     // Catch:{ GSSException -> 0x0075 }
        L_0x00da:
            java.lang.String r0 = new java.lang.String
            org.apache.commons.codec.binary.Base64 r1 = r4.f264b
            byte[] r2 = r4.f267e
            byte[] r1 = r1.encode(r2)
            r0.<init>(r1)
            org.apache.commons.logging.Log r1 = r4.f263a
            boolean r1 = r1.isDebugEnabled()
            if (r1 == 0) goto L_0x0109
            org.apache.commons.logging.Log r1 = r4.f263a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Sending response '"
            r2.<init>(r3)
            java.lang.StringBuilder r2 = r2.append(r0)
            java.lang.String r3 = "' back to the auth server"
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.debug(r2)
        L_0x0109:
            org.a.a.m.b r1 = new org.a.a.m.b
            r2 = 32
            r1.<init>(r2)
            boolean r2 = r4.mo5141e()
            if (r2 == 0) goto L_0x016c
            java.lang.String r2 = "Proxy-Authorization"
            r1.mo5428a((java.lang.String) r2)
        L_0x011b:
            java.lang.String r2 = ": Negotiate "
            r1.mo5428a((java.lang.String) r2)
            r1.mo5428a((java.lang.String) r0)
            org.a.a.i.o r0 = new org.a.a.i.o
            r0.<init>(r1)
            return r0
        L_0x0129:
            java.lang.String r0 = r0.mo5441a()     // Catch:{ GSSException -> 0x0075 }
            goto L_0x00b2
        L_0x012e:
            int r1 = r0.getMajor()
            r2 = 13
            if (r1 != r2) goto L_0x0140
            org.a.a.a.o r1 = new org.a.a.a.o
            java.lang.String r2 = r0.getMessage()
            r1.<init>(r2, r0)
            throw r1
        L_0x0140:
            int r1 = r0.getMajor()
            r2 = 10
            if (r1 == r2) goto L_0x0158
            int r1 = r0.getMajor()
            r2 = 19
            if (r1 == r2) goto L_0x0158
            int r1 = r0.getMajor()
            r2 = 20
            if (r1 != r2) goto L_0x0162
        L_0x0158:
            org.a.a.a.j r1 = new org.a.a.a.j
            java.lang.String r2 = r0.getMessage()
            r1.<init>(r2, r0)
            throw r1
        L_0x0162:
            org.a.a.a.j r1 = new org.a.a.a.j
            java.lang.String r0 = r0.getMessage()
            r1.<init>(r0)
            throw r1
        L_0x016c:
            java.lang.String r2 = "Authorization"
            r1.mo5428a((java.lang.String) r2)
            goto L_0x011b
        L_0x0172:
            r0 = r1
            goto L_0x00a4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.p004a.p005a.p025g.p026a.C0394f.mo4836a(org.a.a.a.n, org.a.a.q, org.a.a.l.e):org.a.a.e");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo5140a(C0563b bVar, int i, int i2) {
        String b = bVar.mo5432b(i, i2);
        if (this.f263a.isDebugEnabled()) {
            this.f263a.debug("Received challenge '" + b + "' from the auth server");
        }
        if (this.f266d == C0396h.UNINITIATED) {
            this.f267e = Base64.decodeBase64(b.getBytes());
            this.f266d = C0396h.CHALLENGE_RECEIVED;
            return;
        }
        this.f263a.debug("Authentication already attempted");
        this.f266d = C0396h.FAILED;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract byte[] mo5146a(byte[] bArr, String str);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final byte[] mo5147a(byte[] bArr, Oid oid, String str) {
        if (bArr == null) {
            bArr = new byte[0];
        }
        GSSManager instance = GSSManager.getInstance();
        GSSContext createContext = instance.createContext(instance.createName("HTTP@" + str, GSSName.NT_HOSTBASED_SERVICE).canonicalize(oid), oid, (GSSCredential) null, 0);
        createContext.requestMutualAuth(true);
        createContext.requestCredDeleg(true);
        return createContext.initSecContext(bArr, 0, bArr.length);
    }

    /* renamed from: d */
    public final boolean mo4813d() {
        return this.f266d == C0396h.TOKEN_GENERATED || this.f266d == C0396h.FAILED;
    }
}
