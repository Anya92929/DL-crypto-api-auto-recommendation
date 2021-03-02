package org.p004a.p005a.p025g.p028c;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.p004a.p005a.C0521i;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p007b.p010c.C0266m;
import org.p004a.p005a.p014d.C0304b;
import org.p004a.p005a.p014d.C0313c;
import org.p004a.p005a.p014d.C0321d;
import org.p004a.p005a.p014d.C0339m;
import org.p004a.p005a.p014d.p016b.C0306b;
import org.p004a.p005a.p014d.p017c.C0319f;

/* renamed from: org.a.a.g.c.a */
public final class C0442a implements C0304b {

    /* renamed from: b */
    private static final AtomicLong f411b = new AtomicLong();

    /* renamed from: a */
    private final Log f412a;

    /* renamed from: c */
    private final C0319f f413c;

    /* renamed from: d */
    private final C0313c f414d;

    /* renamed from: e */
    private C0450i f415e;

    /* renamed from: f */
    private C0453l f416f;

    /* renamed from: g */
    private volatile boolean f417g;

    public C0442a() {
        this(C0250b.m110c());
    }

    public C0442a(C0319f fVar) {
        this.f412a = LogFactory.getLog(getClass());
        C0250b.m84a((Object) fVar, "Scheme registry");
        this.f413c = fVar;
        this.f414d = new C0446e(fVar);
    }

    /* renamed from: a */
    private void m734a(C0521i iVar) {
        try {
            iVar.mo5226e();
        } catch (IOException e) {
            if (this.f412a.isDebugEnabled()) {
                this.f412a.debug("I/O exception shutting down connection", e);
            }
        }
    }

    /* renamed from: a */
    public final C0319f mo4959a() {
        return this.f413c;
    }

