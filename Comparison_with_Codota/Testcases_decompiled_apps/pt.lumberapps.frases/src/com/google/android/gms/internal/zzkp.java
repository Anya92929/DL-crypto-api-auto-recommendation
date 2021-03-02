package com.google.android.gms.internal;

import android.graphics.Bitmap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@zzin
public class zzkp {

    /* renamed from: a */
    Map f6638a = new ConcurrentHashMap();

    /* renamed from: b */
    private AtomicInteger f6639b = new AtomicInteger(0);

    public Bitmap zza(Integer num) {
        return (Bitmap) this.f6638a.get(num);
    }

    public int zzb(Bitmap bitmap) {
        if (bitmap == null) {
            zzkd.zzcv("Bitmap is null. Skipping putting into the Memory Map.");
            return -1;
        }
        this.f6638a.put(Integer.valueOf(this.f6639b.get()), bitmap);
        return this.f6639b.getAndIncrement();
    }

    public void zzb(Integer num) {
        this.f6638a.remove(num);
    }
}
