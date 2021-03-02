package com.google.android.gms.internal;

import android.support.p000v4.media.TransportMediator;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.internal.C1026d;
import java.io.IOException;

/* renamed from: com.google.android.gms.internal.c */
public interface C0976c {

    /* renamed from: com.google.android.gms.internal.c$a */
    public static final class C0977a extends C1712pg<C0977a> {

        /* renamed from: fn */
        public int f2951fn;

        /* renamed from: fo */
        public int f2952fo;
        public int level;

        public C0977a() {
            mo8167b();
        }

        /* renamed from: a */
        public C0977a mo4923b(C1709pe peVar) throws IOException {
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
                                this.level = qj;
                                break;
                            default:
                                continue;
                        }
                    case 16:
                        this.f2951fn = peVar.mo10031qj();
                        continue;
                    case FitnessActivities.DANCING:
                        this.f2952fo = peVar.mo10031qj();
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

        /* renamed from: a */
        public void mo4922a(C1710pf pfVar) throws IOException {
            if (this.level != 1) {
                pfVar.mo10075s(1, this.level);
            }
            if (this.f2951fn != 0) {
                pfVar.mo10075s(2, this.f2951fn);
            }
            if (this.f2952fo != 0) {
                pfVar.mo10075s(3, this.f2952fo);
            }
            super.mo4922a(pfVar);
        }

        /* renamed from: b */
        public C0977a mo8167b() {
            this.level = 1;
            this.f2951fn = 0;
            this.f2952fo = 0;
            this.awy = null;
            this.awJ = -1;
            return this;
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public int mo4924c() {
            int c = super.mo4924c();
            if (this.level != 1) {
                c += C1710pf.m6019u(1, this.level);
            }
            if (this.f2951fn != 0) {
                c += C1710pf.m6019u(2, this.f2951fn);
            }
            return this.f2952fo != 0 ? c + C1710pf.m6019u(3, this.f2952fo) : c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C0977a)) {
                return false;
            }
            C0977a aVar = (C0977a) o;
            if (this.level == aVar.level && this.f2951fn == aVar.f2951fn && this.f2952fo == aVar.f2952fo) {
                return mo10081a(aVar);
            }
            return false;
        }

