package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.os.SystemClock;
import com.google.android.gms.dynamic.C0167c;
import com.google.android.gms.internal.C0234at;
import com.radiusnetworks.ibeacon.IBeaconManager;

/* renamed from: com.google.android.gms.internal.as */
public final class C0232as implements C0234at.C0235a {

    /* renamed from: dZ */
    private final C0238aw f595dZ;
    /* access modifiers changed from: private */

    /* renamed from: eJ */
    public final Object f596eJ = new Object();

    /* renamed from: em */
    private final C0620v f597em;

    /* renamed from: fd */
    private final String f598fd;

    /* renamed from: fe */
    private final long f599fe;

    /* renamed from: ff */
    private final C0228ao f600ff;

    /* renamed from: fg */
    private final C0622x f601fg;
    /* access modifiers changed from: private */

    /* renamed from: fh */
    public C0241ax f602fh;
    /* access modifiers changed from: private */

    /* renamed from: fi */
    public int f603fi = -2;
    private final Context mContext;

    public C0232as(Context context, String str, C0238aw awVar, C0229ap apVar, C0228ao aoVar, C0620v vVar, C0622x xVar) {
        this.mContext = context;
        this.f598fd = str;
        this.f595dZ = awVar;
        this.f599fe = apVar.f586eV != -1 ? apVar.f586eV : IBeaconManager.DEFAULT_BACKGROUND_SCAN_PERIOD;
        this.f600ff = aoVar;
        this.f597em = vVar;
        this.f601fg = xVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: P */
    public C0241ax m507P() {
        C0344cn.m735o("Instantiating mediation adapter: " + this.f598fd);
        try {
            return this.f595dZ.mo4062g(this.f598fd);
        } catch (RemoteException e) {
            C0344cn.m730a("Could not instantiate mediation adapter: " + this.f598fd, e);
            return null;
        }
    }

    /* renamed from: a */
    private void m510a(long j, long j2, long j3, long j4) {
        while (this.f603fi == -2) {
            m514b(j, j2, j3, j4);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m511a(C0231ar arVar) {
        try {
            if (this.f601fg.f1582ex) {
                this.f602fh.mo4066a(C0167c.m379g(this.mContext), this.f597em, this.f600ff.f583eS, arVar);
            } else {
                this.f602fh.mo4067a(C0167c.m379g(this.mContext), this.f601fg, this.f597em, this.f600ff.f583eS, arVar);
            }
        } catch (RemoteException e) {
            C0344cn.m731b("Could not request ad from mediation adapter.", e);
            mo4059d(5);
        }
    }

    /* renamed from: b */
    private void m514b(long j, long j2, long j3, long j4) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j5 = j2 - (elapsedRealtime - j);
        long j6 = j4 - (elapsedRealtime - j3);
        if (j5 <= 0 || j6 <= 0) {
            C0344cn.m735o("Timed out waiting for adapter.");
            this.f603fi = 3;
            return;
        }
        try {
            this.f596eJ.wait(Math.min(j5, j6));
        } catch (InterruptedException e) {
            this.f603fi = -1;
        }
    }

    /* renamed from: b */
    public C0234at mo4057b(long j, long j2) {
        C0234at atVar;
        synchronized (this.f596eJ) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            final C0231ar arVar = new C0231ar();
            C0343cm.f1013hO.post(new Runnable() {
                public void run() {
                    synchronized (C0232as.this.f596eJ) {
                        if (C0232as.this.f603fi == -2) {
                            C0241ax unused = C0232as.this.f602fh = C0232as.this.m507P();
                            if (C0232as.this.f602fh == null) {
                                C0232as.this.mo4059d(4);
                                return;
                            }
                            arVar.mo4050a((C0234at.C0235a) C0232as.this);
                            C0232as.this.m511a(arVar);
                        }
                    }
                }
            });
            m510a(elapsedRealtime, this.f599fe, j, j2);
            atVar = new C0234at(this.f600ff, this.f602fh, this.f598fd, arVar, this.f603fi);
        }
        return atVar;
    }

    public void cancel() {
        synchronized (this.f596eJ) {
            try {
                if (this.f602fh != null) {
                    this.f602fh.destroy();
                }
            } catch (RemoteException e) {
                C0344cn.m731b("Could not destroy mediation adapter.", e);
            }
            this.f603fi = -1;
            this.f596eJ.notify();
        }
    }

    /* renamed from: d */
    public void mo4059d(int i) {
        synchronized (this.f596eJ) {
            this.f603fi = i;
            this.f596eJ.notify();
        }
    }
}
