package com.google.android.gms.internal;

import android.support.p021v7.p023b.C0515k;

public interface zzad {

    public final class zza extends zzapp {
        public String stackTrace = null;
        public String zzck = null;
        public Long zzcl = null;
        public String zzcm = null;
        public String zzcn = null;
        public Long zzco = null;
        public Long zzcp = null;
        public String zzcq = null;
        public Long zzcr = null;
        public String zzcs = null;

        public zza() {
            this.f5906b = -1;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int mo7714a() {
            int a = super.mo7714a();
            if (this.zzck != null) {
                a += zzapo.zzs(1, this.zzck);
            }
            if (this.zzcl != null) {
                a += zzapo.zze(2, this.zzcl.longValue());
            }
            if (this.stackTrace != null) {
                a += zzapo.zzs(3, this.stackTrace);
            }
            if (this.zzcm != null) {
                a += zzapo.zzs(4, this.zzcm);
            }
            if (this.zzcn != null) {
                a += zzapo.zzs(5, this.zzcn);
            }
            if (this.zzco != null) {
                a += zzapo.zze(6, this.zzco.longValue());
            }
            if (this.zzcp != null) {
                a += zzapo.zze(7, this.zzcp.longValue());
            }
            if (this.zzcq != null) {
                a += zzapo.zzs(8, this.zzcq);
            }
            if (this.zzcr != null) {
                a += zzapo.zze(9, this.zzcr.longValue());
            }
            return this.zzcs != null ? a + zzapo.zzs(10, this.zzcs) : a;
        }

        /* renamed from: zza */
        public zza zzb(zzapn zzapn) {
            while (true) {
                int ah = zzapn.mo7957ah();
                switch (ah) {
                    case 0:
                        break;
                    case 10:
                        this.zzck = zzapn.readString();
                        continue;
                    case 16:
                        this.zzcl = Long.valueOf(zzapn.mo7960ak());
                        continue;
                    case 26:
                        this.stackTrace = zzapn.readString();
                        continue;
                    case C0515k.AppCompatTheme_actionModePasteDrawable:
                        this.zzcm = zzapn.readString();
                        continue;
                    case C0515k.AppCompatTheme_textAppearancePopupMenuHeader:
                        this.zzcn = zzapn.readString();
                        continue;
                    case C0515k.AppCompatTheme_spinnerDropDownItemStyle:
                        this.zzco = Long.valueOf(zzapn.mo7960ak());
                        continue;
                    case C0515k.AppCompatTheme_dividerVertical:
                        this.zzcp = Long.valueOf(zzapn.mo7960ak());
                        continue;
                    case C0515k.AppCompatTheme_textAppearanceSearchResultTitle:
                        this.zzcq = zzapn.readString();
                        continue;
                    case C0515k.AppCompatTheme_listPreferredItemHeightLarge:
                        this.zzcr = Long.valueOf(zzapn.mo7960ak());
                        continue;
                    case C0515k.AppCompatTheme_listChoiceBackgroundIndicator:
                        this.zzcs = zzapn.readString();
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

        public void zza(zzapo zzapo) {
            if (this.zzck != null) {
                zzapo.zzr(1, this.zzck);
            }
            if (this.zzcl != null) {
                zzapo.zzb(2, this.zzcl.longValue());
            }
            if (this.stackTrace != null) {
                zzapo.zzr(3, this.stackTrace);
            }
            if (this.zzcm != null) {
                zzapo.zzr(4, this.zzcm);
            }
            if (this.zzcn != null) {
                zzapo.zzr(5, this.zzcn);
            }
            if (this.zzco != null) {
                zzapo.zzb(6, this.zzco.longValue());
            }
            if (this.zzcp != null) {
                zzapo.zzb(7, this.zzcp.longValue());
            }
            if (this.zzcq != null) {
                zzapo.zzr(8, this.zzcq);
            }
            if (this.zzcr != null) {
                zzapo.zzb(9, this.zzcr.longValue());
            }
            if (this.zzcs != null) {
                zzapo.zzr(10, this.zzcs);
            }
            super.zza(zzapo);
        }
    }
}
