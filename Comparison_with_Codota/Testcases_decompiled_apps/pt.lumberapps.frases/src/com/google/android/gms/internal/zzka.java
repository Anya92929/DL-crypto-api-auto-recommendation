package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.ads.internal.zzu;

@zzin
public class zzka {

    /* renamed from: a */
    private final Object f6600a;

    /* renamed from: b */
    private int f6601b;

    /* renamed from: c */
    private int f6602c;

    /* renamed from: d */
    private final zzjx f6603d;

    /* renamed from: e */
    private final String f6604e;

    zzka(zzjx zzjx, String str) {
        this.f6600a = new Object();
        this.f6603d = zzjx;
        this.f6604e = str;
    }

    public zzka(String str) {
        this(zzu.zzft(), str);
    }

    public Bundle toBundle() {
        Bundle bundle;
        synchronized (this.f6600a) {
            bundle = new Bundle();
            bundle.putInt("pmnli", this.f6601b);
            bundle.putInt("pmnll", this.f6602c);
        }
        return bundle;
    }

    public void zzh(int i, int i2) {
        synchronized (this.f6600a) {
            this.f6601b = i;
            this.f6602c = i2;
            this.f6603d.zza(this.f6604e, this);
        }
    }
}
