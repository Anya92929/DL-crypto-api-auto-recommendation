package com.google.android.gms.internal;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.WebView;
import com.google.android.gms.internal.C0300bp;
import com.google.android.gms.internal.C0307br;
import com.google.android.gms.internal.C0313bu;
import com.google.android.gms.internal.C0348cr;
import org.json.JSONException;

/* renamed from: com.google.android.gms.internal.bq */
public final class C0302bq extends C0332cg implements C0307br.C0308a, C0348cr.C0350a {

    /* renamed from: dZ */
    private final C0238aw f888dZ;
    /* access modifiers changed from: private */

    /* renamed from: eJ */
    public final Object f889eJ = new Object();

    /* renamed from: eK */
    private C0229ap f890eK;
    /* access modifiers changed from: private */

    /* renamed from: fG */
    public final C0347cq f891fG;
    /* access modifiers changed from: private */

    /* renamed from: gm */
    public final C0300bp.C0301a f892gm;

    /* renamed from: gn */
    private final C0313bu.C0314a f893gn;

    /* renamed from: go */
    private final C0599h f894go;

    /* renamed from: gp */
    private C0332cg f895gp;
    /* access modifiers changed from: private */

    /* renamed from: gq */
    public C0316bw f896gq;

    /* renamed from: gr */
    private boolean f897gr = false;

    /* renamed from: gs */
    private C0226an f898gs;

    /* renamed from: gt */
    private C0234at f899gt;
    private final Context mContext;

    /* renamed from: com.google.android.gms.internal.bq$a */
    private static final class C0306a extends Exception {

        /* renamed from: gw */
        private final int f904gw;

        public C0306a(String str, int i) {
            super(str);
            this.f904gw = i;
        }

        public int getErrorCode() {
            return this.f904gw;
        }
    }

    public C0302bq(Context context, C0313bu.C0314a aVar, C0599h hVar, C0347cq cqVar, C0238aw awVar, C0300bp.C0301a aVar2) {
        this.f888dZ = awVar;
        this.f892gm = aVar2;
        this.f891fG = cqVar;
        this.mContext = context;
        this.f893gn = aVar;
        this.f894go = hVar;
    }

    /* renamed from: a */
    private void m614a(C0313bu buVar, long j) throws C0306a {
        this.f898gs = new C0226an(this.mContext, buVar, this.f888dZ, this.f890eK);
        this.f899gt = this.f898gs.mo4041a(j, 60000);
        switch (this.f899gt.f606fl) {
            case 0:
                return;
            case 1:
                throw new C0306a("No fill from any mediation ad networks.", 3);
            default:
                throw new C0306a("Unexpected mediation result: " + this.f899gt.f606fl, 0);
        }
    }

    /* renamed from: ad */
    private void m615ad() throws C0306a {
        if (this.f896gq.errorCode != -3) {
            if (TextUtils.isEmpty(this.f896gq.f930gG)) {
                throw new C0306a("No fill from ad server.", 3);
            } else if (this.f896gq.f932gI) {
                try {
                    this.f890eK = new C0229ap(this.f896gq.f930gG);
                } catch (JSONException e) {
                    throw new C0306a("Could not parse mediation config: " + this.f896gq.f930gG, 0);
                }
            }
        }
    }

