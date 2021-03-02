package com.google.android.gms.internal;

import com.google.android.gms.fitness.FitnessActivities;
import java.io.IOException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.pq */
public interface C1722pq {

    /* renamed from: com.google.android.gms.internal.pq$a */
    public static final class C1723a extends C1712pg<C1723a> {
        public String[] awT;
        public String[] awU;
        public int[] awV;

        public C1723a() {
            mo10114qH();
        }

        /* renamed from: a */
        public void mo4922a(C1710pf pfVar) throws IOException {
            if (this.awT != null && this.awT.length > 0) {
                for (String str : this.awT) {
                    if (str != null) {
                        pfVar.mo10058b(1, str);
                    }
                }
            }
            if (this.awU != null && this.awU.length > 0) {
                for (String str2 : this.awU) {
                    if (str2 != null) {
                        pfVar.mo10058b(2, str2);
                    }
                }
            }
            if (this.awV != null && this.awV.length > 0) {
                for (int s : this.awV) {
                    pfVar.mo10075s(3, s);
                }
            }
            super.mo4922a(pfVar);
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public int mo4924c() {
            int i;
            int c = super.mo4924c();
            if (this.awT == null || this.awT.length <= 0) {
                i = c;
            } else {
                int i2 = 0;
                int i3 = 0;
                for (String str : this.awT) {
                    if (str != null) {
                        i3++;
                        i2 += C1710pf.m6006df(str);
                    }
                }
                i = c + i2 + (i3 * 1);
            }
            if (this.awU != null && this.awU.length > 0) {
                int i4 = 0;
                int i5 = 0;
                for (String str2 : this.awU) {
                    if (str2 != null) {
                        i5++;
                        i4 += C1710pf.m6006df(str2);
                    }
                }
                i = i + i4 + (i5 * 1);
            }
            if (this.awV == null || this.awV.length <= 0) {
                return i;
            }
            int i6 = 0;
            for (int gv : this.awV) {
                i6 += C1710pf.m6013gv(gv);
            }
            return i + i6 + (this.awV.length * 1);
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C1723a)) {
                return false;
            }
            C1723a aVar = (C1723a) o;
            if (!C1716pk.equals((Object[]) this.awT, (Object[]) aVar.awT) || !C1716pk.equals((Object[]) this.awU, (Object[]) aVar.awU) || !C1716pk.equals(this.awV, aVar.awV)) {
                return false;
            }
            return mo10081a(aVar);
        }

        public int hashCode() {
            return ((((((C1716pk.hashCode((Object[]) this.awT) + 527) * 31) + C1716pk.hashCode((Object[]) this.awU)) * 31) + C1716pk.hashCode(this.awV)) * 31) + mo10082qx();
        }

        /* renamed from: qH */
        public C1723a mo10114qH() {
            this.awT = C1721pp.awQ;
            this.awU = C1721pp.awQ;
            this.awV = C1721pp.awL;
            this.awy = null;
            this.awJ = -1;
            return this;
        }

