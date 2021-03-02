package com.google.android.gms.internal;

/* renamed from: com.google.android.gms.internal.aj */
class C1418aj implements zzani {

    /* renamed from: a */
    private final zzaol f4828a;

    /* renamed from: b */
    private final boolean f4829b;

    /* renamed from: c */
    private final Class f4830c;

    /* renamed from: d */
    private final zzand f4831d;

    /* renamed from: e */
    private final zzamu f4832e;

    private C1418aj(Object obj, zzaol zzaol, boolean z, Class cls) {
        this.f4831d = obj instanceof zzand ? (zzand) obj : null;
        this.f4832e = obj instanceof zzamu ? (zzamu) obj : null;
        zzann.zzbo((this.f4831d == null && this.f4832e == null) ? false : true);
        this.f4828a = zzaol;
        this.f4829b = z;
        this.f4830c = cls;
    }

    public zzanh zza(zzamp zzamp, zzaol zzaol) {
        if (this.f4828a != null ? this.f4828a.equals(zzaol) || (this.f4829b && this.f4828a.mo7940n() == zzaol.mo7939m()) : this.f4830c.isAssignableFrom(zzaol.mo7939m())) {
            return new C1416ah(this.f4831d, this.f4832e, zzamp, zzaol, this);
        }
        return null;
    }
}
