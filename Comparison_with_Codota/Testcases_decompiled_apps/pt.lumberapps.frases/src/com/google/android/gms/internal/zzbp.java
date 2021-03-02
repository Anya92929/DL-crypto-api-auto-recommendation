package com.google.android.gms.internal;

import com.google.android.gms.internal.zzae;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

public abstract class zzbp implements Callable {

    /* renamed from: a */
    protected final String f5981a = getClass().getSimpleName();

    /* renamed from: b */
    protected final zzax f5982b;

    /* renamed from: c */
    protected final String f5983c;

    /* renamed from: d */
    protected final String f5984d;

    /* renamed from: e */
    protected final zzae.zza f5985e;

    /* renamed from: f */
    protected Method f5986f;

    /* renamed from: g */
    protected final int f5987g;

    /* renamed from: h */
    protected final int f5988h;

    public zzbp(zzax zzax, String str, String str2, zzae.zza zza, int i, int i2) {
        this.f5982b = zzax;
        this.f5983c = str;
        this.f5984d = str2;
        this.f5985e = zza;
        this.f5987g = i;
        this.f5988h = i2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo8119a();

    /* renamed from: zzcx */
    public Void call() {
        try {
            long nanoTime = System.nanoTime();
            this.f5986f = this.f5982b.zzc(this.f5983c, this.f5984d);
            if (this.f5986f != null) {
                mo8119a();
                zzam zzck = this.f5982b.zzck();
                if (!(zzck == null || this.f5987g == Integer.MIN_VALUE)) {
                    zzck.zza(this.f5988h, this.f5987g, (System.nanoTime() - nanoTime) / 1000);
                }
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
        }
        return null;
    }
}
