package com.google.android.gms.internal;

import com.google.android.gms.internal.zzah;

public interface zzadu {

    public final class zza extends zzapp {
        public long aCV;
        public zzah.zzj aCW;
        public zzah.zzf zzwr;

        public zza() {
            zzcgx();
        }

        public static zza zzao(byte[] bArr) {
            return (zza) zzapv.zza(new zza(), bArr);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int mo7714a() {
            int a = super.mo7714a() + zzapo.zze(1, this.aCV);
            if (this.zzwr != null) {
                a += zzapo.zzc(2, (zzapv) this.zzwr);
            }
            return this.aCW != null ? a + zzapo.zzc(3, (zzapv) this.aCW) : a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza = (zza) obj;
            if (this.aCV != zza.aCV) {
                return false;
            }
            if (this.zzwr == null) {
                if (zza.zzwr != null) {
                    return false;
                }
            } else if (!this.zzwr.equals(zza.zzwr)) {
                return false;
            }
            if (this.aCW == null) {
                if (zza.aCW != null) {
                    return false;
                }
            } else if (!this.aCW.equals(zza.aCW)) {
                return false;
            }
            return (this.f5895a == null || this.f5895a.isEmpty()) ? zza.f5895a == null || zza.f5895a.isEmpty() : this.f5895a.equals(zza.f5895a);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.aCW == null ? 0 : this.aCW.hashCode()) + (((this.zzwr == null ? 0 : this.zzwr.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + ((int) (this.aCV ^ (this.aCV >>> 32)))) * 31)) * 31)) * 31;
            if (this.f5895a != null && !this.f5895a.isEmpty()) {
                i = this.f5895a.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzapo zzapo) {
            zzapo.zzb(1, this.aCV);
            if (this.zzwr != null) {
                zzapo.zza(2, (zzapv) this.zzwr);
            }
            if (this.aCW != null) {
                zzapo.zza(3, (zzapv) this.aCW);
            }
            super.zza(zzapo);
        }

        /* renamed from: zzas */
        public zza zzb(zzapn zzapn) {
            while (true) {
                int ah = zzapn.mo7957ah();
                switch (ah) {
                    case 0:
                        break;
                    case 8:
                        this.aCV = zzapn.mo7960ak();
                        continue;
                    case 18:
                        if (this.zzwr == null) {
                            this.zzwr = new zzah.zzf();
                        }
                        zzapn.zza(this.zzwr);
                        continue;
                    case 26:
                        if (this.aCW == null) {
                            this.aCW = new zzah.zzj();
                        }
                        zzapn.zza(this.aCW);
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

        public zza zzcgx() {
            this.aCV = 0;
            this.zzwr = null;
            this.aCW = null;
            this.f5895a = null;
            this.f5906b = -1;
            return this;
        }
    }
}
