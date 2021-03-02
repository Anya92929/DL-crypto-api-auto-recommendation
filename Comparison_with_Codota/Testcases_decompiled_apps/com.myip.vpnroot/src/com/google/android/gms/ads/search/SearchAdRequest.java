package com.google.android.gms.ads.search;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.internal.C0944bg;

public final class SearchAdRequest {
    public static final int BORDER_TYPE_DASHED = 1;
    public static final int BORDER_TYPE_DOTTED = 2;
    public static final int BORDER_TYPE_NONE = 0;
    public static final int BORDER_TYPE_SOLID = 3;
    public static final int CALL_BUTTON_COLOR_DARK = 2;
    public static final int CALL_BUTTON_COLOR_LIGHT = 0;
    public static final int CALL_BUTTON_COLOR_MEDIUM = 1;
    public static final String DEVICE_ID_EMULATOR = C0944bg.DEVICE_ID_EMULATOR;
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;

    /* renamed from: ld */
    private final C0944bg f57ld;

    /* renamed from: xl */
    private final int f58xl;

    /* renamed from: xm */
    private final int f59xm;

    /* renamed from: xn */
    private final int f60xn;

    /* renamed from: xo */
    private final int f61xo;

    /* renamed from: xp */
    private final int f62xp;

    /* renamed from: xq */
    private final int f63xq;

    /* renamed from: xr */
    private final int f64xr;

    /* renamed from: xs */
    private final int f65xs;

    /* renamed from: xt */
    private final String f66xt;

    /* renamed from: xu */
    private final int f67xu;

    /* renamed from: xv */
    private final String f68xv;

    /* renamed from: xw */
    private final int f69xw;

    /* renamed from: xx */
    private final int f70xx;

    /* renamed from: xy */
    private final String f71xy;

    public static final class Builder {
        /* access modifiers changed from: private */

        /* renamed from: le */
        public final C0944bg.C0945a f72le = new C0944bg.C0945a();
        /* access modifiers changed from: private */

        /* renamed from: xl */
        public int f73xl;
        /* access modifiers changed from: private */

        /* renamed from: xm */
        public int f74xm;
        /* access modifiers changed from: private */

        /* renamed from: xn */
        public int f75xn;
        /* access modifiers changed from: private */

        /* renamed from: xo */
        public int f76xo;
        /* access modifiers changed from: private */

        /* renamed from: xp */
        public int f77xp;
        /* access modifiers changed from: private */

        /* renamed from: xq */
        public int f78xq;
        /* access modifiers changed from: private */

        /* renamed from: xr */
        public int f79xr = 0;
        /* access modifiers changed from: private */

        /* renamed from: xs */
        public int f80xs;
        /* access modifiers changed from: private */

        /* renamed from: xt */
        public String f81xt;
        /* access modifiers changed from: private */

        /* renamed from: xu */
        public int f82xu;
        /* access modifiers changed from: private */

        /* renamed from: xv */
        public String f83xv;
        /* access modifiers changed from: private */

        /* renamed from: xw */
        public int f84xw;
        /* access modifiers changed from: private */

        /* renamed from: xx */
        public int f85xx;
        /* access modifiers changed from: private */

        /* renamed from: xy */
        public String f86xy;

        public Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> adapterClass, Bundle customEventExtras) {
            this.f72le.mo8082b(adapterClass, customEventExtras);
            return this;
        }

        public Builder addNetworkExtras(NetworkExtras networkExtras) {
            this.f72le.mo8079a(networkExtras);
            return this;
        }

        public Builder addNetworkExtrasBundle(Class<? extends MediationAdapter> adapterClass, Bundle networkExtras) {
            this.f72le.mo8080a(adapterClass, networkExtras);
            return this;
        }

        public Builder addTestDevice(String deviceId) {
            this.f72le.mo8087s(deviceId);
            return this;
        }

        public SearchAdRequest build() {
            return new SearchAdRequest(this);
        }

        public Builder setAnchorTextColor(int anchorTextColor) {
            this.f73xl = anchorTextColor;
            return this;
        }

