package com.google.android.gms.location.places;

import com.google.android.gms.common.api.Api;

public final class PlacesOptions implements Api.ApiOptions.Optional {
    public final String zzaPU;
    public final int zzaPV;

    public static class Builder {
        /* access modifiers changed from: private */
        public int zzaPV = 0;
        /* access modifiers changed from: private */
        public String zzaPW;

        public PlacesOptions build() {
            return new PlacesOptions(this);
        }
    }

    private PlacesOptions(Builder builder) {
        this.zzaPU = builder.zzaPW;
        this.zzaPV = builder.zzaPV;
    }
}
