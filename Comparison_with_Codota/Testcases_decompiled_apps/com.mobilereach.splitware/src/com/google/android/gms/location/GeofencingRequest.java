package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.internal.ParcelableGeofence;
import java.util.ArrayList;
import java.util.List;

public class GeofencingRequest implements SafeParcelable {
    public static final Parcelable.Creator<GeofencingRequest> CREATOR = new zza();
    public static final int INITIAL_TRIGGER_DWELL = 4;
    public static final int INITIAL_TRIGGER_ENTER = 1;
    public static final int INITIAL_TRIGGER_EXIT = 2;
    private final int mVersionCode;
    private final List<ParcelableGeofence> zzaNN;
    private final int zzaNO;

    public static final class Builder {
        private final List<ParcelableGeofence> zzaNN = new ArrayList();
        private int zzaNO = 5;

        public static int zzhp(int i) {
            return i & 7;
        }

        public Builder addGeofence(Geofence geofence) {
            zzx.zzb(geofence, (Object) "geofence can't be null.");
            zzx.zzb(geofence instanceof ParcelableGeofence, (Object) "Geofence must be created using Geofence.Builder.");
            this.zzaNN.add((ParcelableGeofence) geofence);
            return this;
        }

        public Builder addGeofences(List<Geofence> geofences) {
            if (geofences != null && !geofences.isEmpty()) {
                for (Geofence next : geofences) {
                    if (next != null) {
                        addGeofence(next);
                    }
                }
            }
            return this;
        }

        public GeofencingRequest build() {
            zzx.zzb(!this.zzaNN.isEmpty(), (Object) "No geofence has been added to this request.");
            return new GeofencingRequest((List) this.zzaNN, this.zzaNO);
        }

        public Builder setInitialTrigger(int initialTrigger) {
            this.zzaNO = zzhp(initialTrigger);
            return this;
        }
    }

    GeofencingRequest(int version, List<ParcelableGeofence> geofences, int initialTrigger) {
        this.mVersionCode = version;
        this.zzaNN = geofences;
        this.zzaNO = initialTrigger;
    }

    private GeofencingRequest(List<ParcelableGeofence> geofences, int initialTrigger) {
        this(1, geofences, initialTrigger);
    }

    public int describeContents() {
        return 0;
    }

    public List<Geofence> getGeofences() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.zzaNN);
        return arrayList;
    }

    public int getInitialTrigger() {
        return this.zzaNO;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zza.zza(this, dest, flags);
    }

    public List<ParcelableGeofence> zzyI() {
        return this.zzaNN;
    }
}
