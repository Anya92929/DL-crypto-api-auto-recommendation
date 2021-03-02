package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@zzin
public class zzcm {

    /* renamed from: a */
    private final Object f6057a = new Object();

    /* renamed from: b */
    private int f6058b;

    /* renamed from: c */
    private List f6059c = new LinkedList();

    public boolean zza(zzcl zzcl) {
        boolean z;
        synchronized (this.f6057a) {
            z = this.f6059c.contains(zzcl);
        }
        return z;
    }

    public boolean zzb(zzcl zzcl) {
        boolean z;
        synchronized (this.f6057a) {
            Iterator it = this.f6059c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                zzcl zzcl2 = (zzcl) it.next();
                if (zzcl != zzcl2 && zzcl2.zzhr().equals(zzcl.zzhr())) {
                    it.remove();
                    z = true;
                    break;
                }
            }
        }
        return z;
    }

    public void zzc(zzcl zzcl) {
        synchronized (this.f6057a) {
            if (this.f6059c.size() >= 10) {
                zzkd.zzcv(new StringBuilder(41).append("Queue is full, current size = ").append(this.f6059c.size()).toString());
                this.f6059c.remove(0);
            }
            int i = this.f6058b;
            this.f6058b = i + 1;
            zzcl.zzl(i);
            this.f6059c.add(zzcl);
        }
    }

    public zzcl zzhy() {
        int i;
        zzcl zzcl;
        zzcl zzcl2 = null;
        synchronized (this.f6057a) {
            if (this.f6059c.size() == 0) {
                zzkd.zzcv("Queue empty");
                return null;
            } else if (this.f6059c.size() >= 2) {
                int i2 = Integer.MIN_VALUE;
                for (zzcl zzcl3 : this.f6059c) {
                    int score = zzcl3.getScore();
                    if (score > i2) {
                        int i3 = score;
                        zzcl = zzcl3;
                        i = i3;
                    } else {
                        i = i2;
                        zzcl = zzcl2;
                    }
                    i2 = i;
                    zzcl2 = zzcl;
                }
                this.f6059c.remove(zzcl2);
                return zzcl2;
            } else {
                zzcl zzcl4 = (zzcl) this.f6059c.get(0);
                zzcl4.zzht();
                return zzcl4;
            }
        }
    }
}
