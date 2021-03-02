package com.google.android.gms.ads.search;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzad;
import com.google.android.gms.ads.mediation.NetworkExtras;

public final class SearchAdRequest {
    public static final int BORDER_TYPE_DASHED = 1;
    public static final int BORDER_TYPE_DOTTED = 2;
    public static final int BORDER_TYPE_NONE = 0;
    public static final int BORDER_TYPE_SOLID = 3;
    public static final int CALL_BUTTON_COLOR_DARK = 2;
    public static final int CALL_BUTTON_COLOR_LIGHT = 0;
    public static final int CALL_BUTTON_COLOR_MEDIUM = 1;
    public static final String DEVICE_ID_EMULATOR = zzad.DEVICE_ID_EMULATOR;
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;

    /* renamed from: a */
    private final zzad f4156a;

    /* renamed from: b */
    private final int f4157b;

    /* renamed from: c */
    private final int f4158c;

    /* renamed from: d */
    private final int f4159d;

    /* renamed from: e */
    private final int f4160e;

    /* renamed from: f */
    private final int f4161f;

    /* renamed from: g */
    private final int f4162g;

    /* renamed from: h */
    private final int f4163h;

    /* renamed from: i */
    private final int f4164i;

    /* renamed from: j */
    private final String f4165j;

    /* renamed from: k */
    private final int f4166k;

    /* renamed from: l */
    private final String f4167l;

    /* renamed from: m */
    private final int f4168m;

    /* renamed from: n */
    private final int f4169n;

    /* renamed from: o */
    private final String f4170o;

    public final class Builder {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final zzad.zza f4171a = new zzad.zza();
        /* access modifiers changed from: private */

        /* renamed from: b */
        public int f4172b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public int f4173c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public int f4174d;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public int f4175e;
        /* access modifiers changed from: private */

        /* renamed from: f */
        public int f4176f;
        /* access modifiers changed from: private */

        /* renamed from: g */
        public int f4177g;
        /* access modifiers changed from: private */

        /* renamed from: h */
        public int f4178h = 0;
        /* access modifiers changed from: private */

        /* renamed from: i */
        public int f4179i;
        /* access modifiers changed from: private */

        /* renamed from: j */
        public String f4180j;
        /* access modifiers changed from: private */

        /* renamed from: k */
        public int f4181k;
        /* access modifiers changed from: private */

        /* renamed from: l */
        public String f4182l;
        /* access modifiers changed from: private */

        /* renamed from: m */
        public int f4183m;
        /* access modifiers changed from: private */

        /* renamed from: n */
        public int f4184n;
        /* access modifiers changed from: private */

        /* renamed from: o */
        public String f4185o;

        public Builder addCustomEventExtrasBundle(Class cls, Bundle bundle) {
            this.f4171a.zzb(cls, bundle);
            return this;
        }

        public Builder addNetworkExtras(NetworkExtras networkExtras) {
            this.f4171a.zza(networkExtras);
            return this;
        }

        public Builder addNetworkExtrasBundle(Class cls, Bundle bundle) {
            this.f4171a.zza(cls, bundle);
            return this;
        }

        public Builder addTestDevice(String str) {
            this.f4171a.zzag(str);
            return this;
        }

        public SearchAdRequest build() {
            return new SearchAdRequest(this);
        }

        public Builder setAnchorTextColor(int i) {
            this.f4172b = i;
            return this;
        }

        public Builder setBackgroundColor(int i) {
            this.f4173c = i;
            this.f4174d = Color.argb(0, 0, 0, 0);
            this.f4175e = Color.argb(0, 0, 0, 0);
            return this;
        }

        public Builder setBackgroundGradient(int i, int i2) {
            this.f4173c = Color.argb(0, 0, 0, 0);
            this.f4174d = i2;
            this.f4175e = i;
            return this;
        }

        public Builder setBorderColor(int i) {
            this.f4176f = i;
            return this;
        }

        public Builder setBorderThickness(int i) {
            this.f4177g = i;
            return this;
        }

        public Builder setBorderType(int i) {
            this.f4178h = i;
            return this;
        }

        public Builder setCallButtonColor(int i) {
            this.f4179i = i;
            return this;
        }

        public Builder setCustomChannels(String str) {
            this.f4180j = str;
            return this;
        }

        public Builder setDescriptionTextColor(int i) {
            this.f4181k = i;
            return this;
        }

        public Builder setFontFace(String str) {
            this.f4182l = str;
            return this;
        }

        public Builder setHeaderTextColor(int i) {
            this.f4183m = i;
            return this;
        }

        public Builder setHeaderTextSize(int i) {
            this.f4184n = i;
            return this;
        }

        public Builder setLocation(Location location) {
            this.f4171a.zzb(location);
            return this;
        }

        public Builder setQuery(String str) {
            this.f4185o = str;
            return this;
        }

        public Builder setRequestAgent(String str) {
            this.f4171a.zzak(str);
            return this;
        }

        public Builder tagForChildDirectedTreatment(boolean z) {
            this.f4171a.zzn(z);
            return this;
        }
    }

    private SearchAdRequest(Builder builder) {
        this.f4157b = builder.f4172b;
        this.f4158c = builder.f4173c;
        this.f4159d = builder.f4174d;
        this.f4160e = builder.f4175e;
        this.f4161f = builder.f4176f;
        this.f4162g = builder.f4177g;
        this.f4163h = builder.f4178h;
        this.f4164i = builder.f4179i;
        this.f4165j = builder.f4180j;
        this.f4166k = builder.f4181k;
        this.f4167l = builder.f4182l;
        this.f4168m = builder.f4183m;
        this.f4169n = builder.f4184n;
        this.f4170o = builder.f4185o;
        this.f4156a = new zzad(builder.f4171a, this);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public zzad mo6063a() {
        return this.f4156a;
    }

    public int getAnchorTextColor() {
        return this.f4157b;
    }

    public int getBackgroundColor() {
        return this.f4158c;
    }

    public int getBackgroundGradientBottom() {
        return this.f4159d;
    }

    public int getBackgroundGradientTop() {
        return this.f4160e;
    }

    public int getBorderColor() {
        return this.f4161f;
    }

    public int getBorderThickness() {
        return this.f4162g;
    }

    public int getBorderType() {
        return this.f4163h;
    }

    public int getCallButtonColor() {
        return this.f4164i;
    }

    public String getCustomChannels() {
        return this.f4165j;
    }

    public Bundle getCustomEventExtrasBundle(Class cls) {
        return this.f4156a.getCustomEventExtrasBundle(cls);
    }

    public int getDescriptionTextColor() {
        return this.f4166k;
    }

    public String getFontFace() {
        return this.f4167l;
    }

    public int getHeaderTextColor() {
        return this.f4168m;
    }

    public int getHeaderTextSize() {
        return this.f4169n;
    }

    public Location getLocation() {
        return this.f4156a.getLocation();
    }

    @Deprecated
    public NetworkExtras getNetworkExtras(Class cls) {
        return this.f4156a.getNetworkExtras(cls);
    }

    public Bundle getNetworkExtrasBundle(Class cls) {
        return this.f4156a.getNetworkExtrasBundle(cls);
    }

    public String getQuery() {
        return this.f4170o;
    }

    public boolean isTestDevice(Context context) {
        return this.f4156a.isTestDevice(context);
    }
}
