package com.google.android.gms.common.internal;

import android.util.Log;

public final class zzp {

    /* renamed from: a */
    private static final String f4615a = null;

    /* renamed from: za */
    public static final int f4616za = (23 - " PII_LOG".length());

    /* renamed from: b */
    private final String f4617b;

    /* renamed from: c */
    private final String f4618c;

    public zzp(String str) {
        this(str, (String) null);
    }

    public zzp(String str, String str2) {
        zzab.zzb((Object) str, (Object) "log tag cannot be null");
        zzab.zzb(str.length() <= 23, "tag \"%s\" is longer than the %d character maximum", str, 23);
        this.f4617b = str;
        if (str2 == null || str2.length() <= 0) {
            this.f4618c = null;
        } else {
            this.f4618c = str2;
        }
    }

    /* renamed from: a */
    private String m6141a(String str) {
        return this.f4618c == null ? str : this.f4618c.concat(str);
    }

    public void zzae(String str, String str2) {
        if (zzgg(3)) {
            Log.d(str, m6141a(str2));
        }
    }

    public void zzaf(String str, String str2) {
        if (zzgg(5)) {
            Log.w(str, m6141a(str2));
        }
    }

    public void zzag(String str, String str2) {
        if (zzgg(6)) {
            Log.e(str, m6141a(str2));
        }
    }

    public void zzb(String str, String str2, Throwable th) {
        if (zzgg(4)) {
            Log.i(str, m6141a(str2), th);
        }
    }

    public void zzc(String str, String str2, Throwable th) {
        if (zzgg(5)) {
            Log.w(str, m6141a(str2), th);
        }
    }

    public void zzd(String str, String str2, Throwable th) {
        if (zzgg(6)) {
            Log.e(str, m6141a(str2), th);
        }
    }

    public void zze(String str, String str2, Throwable th) {
        if (zzgg(7)) {
            Log.e(str, m6141a(str2), th);
            Log.wtf(str, m6141a(str2), th);
        }
    }

    public boolean zzgg(int i) {
        return Log.isLoggable(this.f4617b, i);
    }
}
