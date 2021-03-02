package com.google.android.gms.analytics;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.C0164c;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.C1249hb;
import com.google.android.gms.internal.C1385ju;
import com.google.android.gms.internal.C1387jw;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;

/* renamed from: com.google.android.gms.analytics.r */
class C0186r implements C0157af, C0164c.C0166b, C0164c.C0167c {
    private final Context mContext;

    /* renamed from: yA */
    private boolean f203yA;

    /* renamed from: yB */
    private boolean f204yB;

    /* renamed from: yC */
    private boolean f205yC;
    /* access modifiers changed from: private */

    /* renamed from: yD */
    public C1385ju f206yD;
    /* access modifiers changed from: private */

    /* renamed from: yE */
    public long f207yE;

    /* renamed from: yd */
    private C0168d f208yd;

    /* renamed from: ye */
    private final C0170f f209ye;

    /* renamed from: yg */
    private boolean f210yg;
    /* access modifiers changed from: private */

    /* renamed from: yq */
    public volatile long f211yq;
    /* access modifiers changed from: private */

    /* renamed from: yr */
    public volatile C0189a f212yr;

    /* renamed from: ys */
    private volatile C0163b f213ys;

    /* renamed from: yt */
    private C0168d f214yt;

    /* renamed from: yu */
    private final GoogleAnalytics f215yu;
    /* access modifiers changed from: private */

    /* renamed from: yv */
    public final Queue<C0192d> f216yv;

    /* renamed from: yw */
    private volatile int f217yw;

    /* renamed from: yx */
    private volatile Timer f218yx;

    /* renamed from: yy */
    private volatile Timer f219yy;
    /* access modifiers changed from: private */

    /* renamed from: yz */
    public volatile Timer f220yz;

    /* renamed from: com.google.android.gms.analytics.r$a */
    private enum C0189a {
        CONNECTING,
        CONNECTED_SERVICE,
        CONNECTED_LOCAL,
        BLOCKED,
        PENDING_CONNECTION,
        PENDING_DISCONNECT,
        DISCONNECTED
    }

    /* renamed from: com.google.android.gms.analytics.r$b */
    private class C0190b extends TimerTask {
        private C0190b() {
        }

        public void run() {
            if (C0186r.this.f212yr != C0189a.CONNECTED_SERVICE || !C0186r.this.f216yv.isEmpty() || C0186r.this.f211yq + C0186r.this.f207yE >= C0186r.this.f206yD.elapsedRealtime()) {
                C0186r.this.f220yz.schedule(new C0190b(), C0186r.this.f207yE);
                return;
            }
            C0207z.m308V("Disconnecting due to inactivity");
            C0186r.this.m232cD();
        }
    }

    /* renamed from: com.google.android.gms.analytics.r$c */
    private class C0191c extends TimerTask {
        private C0191c() {
        }

        public void run() {
            if (C0186r.this.f212yr == C0189a.CONNECTING) {
                C0186r.this.m238ek();
            }
        }
    }

    /* renamed from: com.google.android.gms.analytics.r$d */
    private static class C0192d {

        /* renamed from: yP */
        private final Map<String, String> f233yP;

        /* renamed from: yQ */
        private final long f234yQ;

        /* renamed from: yR */
        private final String f235yR;

        /* renamed from: yS */
        private final List<C1249hb> f236yS;

        public C0192d(Map<String, String> map, long j, String str, List<C1249hb> list) {
            this.f233yP = map;
            this.f234yQ = j;
            this.f235yR = str;
            this.f236yS = list;
        }

        /* renamed from: en */
        public Map<String, String> mo3717en() {
            return this.f233yP;
        }

        /* renamed from: eo */
        public long mo3718eo() {
            return this.f234yQ;
        }

        /* renamed from: ep */
        public List<C1249hb> mo3719ep() {
            return this.f236yS;
        }

        public String getPath() {
            return this.f235yR;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("PATH: ");
            sb.append(this.f235yR);
            if (this.f233yP != null) {
                sb.append("  PARAMS: ");
                for (Map.Entry next : this.f233yP.entrySet()) {
                    sb.append((String) next.getKey());
                    sb.append("=");
                    sb.append((String) next.getValue());
                    sb.append(",  ");
                }
            }
            return sb.toString();
        }
    }

    /* renamed from: com.google.android.gms.analytics.r$e */
    private class C0193e extends TimerTask {
        private C0193e() {
        }

        public void run() {
            C0186r.this.m239el();
        }
    }

    C0186r(Context context, C0170f fVar) {
        this(context, fVar, (C0168d) null, GoogleAnalytics.getInstance(context));
    }

