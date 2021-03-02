package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import android.support.p001v4.util.LruCache;
import com.google.android.gms.common.internal.zzw;

public final class zzmd extends LruCache<zza, Drawable> {

    public static final class zza {
        public final int zzakx;
        public final int zzaky;

        public zza(int i, int i2) {
            this.zzakx = i;
            this.zzaky = i2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            zza zza = (zza) obj;
            return zza.zzakx == this.zzakx && zza.zzaky == this.zzaky;
        }

        public int hashCode() {
            return zzw.hashCode(Integer.valueOf(this.zzakx), Integer.valueOf(this.zzaky));
        }
    }

    public zzmd() {
        super(10);
    }
}
