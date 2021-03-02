package com.google.android.gms.internal;

/* renamed from: com.google.android.gms.internal.ct */
final class C1482ct implements zzani {

    /* renamed from: a */
    final /* synthetic */ Class f4927a;

    /* renamed from: b */
    final /* synthetic */ zzanh f4928b;

    C1482ct(Class cls, zzanh zzanh) {
        this.f4927a = cls;
        this.f4928b = zzanh;
    }

    public String toString() {
        String valueOf = String.valueOf(this.f4927a.getName());
        String valueOf2 = String.valueOf(this.f4928b);
        return new StringBuilder(String.valueOf(valueOf).length() + 32 + String.valueOf(valueOf2).length()).append("Factory[typeHierarchy=").append(valueOf).append(",adapter=").append(valueOf2).append("]").toString();
    }

    public zzanh zza(zzamp zzamp, zzaol zzaol) {
        if (this.f4927a.isAssignableFrom(zzaol.mo7939m())) {
            return this.f4928b;
        }
        return null;
    }
}
