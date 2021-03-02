package com.google.android.gms.internal;

import java.util.Locale;
import java.util.StringTokenizer;

/* renamed from: com.google.android.gms.internal.ck */
final class C1473ck extends zzanh {
    C1473ck() {
    }

    /* renamed from: a */
    public Locale zzb(zzaom zzaom) {
        if (zzaom.mo7902b() == zzaon.NULL) {
            zzaom.nextNull();
            return null;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(zzaom.nextString(), "_");
        String nextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
        String nextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
        String nextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
        return (nextToken2 == null && nextToken3 == null) ? new Locale(nextToken) : nextToken3 == null ? new Locale(nextToken, nextToken2) : new Locale(nextToken, nextToken2, nextToken3);
    }

    /* renamed from: a */
    public void zza(zzaoo zzaoo, Locale locale) {
        zzaoo.zzts(locale == null ? null : locale.toString());
    }
}
