package com.google.android.gms.ads.internal.purchase;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.zzhn;
import com.google.android.gms.internal.zzhp;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzkd;

@zzin
public class zze extends zzhp.zza implements ServiceConnection {

    /* renamed from: a */
    zzh f3878a;

    /* renamed from: b */
    private final Activity f3879b;

    /* renamed from: c */
    private Context f3880c;

    /* renamed from: d */
    private zzhn f3881d;

    /* renamed from: e */
    private zzb f3882e;

    /* renamed from: f */
    private zzf f3883f;

    /* renamed from: g */
    private zzj f3884g;

    /* renamed from: h */
    private zzk f3885h;

    /* renamed from: i */
    private String f3886i = null;

    public zze(Activity activity) {
        this.f3879b = activity;
        this.f3878a = zzh.zzs(this.f3879b.getApplicationContext());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5593a(String str, boolean z, int i, Intent intent) {
        if (this.f3884g != null) {
            this.f3884g.zza(str, z, i, intent, this.f3883f);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1001) {
            boolean z = false;
            try {
                int zzd = zzu.zzga().zzd(intent);
                if (i2 == -1) {
                    zzu.zzga();
                    if (zzd == 0) {
                        if (this.f3885h.zza(this.f3886i, i2, intent)) {
                            z = true;
                        }
                        this.f3881d.recordPlayBillingResolution(zzd);
                        this.f3879b.finish();
                        mo5593a(this.f3881d.getProductId(), z, i2, intent);
                    }
                }
                this.f3878a.zza(this.f3883f);
                this.f3881d.recordPlayBillingResolution(zzd);
                this.f3879b.finish();
                mo5593a(this.f3881d.getProductId(), z, i2, intent);
            } catch (RemoteException e) {
                zzkd.zzcx("Fail to process purchase result.");
                this.f3879b.finish();
            } finally {
                this.f3886i = null;
            }
        }
    }

    public void onCreate() {
        GInAppPurchaseManagerInfoParcel zzc = GInAppPurchaseManagerInfoParcel.zzc(this.f3879b.getIntent());
        this.f3884g = zzc.zzbwo;
        this.f3885h = zzc.zzapt;
        this.f3881d = zzc.zzbwm;
        this.f3882e = new zzb(this.f3879b.getApplicationContext());
        this.f3880c = zzc.zzbwn;
        if (this.f3879b.getResources().getConfiguration().orientation == 2) {
            this.f3879b.setRequestedOrientation(zzu.zzfs().zztj());
        } else {
            this.f3879b.setRequestedOrientation(zzu.zzfs().zztk());
        }
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage("com.android.vending");
        this.f3879b.bindService(intent, this, 1);
    }

    public void onDestroy() {
        this.f3879b.unbindService(this);
        this.f3882e.destroy();
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f3882e.zzas(iBinder);
        try {
            this.f3886i = this.f3885h.zzpu();
            Bundle zzb = this.f3882e.zzb(this.f3879b.getPackageName(), this.f3881d.getProductId(), this.f3886i);
            PendingIntent pendingIntent = (PendingIntent) zzb.getParcelable("BUY_INTENT");
            if (pendingIntent == null) {
                int zze = zzu.zzga().zze(zzb);
                this.f3881d.recordPlayBillingResolution(zze);
                mo5593a(this.f3881d.getProductId(), false, zze, (Intent) null);
                this.f3879b.finish();
                return;
            }
            this.f3883f = new zzf(this.f3881d.getProductId(), this.f3886i);
            this.f3878a.zzb(this.f3883f);
            Integer num = 0;
            Integer num2 = 0;
            Integer num3 = 0;
            this.f3879b.startIntentSenderForResult(pendingIntent.getIntentSender(), 1001, new Intent(), num.intValue(), num2.intValue(), num3.intValue());
        } catch (IntentSender.SendIntentException | RemoteException e) {
            zzkd.zzd("Error when connecting in-app billing service", e);
            this.f3879b.finish();
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        zzkd.zzcw("In-app billing service disconnected.");
        this.f3882e.destroy();
    }
}