        public int hashCode() {
            return ((((((this.level + 527) * 31) + this.f2951fn) * 31) + this.f2952fo) * 31) + mo10082qx();
        }
    }

    /* renamed from: com.google.android.gms.internal.c$b */
    public static final class C0978b extends C1712pg<C0978b> {

        /* renamed from: fp */
        private static volatile C0978b[] f2953fp;

        /* renamed from: fq */
        public int[] f2954fq;

        /* renamed from: fr */
        public int f2955fr;

        /* renamed from: fs */
        public boolean f2956fs;

        /* renamed from: ft */
        public boolean f2957ft;
        public int name;

        public C0978b() {
            mo8171e();
        }

        /* renamed from: d */
        public static C0978b[] m4056d() {
            if (f2953fp == null) {
                synchronized (C1716pk.awI) {
                    if (f2953fp == null) {
                        f2953fp = new C0978b[0];
                    }
                }
            }
            return f2953fp;
        }

        /* renamed from: a */
        public void mo4922a(C1710pf pfVar) throws IOException {
            if (this.f2957ft) {
                pfVar.mo10059b(1, this.f2957ft);
            }
            pfVar.mo10075s(2, this.f2955fr);
            if (this.f2954fq != null && this.f2954fq.length > 0) {
                for (int s : this.f2954fq) {
                    pfVar.mo10075s(3, s);
                }
            }
            if (this.name != 0) {
                pfVar.mo10075s(4, this.name);
            }
            if (this.f2956fs) {
                pfVar.mo10059b(6, this.f2956fs);
            }
            super.mo4922a(pfVar);
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public int mo4924c() {
            int i;
            int i2 = 0;
            int c = super.mo4924c();
            if (this.f2957ft) {
                c += C1710pf.m6003c(1, this.f2957ft);
            }
            int u = C1710pf.m6019u(2, this.f2955fr) + c;
            if (this.f2954fq == null || this.f2954fq.length <= 0) {
                i = u;
            } else {
                for (int gv : this.f2954fq) {
                    i2 += C1710pf.m6013gv(gv);
                }
                i = u + i2 + (this.f2954fq.length * 1);
            }
            if (this.name != 0) {
                i += C1710pf.m6019u(4, this.name);
            }
            return this.f2956fs ? i + C1710pf.m6003c(6, this.f2956fs) : i;
        }

        /* renamed from: c */
        public C0978b mo4923b(C1709pe peVar) throws IOException {
            while (true) {
                int qg = peVar.mo10028qg();
                switch (qg) {
                    case 0:
                        break;
                    case 8:
                        this.f2957ft = peVar.mo10032qk();
                        continue;
                    case 16:
                        this.f2955fr = peVar.mo10031qj();
                        continue;
                    case FitnessActivities.DANCING:
                        int b = C1721pp.m6106b(peVar, 24);
                        int length = this.f2954fq == null ? 0 : this.f2954fq.length;
                        int[] iArr = new int[(b + length)];
                        if (length != 0) {
                            System.arraycopy(this.f2954fq, 0, iArr, 0, length);
                        }
                        while (length < iArr.length - 1) {
                            iArr[length] = peVar.mo10031qj();
                            peVar.mo10028qg();
                            length++;
                        }
                        iArr[length] = peVar.mo10031qj();
                        this.f2954fq = iArr;
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
                        int length2 = this.f2954fq == null ? 0 : this.f2954fq.length;
                        int[] iArr2 = new int[(i + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.f2954fq, 0, iArr2, 0, length2);
                        }
                        while (length2 < iArr2.length) {
                            iArr2[length2] = peVar.mo10031qj();
                            length2++;
                        }
                        this.f2954fq = iArr2;
                        peVar.mo10024gp(go);
                        continue;
                    case 32:
                        this.name = peVar.mo10031qj();
                        continue;
                    case FitnessActivities.PARAGLIDING:
                        this.f2956fs = peVar.mo10032qk();
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

        /* renamed from: e */
        public C0978b mo8171e() {
            this.f2954fq = C1721pp.awL;
            this.f2955fr = 0;
            this.name = 0;
            this.f2956fs = false;
            this.f2957ft = false;
            this.awy = null;
            this.awJ = -1;
            return this;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C0978b)) {
                return false;
            }
            C0978b bVar = (C0978b) o;
            if (C1716pk.equals(this.f2954fq, bVar.f2954fq) && this.f2955fr == bVar.f2955fr && this.name == bVar.name && this.f2956fs == bVar.f2956fs && this.f2957ft == bVar.f2957ft) {
                return mo10081a(bVar);
            }
            return false;
        }

        public int hashCode() {
            int i = 1231;
            int hashCode = ((this.f2956fs ? 1231 : 1237) + ((((((C1716pk.hashCode(this.f2954fq) + 527) * 31) + this.f2955fr) * 31) + this.name) * 31)) * 31;
            if (!this.f2957ft) {
                i = 1237;
            }
            return ((hashCode + i) * 31) + mo10082qx();
        }
    }

    /* renamed from: com.google.android.gms.internal.c$c */
    public static final class C0979c extends C1712pg<C0979c> {

        /* renamed from: fu */
        private static volatile C0979c[] f2958fu;

        /* renamed from: fv */
        public String f2959fv;

        /* renamed from: fw */
        public long f2960fw;

        /* renamed from: fx */
        public long f2961fx;

        /* renamed from: fy */
        public boolean f2962fy;

        /* renamed from: fz */
        public long f2963fz;

        public C0979c() {
            mo8176g();
        }

        /* renamed from: f */
        public static C0979c[] m4062f() {
            if (f2958fu == null) {
                synchronized (C1716pk.awI) {
                    if (f2958fu == null) {
                        f2958fu = new C0979c[0];
                    }
                }
            }
            return f2958fu;
        }

        /* renamed from: a */
        public void mo4922a(C1710pf pfVar) throws IOException {
            if (!this.f2959fv.equals("")) {
                pfVar.mo10058b(1, this.f2959fv);
            }
            if (this.f2960fw != 0) {
                pfVar.mo10057b(2, this.f2960fw);
            }
            if (this.f2961fx != 2147483647L) {
                pfVar.mo10057b(3, this.f2961fx);
            }
            if (this.f2962fy) {
                pfVar.mo10059b(4, this.f2962fy);
            }
            if (this.f2963fz != 0) {
                pfVar.mo10057b(5, this.f2963fz);
            }
            super.mo4922a(pfVar);
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public int mo4924c() {
            int c = super.mo4924c();
            if (!this.f2959fv.equals("")) {
                c += C1710pf.m6016j(1, this.f2959fv);
            }
            if (this.f2960fw != 0) {
                c += C1710pf.m6004d(2, this.f2960fw);
            }
            if (this.f2961fx != 2147483647L) {
                c += C1710pf.m6004d(3, this.f2961fx);
            }
            if (this.f2962fy) {
                c += C1710pf.m6003c(4, this.f2962fy);
            }
            return this.f2963fz != 0 ? c + C1710pf.m6004d(5, this.f2963fz) : c;
        }

        /* renamed from: d */
        public C0979c mo4923b(C1709pe peVar) throws IOException {
            while (true) {
                int qg = peVar.mo10028qg();
                switch (qg) {
                    case 0:
                        break;
                    case 10:
                        this.f2959fv = peVar.readString();
                        continue;
                    case 16:
                        this.f2960fw = peVar.mo10030qi();
                        continue;
                    case FitnessActivities.DANCING:
                        this.f2961fx = peVar.mo10030qi();
                        continue;
                    case 32:
                        this.f2962fy = peVar.mo10032qk();
                        continue;
                    case FitnessActivities.KAYAKING:
                        this.f2963fz = peVar.mo10030qi();
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

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C0979c)) {
                return false;
            }
            C0979c cVar = (C0979c) o;
            if (this.f2959fv == null) {
                if (cVar.f2959fv != null) {
                    return false;
                }
            } else if (!this.f2959fv.equals(cVar.f2959fv)) {
                return false;
            }
            if (this.f2960fw == cVar.f2960fw && this.f2961fx == cVar.f2961fx && this.f2962fy == cVar.f2962fy && this.f2963fz == cVar.f2963fz) {
                return mo10081a(cVar);
            }
            return false;
        }

        /* renamed from: g */
        public C0979c mo8176g() {
            this.f2959fv = "";
            this.f2960fw = 0;
            this.f2961fx = 2147483647L;
            this.f2962fy = false;
            this.f2963fz = 0;
            this.awy = null;
            this.awJ = -1;
            return this;
        }

        public int hashCode() {
            return (((((this.f2962fy ? 1231 : 1237) + (((((((this.f2959fv == null ? 0 : this.f2959fv.hashCode()) + 527) * 31) + ((int) (this.f2960fw ^ (this.f2960fw >>> 32)))) * 31) + ((int) (this.f2961fx ^ (this.f2961fx >>> 32)))) * 31)) * 31) + ((int) (this.f2963fz ^ (this.f2963fz >>> 32)))) * 31) + mo10082qx();
        }
    }

    /* renamed from: com.google.android.gms.internal.c$d */
    public static final class C0980d extends C1712pg<C0980d> {

        /* renamed from: fA */
        public C1026d.C1027a[] f2964fA;

        /* renamed from: fB */
        public C1026d.C1027a[] f2965fB;

        /* renamed from: fC */
        public C0979c[] f2966fC;

        public C0980d() {
            mo8180h();
        }

        /* renamed from: a */
        public void mo4922a(C1710pf pfVar) throws IOException {
            if (this.f2964fA != null && this.f2964fA.length > 0) {
                for (C1026d.C1027a aVar : this.f2964fA) {
                    if (aVar != null) {
                        pfVar.mo10053a(1, (C1718pm) aVar);
                    }
                }
            }
            if (this.f2965fB != null && this.f2965fB.length > 0) {
                for (C1026d.C1027a aVar2 : this.f2965fB) {
                    if (aVar2 != null) {
                        pfVar.mo10053a(2, (C1718pm) aVar2);
                    }
                }
            }
            if (this.f2966fC != null && this.f2966fC.length > 0) {
                for (C0979c cVar : this.f2966fC) {
                    if (cVar != null) {
                        pfVar.mo10053a(3, (C1718pm) cVar);
                    }
                }
            }
            super.mo4922a(pfVar);
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public int mo4924c() {
            int c = super.mo4924c();
            if (this.f2964fA != null && this.f2964fA.length > 0) {
                int i = c;
                for (C1026d.C1027a aVar : this.f2964fA) {
                    if (aVar != null) {
                        i += C1710pf.m6002c(1, (C1718pm) aVar);
                    }
                }
                c = i;
            }
            if (this.f2965fB != null && this.f2965fB.length > 0) {
                int i2 = c;
                for (C1026d.C1027a aVar2 : this.f2965fB) {
                    if (aVar2 != null) {
                        i2 += C1710pf.m6002c(2, (C1718pm) aVar2);
                    }
                }
                c = i2;
            }
            if (this.f2966fC != null && this.f2966fC.length > 0) {
                for (C0979c cVar : this.f2966fC) {
                    if (cVar != null) {
                        c += C1710pf.m6002c(3, (C1718pm) cVar);
                    }
                }
            }
            return c;
        }

        /* renamed from: e */
        public C0980d mo4923b(C1709pe peVar) throws IOException {
            while (true) {
                int qg = peVar.mo10028qg();
                switch (qg) {
                    case 0:
                        break;
                    case 10:
                        int b = C1721pp.m6106b(peVar, 10);
                        int length = this.f2964fA == null ? 0 : this.f2964fA.length;
                        C1026d.C1027a[] aVarArr = new C1026d.C1027a[(b + length)];
                        if (length != 0) {
                            System.arraycopy(this.f2964fA, 0, aVarArr, 0, length);
                        }
                        while (length < aVarArr.length - 1) {
                            aVarArr[length] = new C1026d.C1027a();
                            peVar.mo10018a(aVarArr[length]);
                            peVar.mo10028qg();
                            length++;
                        }
                        aVarArr[length] = new C1026d.C1027a();
                        peVar.mo10018a(aVarArr[length]);
                        this.f2964fA = aVarArr;
                        continue;
                    case 18:
                        int b2 = C1721pp.m6106b(peVar, 18);
                        int length2 = this.f2965fB == null ? 0 : this.f2965fB.length;
                        C1026d.C1027a[] aVarArr2 = new C1026d.C1027a[(b2 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.f2965fB, 0, aVarArr2, 0, length2);
                        }
                        while (length2 < aVarArr2.length - 1) {
                            aVarArr2[length2] = new C1026d.C1027a();
                            peVar.mo10018a(aVarArr2[length2]);
                            peVar.mo10028qg();
                            length2++;
                        }
                        aVarArr2[length2] = new C1026d.C1027a();
                        peVar.mo10018a(aVarArr2[length2]);
                        this.f2965fB = aVarArr2;
                        continue;
                    case FitnessActivities.FENCING:
                        int b3 = C1721pp.m6106b(peVar, 26);
                        int length3 = this.f2966fC == null ? 0 : this.f2966fC.length;
                        C0979c[] cVarArr = new C0979c[(b3 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.f2966fC, 0, cVarArr, 0, length3);
                        }
                        while (length3 < cVarArr.length - 1) {
                            cVarArr[length3] = new C0979c();
                            peVar.mo10018a(cVarArr[length3]);
                            peVar.mo10028qg();
                            length3++;
                        }
                        cVarArr[length3] = new C0979c();
                        peVar.mo10018a(cVarArr[length3]);
                        this.f2966fC = cVarArr;
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

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C0980d)) {
                return false;
            }
            C0980d dVar = (C0980d) o;
            if (!C1716pk.equals((Object[]) this.f2964fA, (Object[]) dVar.f2964fA) || !C1716pk.equals((Object[]) this.f2965fB, (Object[]) dVar.f2965fB) || !C1716pk.equals((Object[]) this.f2966fC, (Object[]) dVar.f2966fC)) {
                return false;
            }
            return mo10081a(dVar);
        }

        /* renamed from: h */
        public C0980d mo8180h() {
            this.f2964fA = C1026d.C1027a.m4181r();
            this.f2965fB = C1026d.C1027a.m4181r();
            this.f2966fC = C0979c.m4062f();
            this.awy = null;
            this.awJ = -1;
            return this;
        }

        public int hashCode() {
            return ((((((C1716pk.hashCode((Object[]) this.f2964fA) + 527) * 31) + C1716pk.hashCode((Object[]) this.f2965fB)) * 31) + C1716pk.hashCode((Object[]) this.f2966fC)) * 31) + mo10082qx();
        }
    }

    /* renamed from: com.google.android.gms.internal.c$e */
    public static final class C0981e extends C1712pg<C0981e> {

        /* renamed from: fD */
        private static volatile C0981e[] f2967fD;
        public int key;
        public int value;

        public C0981e() {
            mo8185j();
        }

        /* renamed from: i */
        public static C0981e[] m4073i() {
            if (f2967fD == null) {
                synchronized (C1716pk.awI) {
                    if (f2967fD == null) {
                        f2967fD = new C0981e[0];
                    }
                }
            }
            return f2967fD;
        }

        /* renamed from: a */
        public void mo4922a(C1710pf pfVar) throws IOException {
            pfVar.mo10075s(1, this.key);
            pfVar.mo10075s(2, this.value);
            super.mo4922a(pfVar);
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public int mo4924c() {
            return super.mo4924c() + C1710pf.m6019u(1, this.key) + C1710pf.m6019u(2, this.value);
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C0981e)) {
                return false;
            }
            C0981e eVar = (C0981e) o;
            if (this.key == eVar.key && this.value == eVar.value) {
                return mo10081a(eVar);
            }
            return false;
        }

        /* renamed from: f */
        public C0981e mo4923b(C1709pe peVar) throws IOException {
            while (true) {
                int qg = peVar.mo10028qg();
                switch (qg) {
                    case 0:
                        break;
                    case 8:
                        this.key = peVar.mo10031qj();
                        continue;
                    case 16:
                        this.value = peVar.mo10031qj();
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

        public int hashCode() {
            return ((((this.key + 527) * 31) + this.value) * 31) + mo10082qx();
        }

        /* renamed from: j */
        public C0981e mo8185j() {
            this.key = 0;
            this.value = 0;
            this.awy = null;
            this.awJ = -1;
            return this;
        }
    }

    /* renamed from: com.google.android.gms.internal.c$f */
    public static final class C0982f extends C1712pg<C0982f> {

        /* renamed from: fE */
        public String[] f2968fE;

        /* renamed from: fF */
        public String[] f2969fF;

        /* renamed from: fG */
        public C1026d.C1027a[] f2970fG;

        /* renamed from: fH */
        public C0981e[] f2971fH;

        /* renamed from: fI */
        public C0978b[] f2972fI;

        /* renamed from: fJ */
        public C0978b[] f2973fJ;

        /* renamed from: fK */
        public C0978b[] f2974fK;

        /* renamed from: fL */
        public C0983g[] f2975fL;

        /* renamed from: fM */
        public String f2976fM;

        /* renamed from: fN */
        public String f2977fN;

        /* renamed from: fO */
        public String f2978fO;

        /* renamed from: fP */
        public C0977a f2979fP;

        /* renamed from: fQ */
        public float f2980fQ;

        /* renamed from: fR */
        public boolean f2981fR;

        /* renamed from: fS */
        public String[] f2982fS;

        /* renamed from: fT */
        public int f2983fT;
        public String version;

        public C0982f() {
            mo8189k();
        }

        /* renamed from: a */
        public static C0982f m4079a(byte[] bArr) throws C1717pl {
            return (C0982f) C1718pm.m6089a(new C0982f(), bArr);
        }

        /* renamed from: a */
        public void mo4922a(C1710pf pfVar) throws IOException {
            if (this.f2969fF != null && this.f2969fF.length > 0) {
                for (String str : this.f2969fF) {
                    if (str != null) {
                        pfVar.mo10058b(1, str);
                    }
                }
            }
            if (this.f2970fG != null && this.f2970fG.length > 0) {
                for (C1026d.C1027a aVar : this.f2970fG) {
                    if (aVar != null) {
                        pfVar.mo10053a(2, (C1718pm) aVar);
                    }
                }
            }
            if (this.f2971fH != null && this.f2971fH.length > 0) {
                for (C0981e eVar : this.f2971fH) {
                    if (eVar != null) {
                        pfVar.mo10053a(3, (C1718pm) eVar);
                    }
                }
            }
            if (this.f2972fI != null && this.f2972fI.length > 0) {
                for (C0978b bVar : this.f2972fI) {
                    if (bVar != null) {
                        pfVar.mo10053a(4, (C1718pm) bVar);
                    }
                }
            }
            if (this.f2973fJ != null && this.f2973fJ.length > 0) {
                for (C0978b bVar2 : this.f2973fJ) {
                    if (bVar2 != null) {
                        pfVar.mo10053a(5, (C1718pm) bVar2);
                    }
                }
            }
            if (this.f2974fK != null && this.f2974fK.length > 0) {
                for (C0978b bVar3 : this.f2974fK) {
                    if (bVar3 != null) {
                        pfVar.mo10053a(6, (C1718pm) bVar3);
                    }
                }
            }
            if (this.f2975fL != null && this.f2975fL.length > 0) {
                for (C0983g gVar : this.f2975fL) {
                    if (gVar != null) {
                        pfVar.mo10053a(7, (C1718pm) gVar);
                    }
                }
            }
            if (!this.f2976fM.equals("")) {
                pfVar.mo10058b(9, this.f2976fM);
            }
            if (!this.f2977fN.equals("")) {
                pfVar.mo10058b(10, this.f2977fN);
            }
            if (!this.f2978fO.equals("0")) {
                pfVar.mo10058b(12, this.f2978fO);
            }
            if (!this.version.equals("")) {
                pfVar.mo10058b(13, this.version);
            }
            if (this.f2979fP != null) {
                pfVar.mo10053a(14, (C1718pm) this.f2979fP);
            }
            if (Float.floatToIntBits(this.f2980fQ) != Float.floatToIntBits(0.0f)) {
                pfVar.mo10056b(15, this.f2980fQ);
            }
            if (this.f2982fS != null && this.f2982fS.length > 0) {
                for (String str2 : this.f2982fS) {
                    if (str2 != null) {
                        pfVar.mo10058b(16, str2);
                    }
                }
            }
            if (this.f2983fT != 0) {
                pfVar.mo10075s(17, this.f2983fT);
            }
            if (this.f2981fR) {
                pfVar.mo10059b(18, this.f2981fR);
            }
            if (this.f2968fE != null && this.f2968fE.length > 0) {
                for (String str3 : this.f2968fE) {
                    if (str3 != null) {
                        pfVar.mo10058b(19, str3);
                    }
                }
            }
            super.mo4922a(pfVar);
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public int mo4924c() {
            int i;
            int c = super.mo4924c();
            if (this.f2969fF == null || this.f2969fF.length <= 0) {
                i = c;
            } else {
                int i2 = 0;
                int i3 = 0;
                for (String str : this.f2969fF) {
                    if (str != null) {
                        i3++;
                        i2 += C1710pf.m6006df(str);
                    }
                }
                i = c + i2 + (i3 * 1);
            }
            if (this.f2970fG != null && this.f2970fG.length > 0) {
                int i4 = i;
                for (C1026d.C1027a aVar : this.f2970fG) {
                    if (aVar != null) {
                        i4 += C1710pf.m6002c(2, (C1718pm) aVar);
                    }
                }
                i = i4;
            }
            if (this.f2971fH != null && this.f2971fH.length > 0) {
                int i5 = i;
                for (C0981e eVar : this.f2971fH) {
                    if (eVar != null) {
                        i5 += C1710pf.m6002c(3, (C1718pm) eVar);
                    }
                }
                i = i5;
            }
            if (this.f2972fI != null && this.f2972fI.length > 0) {
                int i6 = i;
                for (C0978b bVar : this.f2972fI) {
                    if (bVar != null) {
                        i6 += C1710pf.m6002c(4, (C1718pm) bVar);
                    }
                }
                i = i6;
            }
            if (this.f2973fJ != null && this.f2973fJ.length > 0) {
                int i7 = i;
                for (C0978b bVar2 : this.f2973fJ) {
                    if (bVar2 != null) {
                        i7 += C1710pf.m6002c(5, (C1718pm) bVar2);
                    }
                }
                i = i7;
            }
            if (this.f2974fK != null && this.f2974fK.length > 0) {
                int i8 = i;
                for (C0978b bVar3 : this.f2974fK) {
                    if (bVar3 != null) {
                        i8 += C1710pf.m6002c(6, (C1718pm) bVar3);
                    }
                }
                i = i8;
            }
            if (this.f2975fL != null && this.f2975fL.length > 0) {
                int i9 = i;
                for (C0983g gVar : this.f2975fL) {
                    if (gVar != null) {
                        i9 += C1710pf.m6002c(7, (C1718pm) gVar);
                    }
                }
                i = i9;
            }
            if (!this.f2976fM.equals("")) {
                i += C1710pf.m6016j(9, this.f2976fM);
            }
            if (!this.f2977fN.equals("")) {
                i += C1710pf.m6016j(10, this.f2977fN);
            }
            if (!this.f2978fO.equals("0")) {
                i += C1710pf.m6016j(12, this.f2978fO);
            }
            if (!this.version.equals("")) {
                i += C1710pf.m6016j(13, this.version);
            }
            if (this.f2979fP != null) {
                i += C1710pf.m6002c(14, (C1718pm) this.f2979fP);
            }
            if (Float.floatToIntBits(this.f2980fQ) != Float.floatToIntBits(0.0f)) {
                i += C1710pf.m6001c(15, this.f2980fQ);
            }
            if (this.f2982fS != null && this.f2982fS.length > 0) {
                int i10 = 0;
                int i11 = 0;
                for (String str2 : this.f2982fS) {
                    if (str2 != null) {
                        i11++;
                        i10 += C1710pf.m6006df(str2);
                    }
                }
                i = i + i10 + (i11 * 2);
            }
            if (this.f2983fT != 0) {
                i += C1710pf.m6019u(17, this.f2983fT);
            }
            if (this.f2981fR) {
                i += C1710pf.m6003c(18, this.f2981fR);
            }
            if (this.f2968fE == null || this.f2968fE.length <= 0) {
                return i;
            }
            int i12 = 0;
            int i13 = 0;
            for (String str3 : this.f2968fE) {
                if (str3 != null) {
                    i13++;
                    i12 += C1710pf.m6006df(str3);
                }
            }
            return i + i12 + (i13 * 2);
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C0982f)) {
                return false;
            }
            C0982f fVar = (C0982f) o;
            if (!C1716pk.equals((Object[]) this.f2968fE, (Object[]) fVar.f2968fE) || !C1716pk.equals((Object[]) this.f2969fF, (Object[]) fVar.f2969fF) || !C1716pk.equals((Object[]) this.f2970fG, (Object[]) fVar.f2970fG) || !C1716pk.equals((Object[]) this.f2971fH, (Object[]) fVar.f2971fH) || !C1716pk.equals((Object[]) this.f2972fI, (Object[]) fVar.f2972fI) || !C1716pk.equals((Object[]) this.f2973fJ, (Object[]) fVar.f2973fJ) || !C1716pk.equals((Object[]) this.f2974fK, (Object[]) fVar.f2974fK) || !C1716pk.equals((Object[]) this.f2975fL, (Object[]) fVar.f2975fL)) {
                return false;
            }
            if (this.f2976fM == null) {
                if (fVar.f2976fM != null) {
                    return false;
                }
            } else if (!this.f2976fM.equals(fVar.f2976fM)) {
                return false;
            }
            if (this.f2977fN == null) {
                if (fVar.f2977fN != null) {
                    return false;
                }
            } else if (!this.f2977fN.equals(fVar.f2977fN)) {
                return false;
            }
            if (this.f2978fO == null) {
                if (fVar.f2978fO != null) {
                    return false;
                }
            } else if (!this.f2978fO.equals(fVar.f2978fO)) {
                return false;
            }
            if (this.version == null) {
                if (fVar.version != null) {
                    return false;
                }
            } else if (!this.version.equals(fVar.version)) {
                return false;
            }
            if (this.f2979fP == null) {
                if (fVar.f2979fP != null) {
                    return false;
                }
            } else if (!this.f2979fP.equals(fVar.f2979fP)) {
                return false;
            }
            if (Float.floatToIntBits(this.f2980fQ) == Float.floatToIntBits(fVar.f2980fQ) && this.f2981fR == fVar.f2981fR && C1716pk.equals((Object[]) this.f2982fS, (Object[]) fVar.f2982fS) && this.f2983fT == fVar.f2983fT) {
                return mo10081a(fVar);
            }
            return false;
        }

        /* renamed from: g */
        public C0982f mo4923b(C1709pe peVar) throws IOException {
            while (true) {
                int qg = peVar.mo10028qg();
                switch (qg) {
                    case 0:
                        break;
                    case 10:
                        int b = C1721pp.m6106b(peVar, 10);
                        int length = this.f2969fF == null ? 0 : this.f2969fF.length;
                        String[] strArr = new String[(b + length)];
                        if (length != 0) {
                            System.arraycopy(this.f2969fF, 0, strArr, 0, length);
                        }
                        while (length < strArr.length - 1) {
                            strArr[length] = peVar.readString();
                            peVar.mo10028qg();
                            length++;
                        }
                        strArr[length] = peVar.readString();
                        this.f2969fF = strArr;
                        continue;
                    case 18:
                        int b2 = C1721pp.m6106b(peVar, 18);
                        int length2 = this.f2970fG == null ? 0 : this.f2970fG.length;
                        C1026d.C1027a[] aVarArr = new C1026d.C1027a[(b2 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.f2970fG, 0, aVarArr, 0, length2);
                        }
                        while (length2 < aVarArr.length - 1) {
                            aVarArr[length2] = new C1026d.C1027a();
                            peVar.mo10018a(aVarArr[length2]);
                            peVar.mo10028qg();
                            length2++;
                        }
                        aVarArr[length2] = new C1026d.C1027a();
                        peVar.mo10018a(aVarArr[length2]);
                        this.f2970fG = aVarArr;
                        continue;
                    case FitnessActivities.FENCING:
                        int b3 = C1721pp.m6106b(peVar, 26);
                        int length3 = this.f2971fH == null ? 0 : this.f2971fH.length;
                        C0981e[] eVarArr = new C0981e[(b3 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.f2971fH, 0, eVarArr, 0, length3);
                        }
                        while (length3 < eVarArr.length - 1) {
                            eVarArr[length3] = new C0981e();
                            peVar.mo10018a(eVarArr[length3]);
                            peVar.mo10028qg();
                            length3++;
                        }
                        eVarArr[length3] = new C0981e();
                        peVar.mo10018a(eVarArr[length3]);
                        this.f2971fH = eVarArr;
                        continue;
                    case FitnessActivities.HANDBALL:
                        int b4 = C1721pp.m6106b(peVar, 34);
                        int length4 = this.f2972fI == null ? 0 : this.f2972fI.length;
                        C0978b[] bVarArr = new C0978b[(b4 + length4)];
                        if (length4 != 0) {
                            System.arraycopy(this.f2972fI, 0, bVarArr, 0, length4);
                        }
                        while (length4 < bVarArr.length - 1) {
                            bVarArr[length4] = new C0978b();
                            peVar.mo10018a(bVarArr[length4]);
                            peVar.mo10028qg();
                            length4++;
                        }
                        bVarArr[length4] = new C0978b();
                        peVar.mo10018a(bVarArr[length4]);
                        this.f2972fI = bVarArr;
                        continue;
                    case FitnessActivities.KICKBOXING:
                        int b5 = C1721pp.m6106b(peVar, 42);
                        int length5 = this.f2973fJ == null ? 0 : this.f2973fJ.length;
                        C0978b[] bVarArr2 = new C0978b[(b5 + length5)];
                        if (length5 != 0) {
                            System.arraycopy(this.f2973fJ, 0, bVarArr2, 0, length5);
                        }
                        while (length5 < bVarArr2.length - 1) {
                            bVarArr2[length5] = new C0978b();
                            peVar.mo10018a(bVarArr2[length5]);
                            peVar.mo10028qg();
                            length5++;
                        }
                        bVarArr2[length5] = new C0978b();
                        peVar.mo10018a(bVarArr2[length5]);
                        this.f2973fJ = bVarArr2;
                        continue;
                    case 50:
                        int b6 = C1721pp.m6106b(peVar, 50);
                        int length6 = this.f2974fK == null ? 0 : this.f2974fK.length;
                        C0978b[] bVarArr3 = new C0978b[(b6 + length6)];
                        if (length6 != 0) {
                            System.arraycopy(this.f2974fK, 0, bVarArr3, 0, length6);
                        }
                        while (length6 < bVarArr3.length - 1) {
                            bVarArr3[length6] = new C0978b();
                            peVar.mo10018a(bVarArr3[length6]);
                            peVar.mo10028qg();
                            length6++;
                        }
                        bVarArr3[length6] = new C0978b();
                        peVar.mo10018a(bVarArr3[length6]);
                        this.f2974fK = bVarArr3;
                        continue;
                    case FitnessActivities.RUNNING_TREADMILL:
                        int b7 = C1721pp.m6106b(peVar, 58);
                        int length7 = this.f2975fL == null ? 0 : this.f2975fL.length;
                        C0983g[] gVarArr = new C0983g[(b7 + length7)];
                        if (length7 != 0) {
                            System.arraycopy(this.f2975fL, 0, gVarArr, 0, length7);
                        }
                        while (length7 < gVarArr.length - 1) {
                            gVarArr[length7] = new C0983g();
                            peVar.mo10018a(gVarArr[length7]);
                            peVar.mo10028qg();
                            length7++;
                        }
                        gVarArr[length7] = new C0983g();
                        peVar.mo10018a(gVarArr[length7]);
                        this.f2975fL = gVarArr;
                        continue;
                    case FitnessActivities.SNOWMOBILE:
                        this.f2976fM = peVar.readString();
                        continue;
                    case FitnessActivities.SWIMMING:
                        this.f2977fN = peVar.readString();
                        continue;
                    case FitnessActivities.WHEELCHAIR:
                        this.f2978fO = peVar.readString();
                        continue;
                    case FitnessActivities.CURLING:
                        this.version = peVar.readString();
                        continue;
                    case 114:
                        if (this.f2979fP == null) {
                            this.f2979fP = new C0977a();
                        }
                        peVar.mo10018a(this.f2979fP);
                        continue;
                    case 125:
                        this.f2980fQ = peVar.readFloat();
                        continue;
                    case TransportMediator.KEYCODE_MEDIA_RECORD:
                        int b8 = C1721pp.m6106b(peVar, TransportMediator.KEYCODE_MEDIA_RECORD);
                        int length8 = this.f2982fS == null ? 0 : this.f2982fS.length;
                        String[] strArr2 = new String[(b8 + length8)];
                        if (length8 != 0) {
                            System.arraycopy(this.f2982fS, 0, strArr2, 0, length8);
                        }
                        while (length8 < strArr2.length - 1) {
                            strArr2[length8] = peVar.readString();
                            peVar.mo10028qg();
                            length8++;
                        }
                        strArr2[length8] = peVar.readString();
                        this.f2982fS = strArr2;
                        continue;
                    case 136:
                        this.f2983fT = peVar.mo10031qj();
                        continue;
                    case 144:
                        this.f2981fR = peVar.mo10032qk();
                        continue;
                    case 154:
                        int b9 = C1721pp.m6106b(peVar, 154);
                        int length9 = this.f2968fE == null ? 0 : this.f2968fE.length;
                        String[] strArr3 = new String[(b9 + length9)];
                        if (length9 != 0) {
                            System.arraycopy(this.f2968fE, 0, strArr3, 0, length9);
                        }
                        while (length9 < strArr3.length - 1) {
                            strArr3[length9] = peVar.readString();
                            peVar.mo10028qg();
                            length9++;
                        }
                        strArr3[length9] = peVar.readString();
                        this.f2968fE = strArr3;
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

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.version == null ? 0 : this.version.hashCode()) + (((this.f2978fO == null ? 0 : this.f2978fO.hashCode()) + (((this.f2977fN == null ? 0 : this.f2977fN.hashCode()) + (((this.f2976fM == null ? 0 : this.f2976fM.hashCode()) + ((((((((((((((((C1716pk.hashCode((Object[]) this.f2968fE) + 527) * 31) + C1716pk.hashCode((Object[]) this.f2969fF)) * 31) + C1716pk.hashCode((Object[]) this.f2970fG)) * 31) + C1716pk.hashCode((Object[]) this.f2971fH)) * 31) + C1716pk.hashCode((Object[]) this.f2972fI)) * 31) + C1716pk.hashCode((Object[]) this.f2973fJ)) * 31) + C1716pk.hashCode((Object[]) this.f2974fK)) * 31) + C1716pk.hashCode((Object[]) this.f2975fL)) * 31)) * 31)) * 31)) * 31)) * 31;
            if (this.f2979fP != null) {
                i = this.f2979fP.hashCode();
            }
            return (((((((this.f2981fR ? 1231 : 1237) + ((((hashCode + i) * 31) + Float.floatToIntBits(this.f2980fQ)) * 31)) * 31) + C1716pk.hashCode((Object[]) this.f2982fS)) * 31) + this.f2983fT) * 31) + mo10082qx();
        }

        /* renamed from: k */
        public C0982f mo8189k() {
            this.f2968fE = C1721pp.awQ;
            this.f2969fF = C1721pp.awQ;
            this.f2970fG = C1026d.C1027a.m4181r();
            this.f2971fH = C0981e.m4073i();
            this.f2972fI = C0978b.m4056d();
            this.f2973fJ = C0978b.m4056d();
            this.f2974fK = C0978b.m4056d();
            this.f2975fL = C0983g.m4085l();
            this.f2976fM = "";
            this.f2977fN = "";
            this.f2978fO = "0";
            this.version = "";
            this.f2979fP = null;
            this.f2980fQ = 0.0f;
            this.f2981fR = false;
            this.f2982fS = C1721pp.awQ;
            this.f2983fT = 0;
            this.awy = null;
            this.awJ = -1;
            return this;
        }
    }

    /* renamed from: com.google.android.gms.internal.c$g */
    public static final class C0983g extends C1712pg<C0983g> {

        /* renamed from: fU */
        private static volatile C0983g[] f2984fU;

        /* renamed from: fV */
        public int[] f2985fV;

        /* renamed from: fW */
        public int[] f2986fW;

        /* renamed from: fX */
        public int[] f2987fX;

        /* renamed from: fY */
        public int[] f2988fY;

        /* renamed from: fZ */
        public int[] f2989fZ;

        /* renamed from: ga */
        public int[] f2990ga;

        /* renamed from: gb */
        public int[] f2991gb;

        /* renamed from: gc */
        public int[] f2992gc;

        /* renamed from: gd */
        public int[] f2993gd;

        /* renamed from: ge */
        public int[] f2994ge;

        public C0983g() {
            mo8193m();
        }

        /* renamed from: l */
        public static C0983g[] m4085l() {
            if (f2984fU == null) {
                synchronized (C1716pk.awI) {
                    if (f2984fU == null) {
                        f2984fU = new C0983g[0];
                    }
                }
            }
            return f2984fU;
        }

        /* renamed from: a */
        public void mo4922a(C1710pf pfVar) throws IOException {
            if (this.f2985fV != null && this.f2985fV.length > 0) {
                for (int s : this.f2985fV) {
                    pfVar.mo10075s(1, s);
                }
            }
            if (this.f2986fW != null && this.f2986fW.length > 0) {
                for (int s2 : this.f2986fW) {
                    pfVar.mo10075s(2, s2);
                }
            }
            if (this.f2987fX != null && this.f2987fX.length > 0) {
                for (int s3 : this.f2987fX) {
                    pfVar.mo10075s(3, s3);
                }
            }
            if (this.f2988fY != null && this.f2988fY.length > 0) {
                for (int s4 : this.f2988fY) {
                    pfVar.mo10075s(4, s4);
                }
            }
            if (this.f2989fZ != null && this.f2989fZ.length > 0) {
                for (int s5 : this.f2989fZ) {
                    pfVar.mo10075s(5, s5);
                }
            }
            if (this.f2990ga != null && this.f2990ga.length > 0) {
                for (int s6 : this.f2990ga) {
                    pfVar.mo10075s(6, s6);
                }
            }
            if (this.f2991gb != null && this.f2991gb.length > 0) {
                for (int s7 : this.f2991gb) {
                    pfVar.mo10075s(7, s7);
                }
            }
            if (this.f2992gc != null && this.f2992gc.length > 0) {
                for (int s8 : this.f2992gc) {
                    pfVar.mo10075s(8, s8);
                }
            }
            if (this.f2993gd != null && this.f2993gd.length > 0) {
                for (int s9 : this.f2993gd) {
                    pfVar.mo10075s(9, s9);
                }
            }
            if (this.f2994ge != null && this.f2994ge.length > 0) {
                for (int s10 : this.f2994ge) {
                    pfVar.mo10075s(10, s10);
                }
            }
            super.mo4922a(pfVar);
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public int mo4924c() {
            int i;
            int c = super.mo4924c();
            if (this.f2985fV == null || this.f2985fV.length <= 0) {
                i = c;
            } else {
                int i2 = 0;
                for (int gv : this.f2985fV) {
                    i2 += C1710pf.m6013gv(gv);
                }
                i = c + i2 + (this.f2985fV.length * 1);
            }
            if (this.f2986fW != null && this.f2986fW.length > 0) {
                int i3 = 0;
                for (int gv2 : this.f2986fW) {
                    i3 += C1710pf.m6013gv(gv2);
                }
                i = i + i3 + (this.f2986fW.length * 1);
            }
            if (this.f2987fX != null && this.f2987fX.length > 0) {
                int i4 = 0;
                for (int gv3 : this.f2987fX) {
                    i4 += C1710pf.m6013gv(gv3);
                }
                i = i + i4 + (this.f2987fX.length * 1);
            }
            if (this.f2988fY != null && this.f2988fY.length > 0) {
                int i5 = 0;
                for (int gv4 : this.f2988fY) {
                    i5 += C1710pf.m6013gv(gv4);
                }
                i = i + i5 + (this.f2988fY.length * 1);
            }
            if (this.f2989fZ != null && this.f2989fZ.length > 0) {
                int i6 = 0;
                for (int gv5 : this.f2989fZ) {
                    i6 += C1710pf.m6013gv(gv5);
                }
                i = i + i6 + (this.f2989fZ.length * 1);
            }
            if (this.f2990ga != null && this.f2990ga.length > 0) {
                int i7 = 0;
                for (int gv6 : this.f2990ga) {
                    i7 += C1710pf.m6013gv(gv6);
                }
                i = i + i7 + (this.f2990ga.length * 1);
            }
            if (this.f2991gb != null && this.f2991gb.length > 0) {
                int i8 = 0;
                for (int gv7 : this.f2991gb) {
                    i8 += C1710pf.m6013gv(gv7);
                }
                i = i + i8 + (this.f2991gb.length * 1);
            }
            if (this.f2992gc != null && this.f2992gc.length > 0) {
                int i9 = 0;
                for (int gv8 : this.f2992gc) {
                    i9 += C1710pf.m6013gv(gv8);
                }
                i = i + i9 + (this.f2992gc.length * 1);
            }
            if (this.f2993gd != null && this.f2993gd.length > 0) {
                int i10 = 0;
                for (int gv9 : this.f2993gd) {
                    i10 += C1710pf.m6013gv(gv9);
                }
                i = i + i10 + (this.f2993gd.length * 1);
            }
            if (this.f2994ge == null || this.f2994ge.length <= 0) {
                return i;
            }
            int i11 = 0;
            for (int gv10 : this.f2994ge) {
                i11 += C1710pf.m6013gv(gv10);
            }
            return i + i11 + (this.f2994ge.length * 1);
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C0983g)) {
                return false;
            }
            C0983g gVar = (C0983g) o;
            if (!C1716pk.equals(this.f2985fV, gVar.f2985fV) || !C1716pk.equals(this.f2986fW, gVar.f2986fW) || !C1716pk.equals(this.f2987fX, gVar.f2987fX) || !C1716pk.equals(this.f2988fY, gVar.f2988fY) || !C1716pk.equals(this.f2989fZ, gVar.f2989fZ) || !C1716pk.equals(this.f2990ga, gVar.f2990ga) || !C1716pk.equals(this.f2991gb, gVar.f2991gb) || !C1716pk.equals(this.f2992gc, gVar.f2992gc) || !C1716pk.equals(this.f2993gd, gVar.f2993gd) || !C1716pk.equals(this.f2994ge, gVar.f2994ge)) {
                return false;
            }
            return mo10081a(gVar);
        }

        /* renamed from: h */
        public C0983g mo4923b(C1709pe peVar) throws IOException {
            while (true) {
                int qg = peVar.mo10028qg();
                switch (qg) {
                    case 0:
                        break;
                    case 8:
                        int b = C1721pp.m6106b(peVar, 8);
                        int length = this.f2985fV == null ? 0 : this.f2985fV.length;
                        int[] iArr = new int[(b + length)];
                        if (length != 0) {
                            System.arraycopy(this.f2985fV, 0, iArr, 0, length);
                        }
                        while (length < iArr.length - 1) {
                            iArr[length] = peVar.mo10031qj();
                            peVar.mo10028qg();
                            length++;
                        }
                        iArr[length] = peVar.mo10031qj();
                        this.f2985fV = iArr;
                        continue;
                    case 10:
                        int go = peVar.mo10023go(peVar.mo10035qn());
                        int position = peVar.getPosition();
                        int i = 0;
                        while (peVar.mo10039qs() > 0) {
                            peVar.mo10031qj();
                            i++;
                        }
                        peVar.mo10025gq(position);
                        int length2 = this.f2985fV == null ? 0 : this.f2985fV.length;
                        int[] iArr2 = new int[(i + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.f2985fV, 0, iArr2, 0, length2);
                        }
                        while (length2 < iArr2.length) {
                            iArr2[length2] = peVar.mo10031qj();
                            length2++;
                        }
                        this.f2985fV = iArr2;
                        peVar.mo10024gp(go);
                        continue;
                    case 16:
                        int b2 = C1721pp.m6106b(peVar, 16);
                        int length3 = this.f2986fW == null ? 0 : this.f2986fW.length;
                        int[] iArr3 = new int[(b2 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.f2986fW, 0, iArr3, 0, length3);
                        }
                        while (length3 < iArr3.length - 1) {
                            iArr3[length3] = peVar.mo10031qj();
                            peVar.mo10028qg();
                            length3++;
                        }
                        iArr3[length3] = peVar.mo10031qj();
                        this.f2986fW = iArr3;
                        continue;
                    case 18:
                        int go2 = peVar.mo10023go(peVar.mo10035qn());
                        int position2 = peVar.getPosition();
                        int i2 = 0;
                        while (peVar.mo10039qs() > 0) {
                            peVar.mo10031qj();
                            i2++;
                        }
                        peVar.mo10025gq(position2);
                        int length4 = this.f2986fW == null ? 0 : this.f2986fW.length;
                        int[] iArr4 = new int[(i2 + length4)];
                        if (length4 != 0) {
                            System.arraycopy(this.f2986fW, 0, iArr4, 0, length4);
                        }
                        while (length4 < iArr4.length) {
                            iArr4[length4] = peVar.mo10031qj();
                            length4++;
                        }
                        this.f2986fW = iArr4;
                        peVar.mo10024gp(go2);
                        continue;
                    case FitnessActivities.DANCING:
                        int b3 = C1721pp.m6106b(peVar, 24);
                        int length5 = this.f2987fX == null ? 0 : this.f2987fX.length;
                        int[] iArr5 = new int[(b3 + length5)];
                        if (length5 != 0) {
                            System.arraycopy(this.f2987fX, 0, iArr5, 0, length5);
                        }
                        while (length5 < iArr5.length - 1) {
                            iArr5[length5] = peVar.mo10031qj();
                            peVar.mo10028qg();
                            length5++;
                        }
                        iArr5[length5] = peVar.mo10031qj();
                        this.f2987fX = iArr5;
                        continue;
                    case FitnessActivities.FENCING:
                        int go3 = peVar.mo10023go(peVar.mo10035qn());
                        int position3 = peVar.getPosition();
                        int i3 = 0;
                        while (peVar.mo10039qs() > 0) {
                            peVar.mo10031qj();
                            i3++;
                        }
                        peVar.mo10025gq(position3);
                        int length6 = this.f2987fX == null ? 0 : this.f2987fX.length;
                        int[] iArr6 = new int[(i3 + length6)];
                        if (length6 != 0) {
                            System.arraycopy(this.f2987fX, 0, iArr6, 0, length6);
                        }
                        while (length6 < iArr6.length) {
                            iArr6[length6] = peVar.mo10031qj();
                            length6++;
                        }
                        this.f2987fX = iArr6;
                        peVar.mo10024gp(go3);
                        continue;
                    case 32:
                        int b4 = C1721pp.m6106b(peVar, 32);
                        int length7 = this.f2988fY == null ? 0 : this.f2988fY.length;
                        int[] iArr7 = new int[(b4 + length7)];
                        if (length7 != 0) {
                            System.arraycopy(this.f2988fY, 0, iArr7, 0, length7);
                        }
                        while (length7 < iArr7.length - 1) {
                            iArr7[length7] = peVar.mo10031qj();
                            peVar.mo10028qg();
                            length7++;
                        }
                        iArr7[length7] = peVar.mo10031qj();
                        this.f2988fY = iArr7;
                        continue;
                    case FitnessActivities.HANDBALL:
                        int go4 = peVar.mo10023go(peVar.mo10035qn());
                        int position4 = peVar.getPosition();
                        int i4 = 0;
                        while (peVar.mo10039qs() > 0) {
                            peVar.mo10031qj();
                            i4++;
                        }
                        peVar.mo10025gq(position4);
                        int length8 = this.f2988fY == null ? 0 : this.f2988fY.length;
                        int[] iArr8 = new int[(i4 + length8)];
                        if (length8 != 0) {
                            System.arraycopy(this.f2988fY, 0, iArr8, 0, length8);
                        }
                        while (length8 < iArr8.length) {
                            iArr8[length8] = peVar.mo10031qj();
                            length8++;
                        }
                        this.f2988fY = iArr8;
                        peVar.mo10024gp(go4);
                        continue;
                    case FitnessActivities.KAYAKING:
                        int b5 = C1721pp.m6106b(peVar, 40);
                        int length9 = this.f2989fZ == null ? 0 : this.f2989fZ.length;
                        int[] iArr9 = new int[(b5 + length9)];
                        if (length9 != 0) {
                            System.arraycopy(this.f2989fZ, 0, iArr9, 0, length9);
                        }
                        while (length9 < iArr9.length - 1) {
                            iArr9[length9] = peVar.mo10031qj();
                            peVar.mo10028qg();
                            length9++;
                        }
                        iArr9[length9] = peVar.mo10031qj();
                        this.f2989fZ = iArr9;
                        continue;
                    case FitnessActivities.KICKBOXING:
                        int go5 = peVar.mo10023go(peVar.mo10035qn());
                        int position5 = peVar.getPosition();
                        int i5 = 0;
                        while (peVar.mo10039qs() > 0) {
                            peVar.mo10031qj();
                            i5++;
                        }
                        peVar.mo10025gq(position5);
                        int length10 = this.f2989fZ == null ? 0 : this.f2989fZ.length;
                        int[] iArr10 = new int[(i5 + length10)];
                        if (length10 != 0) {
                            System.arraycopy(this.f2989fZ, 0, iArr10, 0, length10);
                        }
                        while (length10 < iArr10.length) {
                            iArr10[length10] = peVar.mo10031qj();
                            length10++;
                        }
                        this.f2989fZ = iArr10;
                        peVar.mo10024gp(go5);
                        continue;
                    case FitnessActivities.PARAGLIDING:
                        int b6 = C1721pp.m6106b(peVar, 48);
                        int length11 = this.f2990ga == null ? 0 : this.f2990ga.length;
                        int[] iArr11 = new int[(b6 + length11)];
                        if (length11 != 0) {
                            System.arraycopy(this.f2990ga, 0, iArr11, 0, length11);
                        }
                        while (length11 < iArr11.length - 1) {
                            iArr11[length11] = peVar.mo10031qj();
                            peVar.mo10028qg();
                            length11++;
                        }
                        iArr11[length11] = peVar.mo10031qj();
                        this.f2990ga = iArr11;
                        continue;
                    case 50:
                        int go6 = peVar.mo10023go(peVar.mo10035qn());
                        int position6 = peVar.getPosition();
                        int i6 = 0;
                        while (peVar.mo10039qs() > 0) {
                            peVar.mo10031qj();
                            i6++;
                        }
                        peVar.mo10025gq(position6);
                        int length12 = this.f2990ga == null ? 0 : this.f2990ga.length;
                        int[] iArr12 = new int[(i6 + length12)];
                        if (length12 != 0) {
                            System.arraycopy(this.f2990ga, 0, iArr12, 0, length12);
                        }
                        while (length12 < iArr12.length) {
                            iArr12[length12] = peVar.mo10031qj();
                            length12++;
                        }
                        this.f2990ga = iArr12;
                        peVar.mo10024gp(go6);
                        continue;
                    case FitnessActivities.RUNNING_JOGGING:
                        int b7 = C1721pp.m6106b(peVar, 56);
                        int length13 = this.f2991gb == null ? 0 : this.f2991gb.length;
                        int[] iArr13 = new int[(b7 + length13)];
                        if (length13 != 0) {
                            System.arraycopy(this.f2991gb, 0, iArr13, 0, length13);
                        }
                        while (length13 < iArr13.length - 1) {
                            iArr13[length13] = peVar.mo10031qj();
                            peVar.mo10028qg();
                            length13++;
                        }
                        iArr13[length13] = peVar.mo10031qj();
                        this.f2991gb = iArr13;
                        continue;
                    case FitnessActivities.RUNNING_TREADMILL:
                        int go7 = peVar.mo10023go(peVar.mo10035qn());
                        int position7 = peVar.getPosition();
                        int i7 = 0;
                        while (peVar.mo10039qs() > 0) {
                            peVar.mo10031qj();
                            i7++;
                        }
                        peVar.mo10025gq(position7);
                        int length14 = this.f2991gb == null ? 0 : this.f2991gb.length;
                        int[] iArr14 = new int[(i7 + length14)];
                        if (length14 != 0) {
                            System.arraycopy(this.f2991gb, 0, iArr14, 0, length14);
                        }
                        while (length14 < iArr14.length) {
                            iArr14[length14] = peVar.mo10031qj();
                            length14++;
                        }
                        this.f2991gb = iArr14;
                        peVar.mo10024gp(go7);
                        continue;
                    case 64:
                        int b8 = C1721pp.m6106b(peVar, 64);
                        int length15 = this.f2992gc == null ? 0 : this.f2992gc.length;
                        int[] iArr15 = new int[(b8 + length15)];
                        if (length15 != 0) {
                            System.arraycopy(this.f2992gc, 0, iArr15, 0, length15);
                        }
                        while (length15 < iArr15.length - 1) {
                            iArr15[length15] = peVar.mo10031qj();
                            peVar.mo10028qg();
                            length15++;
                        }
                        iArr15[length15] = peVar.mo10031qj();
                        this.f2992gc = iArr15;
                        continue;
                    case FitnessActivities.SKIING_BACK_COUNTRY:
                        int go8 = peVar.mo10023go(peVar.mo10035qn());
                        int position8 = peVar.getPosition();
                        int i8 = 0;
                        while (peVar.mo10039qs() > 0) {
                            peVar.mo10031qj();
                            i8++;
                        }
                        peVar.mo10025gq(position8);
                        int length16 = this.f2992gc == null ? 0 : this.f2992gc.length;
                        int[] iArr16 = new int[(i8 + length16)];
                        if (length16 != 0) {
                            System.arraycopy(this.f2992gc, 0, iArr16, 0, length16);
                        }
                        while (length16 < iArr16.length) {
                            iArr16[length16] = peVar.mo10031qj();
                            length16++;
                        }
                        this.f2992gc = iArr16;
                        peVar.mo10024gp(go8);
                        continue;
                    case FitnessActivities.SLEEP:
                        int b9 = C1721pp.m6106b(peVar, 72);
                        int length17 = this.f2993gd == null ? 0 : this.f2993gd.length;
                        int[] iArr17 = new int[(b9 + length17)];
                        if (length17 != 0) {
                            System.arraycopy(this.f2993gd, 0, iArr17, 0, length17);
                        }
                        while (length17 < iArr17.length - 1) {
                            iArr17[length17] = peVar.mo10031qj();
                            peVar.mo10028qg();
                            length17++;
                        }
                        iArr17[length17] = peVar.mo10031qj();
                        this.f2993gd = iArr17;
                        continue;
                    case FitnessActivities.SNOWMOBILE:
                        int go9 = peVar.mo10023go(peVar.mo10035qn());
                        int position9 = peVar.getPosition();
                        int i9 = 0;
                        while (peVar.mo10039qs() > 0) {
                            peVar.mo10031qj();
                            i9++;
                        }
                        peVar.mo10025gq(position9);
                        int length18 = this.f2993gd == null ? 0 : this.f2993gd.length;
                        int[] iArr18 = new int[(i9 + length18)];
                        if (length18 != 0) {
                            System.arraycopy(this.f2993gd, 0, iArr18, 0, length18);
                        }
                        while (length18 < iArr18.length) {
                            iArr18[length18] = peVar.mo10031qj();
                            length18++;
                        }
                        this.f2993gd = iArr18;
                        peVar.mo10024gp(go9);
                        continue;
                    case FitnessActivities.STRENGTH_TRAINING:
                        int b10 = C1721pp.m6106b(peVar, 80);
                        int length19 = this.f2994ge == null ? 0 : this.f2994ge.length;
                        int[] iArr19 = new int[(b10 + length19)];
                        if (length19 != 0) {
                            System.arraycopy(this.f2994ge, 0, iArr19, 0, length19);
                        }
                        while (length19 < iArr19.length - 1) {
                            iArr19[length19] = peVar.mo10031qj();
                            peVar.mo10028qg();
                            length19++;
                        }
                        iArr19[length19] = peVar.mo10031qj();
                        this.f2994ge = iArr19;
                        continue;
                    case FitnessActivities.SWIMMING:
                        int go10 = peVar.mo10023go(peVar.mo10035qn());
                        int position10 = peVar.getPosition();
                        int i10 = 0;
                        while (peVar.mo10039qs() > 0) {
                            peVar.mo10031qj();
                            i10++;
                        }
                        peVar.mo10025gq(position10);
                        int length20 = this.f2994ge == null ? 0 : this.f2994ge.length;
                        int[] iArr20 = new int[(i10 + length20)];
                        if (length20 != 0) {
                            System.arraycopy(this.f2994ge, 0, iArr20, 0, length20);
                        }
                        while (length20 < iArr20.length) {
                            iArr20[length20] = peVar.mo10031qj();
                            length20++;
                        }
                        this.f2994ge = iArr20;
                        peVar.mo10024gp(go10);
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

        public int hashCode() {
            return ((((((((((((((((((((C1716pk.hashCode(this.f2985fV) + 527) * 31) + C1716pk.hashCode(this.f2986fW)) * 31) + C1716pk.hashCode(this.f2987fX)) * 31) + C1716pk.hashCode(this.f2988fY)) * 31) + C1716pk.hashCode(this.f2989fZ)) * 31) + C1716pk.hashCode(this.f2990ga)) * 31) + C1716pk.hashCode(this.f2991gb)) * 31) + C1716pk.hashCode(this.f2992gc)) * 31) + C1716pk.hashCode(this.f2993gd)) * 31) + C1716pk.hashCode(this.f2994ge)) * 31) + mo10082qx();
        }

        /* renamed from: m */
        public C0983g mo8193m() {
            this.f2985fV = C1721pp.awL;
            this.f2986fW = C1721pp.awL;
            this.f2987fX = C1721pp.awL;
            this.f2988fY = C1721pp.awL;
            this.f2989fZ = C1721pp.awL;
            this.f2990ga = C1721pp.awL;
            this.f2991gb = C1721pp.awL;
            this.f2992gc = C1721pp.awL;
            this.f2993gd = C1721pp.awL;
            this.f2994ge = C1721pp.awL;
            this.awy = null;
            this.awJ = -1;
            return this;
        }
    }

    /* renamed from: com.google.android.gms.internal.c$h */
    public static final class C0984h extends C1712pg<C0984h> {

        /* renamed from: gf */
        public static final C1713ph<C1026d.C1027a, C0984h> f2995gf = C1713ph.m6059a(11, C0984h.class, 810);

        /* renamed from: gg */
        private static final C0984h[] f2996gg = new C0984h[0];

        /* renamed from: gh */
        public int[] f2997gh;

        /* renamed from: gi */
        public int[] f2998gi;

        /* renamed from: gj */
        public int[] f2999gj;

        /* renamed from: gk */
        public int f3000gk;

        /* renamed from: gl */
        public int[] f3001gl;

        /* renamed from: gm */
        public int f3002gm;

        /* renamed from: gn */
        public int f3003gn;

        public C0984h() {
            mo8197n();
        }

        /* renamed from: a */
        public void mo4922a(C1710pf pfVar) throws IOException {
            if (this.f2997gh != null && this.f2997gh.length > 0) {
                for (int s : this.f2997gh) {
                    pfVar.mo10075s(1, s);
                }
            }
            if (this.f2998gi != null && this.f2998gi.length > 0) {
                for (int s2 : this.f2998gi) {
                    pfVar.mo10075s(2, s2);
                }
            }
            if (this.f2999gj != null && this.f2999gj.length > 0) {
                for (int s3 : this.f2999gj) {
                    pfVar.mo10075s(3, s3);
                }
            }
            if (this.f3000gk != 0) {
                pfVar.mo10075s(4, this.f3000gk);
            }
            if (this.f3001gl != null && this.f3001gl.length > 0) {
                for (int s4 : this.f3001gl) {
                    pfVar.mo10075s(5, s4);
                }
            }
            if (this.f3002gm != 0) {
                pfVar.mo10075s(6, this.f3002gm);
            }
            if (this.f3003gn != 0) {
                pfVar.mo10075s(7, this.f3003gn);
            }
            super.mo4922a(pfVar);
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public int mo4924c() {
            int i;
            int c = super.mo4924c();
            if (this.f2997gh == null || this.f2997gh.length <= 0) {
                i = c;
            } else {
                int i2 = 0;
                for (int gv : this.f2997gh) {
                    i2 += C1710pf.m6013gv(gv);
                }
                i = c + i2 + (this.f2997gh.length * 1);
            }
            if (this.f2998gi != null && this.f2998gi.length > 0) {
                int i3 = 0;
                for (int gv2 : this.f2998gi) {
                    i3 += C1710pf.m6013gv(gv2);
                }
                i = i + i3 + (this.f2998gi.length * 1);
            }
            if (this.f2999gj != null && this.f2999gj.length > 0) {
                int i4 = 0;
                for (int gv3 : this.f2999gj) {
                    i4 += C1710pf.m6013gv(gv3);
                }
                i = i + i4 + (this.f2999gj.length * 1);
            }
            if (this.f3000gk != 0) {
                i += C1710pf.m6019u(4, this.f3000gk);
            }
            if (this.f3001gl != null && this.f3001gl.length > 0) {
                int i5 = 0;
                for (int gv4 : this.f3001gl) {
                    i5 += C1710pf.m6013gv(gv4);
                }
                i = i + i5 + (this.f3001gl.length * 1);
            }
            if (this.f3002gm != 0) {
                i += C1710pf.m6019u(6, this.f3002gm);
            }
            return this.f3003gn != 0 ? i + C1710pf.m6019u(7, this.f3003gn) : i;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C0984h)) {
                return false;
            }
            C0984h hVar = (C0984h) o;
            if (!C1716pk.equals(this.f2997gh, hVar.f2997gh) || !C1716pk.equals(this.f2998gi, hVar.f2998gi) || !C1716pk.equals(this.f2999gj, hVar.f2999gj) || this.f3000gk != hVar.f3000gk || !C1716pk.equals(this.f3001gl, hVar.f3001gl) || this.f3002gm != hVar.f3002gm || this.f3003gn != hVar.f3003gn) {
                return false;
            }
            return mo10081a(hVar);
        }

        public int hashCode() {
            return ((((((((((((((C1716pk.hashCode(this.f2997gh) + 527) * 31) + C1716pk.hashCode(this.f2998gi)) * 31) + C1716pk.hashCode(this.f2999gj)) * 31) + this.f3000gk) * 31) + C1716pk.hashCode(this.f3001gl)) * 31) + this.f3002gm) * 31) + this.f3003gn) * 31) + mo10082qx();
        }

        /* renamed from: i */
        public C0984h mo4923b(C1709pe peVar) throws IOException {
            while (true) {
                int qg = peVar.mo10028qg();
                switch (qg) {
                    case 0:
                        break;
                    case 8:
                        int b = C1721pp.m6106b(peVar, 8);
                        int length = this.f2997gh == null ? 0 : this.f2997gh.length;
                        int[] iArr = new int[(b + length)];
                        if (length != 0) {
                            System.arraycopy(this.f2997gh, 0, iArr, 0, length);
                        }
                        while (length < iArr.length - 1) {
                            iArr[length] = peVar.mo10031qj();
                            peVar.mo10028qg();
                            length++;
                        }
                        iArr[length] = peVar.mo10031qj();
                        this.f2997gh = iArr;
                        continue;
                    case 10:
                        int go = peVar.mo10023go(peVar.mo10035qn());
                        int position = peVar.getPosition();
                        int i = 0;
                        while (peVar.mo10039qs() > 0) {
                            peVar.mo10031qj();
                            i++;
                        }
                        peVar.mo10025gq(position);
                        int length2 = this.f2997gh == null ? 0 : this.f2997gh.length;
                        int[] iArr2 = new int[(i + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.f2997gh, 0, iArr2, 0, length2);
                        }
                        while (length2 < iArr2.length) {
                            iArr2[length2] = peVar.mo10031qj();
                            length2++;
                        }
                        this.f2997gh = iArr2;
                        peVar.mo10024gp(go);
                        continue;
                    case 16:
                        int b2 = C1721pp.m6106b(peVar, 16);
                        int length3 = this.f2998gi == null ? 0 : this.f2998gi.length;
                        int[] iArr3 = new int[(b2 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.f2998gi, 0, iArr3, 0, length3);
                        }
                        while (length3 < iArr3.length - 1) {
                            iArr3[length3] = peVar.mo10031qj();
                            peVar.mo10028qg();
                            length3++;
                        }
                        iArr3[length3] = peVar.mo10031qj();
                        this.f2998gi = iArr3;
                        continue;
                    case 18:
                        int go2 = peVar.mo10023go(peVar.mo10035qn());
                        int position2 = peVar.getPosition();
                        int i2 = 0;
                        while (peVar.mo10039qs() > 0) {
                            peVar.mo10031qj();
                            i2++;
                        }
                        peVar.mo10025gq(position2);
                        int length4 = this.f2998gi == null ? 0 : this.f2998gi.length;
                        int[] iArr4 = new int[(i2 + length4)];
                        if (length4 != 0) {
                            System.arraycopy(this.f2998gi, 0, iArr4, 0, length4);
                        }
                        while (length4 < iArr4.length) {
                            iArr4[length4] = peVar.mo10031qj();
                            length4++;
                        }
                        this.f2998gi = iArr4;
                        peVar.mo10024gp(go2);
                        continue;
                    case FitnessActivities.DANCING:
                        int b3 = C1721pp.m6106b(peVar, 24);
                        int length5 = this.f2999gj == null ? 0 : this.f2999gj.length;
                        int[] iArr5 = new int[(b3 + length5)];
                        if (length5 != 0) {
                            System.arraycopy(this.f2999gj, 0, iArr5, 0, length5);
                        }
                        while (length5 < iArr5.length - 1) {
                            iArr5[length5] = peVar.mo10031qj();
                            peVar.mo10028qg();
                            length5++;
                        }
                        iArr5[length5] = peVar.mo10031qj();
                        this.f2999gj = iArr5;
                        continue;
                    case FitnessActivities.FENCING:
                        int go3 = peVar.mo10023go(peVar.mo10035qn());
                        int position3 = peVar.getPosition();
                        int i3 = 0;
                        while (peVar.mo10039qs() > 0) {
                            peVar.mo10031qj();
                            i3++;
                        }
                        peVar.mo10025gq(position3);
                        int length6 = this.f2999gj == null ? 0 : this.f2999gj.length;
                        int[] iArr6 = new int[(i3 + length6)];
                        if (length6 != 0) {
                            System.arraycopy(this.f2999gj, 0, iArr6, 0, length6);
                        }
                        while (length6 < iArr6.length) {
                            iArr6[length6] = peVar.mo10031qj();
                            length6++;
                        }
                        this.f2999gj = iArr6;
                        peVar.mo10024gp(go3);
                        continue;
                    case 32:
                        this.f3000gk = peVar.mo10031qj();
                        continue;
                    case FitnessActivities.KAYAKING:
                        int b4 = C1721pp.m6106b(peVar, 40);
                        int length7 = this.f3001gl == null ? 0 : this.f3001gl.length;
                        int[] iArr7 = new int[(b4 + length7)];
                        if (length7 != 0) {
                            System.arraycopy(this.f3001gl, 0, iArr7, 0, length7);
                        }
                        while (length7 < iArr7.length - 1) {
                            iArr7[length7] = peVar.mo10031qj();
                            peVar.mo10028qg();
                            length7++;
                        }
                        iArr7[length7] = peVar.mo10031qj();
                        this.f3001gl = iArr7;
                        continue;
                    case FitnessActivities.KICKBOXING:
                        int go4 = peVar.mo10023go(peVar.mo10035qn());
                        int position4 = peVar.getPosition();
                        int i4 = 0;
                        while (peVar.mo10039qs() > 0) {
                            peVar.mo10031qj();
                            i4++;
                        }
                        peVar.mo10025gq(position4);
                        int length8 = this.f3001gl == null ? 0 : this.f3001gl.length;
                        int[] iArr8 = new int[(i4 + length8)];
                        if (length8 != 0) {
                            System.arraycopy(this.f3001gl, 0, iArr8, 0, length8);
                        }
                        while (length8 < iArr8.length) {
                            iArr8[length8] = peVar.mo10031qj();
                            length8++;
                        }
                        this.f3001gl = iArr8;
                        peVar.mo10024gp(go4);
                        continue;
                    case FitnessActivities.PARAGLIDING:
                        this.f3002gm = peVar.mo10031qj();
                        continue;
                    case FitnessActivities.RUNNING_JOGGING:
                        this.f3003gn = peVar.mo10031qj();
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

        /* renamed from: n */
        public C0984h mo8197n() {
            this.f2997gh = C1721pp.awL;
            this.f2998gi = C1721pp.awL;
            this.f2999gj = C1721pp.awL;
            this.f3000gk = 0;
            this.f3001gl = C1721pp.awL;
            this.f3002gm = 0;
            this.f3003gn = 0;
            this.awy = null;
            this.awJ = -1;
            return this;
        }
    }

    /* renamed from: com.google.android.gms.internal.c$i */
    public static final class C0985i extends C1712pg<C0985i> {

        /* renamed from: go */
        private static volatile C0985i[] f3004go;

        /* renamed from: gp */
        public C1026d.C1027a f3005gp;

        /* renamed from: gq */
        public C0980d f3006gq;
        public String name;

        public C0985i() {
            mo8201p();
        }

        /* renamed from: o */
        public static C0985i[] m4096o() {
            if (f3004go == null) {
                synchronized (C1716pk.awI) {
                    if (f3004go == null) {
                        f3004go = new C0985i[0];
                    }
                }
            }
            return f3004go;
        }

        /* renamed from: a */
        public void mo4922a(C1710pf pfVar) throws IOException {
            if (!this.name.equals("")) {
                pfVar.mo10058b(1, this.name);
            }
            if (this.f3005gp != null) {
                pfVar.mo10053a(2, (C1718pm) this.f3005gp);
            }
            if (this.f3006gq != null) {
                pfVar.mo10053a(3, (C1718pm) this.f3006gq);
            }
            super.mo4922a(pfVar);
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public int mo4924c() {
            int c = super.mo4924c();
            if (!this.name.equals("")) {
                c += C1710pf.m6016j(1, this.name);
            }
            if (this.f3005gp != null) {
                c += C1710pf.m6002c(2, (C1718pm) this.f3005gp);
            }
            return this.f3006gq != null ? c + C1710pf.m6002c(3, (C1718pm) this.f3006gq) : c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C0985i)) {
                return false;
            }
            C0985i iVar = (C0985i) o;
            if (this.name == null) {
                if (iVar.name != null) {
                    return false;
                }
            } else if (!this.name.equals(iVar.name)) {
                return false;
            }
            if (this.f3005gp == null) {
                if (iVar.f3005gp != null) {
                    return false;
                }
            } else if (!this.f3005gp.equals(iVar.f3005gp)) {
                return false;
            }
            if (this.f3006gq == null) {
                if (iVar.f3006gq != null) {
                    return false;
                }
            } else if (!this.f3006gq.equals(iVar.f3006gq)) {
                return false;
            }
            return mo10081a(iVar);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.f3005gp == null ? 0 : this.f3005gp.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + 527) * 31)) * 31;
            if (this.f3006gq != null) {
                i = this.f3006gq.hashCode();
            }
            return ((hashCode + i) * 31) + mo10082qx();
        }

        /* renamed from: j */
        public C0985i mo4923b(C1709pe peVar) throws IOException {
            while (true) {
                int qg = peVar.mo10028qg();
                switch (qg) {
                    case 0:
                        break;
                    case 10:
                        this.name = peVar.readString();
                        continue;
                    case 18:
                        if (this.f3005gp == null) {
                            this.f3005gp = new C1026d.C1027a();
                        }
                        peVar.mo10018a(this.f3005gp);
                        continue;
                    case FitnessActivities.FENCING:
                        if (this.f3006gq == null) {
                            this.f3006gq = new C0980d();
                        }
                        peVar.mo10018a(this.f3006gq);
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

        /* renamed from: p */
        public C0985i mo8201p() {
            this.name = "";
            this.f3005gp = null;
            this.f3006gq = null;
            this.awy = null;
            this.awJ = -1;
            return this;
        }
    }

    /* renamed from: com.google.android.gms.internal.c$j */
    public static final class C0986j extends C1712pg<C0986j> {

        /* renamed from: gr */
        public C0985i[] f3007gr;

        /* renamed from: gs */
        public C0982f f3008gs;

        /* renamed from: gt */
        public String f3009gt;

        public C0986j() {
            mo8205q();
        }

        /* renamed from: b */
        public static C0986j m4102b(byte[] bArr) throws C1717pl {
            return (C0986j) C1718pm.m6089a(new C0986j(), bArr);
        }

        /* renamed from: a */
        public void mo4922a(C1710pf pfVar) throws IOException {
            if (this.f3007gr != null && this.f3007gr.length > 0) {
                for (C0985i iVar : this.f3007gr) {
                    if (iVar != null) {
                        pfVar.mo10053a(1, (C1718pm) iVar);
                    }
                }
            }
            if (this.f3008gs != null) {
                pfVar.mo10053a(2, (C1718pm) this.f3008gs);
            }
            if (!this.f3009gt.equals("")) {
                pfVar.mo10058b(3, this.f3009gt);
            }
            super.mo4922a(pfVar);
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public int mo4924c() {
            int c = super.mo4924c();
            if (this.f3007gr != null && this.f3007gr.length > 0) {
                for (C0985i iVar : this.f3007gr) {
                    if (iVar != null) {
                        c += C1710pf.m6002c(1, (C1718pm) iVar);
                    }
                }
            }
            if (this.f3008gs != null) {
                c += C1710pf.m6002c(2, (C1718pm) this.f3008gs);
            }
            return !this.f3009gt.equals("") ? c + C1710pf.m6016j(3, this.f3009gt) : c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C0986j)) {
                return false;
            }
            C0986j jVar = (C0986j) o;
            if (!C1716pk.equals((Object[]) this.f3007gr, (Object[]) jVar.f3007gr)) {
                return false;
            }
            if (this.f3008gs == null) {
                if (jVar.f3008gs != null) {
                    return false;
                }
            } else if (!this.f3008gs.equals(jVar.f3008gs)) {
                return false;
            }
            if (this.f3009gt == null) {
                if (jVar.f3009gt != null) {
                    return false;
                }
            } else if (!this.f3009gt.equals(jVar.f3009gt)) {
                return false;
            }
            return mo10081a(jVar);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.f3008gs == null ? 0 : this.f3008gs.hashCode()) + ((C1716pk.hashCode((Object[]) this.f3007gr) + 527) * 31)) * 31;
            if (this.f3009gt != null) {
                i = this.f3009gt.hashCode();
            }
            return ((hashCode + i) * 31) + mo10082qx();
        }

        /* renamed from: k */
        public C0986j mo4923b(C1709pe peVar) throws IOException {
            while (true) {
                int qg = peVar.mo10028qg();
                switch (qg) {
                    case 0:
                        break;
                    case 10:
                        int b = C1721pp.m6106b(peVar, 10);
                        int length = this.f3007gr == null ? 0 : this.f3007gr.length;
                        C0985i[] iVarArr = new C0985i[(b + length)];
                        if (length != 0) {
                            System.arraycopy(this.f3007gr, 0, iVarArr, 0, length);
                        }
                        while (length < iVarArr.length - 1) {
                            iVarArr[length] = new C0985i();
                            peVar.mo10018a(iVarArr[length]);
                            peVar.mo10028qg();
                            length++;
                        }
                        iVarArr[length] = new C0985i();
                        peVar.mo10018a(iVarArr[length]);
                        this.f3007gr = iVarArr;
                        continue;
                    case 18:
                        if (this.f3008gs == null) {
                            this.f3008gs = new C0982f();
                        }
                        peVar.mo10018a(this.f3008gs);
                        continue;
                    case FitnessActivities.FENCING:
                        this.f3009gt = peVar.readString();
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

        /* renamed from: q */
        public C0986j mo8205q() {
            this.f3007gr = C0985i.m4096o();
            this.f3008gs = null;
            this.f3009gt = "";
            this.awy = null;
            this.awJ = -1;
            return this;
        }
    }
}
