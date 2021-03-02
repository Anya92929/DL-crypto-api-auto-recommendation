package com.google.android.gms.internal;

import android.support.p021v7.p023b.C0515k;
import com.google.android.gms.internal.zzuf;

public interface zzug {

    public final class zza extends zzapv {

        /* renamed from: a */
        private static volatile zza[] f7014a;
        public Boolean ana;
        public Boolean anb;
        public String name;

        public zza() {
            zzbvo();
        }

        public static zza[] zzbvn() {
            if (f7014a == null) {
                synchronized (zzapt.bjF) {
                    if (f7014a == null) {
                        f7014a = new zza[0];
                    }
                }
            }
            return f7014a;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int mo7714a() {
            int a = super.mo7714a();
            if (this.name != null) {
                a += zzapo.zzs(1, this.name);
            }
            if (this.ana != null) {
                a += zzapo.zzk(2, this.ana.booleanValue());
            }
            return this.anb != null ? a + zzapo.zzk(3, this.anb.booleanValue()) : a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza = (zza) obj;
            if (this.name == null) {
                if (zza.name != null) {
                    return false;
                }
            } else if (!this.name.equals(zza.name)) {
                return false;
            }
            if (this.ana == null) {
                if (zza.ana != null) {
                    return false;
                }
            } else if (!this.ana.equals(zza.ana)) {
                return false;
            }
            return this.anb == null ? zza.anb == null : this.anb.equals(zza.anb);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.ana == null ? 0 : this.ana.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
            if (this.anb != null) {
                i = this.anb.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzapo zzapo) {
            if (this.name != null) {
                zzapo.zzr(1, this.name);
            }
            if (this.ana != null) {
                zzapo.zzj(2, this.ana.booleanValue());
            }
            if (this.anb != null) {
                zzapo.zzj(3, this.anb.booleanValue());
            }
            super.zza(zzapo);
        }

        /* renamed from: zzai */
        public zza zzb(zzapn zzapn) {
            while (true) {
                int ah = zzapn.mo7957ah();
                switch (ah) {
                    case 0:
                        break;
                    case 10:
                        this.name = zzapn.readString();
                        continue;
                    case 16:
                        this.ana = Boolean.valueOf(zzapn.mo7963an());
                        continue;
                    case 24:
                        this.anb = Boolean.valueOf(zzapn.mo7963an());
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

        public zza zzbvo() {
            this.name = null;
            this.ana = null;
            this.anb = null;
            this.f5906b = -1;
            return this;
        }
    }

    public final class zzb extends zzapv {
        public String aic;
        public Long anc;
        public Integer and;
        public zzc[] ane;
        public zza[] anf;
        public zzuf.zza[] ang;

        public zzb() {
            zzbvp();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int mo7714a() {
            int a = super.mo7714a();
            if (this.anc != null) {
                a += zzapo.zze(1, this.anc.longValue());
            }
            if (this.aic != null) {
                a += zzapo.zzs(2, this.aic);
            }
            if (this.and != null) {
                a += zzapo.zzag(3, this.and.intValue());
            }
            if (this.ane != null && this.ane.length > 0) {
                int i = a;
                for (zzc zzc : this.ane) {
                    if (zzc != null) {
                        i += zzapo.zzc(4, (zzapv) zzc);
                    }
                }
                a = i;
            }
            if (this.anf != null && this.anf.length > 0) {
                int i2 = a;
                for (zza zza : this.anf) {
                    if (zza != null) {
                        i2 += zzapo.zzc(5, (zzapv) zza);
                    }
                }
                a = i2;
            }
            if (this.ang != null && this.ang.length > 0) {
                for (zzuf.zza zza2 : this.ang) {
                    if (zza2 != null) {
                        a += zzapo.zzc(6, (zzapv) zza2);
                    }
                }
            }
            return a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzb)) {
                return false;
            }
            zzb zzb = (zzb) obj;
            if (this.anc == null) {
                if (zzb.anc != null) {
                    return false;
                }
            } else if (!this.anc.equals(zzb.anc)) {
                return false;
            }
            if (this.aic == null) {
                if (zzb.aic != null) {
                    return false;
                }
            } else if (!this.aic.equals(zzb.aic)) {
                return false;
            }
            if (this.and == null) {
                if (zzb.and != null) {
                    return false;
                }
            } else if (!this.and.equals(zzb.and)) {
                return false;
            }
            if (!zzapt.equals((Object[]) this.ane, (Object[]) zzb.ane)) {
                return false;
            }
            if (!zzapt.equals((Object[]) this.anf, (Object[]) zzb.anf)) {
                return false;
            }
            return zzapt.equals((Object[]) this.ang, (Object[]) zzb.ang);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.aic == null ? 0 : this.aic.hashCode()) + (((this.anc == null ? 0 : this.anc.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
            if (this.and != null) {
                i = this.and.hashCode();
            }
            return ((((((hashCode + i) * 31) + zzapt.hashCode((Object[]) this.ane)) * 31) + zzapt.hashCode((Object[]) this.anf)) * 31) + zzapt.hashCode((Object[]) this.ang);
        }

        public void zza(zzapo zzapo) {
            if (this.anc != null) {
                zzapo.zzb(1, this.anc.longValue());
            }
            if (this.aic != null) {
                zzapo.zzr(2, this.aic);
            }
            if (this.and != null) {
                zzapo.zzae(3, this.and.intValue());
            }
            if (this.ane != null && this.ane.length > 0) {
                for (zzc zzc : this.ane) {
                    if (zzc != null) {
                        zzapo.zza(4, (zzapv) zzc);
                    }
                }
            }
            if (this.anf != null && this.anf.length > 0) {
                for (zza zza : this.anf) {
                    if (zza != null) {
                        zzapo.zza(5, (zzapv) zza);
                    }
                }
            }
            if (this.ang != null && this.ang.length > 0) {
                for (zzuf.zza zza2 : this.ang) {
                    if (zza2 != null) {
                        zzapo.zza(6, (zzapv) zza2);
                    }
                }
            }
            super.zza(zzapo);
        }

        /* renamed from: zzaj */
        public zzb zzb(zzapn zzapn) {
            while (true) {
                int ah = zzapn.mo7957ah();
                switch (ah) {
                    case 0:
                        break;
                    case 8:
                        this.anc = Long.valueOf(zzapn.mo7960ak());
                        continue;
                    case 18:
                        this.aic = zzapn.readString();
                        continue;
                    case 24:
                        this.and = Integer.valueOf(zzapn.mo7961al());
                        continue;
                    case C0515k.AppCompatTheme_actionModePasteDrawable:
                        int zzc = zzapy.zzc(zzapn, 34);
                        int length = this.ane == null ? 0 : this.ane.length;
                        zzc[] zzcArr = new zzc[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.ane, 0, zzcArr, 0, length);
                        }
                        while (length < zzcArr.length - 1) {
                            zzcArr[length] = new zzc();
                            zzapn.zza(zzcArr[length]);
                            zzapn.mo7957ah();
                            length++;
                        }
                        zzcArr[length] = new zzc();
                        zzapn.zza(zzcArr[length]);
                        this.ane = zzcArr;
                        continue;
                    case C0515k.AppCompatTheme_textAppearancePopupMenuHeader:
                        int zzc2 = zzapy.zzc(zzapn, 42);
                        int length2 = this.anf == null ? 0 : this.anf.length;
                        zza[] zzaArr = new zza[(zzc2 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.anf, 0, zzaArr, 0, length2);
                        }
                        while (length2 < zzaArr.length - 1) {
                            zzaArr[length2] = new zza();
                            zzapn.zza(zzaArr[length2]);
                            zzapn.mo7957ah();
                            length2++;
                        }
                        zzaArr[length2] = new zza();
                        zzapn.zza(zzaArr[length2]);
                        this.anf = zzaArr;
                        continue;
                    case 50:
                        int zzc3 = zzapy.zzc(zzapn, 50);
                        int length3 = this.ang == null ? 0 : this.ang.length;
                        zzuf.zza[] zzaArr2 = new zzuf.zza[(zzc3 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.ang, 0, zzaArr2, 0, length3);
                        }
                        while (length3 < zzaArr2.length - 1) {
                            zzaArr2[length3] = new zzuf.zza();
                            zzapn.zza(zzaArr2[length3]);
                            zzapn.mo7957ah();
                            length3++;
                        }
                        zzaArr2[length3] = new zzuf.zza();
                        zzapn.zza(zzaArr2[length3]);
                        this.ang = zzaArr2;
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

        public zzb zzbvp() {
            this.anc = null;
            this.aic = null;
            this.and = null;
            this.ane = zzc.zzbvq();
            this.anf = zza.zzbvn();
            this.ang = zzuf.zza.zzbvd();
            this.f5906b = -1;
            return this;
        }
    }

    public final class zzc extends zzapv {

        /* renamed from: a */
        private static volatile zzc[] f7015a;
        public String value;
        public String zzcb;

        public zzc() {
            zzbvr();
        }

        public static zzc[] zzbvq() {
            if (f7015a == null) {
                synchronized (zzapt.bjF) {
                    if (f7015a == null) {
                        f7015a = new zzc[0];
                    }
                }
            }
            return f7015a;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int mo7714a() {
            int a = super.mo7714a();
            if (this.zzcb != null) {
                a += zzapo.zzs(1, this.zzcb);
            }
            return this.value != null ? a + zzapo.zzs(2, this.value) : a;
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
            return this.value == null ? zzc.value == null : this.value.equals(zzc.value);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzcb == null ? 0 : this.zzcb.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31;
            if (this.value != null) {
                i = this.value.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzapo zzapo) {
            if (this.zzcb != null) {
                zzapo.zzr(1, this.zzcb);
            }
            if (this.value != null) {
                zzapo.zzr(2, this.value);
            }
            super.zza(zzapo);
        }

        /* renamed from: zzak */
        public zzc zzb(zzapn zzapn) {
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
                        if (!zzapy.zzb(zzapn, ah)) {
                            break;
                        } else {
                            continue;
                        }
                }
            }
            return this;
        }

        public zzc zzbvr() {
            this.zzcb = null;
            this.value = null;
            this.f5906b = -1;
            return this;
        }
    }
}
