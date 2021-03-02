package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import java.util.Map;

@zzin
public class zzey implements zzep {

    /* renamed from: a */
    private final zza f6165a;

    public interface zza {
        void zzb(RewardItemParcel rewardItemParcel);

        void zzev();
    }

    public zzey(zza zza2) {
        this.f6165a = zza2;
    }

    /* renamed from: a */
    private void m7017a(Map map) {
        RewardItemParcel rewardItemParcel;
        try {
            int parseInt = Integer.parseInt((String) map.get("amount"));
            String str = (String) map.get("type");
            if (!TextUtils.isEmpty(str)) {
                rewardItemParcel = new RewardItemParcel(str, parseInt);
                this.f6165a.zzb(rewardItemParcel);
            }
        } catch (NumberFormatException e) {
            zzkd.zzd("Unable to parse reward amount.", e);
        }
        rewardItemParcel = null;
        this.f6165a.zzb(rewardItemParcel);
    }

    /* renamed from: b */
    private void m7018b(Map map) {
        this.f6165a.zzev();
    }

    public static void zza(zzlh zzlh, zza zza2) {
        zzlh.zzuj().zza("/reward", (zzep) new zzey(zza2));
    }

    public void zza(zzlh zzlh, Map map) {
        String str = (String) map.get("action");
        if ("grant".equals(str)) {
            m7017a(map);
        } else if ("video_start".equals(str)) {
            m7018b(map);
        }
    }
}
