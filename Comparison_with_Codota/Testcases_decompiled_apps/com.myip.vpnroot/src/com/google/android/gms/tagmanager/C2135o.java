package com.google.android.gms.tagmanager;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.C0976c;
import com.google.android.gms.internal.C1385ju;
import com.google.android.gms.internal.C1387jw;
import com.google.android.gms.internal.C1663ok;
import com.google.android.gms.tagmanager.C2026bg;
import com.google.android.gms.tagmanager.C2055ce;
import com.google.android.gms.tagmanager.C2075cr;
import com.google.android.gms.tagmanager.C2132n;

/* renamed from: com.google.android.gms.tagmanager.o */
class C2135o extends BaseImplementation.AbstractPendingResult<ContainerHolder> {

    /* renamed from: IB */
    private final Looper f4597IB;
    private final String anR;
    /* access modifiers changed from: private */
    public long anW;
    private final TagManager aod;
    private final C2141d aog;
    /* access modifiers changed from: private */
    public final C2058cg aoh;
    private final int aoi;
    private C2143f aoj;
    /* access modifiers changed from: private */
    public volatile C2132n aok;
    /* access modifiers changed from: private */
    public volatile boolean aol;
    /* access modifiers changed from: private */
    public C0976c.C0986j aom;
    private String aon;
    private C2142e aoo;
    private C2138a aop;
    private final Context mContext;
    /* access modifiers changed from: private */

    /* renamed from: yD */
    public final C1385ju f4598yD;

    /* renamed from: com.google.android.gms.tagmanager.o$a */
    interface C2138a {
        /* renamed from: b */
        boolean mo11771b(Container container);
    }

    /* renamed from: com.google.android.gms.tagmanager.o$b */
    private class C2139b implements C2026bg<C1663ok.C1664a> {
        private C2139b() {
        }

        /* renamed from: a */
        public void mo11574l(C1663ok.C1664a aVar) {
            C0976c.C0986j jVar;
            if (aVar.ash != null) {
                jVar = aVar.ash;
            } else {
                C0976c.C0982f fVar = aVar.f4343gs;
                jVar = new C0976c.C0986j();
                jVar.f3008gs = fVar;
                jVar.f3007gr = null;
                jVar.f3009gt = fVar.version;
            }
            C2135o.this.m7192a(jVar, aVar.asg, true);
        }

        /* renamed from: a */
        public void mo11573a(C2026bg.C2027a aVar) {
            if (!C2135o.this.aol) {
                C2135o.this.m7203w(0);
            }
        }

