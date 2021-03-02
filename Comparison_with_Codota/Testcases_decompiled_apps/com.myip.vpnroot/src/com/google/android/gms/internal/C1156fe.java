package com.google.android.gms.internal;

import android.content.Context;
import android.os.SystemClock;
import android.webkit.WebView;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.internal.C0955bq;
import com.google.android.gms.internal.C1154fd;
import com.google.android.gms.internal.C1196fz;
import com.google.android.gms.internal.C1234gw;

@C1130ez
/* renamed from: com.google.android.gms.internal.fe */
public class C1156fe extends C1206gg implements C1234gw.C1236a {

    /* renamed from: lq */
    private final C1013ct f3504lq;
    private final Context mContext;
    /* access modifiers changed from: private */

    /* renamed from: md */
    public final C1232gv f3505md;
    /* access modifiers changed from: private */

    /* renamed from: mw */
    public final Object f3506mw = new Object();

    /* renamed from: pR */
    private C1004cm f3507pR;

    /* renamed from: sV */
    private final Object f3508sV = new Object();
    /* access modifiers changed from: private */

    /* renamed from: sZ */
    public C1171fk f3509sZ;
    /* access modifiers changed from: private */

    /* renamed from: tm */
    public final C1154fd.C1155a f3510tm;

    /* renamed from: tn */
    private final C1196fz.C1197a f3511tn;

    /* renamed from: to */
    private boolean f3512to = false;

    /* renamed from: tp */
    private C1001ck f3513tp;

    /* renamed from: tq */
    private C1009cq f3514tq;

    /* renamed from: com.google.android.gms.internal.fe$a */
    private static final class C1161a extends Exception {

        /* renamed from: tc */
        private final int f3521tc;

        public C1161a(String str, int i) {
            super(str);
            this.f3521tc = i;
        }

        public int getErrorCode() {
            return this.f3521tc;
        }
    }

    public C1156fe(Context context, C1196fz.C1197a aVar, C1232gv gvVar, C1013ct ctVar, C1154fd.C1155a aVar2) {
        this.mContext = context;
        this.f3511tn = aVar;
        this.f3509sZ = aVar.f3692vw;
        this.f3505md = gvVar;
        this.f3504lq = ctVar;
        this.f3510tm = aVar2;
        this.f3507pR = aVar.f3688vq;
    }

    /* renamed from: a */
    private void m4432a(C1168fi fiVar, long j) throws C1161a {
        synchronized (this.f3508sV) {
            this.f3513tp = new C1001ck(this.mContext, fiVar, this.f3504lq, this.f3507pR);
        }
        this.f3514tq = this.f3513tp.mo8216a(j, 60000);
        switch (this.f3514tq.f3060qx) {
            case 0:
                return;
            case 1:
                throw new C1161a("No fill from any mediation ad networks.", 3);
            default:
                throw new C1161a("Unexpected mediation result: " + this.f3514tq.f3060qx, 0);
        }
    }

    /* renamed from: c */
    private boolean m4435c(long j) throws C1161a {
        long elapsedRealtime = 60000 - (SystemClock.elapsedRealtime() - j);
        if (elapsedRealtime <= 0) {
            return false;
        }
        try {
            this.f3506mw.wait(elapsedRealtime);
            return true;
        } catch (InterruptedException e) {
            throw new C1161a("Ad request cancelled.", -1);
        }
    }

