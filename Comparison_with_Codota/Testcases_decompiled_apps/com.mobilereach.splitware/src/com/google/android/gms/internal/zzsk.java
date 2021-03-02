package com.google.android.gms.internal;

import java.io.IOException;

public final class zzsk extends zzso<zzsk> {
    public String[] zzbtT;
    public int[] zzbtU;
    public byte[][] zzbtV;

    public zzsk() {
        zzIW();
    }

    public static zzsk zzB(byte[] bArr) throws zzst {
        return (zzsk) zzsu.mergeFrom(new zzsk(), bArr);
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof zzsk)) {
            return false;
        }
        zzsk zzsk = (zzsk) o;
        if (!zzss.equals((Object[]) this.zzbtT, (Object[]) zzsk.zzbtT) || !zzss.equals(this.zzbtU, zzsk.zzbtU) || !zzss.zza(this.zzbtV, zzsk.zzbtV)) {
            return false;
        }
        if (this.zzbuj == null || this.zzbuj.isEmpty()) {
            return zzsk.zzbuj == null || zzsk.zzbuj.isEmpty();
        }
        return this.zzbuj.equals(zzsk.zzbuj);
    }

    public int hashCode() {
        return ((this.zzbuj == null || this.zzbuj.isEmpty()) ? 0 : this.zzbuj.hashCode()) + ((((((((getClass().getName().hashCode() + 527) * 31) + zzss.hashCode((Object[]) this.zzbtT)) * 31) + zzss.hashCode(this.zzbtU)) * 31) + zzss.zza(this.zzbtV)) * 31);
    }

    public void writeTo(zzsn output) throws IOException {
        if (this.zzbtT != null && this.zzbtT.length > 0) {
            for (String str : this.zzbtT) {
                if (str != null) {
                    output.zzn(1, str);
                }
            }
        }
        if (this.zzbtU != null && this.zzbtU.length > 0) {
            for (int zzA : this.zzbtU) {
                output.zzA(2, zzA);
            }
        }
        if (this.zzbtV != null && this.zzbtV.length > 0) {
            for (byte[] bArr : this.zzbtV) {
                if (bArr != null) {
                    output.zza(3, bArr);
                }
            }
        }
        super.writeTo(output);
    }

    public zzsk zzIW() {
        this.zzbtT = zzsx.zzbuB;
        this.zzbtU = zzsx.zzbuw;
        this.zzbtV = zzsx.zzbuC;
        this.zzbuj = null;
        this.zzbuu = -1;
        return this;
    }

    /* renamed from: zzO */
    public zzsk mergeFrom(zzsm zzsm) throws IOException {
        while (true) {
            int zzIX = zzsm.zzIX();
            switch (zzIX) {
                case 0:
                    break;
                case 10:
                    int zzc = zzsx.zzc(zzsm, 10);
                    int length = this.zzbtT == null ? 0 : this.zzbtT.length;
                    String[] strArr = new String[(zzc + length)];
                    if (length != 0) {
                        System.arraycopy(this.zzbtT, 0, strArr, 0, length);
                    }
                    while (length < strArr.length - 1) {
                        strArr[length] = zzsm.readString();
                        zzsm.zzIX();
                        length++;
                    }
                    strArr[length] = zzsm.readString();
                    this.zzbtT = strArr;
                    continue;
                case 16:
                    int zzc2 = zzsx.zzc(zzsm, 16);
                    int length2 = this.zzbtU == null ? 0 : this.zzbtU.length;
                    int[] iArr = new int[(zzc2 + length2)];
                    if (length2 != 0) {
                        System.arraycopy(this.zzbtU, 0, iArr, 0, length2);
                    }
                    while (length2 < iArr.length - 1) {
                        iArr[length2] = zzsm.zzJb();
                        zzsm.zzIX();
                        length2++;
                    }
                    iArr[length2] = zzsm.zzJb();
                    this.zzbtU = iArr;
                    continue;
                case 18:
                    int zzmq = zzsm.zzmq(zzsm.zzJf());
                    int position = zzsm.getPosition();
                    int i = 0;
                    while (zzsm.zzJk() > 0) {
                        zzsm.zzJb();
                        i++;
                    }
                    zzsm.zzms(position);
                    int length3 = this.zzbtU == null ? 0 : this.zzbtU.length;
                    int[] iArr2 = new int[(i + length3)];
                    if (length3 != 0) {
                        System.arraycopy(this.zzbtU, 0, iArr2, 0, length3);
                    }
                    while (length3 < iArr2.length) {
                        iArr2[length3] = zzsm.zzJb();
                        length3++;
                    }
                    this.zzbtU = iArr2;
                    zzsm.zzmr(zzmq);
                    continue;
                case 26:
                    int zzc3 = zzsx.zzc(zzsm, 26);
                    int length4 = this.zzbtV == null ? 0 : this.zzbtV.length;
                    byte[][] bArr = new byte[(zzc3 + length4)][];
                    if (length4 != 0) {
                        System.arraycopy(this.zzbtV, 0, bArr, 0, length4);
                    }
                    while (length4 < bArr.length - 1) {
                        bArr[length4] = zzsm.readBytes();
                        zzsm.zzIX();
                        length4++;
                    }
                    bArr[length4] = zzsm.readBytes();
                    this.zzbtV = bArr;
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
        if (this.zzbtT == null || this.zzbtT.length <= 0) {
            i = zzz;
        } else {
            int i2 = 0;
            int i3 = 0;
            for (String str : this.zzbtT) {
                if (str != null) {
                    i3++;
                    i2 += zzsn.zzgO(str);
                }
            }
            i = zzz + i2 + (i3 * 1);
        }
        if (this.zzbtU != null && this.zzbtU.length > 0) {
            int i4 = 0;
            for (int zzmx : this.zzbtU) {
                i4 += zzsn.zzmx(zzmx);
            }
            i = i + i4 + (this.zzbtU.length * 1);
        }
        if (this.zzbtV == null || this.zzbtV.length <= 0) {
            return i;
        }
        int i5 = 0;
        int i6 = 0;
        for (byte[] bArr : this.zzbtV) {
            if (bArr != null) {
                i6++;
                i5 += zzsn.zzG(bArr);
            }
        }
        return i + i5 + (i6 * 1);
    }
}
