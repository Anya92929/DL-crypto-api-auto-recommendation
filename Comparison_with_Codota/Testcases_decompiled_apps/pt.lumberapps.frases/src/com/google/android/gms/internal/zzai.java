package com.google.android.gms.internal;

import android.support.p021v7.p023b.C0515k;

public interface zzai {

    public final class zza extends zzapp {

        /* renamed from: c */
        private static volatile zza[] f5563c;
        public String string;
        public int type;
        public zza[] zzwu;
        public zza[] zzwv;
        public zza[] zzww;
        public String zzwx;
        public String zzwy;
        public long zzwz;
        public boolean zzxa;
        public zza[] zzxb;
        public int[] zzxc;
        public boolean zzxd;

        public zza() {
            zzaq();
        }

        public static zza[] zzap() {
            if (f5563c == null) {
                synchronized (zzapt.bjF) {
                    if (f5563c == null) {
                        f5563c = new zza[0];
                    }
                }
            }
            return f5563c;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int mo7714a() {
            int a = super.mo7714a() + zzapo.zzag(1, this.type);
            if (!this.string.equals("")) {
                a += zzapo.zzs(2, this.string);
            }
            if (this.zzwu != null && this.zzwu.length > 0) {
                int i = a;
                for (zza zza : this.zzwu) {
                    if (zza != null) {
                        i += zzapo.zzc(3, (zzapv) zza);
                    }
                }
                a = i;
            }
            if (this.zzwv != null && this.zzwv.length > 0) {
                int i2 = a;
                for (zza zza2 : this.zzwv) {
                    if (zza2 != null) {
                        i2 += zzapo.zzc(4, (zzapv) zza2);
                    }
                }
                a = i2;
            }
            if (this.zzww != null && this.zzww.length > 0) {
                int i3 = a;
                for (zza zza3 : this.zzww) {
                    if (zza3 != null) {
                        i3 += zzapo.zzc(5, (zzapv) zza3);
                    }
                }
                a = i3;
            }
            if (!this.zzwx.equals("")) {
                a += zzapo.zzs(6, this.zzwx);
            }
            if (!this.zzwy.equals("")) {
                a += zzapo.zzs(7, this.zzwy);
            }
            if (this.zzwz != 0) {
                a += zzapo.zze(8, this.zzwz);
            }
            if (this.zzxd) {
                a += zzapo.zzk(9, this.zzxd);
            }
            if (this.zzxc != null && this.zzxc.length > 0) {
                int i4 = 0;
                for (int zzafx : this.zzxc) {
                    i4 += zzapo.zzafx(zzafx);
                }
                a = a + i4 + (this.zzxc.length * 1);
            }
            if (this.zzxb != null && this.zzxb.length > 0) {
                for (zza zza4 : this.zzxb) {
                    if (zza4 != null) {
                        a += zzapo.zzc(11, (zzapv) zza4);
                    }
                }
            }
            return this.zzxa ? a + zzapo.zzk(12, this.zzxa) : a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza = (zza) obj;
            if (this.type != zza.type) {
                return false;
            }
            if (this.string == null) {
                if (zza.string != null) {
                    return false;
                }
            } else if (!this.string.equals(zza.string)) {
                return false;
            }
            if (!zzapt.equals((Object[]) this.zzwu, (Object[]) zza.zzwu) || !zzapt.equals((Object[]) this.zzwv, (Object[]) zza.zzwv) || !zzapt.equals((Object[]) this.zzww, (Object[]) zza.zzww)) {
                return false;
            }
            if (this.zzwx == null) {
                if (zza.zzwx != null) {
                    return false;
                }
            } else if (!this.zzwx.equals(zza.zzwx)) {
                return false;
            }
            if (this.zzwy == null) {
                if (zza.zzwy != null) {
                    return false;
                }
            } else if (!this.zzwy.equals(zza.zzwy)) {
                return false;
            }
            if (this.zzwz == zza.zzwz && this.zzxa == zza.zzxa && zzapt.equals((Object[]) this.zzxb, (Object[]) zza.zzxb) && zzapt.equals(this.zzxc, zza.zzxc) && this.zzxd == zza.zzxd) {
                return (this.f5895a == null || this.f5895a.isEmpty()) ? zza.f5895a == null || zza.f5895a.isEmpty() : this.f5895a.equals(zza.f5895a);
            }
            return false;
        }

        public int hashCode() {
            int i = 1231;
            int i2 = 0;
            int hashCode = ((((((this.zzxa ? 1231 : 1237) + (((((this.zzwy == null ? 0 : this.zzwy.hashCode()) + (((this.zzwx == null ? 0 : this.zzwx.hashCode()) + (((((((((this.string == null ? 0 : this.string.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + this.type) * 31)) * 31) + zzapt.hashCode((Object[]) this.zzwu)) * 31) + zzapt.hashCode((Object[]) this.zzwv)) * 31) + zzapt.hashCode((Object[]) this.zzww)) * 31)) * 31)) * 31) + ((int) (this.zzwz ^ (this.zzwz >>> 32)))) * 31)) * 31) + zzapt.hashCode((Object[]) this.zzxb)) * 31) + zzapt.hashCode(this.zzxc)) * 31;
            if (!this.zzxd) {
                i = 1237;
            }
            int i3 = (hashCode + i) * 31;
            if (this.f5895a != null && !this.f5895a.isEmpty()) {
                i2 = this.f5895a.hashCode();
            }
            return i3 + i2;
        }

