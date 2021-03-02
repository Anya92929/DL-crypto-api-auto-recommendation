package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzag;
import com.google.android.gms.ads.internal.client.zzah;
import com.google.android.gms.ads.reward.RewardedVideoAd;

public class MobileAds {

    public final class Settings {

        /* renamed from: a */
        private final zzah f3395a = new zzah();

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public zzah mo4809a() {
            return this.f3395a;
        }

        @Deprecated
        public String getTrackingId() {
            return this.f3395a.getTrackingId();
        }

        @Deprecated
        public boolean isGoogleAnalyticsEnabled() {
            return this.f3395a.isGoogleAnalyticsEnabled();
        }

        @Deprecated
        public Settings setGoogleAnalyticsEnabled(boolean z) {
            this.f3395a.zzp(z);
            return this;
        }

        @Deprecated
        public Settings setTrackingId(String str) {
            this.f3395a.zzao(str);
            return this;
        }
    }

    private MobileAds() {
    }

    public static RewardedVideoAd getRewardedVideoAdInstance(Context context) {
        return zzag.zzjo().getRewardedVideoAdInstance(context);
    }

    @Deprecated
    public static void initialize(Context context) {
        initialize(context, (String) null, (Settings) null);
    }

    public static void initialize(Context context, String str) {
        initialize(context, str, (Settings) null);
    }

    @Deprecated
    public static void initialize(Context context, String str, Settings settings) {
        zzag.zzjo().zza(context, str, settings == null ? null : settings.mo4809a());
    }

    public static void setAppMuted(boolean z) {
        zzag.zzjo().setAppMuted(z);
    }

    public static void setAppVolume(float f) {
        zzag.zzjo().setAppVolume(f);
    }
}
