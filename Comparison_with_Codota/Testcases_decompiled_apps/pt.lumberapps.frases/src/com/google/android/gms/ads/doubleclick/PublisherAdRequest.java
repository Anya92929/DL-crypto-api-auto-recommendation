package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzad;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzy;
import java.util.Date;
import java.util.List;
import java.util.Set;

public final class PublisherAdRequest {
    public static final String DEVICE_ID_EMULATOR = zzad.DEVICE_ID_EMULATOR;
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;
    public static final int GENDER_FEMALE = 2;
    public static final int GENDER_MALE = 1;
    public static final int GENDER_UNKNOWN = 0;

    /* renamed from: a */
    private final zzad f3402a;

    public final class Builder {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final zzad.zza f3403a = new zzad.zza();

        public Builder addCategoryExclusion(String str) {
            this.f3403a.zzal(str);
            return this;
        }

        public Builder addCustomEventExtrasBundle(Class cls, Bundle bundle) {
            this.f3403a.zzb(cls, bundle);
            return this;
        }

        public Builder addCustomTargeting(String str, String str2) {
            this.f3403a.zzf(str, str2);
            return this;
        }

        public Builder addCustomTargeting(String str, List list) {
            if (list != null) {
                this.f3403a.zzf(str, zzy.zzhq(",").zza(list));
            }
            return this;
        }

        public Builder addKeyword(String str) {
            this.f3403a.zzaf(str);
            return this;
        }

        public Builder addNetworkExtras(NetworkExtras networkExtras) {
            this.f3403a.zza(networkExtras);
            return this;
        }

        public Builder addNetworkExtrasBundle(Class cls, Bundle bundle) {
            this.f3403a.zza(cls, bundle);
            return this;
        }

        public Builder addTestDevice(String str) {
            this.f3403a.zzag(str);
            return this;
        }

        public PublisherAdRequest build() {
            return new PublisherAdRequest(this);
        }

        public Builder setBirthday(Date date) {
            this.f3403a.zza(date);
            return this;
        }

        public Builder setContentUrl(String str) {
            zzab.zzb((Object) str, (Object) "Content URL must be non-null.");
            zzab.zzh(str, "Content URL must be non-empty.");
            zzab.zzb(str.length() <= 512, "Content URL must not exceed %d in length.  Provided length was %d.", 512, Integer.valueOf(str.length()));
            this.f3403a.zzai(str);
            return this;
        }

        public Builder setGender(int i) {
            this.f3403a.zzt(i);
            return this;
        }

        public Builder setIsDesignedForFamilies(boolean z) {
            this.f3403a.zzo(z);
            return this;
        }

        public Builder setLocation(Location location) {
            this.f3403a.zzb(location);
            return this;
        }

        @Deprecated
        public Builder setManualImpressionsEnabled(boolean z) {
            this.f3403a.setManualImpressionsEnabled(z);
            return this;
        }

        public Builder setPublisherProvidedId(String str) {
            this.f3403a.zzaj(str);
            return this;
        }

        public Builder setRequestAgent(String str) {
            this.f3403a.zzak(str);
            return this;
        }

        public Builder tagForChildDirectedTreatment(boolean z) {
            this.f3403a.zzn(z);
            return this;
        }
    }

    private PublisherAdRequest(Builder builder) {
        this.f3402a = new zzad(builder.f3403a);
    }

    public static void updateCorrelator() {
    }

    public Date getBirthday() {
        return this.f3402a.getBirthday();
    }

    public String getContentUrl() {
        return this.f3402a.getContentUrl();
    }

    public Bundle getCustomEventExtrasBundle(Class cls) {
        return this.f3402a.getCustomEventExtrasBundle(cls);
    }

    public Bundle getCustomTargeting() {
        return this.f3402a.getCustomTargeting();
    }

    public int getGender() {
        return this.f3402a.getGender();
    }

    public Set getKeywords() {
        return this.f3402a.getKeywords();
    }

    public Location getLocation() {
        return this.f3402a.getLocation();
    }

    public boolean getManualImpressionsEnabled() {
        return this.f3402a.getManualImpressionsEnabled();
    }

    @Deprecated
    public NetworkExtras getNetworkExtras(Class cls) {
        return this.f3402a.getNetworkExtras(cls);
    }

    public Bundle getNetworkExtrasBundle(Class cls) {
        return this.f3402a.getNetworkExtrasBundle(cls);
    }

    public String getPublisherProvidedId() {
        return this.f3402a.getPublisherProvidedId();
    }

    public boolean isTestDevice(Context context) {
        return this.f3402a.isTestDevice(context);
    }

    public zzad zzdc() {
        return this.f3402a;
    }
}
