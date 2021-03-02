package com.google.android.gms.internal;

import com.google.android.gms.fitness.FitnessActivities;
import java.io.IOException;

/* renamed from: com.google.android.gms.internal.lk */
public interface C1499lk {

    /* renamed from: com.google.android.gms.internal.lk$a */
    public static final class C1500a extends C1712pg<C1500a> {
        public C1501a[] adt;

        /* renamed from: com.google.android.gms.internal.lk$a$a */
        public static final class C1501a extends C1712pg<C1501a> {
            private static volatile C1501a[] adu;
            public String adv;
            public String adw;
            public int viewId;

            public C1501a() {
                mo9221lP();
            }

            /* renamed from: lO */
            public static C1501a[] m5436lO() {
                if (adu == null) {
                    synchronized (C1716pk.awI) {
                        if (adu == null) {
                            adu = new C1501a[0];
                        }
                    }
                }
                return adu;
            }

            /* renamed from: a */
            public void mo4922a(C1710pf pfVar) throws IOException {
                if (!this.adv.equals("")) {
                    pfVar.mo10058b(1, this.adv);
                }
                if (!this.adw.equals("")) {
                    pfVar.mo10058b(2, this.adw);
                }
                if (this.viewId != 0) {
                    pfVar.mo10075s(3, this.viewId);
                }
                super.mo4922a(pfVar);
            }

            /* access modifiers changed from: protected */
            /* renamed from: c */
            public int mo4924c() {
                int c = super.mo4924c();
                if (!this.adv.equals("")) {
                    c += C1710pf.m6016j(1, this.adv);
                }
                if (!this.adw.equals("")) {
                    c += C1710pf.m6016j(2, this.adw);
                }
                return this.viewId != 0 ? c + C1710pf.m6019u(3, this.viewId) : c;
            }

            public boolean equals(Object o) {
                if (o == this) {
                    return true;
                }
                if (!(o instanceof C1501a)) {
                    return false;
                }
                C1501a aVar = (C1501a) o;
                if (this.adv == null) {
                    if (aVar.adv != null) {
                        return false;
                    }
                } else if (!this.adv.equals(aVar.adv)) {
                    return false;
                }
                if (this.adw == null) {
                    if (aVar.adw != null) {
                        return false;
                    }
                } else if (!this.adw.equals(aVar.adw)) {
                    return false;
                }
                if (this.viewId == aVar.viewId) {
                    return mo10081a(aVar);
                }
                return false;
            }

            public int hashCode() {
                int i = 0;
                int hashCode = ((this.adv == null ? 0 : this.adv.hashCode()) + 527) * 31;
                if (this.adw != null) {
                    i = this.adw.hashCode();
                }
                return ((((hashCode + i) * 31) + this.viewId) * 31) + mo10082qx();
            }

            /* renamed from: lP */
            public C1501a mo9221lP() {
                this.adv = "";
                this.adw = "";
                this.viewId = 0;
                this.awy = null;
                this.awJ = -1;
                return this;
            }

            /* renamed from: o */
            public C1501a mo4923b(C1709pe peVar) throws IOException {
                while (true) {
                    int qg = peVar.mo10028qg();
                    switch (qg) {
                        case 0:
                            break;
                        case 10:
                            this.adv = peVar.readString();
                            continue;
                        case 18:
                            this.adw = peVar.readString();
                            continue;
                        case FitnessActivities.DANCING:
                            this.viewId = peVar.mo10031qj();
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

        public C1500a() {
            mo9217lN();
        }

        /* renamed from: a */
        public void mo4922a(C1710pf pfVar) throws IOException {
            if (this.adt != null && this.adt.length > 0) {
                for (C1501a aVar : this.adt) {
                    if (aVar != null) {
                        pfVar.mo10053a(1, (C1718pm) aVar);
                    }
                }
            }
            super.mo4922a(pfVar);
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public int mo4924c() {
            int c = super.mo4924c();
            if (this.adt != null && this.adt.length > 0) {
                for (C1501a aVar : this.adt) {
                    if (aVar != null) {
                        c += C1710pf.m6002c(1, (C1718pm) aVar);
                    }
                }
            }
            return c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C1500a)) {
                return false;
            }
            C1500a aVar = (C1500a) o;
            if (C1716pk.equals((Object[]) this.adt, (Object[]) aVar.adt)) {
                return mo10081a(aVar);
            }
            return false;
        }

        public int hashCode() {
            return ((C1716pk.hashCode((Object[]) this.adt) + 527) * 31) + mo10082qx();
        }

        /* renamed from: lN */
        public C1500a mo9217lN() {
            this.adt = C1501a.m5436lO();
            this.awy = null;
            this.awJ = -1;
            return this;
        }

        /* renamed from: n */
        public C1500a mo4923b(C1709pe peVar) throws IOException {
            while (true) {
                int qg = peVar.mo10028qg();
                switch (qg) {
                    case 0:
                        break;
                    case 10:
                        int b = C1721pp.m6106b(peVar, 10);
                        int length = this.adt == null ? 0 : this.adt.length;
                        C1501a[] aVarArr = new C1501a[(b + length)];
                        if (length != 0) {
                            System.arraycopy(this.adt, 0, aVarArr, 0, length);
                        }
                        while (length < aVarArr.length - 1) {
                            aVarArr[length] = new C1501a();
                            peVar.mo10018a(aVarArr[length]);
                            peVar.mo10028qg();
                            length++;
                        }
                        aVarArr[length] = new C1501a();
                        peVar.mo10018a(aVarArr[length]);
                        this.adt = aVarArr;
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
}
