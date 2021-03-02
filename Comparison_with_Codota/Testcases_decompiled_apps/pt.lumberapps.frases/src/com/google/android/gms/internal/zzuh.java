package com.google.android.gms.internal;

import android.support.p009v4.app.NotificationCompat;
import android.support.p021v7.p023b.C0515k;

public interface zzuh {

    public final class zza extends zzapv {

        /* renamed from: a */
        private static volatile zza[] f7016a;
        public Integer amz;
        public zzf anj;
        public zzf ank;
        public Boolean anl;

        public zza() {
            zzbvt();
        }

        public static zza[] zzbvs() {
            if (f7016a == null) {
                synchronized (zzapt.bjF) {
                    if (f7016a == null) {
                        f7016a = new zza[0];
                    }
                }
            }
            return f7016a;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int mo7714a() {
            int a = super.mo7714a();
            if (this.amz != null) {
                a += zzapo.zzag(1, this.amz.intValue());
            }
            if (this.anj != null) {
                a += zzapo.zzc(2, (zzapv) this.anj);
            }
            if (this.ank != null) {
                a += zzapo.zzc(3, (zzapv) this.ank);
            }
            return this.anl != null ? a + zzapo.zzk(4, this.anl.booleanValue()) : a;
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
            if (this.anj == null) {
                if (zza.anj != null) {
                    return false;
                }
            } else if (!this.anj.equals(zza.anj)) {
                return false;
            }
            if (this.ank == null) {
                if (zza.ank != null) {
                    return false;
                }
            } else if (!this.ank.equals(zza.ank)) {
                return false;
            }
            return this.anl == null ? zza.anl == null : this.anl.equals(zza.anl);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.ank == null ? 0 : this.ank.hashCode()) + (((this.anj == null ? 0 : this.anj.hashCode()) + (((this.amz == null ? 0 : this.amz.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31;
            if (this.anl != null) {
                i = this.anl.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzapo zzapo) {
            if (this.amz != null) {
                zzapo.zzae(1, this.amz.intValue());
            }
            if (this.anj != null) {
                zzapo.zza(2, (zzapv) this.anj);
            }
            if (this.ank != null) {
                zzapo.zza(3, (zzapv) this.ank);
            }
            if (this.anl != null) {
                zzapo.zzj(4, this.anl.booleanValue());
            }
            super.zza(zzapo);
        }

        /* renamed from: zzal */
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
                        if (this.anj == null) {
                            this.anj = new zzf();
                        }
                        zzapn.zza(this.anj);
                        continue;
                    case 26:
                        if (this.ank == null) {
                            this.ank = new zzf();
                        }
                        zzapn.zza(this.ank);
                        continue;
                    case 32:
                        this.anl = Boolean.valueOf(zzapn.mo7963an());
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

        public zza zzbvt() {
            this.amz = null;
            this.anj = null;
            this.ank = null;
            this.anl = null;
            this.f5906b = -1;
            return this;
        }
    }

    public final class zzb extends zzapv {

        /* renamed from: a */
        private static volatile zzb[] f7017a;
        public zzc[] ann;
        public Long ano;
        public Long anp;
        public Integer count;
        public String name;

        public zzb() {
            zzbvv();
        }

        public static zzb[] zzbvu() {
            if (f7017a == null) {
                synchronized (zzapt.bjF) {
                    if (f7017a == null) {
                        f7017a = new zzb[0];
                    }
                }
            }
            return f7017a;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int mo7714a() {
            int a = super.mo7714a();
            if (this.ann != null && this.ann.length > 0) {
                for (zzc zzc : this.ann) {
                    if (zzc != null) {
                        a += zzapo.zzc(1, (zzapv) zzc);
                    }
                }
            }
            if (this.name != null) {
                a += zzapo.zzs(2, this.name);
            }
            if (this.ano != null) {
                a += zzapo.zze(3, this.ano.longValue());
            }
            if (this.anp != null) {
                a += zzapo.zze(4, this.anp.longValue());
            }
            return this.count != null ? a + zzapo.zzag(5, this.count.intValue()) : a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzb)) {
                return false;
            }
            zzb zzb = (zzb) obj;
            if (!zzapt.equals((Object[]) this.ann, (Object[]) zzb.ann)) {
                return false;
            }
            if (this.name == null) {
                if (zzb.name != null) {
                    return false;
                }
            } else if (!this.name.equals(zzb.name)) {
                return false;
            }
            if (this.ano == null) {
                if (zzb.ano != null) {
                    return false;
                }
            } else if (!this.ano.equals(zzb.ano)) {
                return false;
            }
            if (this.anp == null) {
                if (zzb.anp != null) {
                    return false;
                }
            } else if (!this.anp.equals(zzb.anp)) {
                return false;
            }
            return this.count == null ? zzb.count == null : this.count.equals(zzb.count);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.anp == null ? 0 : this.anp.hashCode()) + (((this.ano == null ? 0 : this.ano.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + zzapt.hashCode((Object[]) this.ann)) * 31)) * 31)) * 31)) * 31;
            if (this.count != null) {
                i = this.count.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzapo zzapo) {
            if (this.ann != null && this.ann.length > 0) {
                for (zzc zzc : this.ann) {
                    if (zzc != null) {
                        zzapo.zza(1, (zzapv) zzc);
                    }
                }
            }
            if (this.name != null) {
                zzapo.zzr(2, this.name);
            }
            if (this.ano != null) {
                zzapo.zzb(3, this.ano.longValue());
            }
            if (this.anp != null) {
                zzapo.zzb(4, this.anp.longValue());
            }
            if (this.count != null) {
                zzapo.zzae(5, this.count.intValue());
            }
            super.zza(zzapo);
        }

        /* renamed from: zzam */
        public zzb zzb(zzapn zzapn) {
            while (true) {
                int ah = zzapn.mo7957ah();
                switch (ah) {
                    case 0:
                        break;
                    case 10:
                        int zzc = zzapy.zzc(zzapn, 10);
                        int length = this.ann == null ? 0 : this.ann.length;
                        zzc[] zzcArr = new zzc[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.ann, 0, zzcArr, 0, length);
                        }
                        while (length < zzcArr.length - 1) {
                            zzcArr[length] = new zzc();
                            zzapn.zza(zzcArr[length]);
                            zzapn.mo7957ah();
                            length++;
                        }
                        zzcArr[length] = new zzc();
                        zzapn.zza(zzcArr[length]);
                        this.ann = zzcArr;
                        continue;
                    case 18:
                        this.name = zzapn.readString();
                        continue;
                    case 24:
                        this.ano = Long.valueOf(zzapn.mo7960ak());
                        continue;
                    case 32:
                        this.anp = Long.valueOf(zzapn.mo7960ak());
                        continue;
                    case C0515k.AppCompatTheme_textAppearanceLargePopupMenu:
                        this.count = Integer.valueOf(zzapn.mo7961al());
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

        public zzb zzbvv() {
            this.ann = zzc.zzbvw();
            this.name = null;
            this.ano = null;
            this.anp = null;
            this.count = null;
            this.f5906b = -1;
            return this;
        }
    }

    public final class zzc extends zzapv {

        /* renamed from: a */
        private static volatile zzc[] f7018a;
        public Float amv;
        public Double amw;
        public Long anr;
        public String name;

        /* renamed from: zD */
        public String f7019zD;

        public zzc() {
            zzbvx();
        }

        public static zzc[] zzbvw() {
            if (f7018a == null) {
                synchronized (zzapt.bjF) {
                    if (f7018a == null) {
                        f7018a = new zzc[0];
                    }
                }
            }
            return f7018a;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int mo7714a() {
            int a = super.mo7714a();
            if (this.name != null) {
                a += zzapo.zzs(1, this.name);
            }
            if (this.f7019zD != null) {
                a += zzapo.zzs(2, this.f7019zD);
            }
            if (this.anr != null) {
                a += zzapo.zze(3, this.anr.longValue());
            }
            if (this.amv != null) {
                a += zzapo.zzd(4, this.amv.floatValue());
            }
            return this.amw != null ? a + zzapo.zzb(5, this.amw.doubleValue()) : a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzc)) {
                return false;
            }
            zzc zzc = (zzc) obj;
            if (this.name == null) {
                if (zzc.name != null) {
                    return false;
                }
            } else if (!this.name.equals(zzc.name)) {
                return false;
            }
            if (this.f7019zD == null) {
                if (zzc.f7019zD != null) {
                    return false;
                }
            } else if (!this.f7019zD.equals(zzc.f7019zD)) {
                return false;
            }
            if (this.anr == null) {
                if (zzc.anr != null) {
                    return false;
                }
            } else if (!this.anr.equals(zzc.anr)) {
                return false;
            }
            if (this.amv == null) {
                if (zzc.amv != null) {
                    return false;
                }
            } else if (!this.amv.equals(zzc.amv)) {
                return false;
            }
            return this.amw == null ? zzc.amw == null : this.amw.equals(zzc.amw);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.amv == null ? 0 : this.amv.hashCode()) + (((this.anr == null ? 0 : this.anr.hashCode()) + (((this.f7019zD == null ? 0 : this.f7019zD.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31;
            if (this.amw != null) {
                i = this.amw.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzapo zzapo) {
            if (this.name != null) {
                zzapo.zzr(1, this.name);
            }
            if (this.f7019zD != null) {
                zzapo.zzr(2, this.f7019zD);
            }
            if (this.anr != null) {
                zzapo.zzb(3, this.anr.longValue());
            }
            if (this.amv != null) {
                zzapo.zzc(4, this.amv.floatValue());
            }
            if (this.amw != null) {
                zzapo.zza(5, this.amw.doubleValue());
            }
            super.zza(zzapo);
        }

        /* renamed from: zzan */
        public zzc zzb(zzapn zzapn) {
            while (true) {
                int ah = zzapn.mo7957ah();
                switch (ah) {
                    case 0:
                        break;
                    case 10:
                        this.name = zzapn.readString();
                        continue;
                    case 18:
                        this.f7019zD = zzapn.readString();
                        continue;
                    case 24:
                        this.anr = Long.valueOf(zzapn.mo7960ak());
                        continue;
                    case C0515k.AppCompatTheme_actionModeFindDrawable:
                        this.amv = Float.valueOf(zzapn.readFloat());
                        continue;
                    case C0515k.AppCompatTheme_textAppearanceSmallPopupMenu:
                        this.amw = Double.valueOf(zzapn.readDouble());
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

        public zzc zzbvx() {
            this.name = null;
            this.f7019zD = null;
            this.anr = null;
            this.amv = null;
            this.amw = null;
            this.f5906b = -1;
            return this;
        }
    }

    public final class zzd extends zzapv {
        public zze[] ans;

        public zzd() {
            zzbvy();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int mo7714a() {
            int a = super.mo7714a();
            if (this.ans != null && this.ans.length > 0) {
                for (zze zze : this.ans) {
                    if (zze != null) {
                        a += zzapo.zzc(1, (zzapv) zze);
                    }
                }
            }
            return a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzd)) {
                return false;
            }
            return zzapt.equals((Object[]) this.ans, (Object[]) ((zzd) obj).ans);
        }

        public int hashCode() {
            return ((getClass().getName().hashCode() + 527) * 31) + zzapt.hashCode((Object[]) this.ans);
        }

        public void zza(zzapo zzapo) {
            if (this.ans != null && this.ans.length > 0) {
                for (zze zze : this.ans) {
                    if (zze != null) {
                        zzapo.zza(1, (zzapv) zze);
                    }
                }
            }
            super.zza(zzapo);
        }

        /* renamed from: zzao */
        public zzd zzb(zzapn zzapn) {
            while (true) {
                int ah = zzapn.mo7957ah();
                switch (ah) {
                    case 0:
                        break;
                    case 10:
                        int zzc = zzapy.zzc(zzapn, 10);
                        int length = this.ans == null ? 0 : this.ans.length;
                        zze[] zzeArr = new zze[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.ans, 0, zzeArr, 0, length);
                        }
                        while (length < zzeArr.length - 1) {
                            zzeArr[length] = new zze();
                            zzapn.zza(zzeArr[length]);
                            zzapn.mo7957ah();
                            length++;
                        }
                        zzeArr[length] = new zze();
                        zzapn.zza(zzeArr[length]);
                        this.ans = zzeArr;
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

        public zzd zzbvy() {
            this.ans = zze.zzbvz();
            this.f5906b = -1;
            return this;
        }
    }

    public final class zze extends zzapv {

        /* renamed from: a */
        private static volatile zze[] f7020a;
        public String aav;
        public String aic;
        public String aid;
        public String aig;
        public String aik;
        public Long anA;
        public Long anB;
        public String anC;
        public String anD;
        public String anE;
        public Integer anF;
        public Long anG;
        public Long anH;
        public String anI;
        public Boolean anJ;
        public String anK;
        public Long anL;
        public Integer anM;
        public Boolean anN;
        public zza[] anO;
        public Integer anP;
        public Integer anQ;
        public Integer anR;
        public String anS;
        public Integer anu;
        public zzb[] anv;
        public zzg[] anw;
        public Long anx;
        public Long any;
        public Long anz;
        public String zzck;
        public String zzct;

        public zze() {
            zzbwa();
        }

        public static zze[] zzbvz() {
            if (f7020a == null) {
                synchronized (zzapt.bjF) {
                    if (f7020a == null) {
                        f7020a = new zze[0];
                    }
                }
            }
            return f7020a;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int mo7714a() {
            int a = super.mo7714a();
            if (this.anu != null) {
                a += zzapo.zzag(1, this.anu.intValue());
            }
            if (this.anv != null && this.anv.length > 0) {
                int i = a;
                for (zzb zzb : this.anv) {
                    if (zzb != null) {
                        i += zzapo.zzc(2, (zzapv) zzb);
                    }
                }
                a = i;
            }
            if (this.anw != null && this.anw.length > 0) {
                int i2 = a;
                for (zzg zzg : this.anw) {
                    if (zzg != null) {
                        i2 += zzapo.zzc(3, (zzapv) zzg);
                    }
                }
                a = i2;
            }
            if (this.anx != null) {
                a += zzapo.zze(4, this.anx.longValue());
            }
            if (this.any != null) {
                a += zzapo.zze(5, this.any.longValue());
            }
            if (this.anz != null) {
                a += zzapo.zze(6, this.anz.longValue());
            }
            if (this.anB != null) {
                a += zzapo.zze(7, this.anB.longValue());
            }
            if (this.anC != null) {
                a += zzapo.zzs(8, this.anC);
            }
            if (this.zzct != null) {
                a += zzapo.zzs(9, this.zzct);
            }
            if (this.anD != null) {
                a += zzapo.zzs(10, this.anD);
            }
            if (this.anE != null) {
                a += zzapo.zzs(11, this.anE);
            }
            if (this.anF != null) {
                a += zzapo.zzag(12, this.anF.intValue());
            }
            if (this.aid != null) {
                a += zzapo.zzs(13, this.aid);
            }
            if (this.zzck != null) {
                a += zzapo.zzs(14, this.zzck);
            }
            if (this.aav != null) {
                a += zzapo.zzs(16, this.aav);
            }
            if (this.anG != null) {
                a += zzapo.zze(17, this.anG.longValue());
            }
            if (this.anH != null) {
                a += zzapo.zze(18, this.anH.longValue());
            }
            if (this.anI != null) {
                a += zzapo.zzs(19, this.anI);
            }
            if (this.anJ != null) {
                a += zzapo.zzk(20, this.anJ.booleanValue());
            }
            if (this.anK != null) {
                a += zzapo.zzs(21, this.anK);
            }
            if (this.anL != null) {
                a += zzapo.zze(22, this.anL.longValue());
            }
            if (this.anM != null) {
                a += zzapo.zzag(23, this.anM.intValue());
            }
            if (this.aig != null) {
                a += zzapo.zzs(24, this.aig);
            }
            if (this.aic != null) {
                a += zzapo.zzs(25, this.aic);
            }
            if (this.anA != null) {
                a += zzapo.zze(26, this.anA.longValue());
            }
            if (this.anN != null) {
                a += zzapo.zzk(28, this.anN.booleanValue());
            }
            if (this.anO != null && this.anO.length > 0) {
                for (zza zza : this.anO) {
                    if (zza != null) {
                        a += zzapo.zzc(29, (zzapv) zza);
                    }
                }
            }
            if (this.aik != null) {
                a += zzapo.zzs(30, this.aik);
            }
            if (this.anP != null) {
                a += zzapo.zzag(31, this.anP.intValue());
            }
            if (this.anQ != null) {
                a += zzapo.zzag(32, this.anQ.intValue());
            }
            if (this.anR != null) {
                a += zzapo.zzag(33, this.anR.intValue());
            }
            return this.anS != null ? a + zzapo.zzs(34, this.anS) : a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zze)) {
                return false;
            }
            zze zze = (zze) obj;
            if (this.anu == null) {
                if (zze.anu != null) {
                    return false;
                }
            } else if (!this.anu.equals(zze.anu)) {
                return false;
            }
            if (!zzapt.equals((Object[]) this.anv, (Object[]) zze.anv)) {
                return false;
            }
            if (!zzapt.equals((Object[]) this.anw, (Object[]) zze.anw)) {
                return false;
            }
            if (this.anx == null) {
                if (zze.anx != null) {
                    return false;
                }
            } else if (!this.anx.equals(zze.anx)) {
                return false;
            }
            if (this.any == null) {
                if (zze.any != null) {
                    return false;
                }
            } else if (!this.any.equals(zze.any)) {
                return false;
            }
            if (this.anz == null) {
                if (zze.anz != null) {
                    return false;
                }
            } else if (!this.anz.equals(zze.anz)) {
                return false;
            }
            if (this.anA == null) {
                if (zze.anA != null) {
                    return false;
                }
            } else if (!this.anA.equals(zze.anA)) {
                return false;
            }
            if (this.anB == null) {
                if (zze.anB != null) {
                    return false;
                }
            } else if (!this.anB.equals(zze.anB)) {
                return false;
            }
            if (this.anC == null) {
                if (zze.anC != null) {
                    return false;
                }
            } else if (!this.anC.equals(zze.anC)) {
                return false;
            }
            if (this.zzct == null) {
                if (zze.zzct != null) {
                    return false;
                }
            } else if (!this.zzct.equals(zze.zzct)) {
                return false;
            }
            if (this.anD == null) {
                if (zze.anD != null) {
                    return false;
                }
            } else if (!this.anD.equals(zze.anD)) {
                return false;
            }
            if (this.anE == null) {
                if (zze.anE != null) {
                    return false;
                }
            } else if (!this.anE.equals(zze.anE)) {
                return false;
            }
            if (this.anF == null) {
                if (zze.anF != null) {
                    return false;
                }
            } else if (!this.anF.equals(zze.anF)) {
                return false;
            }
            if (this.aid == null) {
                if (zze.aid != null) {
                    return false;
                }
            } else if (!this.aid.equals(zze.aid)) {
                return false;
            }
            if (this.zzck == null) {
                if (zze.zzck != null) {
                    return false;
                }
            } else if (!this.zzck.equals(zze.zzck)) {
                return false;
            }
            if (this.aav == null) {
                if (zze.aav != null) {
                    return false;
                }
            } else if (!this.aav.equals(zze.aav)) {
                return false;
            }
            if (this.anG == null) {
                if (zze.anG != null) {
                    return false;
                }
            } else if (!this.anG.equals(zze.anG)) {
                return false;
            }
            if (this.anH == null) {
                if (zze.anH != null) {
                    return false;
                }
            } else if (!this.anH.equals(zze.anH)) {
                return false;
            }
            if (this.anI == null) {
                if (zze.anI != null) {
                    return false;
                }
            } else if (!this.anI.equals(zze.anI)) {
                return false;
            }
            if (this.anJ == null) {
                if (zze.anJ != null) {
                    return false;
                }
            } else if (!this.anJ.equals(zze.anJ)) {
                return false;
            }
            if (this.anK == null) {
                if (zze.anK != null) {
                    return false;
                }
            } else if (!this.anK.equals(zze.anK)) {
                return false;
            }
            if (this.anL == null) {
                if (zze.anL != null) {
                    return false;
                }
            } else if (!this.anL.equals(zze.anL)) {
                return false;
            }
            if (this.anM == null) {
                if (zze.anM != null) {
                    return false;
                }
            } else if (!this.anM.equals(zze.anM)) {
                return false;
            }
            if (this.aig == null) {
                if (zze.aig != null) {
                    return false;
                }
            } else if (!this.aig.equals(zze.aig)) {
                return false;
            }
            if (this.aic == null) {
                if (zze.aic != null) {
                    return false;
                }
            } else if (!this.aic.equals(zze.aic)) {
                return false;
            }
            if (this.anN == null) {
                if (zze.anN != null) {
                    return false;
                }
            } else if (!this.anN.equals(zze.anN)) {
                return false;
            }
            if (!zzapt.equals((Object[]) this.anO, (Object[]) zze.anO)) {
                return false;
            }
            if (this.aik == null) {
                if (zze.aik != null) {
                    return false;
                }
            } else if (!this.aik.equals(zze.aik)) {
                return false;
            }
            if (this.anP == null) {
                if (zze.anP != null) {
                    return false;
                }
            } else if (!this.anP.equals(zze.anP)) {
                return false;
            }
            if (this.anQ == null) {
                if (zze.anQ != null) {
                    return false;
                }
            } else if (!this.anQ.equals(zze.anQ)) {
                return false;
            }
            if (this.anR == null) {
                if (zze.anR != null) {
                    return false;
                }
            } else if (!this.anR.equals(zze.anR)) {
                return false;
            }
            return this.anS == null ? zze.anS == null : this.anS.equals(zze.anS);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.anR == null ? 0 : this.anR.hashCode()) + (((this.anQ == null ? 0 : this.anQ.hashCode()) + (((this.anP == null ? 0 : this.anP.hashCode()) + (((this.aik == null ? 0 : this.aik.hashCode()) + (((((this.anN == null ? 0 : this.anN.hashCode()) + (((this.aic == null ? 0 : this.aic.hashCode()) + (((this.aig == null ? 0 : this.aig.hashCode()) + (((this.anM == null ? 0 : this.anM.hashCode()) + (((this.anL == null ? 0 : this.anL.hashCode()) + (((this.anK == null ? 0 : this.anK.hashCode()) + (((this.anJ == null ? 0 : this.anJ.hashCode()) + (((this.anI == null ? 0 : this.anI.hashCode()) + (((this.anH == null ? 0 : this.anH.hashCode()) + (((this.anG == null ? 0 : this.anG.hashCode()) + (((this.aav == null ? 0 : this.aav.hashCode()) + (((this.zzck == null ? 0 : this.zzck.hashCode()) + (((this.aid == null ? 0 : this.aid.hashCode()) + (((this.anF == null ? 0 : this.anF.hashCode()) + (((this.anE == null ? 0 : this.anE.hashCode()) + (((this.anD == null ? 0 : this.anD.hashCode()) + (((this.zzct == null ? 0 : this.zzct.hashCode()) + (((this.anC == null ? 0 : this.anC.hashCode()) + (((this.anB == null ? 0 : this.anB.hashCode()) + (((this.anA == null ? 0 : this.anA.hashCode()) + (((this.anz == null ? 0 : this.anz.hashCode()) + (((this.any == null ? 0 : this.any.hashCode()) + (((this.anx == null ? 0 : this.anx.hashCode()) + (((((((this.anu == null ? 0 : this.anu.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + zzapt.hashCode((Object[]) this.anv)) * 31) + zzapt.hashCode((Object[]) this.anw)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31) + zzapt.hashCode((Object[]) this.anO)) * 31)) * 31)) * 31)) * 31)) * 31;
            if (this.anS != null) {
                i = this.anS.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzapo zzapo) {
            if (this.anu != null) {
                zzapo.zzae(1, this.anu.intValue());
            }
            if (this.anv != null && this.anv.length > 0) {
                for (zzb zzb : this.anv) {
                    if (zzb != null) {
                        zzapo.zza(2, (zzapv) zzb);
                    }
                }
            }
            if (this.anw != null && this.anw.length > 0) {
                for (zzg zzg : this.anw) {
                    if (zzg != null) {
                        zzapo.zza(3, (zzapv) zzg);
                    }
                }
            }
            if (this.anx != null) {
                zzapo.zzb(4, this.anx.longValue());
            }
            if (this.any != null) {
                zzapo.zzb(5, this.any.longValue());
            }
            if (this.anz != null) {
                zzapo.zzb(6, this.anz.longValue());
            }
            if (this.anB != null) {
                zzapo.zzb(7, this.anB.longValue());
            }
            if (this.anC != null) {
                zzapo.zzr(8, this.anC);
            }
            if (this.zzct != null) {
                zzapo.zzr(9, this.zzct);
            }
            if (this.anD != null) {
                zzapo.zzr(10, this.anD);
            }
            if (this.anE != null) {
                zzapo.zzr(11, this.anE);
            }
            if (this.anF != null) {
                zzapo.zzae(12, this.anF.intValue());
            }
            if (this.aid != null) {
                zzapo.zzr(13, this.aid);
            }
            if (this.zzck != null) {
                zzapo.zzr(14, this.zzck);
            }
            if (this.aav != null) {
                zzapo.zzr(16, this.aav);
            }
            if (this.anG != null) {
                zzapo.zzb(17, this.anG.longValue());
            }
            if (this.anH != null) {
                zzapo.zzb(18, this.anH.longValue());
            }
            if (this.anI != null) {
                zzapo.zzr(19, this.anI);
            }
            if (this.anJ != null) {
                zzapo.zzj(20, this.anJ.booleanValue());
            }
            if (this.anK != null) {
                zzapo.zzr(21, this.anK);
            }
            if (this.anL != null) {
                zzapo.zzb(22, this.anL.longValue());
            }
            if (this.anM != null) {
                zzapo.zzae(23, this.anM.intValue());
            }
            if (this.aig != null) {
                zzapo.zzr(24, this.aig);
            }
            if (this.aic != null) {
                zzapo.zzr(25, this.aic);
            }
            if (this.anA != null) {
                zzapo.zzb(26, this.anA.longValue());
            }
            if (this.anN != null) {
                zzapo.zzj(28, this.anN.booleanValue());
            }
            if (this.anO != null && this.anO.length > 0) {
                for (zza zza : this.anO) {
                    if (zza != null) {
                        zzapo.zza(29, (zzapv) zza);
                    }
                }
            }
            if (this.aik != null) {
                zzapo.zzr(30, this.aik);
            }
            if (this.anP != null) {
                zzapo.zzae(31, this.anP.intValue());
            }
            if (this.anQ != null) {
                zzapo.zzae(32, this.anQ.intValue());
            }
            if (this.anR != null) {
                zzapo.zzae(33, this.anR.intValue());
            }
            if (this.anS != null) {
                zzapo.zzr(34, this.anS);
            }
            super.zza(zzapo);
        }

        /* renamed from: zzap */
        public zze zzb(zzapn zzapn) {
            while (true) {
                int ah = zzapn.mo7957ah();
                switch (ah) {
                    case 0:
                        break;
                    case 8:
                        this.anu = Integer.valueOf(zzapn.mo7961al());
                        continue;
                    case 18:
                        int zzc = zzapy.zzc(zzapn, 18);
                        int length = this.anv == null ? 0 : this.anv.length;
                        zzb[] zzbArr = new zzb[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.anv, 0, zzbArr, 0, length);
                        }
                        while (length < zzbArr.length - 1) {
                            zzbArr[length] = new zzb();
                            zzapn.zza(zzbArr[length]);
                            zzapn.mo7957ah();
                            length++;
                        }
                        zzbArr[length] = new zzb();
                        zzapn.zza(zzbArr[length]);
                        this.anv = zzbArr;
                        continue;
                    case 26:
                        int zzc2 = zzapy.zzc(zzapn, 26);
                        int length2 = this.anw == null ? 0 : this.anw.length;
                        zzg[] zzgArr = new zzg[(zzc2 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.anw, 0, zzgArr, 0, length2);
                        }
                        while (length2 < zzgArr.length - 1) {
                            zzgArr[length2] = new zzg();
                            zzapn.zza(zzgArr[length2]);
                            zzapn.mo7957ah();
                            length2++;
                        }
                        zzgArr[length2] = new zzg();
                        zzapn.zza(zzgArr[length2]);
                        this.anw = zzgArr;
                        continue;
                    case 32:
                        this.anx = Long.valueOf(zzapn.mo7960ak());
                        continue;
                    case C0515k.AppCompatTheme_textAppearanceLargePopupMenu:
                        this.any = Long.valueOf(zzapn.mo7960ak());
                        continue;
                    case C0515k.AppCompatTheme_spinnerDropDownItemStyle:
                        this.anz = Long.valueOf(zzapn.mo7960ak());
                        continue;
                    case C0515k.AppCompatTheme_dividerVertical:
                        this.anB = Long.valueOf(zzapn.mo7960ak());
                        continue;
                    case C0515k.AppCompatTheme_textAppearanceSearchResultTitle:
                        this.anC = zzapn.readString();
                        continue;
                    case C0515k.AppCompatTheme_listPreferredItemPaddingRight:
                        this.zzct = zzapn.readString();
                        continue;
                    case C0515k.AppCompatTheme_listChoiceBackgroundIndicator:
                        this.anD = zzapn.readString();
                        continue;
                    case 90:
                        this.anE = zzapn.readString();
                        continue;
                    case C0515k.AppCompatTheme_alertDialogTheme:
                        this.anF = Integer.valueOf(zzapn.mo7961al());
                        continue;
                    case C0515k.AppCompatTheme_editTextStyle:
                        this.aid = zzapn.readString();
                        continue;
                    case C0515k.AppCompatTheme_listMenuViewStyle:
                        this.zzck = zzapn.readString();
                        continue;
                    case 130:
                        this.aav = zzapn.readString();
                        continue;
                    case 136:
                        this.anG = Long.valueOf(zzapn.mo7960ak());
                        continue;
                    case 144:
                        this.anH = Long.valueOf(zzapn.mo7960ak());
                        continue;
                    case 154:
                        this.anI = zzapn.readString();
                        continue;
                    case 160:
                        this.anJ = Boolean.valueOf(zzapn.mo7963an());
                        continue;
                    case 170:
                        this.anK = zzapn.readString();
                        continue;
                    case 176:
                        this.anL = Long.valueOf(zzapn.mo7960ak());
                        continue;
                    case 184:
                        this.anM = Integer.valueOf(zzapn.mo7961al());
                        continue;
                    case 194:
                        this.aig = zzapn.readString();
                        continue;
                    case 202:
                        this.aic = zzapn.readString();
                        continue;
                    case 208:
                        this.anA = Long.valueOf(zzapn.mo7960ak());
                        continue;
                    case 224:
                        this.anN = Boolean.valueOf(zzapn.mo7963an());
                        continue;
                    case 234:
                        int zzc3 = zzapy.zzc(zzapn, 234);
                        int length3 = this.anO == null ? 0 : this.anO.length;
                        zza[] zzaArr = new zza[(zzc3 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.anO, 0, zzaArr, 0, length3);
                        }
                        while (length3 < zzaArr.length - 1) {
                            zzaArr[length3] = new zza();
                            zzapn.zza(zzaArr[length3]);
                            zzapn.mo7957ah();
                            length3++;
                        }
                        zzaArr[length3] = new zza();
                        zzapn.zza(zzaArr[length3]);
                        this.anO = zzaArr;
                        continue;
                    case 242:
                        this.aik = zzapn.readString();
                        continue;
                    case 248:
                        this.anP = Integer.valueOf(zzapn.mo7961al());
                        continue;
                    case NotificationCompat.FLAG_LOCAL_ONLY:
                        this.anQ = Integer.valueOf(zzapn.mo7961al());
                        continue;
                    case 264:
                        this.anR = Integer.valueOf(zzapn.mo7961al());
                        continue;
                    case 274:
                        this.anS = zzapn.readString();
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

        public zze zzbwa() {
            this.anu = null;
            this.anv = zzb.zzbvu();
            this.anw = zzg.zzbwc();
            this.anx = null;
            this.any = null;
            this.anz = null;
            this.anA = null;
            this.anB = null;
            this.anC = null;
            this.zzct = null;
            this.anD = null;
            this.anE = null;
            this.anF = null;
            this.aid = null;
            this.zzck = null;
            this.aav = null;
            this.anG = null;
            this.anH = null;
            this.anI = null;
            this.anJ = null;
            this.anK = null;
            this.anL = null;
            this.anM = null;
            this.aig = null;
            this.aic = null;
            this.anN = null;
            this.anO = zza.zzbvs();
            this.aik = null;
            this.anP = null;
            this.anQ = null;
            this.anR = null;
            this.anS = null;
            this.f5906b = -1;
            return this;
        }
    }

    public final class zzf extends zzapv {
        public long[] anT;
        public long[] anU;

        public zzf() {
            zzbwb();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int mo7714a() {
            int i;
            int a = super.mo7714a();
            if (this.anT == null || this.anT.length <= 0) {
                i = a;
            } else {
                int i2 = 0;
                for (long zzcx : this.anT) {
                    i2 += zzapo.zzcx(zzcx);
                }
                i = a + i2 + (this.anT.length * 1);
            }
            if (this.anU == null || this.anU.length <= 0) {
                return i;
            }
            int i3 = 0;
            for (long zzcx2 : this.anU) {
                i3 += zzapo.zzcx(zzcx2);
            }
            return i + i3 + (this.anU.length * 1);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzf)) {
                return false;
            }
            zzf zzf = (zzf) obj;
            if (!zzapt.equals(this.anT, zzf.anT)) {
                return false;
            }
            return zzapt.equals(this.anU, zzf.anU);
        }

        public int hashCode() {
            return ((((getClass().getName().hashCode() + 527) * 31) + zzapt.hashCode(this.anT)) * 31) + zzapt.hashCode(this.anU);
        }

        public void zza(zzapo zzapo) {
            if (this.anT != null && this.anT.length > 0) {
                for (long zza : this.anT) {
                    zzapo.zza(1, zza);
                }
            }
            if (this.anU != null && this.anU.length > 0) {
                for (long zza2 : this.anU) {
                    zzapo.zza(2, zza2);
                }
            }
            super.zza(zzapo);
        }

        /* renamed from: zzaq */
        public zzf zzb(zzapn zzapn) {
            while (true) {
                int ah = zzapn.mo7957ah();
                switch (ah) {
                    case 0:
                        break;
                    case 8:
                        int zzc = zzapy.zzc(zzapn, 8);
                        int length = this.anT == null ? 0 : this.anT.length;
                        long[] jArr = new long[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.anT, 0, jArr, 0, length);
                        }
                        while (length < jArr.length - 1) {
                            jArr[length] = zzapn.mo7959aj();
                            zzapn.mo7957ah();
                            length++;
                        }
                        jArr[length] = zzapn.mo7959aj();
                        this.anT = jArr;
                        continue;
                    case 10:
                        int zzafr = zzapn.zzafr(zzapn.mo7966aq());
                        int position = zzapn.getPosition();
                        int i = 0;
                        while (zzapn.mo7970av() > 0) {
                            zzapn.mo7959aj();
                            i++;
                        }
                        zzapn.zzaft(position);
                        int length2 = this.anT == null ? 0 : this.anT.length;
                        long[] jArr2 = new long[(i + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.anT, 0, jArr2, 0, length2);
                        }
                        while (length2 < jArr2.length) {
                            jArr2[length2] = zzapn.mo7959aj();
                            length2++;
                        }
                        this.anT = jArr2;
                        zzapn.zzafs(zzafr);
                        continue;
                    case 16:
                        int zzc2 = zzapy.zzc(zzapn, 16);
                        int length3 = this.anU == null ? 0 : this.anU.length;
                        long[] jArr3 = new long[(zzc2 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.anU, 0, jArr3, 0, length3);
                        }
                        while (length3 < jArr3.length - 1) {
                            jArr3[length3] = zzapn.mo7959aj();
                            zzapn.mo7957ah();
                            length3++;
                        }
                        jArr3[length3] = zzapn.mo7959aj();
                        this.anU = jArr3;
                        continue;
                    case 18:
                        int zzafr2 = zzapn.zzafr(zzapn.mo7966aq());
                        int position2 = zzapn.getPosition();
                        int i2 = 0;
                        while (zzapn.mo7970av() > 0) {
                            zzapn.mo7959aj();
                            i2++;
                        }
                        zzapn.zzaft(position2);
                        int length4 = this.anU == null ? 0 : this.anU.length;
                        long[] jArr4 = new long[(i2 + length4)];
                        if (length4 != 0) {
                            System.arraycopy(this.anU, 0, jArr4, 0, length4);
                        }
                        while (length4 < jArr4.length) {
                            jArr4[length4] = zzapn.mo7959aj();
                            length4++;
                        }
                        this.anU = jArr4;
                        zzapn.zzafs(zzafr2);
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

        public zzf zzbwb() {
            this.anT = zzapy.bjI;
            this.anU = zzapy.bjI;
            this.f5906b = -1;
            return this;
        }
    }

    public final class zzg extends zzapv {

        /* renamed from: a */
        private static volatile zzg[] f7021a;
        public Float amv;
        public Double amw;
        public Long anW;
        public Long anr;
        public String name;

        /* renamed from: zD */
        public String f7022zD;

        public zzg() {
            zzbwd();
        }

        public static zzg[] zzbwc() {
            if (f7021a == null) {
                synchronized (zzapt.bjF) {
                    if (f7021a == null) {
                        f7021a = new zzg[0];
                    }
                }
            }
            return f7021a;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int mo7714a() {
            int a = super.mo7714a();
            if (this.anW != null) {
                a += zzapo.zze(1, this.anW.longValue());
            }
            if (this.name != null) {
                a += zzapo.zzs(2, this.name);
            }
            if (this.f7022zD != null) {
                a += zzapo.zzs(3, this.f7022zD);
            }
            if (this.anr != null) {
                a += zzapo.zze(4, this.anr.longValue());
            }
            if (this.amv != null) {
                a += zzapo.zzd(5, this.amv.floatValue());
            }
            return this.amw != null ? a + zzapo.zzb(6, this.amw.doubleValue()) : a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzg)) {
                return false;
            }
            zzg zzg = (zzg) obj;
            if (this.anW == null) {
                if (zzg.anW != null) {
                    return false;
                }
            } else if (!this.anW.equals(zzg.anW)) {
                return false;
            }
            if (this.name == null) {
                if (zzg.name != null) {
                    return false;
                }
            } else if (!this.name.equals(zzg.name)) {
                return false;
            }
            if (this.f7022zD == null) {
                if (zzg.f7022zD != null) {
                    return false;
                }
            } else if (!this.f7022zD.equals(zzg.f7022zD)) {
                return false;
            }
            if (this.anr == null) {
                if (zzg.anr != null) {
                    return false;
                }
            } else if (!this.anr.equals(zzg.anr)) {
                return false;
            }
            if (this.amv == null) {
                if (zzg.amv != null) {
                    return false;
                }
            } else if (!this.amv.equals(zzg.amv)) {
                return false;
            }
            return this.amw == null ? zzg.amw == null : this.amw.equals(zzg.amw);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.amv == null ? 0 : this.amv.hashCode()) + (((this.anr == null ? 0 : this.anr.hashCode()) + (((this.f7022zD == null ? 0 : this.f7022zD.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + (((this.anW == null ? 0 : this.anW.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
            if (this.amw != null) {
                i = this.amw.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzapo zzapo) {
            if (this.anW != null) {
                zzapo.zzb(1, this.anW.longValue());
            }
            if (this.name != null) {
                zzapo.zzr(2, this.name);
            }
            if (this.f7022zD != null) {
                zzapo.zzr(3, this.f7022zD);
            }
            if (this.anr != null) {
                zzapo.zzb(4, this.anr.longValue());
            }
            if (this.amv != null) {
                zzapo.zzc(5, this.amv.floatValue());
            }
            if (this.amw != null) {
                zzapo.zza(6, this.amw.doubleValue());
            }
            super.zza(zzapo);
        }

        /* renamed from: zzar */
        public zzg zzb(zzapn zzapn) {
            while (true) {
                int ah = zzapn.mo7957ah();
                switch (ah) {
                    case 0:
                        break;
                    case 8:
                        this.anW = Long.valueOf(zzapn.mo7960ak());
                        continue;
                    case 18:
                        this.name = zzapn.readString();
                        continue;
                    case 26:
                        this.f7022zD = zzapn.readString();
                        continue;
                    case 32:
                        this.anr = Long.valueOf(zzapn.mo7960ak());
                        continue;
                    case C0515k.AppCompatTheme_listDividerAlertDialog:
                        this.amv = Float.valueOf(zzapn.readFloat());
                        continue;
                    case C0515k.AppCompatTheme_homeAsUpIndicator:
                        this.amw = Double.valueOf(zzapn.readDouble());
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

        public zzg zzbwd() {
            this.anW = null;
            this.name = null;
            this.f7022zD = null;
            this.anr = null;
            this.amv = null;
            this.amw = null;
            this.f5906b = -1;
            return this;
        }
    }
}
