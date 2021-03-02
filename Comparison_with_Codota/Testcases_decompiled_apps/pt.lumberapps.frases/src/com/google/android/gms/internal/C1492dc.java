package com.google.android.gms.internal;

/* renamed from: com.google.android.gms.internal.dc */
final class C1492dc extends zzanh {
    C1492dc() {
    }

    /* renamed from: a */
    public Character zzb(zzaom zzaom) {
        if (zzaom.mo7902b() == zzaon.NULL) {
            zzaom.nextNull();
            return null;
        }
        String nextString = zzaom.nextString();
        if (nextString.length() == 1) {
            return Character.valueOf(nextString.charAt(0));
        }
        String valueOf = String.valueOf(nextString);
        throw new zzane(valueOf.length() != 0 ? "Expecting character, got: ".concat(valueOf) : new String("Expecting character, got: "));
    }

    /* renamed from: a */
    public void zza(zzaoo zzaoo, Character ch) {
        zzaoo.zzts(ch == null ? null : String.valueOf(ch));
    }
}