        /* renamed from: nZ */
        public void mo11575nZ() {
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.o$c */
    private class C2140c implements C2026bg<C0976c.C0986j> {
        private C2140c() {
        }

        /* renamed from: a */
        public void mo11573a(C2026bg.C2027a aVar) {
            if (C2135o.this.aok != null) {
                C2135o.this.mo4196b(C2135o.this.aok);
            } else {
                C2135o.this.mo4196b(C2135o.this.mo3773c(Status.f594Jr));
            }
            C2135o.this.m7203w(3600000);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* renamed from: b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo11574l(com.google.android.gms.internal.C0976c.C0986j r6) {
            /*
                r5 = this;
                com.google.android.gms.tagmanager.o r1 = com.google.android.gms.tagmanager.C2135o.this
                monitor-enter(r1)
                com.google.android.gms.internal.c$f r0 = r6.f3008gs     // Catch:{ all -> 0x0065 }
                if (r0 != 0) goto L_0x002a
                com.google.android.gms.tagmanager.o r0 = com.google.android.gms.tagmanager.C2135o.this     // Catch:{ all -> 0x0065 }
                com.google.android.gms.internal.c$j r0 = r0.aom     // Catch:{ all -> 0x0065 }
                com.google.android.gms.internal.c$f r0 = r0.f3008gs     // Catch:{ all -> 0x0065 }
                if (r0 != 0) goto L_0x0020
                java.lang.String r0 = "Current resource is null; network resource is also null"
                com.google.android.gms.tagmanager.C2028bh.m6816T(r0)     // Catch:{ all -> 0x0065 }
                com.google.android.gms.tagmanager.o r0 = com.google.android.gms.tagmanager.C2135o.this     // Catch:{ all -> 0x0065 }
                r2 = 3600000(0x36ee80, double:1.7786363E-317)
                r0.m7203w(r2)     // Catch:{ all -> 0x0065 }
                monitor-exit(r1)     // Catch:{ all -> 0x0065 }
            L_0x001f:
                return
            L_0x0020:
                com.google.android.gms.tagmanager.o r0 = com.google.android.gms.tagmanager.C2135o.this     // Catch:{ all -> 0x0065 }
                com.google.android.gms.internal.c$j r0 = r0.aom     // Catch:{ all -> 0x0065 }
                com.google.android.gms.internal.c$f r0 = r0.f3008gs     // Catch:{ all -> 0x0065 }
                r6.f3008gs = r0     // Catch:{ all -> 0x0065 }
            L_0x002a:
                com.google.android.gms.tagmanager.o r0 = com.google.android.gms.tagmanager.C2135o.this     // Catch:{ all -> 0x0065 }
                com.google.android.gms.tagmanager.o r2 = com.google.android.gms.tagmanager.C2135o.this     // Catch:{ all -> 0x0065 }
                com.google.android.gms.internal.ju r2 = r2.f4598yD     // Catch:{ all -> 0x0065 }
                long r2 = r2.currentTimeMillis()     // Catch:{ all -> 0x0065 }
                r4 = 0
                r0.m7192a(r6, r2, r4)     // Catch:{ all -> 0x0065 }
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0065 }
                r0.<init>()     // Catch:{ all -> 0x0065 }
                java.lang.String r2 = "setting refresh time to current time: "
                java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ all -> 0x0065 }
                com.google.android.gms.tagmanager.o r2 = com.google.android.gms.tagmanager.C2135o.this     // Catch:{ all -> 0x0065 }
                long r2 = r2.anW     // Catch:{ all -> 0x0065 }
                java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ all -> 0x0065 }
                java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0065 }
                com.google.android.gms.tagmanager.C2028bh.m6818V(r0)     // Catch:{ all -> 0x0065 }
                com.google.android.gms.tagmanager.o r0 = com.google.android.gms.tagmanager.C2135o.this     // Catch:{ all -> 0x0065 }
                boolean r0 = r0.m7202nY()     // Catch:{ all -> 0x0065 }
                if (r0 != 0) goto L_0x0063
                com.google.android.gms.tagmanager.o r0 = com.google.android.gms.tagmanager.C2135o.this     // Catch:{ all -> 0x0065 }
                r0.m7191a((com.google.android.gms.internal.C0976c.C0986j) r6)     // Catch:{ all -> 0x0065 }
            L_0x0063:
                monitor-exit(r1)     // Catch:{ all -> 0x0065 }
                goto L_0x001f
            L_0x0065:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0065 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.C2135o.C2140c.mo11574l(com.google.android.gms.internal.c$j):void");
        }

        /* renamed from: nZ */
        public void mo11575nZ() {
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.o$d */
    private class C2141d implements C2132n.C2133a {
        private C2141d() {
        }

        /* renamed from: co */
        public void mo11759co(String str) {
            C2135o.this.mo11766co(str);
        }

        /* renamed from: nS */
        public String mo11760nS() {
            return C2135o.this.mo11767nS();
        }

        /* renamed from: nU */
        public void mo11761nU() {
            if (C2135o.this.aoh.mo11572eK()) {
                C2135o.this.m7203w(0);
            }
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.o$e */
    interface C2142e extends Releasable {
        /* renamed from: a */
        void mo11637a(C2026bg<C0976c.C0986j> bgVar);

        /* renamed from: cr */
        void mo11638cr(String str);

        /* renamed from: e */
        void mo11639e(long j, String str);
    }

    /* renamed from: com.google.android.gms.tagmanager.o$f */
    interface C2143f extends Releasable {
        /* renamed from: a */
        void mo11642a(C2026bg<C1663ok.C1664a> bgVar);

        /* renamed from: b */
        void mo11643b(C1663ok.C1664a aVar);

        /* renamed from: fe */
        C2075cr.C2079c mo11645fe(int i);

        /* renamed from: oa */
        void mo11648oa();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2135o(Context context, TagManager tagManager, Looper looper, String str, int i, C2143f fVar, C2142e eVar, C1385ju juVar, C2058cg cgVar) {
        super(looper == null ? Looper.getMainLooper() : looper);
        this.mContext = context;
        this.aod = tagManager;
        this.f4597IB = looper == null ? Looper.getMainLooper() : looper;
        this.anR = str;
        this.aoi = i;
        this.aoj = fVar;
        this.aoo = eVar;
        this.aog = new C2141d();
        this.aom = new C0976c.C0986j();
        this.f4598yD = juVar;
        this.aoh = cgVar;
        if (m7202nY()) {
            mo11766co(C2055ce.m6906oH().mo11631oJ());
        }
    }

    public C2135o(Context context, TagManager tagManager, Looper looper, String str, int i, C2146r rVar) {
        this(context, tagManager, looper, str, i, new C2072cq(context, str), new C2067cp(context, str, rVar), C1387jw.m5217hA(), new C2025bf(30, 900000, 5000, "refreshing", C1387jw.m5217hA()));
    }

    /* renamed from: T */
    private void m7189T(final boolean z) {
        this.aoj.mo11642a(new C2139b());
        this.aoo.mo11637a(new C2140c());
        C2075cr.C2079c fe = this.aoj.mo11645fe(this.aoi);
        if (fe != null) {
            this.aok = new C2132n(this.aod, this.f4597IB, new Container(this.mContext, this.aod.getDataLayer(), this.anR, 0, fe), this.aog);
        }
        this.aop = new C2138a() {
            /* renamed from: b */
            public boolean mo11771b(Container container) {
                return z ? container.getLastRefreshTime() + 43200000 >= C2135o.this.f4598yD.currentTimeMillis() : !container.isDefault();
            }
        };
        if (m7202nY()) {
            this.aoo.mo11639e(0, "");
        } else {
            this.aoj.mo11648oa();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m7191a(C0976c.C0986j jVar) {
        if (this.aoj != null) {
            C1663ok.C1664a aVar = new C1663ok.C1664a();
            aVar.asg = this.anW;
            aVar.f4343gs = new C0976c.C0982f();
            aVar.ash = jVar;
            this.aoj.mo11643b(aVar);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0008, code lost:
        if (r8.aol != false) goto L_0x000a;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void m7192a(com.google.android.gms.internal.C0976c.C0986j r9, long r10, boolean r12) {
        /*
            r8 = this;
            r6 = 43200000(0x2932e00, double:2.1343636E-316)
            monitor-enter(r8)
            if (r12 == 0) goto L_0x000c
            boolean r0 = r8.aol     // Catch:{ all -> 0x006a }
            if (r0 == 0) goto L_0x000c
        L_0x000a:
            monitor-exit(r8)
            return
        L_0x000c:
            boolean r0 = r8.isReady()     // Catch:{ all -> 0x006a }
            if (r0 == 0) goto L_0x0016
            com.google.android.gms.tagmanager.n r0 = r8.aok     // Catch:{ all -> 0x006a }
            if (r0 != 0) goto L_0x0016
        L_0x0016:
            r8.aom = r9     // Catch:{ all -> 0x006a }
            r8.anW = r10     // Catch:{ all -> 0x006a }
            r0 = 0
            r2 = 43200000(0x2932e00, double:2.1343636E-316)
            long r4 = r8.anW     // Catch:{ all -> 0x006a }
            long r4 = r4 + r6
            com.google.android.gms.internal.ju r6 = r8.f4598yD     // Catch:{ all -> 0x006a }
            long r6 = r6.currentTimeMillis()     // Catch:{ all -> 0x006a }
            long r4 = r4 - r6
            long r2 = java.lang.Math.min(r2, r4)     // Catch:{ all -> 0x006a }
            long r0 = java.lang.Math.max(r0, r2)     // Catch:{ all -> 0x006a }
            r8.m7203w(r0)     // Catch:{ all -> 0x006a }
            com.google.android.gms.tagmanager.Container r0 = new com.google.android.gms.tagmanager.Container     // Catch:{ all -> 0x006a }
            android.content.Context r1 = r8.mContext     // Catch:{ all -> 0x006a }
            com.google.android.gms.tagmanager.TagManager r2 = r8.aod     // Catch:{ all -> 0x006a }
            com.google.android.gms.tagmanager.DataLayer r2 = r2.getDataLayer()     // Catch:{ all -> 0x006a }
            java.lang.String r3 = r8.anR     // Catch:{ all -> 0x006a }
            r4 = r10
            r6 = r9
            r0.<init>((android.content.Context) r1, (com.google.android.gms.tagmanager.DataLayer) r2, (java.lang.String) r3, (long) r4, (com.google.android.gms.internal.C0976c.C0986j) r6)     // Catch:{ all -> 0x006a }
            com.google.android.gms.tagmanager.n r1 = r8.aok     // Catch:{ all -> 0x006a }
            if (r1 != 0) goto L_0x006d
            com.google.android.gms.tagmanager.n r1 = new com.google.android.gms.tagmanager.n     // Catch:{ all -> 0x006a }
            com.google.android.gms.tagmanager.TagManager r2 = r8.aod     // Catch:{ all -> 0x006a }
            android.os.Looper r3 = r8.f4597IB     // Catch:{ all -> 0x006a }
            com.google.android.gms.tagmanager.o$d r4 = r8.aog     // Catch:{ all -> 0x006a }
            r1.<init>(r2, r3, r0, r4)     // Catch:{ all -> 0x006a }
            r8.aok = r1     // Catch:{ all -> 0x006a }
        L_0x0056:
            boolean r1 = r8.isReady()     // Catch:{ all -> 0x006a }
            if (r1 != 0) goto L_0x000a
            com.google.android.gms.tagmanager.o$a r1 = r8.aop     // Catch:{ all -> 0x006a }
            boolean r0 = r1.mo11771b(r0)     // Catch:{ all -> 0x006a }
            if (r0 == 0) goto L_0x000a
            com.google.android.gms.tagmanager.n r0 = r8.aok     // Catch:{ all -> 0x006a }
            r8.mo4196b(r0)     // Catch:{ all -> 0x006a }
            goto L_0x000a
        L_0x006a:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        L_0x006d:
            com.google.android.gms.tagmanager.n r1 = r8.aok     // Catch:{ all -> 0x006a }
            r1.mo11754a(r0)     // Catch:{ all -> 0x006a }
            goto L_0x0056
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.C2135o.m7192a(com.google.android.gms.internal.c$j, long, boolean):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: nY */
    public boolean m7202nY() {
        C2055ce oH = C2055ce.m6906oH();
        return (oH.mo11630oI() == C2055ce.C2056a.CONTAINER || oH.mo11630oI() == C2055ce.C2056a.CONTAINER_DEBUG) && this.anR.equals(oH.getContainerId());
    }

    /* access modifiers changed from: private */
    /* renamed from: w */
    public synchronized void m7203w(long j) {
        if (this.aoo == null) {
            C2028bh.m6819W("Refresh requested, but no network load scheduler.");
        } else {
            this.aoo.mo11639e(j, this.aom.f3009gt);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: aE */
    public ContainerHolder mo3773c(Status status) {
        if (this.aok != null) {
            return this.aok;
        }
        if (status == Status.f594Jr) {
            C2028bh.m6816T("timer expired: setting result to failure");
        }
        return new C2132n(status);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: co */
    public synchronized void mo11766co(String str) {
        this.aon = str;
        if (this.aoo != null) {
            this.aoo.mo11638cr(str);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: nS */
    public synchronized String mo11767nS() {
        return this.aon;
    }

    /* renamed from: nV */
    public void mo11768nV() {
        C2075cr.C2079c fe = this.aoj.mo11645fe(this.aoi);
        if (fe != null) {
            mo4196b(new C2132n(this.aod, this.f4597IB, new Container(this.mContext, this.aod.getDataLayer(), this.anR, 0, fe), new C2132n.C2133a() {
                /* renamed from: co */
                public void mo11759co(String str) {
                    C2135o.this.mo11766co(str);
                }

                /* renamed from: nS */
                public String mo11760nS() {
                    return C2135o.this.mo11767nS();
                }

                /* renamed from: nU */
                public void mo11761nU() {
                    C2028bh.m6819W("Refresh ignored: container loaded as default only.");
                }
            }));
        } else {
            C2028bh.m6816T("Default was requested, but no default container was found");
            mo4196b(mo3773c(new Status(10, "Default was requested, but no default container was found", (PendingIntent) null)));
        }
        this.aoo = null;
        this.aoj = null;
    }

    /* renamed from: nW */
    public void mo11769nW() {
        m7189T(false);
    }

    /* renamed from: nX */
    public void mo11770nX() {
        m7189T(true);
    }
}
