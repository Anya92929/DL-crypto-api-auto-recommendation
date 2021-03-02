package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C1385ju;

/* renamed from: com.google.android.gms.tagmanager.bf */
class C2025bf implements C2058cg {

    /* renamed from: AN */
    private final long f4547AN;

    /* renamed from: AO */
    private final int f4548AO;

    /* renamed from: AP */
    private double f4549AP;

    /* renamed from: AQ */
    private long f4550AQ;

    /* renamed from: AR */
    private final Object f4551AR = new Object();

    /* renamed from: AS */
    private final String f4552AS;
    private final long apA;

    /* renamed from: yD */
    private final C1385ju f4553yD;

    public C2025bf(int i, long j, long j2, String str, C1385ju juVar) {
        this.f4548AO = i;
        this.f4549AP = (double) this.f4548AO;
        this.f4547AN = j;
        this.apA = j2;
        this.f4552AS = str;
        this.f4553yD = juVar;
    }

    /* renamed from: eK */
    public boolean mo11572eK() {
        boolean z = false;
        synchronized (this.f4551AR) {
            long currentTimeMillis = this.f4553yD.currentTimeMillis();
            if (currentTimeMillis - this.f4550AQ < this.apA) {
                C2028bh.m6819W("Excessive " + this.f4552AS + " detected; call ignored.");
            } else {
                if (this.f4549AP < ((double) this.f4548AO)) {
                    double d = ((double) (currentTimeMillis - this.f4550AQ)) / ((double) this.f4547AN);
                    if (d > 0.0d) {
                        this.f4549AP = Math.min((double) this.f4548AO, d + this.f4549AP);
                    }
                }
                this.f4550AQ = currentTimeMillis;
                if (this.f4549AP >= 1.0d) {
                    this.f4549AP -= 1.0d;
                    z = true;
                } else {
                    C2028bh.m6819W("Excessive " + this.f4552AS + " detected; call ignored.");
                }
            }
        }
        return z;
    }
}
