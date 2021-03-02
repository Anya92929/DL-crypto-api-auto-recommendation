package com.google.android.gms.internal;

import com.google.android.gms.fitness.FitnessActivities;
import java.io.IOException;

/* renamed from: com.google.android.gms.internal.d */
public interface C1026d {

    /* renamed from: com.google.android.gms.internal.d$a */
    public static final class C1027a extends C1712pg<C1027a> {

        /* renamed from: gu */
        private static volatile C1027a[] f3077gu;

        /* renamed from: gA */
        public String f3078gA;

        /* renamed from: gB */
        public long f3079gB;

        /* renamed from: gC */
        public boolean f3080gC;

        /* renamed from: gD */
        public C1027a[] f3081gD;

        /* renamed from: gE */
        public int[] f3082gE;

        /* renamed from: gF */
        public boolean f3083gF;

        /* renamed from: gv */
        public String f3084gv;

        /* renamed from: gw */
        public C1027a[] f3085gw;

        /* renamed from: gx */
        public C1027a[] f3086gx;

        /* renamed from: gy */
        public C1027a[] f3087gy;

        /* renamed from: gz */
        public String f3088gz;
        public int type;

        public C1027a() {
            mo8260s();
        }

        /* renamed from: r */
        public static C1027a[] m4181r() {
            if (f3077gu == null) {
                synchronized (C1716pk.awI) {
                    if (f3077gu == null) {
                        f3077gu = new C1027a[0];
                    }
                }
            }
            return f3077gu;
        }

