package com.google.android.gms.internal;

/* renamed from: com.google.android.gms.internal.az */
class C1434az extends zzanh {

    /* renamed from: a */
    final /* synthetic */ boolean f4860a;

    /* renamed from: b */
    final /* synthetic */ boolean f4861b;

    /* renamed from: c */
    final /* synthetic */ zzamp f4862c;

    /* renamed from: d */
    final /* synthetic */ zzaol f4863d;

    /* renamed from: e */
    final /* synthetic */ zzanq f4864e;

    /* renamed from: f */
    private zzanh f4865f;

    C1434az(zzanq zzanq, boolean z, boolean z2, zzamp zzamp, zzaol zzaol) {
        this.f4864e = zzanq;
        this.f4860a = z;
        this.f4861b = z2;
        this.f4862c = zzamp;
        this.f4863d = zzaol;
    }

    /* renamed from: a */
    private zzanh m6272a() {
        zzanh zzanh = this.f4865f;
        if (zzanh != null) {
            return zzanh;
        }
        zzanh zza = this.f4862c.zza((zzani) this.f4864e, this.f4863d);
        this.f4865f = zza;
        return zza;
    }

    public void zza(zzaoo zzaoo, Object obj) {
        if (this.f4861b) {
            zzaoo.mo7926l();
        } else {
            m6272a().zza(zzaoo, obj);
        }
    }

    public Object zzb(zzaom zzaom) {
        if (!this.f4860a) {
            return m6272a().zzb(zzaom);
        }
        zzaom.skipValue();
        return null;
    }
}
