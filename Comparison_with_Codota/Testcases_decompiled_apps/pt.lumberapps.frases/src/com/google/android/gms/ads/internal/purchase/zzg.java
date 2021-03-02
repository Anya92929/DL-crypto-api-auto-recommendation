package com.google.android.gms.ads.internal.purchase;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.stats.zzb;
import com.google.android.gms.internal.zzhr;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzkd;

@zzin
public final class zzg extends zzhr.zza implements ServiceConnection {

    /* renamed from: a */
    zzb f3887a;

    /* renamed from: b */
    private boolean f3888b = false;

    /* renamed from: c */
    private Context f3889c;

    /* renamed from: d */
    private int f3890d;

    /* renamed from: e */
    private Intent f3891e;

    /* renamed from: f */
    private zzf f3892f;

    /* renamed from: g */
    private String f3893g;

    public zzg(Context context, String str, boolean z, int i, Intent intent, zzf zzf) {
        this.f3893g = str;
        this.f3890d = i;
        this.f3891e = intent;
        this.f3888b = z;
        this.f3889c = context;
        this.f3892f = zzf;
    }

    public void finishPurchase() {
        int zzd = zzu.zzga().zzd(this.f3891e);
        if (this.f3890d == -1 && zzd == 0) {
            this.f3887a = new zzb(this.f3889c);
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            intent.setPackage("com.android.vending");
            zzb.zzaux().zza(this.f3889c, intent, (ServiceConnection) this, 1);
        }
    }

    public String getProductId() {
        return this.f3893g;
    }

    public Intent getPurchaseData() {
        return this.f3891e;
    }

    public int getResultCode() {
        return this.f3890d;
    }

    public boolean isVerified() {
        return this.f3888b;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        zzkd.zzcw("In-app billing service connected.");
        this.f3887a.zzas(iBinder);
        String zzbz = zzu.zzga().zzbz(zzu.zzga().zze(this.f3891e));
        if (zzbz != null) {
            if (this.f3887a.zzm(this.f3889c.getPackageName(), zzbz) == 0) {
                zzh.zzs(this.f3889c).zza(this.f3892f);
            }
            zzb.zzaux().zza(this.f3889c, this);
            this.f3887a.destroy();
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        zzkd.zzcw("In-app billing service disconnected.");
        this.f3887a.destroy();
    }
}
