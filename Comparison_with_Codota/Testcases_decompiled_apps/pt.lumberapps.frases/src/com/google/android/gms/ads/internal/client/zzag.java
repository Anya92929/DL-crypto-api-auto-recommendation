package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.reward.client.zzi;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzgi;
import com.google.android.gms.internal.zzin;

@zzin
public class zzag {

    /* renamed from: a */
    private static zzag f3568a;

    /* renamed from: b */
    private static final Object f3569b = new Object();

    /* renamed from: c */
    private zzz f3570c;

    /* renamed from: d */
    private RewardedVideoAd f3571d;

    private zzag() {
    }

    public static zzag zzjo() {
        zzag zzag;
        synchronized (f3569b) {
            if (f3568a == null) {
                f3568a = new zzag();
            }
            zzag = f3568a;
        }
        return zzag;
    }

    public RewardedVideoAd getRewardedVideoAdInstance(Context context) {
        RewardedVideoAd rewardedVideoAd;
        synchronized (f3569b) {
            if (this.f3571d != null) {
                rewardedVideoAd = this.f3571d;
            } else {
                this.f3571d = new zzi(context, zzm.zzix().zza(context, new zzgi()));
                rewardedVideoAd = this.f3571d;
            }
        }
        return rewardedVideoAd;
    }

    public void setAppMuted(boolean z) {
        zzab.zza(this.f3570c != null, (Object) "MobileAds.initialize() must be called prior to setting the app volume.");
        try {
            this.f3570c.setAppMuted(z);
        } catch (RemoteException e) {
            zzb.zzb("Unable to set app mute state.", e);
        }
    }

    public void setAppVolume(float f) {
        boolean z = true;
        zzab.zzb(0.0f <= f && f <= 1.0f, (Object) "The app volume must be a value between 0 and 1 inclusive.");
        if (this.f3570c == null) {
            z = false;
        }
        zzab.zza(z, (Object) "MobileAds.initialize() must be called prior to setting the app volume.");
        try {
            this.f3570c.setAppVolume(f);
        } catch (RemoteException e) {
            zzb.zzb("Unable to set app volume.", e);
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zza(android.content.Context r4, java.lang.String r5, com.google.android.gms.ads.internal.client.zzah r6) {
        /*
            r3 = this;
            java.lang.Object r1 = f3569b
            monitor-enter(r1)
            com.google.android.gms.ads.internal.client.zzz r0 = r3.f3570c     // Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x0009
            monitor-exit(r1)     // Catch:{ all -> 0x0013 }
        L_0x0008:
            return
        L_0x0009:
            if (r4 != 0) goto L_0x0016
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0013 }
            java.lang.String r2 = "Context cannot be null."
            r0.<init>(r2)     // Catch:{ all -> 0x0013 }
            throw r0     // Catch:{ all -> 0x0013 }
        L_0x0013:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0013 }
            throw r0
        L_0x0016:
            com.google.android.gms.ads.internal.client.zzl r0 = com.google.android.gms.ads.internal.client.zzm.zzix()     // Catch:{ RemoteException -> 0x002e }
            com.google.android.gms.ads.internal.client.zzz r0 = r0.zzl(r4)     // Catch:{ RemoteException -> 0x002e }
            r3.f3570c = r0     // Catch:{ RemoteException -> 0x002e }
            com.google.android.gms.ads.internal.client.zzz r0 = r3.f3570c     // Catch:{ RemoteException -> 0x002e }
            r0.initialize()     // Catch:{ RemoteException -> 0x002e }
            if (r5 == 0) goto L_0x002c
            com.google.android.gms.ads.internal.client.zzz r0 = r3.f3570c     // Catch:{ RemoteException -> 0x002e }
            r0.zzu(r5)     // Catch:{ RemoteException -> 0x002e }
        L_0x002c:
            monitor-exit(r1)     // Catch:{ all -> 0x0013 }
            goto L_0x0008
        L_0x002e:
            r0 = move-exception
            java.lang.String r2 = "Fail to initialize or set applicationCode on mobile ads setting manager"
            com.google.android.gms.ads.internal.util.client.zzb.zzd(r2, r0)     // Catch:{ all -> 0x0013 }
            goto L_0x002c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.client.zzag.zza(android.content.Context, java.lang.String, com.google.android.gms.ads.internal.client.zzah):void");
    }
}
