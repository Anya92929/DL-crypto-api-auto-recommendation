package com.google.android.gms.internal;

import android.support.p009v4.app.NotificationCompat;
import android.support.p021v7.p023b.C0515k;

public interface zzae {

    public final class zza extends zzapp {
        public String zzcs = null;
        public String zzct = null;
        public Long zzcu = null;
        public Long zzcv = null;
        public Long zzcw = null;
        public Long zzcx = null;
        public Long zzcy = null;
        public Long zzcz = null;
        public Long zzda = null;
        public Long zzdb = null;
        public Long zzdc = null;
        public Long zzdd = null;
        public String zzde = null;
        public Long zzdf = null;
        public Long zzdg = null;
        public Long zzdh = null;
        public Long zzdi = null;
        public Long zzdj = null;
        public Long zzdk = null;
        public Long zzdl = null;
        public Long zzdm = null;
        public Long zzdn = null;
        public String zzdo = null;
        public String zzdp = null;
        public Long zzdq = null;
        public Long zzdr = null;
        public Long zzds = null;
        public String zzdt = null;
        public Long zzdu = null;
        public Long zzdv = null;
        public Long zzdw = null;
        public zzb zzdx;
        public Long zzdy = null;
        public Long zzdz = null;
        public Long zzea = null;
        public Long zzeb = null;
        public Long zzec = null;
        public Long zzed = null;
        public C2112zza[] zzee = C2112zza.zzy();
        public Long zzef = null;
        public String zzeg = null;
        public Integer zzeh = null;
        public Boolean zzei = null;
        public String zzej = null;
        public Long zzek = null;
        public zze zzel;

        /* renamed from: com.google.android.gms.internal.zzae$zza$zza  reason: collision with other inner class name */
        public final class C2112zza extends zzapp {

            /* renamed from: c */
            private static volatile C2112zza[] f5549c;
            public Long zzdf = null;
            public Long zzdg = null;

            public C2112zza() {
                this.f5906b = -1;
            }

