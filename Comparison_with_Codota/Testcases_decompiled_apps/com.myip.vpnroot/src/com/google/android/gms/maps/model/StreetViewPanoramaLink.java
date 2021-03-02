package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class StreetViewPanoramaLink implements SafeParcelable {
    public static final C1918r CREATOR = new C1918r();

    /* renamed from: BR */
    private final int f4476BR;
    public final float bearing;
    public final String panoId;

    StreetViewPanoramaLink(int versionCode, String panoId2, float bearing2) {
        this.f4476BR = versionCode;
        this.panoId = panoId2;
        this.bearing = (((double) bearing2) <= 0.0d ? (bearing2 % 360.0f) + 360.0f : bearing2) % 360.0f;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StreetViewPanoramaLink)) {
            return false;
        }
        StreetViewPanoramaLink streetViewPanoramaLink = (StreetViewPanoramaLink) o;
        return this.panoId.equals(streetViewPanoramaLink.panoId) && Float.floatToIntBits(this.bearing) == Float.floatToIntBits(streetViewPanoramaLink.bearing);
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f4476BR;
    }

    public int hashCode() {
        return C0345m.hashCode(this.panoId, Float.valueOf(this.bearing));
    }

    public String toString() {
        return C0345m.m848h(this).mo4549a("panoId", this.panoId).mo4549a("bearing", Float.valueOf(this.bearing)).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        C1918r.m6493a(this, out, flags);
    }
}
