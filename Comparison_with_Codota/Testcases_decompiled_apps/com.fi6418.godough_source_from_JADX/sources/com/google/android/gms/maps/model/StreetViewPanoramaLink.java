package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.C1006bc;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class StreetViewPanoramaLink implements SafeParcelable {
    public static final zzk CREATOR = new zzk();

    /* renamed from: a */
    private final int f5195a;
    public final float bearing;
    public final String panoId;

    StreetViewPanoramaLink(int i, String str, float f) {
        this.f5195a = i;
        this.panoId = str;
        this.bearing = (((double) f) <= 0.0d ? (f % 360.0f) + 360.0f : f) % 360.0f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo8715a() {
        return this.f5195a;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreetViewPanoramaLink)) {
            return false;
        }
        StreetViewPanoramaLink streetViewPanoramaLink = (StreetViewPanoramaLink) obj;
        return this.panoId.equals(streetViewPanoramaLink.panoId) && Float.floatToIntBits(this.bearing) == Float.floatToIntBits(streetViewPanoramaLink.bearing);
    }

    public int hashCode() {
        return C1006bc.m4523a(this.panoId, Float.valueOf(this.bearing));
    }

    public String toString() {
        return C1006bc.m4524a((Object) this).mo7604a("panoId", this.panoId).mo7604a("bearing", Float.valueOf(this.bearing)).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzk.m5126a(this, parcel, i);
    }
}
