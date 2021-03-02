package com.google.android.gms.location;

import android.content.Intent;
import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class LocationResult implements SafeParcelable {
    public static final Parcelable.Creator<LocationResult> CREATOR = new zze();
    static final List<Location> zzaOd = Collections.emptyList();
    private final int mVersionCode;
    private final List<Location> zzaOe;

    LocationResult(int versionCode, List<Location> locations) {
        this.mVersionCode = versionCode;
        this.zzaOe = locations;
    }

    public static LocationResult create(List<Location> locations) {
        if (locations == null) {
            locations = zzaOd;
        }
        return new LocationResult(2, locations);
    }

    public static LocationResult extractResult(Intent intent) {
        if (!hasResult(intent)) {
            return null;
        }
        return (LocationResult) intent.getExtras().getParcelable("com.google.android.gms.location.EXTRA_LOCATION_RESULT");
    }

    public static boolean hasResult(Intent intent) {
        if (intent == null) {
            return false;
        }
        return intent.hasExtra("com.google.android.gms.location.EXTRA_LOCATION_RESULT");
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (!(other instanceof LocationResult)) {
            return false;
        }
        LocationResult locationResult = (LocationResult) other;
        if (locationResult.zzaOe.size() != this.zzaOe.size()) {
            return false;
        }
        Iterator<Location> it = this.zzaOe.iterator();
        for (Location time : locationResult.zzaOe) {
            if (it.next().getTime() != time.getTime()) {
                return false;
            }
        }
        return true;
    }

    @NonNull
    public Location getLastLocation() {
        int size = this.zzaOe.size();
        if (size == 0) {
            return null;
        }
        return this.zzaOe.get(size - 1);
    }

    @NonNull
    public List<Location> getLocations() {
        return this.zzaOe;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        int i = 17;
        Iterator<Location> it = this.zzaOe.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            long time = it.next().getTime();
            i = ((int) (time ^ (time >>> 32))) + (i2 * 31);
        }
    }

    public String toString() {
        return "LocationResult[locations: " + this.zzaOe + "]";
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zze.zza(this, parcel, flags);
    }
}
