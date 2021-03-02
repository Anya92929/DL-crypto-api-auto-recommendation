package com.google.android.gms.internal;

/* renamed from: com.google.android.gms.internal.cw */
final class C1485cw extends zzanh {
    C1485cw() {
    }

    /* renamed from: a */
    public Number zzb(zzaom zzaom) {
        if (zzaom.mo7902b() == zzaon.NULL) {
            zzaom.nextNull();
            return null;
        }
        try {
            return Byte.valueOf((byte) zzaom.nextInt());
        } catch (NumberFormatException e) {
            throw new zzane((Throwable) e);
        }
    }

    /* renamed from: a */
    public void zza(zzaoo zzaoo, Number number) {
        zzaoo.zza(number);
    }
}
