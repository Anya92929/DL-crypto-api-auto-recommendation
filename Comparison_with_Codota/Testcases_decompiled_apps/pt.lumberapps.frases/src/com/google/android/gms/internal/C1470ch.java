package com.google.android.gms.internal;

import java.sql.Timestamp;
import java.util.Date;

/* renamed from: com.google.android.gms.internal.ch */
final class C1470ch implements zzani {
    C1470ch() {
    }

    public zzanh zza(zzamp zzamp, zzaol zzaol) {
        if (zzaol.mo7939m() != Timestamp.class) {
            return null;
        }
        return new C1471ci(this, zzamp.zzk(Date.class));
    }
}
