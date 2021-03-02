package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzla;

@zzin
public class zzfs {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Object f6193a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Context f6194b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final String f6195c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final VersionInfoParcel f6196d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public zzkl f6197e;

    /* renamed from: f */
    private zzkl f6198f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public zzd f6199g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f6200h;

    public class zzb implements zzkl {
        public void zzd(Object obj) {
        }
    }

    public class zzc extends zzlb {

        /* renamed from: d */
        private final Object f6201d = new Object();
        /* access modifiers changed from: private */

        /* renamed from: e */
        public final zzd f6202e;

        /* renamed from: f */
        private boolean f6203f;

        public zzc(zzd zzd) {
            this.f6202e = zzd;
        }

        public void release() {
            synchronized (this.f6201d) {
                if (!this.f6203f) {
                    this.f6203f = true;
                    zza(new C1628id(this), new zzla.zzb());
                    zza(new C1629ie(this), new C1630if(this));
                }
            }
        }
    }

    public class zzd extends zzlb {

        /* renamed from: d */
        private final Object f6204d = new Object();
        /* access modifiers changed from: private */

        /* renamed from: e */
        public zzkl f6205e;

        /* renamed from: f */
        private boolean f6206f;

        /* renamed from: g */
        private int f6207g;

        public zzd(zzkl zzkl) {
            this.f6205e = zzkl;
            this.f6206f = false;
            this.f6207g = 0;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo8390a() {
            boolean z = true;
            synchronized (this.f6204d) {
                if (this.f6207g < 1) {
                    z = false;
                }
                zzab.zzbn(z);
                zzkd.m7303v("Releasing 1 reference for JS Engine");
                this.f6207g--;
                mo8391b();
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void mo8391b() {
            synchronized (this.f6204d) {
                zzab.zzbn(this.f6207g >= 0);
                if (!this.f6206f || this.f6207g != 0) {
                    zzkd.m7303v("There are still references to the engine. Not destroying.");
                } else {
                    zzkd.m7303v("No reference is left (including root). Cleaning up engine.");
                    zza(new C1633ii(this), new zzla.zzb());
                }
            }
        }

        public zzc zzmb() {
            zzc zzc = new zzc(this);
            synchronized (this.f6204d) {
                zza(new C1631ig(this, zzc), new C1632ih(this, zzc));
                zzab.zzbn(this.f6207g >= 0);
                this.f6207g++;
            }
            return zzc;
        }

        public void zzmd() {
            boolean z = true;
            synchronized (this.f6204d) {
                if (this.f6207g < 0) {
                    z = false;
                }
                zzab.zzbn(z);
                zzkd.m7303v("Releasing root reference. JS Engine will be destroyed once other references are released.");
                this.f6206f = true;
                mo8391b();
            }
        }
    }

    public class zze extends zzlb {

        /* renamed from: d */
        private zzc f6208d;

        public zze(zzc zzc) {
            this.f6208d = zzc;
        }

        public void finalize() {
            this.f6208d.release();
            this.f6208d = null;
        }

        public int getStatus() {
            return this.f6208d.getStatus();
        }

        public void reject() {
            this.f6208d.reject();
        }

        public void zza(zzla.zzc zzc, zzla.zza zza) {
            this.f6208d.zza(zzc, zza);
        }

        /* renamed from: zzf */
        public void zzg(zzft zzft) {
            this.f6208d.zzg(zzft);
        }
    }

    public zzfs(Context context, VersionInfoParcel versionInfoParcel, String str) {
        this.f6193a = new Object();
        this.f6200h = 1;
        this.f6195c = str;
        this.f6194b = context.getApplicationContext();
        this.f6196d = versionInfoParcel;
        this.f6197e = new zzb();
        this.f6198f = new zzb();
    }

    public zzfs(Context context, VersionInfoParcel versionInfoParcel, String str, zzkl zzkl, zzkl zzkl2) {
        this(context, versionInfoParcel, str);
        this.f6197e = zzkl;
        this.f6198f = zzkl2;
    }

    /* renamed from: b */
    private zzd m7059b(zzas zzas) {
        zzd zzd2 = new zzd(this.f6198f);
        zzu.zzfq().runOnUiThread(new C1616hs(this, zzas, zzd2));
        return zzd2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public zzfp mo8385a(Context context, VersionInfoParcel versionInfoParcel, zzas zzas) {
        return new zzfr(context, versionInfoParcel, zzas);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public zzd mo8386a(zzas zzas) {
        zzd b = m7059b(zzas);
        b.zza(new C1625ia(this, b), new C1626ib(this, b));
        return b;
    }

    public zzc zzc(zzas zzas) {
        zzc zzc2;
        synchronized (this.f6193a) {
            if (this.f6199g == null || this.f6199g.getStatus() == -1) {
                this.f6200h = 2;
                this.f6199g = mo8386a(zzas);
                zzc2 = this.f6199g.zzmb();
            } else if (this.f6200h == 0) {
                zzc2 = this.f6199g.zzmb();
            } else if (this.f6200h == 1) {
                this.f6200h = 2;
                mo8386a(zzas);
                zzc2 = this.f6199g.zzmb();
            } else {
                zzc2 = this.f6200h == 2 ? this.f6199g.zzmb() : this.f6199g.zzmb();
            }
        }
        return zzc2;
    }

    public zzc zzma() {
        return zzc((zzas) null);
    }
}
