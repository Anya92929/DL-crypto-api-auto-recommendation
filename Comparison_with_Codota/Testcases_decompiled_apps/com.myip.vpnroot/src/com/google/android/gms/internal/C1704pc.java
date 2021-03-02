package com.google.android.gms.internal;

import com.google.android.gms.fitness.FitnessActivities;
import java.io.IOException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.pc */
public final class C1704pc extends C1712pg<C1704pc> {
    public C1705a[] avS;

    /* renamed from: com.google.android.gms.internal.pc$a */
    public static final class C1705a extends C1712pg<C1705a> {
        private static volatile C1705a[] avT;
        public C1706a avU;
        public String name;

        /* renamed from: com.google.android.gms.internal.pc$a$a */
        public static final class C1706a extends C1712pg<C1706a> {
            private static volatile C1706a[] avV;
            public C1707a avW;
            public int type;

            /* renamed from: com.google.android.gms.internal.pc$a$a$a */
            public static final class C1707a extends C1712pg<C1707a> {
                public byte[] avX;
                public String avY;
                public double avZ;
                public float awa;
                public long awb;
                public int awc;
                public int awd;
                public boolean awe;
                public C1705a[] awf;
                public C1706a[] awg;
                public String[] awh;
                public long[] awi;
                public float[] awj;
                public long awk;

                public C1707a() {
                    mo10015qf();
                }

                /* renamed from: a */
                public void mo4922a(C1710pf pfVar) throws IOException {
                    if (!Arrays.equals(this.avX, C1721pp.awS)) {
                        pfVar.mo10054a(1, this.avX);
                    }
                    if (!this.avY.equals("")) {
                        pfVar.mo10058b(2, this.avY);
                    }
                    if (Double.doubleToLongBits(this.avZ) != Double.doubleToLongBits(0.0d)) {
                        pfVar.mo10052a(3, this.avZ);
                    }
                    if (Float.floatToIntBits(this.awa) != Float.floatToIntBits(0.0f)) {
                        pfVar.mo10056b(4, this.awa);
                    }
                    if (this.awb != 0) {
                        pfVar.mo10057b(5, this.awb);
                    }
                    if (this.awc != 0) {
                        pfVar.mo10075s(6, this.awc);
                    }
                    if (this.awd != 0) {
                        pfVar.mo10076t(7, this.awd);
                    }
                    if (this.awe) {
                        pfVar.mo10059b(8, this.awe);
                    }
                    if (this.awf != null && this.awf.length > 0) {
                        for (C1705a aVar : this.awf) {
                            if (aVar != null) {
                                pfVar.mo10053a(9, (C1718pm) aVar);
                            }
                        }
                    }
                    if (this.awg != null && this.awg.length > 0) {
                        for (C1706a aVar2 : this.awg) {
                            if (aVar2 != null) {
                                pfVar.mo10053a(10, (C1718pm) aVar2);
                            }
                        }
                    }
                    if (this.awh != null && this.awh.length > 0) {
                        for (String str : this.awh) {
                            if (str != null) {
                                pfVar.mo10058b(11, str);
                            }
                        }
                    }
                    if (this.awi != null && this.awi.length > 0) {
                        for (long b : this.awi) {
                            pfVar.mo10057b(12, b);
                        }
                    }
                    if (this.awk != 0) {
                        pfVar.mo10057b(13, this.awk);
                    }
                    if (this.awj != null && this.awj.length > 0) {
                        for (float b2 : this.awj) {
                            pfVar.mo10056b(14, b2);
                        }
                    }
                    super.mo4922a(pfVar);
                }

