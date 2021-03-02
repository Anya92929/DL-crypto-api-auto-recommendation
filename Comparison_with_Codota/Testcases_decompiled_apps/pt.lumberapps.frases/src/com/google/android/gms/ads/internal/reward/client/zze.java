package com.google.android.gms.ads.internal.reward.client;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.internal.zzin;

@zzin
public class zze implements RewardItem {

    /* renamed from: a */
    private final zza f3971a;

    public zze(zza zza) {
        this.f3971a = zza;
    }

    public int getAmount() {
        if (this.f3971a == null) {
            return 0;
        }
        try {
            return this.f3971a.getAmount();
        } catch (RemoteException e) {
            zzb.zzd("Could not forward getAmount to RewardItem", e);
            return 0;
        }
    }

    public String getType() {
        if (this.f3971a == null) {
            return null;
        }
        try {
            return this.f3971a.getType();
        } catch (RemoteException e) {
            zzb.zzd("Could not forward getType to RewardItem", e);
            return null;
        }
    }
}
