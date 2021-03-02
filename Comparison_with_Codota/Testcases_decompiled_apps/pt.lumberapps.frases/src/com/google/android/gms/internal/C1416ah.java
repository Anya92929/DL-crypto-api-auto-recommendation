package com.google.android.gms.internal;

/* renamed from: com.google.android.gms.internal.ah */
final class C1416ah extends zzanh {

    /* renamed from: a */
    private final zzand f4822a;

    /* renamed from: b */
    private final zzamu f4823b;

    /* renamed from: c */
    private final zzamp f4824c;

    /* renamed from: d */
    private final zzaol f4825d;

    /* renamed from: e */
    private final zzani f4826e;

    /* renamed from: f */
    private zzanh f4827f;

    private C1416ah(zzand zzand, zzamu zzamu, zzamp zzamp, zzaol zzaol, zzani zzani) {
        this.f4822a = zzand;
        this.f4823b = zzamu;
        this.f4824c = zzamp;
        this.f4825d = zzaol;
        this.f4826e = zzani;
    }

    /* renamed from: a */
    private zzanh m6269a() {
        zzanh zzanh = this.f4827f;
        if (zzanh != null) {
            return zzanh;
        }
        zzanh zza = this.f4824c.zza(this.f4826e, this.f4825d);
        this.f4827f = zza;
        return zza;
    }

    /* renamed from: a */
    public static zzani m6270a(zzaol zzaol, Object obj) {
        return new C1418aj(obj, zzaol, false, (Class) null);
    }

    /* renamed from: b */
    public static zzani m6271b(zzaol zzaol, Object obj) {
        return new C1418aj(obj, zzaol, zzaol.mo7940n() == zzaol.mo7939m(), (Class) null);
    }

    public void zza(zzaoo zzaoo, Object obj) {
        if (this.f4822a == null) {
            m6269a().zza(zzaoo, obj);
        } else if (obj == null) {
            zzaoo.mo7926l();
        } else {
            zzanw.zzb(this.f4822a.zza(obj, this.f4825d.mo7940n(), this.f4824c.f5772b), zzaoo);
        }
    }

    public Object zzb(zzaom zzaom) {
        if (this.f4823b == null) {
            return m6269a().zzb(zzaom);
        }
        zzamv zzh = zzanw.zzh(zzaom);
        if (zzh.zzczj()) {
            return null;
        }
        try {
            return this.f4823b.zzb(zzh, this.f4825d.mo7940n(), this.f4824c.f5771a);
        } catch (zzamz e) {
            throw e;
        } catch (Exception e2) {
            throw new zzamz((Throwable) e2);
        }
    }
}
