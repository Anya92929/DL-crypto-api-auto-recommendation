package com.google.android.gms.internal;

/* renamed from: com.google.android.gms.internal.cs */
final class C1481cs implements zzani {

    /* renamed from: a */
    final /* synthetic */ Class f4924a;

    /* renamed from: b */
    final /* synthetic */ Class f4925b;

    /* renamed from: c */
    final /* synthetic */ zzanh f4926c;

    C1481cs(Class cls, Class cls2, zzanh zzanh) {
        this.f4924a = cls;
        this.f4925b = cls2;
        this.f4926c = zzanh;
    }

    public String toString() {
        String valueOf = String.valueOf(this.f4924a.getName());
        String valueOf2 = String.valueOf(this.f4925b.getName());
        String valueOf3 = String.valueOf(this.f4926c);
        return new StringBuilder(String.valueOf(valueOf).length() + 24 + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length()).append("Factory[type=").append(valueOf).append("+").append(valueOf2).append(",adapter=").append(valueOf3).append("]").toString();
    }

    public zzanh zza(zzamp zzamp, zzaol zzaol) {
        Class m = zzaol.mo7939m();
        if (m == this.f4924a || m == this.f4925b) {
            return this.f4926c;
        }
        return null;
    }
}
