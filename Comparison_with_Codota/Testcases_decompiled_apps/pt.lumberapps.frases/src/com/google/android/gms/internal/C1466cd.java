package com.google.android.gms.internal;

import java.net.URI;
import java.net.URISyntaxException;

/* renamed from: com.google.android.gms.internal.cd */
final class C1466cd extends zzanh {
    C1466cd() {
    }

    /* renamed from: a */
    public URI zzb(zzaom zzaom) {
        if (zzaom.mo7902b() == zzaon.NULL) {
            zzaom.nextNull();
            return null;
        }
        try {
            String nextString = zzaom.nextString();
            if (!"null".equals(nextString)) {
                return new URI(nextString);
            }
            return null;
        } catch (URISyntaxException e) {
            throw new zzamw((Throwable) e);
        }
    }

    /* renamed from: a */
    public void zza(zzaoo zzaoo, URI uri) {
        zzaoo.zzts(uri == null ? null : uri.toASCIIString());
    }
}
