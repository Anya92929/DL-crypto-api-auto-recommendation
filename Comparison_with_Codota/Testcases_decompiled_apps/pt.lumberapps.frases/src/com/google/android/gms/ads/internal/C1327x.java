package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.internal.zzf;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzep;
import com.google.android.gms.internal.zzgn;
import com.google.android.gms.internal.zzgo;
import com.google.android.gms.internal.zzkd;
import com.google.android.gms.internal.zzlh;
import java.util.Map;

/* renamed from: com.google.android.gms.ads.internal.x */
final class C1327x implements zzep {

    /* renamed from: a */
    final /* synthetic */ zzgn f3999a;

    /* renamed from: b */
    final /* synthetic */ zzf.zza f4000b;

    /* renamed from: c */
    final /* synthetic */ zzgo f4001c;

    C1327x(zzgn zzgn, zzf.zza zza, zzgo zzgo) {
        this.f3999a = zzgn;
        this.f4000b = zza;
        this.f4001c = zzgo;
    }

    public void zza(zzlh zzlh, Map map) {
        View view = zzlh.getView();
        if (view != null) {
            try {
                if (this.f3999a != null) {
                    if (!this.f3999a.getOverrideClickHandling()) {
                        this.f3999a.zzk(zze.zzac(view));
                        this.f4000b.onClick();
                        return;
                    }
                    zzn.m5846b(zzlh);
                } else if (this.f4001c == null) {
                } else {
                    if (!this.f4001c.getOverrideClickHandling()) {
                        this.f4001c.zzk(zze.zzac(view));
                        this.f4000b.onClick();
                        return;
                    }
                    zzn.m5846b(zzlh);
                }
            } catch (RemoteException e) {
                zzkd.zzd("Unable to call handleClick on mapper", e);
            }
        }
    }
}
