package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.dynamic.C0597e;
import com.google.android.gms.internal.C1009cq;

@C1130ez
/* renamed from: com.google.android.gms.internal.cp */
public final class C1007cp implements C1009cq.C1010a {

    /* renamed from: lq */
    private final C1013ct f3046lq;
    private final Context mContext;

    /* renamed from: ml */
    private final C0924av f3047ml;
    /* access modifiers changed from: private */

    /* renamed from: mw */
    public final Object f3048mw = new Object();

    /* renamed from: qo */
    private final String f3049qo;

    /* renamed from: qp */
    private final long f3050qp;

    /* renamed from: qq */
    private final C1003cl f3051qq;

    /* renamed from: qr */
    private final C0927ay f3052qr;

    /* renamed from: qs */
    private final C1230gt f3053qs;
    /* access modifiers changed from: private */

    /* renamed from: qt */
    public C1016cu f3054qt;
    /* access modifiers changed from: private */

    /* renamed from: qu */
    public int f3055qu = -2;

    public C1007cp(Context context, String str, C1013ct ctVar, C1004cm cmVar, C1003cl clVar, C0924av avVar, C0927ay ayVar, C1230gt gtVar) {
        this.mContext = context;
        this.f3046lq = ctVar;
        this.f3051qq = clVar;
        if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
            this.f3049qo = m4143bE();
        } else {
            this.f3049qo = str;
        }
        this.f3050qp = cmVar.f3035qe != -1 ? cmVar.f3035qe : 10000;
        this.f3047ml = avVar;
        this.f3052qr = ayVar;
        this.f3053qs = gtVar;
    }

    /* renamed from: a */
    private void m4138a(long j, long j2, long j3, long j4) {
        while (this.f3055qu == -2) {
            m4142b(j, j2, j3, j4);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m4139a(C1006co coVar) {
        try {
            if (this.f3053qs.f3779wF < 4100000) {
                if (this.f3052qr.f2623og) {
                    this.f3054qt.mo8242a(C0597e.m1743k(this.mContext), this.f3047ml, this.f3051qq.f3033qc, coVar);
                } else {
                    this.f3054qt.mo8244a(C0597e.m1743k(this.mContext), this.f3052qr, this.f3047ml, this.f3051qq.f3033qc, (C1019cv) coVar);
                }
            } else if (this.f3052qr.f2623og) {
                this.f3054qt.mo8243a(C0597e.m1743k(this.mContext), this.f3047ml, this.f3051qq.f3033qc, this.f3051qq.f3027pW, (C1019cv) coVar);
            } else {
                this.f3054qt.mo8245a(C0597e.m1743k(this.mContext), this.f3052qr, this.f3047ml, this.f3051qq.f3033qc, this.f3051qq.f3027pW, coVar);
            }
        } catch (RemoteException e) {
            C1229gs.m4683d("Could not request ad from mediation adapter.", e);
            mo8234j(5);
        }
    }

    /* renamed from: b */
    private void m4142b(long j, long j2, long j3, long j4) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j5 = j2 - (elapsedRealtime - j);
        long j6 = j4 - (elapsedRealtime - j3);
        if (j5 <= 0 || j6 <= 0) {
            C1229gs.m4677U("Timed out waiting for adapter.");
            this.f3055qu = 3;
            return;
        }
        try {
            this.f3048mw.wait(Math.min(j5, j6));
        } catch (InterruptedException e) {
            this.f3055qu = -1;
        }
    }

    /* renamed from: bE */
    private String m4143bE() {
        try {
            return (TextUtils.isEmpty(this.f3051qq.f3031qa) || !this.f3046lq.mo8238y(this.f3051qq.f3031qa)) ? "com.google.ads.mediation.customevent.CustomEventAdapter" : "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter";
        } catch (RemoteException e) {
            C1229gs.m4679W("Fail to determine the custom event's version, assuming the old one.");
        }
        return "com.google.ads.mediation.customevent.CustomEventAdapter";
    }

    /* access modifiers changed from: private */
    /* renamed from: bF */
    public C1016cu m4144bF() {
        C1229gs.m4677U("Instantiating mediation adapter: " + this.f3049qo);
        try {
            return this.f3046lq.mo8237x(this.f3049qo);
        } catch (RemoteException e) {
            C1229gs.m4680a("Could not instantiate mediation adapter: " + this.f3049qo, e);
            return null;
        }
    }

    /* renamed from: b */
    public C1009cq mo8232b(long j, long j2) {
        C1009cq cqVar;
        synchronized (this.f3048mw) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            final C1006co coVar = new C1006co();
            C1228gr.f3776wC.post(new Runnable() {
                public void run() {
                    synchronized (C1007cp.this.f3048mw) {
                        if (C1007cp.this.f3055qu == -2) {
                            C1016cu unused = C1007cp.this.f3054qt = C1007cp.this.m4144bF();
                            if (C1007cp.this.f3054qt == null) {
                                C1007cp.this.mo8234j(4);
                                return;
                            }
                            coVar.mo8225a((C1009cq.C1010a) C1007cp.this);
                            C1007cp.this.m4139a(coVar);
                        }
                    }
                }
            });
            m4138a(elapsedRealtime, this.f3050qp, j, j2);
            cqVar = new C1009cq(this.f3051qq, this.f3054qt, this.f3049qo, coVar, this.f3055qu);
        }
        return cqVar;
    }

    public void cancel() {
        synchronized (this.f3048mw) {
            try {
                if (this.f3054qt != null) {
                    this.f3054qt.destroy();
                }
            } catch (RemoteException e) {
                C1229gs.m4683d("Could not destroy mediation adapter.", e);
            }
            this.f3055qu = -1;
            this.f3048mw.notify();
        }
    }

    /* renamed from: j */
    public void mo8234j(int i) {
        synchronized (this.f3048mw) {
            this.f3055qu = i;
            this.f3048mw.notify();
        }
    }
}