    /* renamed from: b */
    private void m617b(long j) throws C0306a {
        C0343cm.f1013hO.post(new Runnable() {
            /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
                return;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r7 = this;
                    com.google.android.gms.internal.bq r0 = com.google.android.gms.internal.C0302bq.this
                    java.lang.Object r6 = r0.f889eJ
                    monitor-enter(r6)
                    com.google.android.gms.internal.bq r0 = com.google.android.gms.internal.C0302bq.this     // Catch:{ all -> 0x005f }
                    com.google.android.gms.internal.bw r0 = r0.f896gq     // Catch:{ all -> 0x005f }
                    int r0 = r0.errorCode     // Catch:{ all -> 0x005f }
                    r1 = -2
                    if (r0 == r1) goto L_0x0014
                    monitor-exit(r6)     // Catch:{ all -> 0x005f }
                L_0x0013:
                    return
                L_0x0014:
                    com.google.android.gms.internal.bq r0 = com.google.android.gms.internal.C0302bq.this     // Catch:{ all -> 0x005f }
                    com.google.android.gms.internal.cq r0 = r0.f891fG     // Catch:{ all -> 0x005f }
                    com.google.android.gms.internal.cr r0 = r0.mo4212aw()     // Catch:{ all -> 0x005f }
                    com.google.android.gms.internal.bq r1 = com.google.android.gms.internal.C0302bq.this     // Catch:{ all -> 0x005f }
                    r0.mo4223a((com.google.android.gms.internal.C0348cr.C0350a) r1)     // Catch:{ all -> 0x005f }
                    com.google.android.gms.internal.bq r0 = com.google.android.gms.internal.C0302bq.this     // Catch:{ all -> 0x005f }
                    com.google.android.gms.internal.bw r0 = r0.f896gq     // Catch:{ all -> 0x005f }
                    int r0 = r0.errorCode     // Catch:{ all -> 0x005f }
                    r1 = -3
                    if (r0 != r1) goto L_0x0062
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x005f }
                    r0.<init>()     // Catch:{ all -> 0x005f }
                    java.lang.String r1 = "Loading URL in WebView: "
                    java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ all -> 0x005f }
                    com.google.android.gms.internal.bq r1 = com.google.android.gms.internal.C0302bq.this     // Catch:{ all -> 0x005f }
                    com.google.android.gms.internal.bw r1 = r1.f896gq     // Catch:{ all -> 0x005f }
                    java.lang.String r1 = r1.f928fW     // Catch:{ all -> 0x005f }
                    java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ all -> 0x005f }
                    java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x005f }
                    com.google.android.gms.internal.C0344cn.m736p(r0)     // Catch:{ all -> 0x005f }
                    com.google.android.gms.internal.bq r0 = com.google.android.gms.internal.C0302bq.this     // Catch:{ all -> 0x005f }
                    com.google.android.gms.internal.cq r0 = r0.f891fG     // Catch:{ all -> 0x005f }
                    com.google.android.gms.internal.bq r1 = com.google.android.gms.internal.C0302bq.this     // Catch:{ all -> 0x005f }
                    com.google.android.gms.internal.bw r1 = r1.f896gq     // Catch:{ all -> 0x005f }
                    java.lang.String r1 = r1.f928fW     // Catch:{ all -> 0x005f }
                    r0.loadUrl(r1)     // Catch:{ all -> 0x005f }
                L_0x005d:
                    monitor-exit(r6)     // Catch:{ all -> 0x005f }
                    goto L_0x0013
                L_0x005f:
                    r0 = move-exception
                    monitor-exit(r6)     // Catch:{ all -> 0x005f }
                    throw r0
                L_0x0062:
                    java.lang.String r0 = "Loading HTML in WebView."
                    com.google.android.gms.internal.C0344cn.m736p(r0)     // Catch:{ all -> 0x005f }
                    com.google.android.gms.internal.bq r0 = com.google.android.gms.internal.C0302bq.this     // Catch:{ all -> 0x005f }
                    com.google.android.gms.internal.cq r0 = r0.f891fG     // Catch:{ all -> 0x005f }
                    com.google.android.gms.internal.bq r1 = com.google.android.gms.internal.C0302bq.this     // Catch:{ all -> 0x005f }
                    com.google.android.gms.internal.bw r1 = r1.f896gq     // Catch:{ all -> 0x005f }
                    java.lang.String r1 = r1.f928fW     // Catch:{ all -> 0x005f }
                    java.lang.String r1 = com.google.android.gms.internal.C0337ci.m709j((java.lang.String) r1)     // Catch:{ all -> 0x005f }
                    com.google.android.gms.internal.bq r2 = com.google.android.gms.internal.C0302bq.this     // Catch:{ all -> 0x005f }
                    com.google.android.gms.internal.bw r2 = r2.f896gq     // Catch:{ all -> 0x005f }
                    java.lang.String r2 = r2.f930gG     // Catch:{ all -> 0x005f }
                    java.lang.String r3 = "text/html"
                    java.lang.String r4 = "UTF-8"
                    r5 = 0
                    r0.loadDataWithBaseURL(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x005f }
                    goto L_0x005d
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.C0302bq.C03053.run():void");
            }
        });
        m621d(j);
    }

    /* renamed from: c */
    private void m619c(long j) throws C0306a {
        while (m622e(j)) {
            if (this.f896gq != null) {
                this.f895gp = null;
                if (this.f896gq.errorCode != -2 && this.f896gq.errorCode != -3) {
                    throw new C0306a("There was a problem getting an ad response. ErrorCode: " + this.f896gq.errorCode, this.f896gq.errorCode);
                }
                return;
            }
        }
        throw new C0306a("Timed out waiting for ad response.", 2);
    }

    /* renamed from: d */
    private void m621d(long j) throws C0306a {
        while (m622e(j)) {
            if (this.f897gr) {
                return;
            }
        }
        throw new C0306a("Timed out waiting for WebView to finish loading.", 2);
    }

    /* renamed from: e */
    private boolean m622e(long j) throws C0306a {
        long elapsedRealtime = 60000 - (SystemClock.elapsedRealtime() - j);
        if (elapsedRealtime <= 0) {
            return false;
        }
        try {
            this.f889eJ.wait(elapsedRealtime);
            return true;
        } catch (InterruptedException e) {
            throw new C0306a("Ad request cancelled.", -1);
        }
    }

    /* renamed from: a */
    public void mo4154a(C0316bw bwVar) {
        synchronized (this.f889eJ) {
            C0344cn.m733m("Received ad response.");
            this.f896gq = bwVar;
            this.f889eJ.notify();
        }
    }

    /* renamed from: a */
    public void mo4114a(C0347cq cqVar) {
        synchronized (this.f889eJ) {
            C0344cn.m733m("WebView finished loading.");
            this.f897gr = true;
            this.f889eJ.notify();
        }
    }

    /* renamed from: ac */
    public void mo4155ac() {
        synchronized (this.f889eJ) {
            C0344cn.m733m("AdLoaderBackgroundTask started.");
            C0313bu buVar = new C0313bu(this.f893gn, this.f894go.mo5304g().mo4315a(this.mContext));
            int i = -2;
            try {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                this.f895gp = C0307br.m626a(this.mContext, buVar, this);
                if (this.f895gp == null) {
                    throw new C0306a("Could not start the ad request service.", 0);
                }
                m619c(elapsedRealtime);
                m615ad();
                if (this.f896gq.f932gI) {
                    m614a(buVar, elapsedRealtime);
                } else {
                    m617b(elapsedRealtime);
                }
                final C0330ce ceVar = new C0330ce(buVar.f914gB, this.f891fG, this.f896gq.f926eW, i, this.f896gq.f927eX, this.f896gq.f934gK, this.f896gq.orientation, this.f896gq.f929fa, buVar.f917gE, this.f896gq.f932gI, this.f899gt != null ? this.f899gt.f607fm : null, this.f899gt != null ? this.f899gt.f608fn : null, this.f899gt != null ? this.f899gt.f609fo : null, this.f890eK, this.f899gt != null ? this.f899gt.f610fp : null, this.f896gq.f933gJ, this.f896gq.f931gH);
                C0343cm.f1013hO.post(new Runnable() {
                    public void run() {
                        synchronized (C0302bq.this.f889eJ) {
                            C0302bq.this.f892gm.mo4153a(ceVar);
                        }
                    }
                });
            } catch (C0306a e) {
                i = e.getErrorCode();
                if (i == 3 || i == -1) {
                    C0344cn.m735o(e.getMessage());
                } else {
                    C0344cn.m737q(e.getMessage());
                }
                this.f896gq = new C0316bw(i);
                C0343cm.f1013hO.post(new Runnable() {
                    public void run() {
                        C0302bq.this.onStop();
                    }
                });
            }
        }
    }

    public void onStop() {
        synchronized (this.f889eJ) {
            if (this.f895gp != null) {
                this.f895gp.cancel();
            }
            this.f891fG.stopLoading();
            C0337ci.m695a((WebView) this.f891fG);
            if (this.f898gs != null) {
                this.f898gs.cancel();
            }
        }
    }
}
