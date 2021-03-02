package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Process;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.C1385ju;
import com.google.android.gms.internal.C1387jw;
import java.io.IOException;

/* renamed from: com.google.android.gms.tagmanager.a */
class C1985a {
    private static C1985a anF;

    /* renamed from: xz */
    private static Object f4523xz = new Object();
    private volatile long anB;
    private volatile long anC;
    private volatile long anD;
    private C1988a anE;
    private volatile boolean mClosed;
    /* access modifiers changed from: private */
    public final Context mContext;

    /* renamed from: wf */
    private final Thread f4524wf;

    /* renamed from: xB */
    private volatile AdvertisingIdClient.Info f4525xB;

    /* renamed from: yD */
    private final C1385ju f4526yD;

    /* renamed from: com.google.android.gms.tagmanager.a$a */
    public interface C1988a {
        /* renamed from: nK */
        AdvertisingIdClient.Info mo11535nK();
    }

    private C1985a(Context context) {
        this(context, (C1988a) null, C1387jw.m5217hA());
    }

    C1985a(Context context, C1988a aVar, C1385ju juVar) {
        this.anB = 900000;
        this.anC = 30000;
        this.mClosed = false;
        this.anE = new C1988a() {
            /* renamed from: nK */
            public AdvertisingIdClient.Info mo11535nK() {
                try {
                    return AdvertisingIdClient.getAdvertisingIdInfo(C1985a.this.mContext);
                } catch (IllegalStateException e) {
                    C2028bh.m6819W("IllegalStateException getting Advertising Id Info");
                    return null;
                } catch (GooglePlayServicesRepairableException e2) {
                    C2028bh.m6819W("GooglePlayServicesRepairableException getting Advertising Id Info");
                    return null;
                } catch (IOException e3) {
                    C2028bh.m6819W("IOException getting Ad Id Info");
                    return null;
                } catch (GooglePlayServicesNotAvailableException e4) {
                    C2028bh.m6819W("GooglePlayServicesNotAvailableException getting Advertising Id Info");
                    return null;
                } catch (Exception e5) {
                    C2028bh.m6819W("Unknown exception. Could not get the Advertising Id Info.");
                    return null;
                }
            }
        };
        this.f4526yD = juVar;
        if (context != null) {
            this.mContext = context.getApplicationContext();
        } else {
            this.mContext = context;
        }
        if (aVar != null) {
            this.anE = aVar;
        }
        this.f4524wf = new Thread(new Runnable() {
            public void run() {
                C1985a.this.m6724nI();
            }
        });
    }

    /* renamed from: V */
    static C1985a m6721V(Context context) {
        if (anF == null) {
            synchronized (f4523xz) {
                if (anF == null) {
                    anF = new C1985a(context);
                    anF.start();
                }
            }
        }
        return anF;
    }

    /* access modifiers changed from: private */
    /* renamed from: nI */
    public void m6724nI() {
        Process.setThreadPriority(10);
        while (!this.mClosed) {
            try {
                this.f4525xB = this.anE.mo11535nK();
                Thread.sleep(this.anB);
            } catch (InterruptedException e) {
                C2028bh.m6817U("sleep interrupted in AdvertiserDataPoller thread; continuing");
            }
        }
    }

    /* renamed from: nJ */
    private void m6725nJ() {
        if (this.f4526yD.currentTimeMillis() - this.anD >= this.anC) {
            interrupt();
            this.anD = this.f4526yD.currentTimeMillis();
        }
    }

    /* access modifiers changed from: package-private */
    public void interrupt() {
        this.f4524wf.interrupt();
    }

    public boolean isLimitAdTrackingEnabled() {
        m6725nJ();
        if (this.f4525xB == null) {
            return true;
        }
        return this.f4525xB.isLimitAdTrackingEnabled();
    }

    /* renamed from: nH */
    public String mo11533nH() {
        m6725nJ();
        if (this.f4525xB == null) {
            return null;
        }
        return this.f4525xB.getId();
    }

    /* access modifiers changed from: package-private */
    public void start() {
        this.f4524wf.start();
    }
}
