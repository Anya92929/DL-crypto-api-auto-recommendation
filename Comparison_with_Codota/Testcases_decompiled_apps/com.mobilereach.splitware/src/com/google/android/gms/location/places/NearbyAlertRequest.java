package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public final class NearbyAlertRequest implements SafeParcelable {
    public static final zze CREATOR = new zze();
    private int mPriority = SktSsiProtocol.kSsiSerialInterfaceIntercharacterDelay;
    private final int mVersionCode;
    private final int zzaNC;
    private final int zzaPr;
    @Deprecated
    private final PlaceFilter zzaPs;
    private final NearbyAlertFilter zzaPt;
    private final boolean zzaPu;
    private final int zzaPv;

    NearbyAlertRequest(int versionCode, int transitionTypes, int loiteringTimeMillis, PlaceFilter placeFilter, NearbyAlertFilter nearbyAlertFilter, boolean isDebugInfoRequested, int radiusType, int priority) {
        this.mVersionCode = versionCode;
        this.zzaNC = transitionTypes;
        this.zzaPr = loiteringTimeMillis;
        if (nearbyAlertFilter != null) {
            this.zzaPt = nearbyAlertFilter;
        } else if (placeFilter == null) {
            this.zzaPt = null;
        } else if (placeFilter.getPlaceIds() != null && !placeFilter.getPlaceIds().isEmpty()) {
            this.zzaPt = NearbyAlertFilter.zzh(placeFilter.getPlaceIds());
        } else if (placeFilter.getPlaceTypes() == null || placeFilter.getPlaceTypes().isEmpty()) {
            this.zzaPt = null;
        } else {
            this.zzaPt = NearbyAlertFilter.zzi(placeFilter.getPlaceTypes());
        }
        this.zzaPs = null;
        this.zzaPu = isDebugInfoRequested;
        this.zzaPv = radiusType;
        this.mPriority = priority;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof NearbyAlertRequest)) {
            return false;
        }
        NearbyAlertRequest nearbyAlertRequest = (NearbyAlertRequest) object;
        return this.zzaNC == nearbyAlertRequest.zzaNC && this.zzaPr == nearbyAlertRequest.zzaPr && zzw.equal(this.zzaPt, nearbyAlertRequest.zzaPt) && this.mPriority == nearbyAlertRequest.mPriority;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.zzaNC), Integer.valueOf(this.zzaPr), this.zzaPt, Integer.valueOf(this.mPriority));
    }

    public String toString() {
        return zzw.zzy(this).zzg("transitionTypes", Integer.valueOf(this.zzaNC)).zzg("loiteringTimeMillis", Integer.valueOf(this.zzaPr)).zzg("nearbyAlertFilter", this.zzaPt).zzg("priority", Integer.valueOf(this.mPriority)).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zze.zza(this, parcel, flags);
    }

    public int zzyV() {
        return this.zzaNC;
    }

    public int zzyY() {
        return this.zzaPr;
    }

    @Deprecated
    public PlaceFilter zzyZ() {
        return null;
    }

    public NearbyAlertFilter zzza() {
        return this.zzaPt;
    }

    public boolean zzzb() {
        return this.zzaPu;
    }

    public int zzzc() {
        return this.zzaPv;
    }
}
