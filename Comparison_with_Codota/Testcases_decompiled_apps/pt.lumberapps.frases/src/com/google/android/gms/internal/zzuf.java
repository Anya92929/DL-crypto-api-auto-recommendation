package com.google.android.gms.internal;

import android.support.p021v7.p023b.C0515k;

public interface zzuf {

    public final class zza extends zzapv {

        /* renamed from: a */
        private static volatile zza[] f7010a;
        public zze[] amA;
        public zzb[] amB;
        public Integer amz;

        public zza() {
            zzbve();
        }

        public static zza[] zzbvd() {
            if (f7010a == null) {
                synchronized (zzapt.bjF) {
                    if (f7010a == null) {
                        f7010a = new zza[0];
                    }
                }
            }
            return f7010a;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int mo7714a() {
            int a = super.mo7714a();
            if (this.amz != null) {
                a += zzapo.zzag(1, this.amz.intValue());
            }
            if (this.amA != null && this.amA.length > 0) {
                int i = a;
                for (zze zze : this.amA) {
                    if (zze != null) {
                        i += zzapo.zzc(2, (zzapv) zze);
                    }
                }
                a = i;
            }
            if (this.amB != null && this.amB.length > 0) {
                for (zzb zzb : this.amB) {
                    if (zzb != null) {
                        a += zzapo.zzc(3, (zzapv) zzb);
                    }
                }
            }
            return a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza = (zza) obj;
            if (this.amz == null) {
                if (zza.amz != null) {
                    return false;
                }
            } else if (!this.amz.equals(zza.amz)) {
                return false;
            }
            if (!zzapt.equals((Object[]) this.amA, (Object[]) zza.amA)) {
                return false;
            }
            return zzapt.equals((Object[]) this.amB, (Object[]) zza.amB);
        }

        public int hashCode() {
            return (((((this.amz == null ? 0 : this.amz.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + zzapt.hashCode((Object[]) this.amA)) * 31) + zzapt.hashCode((Object[]) this.amB);
        }

        public void zza(zzapo zzapo) {
            if (this.amz != null) {
                zzapo.zzae(1, this.amz.intValue());
            }
            if (this.amA != null && this.amA.length > 0) {
                for (zze zze : this.amA) {
                    if (zze != null) {
                        zzapo.zza(2, (zzapv) zze);
                    }
                }
            }
            if (this.amB != null && this.amB.length > 0) {
                for (zzb zzb : this.amB) {
                    if (zzb != null) {
                        zzapo.zza(3, (zzapv) zzb);
                    }
                }
            }
            super.zza(zzapo);
        }

        /* renamed from: zzac */
        public zza zzb(zzapn zzapn) {
            while (true) {
                int ah = zzapn.mo7957ah();
                switch (ah) {
                    case 0:
                        break;
                    case 8:
                        this.amz = Integer.valueOf(zzapn.mo7961al());
                        continue;
                    case 18:
                        int zzc = zzapy.zzc(zzapn, 18);
                        int length = this.amA == null ? 0 : this.amA.length;
                        zze[] zzeArr = new zze[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.amA, 0, zzeArr, 0, length);
                        }
                        while (length < zzeArr.length - 1) {
                            zzeArr[length] = new zze();
                            zzapn.zza(zzeArr[length]);
                            zzapn.mo7957ah();
                            length++;
                        }
                        zzeArr[length] = new zze();
                        zzapn.zza(zzeArr[length]);
                        this.amA = zzeArr;
                        continue;
                    case 26:
                        int zzc2 = zzapy.zzc(zzapn, 26);
                        int length2 = this.amB == null ? 0 : this.amB.length;
                        zzb[] zzbArr = new zzb[(zzc2 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.amB, 0, zzbArr, 0, length2);
                        }
                        while (length2 < zzbArr.length - 1) {
                            zzbArr[length2] = new zzb();
                            zzapn.zza(zzbArr[length2]);
                            zzapn.mo7957ah();
                            length2++;
                        }
                        zzbArr[length2] = new zzb();
                        zzapn.zza(zzbArr[length2]);
                        this.amB = zzbArr;
                        continue;
                    default:
                        if (!zzapy.zzb(zzapn, ah)) {
                            break;
                        } else {
                            continue;
                        }
                }
            }
            return this;
        }

        public zza zzbve() {
            this.amz = null;
            this.amA = zze.zzbvk();
            this.amB = zzb.zzbvf();
            this.f5906b = -1;
            return this;
        }
    }

    public final class zzb extends zzapv {

        /* renamed from: a */
        private static volatile zzb[] f7011a;
        public Integer amD;
        public String amE;
        public zzc[] amF;
        public Boolean amG;
        public zzd amH;

        public zzb() {
            zzbvg();
        }

        public static zzb[] zzbvf() {
            if (f7011a == null) {
                synchronized (zzapt.bjF) {
                    if (f7011a == null) {
                        f7011a = new zzb[0];
                    }
                }
            }
            return f7011a;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int mo7714a() {
            int a = super.mo7714a();
            if (this.amD != null) {
                a += zzapo.zzag(1, this.amD.intValue());
            }
            if (this.amE != null) {
                a += zzapo.zzs(2, this.amE);
            }
            if (this.amF != null && this.amF.length > 0) {
                int i = a;
                for (zzc zzc : this.amF) {
                    if (zzc != null) {
                        i += zzapo.zzc(3, (zzapv) zzc);
                    }
                }
                a = i;
            }
            if (this.amG != null) {
                a += zzapo.zzk(4, this.amG.booleanValue());
            }
            return this.amH != null ? a + zzapo.zzc(5, (zzapv) this.amH) : a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzb)) {
                return false;
            }
            zzb zzb = (zzb) obj;
            if (this.amD == null) {
                if (zzb.amD != null) {
                    return false;
                }
            } else if (!this.amD.equals(zzb.amD)) {
                return false;
            }
            if (this.amE == null) {
                if (zzb.amE != null) {
                    return false;
                }
            } else if (!this.amE.equals(zzb.amE)) {
                return false;
            }
            if (!zzapt.equals((Object[]) this.amF, (Object[]) zzb.amF)) {
                return false;
            }
            if (this.amG == null) {
                if (zzb.amG != null) {
                    return false;
                }
            } else if (!this.amG.equals(zzb.amG)) {
                return false;
            }
            return this.amH == null ? zzb.amH == null : this.amH.equals(zzb.amH);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.amG == null ? 0 : this.amG.hashCode()) + (((((this.amE == null ? 0 : this.amE.hashCode()) + (((this.amD == null ? 0 : this.amD.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31) + zzapt.hashCode((Object[]) this.amF)) * 31)) * 31;
            if (this.amH != null) {
                i = this.amH.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzapo zzapo) {
            if (this.amD != null) {
                zzapo.zzae(1, this.amD.intValue());
            }
            if (this.amE != null) {
                zzapo.zzr(2, this.amE);
            }
            if (this.amF != null && this.amF.length > 0) {
                for (zzc zzc : this.amF) {
                    if (zzc != null) {
                        zzapo.zza(3, (zzapv) zzc);
                    }
                }
            }
            if (this.amG != null) {
                zzapo.zzj(4, this.amG.booleanValue());
            }
            if (this.amH != null) {
                zzapo.zza(5, (zzapv) this.amH);
            }
            super.zza(zzapo);
        }

        /* renamed from: zzad */
        public zzb zzb(zzapn zzapn) {
            while (true) {
                int ah = zzapn.mo7957ah();
                switch (ah) {
                    case 0:
                        break;
                    case 8:
                        this.amD = Integer.valueOf(zzapn.mo7961al());
                        continue;
                    case 18:
                        this.amE = zzapn.readString();
                        continue;
                    case 26:
                        int zzc = zzapy.zzc(zzapn, 26);
                        int length = this.amF == null ? 0 : this.amF.length;
                        zzc[] zzcArr = new zzc[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.amF, 0, zzcArr, 0, length);
                        }
                        while (length < zzcArr.length - 1) {
                            zzcArr[length] = new zzc();
                            zzapn.zza(zzcArr[length]);
                            zzapn.mo7957ah();
                            length++;
                        }
                        zzcArr[length] = new zzc();
                        zzapn.zza(zzcArr[length]);
                        this.amF = zzcArr;
                        continue;
                    case 32:
                        this.amG = Boolean.valueOf(zzapn.mo7963an());
                        continue;
                    case C0515k.AppCompatTheme_textAppearancePopupMenuHeader:
                        if (this.amH == null) {
                            this.amH = new zzd();
                        }
                        zzapn.zza(this.amH);
                        continue;
                    default:
                        if (!zzapy.zzb(zzapn, ah)) {
                            break;
                        } else {
                            continue;
                        }
                }
            }
            return this;
        }

        public zzb zzbvg() {
            this.amD = null;
            this.amE = null;
            this.amF = zzc.zzbvh();
            this.amG = null;
            this.amH = null;
            this.f5906b = -1;
            return this;
        }
    }

    public final class zzc extends zzapv {

        /* renamed from: a */
        private static volatile zzc[] f7012a;
        public zzf amJ;
        public zzd amK;
        public Boolean amL;
        public String amM;

        public zzc() {
            zzbvi();
        }

        public static zzc[] zzbvh() {
            if (f7012a == null) {
                synchronized (zzapt.bjF) {
                    if (f7012a == null) {
                        f7012a = new zzc[0];
                    }
                }
            }
            return f7012a;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int mo7714a() {
            int a = super.mo7714a();
            if (this.amJ != null) {
                a += zzapo.zzc(1, (zzapv) this.amJ);
            }
            if (this.amK != null) {
                a += zzapo.zzc(2, (zzapv) this.amK);
            }
            if (this.amL != null) {
                a += zzapo.zzk(3, this.amL.booleanValue());
            }
            return this.amM != null ? a + zzapo.zzs(4, this.amM) : a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzc)) {
                return false;
            }
            zzc zzc = (zzc) obj;
            if (this.amJ == null) {
                if (zzc.amJ != null) {
                    return false;
                }
            } else if (!this.amJ.equals(zzc.amJ)) {
                return false;
            }
            if (this.amK == null) {
                if (zzc.amK != null) {
                    return false;
                }
            } else if (!this.amK.equals(zzc.amK)) {
                return false;
            }
            if (this.amL == null) {
                if (zzc.amL != null) {
                    return false;
                }
            } else if (!this.amL.equals(zzc.amL)) {
                return false;
            }
            return this.amM == null ? zzc.amM == null : this.amM.equals(zzc.amM);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.amL == null ? 0 : this.amL.hashCode()) + (((this.amK == null ? 0 : this.amK.hashCode()) + (((this.amJ == null ? 0 : this.amJ.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31;
            if (this.amM != null) {
                i = this.amM.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzapo zzapo) {
            if (this.amJ != null) {
                zzapo.zza(1, (zzapv) this.amJ);
            }
            if (this.amK != null) {
                zzapo.zza(2, (zzapv) this.amK);
            }
            if (this.amL != null) {
                zzapo.zzj(3, this.amL.booleanValue());
            }
            if (this.amM != null) {
                zzapo.zzr(4, this.amM);
            }
            super.zza(zzapo);
        }

        /* renamed from: zzae */
        public zzc zzb(zzapn zzapn) {
            while (true) {
                int ah = zzapn.mo7957ah();
                switch (ah) {
                    case 0:
                        break;
                    case 10:
                        if (this.amJ == null) {
                            this.amJ = new zzf();
                        }
                        zzapn.zza(this.amJ);
                        continue;
                    case 18:
                        if (this.amK == null) {
                            this.amK = new zzd();
                        }
                        zzapn.zza(this.amK);
                        continue;
                    case 24:
                        this.amL = Boolean.valueOf(zzapn.mo7963an());
                        continue;
                    case C0515k.AppCompatTheme_actionModePasteDrawable:
                        this.amM = zzapn.readString();
                        continue;
                    default:
                        if (!zzapy.zzb(zzapn, ah)) {
                            break;
                        } else {
                            continue;
                        }
                }
            }
            return this;
        }

        public zzc zzbvi() {
            this.amJ = null;
            this.amK = null;
            this.amL = null;
            this.amM = null;
            this.f5906b = -1;
            return this;
        }
    }

    public final class zzd extends zzapv {
        public Integer amN;
        public Boolean amO;
        public String amP;
        public String amQ;
        public String amR;

        public zzd() {
            zzbvj();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int mo7714a() {
            int a = super.mo7714a();
            if (this.amN != null) {
                a += zzapo.zzag(1, this.amN.intValue());
            }
            if (this.amO != null) {
                a += zzapo.zzk(2, this.amO.booleanValue());
            }
            if (this.amP != null) {
                a += zzapo.zzs(3, this.amP);
            }
            if (this.amQ != null) {
                a += zzapo.zzs(4, this.amQ);
            }
            return this.amR != null ? a + zzapo.zzs(5, this.amR) : a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzd)) {
                return false;
            }
            zzd zzd = (zzd) obj;
            if (this.amN == null) {
                if (zzd.amN != null) {
                    return false;
                }
            } else if (!this.amN.equals(zzd.amN)) {
                return false;
            }
            if (this.amO == null) {
                if (zzd.amO != null) {
                    return false;
                }
            } else if (!this.amO.equals(zzd.amO)) {
                return false;
            }
            if (this.amP == null) {
                if (zzd.amP != null) {
                    return false;
                }
            } else if (!this.amP.equals(zzd.amP)) {
                return false;
            }
            if (this.amQ == null) {
                if (zzd.amQ != null) {
                    return false;
                }
            } else if (!this.amQ.equals(zzd.amQ)) {
                return false;
            }
            return this.amR == null ? zzd.amR == null : this.amR.equals(zzd.amR);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.amQ == null ? 0 : this.amQ.hashCode()) + (((this.amP == null ? 0 : this.amP.hashCode()) + (((this.amO == null ? 0 : this.amO.hashCode()) + (((this.amN == null ? 0 : this.amN.intValue()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31;
            if (this.amR != null) {
                i = this.amR.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzapo zzapo) {
            if (this.amN != null) {
                zzapo.zzae(1, this.amN.intValue());
            }
            if (this.amO != null) {
                zzapo.zzj(2, this.amO.booleanValue());
            }
            if (this.amP != null) {
                zzapo.zzr(3, this.amP);
            }
            if (this.amQ != null) {
                zzapo.zzr(4, this.amQ);
            }
            if (this.amR != null) {
                zzapo.zzr(5, this.amR);
            }
            super.zza(zzapo);
        }

        /* renamed from: zzaf */
        public zzd zzb(zzapn zzapn) {
            while (true) {
                int ah = zzapn.mo7957ah();
                switch (ah) {
                    case 0:
                        break;
                    case 8:
                        int al = zzapn.mo7961al();
                        switch (al) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                                this.amN = Integer.valueOf(al);
                                break;
                            default:
                                continue;
                        }
                    case 16:
                        this.amO = Boolean.valueOf(zzapn.mo7963an());
                        continue;
                    case 26:
                        this.amP = zzapn.readString();
                        continue;
                    case C0515k.AppCompatTheme_actionModePasteDrawable:
                        this.amQ = zzapn.readString();
                        continue;
                    case C0515k.AppCompatTheme_textAppearancePopupMenuHeader:
                        this.amR = zzapn.readString();
                        continue;
                    default:
                        if (!zzapy.zzb(zzapn, ah)) {
                            break;
                        } else {
                            continue;
                        }
                }
            }
            return this;
        }

        public zzd zzbvj() {
            this.amO = null;
            this.amP = null;
            this.amQ = null;
            this.amR = null;
            this.f5906b = -1;
            return this;
        }
    }

    public final class zze extends zzapv {

        /* renamed from: a */
        private static volatile zze[] f7013a;
        public Integer amD;
        public String amT;
        public zzc amU;

        public zze() {
            zzbvl();
        }

        public static zze[] zzbvk() {
            if (f7013a == null) {
                synchronized (zzapt.bjF) {
                    if (f7013a == null) {
                        f7013a = new zze[0];
                    }
                }
            }
            return f7013a;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int mo7714a() {
            int a = super.mo7714a();
            if (this.amD != null) {
                a += zzapo.zzag(1, this.amD.intValue());
            }
            if (this.amT != null) {
                a += zzapo.zzs(2, this.amT);
            }
            return this.amU != null ? a + zzapo.zzc(3, (zzapv) this.amU) : a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zze)) {
                return false;
            }
            zze zze = (zze) obj;
            if (this.amD == null) {
                if (zze.amD != null) {
                    return false;
                }
            } else if (!this.amD.equals(zze.amD)) {
                return false;
            }
            if (this.amT == null) {
                if (zze.amT != null) {
                    return false;
                }
            } else if (!this.amT.equals(zze.amT)) {
                return false;
            }
            return this.amU == null ? zze.amU == null : this.amU.equals(zze.amU);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.amT == null ? 0 : this.amT.hashCode()) + (((this.amD == null ? 0 : this.amD.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
            if (this.amU != null) {
                i = this.amU.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzapo zzapo) {
            if (this.amD != null) {
                zzapo.zzae(1, this.amD.intValue());
            }
            if (this.amT != null) {
                zzapo.zzr(2, this.amT);
            }
            if (this.amU != null) {
                zzapo.zza(3, (zzapv) this.amU);
            }
            super.zza(zzapo);
        }

        /* renamed from: zzag */
        public zze zzb(zzapn zzapn) {
            while (true) {
                int ah = zzapn.mo7957ah();
                switch (ah) {
                    case 0:
                        break;
                    case 8:
                        this.amD = Integer.valueOf(zzapn.mo7961al());
                        continue;
                    case 18:
                        this.amT = zzapn.readString();
                        continue;
                    case 26:
                        if (this.amU == null) {
                            this.amU = new zzc();
                        }
                        zzapn.zza(this.amU);
                        continue;
                    default:
                        if (!zzapy.zzb(zzapn, ah)) {
                            break;
                        } else {
                            continue;
                        }
                }
            }
            return this;
        }

        public zze zzbvl() {
            this.amD = null;
            this.amT = null;
            this.amU = null;
            this.f5906b = -1;
            return this;
        }
    }

    public final class zzf extends zzapv {
        public Integer amV;
        public String amW;
        public Boolean amX;
        public String[] amY;

        public zzf() {
            zzbvm();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int mo7714a() {
            int a = super.mo7714a();
            if (this.amV != null) {
                a += zzapo.zzag(1, this.amV.intValue());
            }
            if (this.amW != null) {
                a += zzapo.zzs(2, this.amW);
            }
            if (this.amX != null) {
                a += zzapo.zzk(3, this.amX.booleanValue());
            }
            if (this.amY == null || this.amY.length <= 0) {
                return a;
            }
            int i = 0;
            int i2 = 0;
            for (String str : this.amY) {
                if (str != null) {
                    i2++;
                    i += zzapo.zztx(str);
                }
            }
            return a + i + (i2 * 1);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzf)) {
                return false;
            }
            zzf zzf = (zzf) obj;
            if (this.amV == null) {
                if (zzf.amV != null) {
                    return false;
                }
            } else if (!this.amV.equals(zzf.amV)) {
                return false;
            }
            if (this.amW == null) {
                if (zzf.amW != null) {
                    return false;
                }
            } else if (!this.amW.equals(zzf.amW)) {
                return false;
            }
            if (this.amX == null) {
                if (zzf.amX != null) {
                    return false;
                }
            } else if (!this.amX.equals(zzf.amX)) {
                return false;
            }
            return zzapt.equals((Object[]) this.amY, (Object[]) zzf.amY);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.amW == null ? 0 : this.amW.hashCode()) + (((this.amV == null ? 0 : this.amV.intValue()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
            if (this.amX != null) {
                i = this.amX.hashCode();
            }
            return ((hashCode + i) * 31) + zzapt.hashCode((Object[]) this.amY);
        }

        public void zza(zzapo zzapo) {
            if (this.amV != null) {
                zzapo.zzae(1, this.amV.intValue());
            }
            if (this.amW != null) {
                zzapo.zzr(2, this.amW);
            }
            if (this.amX != null) {
                zzapo.zzj(3, this.amX.booleanValue());
            }
            if (this.amY != null && this.amY.length > 0) {
                for (String str : this.amY) {
                    if (str != null) {
                        zzapo.zzr(4, str);
                    }
                }
            }
            super.zza(zzapo);
        }

        /* renamed from: zzah */
        public zzf zzb(zzapn zzapn) {
            while (true) {
                int ah = zzapn.mo7957ah();
                switch (ah) {
                    case 0:
                        break;
                    case 8:
                        int al = zzapn.mo7961al();
                        switch (al) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                                this.amV = Integer.valueOf(al);
                                break;
                            default:
                                continue;
                        }
                    case 18:
                        this.amW = zzapn.readString();
                        continue;
                    case 24:
                        this.amX = Boolean.valueOf(zzapn.mo7963an());
                        continue;
                    case C0515k.AppCompatTheme_actionModePasteDrawable:
                        int zzc = zzapy.zzc(zzapn, 34);
                        int length = this.amY == null ? 0 : this.amY.length;
                        String[] strArr = new String[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.amY, 0, strArr, 0, length);
                        }
                        while (length < strArr.length - 1) {
                            strArr[length] = zzapn.readString();
                            zzapn.mo7957ah();
                            length++;
                        }
                        strArr[length] = zzapn.readString();
                        this.amY = strArr;
                        continue;
                    default:
                        if (!zzapy.zzb(zzapn, ah)) {
                            break;
                        } else {
                            continue;
                        }
                }
            }
            return this;
        }

        public zzf zzbvm() {
            this.amW = null;
            this.amX = null;
            this.amY = zzapy.bjM;
            this.f5906b = -1;
            return this;
        }
    }
}
