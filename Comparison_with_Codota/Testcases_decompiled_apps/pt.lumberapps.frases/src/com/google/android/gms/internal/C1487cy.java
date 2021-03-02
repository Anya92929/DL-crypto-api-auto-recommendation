package com.google.android.gms.internal;

/* renamed from: com.google.android.gms.internal.cy */
final class C1487cy extends zzanh {
    C1487cy() {
    }

    /* renamed from: a */
    public Number zzb(zzaom zzaom) {
        zzaon b = zzaom.mo7902b();
        switch (C1483cu.f4929a[b.ordinal()]) {
            case 1:
                return new zzans(zzaom.nextString());
            case 4:
                zzaom.nextNull();
                return null;
            default:
                String valueOf = String.valueOf(b);
                throw new zzane(new StringBuilder(String.valueOf(valueOf).length() + 23).append("Expecting number, got: ").append(valueOf).toString());
        }
    }

    /* renamed from: a */
    public void zza(zzaoo zzaoo, Number number) {
        zzaoo.zza(number);
    }
}