    /* renamed from: a */
    public final C0321d mo4960a(C0306b bVar, Object obj) {
        return new C0443b(this, bVar, obj);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final C0339m mo5219a(C0306b bVar) {
        C0453l lVar;
        boolean z = true;
        C0250b.m84a((Object) bVar, "Route");
        synchronized (this) {
            C0266m.m146a(!this.f417g, "Connection manager has been shut down");
            if (this.f412a.isDebugEnabled()) {
                this.f412a.debug("Get connection for route " + bVar);
            }
            if (this.f416f != null) {
                z = false;
            }
            C0266m.m146a(z, "Invalid use of BasicClientConnManager: connection still allocated.\nMake sure to release the connection before allocating another one.");
            if (this.f415e != null && !((C0306b) this.f415e.mo5395e()).equals(bVar)) {
                this.f415e.mo5232d();
                this.f415e = null;
            }
            if (this.f415e == null) {
                this.f415e = new C0450i(this.f412a, Long.toString(f411b.getAndIncrement()), bVar, this.f414d.mo4988a(), 0, TimeUnit.MILLISECONDS);
            }
            if (this.f415e.mo5229a(System.currentTimeMillis())) {
                this.f415e.mo5232d();
                this.f415e.mo5228a().mo4983h();
            }
            this.f416f = new C0453l(this, this.f414d, this.f415e);
            lVar = this.f416f;
        }
        return lVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
        return;
     */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo4961a(org.p004a.p005a.p014d.C0339m r7, long r8, java.util.concurrent.TimeUnit r10) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof org.p004a.p005a.p025g.p028c.C0453l
            java.lang.String r1 = "Connection class mismatch, connection not obtained from this manager"
            org.p004a.p005a.p007b.p008a.C0250b.m95a((boolean) r0, (java.lang.String) r1)
            r0 = r7
            org.a.a.g.c.l r0 = (org.p004a.p005a.p025g.p028c.C0453l) r0
            monitor-enter(r0)
            org.apache.commons.logging.Log r1 = r6.f412a     // Catch:{ all -> 0x0046 }
            boolean r1 = r1.isDebugEnabled()     // Catch:{ all -> 0x0046 }
            if (r1 == 0) goto L_0x0027
            org.apache.commons.logging.Log r1 = r6.f412a     // Catch:{ all -> 0x0046 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0046 }
            java.lang.String r3 = "Releasing connection "
            r2.<init>(r3)     // Catch:{ all -> 0x0046 }
            java.lang.StringBuilder r2 = r2.append(r7)     // Catch:{ all -> 0x0046 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0046 }
            r1.debug(r2)     // Catch:{ all -> 0x0046 }
        L_0x0027:
            org.a.a.g.c.i r1 = r0.mo5249n()     // Catch:{ all -> 0x0046 }
            if (r1 != 0) goto L_0x002f
            monitor-exit(r0)     // Catch:{ all -> 0x0046 }
        L_0x002e:
            return
        L_0x002f:
            org.a.a.d.b r1 = r0.mo5251p()     // Catch:{ all -> 0x0046 }
            if (r1 != r6) goto L_0x0049
            r1 = 1
        L_0x0036:
            java.lang.String r2 = "Connection not obtained from this manager"
            org.p004a.p005a.p007b.p010c.C0266m.m146a((boolean) r1, (java.lang.String) r2)     // Catch:{ all -> 0x0046 }
            monitor-enter(r6)     // Catch:{ all -> 0x0046 }
            boolean r1 = r6.f417g     // Catch:{ all -> 0x00d1 }
            if (r1 == 0) goto L_0x004b
            r6.m734a((org.p004a.p005a.C0521i) r0)     // Catch:{ all -> 0x00d1 }
            monitor-exit(r6)     // Catch:{ all -> 0x00d1 }
            monitor-exit(r0)     // Catch:{ all -> 0x0046 }
            goto L_0x002e
        L_0x0046:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0046 }
            throw r1
        L_0x0049:
            r1 = 0
            goto L_0x0036
        L_0x004b:
            boolean r1 = r0.mo5246c()     // Catch:{ all -> 0x00be }
            if (r1 == 0) goto L_0x005a
            boolean r1 = r0.mo5252q()     // Catch:{ all -> 0x00be }
            if (r1 != 0) goto L_0x005a
            r6.m734a((org.p004a.p005a.C0521i) r0)     // Catch:{ all -> 0x00be }
        L_0x005a:
            boolean r1 = r0.mo5252q()     // Catch:{ all -> 0x00be }
            if (r1 == 0) goto L_0x00a3
            org.a.a.g.c.i r2 = r6.f415e     // Catch:{ all -> 0x00be }
            if (r10 == 0) goto L_0x00b8
            r1 = r10
        L_0x0065:
            r2.mo5393a(r8, r1)     // Catch:{ all -> 0x00be }
            org.apache.commons.logging.Log r1 = r6.f412a     // Catch:{ all -> 0x00be }
            boolean r1 = r1.isDebugEnabled()     // Catch:{ all -> 0x00be }
            if (r1 == 0) goto L_0x00a3
            r2 = 0
            int r1 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r1 <= 0) goto L_0x00bb
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00be }
            java.lang.String r2 = "for "
            r1.<init>(r2)     // Catch:{ all -> 0x00be }
            java.lang.StringBuilder r1 = r1.append(r8)     // Catch:{ all -> 0x00be }
            java.lang.String r2 = " "
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x00be }
            java.lang.StringBuilder r1 = r1.append(r10)     // Catch:{ all -> 0x00be }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00be }
        L_0x008f:
            org.apache.commons.logging.Log r2 = r6.f412a     // Catch:{ all -> 0x00be }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00be }
            java.lang.String r4 = "Connection can be kept alive "
            r3.<init>(r4)     // Catch:{ all -> 0x00be }
            java.lang.StringBuilder r1 = r3.append(r1)     // Catch:{ all -> 0x00be }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00be }
            r2.debug(r1)     // Catch:{ all -> 0x00be }
        L_0x00a3:
            r0.mo5250o()     // Catch:{ all -> 0x00d1 }
            r1 = 0
            r6.f416f = r1     // Catch:{ all -> 0x00d1 }
            org.a.a.g.c.i r1 = r6.f415e     // Catch:{ all -> 0x00d1 }
            boolean r1 = r1.mo5231c()     // Catch:{ all -> 0x00d1 }
            if (r1 == 0) goto L_0x00b4
            r1 = 0
            r6.f415e = r1     // Catch:{ all -> 0x00d1 }
        L_0x00b4:
            monitor-exit(r6)     // Catch:{ all -> 0x00d1 }
            monitor-exit(r0)     // Catch:{ all -> 0x0046 }
            goto L_0x002e
        L_0x00b8:
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x00be }
            goto L_0x0065
        L_0x00bb:
            java.lang.String r1 = "indefinitely"
            goto L_0x008f
        L_0x00be:
            r1 = move-exception
            r0.mo5250o()     // Catch:{ all -> 0x00d1 }
            r2 = 0
            r6.f416f = r2     // Catch:{ all -> 0x00d1 }
            org.a.a.g.c.i r2 = r6.f415e     // Catch:{ all -> 0x00d1 }
            boolean r2 = r2.mo5231c()     // Catch:{ all -> 0x00d1 }
            if (r2 == 0) goto L_0x00d0
            r2 = 0
            r6.f415e = r2     // Catch:{ all -> 0x00d1 }
        L_0x00d0:
            throw r1     // Catch:{ all -> 0x00d1 }
        L_0x00d1:
            r1 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x00d1 }
            throw r1     // Catch:{ all -> 0x0046 }
        */
        throw new UnsupportedOperationException("Method not decompiled: org.p004a.p005a.p025g.p028c.C0442a.mo4961a(org.a.a.d.m, long, java.util.concurrent.TimeUnit):void");
    }

    /* renamed from: b */
    public final void mo4962b() {
        synchronized (this) {
            this.f417g = true;
            try {
                if (this.f415e != null) {
                    this.f415e.mo5232d();
                }
                this.f415e = null;
                this.f416f = null;
            } catch (Throwable th) {
                this.f415e = null;
                this.f416f = null;
                throw th;
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void finalize() {
        try {
            mo4962b();
        } finally {
            super.finalize();
        }
    }
}
