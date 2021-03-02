package com.google.android.gms.internal;

import com.google.android.gms.location.places.Place;
import java.io.IOException;
import java.util.Arrays;

public interface zzsz {

    public static final class zza extends zzso<zza> {
        public String[] zzbuI;
        public String[] zzbuJ;
        public int[] zzbuK;
        public long[] zzbuL;

        public zza() {
            zzJC();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zza)) {
                return false;
            }
            zza zza = (zza) o;
            if (!zzss.equals((Object[]) this.zzbuI, (Object[]) zza.zzbuI) || !zzss.equals((Object[]) this.zzbuJ, (Object[]) zza.zzbuJ) || !zzss.equals(this.zzbuK, zza.zzbuK) || !zzss.equals(this.zzbuL, zza.zzbuL)) {
                return false;
            }
            if (this.zzbuj == null || this.zzbuj.isEmpty()) {
                return zza.zzbuj == null || zza.zzbuj.isEmpty();
            }
            return this.zzbuj.equals(zza.zzbuj);
        }

        public int hashCode() {
            return ((this.zzbuj == null || this.zzbuj.isEmpty()) ? 0 : this.zzbuj.hashCode()) + ((((((((((getClass().getName().hashCode() + 527) * 31) + zzss.hashCode((Object[]) this.zzbuI)) * 31) + zzss.hashCode((Object[]) this.zzbuJ)) * 31) + zzss.hashCode(this.zzbuK)) * 31) + zzss.hashCode(this.zzbuL)) * 31);
        }

        public void writeTo(zzsn output) throws IOException {
            if (this.zzbuI != null && this.zzbuI.length > 0) {
                for (String str : this.zzbuI) {
                    if (str != null) {
                        output.zzn(1, str);
                    }
                }
            }
            if (this.zzbuJ != null && this.zzbuJ.length > 0) {
                for (String str2 : this.zzbuJ) {
                    if (str2 != null) {
                        output.zzn(2, str2);
                    }
                }
            }
            if (this.zzbuK != null && this.zzbuK.length > 0) {
                for (int zzA : this.zzbuK) {
                    output.zzA(3, zzA);
                }
            }
            if (this.zzbuL != null && this.zzbuL.length > 0) {
                for (long zzb : this.zzbuL) {
                    output.zzb(4, zzb);
                }
            }
            super.writeTo(output);
        }

        public zza zzJC() {
            this.zzbuI = zzsx.zzbuB;
            this.zzbuJ = zzsx.zzbuB;
            this.zzbuK = zzsx.zzbuw;
            this.zzbuL = zzsx.zzbux;
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        /* renamed from: zzS */
        public zza mergeFrom(zzsm zzsm) throws IOException {
            while (true) {
                int zzIX = zzsm.zzIX();
                switch (zzIX) {
                    case 0:
                        break;
                    case 10:
                        int zzc = zzsx.zzc(zzsm, 10);
                        int length = this.zzbuI == null ? 0 : this.zzbuI.length;
                        String[] strArr = new String[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzbuI, 0, strArr, 0, length);
                        }
                        while (length < strArr.length - 1) {
                            strArr[length] = zzsm.readString();
                            zzsm.zzIX();
                            length++;
                        }
                        strArr[length] = zzsm.readString();
                        this.zzbuI = strArr;
                        continue;
                    case 18:
                        int zzc2 = zzsx.zzc(zzsm, 18);
                        int length2 = this.zzbuJ == null ? 0 : this.zzbuJ.length;
                        String[] strArr2 = new String[(zzc2 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.zzbuJ, 0, strArr2, 0, length2);
                        }
                        while (length2 < strArr2.length - 1) {
                            strArr2[length2] = zzsm.readString();
                            zzsm.zzIX();
                            length2++;
                        }
                        strArr2[length2] = zzsm.readString();
                        this.zzbuJ = strArr2;
                        continue;
                    case 24:
                        int zzc3 = zzsx.zzc(zzsm, 24);
                        int length3 = this.zzbuK == null ? 0 : this.zzbuK.length;
                        int[] iArr = new int[(zzc3 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.zzbuK, 0, iArr, 0, length3);
                        }
                        while (length3 < iArr.length - 1) {
                            iArr[length3] = zzsm.zzJb();
                            zzsm.zzIX();
                            length3++;
                        }
                        iArr[length3] = zzsm.zzJb();
                        this.zzbuK = iArr;
                        continue;
                    case 26:
                        int zzmq = zzsm.zzmq(zzsm.zzJf());
                        int position = zzsm.getPosition();
                        int i = 0;
                        while (zzsm.zzJk() > 0) {
                            zzsm.zzJb();
                            i++;
                        }
                        zzsm.zzms(position);
                        int length4 = this.zzbuK == null ? 0 : this.zzbuK.length;
                        int[] iArr2 = new int[(i + length4)];
                        if (length4 != 0) {
                            System.arraycopy(this.zzbuK, 0, iArr2, 0, length4);
                        }
                        while (length4 < iArr2.length) {
                            iArr2[length4] = zzsm.zzJb();
                            length4++;
                        }
                        this.zzbuK = iArr2;
                        zzsm.zzmr(zzmq);
                        continue;
                    case 32:
                        int zzc4 = zzsx.zzc(zzsm, 32);
                        int length5 = this.zzbuL == null ? 0 : this.zzbuL.length;
                        long[] jArr = new long[(zzc4 + length5)];
                        if (length5 != 0) {
                            System.arraycopy(this.zzbuL, 0, jArr, 0, length5);
                        }
                        while (length5 < jArr.length - 1) {
                            jArr[length5] = zzsm.zzJa();
                            zzsm.zzIX();
                            length5++;
                        }
                        jArr[length5] = zzsm.zzJa();
                        this.zzbuL = jArr;
                        continue;
                    case 34:
                        int zzmq2 = zzsm.zzmq(zzsm.zzJf());
                        int position2 = zzsm.getPosition();
                        int i2 = 0;
                        while (zzsm.zzJk() > 0) {
                            zzsm.zzJa();
                            i2++;
                        }
                        zzsm.zzms(position2);
                        int length6 = this.zzbuL == null ? 0 : this.zzbuL.length;
                        long[] jArr2 = new long[(i2 + length6)];
                        if (length6 != 0) {
                            System.arraycopy(this.zzbuL, 0, jArr2, 0, length6);
                        }
                        while (length6 < jArr2.length) {
                            jArr2[length6] = zzsm.zzJa();
                            length6++;
                        }
                        this.zzbuL = jArr2;
                        zzsm.zzmr(zzmq2);
                        continue;
                    default:
                        if (!zza(zzsm, zzIX)) {
                            break;
                        } else {
                            continue;
                        }
                }
            }
            return this;
        }

        /* access modifiers changed from: protected */
        public int zzz() {
            int i;
            int zzz = super.zzz();
            if (this.zzbuI == null || this.zzbuI.length <= 0) {
                i = zzz;
            } else {
                int i2 = 0;
                int i3 = 0;
                for (String str : this.zzbuI) {
                    if (str != null) {
                        i3++;
                        i2 += zzsn.zzgO(str);
                    }
                }
                i = zzz + i2 + (i3 * 1);
            }
            if (this.zzbuJ != null && this.zzbuJ.length > 0) {
                int i4 = 0;
                int i5 = 0;
                for (String str2 : this.zzbuJ) {
                    if (str2 != null) {
                        i5++;
                        i4 += zzsn.zzgO(str2);
                    }
                }
                i = i + i4 + (i5 * 1);
            }
            if (this.zzbuK != null && this.zzbuK.length > 0) {
                int i6 = 0;
                for (int zzmx : this.zzbuK) {
                    i6 += zzsn.zzmx(zzmx);
                }
                i = i + i6 + (this.zzbuK.length * 1);
            }
            if (this.zzbuL == null || this.zzbuL.length <= 0) {
                return i;
            }
            int i7 = 0;
            for (long zzas : this.zzbuL) {
                i7 += zzsn.zzas(zzas);
            }
            return i + i7 + (this.zzbuL.length * 1);
        }
    }

    public static final class zzb extends zzso<zzb> {
        public String version;
        public int zzbuM;
        public String zzbuN;

        public zzb() {
            zzJD();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzb)) {
                return false;
            }
            zzb zzb = (zzb) o;
            if (this.zzbuM != zzb.zzbuM) {
                return false;
            }
            if (this.zzbuN == null) {
                if (zzb.zzbuN != null) {
                    return false;
                }
            } else if (!this.zzbuN.equals(zzb.zzbuN)) {
                return false;
            }
            if (this.version == null) {
                if (zzb.version != null) {
                    return false;
                }
            } else if (!this.version.equals(zzb.version)) {
                return false;
            }
            if (this.zzbuj == null || this.zzbuj.isEmpty()) {
                return zzb.zzbuj == null || zzb.zzbuj.isEmpty();
            }
            return this.zzbuj.equals(zzb.zzbuj);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.version == null ? 0 : this.version.hashCode()) + (((this.zzbuN == null ? 0 : this.zzbuN.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + this.zzbuM) * 31)) * 31)) * 31;
            if (this.zzbuj != null && !this.zzbuj.isEmpty()) {
                i = this.zzbuj.hashCode();
            }
            return hashCode + i;
        }

        public void writeTo(zzsn output) throws IOException {
            if (this.zzbuM != 0) {
                output.zzA(1, this.zzbuM);
            }
            if (!this.zzbuN.equals("")) {
                output.zzn(2, this.zzbuN);
            }
            if (!this.version.equals("")) {
                output.zzn(3, this.version);
            }
            super.writeTo(output);
        }

        public zzb zzJD() {
            this.zzbuM = 0;
            this.zzbuN = "";
            this.version = "";
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        /* renamed from: zzT */
        public zzb mergeFrom(zzsm zzsm) throws IOException {
            while (true) {
                int zzIX = zzsm.zzIX();
                switch (zzIX) {
                    case 0:
                        break;
                    case 8:
                        int zzJb = zzsm.zzJb();
                        switch (zzJb) {
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
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                                this.zzbuM = zzJb;
                                break;
                            default:
                                continue;
                        }
                    case 18:
                        this.zzbuN = zzsm.readString();
                        continue;
                    case 26:
                        this.version = zzsm.readString();
                        continue;
                    default:
                        if (!zza(zzsm, zzIX)) {
                            break;
                        } else {
                            continue;
                        }
                }
            }
            return this;
        }

        /* access modifiers changed from: protected */
        public int zzz() {
            int zzz = super.zzz();
            if (this.zzbuM != 0) {
                zzz += zzsn.zzC(1, this.zzbuM);
            }
            if (!this.zzbuN.equals("")) {
                zzz += zzsn.zzo(2, this.zzbuN);
            }
            return !this.version.equals("") ? zzz + zzsn.zzo(3, this.version) : zzz;
        }
    }

    public static final class zzc extends zzso<zzc> {
        public byte[] zzbuO;
        public byte[][] zzbuP;
        public boolean zzbuQ;

        public zzc() {
            zzJE();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzc)) {
                return false;
            }
            zzc zzc = (zzc) o;
            if (!Arrays.equals(this.zzbuO, zzc.zzbuO) || !zzss.zza(this.zzbuP, zzc.zzbuP) || this.zzbuQ != zzc.zzbuQ) {
                return false;
            }
            if (this.zzbuj == null || this.zzbuj.isEmpty()) {
                return zzc.zzbuj == null || zzc.zzbuj.isEmpty();
            }
            return this.zzbuj.equals(zzc.zzbuj);
        }

        public int hashCode() {
            return ((this.zzbuj == null || this.zzbuj.isEmpty()) ? 0 : this.zzbuj.hashCode()) + (((this.zzbuQ ? 1231 : 1237) + ((((((getClass().getName().hashCode() + 527) * 31) + Arrays.hashCode(this.zzbuO)) * 31) + zzss.zza(this.zzbuP)) * 31)) * 31);
        }

        public void writeTo(zzsn output) throws IOException {
            if (!Arrays.equals(this.zzbuO, zzsx.zzbuD)) {
                output.zza(1, this.zzbuO);
            }
            if (this.zzbuP != null && this.zzbuP.length > 0) {
                for (byte[] bArr : this.zzbuP) {
                    if (bArr != null) {
                        output.zza(2, bArr);
                    }
                }
            }
            if (this.zzbuQ) {
                output.zze(3, this.zzbuQ);
            }
            super.writeTo(output);
        }

        public zzc zzJE() {
            this.zzbuO = zzsx.zzbuD;
            this.zzbuP = zzsx.zzbuC;
            this.zzbuQ = false;
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        /* renamed from: zzU */
        public zzc mergeFrom(zzsm zzsm) throws IOException {
            while (true) {
                int zzIX = zzsm.zzIX();
                switch (zzIX) {
                    case 0:
                        break;
                    case 10:
                        this.zzbuO = zzsm.readBytes();
                        continue;
                    case 18:
                        int zzc = zzsx.zzc(zzsm, 18);
                        int length = this.zzbuP == null ? 0 : this.zzbuP.length;
                        byte[][] bArr = new byte[(zzc + length)][];
                        if (length != 0) {
                            System.arraycopy(this.zzbuP, 0, bArr, 0, length);
                        }
                        while (length < bArr.length - 1) {
                            bArr[length] = zzsm.readBytes();
                            zzsm.zzIX();
                            length++;
                        }
                        bArr[length] = zzsm.readBytes();
                        this.zzbuP = bArr;
                        continue;
                    case 24:
                        this.zzbuQ = zzsm.zzJc();
                        continue;
                    default:
                        if (!zza(zzsm, zzIX)) {
                            break;
                        } else {
                            continue;
                        }
                }
            }
            return this;
        }

        /* access modifiers changed from: protected */
        public int zzz() {
            int zzz = super.zzz();
            if (!Arrays.equals(this.zzbuO, zzsx.zzbuD)) {
                zzz += zzsn.zzb(1, this.zzbuO);
            }
            if (this.zzbuP != null && this.zzbuP.length > 0) {
                int i = 0;
                int i2 = 0;
                for (byte[] bArr : this.zzbuP) {
                    if (bArr != null) {
                        i2++;
                        i += zzsn.zzG(bArr);
                    }
                }
                zzz = zzz + i + (i2 * 1);
            }
            return this.zzbuQ ? zzz + zzsn.zzf(3, this.zzbuQ) : zzz;
        }
    }

    public static final class zzd extends zzso<zzd> {
        public String tag;
        public long zzbuR;
        public long zzbuS;
        public long zzbuT;
        public int zzbuU;
        public boolean zzbuV;
        public zze[] zzbuW;
        public zzb zzbuX;
        public byte[] zzbuY;
        public byte[] zzbuZ;
        public byte[] zzbva;
        public zza zzbvb;
        public String zzbvc;
        public long zzbvd;
        public zzc zzbve;
        public byte[] zzbvf;
        public int zzbvg;
        public int[] zzbvh;
        public long zzbvi;
        public int zzob;

        public zzd() {
            zzJF();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzd)) {
                return false;
            }
            zzd zzd = (zzd) o;
            if (this.zzbuR != zzd.zzbuR || this.zzbuS != zzd.zzbuS || this.zzbuT != zzd.zzbuT) {
                return false;
            }
            if (this.tag == null) {
                if (zzd.tag != null) {
                    return false;
                }
            } else if (!this.tag.equals(zzd.tag)) {
                return false;
            }
            if (this.zzbuU != zzd.zzbuU || this.zzob != zzd.zzob || this.zzbuV != zzd.zzbuV || !zzss.equals((Object[]) this.zzbuW, (Object[]) zzd.zzbuW)) {
                return false;
            }
            if (this.zzbuX == null) {
                if (zzd.zzbuX != null) {
                    return false;
                }
            } else if (!this.zzbuX.equals(zzd.zzbuX)) {
                return false;
            }
            if (!Arrays.equals(this.zzbuY, zzd.zzbuY) || !Arrays.equals(this.zzbuZ, zzd.zzbuZ) || !Arrays.equals(this.zzbva, zzd.zzbva)) {
                return false;
            }
            if (this.zzbvb == null) {
                if (zzd.zzbvb != null) {
                    return false;
                }
            } else if (!this.zzbvb.equals(zzd.zzbvb)) {
                return false;
            }
            if (this.zzbvc == null) {
                if (zzd.zzbvc != null) {
                    return false;
                }
            } else if (!this.zzbvc.equals(zzd.zzbvc)) {
                return false;
            }
            if (this.zzbvd != zzd.zzbvd) {
                return false;
            }
            if (this.zzbve == null) {
                if (zzd.zzbve != null) {
                    return false;
                }
            } else if (!this.zzbve.equals(zzd.zzbve)) {
                return false;
            }
            if (!Arrays.equals(this.zzbvf, zzd.zzbvf) || this.zzbvg != zzd.zzbvg || !zzss.equals(this.zzbvh, zzd.zzbvh) || this.zzbvi != zzd.zzbvi) {
                return false;
            }
            if (this.zzbuj == null || this.zzbuj.isEmpty()) {
                return zzd.zzbuj == null || zzd.zzbuj.isEmpty();
            }
            return this.zzbuj.equals(zzd.zzbuj);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((((((((((this.zzbve == null ? 0 : this.zzbve.hashCode()) + (((((this.zzbvc == null ? 0 : this.zzbvc.hashCode()) + (((this.zzbvb == null ? 0 : this.zzbvb.hashCode()) + (((((((((this.zzbuX == null ? 0 : this.zzbuX.hashCode()) + (((((this.zzbuV ? 1231 : 1237) + (((((((this.tag == null ? 0 : this.tag.hashCode()) + ((((((((getClass().getName().hashCode() + 527) * 31) + ((int) (this.zzbuR ^ (this.zzbuR >>> 32)))) * 31) + ((int) (this.zzbuS ^ (this.zzbuS >>> 32)))) * 31) + ((int) (this.zzbuT ^ (this.zzbuT >>> 32)))) * 31)) * 31) + this.zzbuU) * 31) + this.zzob) * 31)) * 31) + zzss.hashCode((Object[]) this.zzbuW)) * 31)) * 31) + Arrays.hashCode(this.zzbuY)) * 31) + Arrays.hashCode(this.zzbuZ)) * 31) + Arrays.hashCode(this.zzbva)) * 31)) * 31)) * 31) + ((int) (this.zzbvd ^ (this.zzbvd >>> 32)))) * 31)) * 31) + Arrays.hashCode(this.zzbvf)) * 31) + this.zzbvg) * 31) + zzss.hashCode(this.zzbvh)) * 31) + ((int) (this.zzbvi ^ (this.zzbvi >>> 32)))) * 31;
            if (this.zzbuj != null && !this.zzbuj.isEmpty()) {
                i = this.zzbuj.hashCode();
            }
            return hashCode + i;
        }

        public void writeTo(zzsn output) throws IOException {
            if (this.zzbuR != 0) {
                output.zzb(1, this.zzbuR);
            }
            if (!this.tag.equals("")) {
                output.zzn(2, this.tag);
            }
            if (this.zzbuW != null && this.zzbuW.length > 0) {
                for (zze zze : this.zzbuW) {
                    if (zze != null) {
                        output.zza(3, (zzsu) zze);
                    }
                }
            }
            if (!Arrays.equals(this.zzbuY, zzsx.zzbuD)) {
                output.zza(6, this.zzbuY);
            }
            if (this.zzbvb != null) {
                output.zza(7, (zzsu) this.zzbvb);
            }
            if (!Arrays.equals(this.zzbuZ, zzsx.zzbuD)) {
                output.zza(8, this.zzbuZ);
            }
            if (this.zzbuX != null) {
                output.zza(9, (zzsu) this.zzbuX);
            }
            if (this.zzbuV) {
                output.zze(10, this.zzbuV);
            }
            if (this.zzbuU != 0) {
                output.zzA(11, this.zzbuU);
            }
            if (this.zzob != 0) {
                output.zzA(12, this.zzob);
            }
            if (!Arrays.equals(this.zzbva, zzsx.zzbuD)) {
                output.zza(13, this.zzbva);
            }
            if (!this.zzbvc.equals("")) {
                output.zzn(14, this.zzbvc);
            }
            if (this.zzbvd != 180000) {
                output.zzc(15, this.zzbvd);
            }
            if (this.zzbve != null) {
                output.zza(16, (zzsu) this.zzbve);
            }
            if (this.zzbuS != 0) {
                output.zzb(17, this.zzbuS);
            }
            if (!Arrays.equals(this.zzbvf, zzsx.zzbuD)) {
                output.zza(18, this.zzbvf);
            }
            if (this.zzbvg != 0) {
                output.zzA(19, this.zzbvg);
            }
            if (this.zzbvh != null && this.zzbvh.length > 0) {
                for (int zzA : this.zzbvh) {
                    output.zzA(20, zzA);
                }
            }
            if (this.zzbuT != 0) {
                output.zzb(21, this.zzbuT);
            }
            if (this.zzbvi != 0) {
                output.zzb(22, this.zzbvi);
            }
            super.writeTo(output);
        }

        public zzd zzJF() {
            this.zzbuR = 0;
            this.zzbuS = 0;
            this.zzbuT = 0;
            this.tag = "";
            this.zzbuU = 0;
            this.zzob = 0;
            this.zzbuV = false;
            this.zzbuW = zze.zzJG();
            this.zzbuX = null;
            this.zzbuY = zzsx.zzbuD;
            this.zzbuZ = zzsx.zzbuD;
            this.zzbva = zzsx.zzbuD;
            this.zzbvb = null;
            this.zzbvc = "";
            this.zzbvd = 180000;
            this.zzbve = null;
            this.zzbvf = zzsx.zzbuD;
            this.zzbvg = 0;
            this.zzbvh = zzsx.zzbuw;
            this.zzbvi = 0;
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        /* renamed from: zzV */
        public zzd mergeFrom(zzsm zzsm) throws IOException {
            while (true) {
                int zzIX = zzsm.zzIX();
                switch (zzIX) {
                    case 0:
                        break;
                    case 8:
                        this.zzbuR = zzsm.zzJa();
                        continue;
                    case 18:
                        this.tag = zzsm.readString();
                        continue;
                    case 26:
                        int zzc = zzsx.zzc(zzsm, 26);
                        int length = this.zzbuW == null ? 0 : this.zzbuW.length;
                        zze[] zzeArr = new zze[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzbuW, 0, zzeArr, 0, length);
                        }
                        while (length < zzeArr.length - 1) {
                            zzeArr[length] = new zze();
                            zzsm.zza(zzeArr[length]);
                            zzsm.zzIX();
                            length++;
                        }
                        zzeArr[length] = new zze();
                        zzsm.zza(zzeArr[length]);
                        this.zzbuW = zzeArr;
                        continue;
                    case 50:
                        this.zzbuY = zzsm.readBytes();
                        continue;
                    case Place.TYPE_LOCKSMITH /*58*/:
                        if (this.zzbvb == null) {
                            this.zzbvb = new zza();
                        }
                        zzsm.zza(this.zzbvb);
                        continue;
                    case 66:
                        this.zzbuZ = zzsm.readBytes();
                        continue;
                    case 74:
                        if (this.zzbuX == null) {
                            this.zzbuX = new zzb();
                        }
                        zzsm.zza(this.zzbuX);
                        continue;
                    case 80:
                        this.zzbuV = zzsm.zzJc();
                        continue;
                    case Place.TYPE_STORE /*88*/:
                        this.zzbuU = zzsm.zzJb();
                        continue;
                    case Place.TYPE_ZOO /*96*/:
                        this.zzob = zzsm.zzJb();
                        continue;
                    case SktSsiProtocol.kSsiDataOptionSuffix2:
                        this.zzbva = zzsm.readBytes();
                        continue;
                    case SktSsiProtocol.kSsiSymbologyIdChinese2of5:
                        this.zzbvc = zzsm.readString();
                        continue;
                    case 120:
                        this.zzbvd = zzsm.zzJe();
                        continue;
                    case 130:
                        if (this.zzbve == null) {
                            this.zzbve = new zzc();
                        }
                        zzsm.zza(this.zzbve);
                        continue;
                    case 136:
                        this.zzbuS = zzsm.zzJa();
                        continue;
                    case 146:
                        this.zzbvf = zzsm.readBytes();
                        continue;
                    case SktBtIscpProtocol.kSetupSocketCommandsFunctionHostDataConfirmation:
                        int zzJb = zzsm.zzJb();
                        switch (zzJb) {
                            case 0:
                            case 1:
                            case 2:
                                this.zzbvg = zzJb;
                                break;
                            default:
                                continue;
                        }
                    case 160:
                        int zzc2 = zzsx.zzc(zzsm, 160);
                        int length2 = this.zzbvh == null ? 0 : this.zzbvh.length;
                        int[] iArr = new int[(zzc2 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.zzbvh, 0, iArr, 0, length2);
                        }
                        while (length2 < iArr.length - 1) {
                            iArr[length2] = zzsm.zzJb();
                            zzsm.zzIX();
                            length2++;
                        }
                        iArr[length2] = zzsm.zzJb();
                        this.zzbvh = iArr;
                        continue;
                    case 162:
                        int zzmq = zzsm.zzmq(zzsm.zzJf());
                        int position = zzsm.getPosition();
                        int i = 0;
                        while (zzsm.zzJk() > 0) {
                            zzsm.zzJb();
                            i++;
                        }
                        zzsm.zzms(position);
                        int length3 = this.zzbvh == null ? 0 : this.zzbvh.length;
                        int[] iArr2 = new int[(i + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.zzbvh, 0, iArr2, 0, length3);
                        }
                        while (length3 < iArr2.length) {
                            iArr2[length3] = zzsm.zzJb();
                            length3++;
                        }
                        this.zzbvh = iArr2;
                        zzsm.zzmr(zzmq);
                        continue;
                    case 168:
                        this.zzbuT = zzsm.zzJa();
                        continue;
                    case 176:
                        this.zzbvi = zzsm.zzJa();
                        continue;
                    default:
                        if (!zza(zzsm, zzIX)) {
                            break;
                        } else {
                            continue;
                        }
                }
            }
            return this;
        }

        /* access modifiers changed from: protected */
        public int zzz() {
            int zzz = super.zzz();
            if (this.zzbuR != 0) {
                zzz += zzsn.zzd(1, this.zzbuR);
            }
            if (!this.tag.equals("")) {
                zzz += zzsn.zzo(2, this.tag);
            }
            if (this.zzbuW != null && this.zzbuW.length > 0) {
                int i = zzz;
                for (zze zze : this.zzbuW) {
                    if (zze != null) {
                        i += zzsn.zzc(3, (zzsu) zze);
                    }
                }
                zzz = i;
            }
            if (!Arrays.equals(this.zzbuY, zzsx.zzbuD)) {
                zzz += zzsn.zzb(6, this.zzbuY);
            }
            if (this.zzbvb != null) {
                zzz += zzsn.zzc(7, (zzsu) this.zzbvb);
            }
            if (!Arrays.equals(this.zzbuZ, zzsx.zzbuD)) {
                zzz += zzsn.zzb(8, this.zzbuZ);
            }
            if (this.zzbuX != null) {
                zzz += zzsn.zzc(9, (zzsu) this.zzbuX);
            }
            if (this.zzbuV) {
                zzz += zzsn.zzf(10, this.zzbuV);
            }
            if (this.zzbuU != 0) {
                zzz += zzsn.zzC(11, this.zzbuU);
            }
            if (this.zzob != 0) {
                zzz += zzsn.zzC(12, this.zzob);
            }
            if (!Arrays.equals(this.zzbva, zzsx.zzbuD)) {
                zzz += zzsn.zzb(13, this.zzbva);
            }
            if (!this.zzbvc.equals("")) {
                zzz += zzsn.zzo(14, this.zzbvc);
            }
            if (this.zzbvd != 180000) {
                zzz += zzsn.zze(15, this.zzbvd);
            }
            if (this.zzbve != null) {
                zzz += zzsn.zzc(16, (zzsu) this.zzbve);
            }
            if (this.zzbuS != 0) {
                zzz += zzsn.zzd(17, this.zzbuS);
            }
            if (!Arrays.equals(this.zzbvf, zzsx.zzbuD)) {
                zzz += zzsn.zzb(18, this.zzbvf);
            }
            if (this.zzbvg != 0) {
                zzz += zzsn.zzC(19, this.zzbvg);
            }
            if (this.zzbvh != null && this.zzbvh.length > 0) {
                int i2 = 0;
                for (int zzmx : this.zzbvh) {
                    i2 += zzsn.zzmx(zzmx);
                }
                zzz = zzz + i2 + (this.zzbvh.length * 2);
            }
            if (this.zzbuT != 0) {
                zzz += zzsn.zzd(21, this.zzbuT);
            }
            return this.zzbvi != 0 ? zzz + zzsn.zzd(22, this.zzbvi) : zzz;
        }
    }

    public static final class zze extends zzso<zze> {
        private static volatile zze[] zzbvj;
        public String key;
        public String value;

        public zze() {
            zzJH();
        }

        public static zze[] zzJG() {
            if (zzbvj == null) {
                synchronized (zzss.zzbut) {
                    if (zzbvj == null) {
                        zzbvj = new zze[0];
                    }
                }
            }
            return zzbvj;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zze)) {
                return false;
            }
            zze zze = (zze) o;
            if (this.key == null) {
                if (zze.key != null) {
                    return false;
                }
            } else if (!this.key.equals(zze.key)) {
                return false;
            }
            if (this.value == null) {
                if (zze.value != null) {
                    return false;
                }
            } else if (!this.value.equals(zze.value)) {
                return false;
            }
            if (this.zzbuj == null || this.zzbuj.isEmpty()) {
                return zze.zzbuj == null || zze.zzbuj.isEmpty();
            }
            return this.zzbuj.equals(zze.zzbuj);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.value == null ? 0 : this.value.hashCode()) + (((this.key == null ? 0 : this.key.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
            if (this.zzbuj != null && !this.zzbuj.isEmpty()) {
                i = this.zzbuj.hashCode();
            }
            return hashCode + i;
        }

        public void writeTo(zzsn output) throws IOException {
            if (!this.key.equals("")) {
                output.zzn(1, this.key);
            }
            if (!this.value.equals("")) {
                output.zzn(2, this.value);
            }
            super.writeTo(output);
        }

        public zze zzJH() {
            this.key = "";
            this.value = "";
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        /* renamed from: zzW */
        public zze mergeFrom(zzsm zzsm) throws IOException {
            while (true) {
                int zzIX = zzsm.zzIX();
                switch (zzIX) {
                    case 0:
                        break;
                    case 10:
                        this.key = zzsm.readString();
                        continue;
                    case 18:
                        this.value = zzsm.readString();
                        continue;
                    default:
                        if (!zza(zzsm, zzIX)) {
                            break;
                        } else {
                            continue;
                        }
                }
            }
            return this;
        }

        /* access modifiers changed from: protected */
        public int zzz() {
            int zzz = super.zzz();
            if (!this.key.equals("")) {
                zzz += zzsn.zzo(1, this.key);
            }
            return !this.value.equals("") ? zzz + zzsn.zzo(2, this.value) : zzz;
        }
    }
}
