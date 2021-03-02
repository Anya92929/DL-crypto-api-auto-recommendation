package com.google.android.gms.internal;

import java.net.InetAddress;

/* renamed from: com.google.android.gms.internal.cf */
final class C1468cf extends zzanh {
    C1468cf() {
    }

    /* renamed from: a */
    public InetAddress zzb(zzaom zzaom) {
        if (zzaom.mo7902b() != zzaon.NULL) {
            return InetAddress.getByName(zzaom.nextString());
        }
        zzaom.nextNull();
        return null;
    }

    /* renamed from: a */
    public void zza(zzaoo zzaoo, InetAddress inetAddress) {
        zzaoo.zzts(inetAddress == null ? null : inetAddress.getHostAddress());
    }
}
