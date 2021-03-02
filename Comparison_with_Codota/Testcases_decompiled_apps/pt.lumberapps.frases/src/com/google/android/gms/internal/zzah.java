package com.google.android.gms.internal;

import android.support.p021v7.p023b.C0515k;
import com.google.android.gms.internal.zzai;

public interface zzah {

    public final class zza extends zzapp {
        public int level;
        public int zzun;
        public int zzuo;

        public zza() {
            zzaa();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int mo7714a() {
            int a = super.mo7714a();
            if (this.level != 1) {
                a += zzapo.zzag(1, this.level);
            }
            if (this.zzun != 0) {
                a += zzapo.zzag(2, this.zzun);
            }
            return this.zzuo != 0 ? a + zzapo.zzag(3, this.zzuo) : a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza = (zza) obj;
            if (this.level == zza.level && this.zzun == zza.zzun && this.zzuo == zza.zzuo) {
                return (this.f5895a == null || this.f5895a.isEmpty()) ? zza.f5895a == null || zza.f5895a.isEmpty() : this.f5895a.equals(zza.f5895a);
            }
            return false;
        }

        public int hashCode() {
            return ((this.f5895a == null || this.f5895a.isEmpty()) ? 0 : this.f5895a.hashCode()) + ((((((((getClass().getName().hashCode() + 527) * 31) + this.level) * 31) + this.zzun) * 31) + this.zzuo) * 31);
        }

        public void zza(zzapo zzapo) {
            if (this.level != 1) {
                zzapo.zzae(1, this.level);
            }
            if (this.zzun != 0) {
                zzapo.zzae(2, this.zzun);
            }
            if (this.zzuo != 0) {
                zzapo.zzae(3, this.zzuo);
            }
            super.zza(zzapo);
        }

        public zza zzaa() {
            this.level = 1;
            this.zzun = 0;
            this.zzuo = 0;
            this.f5895a = null;
            this.f5906b = -1;
            return this;
        }

        /* renamed from: zzj */
        public zza zzb(zzapn zzapn) {
            while (true) {
                int ah = zzapn.mo7957ah();
                switch (ah) {
                    case 0:
                        break;
                    case 8:
                        int al = zzapn.mo7961al();
                        switch (al) {
                            case 1:
                            case 2:
                            case 3:
                                this.level = al;
                                break;
                            default:
                                continue;
                        }
                    case 16:
                        this.zzun = zzapn.mo7961al();
                        continue;
                    case 24:
                        this.zzuo = zzapn.mo7961al();
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

    public final class zzb extends zzapp {

        /* renamed from: c */
        private static volatile zzb[] f5557c;
        public int name;
        public int[] zzuq;
        public int zzur;
        public boolean zzus;
        public boolean zzut;

        public zzb() {
            zzac();
        }

        public static zzb[] zzab() {
            if (f5557c == null) {
                synchronized (zzapt.bjF) {
                    if (f5557c == null) {
                        f5557c = new zzb[0];
                    }
                }
            }
            return f5557c;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int mo7714a() {
            int i;
            int i2 = 0;
            int a = super.mo7714a();
            if (this.zzut) {
                a += zzapo.zzk(1, this.zzut);
            }
            int zzag = zzapo.zzag(2, this.zzur) + a;
            if (this.zzuq == null || this.zzuq.length <= 0) {
                i = zzag;
            } else {
                for (int zzafx : this.zzuq) {
                    i2 += zzapo.zzafx(zzafx);
                }
                i = zzag + i2 + (this.zzuq.length * 1);
            }
            if (this.name != 0) {
                i += zzapo.zzag(4, this.name);
            }
            return this.zzus ? i + zzapo.zzk(6, this.zzus) : i;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzb)) {
                return false;
            }
            zzb zzb = (zzb) obj;
            if (zzapt.equals(this.zzuq, zzb.zzuq) && this.zzur == zzb.zzur && this.name == zzb.name && this.zzus == zzb.zzus && this.zzut == zzb.zzut) {
                return (this.f5895a == null || this.f5895a.isEmpty()) ? zzb.f5895a == null || zzb.f5895a.isEmpty() : this.f5895a.equals(zzb.f5895a);
            }
            return false;
        }

        public int hashCode() {
            int i = 1231;
            int hashCode = ((this.zzus ? 1231 : 1237) + ((((((((getClass().getName().hashCode() + 527) * 31) + zzapt.hashCode(this.zzuq)) * 31) + this.zzur) * 31) + this.name) * 31)) * 31;
            if (!this.zzut) {
                i = 1237;
            }
            return ((this.f5895a == null || this.f5895a.isEmpty()) ? 0 : this.f5895a.hashCode()) + ((hashCode + i) * 31);
        }

        public void zza(zzapo zzapo) {
            if (this.zzut) {
                zzapo.zzj(1, this.zzut);
            }
            zzapo.zzae(2, this.zzur);
            if (this.zzuq != null && this.zzuq.length > 0) {
                for (int zzae : this.zzuq) {
                    zzapo.zzae(3, zzae);
                }
            }
            if (this.name != 0) {
                zzapo.zzae(4, this.name);
            }
            if (this.zzus) {
                zzapo.zzj(6, this.zzus);
            }
            super.zza(zzapo);
        }

        public zzb zzac() {
            this.zzuq = zzapy.bjH;
            this.zzur = 0;
            this.name = 0;
            this.zzus = false;
            this.zzut = false;
            this.f5895a = null;
            this.f5906b = -1;
            return this;
        }

        /* renamed from: zzk */
        public zzb zzb(zzapn zzapn) {
            while (true) {
                int ah = zzapn.mo7957ah();
                switch (ah) {
                    case 0:
                        break;
                    case 8:
                        this.zzut = zzapn.mo7963an();
                        continue;
                    case 16:
                        this.zzur = zzapn.mo7961al();
                        continue;
                    case 24:
                        int zzc = zzapy.zzc(zzapn, 24);
                        int length = this.zzuq == null ? 0 : this.zzuq.length;
                        int[] iArr = new int[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzuq, 0, iArr, 0, length);
                        }
                        while (length < iArr.length - 1) {
                            iArr[length] = zzapn.mo7961al();
                            zzapn.mo7957ah();
                            length++;
                        }
                        iArr[length] = zzapn.mo7961al();
                        this.zzuq = iArr;
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
                        int length2 = this.zzuq == null ? 0 : this.zzuq.length;
                        int[] iArr2 = new int[(i + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.zzuq, 0, iArr2, 0, length2);
                        }
                        while (length2 < iArr2.length) {
                            iArr2[length2] = zzapn.mo7961al();
                            length2++;
                        }
                        this.zzuq = iArr2;
                        zzapn.zzafs(zzafr);
                        continue;
                    case 32:
                        this.name = zzapn.mo7961al();
                        continue;
                    case C0515k.AppCompatTheme_spinnerDropDownItemStyle:
                        this.zzus = zzapn.mo7963an();
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

    public final class zzc extends zzapp {

        /* renamed from: c */
        private static volatile zzc[] f5558c;
        public String zzcb;
        public long zzuv;
        public long zzuw;
        public boolean zzux;
        public long zzuy;

        public zzc() {
            zzae();
        }

        public static zzc[] zzad() {
            if (f5558c == null) {
                synchronized (zzapt.bjF) {
                    if (f5558c == null) {
                        f5558c = new zzc[0];
                    }
                }
            }
            return f5558c;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int mo7714a() {
            int a = super.mo7714a();
            if (!this.zzcb.equals("")) {
                a += zzapo.zzs(1, this.zzcb);
            }
            if (this.zzuv != 0) {
                a += zzapo.zze(2, this.zzuv);
            }
            if (this.zzuw != 2147483647L) {
                a += zzapo.zze(3, this.zzuw);
            }
            if (this.zzux) {
                a += zzapo.zzk(4, this.zzux);
            }
            return this.zzuy != 0 ? a + zzapo.zze(5, this.zzuy) : a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzc)) {
                return false;
            }
            zzc zzc = (zzc) obj;
            if (this.zzcb == null) {
                if (zzc.zzcb != null) {
                    return false;
                }
            } else if (!this.zzcb.equals(zzc.zzcb)) {
                return false;
            }
            if (this.zzuv == zzc.zzuv && this.zzuw == zzc.zzuw && this.zzux == zzc.zzux && this.zzuy == zzc.zzuy) {
                return (this.f5895a == null || this.f5895a.isEmpty()) ? zzc.f5895a == null || zzc.f5895a.isEmpty() : this.f5895a.equals(zzc.f5895a);
            }
            return false;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((((this.zzux ? 1231 : 1237) + (((((((this.zzcb == null ? 0 : this.zzcb.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + ((int) (this.zzuv ^ (this.zzuv >>> 32)))) * 31) + ((int) (this.zzuw ^ (this.zzuw >>> 32)))) * 31)) * 31) + ((int) (this.zzuy ^ (this.zzuy >>> 32)))) * 31;
            if (this.f5895a != null && !this.f5895a.isEmpty()) {
                i = this.f5895a.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzapo zzapo) {
            if (!this.zzcb.equals("")) {
                zzapo.zzr(1, this.zzcb);
            }
            if (this.zzuv != 0) {
                zzapo.zzb(2, this.zzuv);
            }
            if (this.zzuw != 2147483647L) {
                zzapo.zzb(3, this.zzuw);
            }
            if (this.zzux) {
                zzapo.zzj(4, this.zzux);
            }
            if (this.zzuy != 0) {
                zzapo.zzb(5, this.zzuy);
            }
            super.zza(zzapo);
        }

        public zzc zzae() {
            this.zzcb = "";
            this.zzuv = 0;
            this.zzuw = 2147483647L;
            this.zzux = false;
            this.zzuy = 0;
            this.f5895a = null;
            this.f5906b = -1;
            return this;
        }

        /* renamed from: zzl */
        public zzc zzb(zzapn zzapn) {
            while (true) {
                int ah = zzapn.mo7957ah();
                switch (ah) {
                    case 0:
                        break;
                    case 10:
                        this.zzcb = zzapn.readString();
                        continue;
                    case 16:
                        this.zzuv = zzapn.mo7960ak();
                        continue;
                    case 24:
                        this.zzuw = zzapn.mo7960ak();
                        continue;
                    case 32:
                        this.zzux = zzapn.mo7963an();
                        continue;
                    case C0515k.AppCompatTheme_textAppearanceLargePopupMenu:
                        this.zzuy = zzapn.mo7960ak();
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

    public final class zzd extends zzapp {
        public zzai.zza[] zzuz;
        public zzai.zza[] zzva;
        public zzc[] zzvb;

        public zzd() {
            zzaf();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int mo7714a() {
            int a = super.mo7714a();
            if (this.zzuz != null && this.zzuz.length > 0) {
                int i = a;
                for (zzai.zza zza : this.zzuz) {
                    if (zza != null) {
                        i += zzapo.zzc(1, (zzapv) zza);
                    }
                }
                a = i;
            }
            if (this.zzva != null && this.zzva.length > 0) {
                int i2 = a;
                for (zzai.zza zza2 : this.zzva) {
                    if (zza2 != null) {
                        i2 += zzapo.zzc(2, (zzapv) zza2);
                    }
                }
                a = i2;
            }
            if (this.zzvb != null && this.zzvb.length > 0) {
                for (zzc zzc : this.zzvb) {
                    if (zzc != null) {
                        a += zzapo.zzc(3, (zzapv) zzc);
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
            zzd zzd = (zzd) obj;
            if (!zzapt.equals((Object[]) this.zzuz, (Object[]) zzd.zzuz) || !zzapt.equals((Object[]) this.zzva, (Object[]) zzd.zzva) || !zzapt.equals((Object[]) this.zzvb, (Object[]) zzd.zzvb)) {
                return false;
            }
            return (this.f5895a == null || this.f5895a.isEmpty()) ? zzd.f5895a == null || zzd.f5895a.isEmpty() : this.f5895a.equals(zzd.f5895a);
        }

        public int hashCode() {
            return ((this.f5895a == null || this.f5895a.isEmpty()) ? 0 : this.f5895a.hashCode()) + ((((((((getClass().getName().hashCode() + 527) * 31) + zzapt.hashCode((Object[]) this.zzuz)) * 31) + zzapt.hashCode((Object[]) this.zzva)) * 31) + zzapt.hashCode((Object[]) this.zzvb)) * 31);
        }

        public void zza(zzapo zzapo) {
            if (this.zzuz != null && this.zzuz.length > 0) {
                for (zzai.zza zza : this.zzuz) {
                    if (zza != null) {
                        zzapo.zza(1, (zzapv) zza);
                    }
                }
            }
            if (this.zzva != null && this.zzva.length > 0) {
                for (zzai.zza zza2 : this.zzva) {
                    if (zza2 != null) {
                        zzapo.zza(2, (zzapv) zza2);
                    }
                }
            }
            if (this.zzvb != null && this.zzvb.length > 0) {
                for (zzc zzc : this.zzvb) {
                    if (zzc != null) {
                        zzapo.zza(3, (zzapv) zzc);
                    }
                }
            }
            super.zza(zzapo);
        }

        public zzd zzaf() {
            this.zzuz = zzai.zza.zzap();
            this.zzva = zzai.zza.zzap();
            this.zzvb = zzc.zzad();
            this.f5895a = null;
            this.f5906b = -1;
            return this;
        }

        /* renamed from: zzm */
        public zzd zzb(zzapn zzapn) {
            while (true) {
                int ah = zzapn.mo7957ah();
                switch (ah) {
                    case 0:
                        break;
                    case 10:
                        int zzc = zzapy.zzc(zzapn, 10);
                        int length = this.zzuz == null ? 0 : this.zzuz.length;
                        zzai.zza[] zzaArr = new zzai.zza[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzuz, 0, zzaArr, 0, length);
                        }
                        while (length < zzaArr.length - 1) {
                            zzaArr[length] = new zzai.zza();
                            zzapn.zza(zzaArr[length]);
                            zzapn.mo7957ah();
                            length++;
                        }
                        zzaArr[length] = new zzai.zza();
                        zzapn.zza(zzaArr[length]);
                        this.zzuz = zzaArr;
                        continue;
                    case 18:
                        int zzc2 = zzapy.zzc(zzapn, 18);
                        int length2 = this.zzva == null ? 0 : this.zzva.length;
                        zzai.zza[] zzaArr2 = new zzai.zza[(zzc2 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.zzva, 0, zzaArr2, 0, length2);
                        }
                        while (length2 < zzaArr2.length - 1) {
                            zzaArr2[length2] = new zzai.zza();
                            zzapn.zza(zzaArr2[length2]);
                            zzapn.mo7957ah();
                            length2++;
                        }
                        zzaArr2[length2] = new zzai.zza();
                        zzapn.zza(zzaArr2[length2]);
                        this.zzva = zzaArr2;
                        continue;
                    case 26:
                        int zzc3 = zzapy.zzc(zzapn, 26);
                        int length3 = this.zzvb == null ? 0 : this.zzvb.length;
                        zzc[] zzcArr = new zzc[(zzc3 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.zzvb, 0, zzcArr, 0, length3);
                        }
                        while (length3 < zzcArr.length - 1) {
                            zzcArr[length3] = new zzc();
                            zzapn.zza(zzcArr[length3]);
                            zzapn.mo7957ah();
                            length3++;
                        }
                        zzcArr[length3] = new zzc();
                        zzapn.zza(zzcArr[length3]);
                        this.zzvb = zzcArr;
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

    public final class zze extends zzapp {

        /* renamed from: c */
        private static volatile zze[] f5559c;
        public int key;
        public int value;

        public zze() {
            zzah();
        }

        public static zze[] zzag() {
            if (f5559c == null) {
                synchronized (zzapt.bjF) {
                    if (f5559c == null) {
                        f5559c = new zze[0];
                    }
                }
            }
            return f5559c;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int mo7714a() {
            return super.mo7714a() + zzapo.zzag(1, this.key) + zzapo.zzag(2, this.value);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zze)) {
                return false;
            }
            zze zze = (zze) obj;
            if (this.key == zze.key && this.value == zze.value) {
                return (this.f5895a == null || this.f5895a.isEmpty()) ? zze.f5895a == null || zze.f5895a.isEmpty() : this.f5895a.equals(zze.f5895a);
            }
            return false;
        }

        public int hashCode() {
            return ((this.f5895a == null || this.f5895a.isEmpty()) ? 0 : this.f5895a.hashCode()) + ((((((getClass().getName().hashCode() + 527) * 31) + this.key) * 31) + this.value) * 31);
        }

        public void zza(zzapo zzapo) {
            zzapo.zzae(1, this.key);
            zzapo.zzae(2, this.value);
            super.zza(zzapo);
        }

        public zze zzah() {
            this.key = 0;
            this.value = 0;
            this.f5895a = null;
            this.f5906b = -1;
            return this;
        }

        /* renamed from: zzn */
        public zze zzb(zzapn zzapn) {
            while (true) {
                int ah = zzapn.mo7957ah();
                switch (ah) {
                    case 0:
                        break;
                    case 8:
                        this.key = zzapn.mo7961al();
                        continue;
                    case 16:
                        this.value = zzapn.mo7961al();
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

    public final class zzf extends zzapp {
        public String version;
        public String[] zzvd;
        public String[] zzve;
        public zzai.zza[] zzvf;
        public zze[] zzvg;
        public zzb[] zzvh;
        public zzb[] zzvi;
        public zzb[] zzvj;
        public zzg[] zzvk;
        public String zzvl;
        public String zzvm;
        public String zzvn;
        public zza zzvo;
        public float zzvp;
        public boolean zzvq;
        public String[] zzvr;
        public int zzvs;

        public zzf() {
            zzai();
        }

        public static zzf zze(byte[] bArr) {
            return (zzf) zzapv.zza(new zzf(), bArr);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int mo7714a() {
            int i;
            int a = super.mo7714a();
            if (this.zzve == null || this.zzve.length <= 0) {
                i = a;
            } else {
                int i2 = 0;
                int i3 = 0;
                for (String str : this.zzve) {
                    if (str != null) {
                        i3++;
                        i2 += zzapo.zztx(str);
                    }
                }
                i = a + i2 + (i3 * 1);
            }
            if (this.zzvf != null && this.zzvf.length > 0) {
                int i4 = i;
                for (zzai.zza zza : this.zzvf) {
                    if (zza != null) {
                        i4 += zzapo.zzc(2, (zzapv) zza);
                    }
                }
                i = i4;
            }
            if (this.zzvg != null && this.zzvg.length > 0) {
                int i5 = i;
                for (zze zze : this.zzvg) {
                    if (zze != null) {
                        i5 += zzapo.zzc(3, (zzapv) zze);
                    }
                }
                i = i5;
            }
            if (this.zzvh != null && this.zzvh.length > 0) {
                int i6 = i;
                for (zzb zzb : this.zzvh) {
                    if (zzb != null) {
                        i6 += zzapo.zzc(4, (zzapv) zzb);
                    }
                }
                i = i6;
            }
            if (this.zzvi != null && this.zzvi.length > 0) {
                int i7 = i;
                for (zzb zzb2 : this.zzvi) {
                    if (zzb2 != null) {
                        i7 += zzapo.zzc(5, (zzapv) zzb2);
                    }
                }
                i = i7;
            }
            if (this.zzvj != null && this.zzvj.length > 0) {
                int i8 = i;
                for (zzb zzb3 : this.zzvj) {
                    if (zzb3 != null) {
                        i8 += zzapo.zzc(6, (zzapv) zzb3);
                    }
                }
                i = i8;
            }
            if (this.zzvk != null && this.zzvk.length > 0) {
                int i9 = i;
                for (zzg zzg : this.zzvk) {
                    if (zzg != null) {
                        i9 += zzapo.zzc(7, (zzapv) zzg);
                    }
                }
                i = i9;
            }
            if (!this.zzvl.equals("")) {
                i += zzapo.zzs(9, this.zzvl);
            }
            if (!this.zzvm.equals("")) {
                i += zzapo.zzs(10, this.zzvm);
            }
            if (!this.zzvn.equals("0")) {
                i += zzapo.zzs(12, this.zzvn);
            }
            if (!this.version.equals("")) {
                i += zzapo.zzs(13, this.version);
            }
            if (this.zzvo != null) {
                i += zzapo.zzc(14, (zzapv) this.zzvo);
            }
            if (Float.floatToIntBits(this.zzvp) != Float.floatToIntBits(0.0f)) {
                i += zzapo.zzd(15, this.zzvp);
            }
            if (this.zzvr != null && this.zzvr.length > 0) {
                int i10 = 0;
                int i11 = 0;
                for (String str2 : this.zzvr) {
                    if (str2 != null) {
                        i11++;
                        i10 += zzapo.zztx(str2);
                    }
                }
                i = i + i10 + (i11 * 2);
            }
            if (this.zzvs != 0) {
                i += zzapo.zzag(17, this.zzvs);
            }
            if (this.zzvq) {
                i += zzapo.zzk(18, this.zzvq);
            }
            if (this.zzvd == null || this.zzvd.length <= 0) {
                return i;
            }
            int i12 = 0;
            int i13 = 0;
            for (String str3 : this.zzvd) {
                if (str3 != null) {
                    i13++;
                    i12 += zzapo.zztx(str3);
                }
            }
            return i + i12 + (i13 * 2);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzf)) {
                return false;
            }
            zzf zzf = (zzf) obj;
            if (!zzapt.equals((Object[]) this.zzvd, (Object[]) zzf.zzvd) || !zzapt.equals((Object[]) this.zzve, (Object[]) zzf.zzve) || !zzapt.equals((Object[]) this.zzvf, (Object[]) zzf.zzvf) || !zzapt.equals((Object[]) this.zzvg, (Object[]) zzf.zzvg) || !zzapt.equals((Object[]) this.zzvh, (Object[]) zzf.zzvh) || !zzapt.equals((Object[]) this.zzvi, (Object[]) zzf.zzvi) || !zzapt.equals((Object[]) this.zzvj, (Object[]) zzf.zzvj) || !zzapt.equals((Object[]) this.zzvk, (Object[]) zzf.zzvk)) {
                return false;
            }
            if (this.zzvl == null) {
                if (zzf.zzvl != null) {
                    return false;
                }
            } else if (!this.zzvl.equals(zzf.zzvl)) {
                return false;
            }
            if (this.zzvm == null) {
                if (zzf.zzvm != null) {
                    return false;
                }
            } else if (!this.zzvm.equals(zzf.zzvm)) {
                return false;
            }
            if (this.zzvn == null) {
                if (zzf.zzvn != null) {
                    return false;
                }
            } else if (!this.zzvn.equals(zzf.zzvn)) {
                return false;
            }
            if (this.version == null) {
                if (zzf.version != null) {
                    return false;
                }
            } else if (!this.version.equals(zzf.version)) {
                return false;
            }
            if (this.zzvo == null) {
                if (zzf.zzvo != null) {
                    return false;
                }
            } else if (!this.zzvo.equals(zzf.zzvo)) {
                return false;
            }
            if (Float.floatToIntBits(this.zzvp) == Float.floatToIntBits(zzf.zzvp) && this.zzvq == zzf.zzvq && zzapt.equals((Object[]) this.zzvr, (Object[]) zzf.zzvr) && this.zzvs == zzf.zzvs) {
                return (this.f5895a == null || this.f5895a.isEmpty()) ? zzf.f5895a == null || zzf.f5895a.isEmpty() : this.f5895a.equals(zzf.f5895a);
            }
            return false;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((((((this.zzvq ? 1231 : 1237) + (((((this.zzvo == null ? 0 : this.zzvo.hashCode()) + (((this.version == null ? 0 : this.version.hashCode()) + (((this.zzvn == null ? 0 : this.zzvn.hashCode()) + (((this.zzvm == null ? 0 : this.zzvm.hashCode()) + (((this.zzvl == null ? 0 : this.zzvl.hashCode()) + ((((((((((((((((((getClass().getName().hashCode() + 527) * 31) + zzapt.hashCode((Object[]) this.zzvd)) * 31) + zzapt.hashCode((Object[]) this.zzve)) * 31) + zzapt.hashCode((Object[]) this.zzvf)) * 31) + zzapt.hashCode((Object[]) this.zzvg)) * 31) + zzapt.hashCode((Object[]) this.zzvh)) * 31) + zzapt.hashCode((Object[]) this.zzvi)) * 31) + zzapt.hashCode((Object[]) this.zzvj)) * 31) + zzapt.hashCode((Object[]) this.zzvk)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31) + Float.floatToIntBits(this.zzvp)) * 31)) * 31) + zzapt.hashCode((Object[]) this.zzvr)) * 31) + this.zzvs) * 31;
            if (this.f5895a != null && !this.f5895a.isEmpty()) {
                i = this.f5895a.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzapo zzapo) {
            if (this.zzve != null && this.zzve.length > 0) {
                for (String str : this.zzve) {
                    if (str != null) {
                        zzapo.zzr(1, str);
                    }
                }
            }
            if (this.zzvf != null && this.zzvf.length > 0) {
                for (zzai.zza zza : this.zzvf) {
                    if (zza != null) {
                        zzapo.zza(2, (zzapv) zza);
                    }
                }
            }
            if (this.zzvg != null && this.zzvg.length > 0) {
                for (zze zze : this.zzvg) {
                    if (zze != null) {
                        zzapo.zza(3, (zzapv) zze);
                    }
                }
            }
            if (this.zzvh != null && this.zzvh.length > 0) {
                for (zzb zzb : this.zzvh) {
                    if (zzb != null) {
                        zzapo.zza(4, (zzapv) zzb);
                    }
                }
            }
            if (this.zzvi != null && this.zzvi.length > 0) {
                for (zzb zzb2 : this.zzvi) {
                    if (zzb2 != null) {
                        zzapo.zza(5, (zzapv) zzb2);
                    }
                }
            }
            if (this.zzvj != null && this.zzvj.length > 0) {
                for (zzb zzb3 : this.zzvj) {
                    if (zzb3 != null) {
                        zzapo.zza(6, (zzapv) zzb3);
                    }
                }
            }
            if (this.zzvk != null && this.zzvk.length > 0) {
                for (zzg zzg : this.zzvk) {
                    if (zzg != null) {
                        zzapo.zza(7, (zzapv) zzg);
                    }
                }
            }
            if (!this.zzvl.equals("")) {
                zzapo.zzr(9, this.zzvl);
            }
            if (!this.zzvm.equals("")) {
                zzapo.zzr(10, this.zzvm);
            }
            if (!this.zzvn.equals("0")) {
                zzapo.zzr(12, this.zzvn);
            }
            if (!this.version.equals("")) {
                zzapo.zzr(13, this.version);
            }
            if (this.zzvo != null) {
                zzapo.zza(14, (zzapv) this.zzvo);
            }
            if (Float.floatToIntBits(this.zzvp) != Float.floatToIntBits(0.0f)) {
                zzapo.zzc(15, this.zzvp);
            }
            if (this.zzvr != null && this.zzvr.length > 0) {
                for (String str2 : this.zzvr) {
                    if (str2 != null) {
                        zzapo.zzr(16, str2);
                    }
                }
            }
            if (this.zzvs != 0) {
                zzapo.zzae(17, this.zzvs);
            }
            if (this.zzvq) {
                zzapo.zzj(18, this.zzvq);
            }
            if (this.zzvd != null && this.zzvd.length > 0) {
                for (String str3 : this.zzvd) {
                    if (str3 != null) {
                        zzapo.zzr(19, str3);
                    }
                }
            }
            super.zza(zzapo);
        }

        public zzf zzai() {
            this.zzvd = zzapy.bjM;
            this.zzve = zzapy.bjM;
            this.zzvf = zzai.zza.zzap();
            this.zzvg = zze.zzag();
            this.zzvh = zzb.zzab();
            this.zzvi = zzb.zzab();
            this.zzvj = zzb.zzab();
            this.zzvk = zzg.zzaj();
            this.zzvl = "";
            this.zzvm = "";
            this.zzvn = "0";
            this.version = "";
            this.zzvo = null;
            this.zzvp = 0.0f;
            this.zzvq = false;
            this.zzvr = zzapy.bjM;
            this.zzvs = 0;
            this.f5895a = null;
            this.f5906b = -1;
            return this;
        }

        /* renamed from: zzo */
        public zzf zzb(zzapn zzapn) {
            while (true) {
                int ah = zzapn.mo7957ah();
                switch (ah) {
                    case 0:
                        break;
                    case 10:
                        int zzc = zzapy.zzc(zzapn, 10);
                        int length = this.zzve == null ? 0 : this.zzve.length;
                        String[] strArr = new String[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzve, 0, strArr, 0, length);
                        }
                        while (length < strArr.length - 1) {
                            strArr[length] = zzapn.readString();
                            zzapn.mo7957ah();
                            length++;
                        }
                        strArr[length] = zzapn.readString();
                        this.zzve = strArr;
                        continue;
                    case 18:
                        int zzc2 = zzapy.zzc(zzapn, 18);
                        int length2 = this.zzvf == null ? 0 : this.zzvf.length;
                        zzai.zza[] zzaArr = new zzai.zza[(zzc2 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.zzvf, 0, zzaArr, 0, length2);
                        }
                        while (length2 < zzaArr.length - 1) {
                            zzaArr[length2] = new zzai.zza();
                            zzapn.zza(zzaArr[length2]);
                            zzapn.mo7957ah();
                            length2++;
                        }
                        zzaArr[length2] = new zzai.zza();
                        zzapn.zza(zzaArr[length2]);
                        this.zzvf = zzaArr;
                        continue;
                    case 26:
                        int zzc3 = zzapy.zzc(zzapn, 26);
                        int length3 = this.zzvg == null ? 0 : this.zzvg.length;
                        zze[] zzeArr = new zze[(zzc3 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.zzvg, 0, zzeArr, 0, length3);
                        }
                        while (length3 < zzeArr.length - 1) {
                            zzeArr[length3] = new zze();
                            zzapn.zza(zzeArr[length3]);
                            zzapn.mo7957ah();
                            length3++;
                        }
                        zzeArr[length3] = new zze();
                        zzapn.zza(zzeArr[length3]);
                        this.zzvg = zzeArr;
                        continue;
                    case C0515k.AppCompatTheme_actionModePasteDrawable:
                        int zzc4 = zzapy.zzc(zzapn, 34);
                        int length4 = this.zzvh == null ? 0 : this.zzvh.length;
                        zzb[] zzbArr = new zzb[(zzc4 + length4)];
                        if (length4 != 0) {
                            System.arraycopy(this.zzvh, 0, zzbArr, 0, length4);
                        }
                        while (length4 < zzbArr.length - 1) {
                            zzbArr[length4] = new zzb();
                            zzapn.zza(zzbArr[length4]);
                            zzapn.mo7957ah();
                            length4++;
                        }
                        zzbArr[length4] = new zzb();
                        zzapn.zza(zzbArr[length4]);
                        this.zzvh = zzbArr;
                        continue;
                    case C0515k.AppCompatTheme_textAppearancePopupMenuHeader:
                        int zzc5 = zzapy.zzc(zzapn, 42);
                        int length5 = this.zzvi == null ? 0 : this.zzvi.length;
                        zzb[] zzbArr2 = new zzb[(zzc5 + length5)];
                        if (length5 != 0) {
                            System.arraycopy(this.zzvi, 0, zzbArr2, 0, length5);
                        }
                        while (length5 < zzbArr2.length - 1) {
                            zzbArr2[length5] = new zzb();
                            zzapn.zza(zzbArr2[length5]);
                            zzapn.mo7957ah();
                            length5++;
                        }
                        zzbArr2[length5] = new zzb();
                        zzapn.zza(zzbArr2[length5]);
                        this.zzvi = zzbArr2;
                        continue;
                    case 50:
                        int zzc6 = zzapy.zzc(zzapn, 50);
                        int length6 = this.zzvj == null ? 0 : this.zzvj.length;
                        zzb[] zzbArr3 = new zzb[(zzc6 + length6)];
                        if (length6 != 0) {
                            System.arraycopy(this.zzvj, 0, zzbArr3, 0, length6);
                        }
                        while (length6 < zzbArr3.length - 1) {
                            zzbArr3[length6] = new zzb();
                            zzapn.zza(zzbArr3[length6]);
                            zzapn.mo7957ah();
                            length6++;
                        }
                        zzbArr3[length6] = new zzb();
                        zzapn.zza(zzbArr3[length6]);
                        this.zzvj = zzbArr3;
                        continue;
                    case C0515k.AppCompatTheme_activityChooserViewStyle:
                        int zzc7 = zzapy.zzc(zzapn, 58);
                        int length7 = this.zzvk == null ? 0 : this.zzvk.length;
                        zzg[] zzgArr = new zzg[(zzc7 + length7)];
                        if (length7 != 0) {
                            System.arraycopy(this.zzvk, 0, zzgArr, 0, length7);
                        }
                        while (length7 < zzgArr.length - 1) {
                            zzgArr[length7] = new zzg();
                            zzapn.zza(zzgArr[length7]);
                            zzapn.mo7957ah();
                            length7++;
                        }
                        zzgArr[length7] = new zzg();
                        zzapn.zza(zzgArr[length7]);
                        this.zzvk = zzgArr;
                        continue;
                    case C0515k.AppCompatTheme_listPreferredItemPaddingRight:
                        this.zzvl = zzapn.readString();
                        continue;
                    case C0515k.AppCompatTheme_listChoiceBackgroundIndicator:
                        this.zzvm = zzapn.readString();
                        continue;
                    case C0515k.AppCompatTheme_buttonBarPositiveButtonStyle:
                        this.zzvn = zzapn.readString();
                        continue;
                    case C0515k.AppCompatTheme_editTextStyle:
                        this.version = zzapn.readString();
                        continue;
                    case C0515k.AppCompatTheme_listMenuViewStyle:
                        if (this.zzvo == null) {
                            this.zzvo = new zza();
                        }
                        zzapn.zza(this.zzvo);
                        continue;
                    case 125:
                        this.zzvp = zzapn.readFloat();
                        continue;
                    case 130:
                        int zzc8 = zzapy.zzc(zzapn, 130);
                        int length8 = this.zzvr == null ? 0 : this.zzvr.length;
                        String[] strArr2 = new String[(zzc8 + length8)];
                        if (length8 != 0) {
                            System.arraycopy(this.zzvr, 0, strArr2, 0, length8);
                        }
                        while (length8 < strArr2.length - 1) {
                            strArr2[length8] = zzapn.readString();
                            zzapn.mo7957ah();
                            length8++;
                        }
                        strArr2[length8] = zzapn.readString();
                        this.zzvr = strArr2;
                        continue;
                    case 136:
                        this.zzvs = zzapn.mo7961al();
                        continue;
                    case 144:
                        this.zzvq = zzapn.mo7963an();
                        continue;
                    case 154:
                        int zzc9 = zzapy.zzc(zzapn, 154);
                        int length9 = this.zzvd == null ? 0 : this.zzvd.length;
                        String[] strArr3 = new String[(zzc9 + length9)];
                        if (length9 != 0) {
                            System.arraycopy(this.zzvd, 0, strArr3, 0, length9);
                        }
                        while (length9 < strArr3.length - 1) {
                            strArr3[length9] = zzapn.readString();
                            zzapn.mo7957ah();
                            length9++;
                        }
                        strArr3[length9] = zzapn.readString();
                        this.zzvd = strArr3;
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

    public final class zzg extends zzapp {

        /* renamed from: c */
        private static volatile zzg[] f5560c;
        public int[] zzvu;
        public int[] zzvv;
        public int[] zzvw;
        public int[] zzvx;
        public int[] zzvy;
        public int[] zzvz;
        public int[] zzwa;
        public int[] zzwb;
        public int[] zzwc;
        public int[] zzwd;

        public zzg() {
            zzak();
        }

        public static zzg[] zzaj() {
            if (f5560c == null) {
                synchronized (zzapt.bjF) {
                    if (f5560c == null) {
                        f5560c = new zzg[0];
                    }
                }
            }
            return f5560c;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int mo7714a() {
            int i;
            int a = super.mo7714a();
            if (this.zzvu == null || this.zzvu.length <= 0) {
                i = a;
            } else {
                int i2 = 0;
                for (int zzafx : this.zzvu) {
                    i2 += zzapo.zzafx(zzafx);
                }
                i = a + i2 + (this.zzvu.length * 1);
            }
            if (this.zzvv != null && this.zzvv.length > 0) {
                int i3 = 0;
                for (int zzafx2 : this.zzvv) {
                    i3 += zzapo.zzafx(zzafx2);
                }
                i = i + i3 + (this.zzvv.length * 1);
            }
            if (this.zzvw != null && this.zzvw.length > 0) {
                int i4 = 0;
                for (int zzafx3 : this.zzvw) {
                    i4 += zzapo.zzafx(zzafx3);
                }
                i = i + i4 + (this.zzvw.length * 1);
            }
            if (this.zzvx != null && this.zzvx.length > 0) {
                int i5 = 0;
                for (int zzafx4 : this.zzvx) {
                    i5 += zzapo.zzafx(zzafx4);
                }
                i = i + i5 + (this.zzvx.length * 1);
            }
            if (this.zzvy != null && this.zzvy.length > 0) {
                int i6 = 0;
                for (int zzafx5 : this.zzvy) {
                    i6 += zzapo.zzafx(zzafx5);
                }
                i = i + i6 + (this.zzvy.length * 1);
            }
            if (this.zzvz != null && this.zzvz.length > 0) {
                int i7 = 0;
                for (int zzafx6 : this.zzvz) {
                    i7 += zzapo.zzafx(zzafx6);
                }
                i = i + i7 + (this.zzvz.length * 1);
            }
            if (this.zzwa != null && this.zzwa.length > 0) {
                int i8 = 0;
                for (int zzafx7 : this.zzwa) {
                    i8 += zzapo.zzafx(zzafx7);
                }
                i = i + i8 + (this.zzwa.length * 1);
            }
            if (this.zzwb != null && this.zzwb.length > 0) {
                int i9 = 0;
                for (int zzafx8 : this.zzwb) {
                    i9 += zzapo.zzafx(zzafx8);
                }
                i = i + i9 + (this.zzwb.length * 1);
            }
            if (this.zzwc != null && this.zzwc.length > 0) {
                int i10 = 0;
                for (int zzafx9 : this.zzwc) {
                    i10 += zzapo.zzafx(zzafx9);
                }
                i = i + i10 + (this.zzwc.length * 1);
            }
            if (this.zzwd == null || this.zzwd.length <= 0) {
                return i;
            }
            int i11 = 0;
            for (int zzafx10 : this.zzwd) {
                i11 += zzapo.zzafx(zzafx10);
            }
            return i + i11 + (this.zzwd.length * 1);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzg)) {
                return false;
            }
            zzg zzg = (zzg) obj;
            if (!zzapt.equals(this.zzvu, zzg.zzvu) || !zzapt.equals(this.zzvv, zzg.zzvv) || !zzapt.equals(this.zzvw, zzg.zzvw) || !zzapt.equals(this.zzvx, zzg.zzvx) || !zzapt.equals(this.zzvy, zzg.zzvy) || !zzapt.equals(this.zzvz, zzg.zzvz) || !zzapt.equals(this.zzwa, zzg.zzwa) || !zzapt.equals(this.zzwb, zzg.zzwb) || !zzapt.equals(this.zzwc, zzg.zzwc) || !zzapt.equals(this.zzwd, zzg.zzwd)) {
                return false;
            }
            return (this.f5895a == null || this.f5895a.isEmpty()) ? zzg.f5895a == null || zzg.f5895a.isEmpty() : this.f5895a.equals(zzg.f5895a);
        }

        public int hashCode() {
            return ((this.f5895a == null || this.f5895a.isEmpty()) ? 0 : this.f5895a.hashCode()) + ((((((((((((((((((((((getClass().getName().hashCode() + 527) * 31) + zzapt.hashCode(this.zzvu)) * 31) + zzapt.hashCode(this.zzvv)) * 31) + zzapt.hashCode(this.zzvw)) * 31) + zzapt.hashCode(this.zzvx)) * 31) + zzapt.hashCode(this.zzvy)) * 31) + zzapt.hashCode(this.zzvz)) * 31) + zzapt.hashCode(this.zzwa)) * 31) + zzapt.hashCode(this.zzwb)) * 31) + zzapt.hashCode(this.zzwc)) * 31) + zzapt.hashCode(this.zzwd)) * 31);
        }

        public void zza(zzapo zzapo) {
            if (this.zzvu != null && this.zzvu.length > 0) {
                for (int zzae : this.zzvu) {
                    zzapo.zzae(1, zzae);
                }
            }
            if (this.zzvv != null && this.zzvv.length > 0) {
                for (int zzae2 : this.zzvv) {
                    zzapo.zzae(2, zzae2);
                }
            }
            if (this.zzvw != null && this.zzvw.length > 0) {
                for (int zzae3 : this.zzvw) {
                    zzapo.zzae(3, zzae3);
                }
            }
            if (this.zzvx != null && this.zzvx.length > 0) {
                for (int zzae4 : this.zzvx) {
                    zzapo.zzae(4, zzae4);
                }
            }
            if (this.zzvy != null && this.zzvy.length > 0) {
                for (int zzae5 : this.zzvy) {
                    zzapo.zzae(5, zzae5);
                }
            }
            if (this.zzvz != null && this.zzvz.length > 0) {
                for (int zzae6 : this.zzvz) {
                    zzapo.zzae(6, zzae6);
                }
            }
            if (this.zzwa != null && this.zzwa.length > 0) {
                for (int zzae7 : this.zzwa) {
                    zzapo.zzae(7, zzae7);
                }
            }
            if (this.zzwb != null && this.zzwb.length > 0) {
                for (int zzae8 : this.zzwb) {
                    zzapo.zzae(8, zzae8);
                }
            }
            if (this.zzwc != null && this.zzwc.length > 0) {
                for (int zzae9 : this.zzwc) {
                    zzapo.zzae(9, zzae9);
                }
            }
            if (this.zzwd != null && this.zzwd.length > 0) {
                for (int zzae10 : this.zzwd) {
                    zzapo.zzae(10, zzae10);
                }
            }
            super.zza(zzapo);
        }

        public zzg zzak() {
            this.zzvu = zzapy.bjH;
            this.zzvv = zzapy.bjH;
            this.zzvw = zzapy.bjH;
            this.zzvx = zzapy.bjH;
            this.zzvy = zzapy.bjH;
            this.zzvz = zzapy.bjH;
            this.zzwa = zzapy.bjH;
            this.zzwb = zzapy.bjH;
            this.zzwc = zzapy.bjH;
            this.zzwd = zzapy.bjH;
            this.f5895a = null;
            this.f5906b = -1;
            return this;
        }

        /* renamed from: zzp */
        public zzg zzb(zzapn zzapn) {
            while (true) {
                int ah = zzapn.mo7957ah();
                switch (ah) {
                    case 0:
                        break;
                    case 8:
                        int zzc = zzapy.zzc(zzapn, 8);
                        int length = this.zzvu == null ? 0 : this.zzvu.length;
                        int[] iArr = new int[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzvu, 0, iArr, 0, length);
                        }
                        while (length < iArr.length - 1) {
                            iArr[length] = zzapn.mo7961al();
                            zzapn.mo7957ah();
                            length++;
                        }
                        iArr[length] = zzapn.mo7961al();
                        this.zzvu = iArr;
                        continue;
                    case 10:
                        int zzafr = zzapn.zzafr(zzapn.mo7966aq());
                        int position = zzapn.getPosition();
                        int i = 0;
                        while (zzapn.mo7970av() > 0) {
                            zzapn.mo7961al();
                            i++;
                        }
                        zzapn.zzaft(position);
                        int length2 = this.zzvu == null ? 0 : this.zzvu.length;
                        int[] iArr2 = new int[(i + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.zzvu, 0, iArr2, 0, length2);
                        }
                        while (length2 < iArr2.length) {
                            iArr2[length2] = zzapn.mo7961al();
                            length2++;
                        }
                        this.zzvu = iArr2;
                        zzapn.zzafs(zzafr);
                        continue;
                    case 16:
                        int zzc2 = zzapy.zzc(zzapn, 16);
                        int length3 = this.zzvv == null ? 0 : this.zzvv.length;
                        int[] iArr3 = new int[(zzc2 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.zzvv, 0, iArr3, 0, length3);
                        }
                        while (length3 < iArr3.length - 1) {
                            iArr3[length3] = zzapn.mo7961al();
                            zzapn.mo7957ah();
                            length3++;
                        }
                        iArr3[length3] = zzapn.mo7961al();
                        this.zzvv = iArr3;
                        continue;
                    case 18:
                        int zzafr2 = zzapn.zzafr(zzapn.mo7966aq());
                        int position2 = zzapn.getPosition();
                        int i2 = 0;
                        while (zzapn.mo7970av() > 0) {
                            zzapn.mo7961al();
                            i2++;
                        }
                        zzapn.zzaft(position2);
                        int length4 = this.zzvv == null ? 0 : this.zzvv.length;
                        int[] iArr4 = new int[(i2 + length4)];
                        if (length4 != 0) {
                            System.arraycopy(this.zzvv, 0, iArr4, 0, length4);
                        }
                        while (length4 < iArr4.length) {
                            iArr4[length4] = zzapn.mo7961al();
                            length4++;
                        }
                        this.zzvv = iArr4;
                        zzapn.zzafs(zzafr2);
                        continue;
                    case 24:
                        int zzc3 = zzapy.zzc(zzapn, 24);
                        int length5 = this.zzvw == null ? 0 : this.zzvw.length;
                        int[] iArr5 = new int[(zzc3 + length5)];
                        if (length5 != 0) {
                            System.arraycopy(this.zzvw, 0, iArr5, 0, length5);
                        }
                        while (length5 < iArr5.length - 1) {
                            iArr5[length5] = zzapn.mo7961al();
                            zzapn.mo7957ah();
                            length5++;
                        }
                        iArr5[length5] = zzapn.mo7961al();
                        this.zzvw = iArr5;
                        continue;
                    case 26:
                        int zzafr3 = zzapn.zzafr(zzapn.mo7966aq());
                        int position3 = zzapn.getPosition();
                        int i3 = 0;
                        while (zzapn.mo7970av() > 0) {
                            zzapn.mo7961al();
                            i3++;
                        }
                        zzapn.zzaft(position3);
                        int length6 = this.zzvw == null ? 0 : this.zzvw.length;
                        int[] iArr6 = new int[(i3 + length6)];
                        if (length6 != 0) {
                            System.arraycopy(this.zzvw, 0, iArr6, 0, length6);
                        }
                        while (length6 < iArr6.length) {
                            iArr6[length6] = zzapn.mo7961al();
                            length6++;
                        }
                        this.zzvw = iArr6;
                        zzapn.zzafs(zzafr3);
                        continue;
                    case 32:
                        int zzc4 = zzapy.zzc(zzapn, 32);
                        int length7 = this.zzvx == null ? 0 : this.zzvx.length;
                        int[] iArr7 = new int[(zzc4 + length7)];
                        if (length7 != 0) {
                            System.arraycopy(this.zzvx, 0, iArr7, 0, length7);
                        }
                        while (length7 < iArr7.length - 1) {
                            iArr7[length7] = zzapn.mo7961al();
                            zzapn.mo7957ah();
                            length7++;
                        }
                        iArr7[length7] = zzapn.mo7961al();
                        this.zzvx = iArr7;
                        continue;
                    case C0515k.AppCompatTheme_actionModePasteDrawable:
                        int zzafr4 = zzapn.zzafr(zzapn.mo7966aq());
                        int position4 = zzapn.getPosition();
                        int i4 = 0;
                        while (zzapn.mo7970av() > 0) {
                            zzapn.mo7961al();
                            i4++;
                        }
                        zzapn.zzaft(position4);
                        int length8 = this.zzvx == null ? 0 : this.zzvx.length;
                        int[] iArr8 = new int[(i4 + length8)];
                        if (length8 != 0) {
                            System.arraycopy(this.zzvx, 0, iArr8, 0, length8);
                        }
                        while (length8 < iArr8.length) {
                            iArr8[length8] = zzapn.mo7961al();
                            length8++;
                        }
                        this.zzvx = iArr8;
                        zzapn.zzafs(zzafr4);
                        continue;
                    case C0515k.AppCompatTheme_textAppearanceLargePopupMenu:
                        int zzc5 = zzapy.zzc(zzapn, 40);
                        int length9 = this.zzvy == null ? 0 : this.zzvy.length;
                        int[] iArr9 = new int[(zzc5 + length9)];
                        if (length9 != 0) {
                            System.arraycopy(this.zzvy, 0, iArr9, 0, length9);
                        }
                        while (length9 < iArr9.length - 1) {
                            iArr9[length9] = zzapn.mo7961al();
                            zzapn.mo7957ah();
                            length9++;
                        }
                        iArr9[length9] = zzapn.mo7961al();
                        this.zzvy = iArr9;
                        continue;
                    case C0515k.AppCompatTheme_textAppearancePopupMenuHeader:
                        int zzafr5 = zzapn.zzafr(zzapn.mo7966aq());
                        int position5 = zzapn.getPosition();
                        int i5 = 0;
                        while (zzapn.mo7970av() > 0) {
                            zzapn.mo7961al();
                            i5++;
                        }
                        zzapn.zzaft(position5);
                        int length10 = this.zzvy == null ? 0 : this.zzvy.length;
                        int[] iArr10 = new int[(i5 + length10)];
                        if (length10 != 0) {
                            System.arraycopy(this.zzvy, 0, iArr10, 0, length10);
                        }
                        while (length10 < iArr10.length) {
                            iArr10[length10] = zzapn.mo7961al();
                            length10++;
                        }
                        this.zzvy = iArr10;
                        zzapn.zzafs(zzafr5);
                        continue;
                    case C0515k.AppCompatTheme_spinnerDropDownItemStyle:
                        int zzc6 = zzapy.zzc(zzapn, 48);
                        int length11 = this.zzvz == null ? 0 : this.zzvz.length;
                        int[] iArr11 = new int[(zzc6 + length11)];
                        if (length11 != 0) {
                            System.arraycopy(this.zzvz, 0, iArr11, 0, length11);
                        }
                        while (length11 < iArr11.length - 1) {
                            iArr11[length11] = zzapn.mo7961al();
                            zzapn.mo7957ah();
                            length11++;
                        }
                        iArr11[length11] = zzapn.mo7961al();
                        this.zzvz = iArr11;
                        continue;
                    case 50:
                        int zzafr6 = zzapn.zzafr(zzapn.mo7966aq());
                        int position6 = zzapn.getPosition();
                        int i6 = 0;
                        while (zzapn.mo7970av() > 0) {
                            zzapn.mo7961al();
                            i6++;
                        }
                        zzapn.zzaft(position6);
                        int length12 = this.zzvz == null ? 0 : this.zzvz.length;
                        int[] iArr12 = new int[(i6 + length12)];
                        if (length12 != 0) {
                            System.arraycopy(this.zzvz, 0, iArr12, 0, length12);
                        }
                        while (length12 < iArr12.length) {
                            iArr12[length12] = zzapn.mo7961al();
                            length12++;
                        }
                        this.zzvz = iArr12;
                        zzapn.zzafs(zzafr6);
                        continue;
                    case C0515k.AppCompatTheme_dividerVertical:
                        int zzc7 = zzapy.zzc(zzapn, 56);
                        int length13 = this.zzwa == null ? 0 : this.zzwa.length;
                        int[] iArr13 = new int[(zzc7 + length13)];
                        if (length13 != 0) {
                            System.arraycopy(this.zzwa, 0, iArr13, 0, length13);
                        }
                        while (length13 < iArr13.length - 1) {
                            iArr13[length13] = zzapn.mo7961al();
                            zzapn.mo7957ah();
                            length13++;
                        }
                        iArr13[length13] = zzapn.mo7961al();
                        this.zzwa = iArr13;
                        continue;
                    case C0515k.AppCompatTheme_activityChooserViewStyle:
                        int zzafr7 = zzapn.zzafr(zzapn.mo7966aq());
                        int position7 = zzapn.getPosition();
                        int i7 = 0;
                        while (zzapn.mo7970av() > 0) {
                            zzapn.mo7961al();
                            i7++;
                        }
                        zzapn.zzaft(position7);
                        int length14 = this.zzwa == null ? 0 : this.zzwa.length;
                        int[] iArr14 = new int[(i7 + length14)];
                        if (length14 != 0) {
                            System.arraycopy(this.zzwa, 0, iArr14, 0, length14);
                        }
                        while (length14 < iArr14.length) {
                            iArr14[length14] = zzapn.mo7961al();
                            length14++;
                        }
                        this.zzwa = iArr14;
                        zzapn.zzafs(zzafr7);
                        continue;
                    case 64:
                        int zzc8 = zzapy.zzc(zzapn, 64);
                        int length15 = this.zzwb == null ? 0 : this.zzwb.length;
                        int[] iArr15 = new int[(zzc8 + length15)];
                        if (length15 != 0) {
                            System.arraycopy(this.zzwb, 0, iArr15, 0, length15);
                        }
                        while (length15 < iArr15.length - 1) {
                            iArr15[length15] = zzapn.mo7961al();
                            zzapn.mo7957ah();
                            length15++;
                        }
                        iArr15[length15] = zzapn.mo7961al();
                        this.zzwb = iArr15;
                        continue;
                    case C0515k.AppCompatTheme_textAppearanceSearchResultTitle:
                        int zzafr8 = zzapn.zzafr(zzapn.mo7966aq());
                        int position8 = zzapn.getPosition();
                        int i8 = 0;
                        while (zzapn.mo7970av() > 0) {
                            zzapn.mo7961al();
                            i8++;
                        }
                        zzapn.zzaft(position8);
                        int length16 = this.zzwb == null ? 0 : this.zzwb.length;
                        int[] iArr16 = new int[(i8 + length16)];
                        if (length16 != 0) {
                            System.arraycopy(this.zzwb, 0, iArr16, 0, length16);
                        }
                        while (length16 < iArr16.length) {
                            iArr16[length16] = zzapn.mo7961al();
                            length16++;
                        }
                        this.zzwb = iArr16;
                        zzapn.zzafs(zzafr8);
                        continue;
                    case C0515k.AppCompatTheme_listPreferredItemHeightLarge:
                        int zzc9 = zzapy.zzc(zzapn, 72);
                        int length17 = this.zzwc == null ? 0 : this.zzwc.length;
                        int[] iArr17 = new int[(zzc9 + length17)];
                        if (length17 != 0) {
                            System.arraycopy(this.zzwc, 0, iArr17, 0, length17);
                        }
                        while (length17 < iArr17.length - 1) {
                            iArr17[length17] = zzapn.mo7961al();
                            zzapn.mo7957ah();
                            length17++;
                        }
                        iArr17[length17] = zzapn.mo7961al();
                        this.zzwc = iArr17;
                        continue;
                    case C0515k.AppCompatTheme_listPreferredItemPaddingRight:
                        int zzafr9 = zzapn.zzafr(zzapn.mo7966aq());
                        int position9 = zzapn.getPosition();
                        int i9 = 0;
                        while (zzapn.mo7970av() > 0) {
                            zzapn.mo7961al();
                            i9++;
                        }
                        zzapn.zzaft(position9);
                        int length18 = this.zzwc == null ? 0 : this.zzwc.length;
                        int[] iArr18 = new int[(i9 + length18)];
                        if (length18 != 0) {
                            System.arraycopy(this.zzwc, 0, iArr18, 0, length18);
                        }
                        while (length18 < iArr18.length) {
                            iArr18[length18] = zzapn.mo7961al();
                            length18++;
                        }
                        this.zzwc = iArr18;
                        zzapn.zzafs(zzafr9);
                        continue;
                    case C0515k.AppCompatTheme_panelMenuListWidth:
                        int zzc10 = zzapy.zzc(zzapn, 80);
                        int length19 = this.zzwd == null ? 0 : this.zzwd.length;
                        int[] iArr19 = new int[(zzc10 + length19)];
                        if (length19 != 0) {
                            System.arraycopy(this.zzwd, 0, iArr19, 0, length19);
                        }
                        while (length19 < iArr19.length - 1) {
                            iArr19[length19] = zzapn.mo7961al();
                            zzapn.mo7957ah();
                            length19++;
                        }
                        iArr19[length19] = zzapn.mo7961al();
                        this.zzwd = iArr19;
                        continue;
                    case C0515k.AppCompatTheme_listChoiceBackgroundIndicator:
                        int zzafr10 = zzapn.zzafr(zzapn.mo7966aq());
                        int position10 = zzapn.getPosition();
                        int i10 = 0;
                        while (zzapn.mo7970av() > 0) {
                            zzapn.mo7961al();
                            i10++;
                        }
                        zzapn.zzaft(position10);
                        int length20 = this.zzwd == null ? 0 : this.zzwd.length;
                        int[] iArr20 = new int[(i10 + length20)];
                        if (length20 != 0) {
                            System.arraycopy(this.zzwd, 0, iArr20, 0, length20);
                        }
                        while (length20 < iArr20.length) {
                            iArr20[length20] = zzapn.mo7961al();
                            length20++;
                        }
                        this.zzwd = iArr20;
                        zzapn.zzafs(zzafr10);
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

    public final class zzh extends zzapp {

        /* renamed from: c */
        private static final zzh[] f5561c = new zzh[0];
        public static final zzapq zzwe = zzapq.zza(11, zzh.class, 810);
        public int[] zzwg;
        public int[] zzwh;
        public int[] zzwi;
        public int zzwj;
        public int[] zzwk;
        public int zzwl;
        public int zzwm;

        public zzh() {
            zzal();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int mo7714a() {
            int i;
            int a = super.mo7714a();
            if (this.zzwg == null || this.zzwg.length <= 0) {
                i = a;
            } else {
                int i2 = 0;
                for (int zzafx : this.zzwg) {
                    i2 += zzapo.zzafx(zzafx);
                }
                i = a + i2 + (this.zzwg.length * 1);
            }
            if (this.zzwh != null && this.zzwh.length > 0) {
                int i3 = 0;
                for (int zzafx2 : this.zzwh) {
                    i3 += zzapo.zzafx(zzafx2);
                }
                i = i + i3 + (this.zzwh.length * 1);
            }
            if (this.zzwi != null && this.zzwi.length > 0) {
                int i4 = 0;
                for (int zzafx3 : this.zzwi) {
                    i4 += zzapo.zzafx(zzafx3);
                }
                i = i + i4 + (this.zzwi.length * 1);
            }
            if (this.zzwj != 0) {
                i += zzapo.zzag(4, this.zzwj);
            }
            if (this.zzwk != null && this.zzwk.length > 0) {
                int i5 = 0;
                for (int zzafx4 : this.zzwk) {
                    i5 += zzapo.zzafx(zzafx4);
                }
                i = i + i5 + (this.zzwk.length * 1);
            }
            if (this.zzwl != 0) {
                i += zzapo.zzag(6, this.zzwl);
            }
            return this.zzwm != 0 ? i + zzapo.zzag(7, this.zzwm) : i;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzh)) {
                return false;
            }
            zzh zzh = (zzh) obj;
            if (!zzapt.equals(this.zzwg, zzh.zzwg) || !zzapt.equals(this.zzwh, zzh.zzwh) || !zzapt.equals(this.zzwi, zzh.zzwi) || this.zzwj != zzh.zzwj || !zzapt.equals(this.zzwk, zzh.zzwk) || this.zzwl != zzh.zzwl || this.zzwm != zzh.zzwm) {
                return false;
            }
            return (this.f5895a == null || this.f5895a.isEmpty()) ? zzh.f5895a == null || zzh.f5895a.isEmpty() : this.f5895a.equals(zzh.f5895a);
        }

        public int hashCode() {
            return ((this.f5895a == null || this.f5895a.isEmpty()) ? 0 : this.f5895a.hashCode()) + ((((((((((((((((getClass().getName().hashCode() + 527) * 31) + zzapt.hashCode(this.zzwg)) * 31) + zzapt.hashCode(this.zzwh)) * 31) + zzapt.hashCode(this.zzwi)) * 31) + this.zzwj) * 31) + zzapt.hashCode(this.zzwk)) * 31) + this.zzwl) * 31) + this.zzwm) * 31);
        }

        public void zza(zzapo zzapo) {
            if (this.zzwg != null && this.zzwg.length > 0) {
                for (int zzae : this.zzwg) {
                    zzapo.zzae(1, zzae);
                }
            }
            if (this.zzwh != null && this.zzwh.length > 0) {
                for (int zzae2 : this.zzwh) {
                    zzapo.zzae(2, zzae2);
                }
            }
            if (this.zzwi != null && this.zzwi.length > 0) {
                for (int zzae3 : this.zzwi) {
                    zzapo.zzae(3, zzae3);
                }
            }
            if (this.zzwj != 0) {
                zzapo.zzae(4, this.zzwj);
            }
            if (this.zzwk != null && this.zzwk.length > 0) {
                for (int zzae4 : this.zzwk) {
                    zzapo.zzae(5, zzae4);
                }
            }
            if (this.zzwl != 0) {
                zzapo.zzae(6, this.zzwl);
            }
            if (this.zzwm != 0) {
                zzapo.zzae(7, this.zzwm);
            }
            super.zza(zzapo);
        }

        public zzh zzal() {
            this.zzwg = zzapy.bjH;
            this.zzwh = zzapy.bjH;
            this.zzwi = zzapy.bjH;
            this.zzwj = 0;
            this.zzwk = zzapy.bjH;
            this.zzwl = 0;
            this.zzwm = 0;
            this.f5895a = null;
            this.f5906b = -1;
            return this;
        }

        /* renamed from: zzq */
        public zzh zzb(zzapn zzapn) {
            while (true) {
                int ah = zzapn.mo7957ah();
                switch (ah) {
                    case 0:
                        break;
                    case 8:
                        int zzc = zzapy.zzc(zzapn, 8);
                        int length = this.zzwg == null ? 0 : this.zzwg.length;
                        int[] iArr = new int[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzwg, 0, iArr, 0, length);
                        }
                        while (length < iArr.length - 1) {
                            iArr[length] = zzapn.mo7961al();
                            zzapn.mo7957ah();
                            length++;
                        }
                        iArr[length] = zzapn.mo7961al();
                        this.zzwg = iArr;
                        continue;
                    case 10:
                        int zzafr = zzapn.zzafr(zzapn.mo7966aq());
                        int position = zzapn.getPosition();
                        int i = 0;
                        while (zzapn.mo7970av() > 0) {
                            zzapn.mo7961al();
                            i++;
                        }
                        zzapn.zzaft(position);
                        int length2 = this.zzwg == null ? 0 : this.zzwg.length;
                        int[] iArr2 = new int[(i + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.zzwg, 0, iArr2, 0, length2);
                        }
                        while (length2 < iArr2.length) {
                            iArr2[length2] = zzapn.mo7961al();
                            length2++;
                        }
                        this.zzwg = iArr2;
                        zzapn.zzafs(zzafr);
                        continue;
                    case 16:
                        int zzc2 = zzapy.zzc(zzapn, 16);
                        int length3 = this.zzwh == null ? 0 : this.zzwh.length;
                        int[] iArr3 = new int[(zzc2 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.zzwh, 0, iArr3, 0, length3);
                        }
                        while (length3 < iArr3.length - 1) {
                            iArr3[length3] = zzapn.mo7961al();
                            zzapn.mo7957ah();
                            length3++;
                        }
                        iArr3[length3] = zzapn.mo7961al();
                        this.zzwh = iArr3;
                        continue;
                    case 18:
                        int zzafr2 = zzapn.zzafr(zzapn.mo7966aq());
                        int position2 = zzapn.getPosition();
                        int i2 = 0;
                        while (zzapn.mo7970av() > 0) {
                            zzapn.mo7961al();
                            i2++;
                        }
                        zzapn.zzaft(position2);
                        int length4 = this.zzwh == null ? 0 : this.zzwh.length;
                        int[] iArr4 = new int[(i2 + length4)];
                        if (length4 != 0) {
                            System.arraycopy(this.zzwh, 0, iArr4, 0, length4);
                        }
                        while (length4 < iArr4.length) {
                            iArr4[length4] = zzapn.mo7961al();
                            length4++;
                        }
                        this.zzwh = iArr4;
                        zzapn.zzafs(zzafr2);
                        continue;
                    case 24:
                        int zzc3 = zzapy.zzc(zzapn, 24);
                        int length5 = this.zzwi == null ? 0 : this.zzwi.length;
                        int[] iArr5 = new int[(zzc3 + length5)];
                        if (length5 != 0) {
                            System.arraycopy(this.zzwi, 0, iArr5, 0, length5);
                        }
                        while (length5 < iArr5.length - 1) {
                            iArr5[length5] = zzapn.mo7961al();
                            zzapn.mo7957ah();
                            length5++;
                        }
                        iArr5[length5] = zzapn.mo7961al();
                        this.zzwi = iArr5;
                        continue;
                    case 26:
                        int zzafr3 = zzapn.zzafr(zzapn.mo7966aq());
                        int position3 = zzapn.getPosition();
                        int i3 = 0;
                        while (zzapn.mo7970av() > 0) {
                            zzapn.mo7961al();
                            i3++;
                        }
                        zzapn.zzaft(position3);
                        int length6 = this.zzwi == null ? 0 : this.zzwi.length;
                        int[] iArr6 = new int[(i3 + length6)];
                        if (length6 != 0) {
                            System.arraycopy(this.zzwi, 0, iArr6, 0, length6);
                        }
                        while (length6 < iArr6.length) {
                            iArr6[length6] = zzapn.mo7961al();
                            length6++;
                        }
                        this.zzwi = iArr6;
                        zzapn.zzafs(zzafr3);
                        continue;
                    case 32:
                        this.zzwj = zzapn.mo7961al();
                        continue;
                    case C0515k.AppCompatTheme_textAppearanceLargePopupMenu:
                        int zzc4 = zzapy.zzc(zzapn, 40);
                        int length7 = this.zzwk == null ? 0 : this.zzwk.length;
                        int[] iArr7 = new int[(zzc4 + length7)];
                        if (length7 != 0) {
                            System.arraycopy(this.zzwk, 0, iArr7, 0, length7);
                        }
                        while (length7 < iArr7.length - 1) {
                            iArr7[length7] = zzapn.mo7961al();
                            zzapn.mo7957ah();
                            length7++;
                        }
                        iArr7[length7] = zzapn.mo7961al();
                        this.zzwk = iArr7;
                        continue;
                    case C0515k.AppCompatTheme_textAppearancePopupMenuHeader:
                        int zzafr4 = zzapn.zzafr(zzapn.mo7966aq());
                        int position4 = zzapn.getPosition();
                        int i4 = 0;
                        while (zzapn.mo7970av() > 0) {
                            zzapn.mo7961al();
                            i4++;
                        }
                        zzapn.zzaft(position4);
                        int length8 = this.zzwk == null ? 0 : this.zzwk.length;
                        int[] iArr8 = new int[(i4 + length8)];
                        if (length8 != 0) {
                            System.arraycopy(this.zzwk, 0, iArr8, 0, length8);
                        }
                        while (length8 < iArr8.length) {
                            iArr8[length8] = zzapn.mo7961al();
                            length8++;
                        }
                        this.zzwk = iArr8;
                        zzapn.zzafs(zzafr4);
                        continue;
                    case C0515k.AppCompatTheme_spinnerDropDownItemStyle:
                        this.zzwl = zzapn.mo7961al();
                        continue;
                    case C0515k.AppCompatTheme_dividerVertical:
                        this.zzwm = zzapn.mo7961al();
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

    public final class zzi extends zzapp {

        /* renamed from: c */
        private static volatile zzi[] f5562c;
        public String name;
        public zzai.zza zzwo;
        public zzd zzwp;

        public zzi() {
            zzan();
        }

        public static zzi[] zzam() {
            if (f5562c == null) {
                synchronized (zzapt.bjF) {
                    if (f5562c == null) {
                        f5562c = new zzi[0];
                    }
                }
            }
            return f5562c;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int mo7714a() {
            int a = super.mo7714a();
            if (!this.name.equals("")) {
                a += zzapo.zzs(1, this.name);
            }
            if (this.zzwo != null) {
                a += zzapo.zzc(2, (zzapv) this.zzwo);
            }
            return this.zzwp != null ? a + zzapo.zzc(3, (zzapv) this.zzwp) : a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzi)) {
                return false;
            }
            zzi zzi = (zzi) obj;
            if (this.name == null) {
                if (zzi.name != null) {
                    return false;
                }
            } else if (!this.name.equals(zzi.name)) {
                return false;
            }
            if (this.zzwo == null) {
                if (zzi.zzwo != null) {
                    return false;
                }
            } else if (!this.zzwo.equals(zzi.zzwo)) {
                return false;
            }
            if (this.zzwp == null) {
                if (zzi.zzwp != null) {
                    return false;
                }
            } else if (!this.zzwp.equals(zzi.zzwp)) {
                return false;
            }
            return (this.f5895a == null || this.f5895a.isEmpty()) ? zzi.f5895a == null || zzi.f5895a.isEmpty() : this.f5895a.equals(zzi.f5895a);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzwp == null ? 0 : this.zzwp.hashCode()) + (((this.zzwo == null ? 0 : this.zzwo.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31;
            if (this.f5895a != null && !this.f5895a.isEmpty()) {
                i = this.f5895a.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzapo zzapo) {
            if (!this.name.equals("")) {
                zzapo.zzr(1, this.name);
            }
            if (this.zzwo != null) {
                zzapo.zza(2, (zzapv) this.zzwo);
            }
            if (this.zzwp != null) {
                zzapo.zza(3, (zzapv) this.zzwp);
            }
            super.zza(zzapo);
        }

        public zzi zzan() {
            this.name = "";
            this.zzwo = null;
            this.zzwp = null;
            this.f5895a = null;
            this.f5906b = -1;
            return this;
        }

        /* renamed from: zzr */
        public zzi zzb(zzapn zzapn) {
            while (true) {
                int ah = zzapn.mo7957ah();
                switch (ah) {
                    case 0:
                        break;
                    case 10:
                        this.name = zzapn.readString();
                        continue;
                    case 18:
                        if (this.zzwo == null) {
                            this.zzwo = new zzai.zza();
                        }
                        zzapn.zza(this.zzwo);
                        continue;
                    case 26:
                        if (this.zzwp == null) {
                            this.zzwp = new zzd();
                        }
                        zzapn.zza(this.zzwp);
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

    public final class zzj extends zzapp {
        public zzi[] zzwq;
        public zzf zzwr;
        public String zzws;

        public zzj() {
            zzao();
        }

        public static zzj zzf(byte[] bArr) {
            return (zzj) zzapv.zza(new zzj(), bArr);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int mo7714a() {
            int a = super.mo7714a();
            if (this.zzwq != null && this.zzwq.length > 0) {
                for (zzi zzi : this.zzwq) {
                    if (zzi != null) {
                        a += zzapo.zzc(1, (zzapv) zzi);
                    }
                }
            }
            if (this.zzwr != null) {
                a += zzapo.zzc(2, (zzapv) this.zzwr);
            }
            return !this.zzws.equals("") ? a + zzapo.zzs(3, this.zzws) : a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzj)) {
                return false;
            }
            zzj zzj = (zzj) obj;
            if (!zzapt.equals((Object[]) this.zzwq, (Object[]) zzj.zzwq)) {
                return false;
            }
            if (this.zzwr == null) {
                if (zzj.zzwr != null) {
                    return false;
                }
            } else if (!this.zzwr.equals(zzj.zzwr)) {
                return false;
            }
            if (this.zzws == null) {
                if (zzj.zzws != null) {
                    return false;
                }
            } else if (!this.zzws.equals(zzj.zzws)) {
                return false;
            }
            return (this.f5895a == null || this.f5895a.isEmpty()) ? zzj.f5895a == null || zzj.f5895a.isEmpty() : this.f5895a.equals(zzj.f5895a);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzws == null ? 0 : this.zzws.hashCode()) + (((this.zzwr == null ? 0 : this.zzwr.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + zzapt.hashCode((Object[]) this.zzwq)) * 31)) * 31)) * 31;
            if (this.f5895a != null && !this.f5895a.isEmpty()) {
                i = this.f5895a.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzapo zzapo) {
            if (this.zzwq != null && this.zzwq.length > 0) {
                for (zzi zzi : this.zzwq) {
                    if (zzi != null) {
                        zzapo.zza(1, (zzapv) zzi);
                    }
                }
            }
            if (this.zzwr != null) {
                zzapo.zza(2, (zzapv) this.zzwr);
            }
            if (!this.zzws.equals("")) {
                zzapo.zzr(3, this.zzws);
            }
            super.zza(zzapo);
        }

        public zzj zzao() {
            this.zzwq = zzi.zzam();
            this.zzwr = null;
            this.zzws = "";
            this.f5895a = null;
            this.f5906b = -1;
            return this;
        }

        /* renamed from: zzs */
        public zzj zzb(zzapn zzapn) {
            while (true) {
                int ah = zzapn.mo7957ah();
                switch (ah) {
                    case 0:
                        break;
                    case 10:
                        int zzc = zzapy.zzc(zzapn, 10);
                        int length = this.zzwq == null ? 0 : this.zzwq.length;
                        zzi[] zziArr = new zzi[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzwq, 0, zziArr, 0, length);
                        }
                        while (length < zziArr.length - 1) {
                            zziArr[length] = new zzi();
                            zzapn.zza(zziArr[length]);
                            zzapn.mo7957ah();
                            length++;
                        }
                        zziArr[length] = new zzi();
                        zzapn.zza(zziArr[length]);
                        this.zzwq = zziArr;
                        continue;
                    case 18:
                        if (this.zzwr == null) {
                            this.zzwr = new zzf();
                        }
                        zzapn.zza(this.zzwr);
                        continue;
                    case 26:
                        this.zzws = zzapn.readString();
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
}
