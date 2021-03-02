package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.internal.client.zzy;
import com.google.android.gms.internal.zzin;
import java.util.Random;

@zzin
public class zzn extends zzy.zza {

    /* renamed from: a */
    private final Random f3611a = new Random();

    /* renamed from: b */
    private long f3612b;

    /* renamed from: c */
    private Object f3613c = new Object();

    public zzn() {
        zziy();
    }

    public long getValue() {
        return this.f3612b;
    }

    public void zziy() {
        synchronized (this.f3613c) {
            int i = 3;
            long j = 0;
            while (true) {
                i--;
                if (i <= 0) {
                    break;
                }
                j = ((long) this.f3611a.nextInt()) + 2147483648L;
                if (j != this.f3612b && j != 0) {
                    break;
                }
            }
            this.f3612b = j;
        }
    }
}
