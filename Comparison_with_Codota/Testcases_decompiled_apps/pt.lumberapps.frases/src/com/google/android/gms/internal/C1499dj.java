package com.google.android.gms.internal;

/* renamed from: com.google.android.gms.internal.dj */
final class C1499dj extends zzanr {
    C1499dj() {
    }

    public void zzi(zzaom zzaom) {
        if (zzaom instanceof zzaoc) {
            ((zzaoc) zzaom).mo7906e();
            return;
        }
        int a = zzaom.f5859i;
        if (a == 0) {
            a = zzaom.m6724a();
        }
        if (a == 13) {
            int unused = zzaom.f5859i = 9;
        } else if (a == 12) {
            int unused2 = zzaom.f5859i = 8;
        } else if (a == 14) {
            int unused3 = zzaom.f5859i = 10;
        } else {
            String valueOf = String.valueOf(zzaom.mo7902b());
            int c = zzaom.m6742g();
            int d = zzaom.m6743h();
            String path = zzaom.getPath();
            throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 70 + String.valueOf(path).length()).append("Expected a name but was ").append(valueOf).append(" ").append(" at line ").append(c).append(" column ").append(d).append(" path ").append(path).toString());
        }
    }
}
