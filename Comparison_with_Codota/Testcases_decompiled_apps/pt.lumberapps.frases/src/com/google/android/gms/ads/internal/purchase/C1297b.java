package com.google.android.gms.ads.internal.purchase;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.zzjx;

/* renamed from: com.google.android.gms.ads.internal.purchase.b */
class C1297b implements ServiceConnection {

    /* renamed from: a */
    final /* synthetic */ Context f3861a;

    /* renamed from: b */
    final /* synthetic */ zzi f3862b;

    C1297b(zzi zzi, Context context) {
        this.f3862b = zzi;
        this.f3861a = context;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        boolean z = false;
        zzb zzb = new zzb(this.f3861a.getApplicationContext(), false);
        zzb.zzas(iBinder);
        int zzb2 = zzb.zzb(3, this.f3861a.getPackageName(), "inapp");
        zzjx zzft = zzu.zzft();
        if (zzb2 == 0) {
            z = true;
        }
        zzft.zzag(z);
        this.f3861a.unbindService(this);
        zzb.destroy();
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }
}
