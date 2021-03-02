package com.google.android.gms.internal;

/* renamed from: com.google.android.gms.internal.cq */
final class C1479cq implements zzani {

    /* renamed from: a */
    final /* synthetic */ Class f4921a;

    /* renamed from: b */
    final /* synthetic */ Class f4922b;

    /* renamed from: c */
    final /* synthetic */ zzanh f4923c;

    C1479cq(Class cls, Class cls2, zzanh zzanh) {
        this.f4921a = cls;
        this.f4922b = cls2;
        this.f4923c = zzanh;
    }

    public String toString() {
        String valueOf = String.valueOf(this.f4922b.getName());
        String valueOf2 = String.valueOf(this.f4921a.getName());
        String valueOf3 = String.valueOf(this.f4923c);
        return new StringBuilder(String.valueOf(valueOf).length() + 24 + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length()).append("Factory[type=").append(valueOf).append("+").append(valueOf2).append(",adapter=").append(valueOf3).append("]").toString();
    }

    public zzanh zza(zzamp zzamp, zzaol zzaol) {
        Class m = zzaol.mo7939m();
        if (m == this.f4921a || m == this.f4922b) {
            return this.f4923c;
        }
        return null;
    }
}
