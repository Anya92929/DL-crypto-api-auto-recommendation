package com.google.android.gms.internal;

import android.support.p021v7.p023b.C0515k;
import java.util.Arrays;

public interface zzapz {

    public final class zza extends zzapp implements Cloneable {
        public String[] bjP;
        public String[] bjQ;
        public int[] bjR;
        public long[] bjS;
        public long[] bjT;

        public zza() {
            mo8051aN();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int mo7714a() {
            int i;
            int a = super.mo7714a();
            if (this.bjP == null || this.bjP.length <= 0) {
                i = a;
            } else {
                int i2 = 0;
                int i3 = 0;
                for (String str : this.bjP) {
                    if (str != null) {
                        i3++;
                        i2 += zzapo.zztx(str);
                    }
                }
                i = a + i2 + (i3 * 1);
            }
            if (this.bjQ != null && this.bjQ.length > 0) {
                int i4 = 0;
                int i5 = 0;
                for (String str2 : this.bjQ) {
                    if (str2 != null) {
                        i5++;
                        i4 += zzapo.zztx(str2);
                    }
                }
                i = i + i4 + (i5 * 1);
            }
            if (this.bjR != null && this.bjR.length > 0) {
                int i6 = 0;
                for (int zzafx : this.bjR) {
                    i6 += zzapo.zzafx(zzafx);
                }
                i = i + i6 + (this.bjR.length * 1);
            }
            if (this.bjS != null && this.bjS.length > 0) {
                int i7 = 0;
                for (long zzcy : this.bjS) {
                    i7 += zzapo.zzcy(zzcy);
                }
                i = i + i7 + (this.bjS.length * 1);
            }
            if (this.bjT == null || this.bjT.length <= 0) {
                return i;
            }
            int i8 = 0;
            for (long zzcy2 : this.bjT) {
                i8 += zzapo.zzcy(zzcy2);
            }
            return i + i8 + (this.bjT.length * 1);
        }

        /* renamed from: aA */
        public /* synthetic */ zzapp mo8024aA() {
            return (zza) clone();
        }

        /* renamed from: aB */
        public /* synthetic */ zzapv mo8025aB() {
            return (zza) clone();
        }

        /* renamed from: aN */
        public zza mo8051aN() {
            this.bjP = zzapy.bjM;
            this.bjQ = zzapy.bjM;
            this.bjR = zzapy.bjH;
            this.bjS = zzapy.bjI;
            this.bjT = zzapy.bjI;
            this.f5895a = null;
            this.f5906b = -1;
            return this;
        }

        /* renamed from: aO */
        public zza clone() {
            try {
                zza zza = (zza) super.clone();
                if (this.bjP != null && this.bjP.length > 0) {
                    zza.bjP = (String[]) this.bjP.clone();
                }
                if (this.bjQ != null && this.bjQ.length > 0) {
                    zza.bjQ = (String[]) this.bjQ.clone();
                }
                if (this.bjR != null && this.bjR.length > 0) {
                    zza.bjR = (int[]) this.bjR.clone();
                }
                if (this.bjS != null && this.bjS.length > 0) {
                    zza.bjS = (long[]) this.bjS.clone();
                }
                if (this.bjT != null && this.bjT.length > 0) {
                    zza.bjT = (long[]) this.bjT.clone();
                }
                return zza;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza = (zza) obj;
            if (!zzapt.equals((Object[]) this.bjP, (Object[]) zza.bjP) || !zzapt.equals((Object[]) this.bjQ, (Object[]) zza.bjQ) || !zzapt.equals(this.bjR, zza.bjR) || !zzapt.equals(this.bjS, zza.bjS) || !zzapt.equals(this.bjT, zza.bjT)) {
                return false;
            }
            return (this.f5895a == null || this.f5895a.isEmpty()) ? zza.f5895a == null || zza.f5895a.isEmpty() : this.f5895a.equals(zza.f5895a);
        }

        public int hashCode() {
            return ((this.f5895a == null || this.f5895a.isEmpty()) ? 0 : this.f5895a.hashCode()) + ((((((((((((getClass().getName().hashCode() + 527) * 31) + zzapt.hashCode((Object[]) this.bjP)) * 31) + zzapt.hashCode((Object[]) this.bjQ)) * 31) + zzapt.hashCode(this.bjR)) * 31) + zzapt.hashCode(this.bjS)) * 31) + zzapt.hashCode(this.bjT)) * 31);
        }

        public void zza(zzapo zzapo) {
            if (this.bjP != null && this.bjP.length > 0) {
                for (String str : this.bjP) {
                    if (str != null) {
                        zzapo.zzr(1, str);
                    }
                }
            }
            if (this.bjQ != null && this.bjQ.length > 0) {
                for (String str2 : this.bjQ) {
                    if (str2 != null) {
                        zzapo.zzr(2, str2);
                    }
                }
            }
            if (this.bjR != null && this.bjR.length > 0) {
                for (int zzae : this.bjR) {
                    zzapo.zzae(3, zzae);
                }
            }
            if (this.bjS != null && this.bjS.length > 0) {
                for (long zzb : this.bjS) {
                    zzapo.zzb(4, zzb);
                }
            }
            if (this.bjT != null && this.bjT.length > 0) {
                for (long zzb2 : this.bjT) {
                    zzapo.zzb(5, zzb2);
                }
            }
            super.zza(zzapo);
        }

        /* renamed from: zzch */
        public zza zzb(zzapn zzapn) {
            while (true) {
                int ah = zzapn.mo7957ah();
                switch (ah) {
                    case 0:
                        break;
                    case 10:
                        int zzc = zzapy.zzc(zzapn, 10);
                        int length = this.bjP == null ? 0 : this.bjP.length;
                        String[] strArr = new String[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.bjP, 0, strArr, 0, length);
                        }
                        while (length < strArr.length - 1) {
                            strArr[length] = zzapn.readString();
                            zzapn.mo7957ah();
                            length++;
                        }
                        strArr[length] = zzapn.readString();
                        this.bjP = strArr;
                        continue;
                    case 18:
                        int zzc2 = zzapy.zzc(zzapn, 18);
                        int length2 = this.bjQ == null ? 0 : this.bjQ.length;
                        String[] strArr2 = new String[(zzc2 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.bjQ, 0, strArr2, 0, length2);
                        }
                        while (length2 < strArr2.length - 1) {
                            strArr2[length2] = zzapn.readString();
                            zzapn.mo7957ah();
                            length2++;
                        }
                        strArr2[length2] = zzapn.readString();
                        this.bjQ = strArr2;
                        continue;
                    case 24:
                        int zzc3 = zzapy.zzc(zzapn, 24);
                        int length3 = this.bjR == null ? 0 : this.bjR.length;
                        int[] iArr = new int[(zzc3 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.bjR, 0, iArr, 0, length3);
                        }
                        while (length3 < iArr.length - 1) {
                            iArr[length3] = zzapn.mo7961al();
                            zzapn.mo7957ah();
                            length3++;
                        }
                        iArr[length3] = zzapn.mo7961al();
                        this.bjR = iArr;
                        continue;
                    case 26:
                        int zzafr = zzapn.zzafr(zzapn.mo7966aq());
                        int position = zzapn.getPosition();
                        int i = 0;
                        while (zzapn.mo7970av() > 0) {
                            zzapn.mo7961al();
                            i++;
                        }
                        zzapn.zzaft(position);
                        int length4 = this.bjR == null ? 0 : this.bjR.length;
                        int[] iArr2 = new int[(i + length4)];
                        if (length4 != 0) {
                            System.arraycopy(this.bjR, 0, iArr2, 0, length4);
                        }
                        while (length4 < iArr2.length) {
                            iArr2[length4] = zzapn.mo7961al();
                            length4++;
                        }
                        this.bjR = iArr2;
                        zzapn.zzafs(zzafr);
                        continue;
                    case 32:
                        int zzc4 = zzapy.zzc(zzapn, 32);
                        int length5 = this.bjS == null ? 0 : this.bjS.length;
                        long[] jArr = new long[(zzc4 + length5)];
                        if (length5 != 0) {
                            System.arraycopy(this.bjS, 0, jArr, 0, length5);
                        }
                        while (length5 < jArr.length - 1) {
                            jArr[length5] = zzapn.mo7960ak();
                            zzapn.mo7957ah();
                            length5++;
                        }
                        jArr[length5] = zzapn.mo7960ak();
                        this.bjS = jArr;
                        continue;
                    case C0515k.AppCompatTheme_actionModePasteDrawable:
                        int zzafr2 = zzapn.zzafr(zzapn.mo7966aq());
                        int position2 = zzapn.getPosition();
                        int i2 = 0;
                        while (zzapn.mo7970av() > 0) {
                            zzapn.mo7960ak();
                            i2++;
                        }
                        zzapn.zzaft(position2);
                        int length6 = this.bjS == null ? 0 : this.bjS.length;
                        long[] jArr2 = new long[(i2 + length6)];
                        if (length6 != 0) {
                            System.arraycopy(this.bjS, 0, jArr2, 0, length6);
                        }
                        while (length6 < jArr2.length) {
                            jArr2[length6] = zzapn.mo7960ak();
                            length6++;
                        }
                        this.bjS = jArr2;
                        zzapn.zzafs(zzafr2);
                        continue;
                    case C0515k.AppCompatTheme_textAppearanceLargePopupMenu:
                        int zzc5 = zzapy.zzc(zzapn, 40);
                        int length7 = this.bjT == null ? 0 : this.bjT.length;
                        long[] jArr3 = new long[(zzc5 + length7)];
                        if (length7 != 0) {
                            System.arraycopy(this.bjT, 0, jArr3, 0, length7);
                        }
                        while (length7 < jArr3.length - 1) {
                            jArr3[length7] = zzapn.mo7960ak();
                            zzapn.mo7957ah();
                            length7++;
                        }
                        jArr3[length7] = zzapn.mo7960ak();
                        this.bjT = jArr3;
                        continue;
                    case C0515k.AppCompatTheme_textAppearancePopupMenuHeader:
                        int zzafr3 = zzapn.zzafr(zzapn.mo7966aq());
                        int position3 = zzapn.getPosition();
                        int i3 = 0;
                        while (zzapn.mo7970av() > 0) {
                            zzapn.mo7960ak();
                            i3++;
                        }
                        zzapn.zzaft(position3);
                        int length8 = this.bjT == null ? 0 : this.bjT.length;
                        long[] jArr4 = new long[(i3 + length8)];
                        if (length8 != 0) {
                            System.arraycopy(this.bjT, 0, jArr4, 0, length8);
                        }
                        while (length8 < jArr4.length) {
                            jArr4[length8] = zzapn.mo7960ak();
                            length8++;
                        }
                        this.bjT = jArr4;
                        zzapn.zzafs(zzafr3);
                        continue;
                    default:
                        if (!super.mo8023a(zzapn, ah)) {
                            break;
                        } else {
                            continue;
                        }
                }
            }
            return this;
        }
    }

