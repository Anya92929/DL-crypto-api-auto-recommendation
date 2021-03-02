package com.google.android.gms.internal;

import android.content.Context;
import java.io.InputStream;
import java.util.Map;

@zzin
public class zzkn {

    /* renamed from: a */
    private static zzl f6632a;

    /* renamed from: b */
    private static final Object f6633b = new Object();
    public static final zza zzcme = new C1745mm();

    public interface zza {
        Object zzh(InputStream inputStream);

        Object zzqu();
    }

    public zzkn(Context context) {
        m7329a(context);
    }

    /* renamed from: a */
    private static zzl m7329a(Context context) {
        zzl zzl;
        synchronized (f6633b) {
            if (f6632a == null) {
                f6632a = zzac.zza(context.getApplicationContext());
            }
            zzl = f6632a;
        }
        return zzl;
    }

    public zzky zza(int i, String str, Map map, byte[] bArr) {
        C1750mr mrVar = new C1750mr(this, (C1745mm) null);
        f6632a.zze(new C1747mo(this, i, str, mrVar, new C1746mn(this, str, mrVar), bArr, map));
        return mrVar;
    }

    public zzky zza(String str, zza zza2) {
        C1750mr mrVar = new C1750mr(this, (C1745mm) null);
        f6632a.zze(new C1748mp(str, zza2, mrVar));
        return mrVar;
    }

    public zzky zzc(String str, Map map) {
        return zza(0, str, map, (byte[]) null);
    }
}