                /* access modifiers changed from: protected */
                /* renamed from: c */
                public int mo4924c() {
                    int c = super.mo4924c();
                    if (!Arrays.equals(this.avX, C1721pp.awS)) {
                        c += C1710pf.m5999b(1, this.avX);
                    }
                    if (!this.avY.equals("")) {
                        c += C1710pf.m6016j(2, this.avY);
                    }
                    if (Double.doubleToLongBits(this.avZ) != Double.doubleToLongBits(0.0d)) {
                        c += C1710pf.m5997b(3, this.avZ);
                    }
                    if (Float.floatToIntBits(this.awa) != Float.floatToIntBits(0.0f)) {
                        c += C1710pf.m6001c(4, this.awa);
                    }
                    if (this.awb != 0) {
                        c += C1710pf.m6004d(5, this.awb);
                    }
                    if (this.awc != 0) {
                        c += C1710pf.m6019u(6, this.awc);
                    }
                    if (this.awd != 0) {
                        c += C1710pf.m6020v(7, this.awd);
                    }
                    if (this.awe) {
                        c += C1710pf.m6003c(8, this.awe);
                    }
                    if (this.awf != null && this.awf.length > 0) {
                        int i = c;
                        for (C1705a aVar : this.awf) {
                            if (aVar != null) {
                                i += C1710pf.m6002c(9, (C1718pm) aVar);
                            }
                        }
                        c = i;
                    }
                    if (this.awg != null && this.awg.length > 0) {
                        int i2 = c;
                        for (C1706a aVar2 : this.awg) {
                            if (aVar2 != null) {
                                i2 += C1710pf.m6002c(10, (C1718pm) aVar2);
                            }
                        }
                        c = i2;
                    }
                    if (this.awh != null && this.awh.length > 0) {
                        int i3 = 0;
                        int i4 = 0;
                        for (String str : this.awh) {
                            if (str != null) {
                                i4++;
                                i3 += C1710pf.m6006df(str);
                            }
                        }
                        c = c + i3 + (i4 * 1);
                    }
                    if (this.awi != null && this.awi.length > 0) {
                        int i5 = 0;
                        for (long D : this.awi) {
                            i5 += C1710pf.m5992D(D);
                        }
                        c = c + i5 + (this.awi.length * 1);
                    }
                    if (this.awk != 0) {
                        c += C1710pf.m6004d(13, this.awk);
                    }
                    return (this.awj == null || this.awj.length <= 0) ? c : c + (this.awj.length * 4) + (this.awj.length * 1);
                }

                public boolean equals(Object o) {
                    if (o == this) {
                        return true;
                    }
                    if (!(o instanceof C1707a)) {
                        return false;
                    }
                    C1707a aVar = (C1707a) o;
                    if (!Arrays.equals(this.avX, aVar.avX)) {
                        return false;
                    }
                    if (this.avY == null) {
                        if (aVar.avY != null) {
                            return false;
                        }
                    } else if (!this.avY.equals(aVar.avY)) {
                        return false;
                    }
                    if (Double.doubleToLongBits(this.avZ) == Double.doubleToLongBits(aVar.avZ) && Float.floatToIntBits(this.awa) == Float.floatToIntBits(aVar.awa) && this.awb == aVar.awb && this.awc == aVar.awc && this.awd == aVar.awd && this.awe == aVar.awe && C1716pk.equals((Object[]) this.awf, (Object[]) aVar.awf) && C1716pk.equals((Object[]) this.awg, (Object[]) aVar.awg) && C1716pk.equals((Object[]) this.awh, (Object[]) aVar.awh) && C1716pk.equals(this.awi, aVar.awi) && C1716pk.equals(this.awj, aVar.awj) && this.awk == aVar.awk) {
                        return mo10081a(aVar);
                    }
                    return false;
                }

