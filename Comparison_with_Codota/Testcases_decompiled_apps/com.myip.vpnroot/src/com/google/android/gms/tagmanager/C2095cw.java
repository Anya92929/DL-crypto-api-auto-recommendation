package com.google.android.gms.tagmanager;

/* renamed from: com.google.android.gms.tagmanager.cw */
class C2095cw implements C2058cg {

    /* renamed from: AN */
    private final long f4575AN;

    /* renamed from: AO */
    private final int f4576AO;

    /* renamed from: AP */
    private double f4577AP;

    /* renamed from: AR */
    private final Object f4578AR;
    private long are;

    public C2095cw() {
        this(60, 2000);
    }

    public C2095cw(int i, long j) {
        this.f4578AR = new Object();
        this.f4576AO = i;
        this.f4577AP = (double) this.f4576AO;
        this.f4575AN = j;
    }

    /* renamed from: eK */
    public boolean mo11572eK() {
        boolean z;
        synchronized (this.f4578AR) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.f4577AP < ((double) this.f4576AO)) {
                double d = ((double) (currentTimeMillis - this.are)) / ((double) this.f4575AN);
                if (d > 0.0d) {
                    this.f4577AP = Math.min((double) this.f4576AO, d + this.f4577AP);
                }
            }
            this.are = currentTimeMillis;
            if (this.f4577AP >= 1.0d) {
                this.f4577AP -= 1.0d;
                z = true;
            } else {
                C2028bh.m6819W("No more tokens available.");
                z = false;
            }
        }
        return z;
    }
}
