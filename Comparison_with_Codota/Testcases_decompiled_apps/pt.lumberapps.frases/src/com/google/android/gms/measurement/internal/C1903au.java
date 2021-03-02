package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzuf;

/* renamed from: com.google.android.gms.measurement.internal.au */
class C1903au {

    /* renamed from: a */
    final boolean f7118a;

    /* renamed from: b */
    final int f7119b;

    /* renamed from: c */
    long f7120c;

    /* renamed from: d */
    double f7121d;

    /* renamed from: e */
    long f7122e;

    /* renamed from: f */
    double f7123f;

    /* renamed from: g */
    long f7124g;

    /* renamed from: h */
    double f7125h;

    /* renamed from: i */
    final boolean f7126i;

    public C1903au(zzuf.zzd zzd) {
        boolean z;
        boolean z2 = true;
        zzab.zzy(zzd);
        if (zzd.amN == null || zzd.amN.intValue() == 0) {
            z = false;
        } else {
            if (zzd.amN.intValue() != 4) {
                if (zzd.amP == null) {
                    z = false;
                }
            } else if (zzd.amQ == null || zzd.amR == null) {
                z = false;
            }
            z = true;
        }
        if (z) {
            this.f7119b = zzd.amN.intValue();
            this.f7118a = (zzd.amO == null || !zzd.amO.booleanValue()) ? false : z2;
            if (zzd.amN.intValue() == 4) {
                if (this.f7118a) {
                    this.f7123f = Double.parseDouble(zzd.amQ);
                    this.f7125h = Double.parseDouble(zzd.amR);
                } else {
                    this.f7122e = Long.parseLong(zzd.amQ);
                    this.f7124g = Long.parseLong(zzd.amR);
                }
            } else if (this.f7118a) {
                this.f7121d = Double.parseDouble(zzd.amP);
            } else {
                this.f7120c = Long.parseLong(zzd.amP);
            }
        } else {
            this.f7119b = 0;
            this.f7118a = false;
        }
        this.f7126i = z;
    }

    /* renamed from: a */
    public Boolean mo9256a(double d) {
        boolean z = true;
        boolean z2 = false;
        if (!this.f7126i) {
            return null;
        }
        if (!this.f7118a) {
            return null;
        }
        switch (this.f7119b) {
            case 1:
                if (d >= this.f7121d) {
                    z = false;
                }
                return Boolean.valueOf(z);
            case 2:
                if (d <= this.f7121d) {
                    z = false;
                }
                return Boolean.valueOf(z);
            case 3:
                if (d == this.f7121d || Math.abs(d - this.f7121d) < 2.0d * Math.max(Math.ulp(d), Math.ulp(this.f7121d))) {
                    z2 = true;
                }
                return Boolean.valueOf(z2);
            case 4:
                if (d < this.f7123f || d > this.f7125h) {
                    z = false;
                }
                return Boolean.valueOf(z);
            default:
                return null;
        }
    }

    /* renamed from: a */
    public Boolean mo9257a(long j) {
        boolean z = true;
        if (!this.f7126i) {
            return null;
        }
        if (this.f7118a) {
            return null;
        }
        switch (this.f7119b) {
            case 1:
                if (j >= this.f7120c) {
                    z = false;
                }
                return Boolean.valueOf(z);
            case 2:
                if (j <= this.f7120c) {
                    z = false;
                }
                return Boolean.valueOf(z);
            case 3:
                if (j != this.f7120c) {
                    z = false;
                }
                return Boolean.valueOf(z);
            case 4:
                if (j < this.f7122e || j > this.f7124g) {
                    z = false;
                }
                return Boolean.valueOf(z);
            default:
                return null;
        }
    }
}
