package com.google.android.gms.analytics.internal;

/* renamed from: com.google.android.gms.analytics.internal.h */
public class C0560h {

    /* renamed from: a */
    private final long f3861a;

    /* renamed from: b */
    private final int f3862b;

    /* renamed from: c */
    private double f3863c;

    /* renamed from: d */
    private long f3864d;

    /* renamed from: e */
    private final Object f3865e;

    /* renamed from: f */
    private final String f3866f;

    public C0560h(int i, long j, String str) {
        this.f3865e = new Object();
        this.f3862b = i;
        this.f3863c = (double) this.f3862b;
        this.f3861a = j;
        this.f3866f = str;
    }

    public C0560h(String str) {
        this(60, 2000, str);
    }

    /* renamed from: a */
    public boolean mo6801a() {
        boolean z;
        synchronized (this.f3865e) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.f3863c < ((double) this.f3862b)) {
                double d = ((double) (currentTimeMillis - this.f3864d)) / ((double) this.f3861a);
                if (d > 0.0d) {
                    this.f3863c = Math.min((double) this.f3862b, d + this.f3863c);
                }
            }
            this.f3864d = currentTimeMillis;
            if (this.f3863c >= 1.0d) {
                this.f3863c -= 1.0d;
                z = true;
            } else {
                C0561i.m3263c("Excessive " + this.f3866f + " detected; call ignored.");
                z = false;
            }
        }
        return z;
    }
}
