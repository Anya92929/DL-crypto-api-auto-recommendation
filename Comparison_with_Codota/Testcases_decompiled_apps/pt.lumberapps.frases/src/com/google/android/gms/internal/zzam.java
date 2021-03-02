package com.google.android.gms.internal;

import com.google.android.gms.clearcut.zzb;
import com.google.android.gms.internal.zzad;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class zzam {

    /* renamed from: a */
    protected static volatile zzb f5764a = null;

    /* renamed from: d */
    private static volatile Random f5765d = null;

    /* renamed from: e */
    private static final Object f5766e = new Object();

    /* renamed from: b */
    protected boolean f5767b = false;

    /* renamed from: c */
    private zzax f5768c;

    public zzam(zzax zzax) {
        this.f5768c = zzax;
        zzdc.initialize(zzax.getContext());
        this.f5767b = ((Boolean) zzdc.zzbbi.get()).booleanValue();
        if (this.f5767b && f5764a == null) {
            synchronized (f5766e) {
                if (f5764a == null) {
                    f5764a = new zzb(zzax.getContext(), "ADSHIELD", (String) null);
                }
            }
        }
    }

    /* renamed from: a */
    private static Random m6642a() {
        if (f5765d == null) {
            synchronized (f5766e) {
                if (f5765d == null) {
                    f5765d = new Random();
                }
            }
        }
        return f5765d;
    }

    public void zza(int i, int i2, long j) {
        try {
            if (this.f5767b && f5764a != null && this.f5768c.zzcj()) {
                zzad.zza zza = new zzad.zza();
                zza.zzck = this.f5768c.getContext().getPackageName();
                zza.zzcl = Long.valueOf(j);
                zzb.zza zzl = f5764a.zzl(zzapv.zzf(zza));
                zzl.zzez(i2);
                zzl.zzey(i);
                zzl.zze(this.f5768c.zzch());
            }
        } catch (Exception e) {
        }
    }

    public int zzat() {
        try {
            return ThreadLocalRandom.current().nextInt();
        } catch (NoClassDefFoundError e) {
            return m6642a().nextInt();
        } catch (RuntimeException e2) {
            return m6642a().nextInt();
        }
    }
}
