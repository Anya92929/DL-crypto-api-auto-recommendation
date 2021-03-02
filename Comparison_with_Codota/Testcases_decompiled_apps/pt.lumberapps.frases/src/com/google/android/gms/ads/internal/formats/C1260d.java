package com.google.android.gms.ads.internal.formats;

import com.google.android.gms.internal.zzep;
import com.google.android.gms.internal.zzft;
import com.google.android.gms.internal.zzih;

/* renamed from: com.google.android.gms.ads.internal.formats.d */
class C1260d extends zzih.zza {

    /* renamed from: a */
    final /* synthetic */ zzi f3627a;

    C1260d(zzi zzi) {
        this.f3627a = zzi;
    }

    public void zze(zzft zzft) {
        zzft.zza("/loadHtml", (zzep) new C1261e(this, zzft));
        zzft.zza("/showOverlay", (zzep) new C1263g(this));
        zzft.zza("/hideOverlay", (zzep) new C1264h(this));
        this.f3627a.f3696j.zzuj().zza("/hideOverlay", (zzep) new C1265i(this));
        this.f3627a.f3696j.zzuj().zza("/sendMessageToSdk", (zzep) new C1266j(this, zzft));
    }
}