        /* renamed from: a */
        public void mo4922a(C1710pf pfVar) throws IOException {
            pfVar.mo10075s(1, this.type);
            if (!this.f3084gv.equals("")) {
                pfVar.mo10058b(2, this.f3084gv);
            }
            if (this.f3085gw != null && this.f3085gw.length > 0) {
                for (C1027a aVar : this.f3085gw) {
                    if (aVar != null) {
                        pfVar.mo10053a(3, (C1718pm) aVar);
                    }
                }
            }
            if (this.f3086gx != null && this.f3086gx.length > 0) {
                for (C1027a aVar2 : this.f3086gx) {
                    if (aVar2 != null) {
                        pfVar.mo10053a(4, (C1718pm) aVar2);
                    }
                }
            }
            if (this.f3087gy != null && this.f3087gy.length > 0) {
                for (C1027a aVar3 : this.f3087gy) {
                    if (aVar3 != null) {
                        pfVar.mo10053a(5, (C1718pm) aVar3);
                    }
                }
            }
            if (!this.f3088gz.equals("")) {
                pfVar.mo10058b(6, this.f3088gz);
            }
            if (!this.f3078gA.equals("")) {
                pfVar.mo10058b(7, this.f3078gA);
            }
            if (this.f3079gB != 0) {
                pfVar.mo10057b(8, this.f3079gB);
            }
            if (this.f3083gF) {
                pfVar.mo10059b(9, this.f3083gF);
            }
            if (this.f3082gE != null && this.f3082gE.length > 0) {
                for (int s : this.f3082gE) {
                    pfVar.mo10075s(10, s);
                }
            }
            if (this.f3081gD != null && this.f3081gD.length > 0) {
                for (C1027a aVar4 : this.f3081gD) {
                    if (aVar4 != null) {
                        pfVar.mo10053a(11, (C1718pm) aVar4);
                    }
                }
            }
            if (this.f3080gC) {
                pfVar.mo10059b(12, this.f3080gC);
            }
            super.mo4922a(pfVar);
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public int mo4924c() {
            int c = super.mo4924c() + C1710pf.m6019u(1, this.type);
            if (!this.f3084gv.equals("")) {
                c += C1710pf.m6016j(2, this.f3084gv);
            }
            if (this.f3085gw != null && this.f3085gw.length > 0) {
                int i = c;
                for (C1027a aVar : this.f3085gw) {
                    if (aVar != null) {
                        i += C1710pf.m6002c(3, (C1718pm) aVar);
                    }
                }
                c = i;
            }
            if (this.f3086gx != null && this.f3086gx.length > 0) {
                int i2 = c;
                for (C1027a aVar2 : this.f3086gx) {
                    if (aVar2 != null) {
                        i2 += C1710pf.m6002c(4, (C1718pm) aVar2);
                    }
                }
                c = i2;
            }
            if (this.f3087gy != null && this.f3087gy.length > 0) {
                int i3 = c;
                for (C1027a aVar3 : this.f3087gy) {
                    if (aVar3 != null) {
                        i3 += C1710pf.m6002c(5, (C1718pm) aVar3);
                    }
                }
                c = i3;
            }
            if (!this.f3088gz.equals("")) {
                c += C1710pf.m6016j(6, this.f3088gz);
            }
            if (!this.f3078gA.equals("")) {
                c += C1710pf.m6016j(7, this.f3078gA);
            }
            if (this.f3079gB != 0) {
                c += C1710pf.m6004d(8, this.f3079gB);
            }
            if (this.f3083gF) {
                c += C1710pf.m6003c(9, this.f3083gF);
            }
            if (this.f3082gE != null && this.f3082gE.length > 0) {
                int i4 = 0;
                for (int gv : this.f3082gE) {
                    i4 += C1710pf.m6013gv(gv);
                }
                c = c + i4 + (this.f3082gE.length * 1);
            }
            if (this.f3081gD != null && this.f3081gD.length > 0) {
                for (C1027a aVar4 : this.f3081gD) {
                    if (aVar4 != null) {
                        c += C1710pf.m6002c(11, (C1718pm) aVar4);
                    }
                }
            }
            return this.f3080gC ? c + C1710pf.m6003c(12, this.f3080gC) : c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C1027a)) {
                return false;
            }
            C1027a aVar = (C1027a) o;
            if (this.type != aVar.type) {
                return false;
            }
            if (this.f3084gv == null) {
                if (aVar.f3084gv != null) {
                    return false;
                }
            } else if (!this.f3084gv.equals(aVar.f3084gv)) {
                return false;
            }
            if (!C1716pk.equals((Object[]) this.f3085gw, (Object[]) aVar.f3085gw) || !C1716pk.equals((Object[]) this.f3086gx, (Object[]) aVar.f3086gx) || !C1716pk.equals((Object[]) this.f3087gy, (Object[]) aVar.f3087gy)) {
                return false;
            }
            if (this.f3088gz == null) {
                if (aVar.f3088gz != null) {
                    return false;
                }
            } else if (!this.f3088gz.equals(aVar.f3088gz)) {
                return false;
            }
            if (this.f3078gA == null) {
                if (aVar.f3078gA != null) {
                    return false;
                }
            } else if (!this.f3078gA.equals(aVar.f3078gA)) {
                return false;
            }
            if (this.f3079gB == aVar.f3079gB && this.f3080gC == aVar.f3080gC && C1716pk.equals((Object[]) this.f3081gD, (Object[]) aVar.f3081gD) && C1716pk.equals(this.f3082gE, aVar.f3082gE) && this.f3083gF == aVar.f3083gF) {
                return mo10081a(aVar);
            }
            return false;
        }

        public int hashCode() {
            int i = 1231;
            int i2 = 0;
            int hashCode = ((this.f3088gz == null ? 0 : this.f3088gz.hashCode()) + (((((((((this.f3084gv == null ? 0 : this.f3084gv.hashCode()) + ((this.type + 527) * 31)) * 31) + C1716pk.hashCode((Object[]) this.f3085gw)) * 31) + C1716pk.hashCode((Object[]) this.f3086gx)) * 31) + C1716pk.hashCode((Object[]) this.f3087gy)) * 31)) * 31;
            if (this.f3078gA != null) {
                i2 = this.f3078gA.hashCode();
            }
            int hashCode2 = ((((((this.f3080gC ? 1231 : 1237) + ((((hashCode + i2) * 31) + ((int) (this.f3079gB ^ (this.f3079gB >>> 32)))) * 31)) * 31) + C1716pk.hashCode((Object[]) this.f3081gD)) * 31) + C1716pk.hashCode(this.f3082gE)) * 31;
            if (!this.f3083gF) {
                i = 1237;
            }
            return ((hashCode2 + i) * 31) + mo10082qx();
        }

