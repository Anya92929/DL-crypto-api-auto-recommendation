package com.google.android.gms.internal;

public final class zzaob implements zzani {

    /* renamed from: a */
    private final zzanp f5829a;

    public zzaob(zzanp zzanp) {
        this.f5829a = zzanp;
    }

    /* renamed from: a */
    static zzanh m6698a(zzanp zzanp, zzamp zzamp, zzaol zzaol, zzanj zzanj) {
        Class value = zzanj.value();
        if (zzanh.class.isAssignableFrom(value)) {
            return (zzanh) zzanp.zzb(zzaol.zzr(value)).zzczu();
        }
        if (zzani.class.isAssignableFrom(value)) {
            return ((zzani) zzanp.zzb(zzaol.zzr(value)).zzczu()).zza(zzamp, zzaol);
        }
        throw new IllegalArgumentException("@JsonAdapter value must be TypeAdapter or TypeAdapterFactory reference.");
    }

    public zzanh zza(zzamp zzamp, zzaol zzaol) {
        zzanj zzanj = (zzanj) zzaol.mo7939m().getAnnotation(zzanj.class);
        if (zzanj == null) {
            return null;
        }
        return m6698a(this.f5829a, zzamp, zzaol, zzanj);
    }
}