        public void zza(zzapo zzapo) {
            zzapo.zzae(1, this.type);
            if (!this.string.equals("")) {
                zzapo.zzr(2, this.string);
            }
            if (this.zzwu != null && this.zzwu.length > 0) {
                for (zza zza : this.zzwu) {
                    if (zza != null) {
                        zzapo.zza(3, (zzapv) zza);
                    }
                }
            }
            if (this.zzwv != null && this.zzwv.length > 0) {
                for (zza zza2 : this.zzwv) {
                    if (zza2 != null) {
                        zzapo.zza(4, (zzapv) zza2);
                    }
                }
            }
            if (this.zzww != null && this.zzww.length > 0) {
                for (zza zza3 : this.zzww) {
                    if (zza3 != null) {
                        zzapo.zza(5, (zzapv) zza3);
                    }
                }
            }
            if (!this.zzwx.equals("")) {
                zzapo.zzr(6, this.zzwx);
            }
            if (!this.zzwy.equals("")) {
                zzapo.zzr(7, this.zzwy);
            }
            if (this.zzwz != 0) {
                zzapo.zzb(8, this.zzwz);
            }
            if (this.zzxd) {
                zzapo.zzj(9, this.zzxd);
            }
            if (this.zzxc != null && this.zzxc.length > 0) {
                for (int zzae : this.zzxc) {
                    zzapo.zzae(10, zzae);
                }
            }
            if (this.zzxb != null && this.zzxb.length > 0) {
                for (zza zza4 : this.zzxb) {
                    if (zza4 != null) {
                        zzapo.zza(11, (zzapv) zza4);
                    }
                }
            }
            if (this.zzxa) {
                zzapo.zzj(12, this.zzxa);
            }
            super.zza(zzapo);
        }

        public zza zzaq() {
            this.type = 1;
            this.string = "";
            this.zzwu = zzap();
            this.zzwv = zzap();
            this.zzww = zzap();
            this.zzwx = "";
            this.zzwy = "";
            this.zzwz = 0;
            this.zzxa = false;
            this.zzxb = zzap();
            this.zzxc = zzapy.bjH;
            this.zzxd = false;
            this.f5895a = null;
            this.f5906b = -1;
            return this;
        }