        public Builder setBackgroundColor(int backgroundColor) {
            this.f74xm = backgroundColor;
            this.f75xn = Color.argb(0, 0, 0, 0);
            this.f76xo = Color.argb(0, 0, 0, 0);
            return this;
        }

        public Builder setBackgroundGradient(int top, int bottom) {
            this.f74xm = Color.argb(0, 0, 0, 0);
            this.f75xn = bottom;
            this.f76xo = top;
            return this;
        }

        public Builder setBorderColor(int borderColor) {
            this.f77xp = borderColor;
            return this;
        }

        public Builder setBorderThickness(int borderThickness) {
            this.f78xq = borderThickness;
            return this;
        }

        public Builder setBorderType(int borderType) {
            this.f79xr = borderType;
            return this;
        }

        public Builder setCallButtonColor(int callButtonColor) {
            this.f80xs = callButtonColor;
            return this;
        }

        public Builder setCustomChannels(String channelIds) {
            this.f81xt = channelIds;
            return this;
        }

        public Builder setDescriptionTextColor(int descriptionTextColor) {
            this.f82xu = descriptionTextColor;
            return this;
        }

        public Builder setFontFace(String fontFace) {
            this.f83xv = fontFace;
            return this;
        }

        public Builder setHeaderTextColor(int headerTextColor) {
            this.f84xw = headerTextColor;
            return this;
        }

        public Builder setHeaderTextSize(int headerTextSize) {
            this.f85xx = headerTextSize;
            return this;
        }

        public Builder setLocation(Location location) {
            this.f72le.mo8078a(location);
            return this;
        }

        public Builder setQuery(String query) {
            this.f86xy = query;
            return this;
        }

        public Builder tagForChildDirectedTreatment(boolean tagForChildDirectedTreatment) {
            this.f72le.mo8085h(tagForChildDirectedTreatment);
            return this;
        }
    }

    private SearchAdRequest(Builder builder) {
        this.f58xl = builder.f73xl;
        this.f59xm = builder.f74xm;
        this.f60xn = builder.f75xn;
        this.f61xo = builder.f76xo;
        this.f62xp = builder.f77xp;
        this.f63xq = builder.f78xq;
        this.f64xr = builder.f79xr;
        this.f65xs = builder.f80xs;
        this.f66xt = builder.f81xt;
        this.f67xu = builder.f82xu;
        this.f68xv = builder.f83xv;
        this.f69xw = builder.f84xw;
        this.f70xx = builder.f85xx;
        this.f71xy = builder.f86xy;
        this.f57ld = new C0944bg(builder.f72le, this);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: V */
    public C0944bg mo3421V() {
        return this.f57ld;
    }

    public int getAnchorTextColor() {
        return this.f58xl;
    }

    public int getBackgroundColor() {
        return this.f59xm;
    }

    public int getBackgroundGradientBottom() {
        return this.f60xn;
    }

    public int getBackgroundGradientTop() {
        return this.f61xo;
    }

    public int getBorderColor() {
        return this.f62xp;
    }

    public int getBorderThickness() {
        return this.f63xq;
    }

    public int getBorderType() {
        return this.f64xr;
    }

    public int getCallButtonColor() {
        return this.f65xs;
    }

    public String getCustomChannels() {
        return this.f66xt;
    }

    public <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> adapterClass) {
        return this.f57ld.getCustomEventExtrasBundle(adapterClass);
    }

    public int getDescriptionTextColor() {
        return this.f67xu;
    }

    public String getFontFace() {
        return this.f68xv;
    }

    public int getHeaderTextColor() {
        return this.f69xw;
    }

    public int getHeaderTextSize() {
        return this.f70xx;
    }

    public Location getLocation() {
        return this.f57ld.getLocation();
    }

    @Deprecated
    public <T extends NetworkExtras> T getNetworkExtras(Class<T> networkExtrasClass) {
        return this.f57ld.getNetworkExtras(networkExtrasClass);
    }

    public <T extends MediationAdapter> Bundle getNetworkExtrasBundle(Class<T> adapterClass) {
        return this.f57ld.getNetworkExtrasBundle(adapterClass);
    }

    public String getQuery() {
        return this.f71xy;
    }

    public boolean isTestDevice(Context context) {
        return this.f57ld.isTestDevice(context);
    }
}
