package com.google.android.gms.internal;

import java.util.UUID;

/* renamed from: com.google.android.gms.internal.cg */
final class C1469cg extends zzanh {
    C1469cg() {
    }

    /* renamed from: a */
    public UUID zzb(zzaom zzaom) {
        if (zzaom.mo7902b() != zzaon.NULL) {
            return UUID.fromString(zzaom.nextString());
        }
        zzaom.nextNull();
        return null;
    }

    /* renamed from: a */
    public void zza(zzaoo zzaoo, UUID uuid) {
        zzaoo.zzts(uuid == null ? null : uuid.toString());
    }
}