        /* renamed from: zzt */
        public zza zzb(zzapn zzapn) {
            int i;
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
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                                this.type = al;
                                break;
                            default:
                                continue;
                        }
                    case 18:
                        this.string = zzapn.readString();
                        continue;
                    case 26:
                        int zzc = zzapy.zzc(zzapn, 26);
                        int length = this.zzwu == null ? 0 : this.zzwu.length;
                        zza[] zzaArr = new zza[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzwu, 0, zzaArr, 0, length);
                        }
                        while (length < zzaArr.length - 1) {
                            zzaArr[length] = new zza();
                            zzapn.zza(zzaArr[length]);
                            zzapn.mo7957ah();
                            length++;
                        }
                        zzaArr[length] = new zza();
                        zzapn.zza(zzaArr[length]);
                        this.zzwu = zzaArr;
                        continue;
                    case C0515k.AppCompatTheme_actionModePasteDrawable:
                        int zzc2 = zzapy.zzc(zzapn, 34);
                        int length2 = this.zzwv == null ? 0 : this.zzwv.length;
                        zza[] zzaArr2 = new zza[(zzc2 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.zzwv, 0, zzaArr2, 0, length2);
                        }
                        while (length2 < zzaArr2.length - 1) {
                            zzaArr2[length2] = new zza();
                            zzapn.zza(zzaArr2[length2]);
                            zzapn.mo7957ah();
                            length2++;
                        }
                        zzaArr2[length2] = new zza();
                        zzapn.zza(zzaArr2[length2]);
                        this.zzwv = zzaArr2;
                        continue;
                    case C0515k.AppCompatTheme_textAppearancePopupMenuHeader:
                        int zzc3 = zzapy.zzc(zzapn, 42);
                        int length3 = this.zzww == null ? 0 : this.zzww.length;
                        zza[] zzaArr3 = new zza[(zzc3 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.zzww, 0, zzaArr3, 0, length3);
                        }
                        while (length3 < zzaArr3.length - 1) {
                            zzaArr3[length3] = new zza();
                            zzapn.zza(zzaArr3[length3]);
                            zzapn.mo7957ah();
                            length3++;
                        }
                        zzaArr3[length3] = new zza();
                        zzapn.zza(zzaArr3[length3]);
                        this.zzww = zzaArr3;
                        continue;
                    case 50:
                        this.zzwx = zzapn.readString();
                        continue;
                    case C0515k.AppCompatTheme_activityChooserViewStyle:
                        this.zzwy = zzapn.readString();
                        continue;
                    case 64:
                        this.zzwz = zzapn.mo7960ak();
                        continue;
                    case C0515k.AppCompatTheme_listPreferredItemHeightLarge:
                        this.zzxd = zzapn.mo7963an();
                        continue;
                    case C0515k.AppCompatTheme_panelMenuListWidth:
                        int zzc4 = zzapy.zzc(zzapn, 80);
                        int[] iArr = new int[zzc4];
                        int i2 = 0;
                        int i3 = 0;
                        while (i2 < zzc4) {
                            if (i2 != 0) {
                                zzapn.mo7957ah();
                            }
                            int al2 = zzapn.mo7961al();
                            switch (al2) {
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
                                    i = i3 + 1;
                                    iArr[i3] = al2;
                                    break;
                                default:
                                    i = i3;
                                    break;
                            }
                            i2++;
                            i3 = i;
                        }
                        if (i3 != 0) {
                            int length4 = this.zzxc == null ? 0 : this.zzxc.length;
                            if (length4 != 0 || i3 != zzc4) {
                                int[] iArr2 = new int[(length4 + i3)];
                                if (length4 != 0) {
                                    System.arraycopy(this.zzxc, 0, iArr2, 0, length4);
                                }
                                System.arraycopy(iArr, 0, iArr2, length4, i3);
                                this.zzxc = iArr2;
                                break;
                            } else {
                                this.zzxc = iArr;
                                break;
                            }
                        } else {
                            continue;
                        }
                    case C0515k.AppCompatTheme_listChoiceBackgroundIndicator:
                        int zzafr = zzapn.zzafr(zzapn.mo7966aq());
                        int position = zzapn.getPosition();
                        int i4 = 0;
                        while (zzapn.mo7970av() > 0) {
                            switch (zzapn.mo7961al()) {
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
                                    i4++;
                                    break;
                            }
                        }
                        if (i4 != 0) {
                            zzapn.zzaft(position);
                            int length5 = this.zzxc == null ? 0 : this.zzxc.length;
                            int[] iArr3 = new int[(i4 + length5)];
                            if (length5 != 0) {
                                System.arraycopy(this.zzxc, 0, iArr3, 0, length5);
                            }
                            while (zzapn.mo7970av() > 0) {
                                int al3 = zzapn.mo7961al();
                                switch (al3) {
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
                                        iArr3[length5] = al3;
                                        length5++;
                                        break;
                                }
                            }
                            this.zzxc = iArr3;
                        }
                        zzapn.zzafs(zzafr);
                        continue;
                    case 90:
                        int zzc5 = zzapy.zzc(zzapn, 90);
                        int length6 = this.zzxb == null ? 0 : this.zzxb.length;
                        zza[] zzaArr4 = new zza[(zzc5 + length6)];
                        if (length6 != 0) {
                            System.arraycopy(this.zzxb, 0, zzaArr4, 0, length6);
                        }
                        while (length6 < zzaArr4.length - 1) {
                            zzaArr4[length6] = new zza();
                            zzapn.zza(zzaArr4[length6]);
                            zzapn.mo7957ah();
                            length6++;
                        }
                        zzaArr4[length6] = new zza();
                        zzapn.zza(zzaArr4[length6]);
                        this.zzxb = zzaArr4;
                        continue;
                    case C0515k.AppCompatTheme_alertDialogTheme:
                        this.zzxa = zzapn.mo7963an();
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