        /* renamed from: l */
        public C1027a mo4923b(C1709pe peVar) throws IOException {
            int i;
            while (true) {
                int qg = peVar.mo10028qg();
                switch (qg) {
                    case 0:
                        break;
                    case 8:
                        int qj = peVar.mo10031qj();
                        switch (qj) {
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                                this.type = qj;
                                break;
                            default:
                                continue;
                        }
                    case 18:
                        this.f3084gv = peVar.readString();
                        continue;
                    case FitnessActivities.FENCING:
                        int b = C1721pp.m6106b(peVar, 26);
                        int length = this.f3085gw == null ? 0 : this.f3085gw.length;
                        C1027a[] aVarArr = new C1027a[(b + length)];
                        if (length != 0) {
                            System.arraycopy(this.f3085gw, 0, aVarArr, 0, length);
                        }
                        while (length < aVarArr.length - 1) {
                            aVarArr[length] = new C1027a();
                            peVar.mo10018a(aVarArr[length]);
                            peVar.mo10028qg();
                            length++;
                        }
                        aVarArr[length] = new C1027a();
                        peVar.mo10018a(aVarArr[length]);
                        this.f3085gw = aVarArr;
                        continue;
                    case FitnessActivities.HANDBALL:
                        int b2 = C1721pp.m6106b(peVar, 34);
                        int length2 = this.f3086gx == null ? 0 : this.f3086gx.length;
                        C1027a[] aVarArr2 = new C1027a[(b2 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.f3086gx, 0, aVarArr2, 0, length2);
                        }
                        while (length2 < aVarArr2.length - 1) {
                            aVarArr2[length2] = new C1027a();
                            peVar.mo10018a(aVarArr2[length2]);
                            peVar.mo10028qg();
                            length2++;
                        }
                        aVarArr2[length2] = new C1027a();
                        peVar.mo10018a(aVarArr2[length2]);
                        this.f3086gx = aVarArr2;
                        continue;
                    case FitnessActivities.KICKBOXING:
                        int b3 = C1721pp.m6106b(peVar, 42);
                        int length3 = this.f3087gy == null ? 0 : this.f3087gy.length;
                        C1027a[] aVarArr3 = new C1027a[(b3 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.f3087gy, 0, aVarArr3, 0, length3);
                        }
                        while (length3 < aVarArr3.length - 1) {
                            aVarArr3[length3] = new C1027a();
                            peVar.mo10018a(aVarArr3[length3]);
                            peVar.mo10028qg();
                            length3++;
                        }
                        aVarArr3[length3] = new C1027a();
                        peVar.mo10018a(aVarArr3[length3]);
                        this.f3087gy = aVarArr3;
                        continue;
                    case 50:
                        this.f3088gz = peVar.readString();
                        continue;
                    case FitnessActivities.RUNNING_TREADMILL:
                        this.f3078gA = peVar.readString();
                        continue;
                    case 64:
                        this.f3079gB = peVar.mo10030qi();
                        continue;
                    case FitnessActivities.SLEEP:
                        this.f3083gF = peVar.mo10032qk();
                        continue;
                    case FitnessActivities.STRENGTH_TRAINING:
                        int b4 = C1721pp.m6106b(peVar, 80);
                        int[] iArr = new int[b4];
                        int i2 = 0;
                        int i3 = 0;
                        while (i2 < b4) {
                            if (i2 != 0) {
                                peVar.mo10028qg();
                            }
                            int qj2 = peVar.mo10031qj();
                            switch (qj2) {
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                case 9:
                                case 10:
                                case 11:
                                case 12:
                                case 13:
                                case 14:
                                case 15:
                                case 16:
                                case 17:
                                    i = i3 + 1;
                                    iArr[i3] = qj2;
                                    break;
                                default:
                                    i = i3;
                                    break;
                            }
                            i2++;
                            i3 = i;
                        }
                        if (i3 != 0) {
                            int length4 = this.f3082gE == null ? 0 : this.f3082gE.length;
                            if (length4 != 0 || i3 != iArr.length) {
                                int[] iArr2 = new int[(length4 + i3)];
                                if (length4 != 0) {
                                    System.arraycopy(this.f3082gE, 0, iArr2, 0, length4);
                                }
                                System.arraycopy(iArr, 0, iArr2, length4, i3);
                                this.f3082gE = iArr2;
                                break;
                            } else {
                                this.f3082gE = iArr;
                                break;
                            }
                        } else {
                            continue;
                        }
                    case FitnessActivities.SWIMMING:
                        int go = peVar.mo10023go(peVar.mo10035qn());
                        int position = peVar.getPosition();
                        int i4 = 0;
                        while (peVar.mo10039qs() > 0) {
                            switch (peVar.mo10031qj()) {
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                case 9:
                                case 10:
                                case 11:
                                case 12:
                                case 13:
                                case 14:
                                case 15:
                                case 16:
                                case 17:
                                    i4++;
                                    break;
                            }
                        }
                        if (i4 != 0) {
                            peVar.mo10025gq(position);
                            int length5 = this.f3082gE == null ? 0 : this.f3082gE.length;
                            int[] iArr3 = new int[(i4 + length5)];
                            if (length5 != 0) {
                                System.arraycopy(this.f3082gE, 0, iArr3, 0, length5);
                            }
                            while (peVar.mo10039qs() > 0) {
                                int qj3 = peVar.mo10031qj();
                                switch (qj3) {
                                    case 1:
                                    case 2:
                                    case 3:
                                    case 4:
                                    case 5:
                                    case 6:
                                    case 7:
                                    case 8:
                                    case 9:
                                    case 10:
                                    case 11:
                                    case 12:
                                    case 13:
                                    case 14:
                                    case 15:
                                    case 16:
                                    case 17:
                                        iArr3[length5] = qj3;
                                        length5++;
                                        break;
                                }
                            }
                            this.f3082gE = iArr3;
                        }
                        peVar.mo10024gp(go);
                        continue;
                    case 90:
                        int b5 = C1721pp.m6106b(peVar, 90);
                        int length6 = this.f3081gD == null ? 0 : this.f3081gD.length;
                        C1027a[] aVarArr4 = new C1027a[(b5 + length6)];
                        if (length6 != 0) {
                            System.arraycopy(this.f3081gD, 0, aVarArr4, 0, length6);
                        }
                        while (length6 < aVarArr4.length - 1) {
                            aVarArr4[length6] = new C1027a();
                            peVar.mo10018a(aVarArr4[length6]);
                            peVar.mo10028qg();
                            length6++;
                        }
                        aVarArr4[length6] = new C1027a();
                        peVar.mo10018a(aVarArr4[length6]);
                        this.f3081gD = aVarArr4;
                        continue;
                    case FitnessActivities.WATER_POLO:
                        this.f3080gC = peVar.mo10032qk();
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

        /* renamed from: s */
        public C1027a mo8260s() {
            this.type = 1;
            this.f3084gv = "";
            this.f3085gw = m4181r();
            this.f3086gx = m4181r();
            this.f3087gy = m4181r();
            this.f3088gz = "";
            this.f3078gA = "";
            this.f3079gB = 0;
            this.f3080gC = false;
            this.f3081gD = m4181r();
            this.f3082gE = C1721pp.awL;
            this.f3083gF = false;
            this.awy = null;
            this.awJ = -1;
            return this;
        }
    }
}
