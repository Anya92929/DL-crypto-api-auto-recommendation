package com.google.android.gms.location.places;

import android.os.Parcel;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class NearbyAlertFilter extends zza implements SafeParcelable {
    public static final zzd CREATOR = new zzd();
    final int mVersionCode;
    final List<String> zzaPj;
    final List<Integer> zzaPk;
    final List<UserDataType> zzaPl;
    final String zzaPm;
    final boolean zzaPn;
    private final Set<String> zzaPo;
    private final Set<Integer> zzaPp;
    private final Set<UserDataType> zzaPq;

    NearbyAlertFilter(int versionCode, @Nullable List<String> placeIdsList, @Nullable List<Integer> placeTypesList, @Nullable List<UserDataType> requestedUserDataTypesList, @Nullable String chainName, boolean isBeaconRequired) {
        this.mVersionCode = versionCode;
        this.zzaPk = placeTypesList == null ? Collections.emptyList() : Collections.unmodifiableList(placeTypesList);
        this.zzaPl = requestedUserDataTypesList == null ? Collections.emptyList() : Collections.unmodifiableList(requestedUserDataTypesList);
        this.zzaPj = placeIdsList == null ? Collections.emptyList() : Collections.unmodifiableList(placeIdsList);
        this.zzaPp = zzw(this.zzaPk);
        this.zzaPq = zzw(this.zzaPl);
        this.zzaPo = zzw(this.zzaPj);
        this.zzaPm = chainName;
        this.zzaPn = isBeaconRequired;
    }

    public static NearbyAlertFilter zzh(Collection<String> collection) {
        if (collection != null && !collection.isEmpty()) {
            return new NearbyAlertFilter(0, zzf(collection), (List<Integer>) null, (List<UserDataType>) null, (String) null, false);
        }
        throw new IllegalArgumentException("NearbyAlertFilters must contain at least oneplace ID to match results with.");
    }

    public static NearbyAlertFilter zzi(Collection<Integer> collection) {
        if (collection != null && !collection.isEmpty()) {
            return new NearbyAlertFilter(0, (List<String>) null, zzf(collection), (List<UserDataType>) null, (String) null, false);
        }
        throw new IllegalArgumentException("NearbyAlertFilters must contain at least oneplace type to match results with.");
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof NearbyAlertFilter)) {
            return false;
        }
        NearbyAlertFilter nearbyAlertFilter = (NearbyAlertFilter) object;
        if (this.zzaPm != null || nearbyAlertFilter.zzaPm == null) {
            return this.zzaPp.equals(nearbyAlertFilter.zzaPp) && this.zzaPq.equals(nearbyAlertFilter.zzaPq) && this.zzaPo.equals(nearbyAlertFilter.zzaPo) && (this.zzaPm == null || this.zzaPm.equals(nearbyAlertFilter.zzaPm)) && this.zzaPn == nearbyAlertFilter.zzyX();
        }
        return false;
    }

    public Set<String> getPlaceIds() {
        return this.zzaPo;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaPp, this.zzaPq, this.zzaPo, this.zzaPm, Boolean.valueOf(this.zzaPn));
    }

    public String toString() {
        zzw.zza zzy = zzw.zzy(this);
        if (!this.zzaPp.isEmpty()) {
            zzy.zzg("types", this.zzaPp);
        }
        if (!this.zzaPo.isEmpty()) {
            zzy.zzg("placeIds", this.zzaPo);
        }
        if (!this.zzaPq.isEmpty()) {
            zzy.zzg("requestedUserDataTypes", this.zzaPq);
        }
        if (this.zzaPm != null) {
            zzy.zzg("chainName", this.zzaPm);
        }
        zzy.zzg("Beacon required: ", Boolean.valueOf(this.zzaPn));
        return zzy.toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzd.zza(this, parcel, flags);
    }

    public boolean zzyX() {
        return this.zzaPn;
    }
}
