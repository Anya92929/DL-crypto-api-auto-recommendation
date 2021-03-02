package com.google.android.gms.ads.internal.purchase;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.stats.zzb;
import com.google.android.gms.internal.zzhs;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzkc;
import com.google.android.gms.internal.zzkd;
import com.google.android.gms.internal.zzkh;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@zzin
public class zzc extends zzkc implements ServiceConnection {

    /* renamed from: a */
    private final Object f3866a;

    /* renamed from: b */
    private boolean f3867b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Context f3868c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public zzhs f3869d;

    /* renamed from: e */
    private zzb f3870e;

    /* renamed from: f */
    private zzh f3871f;

    /* renamed from: g */
    private List f3872g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public zzk f3873h;

    public zzc(Context context, zzhs zzhs, zzk zzk) {
        this(context, zzhs, zzk, new zzb(context), zzh.zzs(context.getApplicationContext()));
    }

    zzc(Context context, zzhs zzhs, zzk zzk, zzb zzb, zzh zzh) {
        this.f3866a = new Object();
        this.f3867b = false;
        this.f3872g = null;
        this.f3868c = context;
        this.f3869d = zzhs;
        this.f3873h = zzk;
        this.f3870e = zzb;
        this.f3871f = zzh;
        this.f3872g = this.f3871f.zzg(10);
    }

    /* renamed from: a */
    private void m5716a(long j) {
        do {
            if (!m5718b(j)) {
                zzkd.m7303v("Timeout waiting for pending transaction to be processed.");
            }
        } while (!this.f3867b);
    }

    /* renamed from: b */
    private boolean m5718b(long j) {
        long elapsedRealtime = 60000 - (SystemClock.elapsedRealtime() - j);
        if (elapsedRealtime <= 0) {
            return false;
        }
        try {
            this.f3866a.wait(elapsedRealtime);
        } catch (InterruptedException e) {
            zzkd.zzcx("waitWithTimeout_lock interrupted");
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5583a() {
        if (!this.f3872g.isEmpty()) {
            HashMap hashMap = new HashMap();
            for (zzf zzf : this.f3872g) {
                hashMap.put(zzf.zzbxh, zzf);
            }
            String str = null;
            while (true) {
                Bundle zzn = this.f3870e.zzn(this.f3868c.getPackageName(), str);
                if (zzn == null || zzu.zzga().zze(zzn) != 0) {
                    break;
                }
                ArrayList<String> stringArrayList = zzn.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                ArrayList<String> stringArrayList2 = zzn.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                ArrayList<String> stringArrayList3 = zzn.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                String string = zzn.getString("INAPP_CONTINUATION_TOKEN");
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= stringArrayList.size()) {
                        break;
                    }
                    if (hashMap.containsKey(stringArrayList.get(i2))) {
                        String str2 = stringArrayList.get(i2);
                        String str3 = stringArrayList2.get(i2);
                        String str4 = stringArrayList3.get(i2);
                        zzf zzf2 = (zzf) hashMap.get(str2);
                        if (zzf2.zzbxg.equals(zzu.zzga().zzby(str3))) {
                            mo5584a(zzf2, str3, str4);
                            hashMap.remove(str2);
                        }
                    }
                    i = i2 + 1;
                }
                if (string == null || hashMap.isEmpty()) {
                    break;
                }
                str = string;
            }
            for (String str5 : hashMap.keySet()) {
                this.f3871f.zza((zzf) hashMap.get(str5));
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5584a(zzf zzf, String str, String str2) {
        Intent intent = new Intent();
        zzu.zzga();
        intent.putExtra("RESPONSE_CODE", 0);
        zzu.zzga();
        intent.putExtra("INAPP_PURCHASE_DATA", str);
        zzu.zzga();
        intent.putExtra("INAPP_DATA_SIGNATURE", str2);
        zzkh.zzclc.post(new C1296a(this, zzf, intent));
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f3866a) {
            this.f3870e.zzas(iBinder);
            mo5583a();
            this.f3867b = true;
            this.f3866a.notify();
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        zzkd.zzcw("In-app billing service disconnected.");
        this.f3870e.destroy();
    }

    public void onStop() {
        synchronized (this.f3866a) {
            zzb.zzaux().zza(this.f3868c, this);
            this.f3870e.destroy();
        }
    }

    public void zzew() {
        synchronized (this.f3866a) {
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            intent.setPackage("com.android.vending");
            zzb.zzaux().zza(this.f3868c, intent, (ServiceConnection) this, 1);
            m5716a(SystemClock.elapsedRealtime());
            zzb.zzaux().zza(this.f3868c, this);
            this.f3870e.destroy();
        }
    }
}
