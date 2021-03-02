package com.google.android.gms.ads.internal;

import com.google.android.gms.ads.internal.overlay.zzj;
import com.google.android.gms.ads.internal.overlay.zzm;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.overlay.zzt;
import com.google.android.gms.internal.zzem;
import com.google.android.gms.internal.zzff;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzjn;
import com.google.android.gms.internal.zzjp;

@zzin
public class zzd {
    public final zzff zzakj;
    public final zzj zzakk;
    public final zzm zzakl;
    public final zzjp zzakm;

    public zzd(zzff zzff, zzj zzj, zzm zzm, zzjp zzjp) {
        this.zzakj = zzff;
        this.zzakk = zzj;
        this.zzakl = zzm;
        this.zzakm = zzjp;
    }

    public static zzd zzek() {
        return new zzd(new zzem(), new zzn(), new zzt(), new zzjn());
    }
}