    /* renamed from: f */
    private void m4437f(long j) throws C1161a {
        C1228gr.f3776wC.post(new Runnable() {
            /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
                return;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r7 = this;
                    com.google.android.gms.internal.fe r0 = com.google.android.gms.internal.C1156fe.this
                    java.lang.Object r6 = r0.f3506mw
                    monitor-enter(r6)
                    com.google.android.gms.internal.fe r0 = com.google.android.gms.internal.C1156fe.this     // Catch:{ all -> 0x005f }
                    com.google.android.gms.internal.fk r0 = r0.f3509sZ     // Catch:{ all -> 0x005f }
                    int r0 = r0.errorCode     // Catch:{ all -> 0x005f }
                    r1 = -2
                    if (r0 == r1) goto L_0x0014
                    monitor-exit(r6)     // Catch:{ all -> 0x005f }
                L_0x0013:
                    return
                L_0x0014:
                    com.google.android.gms.internal.fe r0 = com.google.android.gms.internal.C1156fe.this     // Catch:{ all -> 0x005f }
                    com.google.android.gms.internal.gv r0 = r0.f3505md     // Catch:{ all -> 0x005f }
                    com.google.android.gms.internal.gw r0 = r0.mo8631dv()     // Catch:{ all -> 0x005f }
                    com.google.android.gms.internal.fe r1 = com.google.android.gms.internal.C1156fe.this     // Catch:{ all -> 0x005f }
                    r0.mo8649a((com.google.android.gms.internal.C1234gw.C1236a) r1)     // Catch:{ all -> 0x005f }
                    com.google.android.gms.internal.fe r0 = com.google.android.gms.internal.C1156fe.this     // Catch:{ all -> 0x005f }
                    com.google.android.gms.internal.fk r0 = r0.f3509sZ     // Catch:{ all -> 0x005f }
                    int r0 = r0.errorCode     // Catch:{ all -> 0x005f }
                    r1 = -3
                    if (r0 != r1) goto L_0x0062
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x005f }
                    r0.<init>()     // Catch:{ all -> 0x005f }
                    java.lang.String r1 = "Loading URL in WebView: "
                    java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ all -> 0x005f }
                    com.google.android.gms.internal.fe r1 = com.google.android.gms.internal.C1156fe.this     // Catch:{ all -> 0x005f }
                    com.google.android.gms.internal.fk r1 = r1.f3509sZ     // Catch:{ all -> 0x005f }
                    java.lang.String r1 = r1.f3558rP     // Catch:{ all -> 0x005f }
                    java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ all -> 0x005f }
                    java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x005f }
                    com.google.android.gms.internal.C1229gs.m4678V(r0)     // Catch:{ all -> 0x005f }
                    com.google.android.gms.internal.fe r0 = com.google.android.gms.internal.C1156fe.this     // Catch:{ all -> 0x005f }
                    com.google.android.gms.internal.gv r0 = r0.f3505md     // Catch:{ all -> 0x005f }
                    com.google.android.gms.internal.fe r1 = com.google.android.gms.internal.C1156fe.this     // Catch:{ all -> 0x005f }
                    com.google.android.gms.internal.fk r1 = r1.f3509sZ     // Catch:{ all -> 0x005f }
                    java.lang.String r1 = r1.f3558rP     // Catch:{ all -> 0x005f }
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
                    com.google.android.gms.internal.C1229gs.m4678V(r0)     // Catch:{ all -> 0x005f }
                    com.google.android.gms.internal.fe r0 = com.google.android.gms.internal.C1156fe.this     // Catch:{ all -> 0x005f }
                    com.google.android.gms.internal.gv r0 = r0.f3505md     // Catch:{ all -> 0x005f }
                    com.google.android.gms.internal.fe r1 = com.google.android.gms.internal.C1156fe.this     // Catch:{ all -> 0x005f }
                    com.google.android.gms.internal.fk r1 = r1.f3509sZ     // Catch:{ all -> 0x005f }
                    java.lang.String r1 = r1.f3558rP     // Catch:{ all -> 0x005f }
                    java.lang.String r1 = com.google.android.gms.internal.C1213gj.m4608L(r1)     // Catch:{ all -> 0x005f }
                    com.google.android.gms.internal.fe r2 = com.google.android.gms.internal.C1156fe.this     // Catch:{ all -> 0x005f }
                    com.google.android.gms.internal.fk r2 = r2.f3509sZ     // Catch:{ all -> 0x005f }
                    java.lang.String r2 = r2.f3560tG     // Catch:{ all -> 0x005f }
                    java.lang.String r3 = "text/html"
                    java.lang.String r4 = "UTF-8"
                    r5 = 0
                    r0.loadDataWithBaseURL(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x005f }
                    goto L_0x005d
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.C1156fe.C11593.run():void");
            }
        });
        m4438h(j);
    }

    /* renamed from: h */
    private void m4438h(long j) throws C1161a {
        while (m4435c(j)) {
            if (this.f3512to) {
                return;
            }
        }
        throw new C1161a("Timed out waiting for WebView to finish loading.", 2);
    }

    /* renamed from: a */
    public void mo7957a(C1232gv gvVar) {
        synchronized (this.f3506mw) {
            C1229gs.m4675S("WebView finished loading.");
            this.f3512to = true;
            this.f3506mw.notify();
        }
    }

    /* renamed from: cp */
    public void mo8384cp() {
        synchronized (this.f3506mw) {
            C1229gs.m4675S("AdRendererBackgroundTask started.");
            C1168fi fiVar = this.f3511tn.f3691vv;
            int i = this.f3511tn.errorCode;
            try {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (this.f3509sZ.f3562tI) {
                    m4432a(fiVar, elapsedRealtime);
                } else if (this.f3509sZ.f3568tO) {
                    mo8485g(elapsedRealtime);
                } else {
                    m4437f(elapsedRealtime);
                }
            } catch (C1161a e) {
                i = e.getErrorCode();
                if (i == 3 || i == -1) {
                    C1229gs.m4677U(e.getMessage());
                } else {
                    C1229gs.m4679W(e.getMessage());
                }
                if (this.f3509sZ == null) {
                    this.f3509sZ = new C1171fk(i);
                } else {
                    this.f3509sZ = new C1171fk(i, this.f3509sZ.f3557qj);
                }
                C1228gr.f3776wC.post(new Runnable() {
                    public void run() {
                        C1156fe.this.onStop();
                    }
                });
            }
            final C1196fz fzVar = new C1196fz(fiVar.f3539tx, this.f3505md, this.f3509sZ.f3555qf, i, this.f3509sZ.f3556qg, this.f3509sZ.f3564tK, this.f3509sZ.orientation, this.f3509sZ.f3557qj, fiVar.f3532tA, this.f3509sZ.f3562tI, this.f3514tq != null ? this.f3514tq.f3061qy : null, this.f3514tq != null ? this.f3514tq.f3062qz : null, this.f3514tq != null ? this.f3514tq.f3058qA : AdMobAdapter.class.getName(), this.f3507pR, this.f3514tq != null ? this.f3514tq.f3059qB : null, this.f3509sZ.f3563tJ, this.f3511tn.f3686lH, this.f3509sZ.f3561tH, this.f3511tn.f3689vs, this.f3509sZ.f3566tM, this.f3509sZ.f3567tN, this.f3511tn.f3687vp, (C0955bq.C0956a) null);
            C1228gr.f3776wC.post(new Runnable() {
                public void run() {
                    synchronized (C1156fe.this.f3506mw) {
                        C1156fe.this.f3510tm.mo8484a(fzVar);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public void mo8485g(long j) throws C1161a {
        int i;
        int i2;
        C0927ay Y = this.f3505md.mo8618Y();
        if (Y.f2623og) {
            i = this.mContext.getResources().getDisplayMetrics().widthPixels;
            i2 = this.mContext.getResources().getDisplayMetrics().heightPixels;
        } else {
            i = Y.widthPixels;
            i2 = Y.heightPixels;
        }
        final C1152fc fcVar = new C1152fc(this, this.f3505md, i, i2);
        C1228gr.f3776wC.post(new Runnable() {
            public void run() {
                synchronized (C1156fe.this.f3506mw) {
                    if (C1156fe.this.f3509sZ.errorCode == -2) {
                        C1156fe.this.f3505md.mo8631dv().mo8649a((C1234gw.C1236a) C1156fe.this);
                        fcVar.mo8473b(C1156fe.this.f3509sZ);
                    }
                }
            }
        });
        m4438h(j);
        if (fcVar.mo8475cB()) {
            C1229gs.m4675S("Ad-Network indicated no fill with passback URL.");
            throw new C1161a("AdNetwork sent passback url", 3);
        } else if (!fcVar.mo8476cC()) {
            throw new C1161a("AdNetwork timed out", 2);
        }
    }

    public void onStop() {
        synchronized (this.f3508sV) {
            this.f3505md.stopLoading();
            C1213gj.m4622a((WebView) this.f3505md);
            if (this.f3513tp != null) {
                this.f3513tp.cancel();
            }
        }
    }
}