    public final class zzb extends zzapp implements Cloneable {
        public int bjU;
        public String bjV;
        public String version;

        public zzb() {
            mo8056aP();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int mo7714a() {
            int a = super.mo7714a();
            if (this.bjU != 0) {
                a += zzapo.zzag(1, this.bjU);
            }
            if (!this.bjV.equals("")) {
                a += zzapo.zzs(2, this.bjV);
            }
            return !this.version.equals("") ? a + zzapo.zzs(3, this.version) : a;
        }

        /* renamed from: aA */
        public /* synthetic */ zzapp mo8024aA() {
            return (zzb) clone();
        }

        /* renamed from: aB */
        public /* synthetic */ zzapv mo8025aB() {
            return (zzb) clone();
        }

        /* renamed from: aP */
        public zzb mo8056aP() {
            this.bjU = 0;
            this.bjV = "";
            this.version = "";
            this.f5895a = null;
            this.f5906b = -1;
            return this;
        }

        /* renamed from: aQ */
        public zzb clone() {
            try {
                return (zzb) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzb)) {
                return false;
            }
            zzb zzb = (zzb) obj;
            if (this.bjU != zzb.bjU) {
                return false;
            }
            if (this.bjV == null) {
                if (zzb.bjV != null) {
                    return false;
                }
            } else if (!this.bjV.equals(zzb.bjV)) {
                return false;
            }
            if (this.version == null) {
                if (zzb.version != null) {
                    return false;
                }
            } else if (!this.version.equals(zzb.version)) {
                return false;
            }
            return (this.f5895a == null || this.f5895a.isEmpty()) ? zzb.f5895a == null || zzb.f5895a.isEmpty() : this.f5895a.equals(zzb.f5895a);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.version == null ? 0 : this.version.hashCode()) + (((this.bjV == null ? 0 : this.bjV.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + this.bjU) * 31)) * 31)) * 31;
            if (this.f5895a != null && !this.f5895a.isEmpty()) {
                i = this.f5895a.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzapo zzapo) {
            if (this.bjU != 0) {
                zzapo.zzae(1, this.bjU);
            }
            if (!this.bjV.equals("")) {
                zzapo.zzr(2, this.bjV);
            }
            if (!this.version.equals("")) {
                zzapo.zzr(3, this.version);
            }
            super.zza(zzapo);
        }

