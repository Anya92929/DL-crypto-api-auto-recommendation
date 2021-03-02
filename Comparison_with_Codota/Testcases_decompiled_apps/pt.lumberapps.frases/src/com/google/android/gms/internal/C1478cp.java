package com.google.android.gms.internal;

/* renamed from: com.google.android.gms.internal.cp */
final class C1478cp implements zzani {

    /* renamed from: a */
    final /* synthetic */ Class f4919a;

    /* renamed from: b */
    final /* synthetic */ zzanh f4920b;

    C1478cp(Class cls, zzanh zzanh) {
        this.f4919a = cls;
        this.f4920b = zzanh;
    }

    public String toString() {
        String valueOf = String.valueOf(this.f4919a.getName());
        String valueOf2 = String.valueOf(this.f4920b);
        return new StringBuilder(String.valueOf(valueOf).length() + 23 + String.valueOf(valueOf2).length()).append("Factory[type=").append(valueOf).append(",adapter=").append(valueOf2).append("]").toString();
    }

    public zzanh zza(zzamp zzamp, zzaol zzaol) {
        if (zzaol.mo7939m() == this.f4919a) {
            return this.f4920b;
        }
        return null;
    }
}
