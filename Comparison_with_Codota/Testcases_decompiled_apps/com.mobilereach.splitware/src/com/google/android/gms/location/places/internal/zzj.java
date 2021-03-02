package com.google.android.gms.location.places.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.PlaceDetectionApi;
import com.google.android.gms.location.places.PlaceFilter;
import com.google.android.gms.location.places.PlaceLikelihoodBuffer;
import com.google.android.gms.location.places.PlaceReport;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.zzl;

public class zzj implements PlaceDetectionApi {
    public PendingResult<PlaceLikelihoodBuffer> getCurrentPlace(GoogleApiClient client, final PlaceFilter filter) {
        return client.zza(new zzl.zzd<zzk>(Places.zzaPO, client) {
            /* access modifiers changed from: protected */
            public void zza(zzk zzk) throws RemoteException {
                zzk.zza(new zzl((zzl.zzd) this, zzk.getContext()), filter);
            }
        });
    }

    public PendingResult<Status> reportDeviceAtPlace(GoogleApiClient client, final PlaceReport report) {
        return client.zzb(new zzl.zzf<zzk>(Places.zzaPO, client) {
            /* access modifiers changed from: protected */
            public void zza(zzk zzk) throws RemoteException {
                zzk.zza(new zzl((zzl.zzf) this), report);
            }
        });
    }
}