        /* renamed from: zzci */
        public zzb zzb(zzapn zzapn) {
            while (true) {
                int ah = zzapn.mo7957ah();
                switch (ah) {
                    case 0:
                        break;
                    case 8:
                        this.bjU = zzapn.mo7961al();
                        continue;
                    case 18:
                        this.bjV = zzapn.readString();
                        continue;
                    case 26:
                        this.version = zzapn.readString();
                        continue;
                    default:
                        if (!super.mo8023a(zzapn, ah)) {
                            break;
                        } else {
                            continue;
                        }
                }
            }
            return this;
        }
    }

    public final class zzc extends zzapp implements Cloneable {
        public byte[] bjW;
        public String bjX;
        public byte[][] bjY;
        public boolean bjZ;

        public zzc() {
            mo8061aR();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int mo7714a() {
            int a = super.mo7714a();
            if (!Arrays.equals(this.bjW, zzapy.bjO)) {
                a += zzapo.zzb(1, this.bjW);
            }
            if (this.bjY != null && this.bjY.length > 0) {
                int i = 0;
                int i2 = 0;
                for (byte[] bArr : this.bjY) {
                    if (bArr != null) {
                        i2++;
                        i += zzapo.zzbg(bArr);
                    }
                }
                a = a + i + (i2 * 1);
            }
            if (this.bjZ) {
                a += zzapo.zzk(3, this.bjZ);
            }
            return !this.bjX.equals("") ? a + zzapo.zzs(4, this.bjX) : a;
        }

        /* renamed from: aA */
        public /* synthetic */ zzapp mo8024aA() {
            return (zzc) clone();
        }

        /* renamed from: aB */
        public /* synthetic */ zzapv mo8025aB() {
            return (zzc) clone();
        }

        /* renamed from: aR */
        public zzc mo8061aR() {
            this.bjW = zzapy.bjO;
            this.bjX = "";
            this.bjY = zzapy.bjN;
            this.bjZ = false;
            this.f5895a = null;
            this.f5906b = -1;
            return this;
        }

        /* renamed from: aS */
        public zzc clone() {
            try {
                zzc zzc = (zzc) super.clone();
                if (this.bjY != null && this.bjY.length > 0) {
                    zzc.bjY = (byte[][]) this.bjY.clone();
                }
                return zzc;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzc)) {
                return false;
            }
            zzc zzc = (zzc) obj;
            if (!Arrays.equals(this.bjW, zzc.bjW)) {
                return false;
            }
            if (this.bjX == null) {
                if (zzc.bjX != null) {
                    return false;
                }
            } else if (!this.bjX.equals(zzc.bjX)) {
                return false;
            }
            if (!zzapt.zza(this.bjY, zzc.bjY) || this.bjZ != zzc.bjZ) {
                return false;
            }
            return (this.f5895a == null || this.f5895a.isEmpty()) ? zzc.f5895a == null || zzc.f5895a.isEmpty() : this.f5895a.equals(zzc.f5895a);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.bjZ ? 1231 : 1237) + (((((this.bjX == null ? 0 : this.bjX.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + Arrays.hashCode(this.bjW)) * 31)) * 31) + zzapt.zzb(this.bjY)) * 31)) * 31;
            if (this.f5895a != null && !this.f5895a.isEmpty()) {
                i = this.f5895a.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzapo zzapo) {
            if (!Arrays.equals(this.bjW, zzapy.bjO)) {
                zzapo.zza(1, this.bjW);
            }
            if (this.bjY != null && this.bjY.length > 0) {
                for (byte[] bArr : this.bjY) {
                    if (bArr != null) {
                        zzapo.zza(2, bArr);
                    }
                }
            }
            if (this.bjZ) {
                zzapo.zzj(3, this.bjZ);
            }
            if (!this.bjX.equals("")) {
                zzapo.zzr(4, this.bjX);
            }
            super.zza(zzapo);
        }

        /* renamed from: zzcj */
        public zzc zzb(zzapn zzapn) {
            while (true) {
                int ah = zzapn.mo7957ah();
                switch (ah) {
                    case 0:
                        break;
                    case 10:
                        this.bjW = zzapn.readBytes();
                        continue;
                    case 18:
                        int zzc = zzapy.zzc(zzapn, 18);
                        int length = this.bjY == null ? 0 : this.bjY.length;
                        byte[][] bArr = new byte[(zzc + length)][];
                        if (length != 0) {
                            System.arraycopy(this.bjY, 0, bArr, 0, length);
                        }
                        while (length < bArr.length - 1) {
                            bArr[length] = zzapn.readBytes();
                            zzapn.mo7957ah();
                            length++;
                        }
                        bArr[length] = zzapn.readBytes();
                        this.bjY = bArr;
                        continue;
                    case 24:
                        this.bjZ = zzapn.mo7963an();
                        continue;
                    case C0515k.AppCompatTheme_actionModePasteDrawable:
                        this.bjX = zzapn.readString();
                        continue;
                    default:
                        if (!super.mo8023a(zzapn, ah)) {
                            break;
                        } else {
                            continue;
                        }
                }
            }
            return this;
        }
    }

    public final class zzd extends zzapp implements Cloneable {
        public boolean aTs;
        public long bka;
        public long bkb;
        public long bkc;
        public int bkd;
        public zze[] bke;
        public byte[] bkf;
        public zzb bkg;
        public byte[] bkh;
        public String bki;
        public String bkj;
        public zza bkk;
        public String bkl;
        public long bkm;
        public zzc bkn;
        public byte[] bko;
        public String bkp;
        public int bkq;
        public int[] bkr;
        public long bks;
        public zzf bkt;
        public String tag;
        public int zzahl;

        public zzd() {
            mo8066aT();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int mo7714a() {
            int a = super.mo7714a();
            if (this.bka != 0) {
                a += zzapo.zze(1, this.bka);
            }
            if (!this.tag.equals("")) {
                a += zzapo.zzs(2, this.tag);
            }
            if (this.bke != null && this.bke.length > 0) {
                int i = a;
                for (zze zze : this.bke) {
                    if (zze != null) {
                        i += zzapo.zzc(3, (zzapv) zze);
                    }
                }
                a = i;
            }
            if (!Arrays.equals(this.bkf, zzapy.bjO)) {
                a += zzapo.zzb(4, this.bkf);
            }
            if (!Arrays.equals(this.bkh, zzapy.bjO)) {
                a += zzapo.zzb(6, this.bkh);
            }
            if (this.bkk != null) {
                a += zzapo.zzc(7, (zzapv) this.bkk);
            }
            if (!this.bki.equals("")) {
                a += zzapo.zzs(8, this.bki);
            }
            if (this.bkg != null) {
                a += zzapo.zzc(9, (zzapv) this.bkg);
            }
            if (this.aTs) {
                a += zzapo.zzk(10, this.aTs);
            }
            if (this.bkd != 0) {
                a += zzapo.zzag(11, this.bkd);
            }
            if (this.zzahl != 0) {
                a += zzapo.zzag(12, this.zzahl);
            }
            if (!this.bkj.equals("")) {
                a += zzapo.zzs(13, this.bkj);
            }
            if (!this.bkl.equals("")) {
                a += zzapo.zzs(14, this.bkl);
            }
            if (this.bkm != 180000) {
                a += zzapo.zzg(15, this.bkm);
            }
            if (this.bkn != null) {
                a += zzapo.zzc(16, (zzapv) this.bkn);
            }
            if (this.bkb != 0) {
                a += zzapo.zze(17, this.bkb);
            }
            if (!Arrays.equals(this.bko, zzapy.bjO)) {
                a += zzapo.zzb(18, this.bko);
            }
            if (this.bkq != 0) {
                a += zzapo.zzag(19, this.bkq);
            }
            if (this.bkr != null && this.bkr.length > 0) {
                int i2 = 0;
                for (int zzafx : this.bkr) {
                    i2 += zzapo.zzafx(zzafx);
                }
                a = a + i2 + (this.bkr.length * 2);
            }
            if (this.bkc != 0) {
                a += zzapo.zze(21, this.bkc);
            }
            if (this.bks != 0) {
                a += zzapo.zze(22, this.bks);
            }
            if (this.bkt != null) {
                a += zzapo.zzc(23, (zzapv) this.bkt);
            }
            return !this.bkp.equals("") ? a + zzapo.zzs(24, this.bkp) : a;
        }

        /* renamed from: aA */
        public /* synthetic */ zzapp mo8024aA() {
            return (zzd) clone();
        }

        /* renamed from: aB */
        public /* synthetic */ zzapv mo8025aB() {
            return (zzd) clone();
        }

        /* renamed from: aT */
        public zzd mo8066aT() {
            this.bka = 0;
            this.bkb = 0;
            this.bkc = 0;
            this.tag = "";
            this.bkd = 0;
            this.zzahl = 0;
            this.aTs = false;
            this.bke = zze.m6855aV();
            this.bkf = zzapy.bjO;
            this.bkg = null;
            this.bkh = zzapy.bjO;
            this.bki = "";
            this.bkj = "";
            this.bkk = null;
            this.bkl = "";
            this.bkm = 180000;
            this.bkn = null;
            this.bko = zzapy.bjO;
            this.bkp = "";
            this.bkq = 0;
            this.bkr = zzapy.bjH;
            this.bks = 0;
            this.bkt = null;
            this.f5895a = null;
            this.f5906b = -1;
            return this;
        }

        /* renamed from: aU */
        public zzd clone() {
            try {
                zzd zzd = (zzd) super.clone();
                if (this.bke != null && this.bke.length > 0) {
                    zzd.bke = new zze[this.bke.length];
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= this.bke.length) {
                            break;
                        }
                        if (this.bke[i2] != null) {
                            zzd.bke[i2] = (zze) this.bke[i2].clone();
                        }
                        i = i2 + 1;
                    }
                }
                if (this.bkg != null) {
                    zzd.bkg = (zzb) this.bkg.clone();
                }
                if (this.bkk != null) {
                    zzd.bkk = (zza) this.bkk.clone();
                }
                if (this.bkn != null) {
                    zzd.bkn = (zzc) this.bkn.clone();
                }
                if (this.bkr != null && this.bkr.length > 0) {
                    zzd.bkr = (int[]) this.bkr.clone();
                }
                if (this.bkt != null) {
                    zzd.bkt = (zzf) this.bkt.clone();
                }
                return zzd;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzd)) {
                return false;
            }
            zzd zzd = (zzd) obj;
            if (this.bka != zzd.bka || this.bkb != zzd.bkb || this.bkc != zzd.bkc) {
                return false;
            }
            if (this.tag == null) {
                if (zzd.tag != null) {
                    return false;
                }
            } else if (!this.tag.equals(zzd.tag)) {
                return false;
            }
            if (this.bkd != zzd.bkd || this.zzahl != zzd.zzahl || this.aTs != zzd.aTs || !zzapt.equals((Object[]) this.bke, (Object[]) zzd.bke) || !Arrays.equals(this.bkf, zzd.bkf)) {
                return false;
            }
            if (this.bkg == null) {
                if (zzd.bkg != null) {
                    return false;
                }
            } else if (!this.bkg.equals(zzd.bkg)) {
                return false;
            }
            if (!Arrays.equals(this.bkh, zzd.bkh)) {
                return false;
            }
            if (this.bki == null) {
                if (zzd.bki != null) {
                    return false;
                }
            } else if (!this.bki.equals(zzd.bki)) {
                return false;
            }
            if (this.bkj == null) {
                if (zzd.bkj != null) {
                    return false;
                }
            } else if (!this.bkj.equals(zzd.bkj)) {
                return false;
            }
            if (this.bkk == null) {
                if (zzd.bkk != null) {
                    return false;
                }
            } else if (!this.bkk.equals(zzd.bkk)) {
                return false;
            }
            if (this.bkl == null) {
                if (zzd.bkl != null) {
                    return false;
                }
            } else if (!this.bkl.equals(zzd.bkl)) {
                return false;
            }
            if (this.bkm != zzd.bkm) {
                return false;
            }
            if (this.bkn == null) {
                if (zzd.bkn != null) {
                    return false;
                }
            } else if (!this.bkn.equals(zzd.bkn)) {
                return false;
            }
            if (!Arrays.equals(this.bko, zzd.bko)) {
                return false;
            }
            if (this.bkp == null) {
                if (zzd.bkp != null) {
                    return false;
                }
            } else if (!this.bkp.equals(zzd.bkp)) {
                return false;
            }
            if (this.bkq != zzd.bkq || !zzapt.equals(this.bkr, zzd.bkr) || this.bks != zzd.bks) {
                return false;
            }
            if (this.bkt == null) {
                if (zzd.bkt != null) {
                    return false;
                }
            } else if (!this.bkt.equals(zzd.bkt)) {
                return false;
            }
            return (this.f5895a == null || this.f5895a.isEmpty()) ? zzd.f5895a == null || zzd.f5895a.isEmpty() : this.f5895a.equals(zzd.f5895a);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.bkt == null ? 0 : this.bkt.hashCode()) + (((((((((this.bkp == null ? 0 : this.bkp.hashCode()) + (((((this.bkn == null ? 0 : this.bkn.hashCode()) + (((((this.bkl == null ? 0 : this.bkl.hashCode()) + (((this.bkk == null ? 0 : this.bkk.hashCode()) + (((this.bkj == null ? 0 : this.bkj.hashCode()) + (((this.bki == null ? 0 : this.bki.hashCode()) + (((((this.bkg == null ? 0 : this.bkg.hashCode()) + (((((((this.aTs ? 1231 : 1237) + (((((((this.tag == null ? 0 : this.tag.hashCode()) + ((((((((getClass().getName().hashCode() + 527) * 31) + ((int) (this.bka ^ (this.bka >>> 32)))) * 31) + ((int) (this.bkb ^ (this.bkb >>> 32)))) * 31) + ((int) (this.bkc ^ (this.bkc >>> 32)))) * 31)) * 31) + this.bkd) * 31) + this.zzahl) * 31)) * 31) + zzapt.hashCode((Object[]) this.bke)) * 31) + Arrays.hashCode(this.bkf)) * 31)) * 31) + Arrays.hashCode(this.bkh)) * 31)) * 31)) * 31)) * 31)) * 31) + ((int) (this.bkm ^ (this.bkm >>> 32)))) * 31)) * 31) + Arrays.hashCode(this.bko)) * 31)) * 31) + this.bkq) * 31) + zzapt.hashCode(this.bkr)) * 31) + ((int) (this.bks ^ (this.bks >>> 32)))) * 31)) * 31;
            if (this.f5895a != null && !this.f5895a.isEmpty()) {
                i = this.f5895a.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzapo zzapo) {
            if (this.bka != 0) {
                zzapo.zzb(1, this.bka);
            }
            if (!this.tag.equals("")) {
                zzapo.zzr(2, this.tag);
            }
            if (this.bke != null && this.bke.length > 0) {
                for (zze zze : this.bke) {
                    if (zze != null) {
                        zzapo.zza(3, (zzapv) zze);
                    }
                }
            }
            if (!Arrays.equals(this.bkf, zzapy.bjO)) {
                zzapo.zza(4, this.bkf);
            }
            if (!Arrays.equals(this.bkh, zzapy.bjO)) {
                zzapo.zza(6, this.bkh);
            }
            if (this.bkk != null) {
                zzapo.zza(7, (zzapv) this.bkk);
            }
            if (!this.bki.equals("")) {
                zzapo.zzr(8, this.bki);
            }
            if (this.bkg != null) {
                zzapo.zza(9, (zzapv) this.bkg);
            }
            if (this.aTs) {
                zzapo.zzj(10, this.aTs);
            }
            if (this.bkd != 0) {
                zzapo.zzae(11, this.bkd);
            }
            if (this.zzahl != 0) {
                zzapo.zzae(12, this.zzahl);
            }
            if (!this.bkj.equals("")) {
                zzapo.zzr(13, this.bkj);
            }
            if (!this.bkl.equals("")) {
                zzapo.zzr(14, this.bkl);
            }
            if (this.bkm != 180000) {
                zzapo.zzd(15, this.bkm);
            }
            if (this.bkn != null) {
                zzapo.zza(16, (zzapv) this.bkn);
            }
            if (this.bkb != 0) {
                zzapo.zzb(17, this.bkb);
            }
            if (!Arrays.equals(this.bko, zzapy.bjO)) {
                zzapo.zza(18, this.bko);
            }
            if (this.bkq != 0) {
                zzapo.zzae(19, this.bkq);
            }
            if (this.bkr != null && this.bkr.length > 0) {
                for (int zzae : this.bkr) {
                    zzapo.zzae(20, zzae);
                }
            }
            if (this.bkc != 0) {
                zzapo.zzb(21, this.bkc);
            }
            if (this.bks != 0) {
                zzapo.zzb(22, this.bks);
            }
            if (this.bkt != null) {
                zzapo.zza(23, (zzapv) this.bkt);
            }
            if (!this.bkp.equals("")) {
                zzapo.zzr(24, this.bkp);
            }
            super.zza(zzapo);
        }

        /* renamed from: zzck */
        public zzd zzb(zzapn zzapn) {
            while (true) {
                int ah = zzapn.mo7957ah();
                switch (ah) {
                    case 0:
                        break;
                    case 8:
                        this.bka = zzapn.mo7960ak();
                        continue;
                    case 18:
                        this.tag = zzapn.readString();
                        continue;
                    case 26:
                        int zzc = zzapy.zzc(zzapn, 26);
                        int length = this.bke == null ? 0 : this.bke.length;
                        zze[] zzeArr = new zze[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.bke, 0, zzeArr, 0, length);
                        }
                        while (length < zzeArr.length - 1) {
                            zzeArr[length] = new zze();
                            zzapn.zza(zzeArr[length]);
                            zzapn.mo7957ah();
                            length++;
                        }
                        zzeArr[length] = new zze();
                        zzapn.zza(zzeArr[length]);
                        this.bke = zzeArr;
                        continue;
                    case C0515k.AppCompatTheme_actionModePasteDrawable:
                        this.bkf = zzapn.readBytes();
                        continue;
                    case 50:
                        this.bkh = zzapn.readBytes();
                        continue;
                    case C0515k.AppCompatTheme_activityChooserViewStyle:
                        if (this.bkk == null) {
                            this.bkk = new zza();
                        }
                        zzapn.zza(this.bkk);
                        continue;
                    case C0515k.AppCompatTheme_textAppearanceSearchResultTitle:
                        this.bki = zzapn.readString();
                        continue;
                    case C0515k.AppCompatTheme_listPreferredItemPaddingRight:
                        if (this.bkg == null) {
                            this.bkg = new zzb();
                        }
                        zzapn.zza(this.bkg);
                        continue;
                    case C0515k.AppCompatTheme_panelMenuListWidth:
                        this.aTs = zzapn.mo7963an();
                        continue;
                    case C0515k.AppCompatTheme_colorControlHighlight:
                        this.bkd = zzapn.mo7961al();
                        continue;
                    case C0515k.AppCompatTheme_alertDialogTheme:
                        this.zzahl = zzapn.mo7961al();
                        continue;
                    case C0515k.AppCompatTheme_editTextStyle:
                        this.bkj = zzapn.readString();
                        continue;
                    case C0515k.AppCompatTheme_listMenuViewStyle:
                        this.bkl = zzapn.readString();
                        continue;
                    case 120:
                        this.bkm = zzapn.mo7965ap();
                        continue;
                    case 130:
                        if (this.bkn == null) {
                            this.bkn = new zzc();
                        }
                        zzapn.zza(this.bkn);
                        continue;
                    case 136:
                        this.bkb = zzapn.mo7960ak();
                        continue;
                    case 146:
                        this.bko = zzapn.readBytes();
                        continue;
                    case 152:
                        int al = zzapn.mo7961al();
                        switch (al) {
                            case 0:
                            case 1:
                            case 2:
                                this.bkq = al;
                                break;
                            default:
                                continue;
                        }
                    case 160:
                        int zzc2 = zzapy.zzc(zzapn, 160);
                        int length2 = this.bkr == null ? 0 : this.bkr.length;
                        int[] iArr = new int[(zzc2 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.bkr, 0, iArr, 0, length2);
                        }
                        while (length2 < iArr.length - 1) {
                            iArr[length2] = zzapn.mo7961al();
                            zzapn.mo7957ah();
                            length2++;
                        }
                        iArr[length2] = zzapn.mo7961al();
                        this.bkr = iArr;
                        continue;
                    case 162:
                        int zzafr = zzapn.zzafr(zzapn.mo7966aq());
                        int position = zzapn.getPosition();
                        int i = 0;
                        while (zzapn.mo7970av() > 0) {
                            zzapn.mo7961al();
                            i++;
                        }
                        zzapn.zzaft(position);
                        int length3 = this.bkr == null ? 0 : this.bkr.length;
                        int[] iArr2 = new int[(i + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.bkr, 0, iArr2, 0, length3);
                        }
                        while (length3 < iArr2.length) {
                            iArr2[length3] = zzapn.mo7961al();
                            length3++;
                        }
                        this.bkr = iArr2;
                        zzapn.zzafs(zzafr);
                        continue;
                    case 168:
                        this.bkc = zzapn.mo7960ak();
                        continue;
                    case 176:
                        this.bks = zzapn.mo7960ak();
                        continue;
                    case 186:
                        if (this.bkt == null) {
                            this.bkt = new zzf();
                        }
                        zzapn.zza(this.bkt);
                        continue;
                    case 194:
                        this.bkp = zzapn.readString();
                        continue;
                    default:
                        if (!super.mo8023a(zzapn, ah)) {
                            break;
                        } else {
                            continue;
                        }
                }
            }
            return this;
        }
    }

    public final class zze extends zzapp implements Cloneable {

        /* renamed from: c */
        private static volatile zze[] f5907c;
        public String value;
        public String zzcb;

        public zze() {
            mo8071aW();
        }

        /* renamed from: aV */
        public static zze[] m6855aV() {
            if (f5907c == null) {
                synchronized (zzapt.bjF) {
                    if (f5907c == null) {
                        f5907c = new zze[0];
                    }
                }
            }
            return f5907c;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int mo7714a() {
            int a = super.mo7714a();
            if (!this.zzcb.equals("")) {
                a += zzapo.zzs(1, this.zzcb);
            }
            return !this.value.equals("") ? a + zzapo.zzs(2, this.value) : a;
        }

        /* renamed from: aA */
        public /* synthetic */ zzapp mo8024aA() {
            return (zze) clone();
        }

        /* renamed from: aB */
        public /* synthetic */ zzapv mo8025aB() {
            return (zze) clone();
        }

        /* renamed from: aW */
        public zze mo8071aW() {
            this.zzcb = "";
            this.value = "";
            this.f5895a = null;
            this.f5906b = -1;
            return this;
        }

        /* renamed from: aX */
        public zze clone() {
            try {
                return (zze) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zze)) {
                return false;
            }
            zze zze = (zze) obj;
            if (this.zzcb == null) {
                if (zze.zzcb != null) {
                    return false;
                }
            } else if (!this.zzcb.equals(zze.zzcb)) {
                return false;
            }
            if (this.value == null) {
                if (zze.value != null) {
                    return false;
                }
            } else if (!this.value.equals(zze.value)) {
                return false;
            }
            return (this.f5895a == null || this.f5895a.isEmpty()) ? zze.f5895a == null || zze.f5895a.isEmpty() : this.f5895a.equals(zze.f5895a);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.value == null ? 0 : this.value.hashCode()) + (((this.zzcb == null ? 0 : this.zzcb.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
            if (this.f5895a != null && !this.f5895a.isEmpty()) {
                i = this.f5895a.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzapo zzapo) {
            if (!this.zzcb.equals("")) {
                zzapo.zzr(1, this.zzcb);
            }
            if (!this.value.equals("")) {
                zzapo.zzr(2, this.value);
            }
            super.zza(zzapo);
        }

        /* renamed from: zzcl */
        public zze zzb(zzapn zzapn) {
            while (true) {
                int ah = zzapn.mo7957ah();
                switch (ah) {
                    case 0:
                        break;
                    case 10:
                        this.zzcb = zzapn.readString();
                        continue;
                    case 18:
                        this.value = zzapn.readString();
                        continue;
                    default:
                        if (!super.mo8023a(zzapn, ah)) {
                            break;
                        } else {
                            continue;
                        }
                }
            }
            return this;
        }
    }

    public final class zzf extends zzapp implements Cloneable {
        public int bkv;

        public zzf() {
            mo8076aY();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int mo7714a() {
            int a = super.mo7714a();
            return this.bkv != -1 ? a + zzapo.zzag(1, this.bkv) : a;
        }

        /* renamed from: aA */
        public /* synthetic */ zzapp mo8024aA() {
            return (zzf) clone();
        }

        /* renamed from: aB */
        public /* synthetic */ zzapv mo8025aB() {
            return (zzf) clone();
        }

        /* renamed from: aY */
        public zzf mo8076aY() {
            this.bkv = -1;
            this.f5895a = null;
            this.f5906b = -1;
            return this;
        }

        /* renamed from: aZ */
        public zzf clone() {
            try {
                return (zzf) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzf)) {
                return false;
            }
            zzf zzf = (zzf) obj;
            if (this.bkv == zzf.bkv) {
                return (this.f5895a == null || this.f5895a.isEmpty()) ? zzf.f5895a == null || zzf.f5895a.isEmpty() : this.f5895a.equals(zzf.f5895a);
            }
            return false;
        }

        public int hashCode() {
            return ((this.f5895a == null || this.f5895a.isEmpty()) ? 0 : this.f5895a.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + this.bkv) * 31);
        }

        public void zza(zzapo zzapo) {
            if (this.bkv != -1) {
                zzapo.zzae(1, this.bkv);
            }
            super.zza(zzapo);
        }

        /* renamed from: zzcm */
        public zzf zzb(zzapn zzapn) {
            while (true) {
                int ah = zzapn.mo7957ah();
                switch (ah) {
                    case 0:
                        break;
                    case 8:
                        int al = zzapn.mo7961al();
                        switch (al) {
                            case -1:
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
                                this.bkv = al;
                                break;
                            default:
                                continue;
                        }
                    default:
                        if (!super.mo8023a(zzapn, ah)) {
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
