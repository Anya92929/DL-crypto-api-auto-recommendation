package com.google.android.gms.internal;

import java.net.URL;

/* renamed from: com.google.android.gms.internal.cc */
final class C1465cc extends zzanh {
    C1465cc() {
    }

    /* renamed from: a */
    public URL zzb(zzaom zzaom) {
        if (zzaom.mo7902b() == zzaon.NULL) {
            zzaom.nextNull();
            return null;
        }
        String nextString = zzaom.nextString();
        if (!"null".equals(nextString)) {
            return new URL(nextString);
        }
        return null;
    }

    /* renamed from: a */
    public void zza(zzaoo zzaoo, URL url) {
        zzaoo.zzts(url == null ? null : url.toExternalForm());
    }
}
