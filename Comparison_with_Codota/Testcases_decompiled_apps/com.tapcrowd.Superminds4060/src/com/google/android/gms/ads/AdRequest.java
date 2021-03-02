package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.internal.C0343cm;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class AdRequest {
    public static final String DEVICE_ID_EMULATOR = C0343cm.m729l("emulator");
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;
    public static final int GENDER_FEMALE = 2;
    public static final int GENDER_MALE = 1;
    public static final int GENDER_UNKNOWN = 0;

    /* renamed from: d */
    private final Date f298d;

    /* renamed from: dI */
    private final int f299dI;

    /* renamed from: dJ */
    private final Map<Class<? extends NetworkExtras>, NetworkExtras> f300dJ;

    /* renamed from: dK */
    private final int f301dK;

    /* renamed from: dL */
    private final Set<String> f302dL;

    /* renamed from: f */
    private final Set<String> f303f;

    public static final class Builder {
        /* access modifiers changed from: private */

        /* renamed from: d */
        public Date f304d;
        /* access modifiers changed from: private */

        /* renamed from: dI */
        public int f305dI = -1;
        /* access modifiers changed from: private */

        /* renamed from: dK */
        public int f306dK = -1;
        /* access modifiers changed from: private */

        /* renamed from: dM */
        public final HashSet<String> f307dM = new HashSet<>();
        /* access modifiers changed from: private */

        /* renamed from: dN */
        public final HashMap<Class<? extends NetworkExtras>, NetworkExtras> f308dN = new HashMap<>();
        /* access modifiers changed from: private */

        /* renamed from: dO */
        public final HashSet<String> f309dO = new HashSet<>();

        public Builder addKeyword(String keyword) {
            this.f307dM.add(keyword);
            return this;
        }

        public Builder addNetworkExtras(NetworkExtras networkExtras) {
            this.f308dN.put(networkExtras.getClass(), networkExtras);
            return this;
        }

        public Builder addTestDevice(String deviceId) {
            this.f309dO.add(deviceId);
            return this;
        }

        public AdRequest build() {
            return new AdRequest(this);
        }

        public Builder setBirthday(Date birthday) {
            this.f304d = birthday;
            return this;
        }

        public Builder setGender(int gender) {
            this.f305dI = gender;
            return this;
        }

        public Builder tagForChildDirectedTreatment(boolean tagForChildDirectedTreatment) {
            this.f306dK = tagForChildDirectedTreatment ? 1 : 0;
            return this;
        }
    }

    private AdRequest(Builder builder) {
        this.f298d = builder.f304d;
        this.f299dI = builder.f305dI;
        this.f303f = Collections.unmodifiableSet(builder.f307dM);
        this.f300dJ = Collections.unmodifiableMap(builder.f308dN);
        this.f301dK = builder.f306dK;
        this.f302dL = Collections.unmodifiableSet(builder.f309dO);
    }

    public Date getBirthday() {
        return this.f298d;
    }

    public int getGender() {
        return this.f299dI;
    }

    public Set<String> getKeywords() {
        return this.f303f;
    }

    public <T extends NetworkExtras> T getNetworkExtras(Class<T> networkExtrasClass) {
        return (NetworkExtras) this.f300dJ.get(networkExtrasClass);
    }

    public boolean isTestDevice(Context context) {
        return this.f302dL.contains(C0343cm.m728l(context));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: v */
    public Map<Class<? extends NetworkExtras>, NetworkExtras> mo3460v() {
        return this.f300dJ;
    }

    /* renamed from: w */
    public int mo3461w() {
        return this.f301dK;
    }
}
