package com.google.android.gms.drive.internal;

import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.internal.C1709pe;
import com.google.android.gms.internal.C1710pf;
import com.google.android.gms.internal.C1712pg;
import com.google.android.gms.internal.C1717pl;
import com.google.android.gms.internal.C1718pm;
import java.io.IOException;

/* renamed from: com.google.android.gms.drive.internal.ah */
public final class C0394ah extends C1712pg<C0394ah> {

    /* renamed from: Pd */
    public String f984Pd;

    /* renamed from: Pe */
    public long f985Pe;

    /* renamed from: Pf */
    public long f986Pf;
    public int versionCode;

    public C0394ah() {
        mo4927ic();
    }

    /* renamed from: g */
    public static C0394ah m1134g(byte[] bArr) throws C1717pl {
        return (C0394ah) C1718pm.m6089a(new C0394ah(), bArr);
    }

    /* renamed from: a */
    public void mo4922a(C1710pf pfVar) throws IOException {
        pfVar.mo10075s(1, this.versionCode);
        pfVar.mo10058b(2, this.f984Pd);
        pfVar.mo10061c(3, this.f985Pe);
        pfVar.mo10061c(4, this.f986Pf);
        super.mo4922a(pfVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public int mo4924c() {
        return super.mo4924c() + C1710pf.m6019u(1, this.versionCode) + C1710pf.m6016j(2, this.f984Pd) + C1710pf.m6008e(3, this.f985Pe) + C1710pf.m6008e(4, this.f986Pf);
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof C0394ah)) {
            return false;
        }
        C0394ah ahVar = (C0394ah) o;
        if (this.versionCode != ahVar.versionCode) {
            return false;
        }
        if (this.f984Pd == null) {
            if (ahVar.f984Pd != null) {
                return false;
            }
        } else if (!this.f984Pd.equals(ahVar.f984Pd)) {
            return false;
        }
        if (this.f985Pe == ahVar.f985Pe && this.f986Pf == ahVar.f986Pf) {
            return mo10081a(ahVar);
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.f984Pd == null ? 0 : this.f984Pd.hashCode()) + ((this.versionCode + 527) * 31)) * 31) + ((int) (this.f985Pe ^ (this.f985Pe >>> 32)))) * 31) + ((int) (this.f986Pf ^ (this.f986Pf >>> 32)))) * 31) + mo10082qx();
    }

    /* renamed from: ic */
    public C0394ah mo4927ic() {
        this.versionCode = 1;
        this.f984Pd = "";
        this.f985Pe = -1;
        this.f986Pf = -1;
        this.awy = null;
        this.awJ = -1;
        return this;
    }

    /* renamed from: m */
    public C0394ah mo4923b(C1709pe peVar) throws IOException {
        while (true) {
            int qg = peVar.mo10028qg();
            switch (qg) {
                case 0:
                    break;
                case 8:
                    this.versionCode = peVar.mo10031qj();
                    continue;
                case 18:
                    this.f984Pd = peVar.readString();
                    continue;
                case FitnessActivities.DANCING /*24*/:
                    this.f985Pe = peVar.mo10034qm();
                    continue;
                case 32:
                    this.f986Pf = peVar.mo10034qm();
                    continue;
                default:
                    if (!mo10080a(peVar, qg)) {
                        break;
                    } else {
                        continue;
                    }
            }
        }
        return this;
    }
}