                public int hashCode() {
                    int hashCode = (this.avY == null ? 0 : this.avY.hashCode()) + ((Arrays.hashCode(this.avX) + 527) * 31);
                    long doubleToLongBits = Double.doubleToLongBits(this.avZ);
                    return (((((((((((((((this.awe ? 1231 : 1237) + (((((((((((hashCode * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + Float.floatToIntBits(this.awa)) * 31) + ((int) (this.awb ^ (this.awb >>> 32)))) * 31) + this.awc) * 31) + this.awd) * 31)) * 31) + C1716pk.hashCode((Object[]) this.awf)) * 31) + C1716pk.hashCode((Object[]) this.awg)) * 31) + C1716pk.hashCode((Object[]) this.awh)) * 31) + C1716pk.hashCode(this.awi)) * 31) + C1716pk.hashCode(this.awj)) * 31) + ((int) (this.awk ^ (this.awk >>> 32)))) * 31) + mo10082qx();
                }

                /* renamed from: qf */
                public C1707a mo10015qf() {
                    this.avX = C1721pp.awS;
                    this.avY = "";
                    this.avZ = 0.0d;
                    this.awa = 0.0f;
                    this.awb = 0;
                    this.awc = 0;
                    this.awd = 0;
                    this.awe = false;
                    this.awf = C1705a.m5945qb();
                    this.awg = C1706a.m5951qd();
                    this.awh = C1721pp.awQ;
                    this.awi = C1721pp.awM;
                    this.awj = C1721pp.awN;
                    this.awk = 0;
                    this.awy = null;
                    this.awJ = -1;
                    return this;
                }

                /* renamed from: t */
                public C1707a mo4923b(C1709pe peVar) throws IOException {
                    while (true) {
                        int qg = peVar.mo10028qg();
                        switch (qg) {
                            case 0:
                                break;
                            case 10:
                                this.avX = peVar.readBytes();
                                continue;
                            case 18:
                                this.avY = peVar.readString();
                                continue;
                            case FitnessActivities.ELLIPTICAL:
                                this.avZ = peVar.readDouble();
                                continue;
                            case FitnessActivities.HORSEBACK_RIDING:
                                this.awa = peVar.readFloat();
                                continue;
                            case FitnessActivities.KAYAKING:
                                this.awb = peVar.mo10030qi();
                                continue;
                            case FitnessActivities.PARAGLIDING:
                                this.awc = peVar.mo10031qj();
                                continue;
                            case FitnessActivities.RUNNING_JOGGING:
                                this.awd = peVar.mo10033ql();
                                continue;
                            case 64:
                                this.awe = peVar.mo10032qk();
                                continue;
                            case FitnessActivities.SNOWMOBILE:
                                int b = C1721pp.m6106b(peVar, 74);
                                int length = this.awf == null ? 0 : this.awf.length;
                                C1705a[] aVarArr = new C1705a[(b + length)];
                                if (length != 0) {
                                    System.arraycopy(this.awf, 0, aVarArr, 0, length);
                                }
                                while (length < aVarArr.length - 1) {
                                    aVarArr[length] = new C1705a();
                                    peVar.mo10018a(aVarArr[length]);
                                    peVar.mo10028qg();
                                    length++;
                                }
                                aVarArr[length] = new C1705a();
                                peVar.mo10018a(aVarArr[length]);
                                this.awf = aVarArr;
                                continue;
                            case FitnessActivities.SWIMMING:
                                int b2 = C1721pp.m6106b(peVar, 82);
                                int length2 = this.awg == null ? 0 : this.awg.length;
                                C1706a[] aVarArr2 = new C1706a[(b2 + length2)];
                                if (length2 != 0) {
                                    System.arraycopy(this.awg, 0, aVarArr2, 0, length2);
                                }
                                while (length2 < aVarArr2.length - 1) {
                                    aVarArr2[length2] = new C1706a();
                                    peVar.mo10018a(aVarArr2[length2]);
                                    peVar.mo10028qg();
                                    length2++;
                                }
                                aVarArr2[length2] = new C1706a();
                                peVar.mo10018a(aVarArr2[length2]);
                                this.awg = aVarArr2;
                                continue;
                            case 90:
                                int b3 = C1721pp.m6106b(peVar, 90);
                                int length3 = this.awh == null ? 0 : this.awh.length;
                                String[] strArr = new String[(b3 + length3)];
                                if (length3 != 0) {
                                    System.arraycopy(this.awh, 0, strArr, 0, length3);
                                }
                                while (length3 < strArr.length - 1) {
                                    strArr[length3] = peVar.readString();
                                    peVar.mo10028qg();
                                    length3++;
                                }
                                strArr[length3] = peVar.readString();
                                this.awh = strArr;
                                continue;
                            case FitnessActivities.WATER_POLO:
                                int b4 = C1721pp.m6106b(peVar, 96);
                                int length4 = this.awi == null ? 0 : this.awi.length;
                                long[] jArr = new long[(b4 + length4)];
                                if (length4 != 0) {
                                    System.arraycopy(this.awi, 0, jArr, 0, length4);
                                }
                                while (length4 < jArr.length - 1) {
                                    jArr[length4] = peVar.mo10030qi();
                                    peVar.mo10028qg();
                                    length4++;
                                }
                                jArr[length4] = peVar.mo10030qi();
                                this.awi = jArr;
                                continue;
                            case FitnessActivities.WHEELCHAIR:
                                int go = peVar.mo10023go(peVar.mo10035qn());
                                int position = peVar.getPosition();
                                int i = 0;
                                while (peVar.mo10039qs() > 0) {
                                    peVar.mo10030qi();
                                    i++;
                                }
                                peVar.mo10025gq(position);
                                int length5 = this.awi == null ? 0 : this.awi.length;
                                long[] jArr2 = new long[(i + length5)];
                                if (length5 != 0) {
                                    System.arraycopy(this.awi, 0, jArr2, 0, length5);
                                }
                                while (length5 < jArr2.length) {
                                    jArr2[length5] = peVar.mo10030qi();
                                    length5++;
                                }
                                this.awi = jArr2;
                                peVar.mo10024gp(go);
                                continue;
                            case 104:
                                this.awk = peVar.mo10030qi();
                                continue;
                            case 114:
                                int qn = peVar.mo10035qn();
                                int go2 = peVar.mo10023go(qn);
                                int i2 = qn / 4;
                                int length6 = this.awj == null ? 0 : this.awj.length;
                                float[] fArr = new float[(i2 + length6)];
                                if (length6 != 0) {
                                    System.arraycopy(this.awj, 0, fArr, 0, length6);
                                }
                                while (length6 < fArr.length) {
                                    fArr[length6] = peVar.readFloat();
                                    length6++;
                                }
                                this.awj = fArr;
                                peVar.mo10024gp(go2);
                                continue;
                            case 117:
                                int b5 = C1721pp.m6106b(peVar, 117);
                                int length7 = this.awj == null ? 0 : this.awj.length;
                                float[] fArr2 = new float[(b5 + length7)];
                                if (length7 != 0) {
                                    System.arraycopy(this.awj, 0, fArr2, 0, length7);
                                }
                                while (length7 < fArr2.length - 1) {
                                    fArr2[length7] = peVar.readFloat();
                                    peVar.mo10028qg();
                                    length7++;
                                }
                                fArr2[length7] = peVar.readFloat();
                                this.awj = fArr2;
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

            public C1706a() {
                mo10011qe();
            }

            /* renamed from: qd */
            public static C1706a[] m5951qd() {
                if (avV == null) {
                    synchronized (C1716pk.awI) {
                        if (avV == null) {
                            avV = new C1706a[0];
                        }
                    }
                }
                return avV;
            }

            /* renamed from: a */
            public void mo4922a(C1710pf pfVar) throws IOException {
                pfVar.mo10075s(1, this.type);
                if (this.avW != null) {
                    pfVar.mo10053a(2, (C1718pm) this.avW);
                }
                super.mo4922a(pfVar);
            }

            /* access modifiers changed from: protected */
            /* renamed from: c */
            public int mo4924c() {
                int c = super.mo4924c() + C1710pf.m6019u(1, this.type);
                return this.avW != null ? c + C1710pf.m6002c(2, (C1718pm) this.avW) : c;
            }

            public boolean equals(Object o) {
                if (o == this) {
                    return true;
                }
                if (!(o instanceof C1706a)) {
                    return false;
                }
                C1706a aVar = (C1706a) o;
                if (this.type != aVar.type) {
                    return false;
                }
                if (this.avW == null) {
                    if (aVar.avW != null) {
                        return false;
                    }
                } else if (!this.avW.equals(aVar.avW)) {
                    return false;
                }
                return mo10081a(aVar);
            }

            public int hashCode() {
                return (((this.avW == null ? 0 : this.avW.hashCode()) + ((this.type + 527) * 31)) * 31) + mo10082qx();
            }

            /* renamed from: qe */
            public C1706a mo10011qe() {
                this.type = 1;
                this.avW = null;
                this.awy = null;
                this.awJ = -1;
                return this;
            }

            /* renamed from: s */
            public C1706a mo4923b(C1709pe peVar) throws IOException {
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
                                case 9:
                                case 10:
                                case 11:
                                case 12:
                                case 13:
                                case 14:
                                case 15:
                                    this.type = qj;
                                    break;
                                default:
                                    continue;
                            }
                        case 18:
                            if (this.avW == null) {
                                this.avW = new C1707a();
                            }
                            peVar.mo10018a(this.avW);
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

        public C1705a() {
            mo10007qc();
        }

        /* renamed from: qb */
        public static C1705a[] m5945qb() {
            if (avT == null) {
                synchronized (C1716pk.awI) {
                    if (avT == null) {
                        avT = new C1705a[0];
                    }
                }
            }
            return avT;
        }

        /* renamed from: a */
        public void mo4922a(C1710pf pfVar) throws IOException {
            pfVar.mo10058b(1, this.name);
            if (this.avU != null) {
                pfVar.mo10053a(2, (C1718pm) this.avU);
            }
            super.mo4922a(pfVar);
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public int mo4924c() {
            int c = super.mo4924c() + C1710pf.m6016j(1, this.name);
            return this.avU != null ? c + C1710pf.m6002c(2, (C1718pm) this.avU) : c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C1705a)) {
                return false;
            }
            C1705a aVar = (C1705a) o;
            if (this.name == null) {
                if (aVar.name != null) {
                    return false;
                }
            } else if (!this.name.equals(aVar.name)) {
                return false;
            }
            if (this.avU == null) {
                if (aVar.avU != null) {
                    return false;
                }
            } else if (!this.avU.equals(aVar.avU)) {
                return false;
            }
            return mo10081a(aVar);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.name == null ? 0 : this.name.hashCode()) + 527) * 31;
            if (this.avU != null) {
                i = this.avU.hashCode();
            }
            return ((hashCode + i) * 31) + mo10082qx();
        }

        /* renamed from: qc */
        public C1705a mo10007qc() {
            this.name = "";
            this.avU = null;
            this.awy = null;
            this.awJ = -1;
            return this;
        }

        /* renamed from: r */
        public C1705a mo4923b(C1709pe peVar) throws IOException {
            while (true) {
                int qg = peVar.mo10028qg();
                switch (qg) {
                    case 0:
                        break;
                    case 10:
                        this.name = peVar.readString();
                        continue;
                    case 18:
                        if (this.avU == null) {
                            this.avU = new C1706a();
                        }
                        peVar.mo10018a(this.avU);
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

    public C1704pc() {
        mo10004qa();
    }

    /* renamed from: n */
    public static C1704pc m5939n(byte[] bArr) throws C1717pl {
        return (C1704pc) C1718pm.m6089a(new C1704pc(), bArr);
    }

    /* renamed from: a */
    public void mo4922a(C1710pf pfVar) throws IOException {
        if (this.avS != null && this.avS.length > 0) {
            for (C1705a aVar : this.avS) {
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
        if (this.avS != null && this.avS.length > 0) {
            for (C1705a aVar : this.avS) {
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
        if (!(o instanceof C1704pc)) {
            return false;
        }
        C1704pc pcVar = (C1704pc) o;
        if (C1716pk.equals((Object[]) this.avS, (Object[]) pcVar.avS)) {
            return mo10081a(pcVar);
        }
        return false;
    }

    public int hashCode() {
        return ((C1716pk.hashCode((Object[]) this.avS) + 527) * 31) + mo10082qx();
    }

    /* renamed from: q */
    public C1704pc mo4923b(C1709pe peVar) throws IOException {
        while (true) {
            int qg = peVar.mo10028qg();
            switch (qg) {
                case 0:
                    break;
                case 10:
                    int b = C1721pp.m6106b(peVar, 10);
                    int length = this.avS == null ? 0 : this.avS.length;
                    C1705a[] aVarArr = new C1705a[(b + length)];
                    if (length != 0) {
                        System.arraycopy(this.avS, 0, aVarArr, 0, length);
                    }
                    while (length < aVarArr.length - 1) {
                        aVarArr[length] = new C1705a();
                        peVar.mo10018a(aVarArr[length]);
                        peVar.mo10028qg();
                        length++;
                    }
                    aVarArr[length] = new C1705a();
                    peVar.mo10018a(aVarArr[length]);
                    this.avS = aVarArr;
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

    /* renamed from: qa */
    public C1704pc mo10004qa() {
        this.avS = C1705a.m5945qb();
        this.awy = null;
        this.awJ = -1;
        return this;
    }
}
