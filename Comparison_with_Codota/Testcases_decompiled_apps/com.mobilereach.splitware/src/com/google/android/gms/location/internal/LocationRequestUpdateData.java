package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.internal.zzg;
import com.google.android.gms.location.zzc;
import com.google.android.gms.location.zzd;

public class LocationRequestUpdateData implements SafeParcelable {
    public static final zzn CREATOR = new zzn();
    PendingIntent mPendingIntent;
    private final int mVersionCode;
    int zzaOU;
    LocationRequestInternal zzaOV;
    zzd zzaOW;
    zzc zzaOX;
    zzg zzaOY;

    LocationRequestUpdateData(int versionCode, int operation, LocationRequestInternal locationRequest, IBinder locationListenerBinder, PendingIntent pendingIntent, IBinder locationCallbackBinder, IBinder fusedLocationProviderCallbackBinder) {
        zzg zzg = null;
        this.mVersionCode = versionCode;
        this.zzaOU = operation;
        this.zzaOV = locationRequest;
        this.zzaOW = locationListenerBinder == null ? null : zzd.zza.zzcf(locationListenerBinder);
        this.mPendingIntent = pendingIntent;
        this.zzaOX = locationCallbackBinder == null ? null : zzc.zza.zzce(locationCallbackBinder);
        this.zzaOY = fusedLocationProviderCallbackBinder != null ? zzg.zza.zzch(fusedLocationProviderCallbackBinder) : zzg;
    }

    public static LocationRequestUpdateData zza(LocationRequestInternal locationRequestInternal, PendingIntent pendingIntent, @Nullable zzg zzg) {
        return new LocationRequestUpdateData(1, 1, locationRequestInternal, (IBinder) null, pendingIntent, (IBinder) null, zzg != null ? zzg.asBinder() : null);
    }

    public static LocationRequestUpdateData zza(LocationRequestInternal locationRequestInternal, zzc zzc, @Nullable zzg zzg) {
        return new LocationRequestUpdateData(1, 1, locationRequestInternal, (IBinder) null, (PendingIntent) null, zzc.asBinder(), zzg != null ? zzg.asBinder() : null);
    }

    public static LocationRequestUpdateData zza(LocationRequestInternal locationRequestInternal, zzd zzd, @Nullable zzg zzg) {
        return new LocationRequestUpdateData(1, 1, locationRequestInternal, zzd.asBinder(), (PendingIntent) null, (IBinder) null, zzg != null ? zzg.asBinder() : null);
    }

    public static LocationRequestUpdateData zza(zzc zzc, @Nullable zzg zzg) {
        return new LocationRequestUpdateData(1, 2, (LocationRequestInternal) null, (IBinder) null, (PendingIntent) null, zzc.asBinder(), zzg != null ? zzg.asBinder() : null);
    }

    public static LocationRequestUpdateData zza(zzd zzd, @Nullable zzg zzg) {
        return new LocationRequestUpdateData(1, 2, (LocationRequestInternal) null, zzd.asBinder(), (PendingIntent) null, (IBinder) null, zzg != null ? zzg.asBinder() : null);
    }

    public static LocationRequestUpdateData zzb(PendingIntent pendingIntent, @Nullable zzg zzg) {
        return new LocationRequestUpdateData(1, 2, (LocationRequestInternal) null, (IBinder) null, pendingIntent, (IBinder) null, zzg != null ? zzg.asBinder() : null);
    }

    public int describeContents() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzn.zza(this, parcel, flags);
    }

    /* access modifiers changed from: package-private */
    public IBinder zzyQ() {
        if (this.zzaOW == null) {
            return null;
        }
        return this.zzaOW.asBinder();
    }

    /* access modifiers changed from: package-private */
    public IBinder zzyR() {
        if (this.zzaOX == null) {
            return null;
        }
        return this.zzaOX.asBinder();
    }

    /* access modifiers changed from: package-private */
    public IBinder zzyS() {
        if (this.zzaOY == null) {
            return null;
        }
        return this.zzaOY.asBinder();
    }
}
