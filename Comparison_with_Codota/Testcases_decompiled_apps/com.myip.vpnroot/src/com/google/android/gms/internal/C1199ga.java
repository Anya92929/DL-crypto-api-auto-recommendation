package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

@C1130ez
/* renamed from: com.google.android.gms.internal.ga */
public class C1199ga {

    /* renamed from: mw */
    private final Object f3693mw;

    /* renamed from: uC */
    private boolean f3694uC;

    /* renamed from: vA */
    private final String f3695vA;

    /* renamed from: vB */
    private long f3696vB;

    /* renamed from: vC */
    private long f3697vC;

    /* renamed from: vD */
    private long f3698vD;

    /* renamed from: vE */
    private long f3699vE;

    /* renamed from: vF */
    private long f3700vF;

    /* renamed from: vG */
    private long f3701vG;

    /* renamed from: vx */
    private final C1201gb f3702vx;

    /* renamed from: vy */
    private final LinkedList<C1200a> f3703vy;

    /* renamed from: vz */
    private final String f3704vz;

    @C1130ez
    /* renamed from: com.google.android.gms.internal.ga$a */
    private static final class C1200a {

        /* renamed from: vH */
        private long f3705vH = -1;

        /* renamed from: vI */
        private long f3706vI = -1;

        /* renamed from: cS */
        public long mo8553cS() {
            return this.f3706vI;
        }

        /* renamed from: cT */
        public void mo8554cT() {
            this.f3706vI = SystemClock.elapsedRealtime();
        }

        /* renamed from: cU */
        public void mo8555cU() {
            this.f3705vH = SystemClock.elapsedRealtime();
        }

        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putLong("topen", this.f3705vH);
            bundle.putLong("tclose", this.f3706vI);
            return bundle;
        }
    }

    public C1199ga(C1201gb gbVar, String str, String str2) {
        this.f3693mw = new Object();
        this.f3696vB = -1;
        this.f3697vC = -1;
        this.f3694uC = false;
        this.f3698vD = -1;
        this.f3699vE = 0;
        this.f3700vF = -1;
        this.f3701vG = -1;
        this.f3702vx = gbVar;
        this.f3704vz = str;
        this.f3695vA = str2;
        this.f3703vy = new LinkedList<>();
    }

    public C1199ga(String str, String str2) {
        this(C1201gb.m4564cV(), str, str2);
    }

    /* renamed from: cP */
    public void mo8544cP() {
        synchronized (this.f3693mw) {
            if (this.f3701vG != -1 && this.f3697vC == -1) {
                this.f3697vC = SystemClock.elapsedRealtime();
                this.f3702vx.mo8557a(this);
            }
            C1201gb gbVar = this.f3702vx;
            C1201gb.m4566cZ().mo8577cP();
        }
    }

    /* renamed from: cQ */
    public void mo8545cQ() {
        synchronized (this.f3693mw) {
            if (this.f3701vG != -1) {
                C1200a aVar = new C1200a();
                aVar.mo8555cU();
                this.f3703vy.add(aVar);
                this.f3699vE++;
                C1201gb gbVar = this.f3702vx;
                C1201gb.m4566cZ().mo8578cQ();
                this.f3702vx.mo8557a(this);
            }
        }
    }

    /* renamed from: cR */
    public void mo8546cR() {
        synchronized (this.f3693mw) {
            if (this.f3701vG != -1 && !this.f3703vy.isEmpty()) {
                C1200a last = this.f3703vy.getLast();
                if (last.mo8553cS() == -1) {
                    last.mo8554cT();
                    this.f3702vx.mo8557a(this);
                }
            }
        }
    }

    /* renamed from: e */
    public void mo8547e(C0924av avVar) {
        synchronized (this.f3693mw) {
            this.f3700vF = SystemClock.elapsedRealtime();
            C1201gb gbVar = this.f3702vx;
            C1201gb.m4566cZ().mo8576b(avVar, this.f3700vF);
        }
    }

    /* renamed from: j */
    public void mo8548j(long j) {
        synchronized (this.f3693mw) {
            this.f3701vG = j;
            if (this.f3701vG != -1) {
                this.f3702vx.mo8557a(this);
            }
        }
    }

    /* renamed from: k */
    public void mo8549k(long j) {
        synchronized (this.f3693mw) {
            if (this.f3701vG != -1) {
                this.f3696vB = j;
                this.f3702vx.mo8557a(this);
            }
        }
    }

    /* renamed from: t */
    public void mo8550t(boolean z) {
        synchronized (this.f3693mw) {
            if (this.f3701vG != -1) {
                this.f3698vD = SystemClock.elapsedRealtime();
                if (!z) {
                    this.f3697vC = this.f3698vD;
                    this.f3702vx.mo8557a(this);
                }
            }
        }
    }

    public Bundle toBundle() {
        Bundle bundle;
        synchronized (this.f3693mw) {
            bundle = new Bundle();
            bundle.putString("seq_num", this.f3704vz);
            bundle.putString("slotid", this.f3695vA);
            bundle.putBoolean("ismediation", this.f3694uC);
            bundle.putLong("treq", this.f3700vF);
            bundle.putLong("tresponse", this.f3701vG);
            bundle.putLong("timp", this.f3697vC);
            bundle.putLong("tload", this.f3698vD);
            bundle.putLong("pcc", this.f3699vE);
            bundle.putLong("tfetch", this.f3696vB);
            ArrayList arrayList = new ArrayList();
            Iterator it = this.f3703vy.iterator();
            while (it.hasNext()) {
                arrayList.add(((C1200a) it.next()).toBundle());
            }
            bundle.putParcelableArrayList("tclick", arrayList);
        }
        return bundle;
    }

    /* renamed from: u */
    public void mo8552u(boolean z) {
        synchronized (this.f3693mw) {
            if (this.f3701vG != -1) {
                this.f3694uC = z;
                this.f3702vx.mo8557a(this);
            }
        }
    }
}