    C0186r(Context context, C0170f fVar, C0168d dVar, GoogleAnalytics googleAnalytics) {
        this.f216yv = new ConcurrentLinkedQueue();
        this.f207yE = 300000;
        this.f214yt = dVar;
        this.mContext = context;
        this.f209ye = fVar;
        this.f215yu = googleAnalytics;
        this.f206yD = C1387jw.m5217hA();
        this.f217yw = 0;
        this.f212yr = C0189a.DISCONNECTED;
    }

    /* renamed from: a */
    private Timer m228a(Timer timer) {
        if (timer == null) {
            return null;
        }
        timer.cancel();
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: cD */
    public synchronized void m232cD() {
        if (this.f213ys != null && this.f212yr == C0189a.CONNECTED_SERVICE) {
            this.f212yr = C0189a.PENDING_DISCONNECT;
            this.f213ys.disconnect();
        }
    }

    /* renamed from: eg */
    private void m235eg() {
        this.f218yx = m228a(this.f218yx);
        this.f219yy = m228a(this.f219yy);
        this.f220yz = m228a(this.f220yz);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0084, code lost:
        if (r7.f210yg == false) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0086, code lost:
        m237ej();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00db, code lost:
        r7.f211yq = r7.f206yD.elapsedRealtime();
     */
    /* renamed from: ei */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void m236ei() {
        /*
            r7 = this;
            monitor-enter(r7)
            java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0074 }
            com.google.android.gms.analytics.f r2 = r7.f209ye     // Catch:{ all -> 0x0074 }
            java.lang.Thread r2 = r2.getThread()     // Catch:{ all -> 0x0074 }
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0074 }
            if (r1 != 0) goto L_0x0021
            com.google.android.gms.analytics.f r1 = r7.f209ye     // Catch:{ all -> 0x0074 }
            java.util.concurrent.LinkedBlockingQueue r1 = r1.mo3696dP()     // Catch:{ all -> 0x0074 }
            com.google.android.gms.analytics.r$1 r2 = new com.google.android.gms.analytics.r$1     // Catch:{ all -> 0x0074 }
            r2.<init>()     // Catch:{ all -> 0x0074 }
            r1.add(r2)     // Catch:{ all -> 0x0074 }
        L_0x001f:
            monitor-exit(r7)
            return
        L_0x0021:
            boolean r1 = r7.f203yA     // Catch:{ all -> 0x0074 }
            if (r1 == 0) goto L_0x0028
            r7.mo3622dI()     // Catch:{ all -> 0x0074 }
        L_0x0028:
            int[] r1 = com.google.android.gms.analytics.C0186r.C01882.f222yG     // Catch:{ all -> 0x0074 }
            com.google.android.gms.analytics.r$a r2 = r7.f212yr     // Catch:{ all -> 0x0074 }
            int r2 = r2.ordinal()     // Catch:{ all -> 0x0074 }
            r1 = r1[r2]     // Catch:{ all -> 0x0074 }
            switch(r1) {
                case 1: goto L_0x0036;
                case 2: goto L_0x008a;
                case 3: goto L_0x0035;
                case 4: goto L_0x0035;
                case 5: goto L_0x0035;
                case 6: goto L_0x00e5;
                case 7: goto L_0x0077;
                default: goto L_0x0035;
            }     // Catch:{ all -> 0x0074 }
        L_0x0035:
            goto L_0x001f
        L_0x0036:
            java.util.Queue<com.google.android.gms.analytics.r$d> r1 = r7.f216yv     // Catch:{ all -> 0x0074 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0074 }
            if (r1 != 0) goto L_0x0082
            java.util.Queue<com.google.android.gms.analytics.r$d> r1 = r7.f216yv     // Catch:{ all -> 0x0074 }
            java.lang.Object r1 = r1.poll()     // Catch:{ all -> 0x0074 }
            r0 = r1
            com.google.android.gms.analytics.r$d r0 = (com.google.android.gms.analytics.C0186r.C0192d) r0     // Catch:{ all -> 0x0074 }
            r6 = r0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0074 }
            r1.<init>()     // Catch:{ all -> 0x0074 }
            java.lang.String r2 = "Sending hit to store  "
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x0074 }
            java.lang.StringBuilder r1 = r1.append(r6)     // Catch:{ all -> 0x0074 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0074 }
            com.google.android.gms.analytics.C0207z.m308V(r1)     // Catch:{ all -> 0x0074 }
            com.google.android.gms.analytics.d r1 = r7.f208yd     // Catch:{ all -> 0x0074 }
            java.util.Map r2 = r6.mo3717en()     // Catch:{ all -> 0x0074 }
            long r3 = r6.mo3718eo()     // Catch:{ all -> 0x0074 }
            java.lang.String r5 = r6.getPath()     // Catch:{ all -> 0x0074 }
            java.util.List r6 = r6.mo3719ep()     // Catch:{ all -> 0x0074 }
            r1.mo3602a(r2, r3, r5, r6)     // Catch:{ all -> 0x0074 }
            goto L_0x0036
        L_0x0074:
            r1 = move-exception
            monitor-exit(r7)
            throw r1
        L_0x0077:
            java.lang.String r1 = "Blocked. Dropping hits."
            com.google.android.gms.analytics.C0207z.m308V(r1)     // Catch:{ all -> 0x0074 }
            java.util.Queue<com.google.android.gms.analytics.r$d> r1 = r7.f216yv     // Catch:{ all -> 0x0074 }
            r1.clear()     // Catch:{ all -> 0x0074 }
            goto L_0x001f
        L_0x0082:
            boolean r1 = r7.f210yg     // Catch:{ all -> 0x0074 }
            if (r1 == 0) goto L_0x001f
            r7.m237ej()     // Catch:{ all -> 0x0074 }
            goto L_0x001f
        L_0x008a:
            java.util.Queue<com.google.android.gms.analytics.r$d> r1 = r7.f216yv     // Catch:{ all -> 0x0074 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0074 }
            if (r1 != 0) goto L_0x00db
            java.util.Queue<com.google.android.gms.analytics.r$d> r1 = r7.f216yv     // Catch:{ all -> 0x0074 }
            java.lang.Object r1 = r1.peek()     // Catch:{ all -> 0x0074 }
            r0 = r1
            com.google.android.gms.analytics.r$d r0 = (com.google.android.gms.analytics.C0186r.C0192d) r0     // Catch:{ all -> 0x0074 }
            r6 = r0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0074 }
            r1.<init>()     // Catch:{ all -> 0x0074 }
            java.lang.String r2 = "Sending hit to service   "
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x0074 }
            java.lang.StringBuilder r1 = r1.append(r6)     // Catch:{ all -> 0x0074 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0074 }
            com.google.android.gms.analytics.C0207z.m308V(r1)     // Catch:{ all -> 0x0074 }
            com.google.android.gms.analytics.GoogleAnalytics r1 = r7.f215yu     // Catch:{ all -> 0x0074 }
            boolean r1 = r1.isDryRunEnabled()     // Catch:{ all -> 0x0074 }
            if (r1 != 0) goto L_0x00d5
            com.google.android.gms.analytics.b r1 = r7.f213ys     // Catch:{ all -> 0x0074 }
            java.util.Map r2 = r6.mo3717en()     // Catch:{ all -> 0x0074 }
            long r3 = r6.mo3718eo()     // Catch:{ all -> 0x0074 }
            java.lang.String r5 = r6.getPath()     // Catch:{ all -> 0x0074 }
            java.util.List r6 = r6.mo3719ep()     // Catch:{ all -> 0x0074 }
            r1.mo3651a(r2, r3, r5, r6)     // Catch:{ all -> 0x0074 }
        L_0x00cf:
            java.util.Queue<com.google.android.gms.analytics.r$d> r1 = r7.f216yv     // Catch:{ all -> 0x0074 }
            r1.poll()     // Catch:{ all -> 0x0074 }
            goto L_0x008a
        L_0x00d5:
            java.lang.String r1 = "Dry run enabled. Hit not actually sent to service."
            com.google.android.gms.analytics.C0207z.m308V(r1)     // Catch:{ all -> 0x0074 }
            goto L_0x00cf
        L_0x00db:
            com.google.android.gms.internal.ju r1 = r7.f206yD     // Catch:{ all -> 0x0074 }
            long r1 = r1.elapsedRealtime()     // Catch:{ all -> 0x0074 }
            r7.f211yq = r1     // Catch:{ all -> 0x0074 }
            goto L_0x001f
        L_0x00e5:
            java.lang.String r1 = "Need to reconnect"
            com.google.android.gms.analytics.C0207z.m308V(r1)     // Catch:{ all -> 0x0074 }
            java.util.Queue<com.google.android.gms.analytics.r$d> r1 = r7.f216yv     // Catch:{ all -> 0x0074 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0074 }
            if (r1 != 0) goto L_0x001f
            r7.m239el()     // Catch:{ all -> 0x0074 }
            goto L_0x001f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.C0186r.m236ei():void");
    }

    /* renamed from: ej */
    private void m237ej() {
        this.f208yd.dispatch();
        this.f210yg = false;
    }

    /* access modifiers changed from: private */
    /* renamed from: ek */
    public synchronized void m238ek() {
        if (this.f212yr != C0189a.CONNECTED_LOCAL) {
            if (this.mContext == null || !GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE.equals(this.mContext.getPackageName())) {
                m235eg();
                C0207z.m308V("falling back to local store");
                if (this.f214yt != null) {
                    this.f208yd = this.f214yt;
                } else {
                    C0183q ea = C0183q.m217ea();
                    ea.mo3709a(this.mContext, this.f209ye);
                    this.f208yd = ea.mo3712ed();
                }
                this.f212yr = C0189a.CONNECTED_LOCAL;
                m236ei();
            } else {
                this.f212yr = C0189a.BLOCKED;
                this.f213ys.disconnect();
                C0207z.m309W("Attempted to fall back to local store from service.");
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: el */
    public synchronized void m239el() {
        if (this.f205yC || this.f213ys == null || this.f212yr == C0189a.CONNECTED_LOCAL) {
            C0207z.m309W("client not initialized.");
            m238ek();
        } else {
            try {
                this.f217yw++;
                m228a(this.f219yy);
                this.f212yr = C0189a.CONNECTING;
                this.f219yy = new Timer("Failed Connect");
                this.f219yy.schedule(new C0191c(), 3000);
                C0207z.m308V("connecting to Analytics service");
                this.f213ys.connect();
            } catch (SecurityException e) {
                C0207z.m309W("security exception on connectToService");
                m238ek();
            }
        }
        return;
    }

    /* renamed from: em */
    private void m240em() {
        this.f218yx = m228a(this.f218yx);
        this.f218yx = new Timer("Service Reconnect");
        this.f218yx.schedule(new C0193e(), 5000);
    }

    /* renamed from: a */
    public synchronized void mo3661a(int i, Intent intent) {
        this.f212yr = C0189a.PENDING_CONNECTION;
        if (this.f217yw < 2) {
            C0207z.m309W("Service unavailable (code=" + i + "), will retry.");
            m240em();
        } else {
            C0207z.m309W("Service unavailable (code=" + i + "), using local store.");
            m238ek();
        }
    }

    /* renamed from: b */
    public void mo3621b(Map<String, String> map, long j, String str, List<C1249hb> list) {
        C0207z.m308V("putHit called");
        this.f216yv.add(new C0192d(map, j, str, list));
        m236ei();
    }

    /* renamed from: dI */
    public void mo3622dI() {
        C0207z.m308V("clearHits called");
        this.f216yv.clear();
        switch (this.f212yr) {
            case CONNECTED_LOCAL:
                this.f208yd.mo3609l(0);
                this.f203yA = false;
                return;
            case CONNECTED_SERVICE:
                this.f213ys.mo3653dI();
                this.f203yA = false;
                return;
            default:
                this.f203yA = true;
                return;
        }
    }

    /* renamed from: dO */
    public synchronized void mo3623dO() {
        if (!this.f205yC) {
            C0207z.m308V("setForceLocalDispatch called.");
            this.f205yC = true;
            switch (this.f212yr) {
                case CONNECTED_LOCAL:
                case PENDING_CONNECTION:
                case PENDING_DISCONNECT:
                case DISCONNECTED:
                    break;
                case CONNECTED_SERVICE:
                    m232cD();
                    break;
                case CONNECTING:
                    this.f204yB = true;
                    break;
            }
        }
    }

    public void dispatch() {
        switch (this.f212yr) {
            case CONNECTED_LOCAL:
                m237ej();
                return;
            case CONNECTED_SERVICE:
                return;
            default:
                this.f210yg = true;
                return;
        }
    }

    /* renamed from: eh */
    public void mo3625eh() {
        if (this.f213ys == null) {
            this.f213ys = new C0164c(this.mContext, this, this);
            m239el();
        }
    }

    public synchronized void onConnected() {
        this.f219yy = m228a(this.f219yy);
        this.f217yw = 0;
        C0207z.m308V("Connected to service");
        this.f212yr = C0189a.CONNECTED_SERVICE;
        if (this.f204yB) {
            m232cD();
            this.f204yB = false;
        } else {
            m236ei();
            this.f220yz = m228a(this.f220yz);
            this.f220yz = new Timer("disconnect check");
            this.f220yz.schedule(new C0190b(), this.f207yE);
        }
    }

    public synchronized void onDisconnected() {
        if (this.f212yr == C0189a.BLOCKED) {
            C0207z.m308V("Service blocked.");
            m235eg();
        } else if (this.f212yr == C0189a.PENDING_DISCONNECT) {
            C0207z.m308V("Disconnected from service");
            m235eg();
            this.f212yr = C0189a.DISCONNECTED;
        } else {
            C0207z.m308V("Unexpected disconnect.");
            this.f212yr = C0189a.PENDING_CONNECTION;
            if (this.f217yw < 2) {
                m240em();
            } else {
                m238ek();
            }
        }
    }
}
