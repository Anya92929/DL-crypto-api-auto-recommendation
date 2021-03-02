package com.google.android.gms.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.client.zzad;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.common.internal.zzab;
import java.util.Date;
import java.util.Set;

public final class AdRequest {
    public static final String DEVICE_ID_EMULATOR = zzad.DEVICE_ID_EMULATOR;
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;
    public static final int GENDER_FEMALE = 2;
    public static final int GENDER_MALE = 1;
    public static final int GENDER_UNKNOWN = 0;
    public static final int MAX_CONTENT_URL_LENGTH = 512;

    /* renamed from: a */
    private final zzad f3388a;

    public final class Builder {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final zzad.zza f3389a = new zzad.zza();

        public Builder() {
            this.f3389a.zzag(AdRequest.DEVICE_ID_EMULATOR);
        }

        public Builder addCustomEventExtrasBundle(Class cls, Bundle bundle) {
            this.f3389a.zzb(cls, bundle);
            return this;
        }

        public Builder addKeyword(String str) {
            this.f3389a.zzaf(str);
            return this;
        }

        public Builder addNetworkExtras(NetworkExtras networkExtras) {
            this.f3389a.zza(networkExtras);
            return this;
        }

        public Builder addNetworkExtrasBundle(Class cls, Bundle bundle) {
            this.f3389a.zza(cls, bundle);
            if (cls.equals(AdMobAdapter.class) && bundle.getBoolean("_emulatorLiveAds")) {
                this.f3389a.zzah(AdRequest.DEVICE_ID_EMULATOR);
            }
            return this;
        }

        public Builder addTestDevice(String str) {
            this.f3389a.zzag(str);
            return this;
        }

        public AdRequest build() {
            return new AdRequest(this);
        }

        public Builder setBirthday(Date date) {
            this.f3389a.zza(date);
            return this;
        }

        public Builder setContentUrl(String str) {
            zzab.zzb((Object) str, (Object) "Content URL must be non-null.");
            zzab.zzh(str, "Content URL must be non-empty.");
            zzab.zzb(str.length() <= 512, "Content URL must not exceed %d in length.  Provided length was %d.", 512, Integer.valueOf(str.length()));
            this.f3389a.zzai(str);
            return this;
        }

        public Builder setGender(int i) {
            this.f3389a.zzt(i);
            return this;
        }

        public Builder setIsDesignedForFamilies(boolean z) {
            this.f3389a.zzo(z);
            return this;
        }

        public Builder setLocation(Location location) {
            this.f3389a.zzb(location);
            return this;
        }

        public Builder setRequestAgent(String str) {
            this.f3389a.zzak(str);
            return this;
        }

        public Builder tagForChildDirectedTreatment(boolean z) {
            this.f3389a.zzn(z);
            return this;
        }
    }

    private AdRequest(Builder builder) {
        this.f3388a = new zzad(builder.f3389a);
    }

    public Date getBirthday() {
        return this.f3388a.getBirthday();
    }

    public String getContentUrl() {
        return this.f3388a.getContentUrl();
    }

    public Bundle getCustomEventExtrasBundle(Class cls) {
        return this.f3388a.getCustomEventExtrasBundle(cls);
    }

    public int getGender() {
        return this.f3388a.getGender();
    }

    public Set getKeywords() {
        return this.f3388a.getKeywords();
    }

    public Location getLocation() {
        return this.f3388a.getLocation();
    }

    @Deprecated
    public NetworkExtras getNetworkExtras(Class cls) {
        return this.f3388a.getNetworkExtras(cls);
    }

    public Bundle getNetworkExtrasBundle(Class cls) {
        return this.f3388a.getNetworkExtrasBundle(cls);
    }

    public boolean isTestDevice(Context context) {
        return this.f3388a.isTestDevice(context);
    }

    public zzad zzdc() {
        return this.f3388a;
    }
}
