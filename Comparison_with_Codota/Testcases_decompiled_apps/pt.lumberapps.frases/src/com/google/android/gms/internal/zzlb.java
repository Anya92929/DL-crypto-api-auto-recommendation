package com.google.android.gms.internal;

import com.google.android.gms.internal.zzla;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@zzin
public class zzlb implements zzla {

    /* renamed from: a */
    protected int f6671a = 0;

    /* renamed from: b */
    protected final BlockingQueue f6672b = new LinkedBlockingQueue();

    /* renamed from: c */
    protected Object f6673c;

    /* renamed from: d */
    private final Object f6674d = new Object();

    public int getStatus() {
        return this.f6671a;
    }

    public void reject() {
        synchronized (this.f6674d) {
            if (this.f6671a != 0) {
                throw new UnsupportedOperationException();
            }
            this.f6671a = -1;
            for (C1755mw mwVar : this.f6672b) {
                mwVar.f5372b.run();
            }
            this.f6672b.clear();
        }
    }

    public void zza(zzla.zzc zzc, zzla.zza zza) {
        synchronized (this.f6674d) {
            if (this.f6671a == 1) {
                zzc.zzd(this.f6673c);
            } else if (this.f6671a == -1) {
                zza.run();
            } else if (this.f6671a == 0) {
                this.f6672b.add(new C1755mw(this, zzc, zza));
            }
        }
    }

    public void zzg(Object obj) {
        synchronized (this.f6674d) {
            if (this.f6671a != 0) {
                throw new UnsupportedOperationException();
            }
            this.f6673c = obj;
            this.f6671a = 1;
            for (C1755mw mwVar : this.f6672b) {
                mwVar.f5371a.zzd(obj);
            }
            this.f6672b.clear();
        }
    }
}
