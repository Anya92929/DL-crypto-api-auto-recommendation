package com.google.android.gms.internal;

/* renamed from: com.google.android.gms.internal.ae */
class C1413ae extends zzanh {

    /* renamed from: a */
    private zzanh f4821a;

    C1413ae() {
    }

    /* renamed from: a */
    public void mo7058a(zzanh zzanh) {
        if (this.f4821a != null) {
            throw new AssertionError();
        }
        this.f4821a = zzanh;
    }

    public void zza(zzaoo zzaoo, Object obj) {
        if (this.f4821a == null) {
            throw new IllegalStateException();
        }
        this.f4821a.zza(zzaoo, obj);
    }

    public Object zzb(zzaom zzaom) {
        if (this.f4821a != null) {
            return this.f4821a.zzb(zzaom);
        }
        throw new IllegalStateException();
    }
}
