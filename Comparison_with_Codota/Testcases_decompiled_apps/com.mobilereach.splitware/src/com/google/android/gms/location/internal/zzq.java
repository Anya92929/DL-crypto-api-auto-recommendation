package com.google.android.gms.location.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.SettingsApi;

public class zzq implements SettingsApi {
    public PendingResult<LocationSettingsResult> checkLocationSettings(GoogleApiClient client, LocationSettingsRequest request) {
        return zza(client, request, (String) null);
    }

    public PendingResult<LocationSettingsResult> zza(GoogleApiClient googleApiClient, final LocationSettingsRequest locationSettingsRequest, final String str) {
        return googleApiClient.zza(new LocationServices.zza<LocationSettingsResult>(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzl zzl) throws RemoteException {
                zzl.zza(locationSettingsRequest, (zza.zzb<LocationSettingsResult>) this, str);
            }

            /* renamed from: zzaR */
            public LocationSettingsResult zzc(Status status) {
                return new LocationSettingsResult(status);
            }
        });
    }
}