            public static C2112zza[] zzy() {
                if (f5549c == null) {
                    synchronized (zzapt.bjF) {
                        if (f5549c == null) {
                            f5549c = new C2112zza[0];
                        }
                    }
                }
                return f5549c;
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public int mo7714a() {
                int a = super.mo7714a();
                if (this.zzdf != null) {
                    a += zzapo.zze(1, this.zzdf.longValue());
                }
                return this.zzdg != null ? a + zzapo.zze(2, this.zzdg.longValue()) : a;
            }

            public void zza(zzapo zzapo) {
                if (this.zzdf != null) {
                    zzapo.zzb(1, this.zzdf.longValue());
                }
                if (this.zzdg != null) {
                    zzapo.zzb(2, this.zzdg.longValue());
                }
                super.zza(zzapo);
            }

            /* renamed from: zzd */
            public C2112zza zzb(zzapn zzapn) {
                while (true) {
                    int ah = zzapn.mo7957ah();
                    switch (ah) {
                        case 0:
                            break;
                        case 8:
                            this.zzdf = Long.valueOf(zzapn.mo7960ak());
                            continue;
                        case 16:
                            this.zzdg = Long.valueOf(zzapn.mo7960ak());
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

        public zza() {
            this.f5906b = -1;
        }

        public static zza zzc(byte[] bArr) {
            return (zza) zzapv.zza(new zza(), bArr);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int mo7714a() {
            int a = super.mo7714a();
            if (this.zzct != null) {
                a += zzapo.zzs(1, this.zzct);
            }
            if (this.zzcs != null) {
                a += zzapo.zzs(2, this.zzcs);
            }
            if (this.zzcu != null) {
                a += zzapo.zze(3, this.zzcu.longValue());
            }
            if (this.zzcv != null) {
                a += zzapo.zze(4, this.zzcv.longValue());
            }
            if (this.zzcw != null) {
                a += zzapo.zze(5, this.zzcw.longValue());
            }
            if (this.zzcx != null) {
                a += zzapo.zze(6, this.zzcx.longValue());
            }
            if (this.zzcy != null) {
                a += zzapo.zze(7, this.zzcy.longValue());
            }
            if (this.zzcz != null) {
                a += zzapo.zze(8, this.zzcz.longValue());
            }
            if (this.zzda != null) {
                a += zzapo.zze(9, this.zzda.longValue());
            }
            if (this.zzdb != null) {
                a += zzapo.zze(10, this.zzdb.longValue());
            }
            if (this.zzdc != null) {
                a += zzapo.zze(11, this.zzdc.longValue());
            }
            if (this.zzdd != null) {
                a += zzapo.zze(12, this.zzdd.longValue());
            }
            if (this.zzde != null) {
                a += zzapo.zzs(13, this.zzde);
            }
            if (this.zzdf != null) {
                a += zzapo.zze(14, this.zzdf.longValue());
            }
            if (this.zzdg != null) {
                a += zzapo.zze(15, this.zzdg.longValue());
            }
            if (this.zzdh != null) {
                a += zzapo.zze(16, this.zzdh.longValue());
            }
            if (this.zzdi != null) {
                a += zzapo.zze(17, this.zzdi.longValue());
            }
            if (this.zzdj != null) {
                a += zzapo.zze(18, this.zzdj.longValue());
            }
            if (this.zzdk != null) {
                a += zzapo.zze(19, this.zzdk.longValue());
            }
            if (this.zzdl != null) {
                a += zzapo.zze(20, this.zzdl.longValue());
            }
            if (this.zzef != null) {
                a += zzapo.zze(21, this.zzef.longValue());
            }
            if (this.zzdm != null) {
                a += zzapo.zze(22, this.zzdm.longValue());
            }
            if (this.zzdn != null) {
                a += zzapo.zze(23, this.zzdn.longValue());
            }
            if (this.zzeg != null) {
                a += zzapo.zzs(24, this.zzeg);
            }
            if (this.zzek != null) {
                a += zzapo.zze(25, this.zzek.longValue());
            }
            if (this.zzeh != null) {
                a += zzapo.zzag(26, this.zzeh.intValue());
            }
            if (this.zzdo != null) {
                a += zzapo.zzs(27, this.zzdo);
            }
            if (this.zzei != null) {
                a += zzapo.zzk(28, this.zzei.booleanValue());
            }
            if (this.zzdp != null) {
                a += zzapo.zzs(29, this.zzdp);
            }
            if (this.zzej != null) {
                a += zzapo.zzs(30, this.zzej);
            }
            if (this.zzdq != null) {
                a += zzapo.zze(31, this.zzdq.longValue());
            }
            if (this.zzdr != null) {
                a += zzapo.zze(32, this.zzdr.longValue());
            }
            if (this.zzds != null) {
                a += zzapo.zze(33, this.zzds.longValue());
            }
            if (this.zzdt != null) {
                a += zzapo.zzs(34, this.zzdt);
            }
            if (this.zzdu != null) {
                a += zzapo.zze(35, this.zzdu.longValue());
            }
            if (this.zzdv != null) {
                a += zzapo.zze(36, this.zzdv.longValue());
            }
            if (this.zzdw != null) {
                a += zzapo.zze(37, this.zzdw.longValue());
            }
            if (this.zzdx != null) {
                a += zzapo.zzc(38, (zzapv) this.zzdx);
            }
            if (this.zzdy != null) {
                a += zzapo.zze(39, this.zzdy.longValue());
            }
            if (this.zzdz != null) {
                a += zzapo.zze(40, this.zzdz.longValue());
            }
            if (this.zzea != null) {
                a += zzapo.zze(41, this.zzea.longValue());
            }
            if (this.zzeb != null) {
                a += zzapo.zze(42, this.zzeb.longValue());
            }
            if (this.zzee != null && this.zzee.length > 0) {
                int i = a;
                for (C2112zza zza : this.zzee) {
                    if (zza != null) {
                        i += zzapo.zzc(43, (zzapv) zza);
                    }
                }
                a = i;
            }
            if (this.zzec != null) {
                a += zzapo.zze(44, this.zzec.longValue());
            }
            if (this.zzed != null) {
                a += zzapo.zze(45, this.zzed.longValue());
            }
            return this.zzel != null ? a + zzapo.zzc(201, (zzapv) this.zzel) : a;
        }

        public void zza(zzapo zzapo) {
            if (this.zzct != null) {
                zzapo.zzr(1, this.zzct);
            }
            if (this.zzcs != null) {
                zzapo.zzr(2, this.zzcs);
            }
            if (this.zzcu != null) {
                zzapo.zzb(3, this.zzcu.longValue());
            }
            if (this.zzcv != null) {
                zzapo.zzb(4, this.zzcv.longValue());
            }
            if (this.zzcw != null) {
                zzapo.zzb(5, this.zzcw.longValue());
            }
            if (this.zzcx != null) {
                zzapo.zzb(6, this.zzcx.longValue());
            }
            if (this.zzcy != null) {
                zzapo.zzb(7, this.zzcy.longValue());
            }
            if (this.zzcz != null) {
                zzapo.zzb(8, this.zzcz.longValue());
            }
            if (this.zzda != null) {
                zzapo.zzb(9, this.zzda.longValue());
            }
            if (this.zzdb != null) {
                zzapo.zzb(10, this.zzdb.longValue());
            }
            if (this.zzdc != null) {
                zzapo.zzb(11, this.zzdc.longValue());
            }
            if (this.zzdd != null) {
                zzapo.zzb(12, this.zzdd.longValue());
            }
            if (this.zzde != null) {
                zzapo.zzr(13, this.zzde);
            }
            if (this.zzdf != null) {
                zzapo.zzb(14, this.zzdf.longValue());
            }
            if (this.zzdg != null) {
                zzapo.zzb(15, this.zzdg.longValue());
            }
            if (this.zzdh != null) {
                zzapo.zzb(16, this.zzdh.longValue());
            }
            if (this.zzdi != null) {
                zzapo.zzb(17, this.zzdi.longValue());
            }
            if (this.zzdj != null) {
                zzapo.zzb(18, this.zzdj.longValue());
            }
            if (this.zzdk != null) {
                zzapo.zzb(19, this.zzdk.longValue());
            }
            if (this.zzdl != null) {
                zzapo.zzb(20, this.zzdl.longValue());
            }
            if (this.zzef != null) {
                zzapo.zzb(21, this.zzef.longValue());
            }
            if (this.zzdm != null) {
                zzapo.zzb(22, this.zzdm.longValue());
            }
            if (this.zzdn != null) {
                zzapo.zzb(23, this.zzdn.longValue());
            }
            if (this.zzeg != null) {
                zzapo.zzr(24, this.zzeg);
            }
            if (this.zzek != null) {
                zzapo.zzb(25, this.zzek.longValue());
            }
            if (this.zzeh != null) {
                zzapo.zzae(26, this.zzeh.intValue());
            }
            if (this.zzdo != null) {
                zzapo.zzr(27, this.zzdo);
            }
            if (this.zzei != null) {
                zzapo.zzj(28, this.zzei.booleanValue());
            }
            if (this.zzdp != null) {
                zzapo.zzr(29, this.zzdp);
            }
            if (this.zzej != null) {
                zzapo.zzr(30, this.zzej);
            }
            if (this.zzdq != null) {
                zzapo.zzb(31, this.zzdq.longValue());
            }
            if (this.zzdr != null) {
                zzapo.zzb(32, this.zzdr.longValue());
            }
            if (this.zzds != null) {
                zzapo.zzb(33, this.zzds.longValue());
            }
            if (this.zzdt != null) {
                zzapo.zzr(34, this.zzdt);
            }
            if (this.zzdu != null) {
                zzapo.zzb(35, this.zzdu.longValue());
            }
            if (this.zzdv != null) {
                zzapo.zzb(36, this.zzdv.longValue());
            }
            if (this.zzdw != null) {
                zzapo.zzb(37, this.zzdw.longValue());
            }
            if (this.zzdx != null) {
                zzapo.zza(38, (zzapv) this.zzdx);
            }
            if (this.zzdy != null) {
                zzapo.zzb(39, this.zzdy.longValue());
            }
            if (this.zzdz != null) {
                zzapo.zzb(40, this.zzdz.longValue());
            }
            if (this.zzea != null) {
                zzapo.zzb(41, this.zzea.longValue());
            }
            if (this.zzeb != null) {
                zzapo.zzb(42, this.zzeb.longValue());
            }
            if (this.zzee != null && this.zzee.length > 0) {
                for (C2112zza zza : this.zzee) {
                    if (zza != null) {
                        zzapo.zza(43, (zzapv) zza);
                    }
                }
            }
            if (this.zzec != null) {
                zzapo.zzb(44, this.zzec.longValue());
            }
            if (this.zzed != null) {
                zzapo.zzb(45, this.zzed.longValue());
            }
            if (this.zzel != null) {
                zzapo.zza(201, (zzapv) this.zzel);
            }
            super.zza(zzapo);
        }

        /* renamed from: zzc */
        public zza zzb(zzapn zzapn) {
            while (true) {
                int ah = zzapn.mo7957ah();
                switch (ah) {
                    case 0:
                        break;
                    case 10:
                        this.zzct = zzapn.readString();
                        continue;
                    case 18:
                        this.zzcs = zzapn.readString();
                        continue;
                    case 24:
                        this.zzcu = Long.valueOf(zzapn.mo7960ak());
                        continue;
                    case 32:
                        this.zzcv = Long.valueOf(zzapn.mo7960ak());
                        continue;
                    case C0515k.AppCompatTheme_textAppearanceLargePopupMenu:
                        this.zzcw = Long.valueOf(zzapn.mo7960ak());
                        continue;
                    case C0515k.AppCompatTheme_spinnerDropDownItemStyle:
                        this.zzcx = Long.valueOf(zzapn.mo7960ak());
                        continue;
                    case C0515k.AppCompatTheme_dividerVertical:
                        this.zzcy = Long.valueOf(zzapn.mo7960ak());
                        continue;
                    case 64:
                        this.zzcz = Long.valueOf(zzapn.mo7960ak());
                        continue;
                    case C0515k.AppCompatTheme_listPreferredItemHeightLarge:
                        this.zzda = Long.valueOf(zzapn.mo7960ak());
                        continue;
                    case C0515k.AppCompatTheme_panelMenuListWidth:
                        this.zzdb = Long.valueOf(zzapn.mo7960ak());
                        continue;
                    case C0515k.AppCompatTheme_colorControlHighlight:
                        this.zzdc = Long.valueOf(zzapn.mo7960ak());
                        continue;
                    case C0515k.AppCompatTheme_alertDialogTheme:
                        this.zzdd = Long.valueOf(zzapn.mo7960ak());
                        continue;
                    case C0515k.AppCompatTheme_editTextStyle:
                        this.zzde = zzapn.readString();
                        continue;
                    case C0515k.AppCompatTheme_spinnerStyle:
                        this.zzdf = Long.valueOf(zzapn.mo7960ak());
                        continue;
                    case 120:
                        this.zzdg = Long.valueOf(zzapn.mo7960ak());
                        continue;
                    case NotificationCompat.FLAG_HIGH_PRIORITY:
                        this.zzdh = Long.valueOf(zzapn.mo7960ak());
                        continue;
                    case 136:
                        this.zzdi = Long.valueOf(zzapn.mo7960ak());
                        continue;
                    case 144:
                        this.zzdj = Long.valueOf(zzapn.mo7960ak());
                        continue;
                    case 152:
                        this.zzdk = Long.valueOf(zzapn.mo7960ak());
                        continue;
                    case 160:
                        this.zzdl = Long.valueOf(zzapn.mo7960ak());
                        continue;
                    case 168:
                        this.zzef = Long.valueOf(zzapn.mo7960ak());
                        continue;
                    case 176:
                        this.zzdm = Long.valueOf(zzapn.mo7960ak());
                        continue;
                    case 184:
                        this.zzdn = Long.valueOf(zzapn.mo7960ak());
                        continue;
                    case 194:
                        this.zzeg = zzapn.readString();
                        continue;
                    case 200:
                        this.zzek = Long.valueOf(zzapn.mo7960ak());
                        continue;
                    case 208:
                        int al = zzapn.mo7961al();
                        switch (al) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                                this.zzeh = Integer.valueOf(al);
                                break;
                            default:
                                continue;
                        }
                    case 218:
                        this.zzdo = zzapn.readString();
                        continue;
                    case 224:
                        this.zzei = Boolean.valueOf(zzapn.mo7963an());
                        continue;
                    case 234:
                        this.zzdp = zzapn.readString();
                        continue;
                    case 242:
                        this.zzej = zzapn.readString();
                        continue;
                    case 248:
                        this.zzdq = Long.valueOf(zzapn.mo7960ak());
                        continue;
                    case NotificationCompat.FLAG_LOCAL_ONLY:
                        this.zzdr = Long.valueOf(zzapn.mo7960ak());
                        continue;
                    case 264:
                        this.zzds = Long.valueOf(zzapn.mo7960ak());
                        continue;
                    case 274:
                        this.zzdt = zzapn.readString();
                        continue;
                    case 280:
                        this.zzdu = Long.valueOf(zzapn.mo7960ak());
                        continue;
                    case 288:
                        this.zzdv = Long.valueOf(zzapn.mo7960ak());
                        continue;
                    case 296:
                        this.zzdw = Long.valueOf(zzapn.mo7960ak());
                        continue;
                    case 306:
                        if (this.zzdx == null) {
                            this.zzdx = new zzb();
                        }
                        zzapn.zza(this.zzdx);
                        continue;
                    case 312:
                        this.zzdy = Long.valueOf(zzapn.mo7960ak());
                        continue;
                    case 320:
                        this.zzdz = Long.valueOf(zzapn.mo7960ak());
                        continue;
                    case 328:
                        this.zzea = Long.valueOf(zzapn.mo7960ak());
                        continue;
                    case 336:
                        this.zzeb = Long.valueOf(zzapn.mo7960ak());
                        continue;
                    case 346:
                        int zzc = zzapy.zzc(zzapn, 346);
                        int length = this.zzee == null ? 0 : this.zzee.length;
                        C2112zza[] zzaArr = new C2112zza[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzee, 0, zzaArr, 0, length);
                        }
                        while (length < zzaArr.length - 1) {
                            zzaArr[length] = new C2112zza();
                            zzapn.zza(zzaArr[length]);
                            zzapn.mo7957ah();
                            length++;
                        }
                        zzaArr[length] = new C2112zza();
                        zzapn.zza(zzaArr[length]);
                        this.zzee = zzaArr;
                        continue;
                    case 352:
                        this.zzec = Long.valueOf(zzapn.mo7960ak());
                        continue;
                    case 360:
                        this.zzed = Long.valueOf(zzapn.mo7960ak());
                        continue;
                    case 1610:
                        if (this.zzel == null) {
                            this.zzel = new zze();
                        }
                        zzapn.zza(this.zzel);
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
        public Long zzen = null;
        public Integer zzeo = null;
        public Boolean zzep = null;
        public int[] zzeq = zzapy.bjH;

        public zzb() {
            this.f5906b = -1;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int mo7714a() {
            int a = super.mo7714a();
            if (this.zzen != null) {
                a += zzapo.zze(1, this.zzen.longValue());
            }
            if (this.zzeo != null) {
                a += zzapo.zzag(2, this.zzeo.intValue());
            }
            if (this.zzep != null) {
                a += zzapo.zzk(3, this.zzep.booleanValue());
            }
            if (this.zzeq == null || this.zzeq.length <= 0) {
                return a;
            }
            int i = 0;
            for (int zzafx : this.zzeq) {
                i += zzapo.zzafx(zzafx);
            }
            return a + i + (this.zzeq.length * 1);
        }

        public void zza(zzapo zzapo) {
            if (this.zzen != null) {
                zzapo.zzb(1, this.zzen.longValue());
            }
            if (this.zzeo != null) {
                zzapo.zzae(2, this.zzeo.intValue());
            }
            if (this.zzep != null) {
                zzapo.zzj(3, this.zzep.booleanValue());
            }
            if (this.zzeq != null && this.zzeq.length > 0) {
                for (int zzae : this.zzeq) {
                    zzapo.zzae(4, zzae);
                }
            }
            super.zza(zzapo);
        }

        /* renamed from: zze */
        public zzb zzb(zzapn zzapn) {
            while (true) {
                int ah = zzapn.mo7957ah();
                switch (ah) {
                    case 0:
                        break;
                    case 8:
                        this.zzen = Long.valueOf(zzapn.mo7960ak());
                        continue;
                    case 16:
                        this.zzeo = Integer.valueOf(zzapn.mo7961al());
                        continue;
                    case 24:
                        this.zzep = Boolean.valueOf(zzapn.mo7963an());
                        continue;
                    case 32:
                        int zzc = zzapy.zzc(zzapn, 32);
                        int length = this.zzeq == null ? 0 : this.zzeq.length;
                        int[] iArr = new int[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzeq, 0, iArr, 0, length);
                        }
                        while (length < iArr.length - 1) {
                            iArr[length] = zzapn.mo7961al();
                            zzapn.mo7957ah();
                            length++;
                        }
                        iArr[length] = zzapn.mo7961al();
                        this.zzeq = iArr;
                        continue;
                    case C0515k.AppCompatTheme_actionModePasteDrawable:
                        int zzafr = zzapn.zzafr(zzapn.mo7966aq());
                        int position = zzapn.getPosition();
                        int i = 0;
                        while (zzapn.mo7970av() > 0) {
                            zzapn.mo7961al();
                            i++;
                        }
                        zzapn.zzaft(position);
                        int length2 = this.zzeq == null ? 0 : this.zzeq.length;
                        int[] iArr2 = new int[(i + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.zzeq, 0, iArr2, 0, length2);
                        }
                        while (length2 < iArr2.length) {
                            iArr2[length2] = zzapn.mo7961al();
                            length2++;
                        }
                        this.zzeq = iArr2;
                        zzapn.zzafs(zzafr);
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
        public byte[] zzer = null;
        public byte[] zzes = null;

        public zzc() {
            this.f5906b = -1;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int mo7714a() {
            int a = super.mo7714a();
            if (this.zzer != null) {
                a += zzapo.zzb(1, this.zzer);
            }
            return this.zzes != null ? a + zzapo.zzb(2, this.zzes) : a;
        }

        public void zza(zzapo zzapo) {
            if (this.zzer != null) {
                zzapo.zza(1, this.zzer);
            }
            if (this.zzes != null) {
                zzapo.zza(2, this.zzes);
            }
            super.zza(zzapo);
        }

        /* renamed from: zzf */
        public zzc zzb(zzapn zzapn) {
            while (true) {
                int ah = zzapn.mo7957ah();
                switch (ah) {
                    case 0:
                        break;
                    case 10:
                        this.zzer = zzapn.readBytes();
                        continue;
                    case 18:
                        this.zzes = zzapn.readBytes();
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
        public byte[] data = null;
        public byte[] zzet = null;
        public byte[] zzeu = null;
        public byte[] zzev = null;

        public zzd() {
            this.f5906b = -1;
        }

        public static zzd zzd(byte[] bArr) {
            return (zzd) zzapv.zza(new zzd(), bArr);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int mo7714a() {
            int a = super.mo7714a();
            if (this.data != null) {
                a += zzapo.zzb(1, this.data);
            }
            if (this.zzet != null) {
                a += zzapo.zzb(2, this.zzet);
            }
            if (this.zzeu != null) {
                a += zzapo.zzb(3, this.zzeu);
            }
            return this.zzev != null ? a + zzapo.zzb(4, this.zzev) : a;
        }

        public void zza(zzapo zzapo) {
            if (this.data != null) {
                zzapo.zza(1, this.data);
            }
            if (this.zzet != null) {
                zzapo.zza(2, this.zzet);
            }
            if (this.zzeu != null) {
                zzapo.zza(3, this.zzeu);
            }
            if (this.zzev != null) {
                zzapo.zza(4, this.zzev);
            }
            super.zza(zzapo);
        }

        /* renamed from: zzg */
        public zzd zzb(zzapn zzapn) {
            while (true) {
                int ah = zzapn.mo7957ah();
                switch (ah) {
                    case 0:
                        break;
                    case 10:
                        this.data = zzapn.readBytes();
                        continue;
                    case 18:
                        this.zzet = zzapn.readBytes();
                        continue;
                    case 26:
                        this.zzeu = zzapn.readBytes();
                        continue;
                    case C0515k.AppCompatTheme_actionModePasteDrawable:
                        this.zzev = zzapn.readBytes();
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
        public Long zzen = null;
        public String zzew = null;
        public byte[] zzex = null;

        public zze() {
            this.f5906b = -1;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int mo7714a() {
            int a = super.mo7714a();
            if (this.zzen != null) {
                a += zzapo.zze(1, this.zzen.longValue());
            }
            if (this.zzew != null) {
                a += zzapo.zzs(3, this.zzew);
            }
            return this.zzex != null ? a + zzapo.zzb(4, this.zzex) : a;
        }

        public void zza(zzapo zzapo) {
            if (this.zzen != null) {
                zzapo.zzb(1, this.zzen.longValue());
            }
            if (this.zzew != null) {
                zzapo.zzr(3, this.zzew);
            }
            if (this.zzex != null) {
                zzapo.zza(4, this.zzex);
            }
            super.zza(zzapo);
        }

        /* renamed from: zzh */
        public zze zzb(zzapn zzapn) {
            while (true) {
                int ah = zzapn.mo7957ah();
                switch (ah) {
                    case 0:
                        break;
                    case 8:
                        this.zzen = Long.valueOf(zzapn.mo7960ak());
                        continue;
                    case 26:
                        this.zzew = zzapn.readString();
                        continue;
                    case C0515k.AppCompatTheme_actionModePasteDrawable:
                        this.zzex = zzapn.readBytes();
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
        public byte[] zzet = null;
        public byte[][] zzey = zzapy.bjN;
        public Integer zzez = null;
        public Integer zzfa = null;

        public zzf() {
            this.f5906b = -1;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int mo7714a() {
            int i;
            int a = super.mo7714a();
            if (this.zzey == null || this.zzey.length <= 0) {
                i = a;
            } else {
                int i2 = 0;
                int i3 = 0;
                for (byte[] bArr : this.zzey) {
                    if (bArr != null) {
                        i3++;
                        i2 += zzapo.zzbg(bArr);
                    }
                }
                i = a + i2 + (i3 * 1);
            }
            if (this.zzet != null) {
                i += zzapo.zzb(2, this.zzet);
            }
            if (this.zzez != null) {
                i += zzapo.zzag(3, this.zzez.intValue());
            }
            return this.zzfa != null ? i + zzapo.zzag(4, this.zzfa.intValue()) : i;
        }

        public void zza(zzapo zzapo) {
            if (this.zzey != null && this.zzey.length > 0) {
                for (byte[] bArr : this.zzey) {
                    if (bArr != null) {
                        zzapo.zza(1, bArr);
                    }
                }
            }
            if (this.zzet != null) {
                zzapo.zza(2, this.zzet);
            }
            if (this.zzez != null) {
                zzapo.zzae(3, this.zzez.intValue());
            }
            if (this.zzfa != null) {
                zzapo.zzae(4, this.zzfa.intValue());
            }
            super.zza(zzapo);
        }

        /* renamed from: zzi */
        public zzf zzb(zzapn zzapn) {
            while (true) {
                int ah = zzapn.mo7957ah();
                switch (ah) {
                    case 0:
                        break;
                    case 10:
                        int zzc = zzapy.zzc(zzapn, 10);
                        int length = this.zzey == null ? 0 : this.zzey.length;
                        byte[][] bArr = new byte[(zzc + length)][];
                        if (length != 0) {
                            System.arraycopy(this.zzey, 0, bArr, 0, length);
                        }
                        while (length < bArr.length - 1) {
                            bArr[length] = zzapn.readBytes();
                            zzapn.mo7957ah();
                            length++;
                        }
                        bArr[length] = zzapn.readBytes();
                        this.zzey = bArr;
                        continue;
                    case 18:
                        this.zzet = zzapn.readBytes();
                        continue;
                    case 24:
                        int al = zzapn.mo7961al();
                        switch (al) {
                            case 0:
                            case 1:
                                this.zzez = Integer.valueOf(al);
                                break;
                            default:
                                continue;
                        }
                    case 32:
                        int al2 = zzapn.mo7961al();
                        switch (al2) {
                            case 0:
                            case 1:
                                this.zzfa = Integer.valueOf(al2);
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
