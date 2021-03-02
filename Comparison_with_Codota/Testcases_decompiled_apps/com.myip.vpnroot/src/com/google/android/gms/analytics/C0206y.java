package com.google.android.gms.analytics;

/* renamed from: com.google.android.gms.analytics.y */
class C0206y implements C0154ac {

    /* renamed from: AN */
    private final long f327AN;

    /* renamed from: AO */
    private final int f328AO;

    /* renamed from: AP */
    private double f329AP;

    /* renamed from: AQ */
    private long f330AQ;

    /* renamed from: AR */
    private final Object f331AR;

    /* renamed from: AS */
    private final String f332AS;

    public C0206y(int i, long j, String str) {
        this.f331AR = new Object();
        this.f328AO = i;
        this.f329AP = (double) this.f328AO;
        this.f327AN = j;
        this.f332AS = str;
    }

    public C0206y(String str) {
        this(60, 2000, str);
    }

    /* renamed from: eK */
    public boolean mo3614eK() {
        boolean z;
        synchronized (this.f331AR) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.f329AP < ((double) this.f328AO)) {
                double d = ((double) (currentTimeMillis - this.f330AQ)) / ((double) this.f327AN);
                if (d > 0.0d) {
                    this.f329AP = Math.min((double) this.f328AO, d + this.f329AP);
                }
            }
            this.f330AQ = currentTimeMillis;
            if (this.f329AP >= 1.0d) {
                this.f329AP -= 1.0d;
                z = true;
            } else {
                C0207z.m309W("Excessive " + this.f332AS + " detected; call ignored.");
                z = false;
            }
        }
        return z;
    }
}
