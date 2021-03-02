package com.google.android.gms.internal;

import android.app.PendingIntent;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.zzd;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.oq */
class C1803oq extends C1810ox {

    /* renamed from: a */
    final /* synthetic */ zzpw f5448a;

    /* renamed from: c */
    private final Map f5449c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1803oq(zzpw zzpw, Map map) {
        super(zzpw, (C1801oo) null);
        this.f5448a = zzpw;
        this.f5449c = map;
    }

    /* renamed from: a */
    public void mo7627a() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4 = true;
        int i = 0;
        Iterator it = this.f5449c.keySet().iterator();
        boolean z5 = true;
        boolean z6 = false;
        while (true) {
            if (!it.hasNext()) {
                z4 = z6;
                z = false;
                break;
            }
            Api.zze zze = (Api.zze) it.next();
            if (!zze.zzanu()) {
                z3 = false;
                z2 = z6;
            } else if (((C1802op) this.f5449c.get(zze)).f5447c == 0) {
                z = true;
                break;
            } else {
                z3 = z5;
                z2 = true;
            }
            z6 = z2;
            z5 = z3;
        }
        if (z4) {
            i = this.f5448a.f6818d.isGooglePlayServicesAvailable(this.f5448a.f6817c);
        }
        if (i == 0 || (!z && !z5)) {
            if (this.f5448a.f6827m) {
                this.f5448a.f6825k.connect();
            }
            for (Api.zze zze2 : this.f5449c.keySet()) {
                zzd.zzf zzf = (zzd.zzf) this.f5449c.get(zze2);
                if (!zze2.zzanu() || i == 0) {
                    zze2.zza(zzf);
                } else {
                    this.f5448a.f6815a.mo8958a((C1818pe) new C1805os(this, this.f5448a, zzf));
                }
            }
            return;
        }
        this.f5448a.f6815a.mo8958a((C1818pe) new C1804or(this, this.f5448a, new ConnectionResult(i, (PendingIntent) null)));
    }
}
