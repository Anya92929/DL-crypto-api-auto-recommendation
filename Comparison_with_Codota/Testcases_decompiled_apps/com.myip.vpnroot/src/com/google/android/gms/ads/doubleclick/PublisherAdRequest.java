package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.internal.C0944bg;
import java.util.Date;
import java.util.Set;

public final class PublisherAdRequest {
    public static final String DEVICE_ID_EMULATOR = C0944bg.DEVICE_ID_EMULATOR;
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;
    public static final int GENDER_FEMALE = 2;
    public static final int GENDER_MALE = 1;
    public static final int GENDER_UNKNOWN = 0;

    /* renamed from: ld */
    private final C0944bg f38ld;

    public static final class Builder {
        /* access modifiers changed from: private */

        /* renamed from: le */
        public final C0944bg.C0945a f39le = new C0944bg.C0945a();

        public Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> adapterClass, Bundle customEventExtras) {
            this.f39le.mo8082b(adapterClass, customEventExtras);
            return this;
        }

        public Builder addKeyword(String keyword) {
            this.f39le.mo8086r(keyword);
            return this;
        }

        public Builder addNetworkExtras(NetworkExtras networkExtras) {
            this.f39le.mo8079a(networkExtras);
            return this;
        }

        public Builder addNetworkExtrasBundle(Class<? extends MediationAdapter> adapterClass, Bundle networkExtras) {
            this.f39le.mo8080a(adapterClass, networkExtras);
            return this;
        }

        public Builder addTestDevice(String deviceId) {
            this.f39le.mo8087s(deviceId);
            return this;
        }

        public PublisherAdRequest build() {
            return new PublisherAdRequest(this);
        }

        public Builder setBirthday(Date birthday) {
            this.f39le.mo8081a(birthday);
            return this;
        }

        public Builder setContentUrl(String contentUrl) {
            C0348n.m857b(contentUrl, (Object) "Content URL must be non-null.");
            C0348n.m858b(contentUrl, (Object) "Content URL must be non-empty.");
            C0348n.m860b(contentUrl.length() <= 512, "Content URL must not exceed %d in length.  Provided length was %d.", 512, Integer.valueOf(contentUrl.length()));
            this.f39le.mo8088t(contentUrl);
            return this;
        }

        public Builder setGender(int gender) {
            this.f39le.mo8083g(gender);
            return this;
        }

        public Builder setLocation(Location location) {
            this.f39le.mo8078a(location);
            return this;
        }

        public Builder setManualImpressionsEnabled(boolean manualImpressionsEnabled) {
            this.f39le.mo8084g(manualImpressionsEnabled);
            return this;
        }

        public Builder setPublisherProvidedId(String publisherProvidedId) {
            this.f39le.mo8089u(publisherProvidedId);
            return this;
        }

        public Builder tagForChildDirectedTreatment(boolean tagForChildDirectedTreatment) {
            this.f39le.mo8085h(tagForChildDirectedTreatment);
            return this;
        }
    }

    private PublisherAdRequest(Builder builder) {
        this.f38ld = new C0944bg(builder.f39le);
    }

    /* renamed from: V */
    public C0944bg mo3311V() {
        return this.f38ld;
    }

    public Date getBirthday() {
        return this.f38ld.getBirthday();
    }

    public String getContentUrl() {
        return this.f38ld.getContentUrl();
    }

    public <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> adapterClass) {
        return this.f38ld.getCustomEventExtrasBundle(adapterClass);
    }

    public int getGender() {
        return this.f38ld.getGender();
    }

    public Set<String> getKeywords() {
        return this.f38ld.getKeywords();
    }

    public Location getLocation() {
        return this.f38ld.getLocation();
    }

    public boolean getManualImpressionsEnabled() {
        return this.f38ld.getManualImpressionsEnabled();
    }

    @Deprecated
    public <T extends NetworkExtras> T getNetworkExtras(Class<T> networkExtrasClass) {
        return this.f38ld.getNetworkExtras(networkExtrasClass);
    }

    public <T extends MediationAdapter> Bundle getNetworkExtrasBundle(Class<T> adapterClass) {
        return this.f38ld.getNetworkExtrasBundle(adapterClass);
    }

    public String getPublisherProvidedId() {
        return this.f38ld.getPublisherProvidedId();
    }

    public boolean isTestDevice(Context context) {
        return this.f38ld.isTestDevice(context);
    }
}
