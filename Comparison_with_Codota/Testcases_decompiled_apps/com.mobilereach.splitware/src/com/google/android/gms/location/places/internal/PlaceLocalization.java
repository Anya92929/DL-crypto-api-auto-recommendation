package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.List;

@Deprecated
public final class PlaceLocalization implements SafeParcelable {
    public static final zzo CREATOR = new zzo();
    public final String address;
    public final String name;
    public final int versionCode;
    public final String zzaQO;
    public final String zzaQP;
    public final List<String> zzaQQ;

    public PlaceLocalization(int versionCode2, String name2, String address2, String internationalPhoneNumber, String regularOpenHours, List<String> attributions) {
        this.versionCode = versionCode2;
        this.name = name2;
        this.address = address2;
        this.zzaQO = internationalPhoneNumber;
        this.zzaQP = regularOpenHours;
        this.zzaQQ = attributions;
    }

    public static PlaceLocalization zza(String str, String str2, String str3, String str4, List<String> list) {
        return new PlaceLocalization(0, str, str2, str3, str4, list);
    }

    public int describeContents() {
        zzo zzo = CREATOR;
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof PlaceLocalization)) {
            return false;
        }
        PlaceLocalization placeLocalization = (PlaceLocalization) object;
        return zzw.equal(this.name, placeLocalization.name) && zzw.equal(this.address, placeLocalization.address) && zzw.equal(this.zzaQO, placeLocalization.zzaQO) && zzw.equal(this.zzaQP, placeLocalization.zzaQP) && zzw.equal(this.zzaQQ, placeLocalization.zzaQQ);
    }

    public int hashCode() {
        return zzw.hashCode(this.name, this.address, this.zzaQO, this.zzaQP);
    }

    public String toString() {
        return zzw.zzy(this).zzg("name", this.name).zzg("address", this.address).zzg("internationalPhoneNumber", this.zzaQO).zzg("regularOpenHours", this.zzaQP).zzg("attributions", this.zzaQQ).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzo zzo = CREATOR;
        zzo.zza(this, parcel, flags);
    }
}
