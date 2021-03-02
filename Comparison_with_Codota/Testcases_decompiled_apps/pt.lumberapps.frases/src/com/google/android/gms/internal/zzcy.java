package com.google.android.gms.internal;

import android.content.SharedPreferences;
import com.google.android.gms.ads.internal.zzu;

@zzin
public abstract class zzcy {

    /* renamed from: a */
    private final int f6087a;

    /* renamed from: b */
    private final String f6088b;

    /* renamed from: c */
    private final Object f6089c;

    private zzcy(int i, String str, Object obj) {
        this.f6087a = i;
        this.f6088b = str;
        this.f6089c = obj;
        zzu.zzfy().zza(this);
    }

    /* synthetic */ zzcy(int i, String str, Object obj, C1526ej ejVar) {
        this(i, str, obj);
    }

    public static zzcy zza(int i, String str) {
        zzcy zza = zza(i, str, (String) null);
        zzu.zzfy().zzb(zza);
        return zza;
    }

    public static zzcy zza(int i, String str, int i2) {
        return new C1527ek(i, str, Integer.valueOf(i2));
    }

    public static zzcy zza(int i, String str, long j) {
        return new C1528el(i, str, Long.valueOf(j));
    }

    public static zzcy zza(int i, String str, Boolean bool) {
        return new C1526ej(i, str, bool);
    }

    public static zzcy zza(int i, String str, String str2) {
        return new C1529em(i, str, str2);
    }

    public static zzcy zzb(int i, String str) {
        zzcy zza = zza(i, str, (String) null);
        zzu.zzfy().zzc(zza);
        return zza;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract Object mo7230a(SharedPreferences sharedPreferences);

    public Object get() {
        return zzu.zzfz().zzd(this);
    }

    public String getKey() {
        return this.f6088b;
    }

    public Object zzjw() {
        return this.f6089c;
    }
}
