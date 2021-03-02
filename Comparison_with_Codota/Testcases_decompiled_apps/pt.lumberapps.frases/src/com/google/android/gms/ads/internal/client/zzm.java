package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.internal.reward.client.zzf;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.internal.zzef;
import com.google.android.gms.internal.zzhh;
import com.google.android.gms.internal.zzhu;
import com.google.android.gms.internal.zzin;

@zzin
public class zzm {

    /* renamed from: a */
    private static final Object f3607a = new Object();

    /* renamed from: b */
    private static zzm f3608b;

    /* renamed from: c */
    private final zza f3609c = new zza();

    /* renamed from: d */
    private final zzl f3610d = new zzl(new zze(), new zzd(), new zzai(), new zzef(), new zzf(), new zzhu(), new zzhh());

    static {
        m5618a(new zzm());
    }

    protected zzm() {
    }

    /* renamed from: a */
    private static zzm m5617a() {
        zzm zzm;
        synchronized (f3607a) {
            zzm = f3608b;
        }
        return zzm;
    }

    /* renamed from: a */
    protected static void m5618a(zzm zzm) {
        synchronized (f3607a) {
            f3608b = zzm;
        }
    }

    public static zza zziw() {
        return m5617a().f3609c;
    }

    public static zzl zzix() {
        return m5617a().f3610d;
    }
}