        /* renamed from: v */
        public C1723a mo4923b(C1709pe peVar) throws IOException {
            while (true) {
                int qg = peVar.mo10028qg();
                switch (qg) {
                    case 0:
                        break;
                    case 10:
                        int b = C1721pp.m6106b(peVar, 10);
                        int length = this.awT == null ? 0 : this.awT.length;
                        String[] strArr = new String[(b + length)];
                        if (length != 0) {
                            System.arraycopy(this.awT, 0, strArr, 0, length);
                        }
                        while (length < strArr.length - 1) {
                            strArr[length] = peVar.readString();
                            peVar.mo10028qg();
                            length++;
                        }
                        strArr[length] = peVar.readString();
                        this.awT = strArr;
                        continue;
                    case 18:
                        int b2 = C1721pp.m6106b(peVar, 18);
                        int length2 = this.awU == null ? 0 : this.awU.length;
                        String[] strArr2 = new String[(b2 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.awU, 0, strArr2, 0, length2);
                        }
                        while (length2 < strArr2.length - 1) {
                            strArr2[length2] = peVar.readString();
                            peVar.mo10028qg();
                            length2++;
                        }
                        strArr2[length2] = peVar.readString();
                        this.awU = strArr2;
                        continue;
                    case FitnessActivities.DANCING:
                        int b3 = C1721pp.m6106b(peVar, 24);
                        int length3 = this.awV == null ? 0 : this.awV.length;
                        int[] iArr = new int[(b3 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.awV, 0, iArr, 0, length3);
                        }
                        while (length3 < iArr.length - 1) {
                            iArr[length3] = peVar.mo10031qj();
                            peVar.mo10028qg();
                            length3++;
                        }
                        iArr[length3] = peVar.mo10031qj();
                        this.awV = iArr;
                        continue;
                    case FitnessActivities.FENCING:
                        int go = peVar.mo10023go(peVar.mo10035qn());
                        int position = peVar.getPosition();
                        int i = 0;
                        while (peVar.mo10039qs() > 0) {
                            peVar.mo10031qj();
                            i++;
                        }
                        peVar.mo10025gq(position);
                        int length4 = this.awV == null ? 0 : this.awV.length;
                        int[] iArr2 = new int[(i + length4)];
                        if (length4 != 0) {
                            System.arraycopy(this.awV, 0, iArr2, 0, length4);
                        }
                        while (length4 < iArr2.length) {
                            iArr2[length4] = peVar.mo10031qj();
                            length4++;
                        }
                        this.awV = iArr2;
                        peVar.mo10024gp(go);
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

    /* renamed from: com.google.android.gms.internal.pq$b */
    public static final class C1724b extends C1712pg<C1724b> {
        public int awW;
        public String awX;
        public String version;

        public C1724b() {
            mo10118qI();
        }

        /* renamed from: a */
        public void mo4922a(C1710pf pfVar) throws IOException {
            if (this.awW != 0) {
                pfVar.mo10075s(1, this.awW);
            }
            if (!this.awX.equals("")) {
                pfVar.mo10058b(2, this.awX);
            }
            if (!this.version.equals("")) {
                pfVar.mo10058b(3, this.version);
            }
            super.mo4922a(pfVar);
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public int mo4924c() {
            int c = super.mo4924c();
            if (this.awW != 0) {
                c += C1710pf.m6019u(1, this.awW);
            }
            if (!this.awX.equals("")) {
                c += C1710pf.m6016j(2, this.awX);
            }
            return !this.version.equals("") ? c + C1710pf.m6016j(3, this.version) : c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C1724b)) {
                return false;
            }
            C1724b bVar = (C1724b) o;
            if (this.awW != bVar.awW) {
                return false;
            }
            if (this.awX == null) {
                if (bVar.awX != null) {
                    return false;
                }
            } else if (!this.awX.equals(bVar.awX)) {
                return false;
            }
            if (this.version == null) {
                if (bVar.version != null) {
                    return false;
                }
            } else if (!this.version.equals(bVar.version)) {
                return false;
            }
            return mo10081a(bVar);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.awX == null ? 0 : this.awX.hashCode()) + ((this.awW + 527) * 31)) * 31;
            if (this.version != null) {
                i = this.version.hashCode();
            }
            return ((hashCode + i) * 31) + mo10082qx();
        }

        /* renamed from: qI */
        public C1724b mo10118qI() {
            this.awW = 0;
            this.awX = "";
            this.version = "";
            this.awy = null;
            this.awJ = -1;
            return this;
        }

        /* renamed from: w */
        public C1724b mo4923b(C1709pe peVar) throws IOException {
            while (true) {
                int qg = peVar.mo10028qg();
                switch (qg) {
                    case 0:
                        break;
                    case 8:
                        int qj = peVar.mo10031qj();
                        switch (qj) {
                            case 0:
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
                            case 18:
                            case 19:
                            case FitnessActivities.BOXING:
                            case 21:
                            case FitnessActivities.CIRCUIT_TRAINING:
                                this.awW = qj;
                                break;
                            default:
                                continue;
                        }
                    case 18:
                        this.awX = peVar.readString();
                        continue;
                    case FitnessActivities.FENCING:
                        this.version = peVar.readString();
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

    /* renamed from: com.google.android.gms.internal.pq$c */
    public static final class C1725c extends C1712pg<C1725c> {
        public long awY;
        public int awZ;
        public int axa;
        public boolean axb;
        public C1726d[] axc;
        public C1724b axd;
        public byte[] axe;
        public byte[] axf;
        public byte[] axg;
        public C1723a axh;
        public String axi;
        public String tag;

        public C1725c() {
            mo10122qJ();
        }

        /* renamed from: a */
        public void mo4922a(C1710pf pfVar) throws IOException {
            if (this.awY != 0) {
                pfVar.mo10057b(1, this.awY);
            }
            if (!this.tag.equals("")) {
                pfVar.mo10058b(2, this.tag);
            }
            if (this.axc != null && this.axc.length > 0) {
                for (C1726d dVar : this.axc) {
                    if (dVar != null) {
                        pfVar.mo10053a(3, (C1718pm) dVar);
                    }
                }
            }
            if (!Arrays.equals(this.axe, C1721pp.awS)) {
                pfVar.mo10054a(6, this.axe);
            }
            if (this.axh != null) {
                pfVar.mo10053a(7, (C1718pm) this.axh);
            }
            if (!Arrays.equals(this.axf, C1721pp.awS)) {
                pfVar.mo10054a(8, this.axf);
            }
            if (this.axd != null) {
                pfVar.mo10053a(9, (C1718pm) this.axd);
            }
            if (this.axb) {
                pfVar.mo10059b(10, this.axb);
            }
            if (this.awZ != 0) {
                pfVar.mo10075s(11, this.awZ);
            }
            if (this.axa != 0) {
                pfVar.mo10075s(12, this.axa);
            }
            if (!Arrays.equals(this.axg, C1721pp.awS)) {
                pfVar.mo10054a(13, this.axg);
            }
            if (!this.axi.equals("")) {
                pfVar.mo10058b(14, this.axi);
            }
            super.mo4922a(pfVar);
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public int mo4924c() {
            int c = super.mo4924c();
            if (this.awY != 0) {
                c += C1710pf.m6004d(1, this.awY);
            }
            if (!this.tag.equals("")) {
                c += C1710pf.m6016j(2, this.tag);
            }
            if (this.axc != null && this.axc.length > 0) {
                int i = c;
                for (C1726d dVar : this.axc) {
                    if (dVar != null) {
                        i += C1710pf.m6002c(3, (C1718pm) dVar);
                    }
                }
                c = i;
            }
            if (!Arrays.equals(this.axe, C1721pp.awS)) {
                c += C1710pf.m5999b(6, this.axe);
            }
            if (this.axh != null) {
                c += C1710pf.m6002c(7, (C1718pm) this.axh);
            }
            if (!Arrays.equals(this.axf, C1721pp.awS)) {
                c += C1710pf.m5999b(8, this.axf);
            }
            if (this.axd != null) {
                c += C1710pf.m6002c(9, (C1718pm) this.axd);
            }
            if (this.axb) {
                c += C1710pf.m6003c(10, this.axb);
            }
            if (this.awZ != 0) {
                c += C1710pf.m6019u(11, this.awZ);
            }
            if (this.axa != 0) {
                c += C1710pf.m6019u(12, this.axa);
            }
            if (!Arrays.equals(this.axg, C1721pp.awS)) {
                c += C1710pf.m5999b(13, this.axg);
            }
            return !this.axi.equals("") ? c + C1710pf.m6016j(14, this.axi) : c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C1725c)) {
                return false;
            }
            C1725c cVar = (C1725c) o;
            if (this.awY != cVar.awY) {
                return false;
            }
            if (this.tag == null) {
                if (cVar.tag != null) {
                    return false;
                }
            } else if (!this.tag.equals(cVar.tag)) {
                return false;
            }
            if (this.awZ != cVar.awZ || this.axa != cVar.axa || this.axb != cVar.axb || !C1716pk.equals((Object[]) this.axc, (Object[]) cVar.axc)) {
                return false;
            }
            if (this.axd == null) {
                if (cVar.axd != null) {
                    return false;
                }
            } else if (!this.axd.equals(cVar.axd)) {
                return false;
            }
            if (!Arrays.equals(this.axe, cVar.axe) || !Arrays.equals(this.axf, cVar.axf) || !Arrays.equals(this.axg, cVar.axg)) {
                return false;
            }
            if (this.axh == null) {
                if (cVar.axh != null) {
                    return false;
                }
            } else if (!this.axh.equals(cVar.axh)) {
                return false;
            }
            if (this.axi == null) {
                if (cVar.axi != null) {
                    return false;
                }
            } else if (!this.axi.equals(cVar.axi)) {
                return false;
            }
            return mo10081a(cVar);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.axh == null ? 0 : this.axh.hashCode()) + (((((((((this.axd == null ? 0 : this.axd.hashCode()) + (((((this.axb ? 1231 : 1237) + (((((((this.tag == null ? 0 : this.tag.hashCode()) + ((((int) (this.awY ^ (this.awY >>> 32))) + 527) * 31)) * 31) + this.awZ) * 31) + this.axa) * 31)) * 31) + C1716pk.hashCode((Object[]) this.axc)) * 31)) * 31) + Arrays.hashCode(this.axe)) * 31) + Arrays.hashCode(this.axf)) * 31) + Arrays.hashCode(this.axg)) * 31)) * 31;
            if (this.axi != null) {
                i = this.axi.hashCode();
            }
            return ((hashCode + i) * 31) + mo10082qx();
        }

        /* renamed from: qJ */
        public C1725c mo10122qJ() {
            this.awY = 0;
            this.tag = "";
            this.awZ = 0;
            this.axa = 0;
            this.axb = false;
            this.axc = C1726d.m6125qK();
            this.axd = null;
            this.axe = C1721pp.awS;
            this.axf = C1721pp.awS;
            this.axg = C1721pp.awS;
            this.axh = null;
            this.axi = "";
            this.awy = null;
            this.awJ = -1;
            return this;
        }

        /* renamed from: x */
        public C1725c mo4923b(C1709pe peVar) throws IOException {
            while (true) {
                int qg = peVar.mo10028qg();
                switch (qg) {
                    case 0:
                        break;
                    case 8:
                        this.awY = peVar.mo10030qi();
                        continue;
                    case 18:
                        this.tag = peVar.readString();
                        continue;
                    case FitnessActivities.FENCING:
                        int b = C1721pp.m6106b(peVar, 26);
                        int length = this.axc == null ? 0 : this.axc.length;
                        C1726d[] dVarArr = new C1726d[(b + length)];
                        if (length != 0) {
                            System.arraycopy(this.axc, 0, dVarArr, 0, length);
                        }
                        while (length < dVarArr.length - 1) {
                            dVarArr[length] = new C1726d();
                            peVar.mo10018a(dVarArr[length]);
                            peVar.mo10028qg();
                            length++;
                        }
                        dVarArr[length] = new C1726d();
                        peVar.mo10018a(dVarArr[length]);
                        this.axc = dVarArr;
                        continue;
                    case 50:
                        this.axe = peVar.readBytes();
                        continue;
                    case FitnessActivities.RUNNING_TREADMILL:
                        if (this.axh == null) {
                            this.axh = new C1723a();
                        }
                        peVar.mo10018a(this.axh);
                        continue;
                    case FitnessActivities.SKIING_BACK_COUNTRY:
                        this.axf = peVar.readBytes();
                        continue;
                    case FitnessActivities.SNOWMOBILE:
                        if (this.axd == null) {
                            this.axd = new C1724b();
                        }
                        peVar.mo10018a(this.axd);
                        continue;
                    case FitnessActivities.STRENGTH_TRAINING:
                        this.axb = peVar.mo10032qk();
                        continue;
                    case FitnessActivities.TREADMILL:
                        this.awZ = peVar.mo10031qj();
                        continue;
                    case FitnessActivities.WATER_POLO:
                        this.axa = peVar.mo10031qj();
                        continue;
                    case FitnessActivities.CURLING:
                        this.axg = peVar.readBytes();
                        continue;
                    case 114:
                        this.axi = peVar.readString();
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

    /* renamed from: com.google.android.gms.internal.pq$d */
    public static final class C1726d extends C1712pg<C1726d> {
        private static volatile C1726d[] axj;

        /* renamed from: fv */
        public String f4358fv;
        public String value;

        public C1726d() {
            mo10126qL();
        }

        /* renamed from: qK */
        public static C1726d[] m6125qK() {
            if (axj == null) {
                synchronized (C1716pk.awI) {
                    if (axj == null) {
                        axj = new C1726d[0];
                    }
                }
            }
            return axj;
        }

        /* renamed from: a */
        public void mo4922a(C1710pf pfVar) throws IOException {
            if (!this.f4358fv.equals("")) {
                pfVar.mo10058b(1, this.f4358fv);
            }
            if (!this.value.equals("")) {
                pfVar.mo10058b(2, this.value);
            }
            super.mo4922a(pfVar);
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public int mo4924c() {
            int c = super.mo4924c();
            if (!this.f4358fv.equals("")) {
                c += C1710pf.m6016j(1, this.f4358fv);
            }
            return !this.value.equals("") ? c + C1710pf.m6016j(2, this.value) : c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C1726d)) {
                return false;
            }
            C1726d dVar = (C1726d) o;
            if (this.f4358fv == null) {
                if (dVar.f4358fv != null) {
                    return false;
                }
            } else if (!this.f4358fv.equals(dVar.f4358fv)) {
                return false;
            }
            if (this.value == null) {
                if (dVar.value != null) {
                    return false;
                }
            } else if (!this.value.equals(dVar.value)) {
                return false;
            }
            return mo10081a(dVar);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.f4358fv == null ? 0 : this.f4358fv.hashCode()) + 527) * 31;
            if (this.value != null) {
                i = this.value.hashCode();
            }
            return ((hashCode + i) * 31) + mo10082qx();
        }

        /* renamed from: qL */
        public C1726d mo10126qL() {
            this.f4358fv = "";
            this.value = "";
            this.awy = null;
            this.awJ = -1;
            return this;
        }

        /* renamed from: y */
        public C1726d mo4923b(C1709pe peVar) throws IOException {
            while (true) {
                int qg = peVar.mo10028qg();
                switch (qg) {
                    case 0:
                        break;
                    case 10:
                        this.f4358fv = peVar.readString();
                        continue;
                    case 18:
                        this.value = peVar.readString();
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
