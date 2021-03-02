package com.google.android.gms.internal;

import android.os.Handler;
import com.google.android.gms.ads.internal.client.zzp;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.client.zzw;
import com.google.android.gms.ads.internal.reward.client.zzd;
import com.google.android.gms.ads.internal.zzl;
import java.util.LinkedList;
import java.util.List;

@zzin
/* renamed from: com.google.android.gms.internal.ge */
class C1575ge {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final List f5028a = new LinkedList();

    C1575ge() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo7285a(zzl zzl) {
        zzl.zza((zzq) new C1576gf(this));
        zzl.zza((zzw) new C1582gl(this));
        zzl.zza(new C1584gn(this));
        zzl.zza(new C1586gp(this));
        zzl.zza((zzp) new C1588gr(this));
        zzl.zza((zzd) new C1590gt(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo7286a(C1601hd hdVar) {
        Handler handler = zzkh.zzclc;
        for (C1600hc hbVar : this.f5028a) {
            handler.post(new C1599hb(this, hbVar, hdVar));
        }
    }
}
