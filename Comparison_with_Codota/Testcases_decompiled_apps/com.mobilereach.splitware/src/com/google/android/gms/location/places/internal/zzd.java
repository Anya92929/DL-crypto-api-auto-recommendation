package com.google.android.gms.location.places.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.places.AddPlaceRequest;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.AutocompletePredictionBuffer;
import com.google.android.gms.location.places.GeoDataApi;
import com.google.android.gms.location.places.PlaceBuffer;
import com.google.android.gms.location.places.PlacePhotoMetadataResult;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.zzf;
import com.google.android.gms.location.places.zzl;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Arrays;
import java.util.List;

public class zzd implements GeoDataApi {
    public PendingResult<PlaceBuffer> addPlace(GoogleApiClient client, final AddPlaceRequest addPlaceRequest) {
        return client.zzb(new zzl.zzc<zze>(Places.zzaPN, client) {
            /* access modifiers changed from: protected */
            public void zza(zze zze) throws RemoteException {
                zze.zza(new zzl((zzl.zzc) this, zze.getContext()), addPlaceRequest);
            }
        });
    }

    public PendingResult<AutocompletePredictionBuffer> getAutocompletePredictions(GoogleApiClient client, String query, LatLngBounds bounds, AutocompleteFilter filter) {
        final String str = query;
        final LatLngBounds latLngBounds = bounds;
        final AutocompleteFilter autocompleteFilter = filter;
        return client.zza(new zzl.zza<zze>(Places.zzaPN, client) {
            /* access modifiers changed from: protected */
            public void zza(zze zze) throws RemoteException {
                zze.zza(new zzl((zzl.zza) this), str, latLngBounds, autocompleteFilter);
            }
        });
    }

    public PendingResult<PlaceBuffer> getPlaceById(GoogleApiClient client, final String... placeIds) {
        boolean z = true;
        if (placeIds == null || placeIds.length < 1) {
            z = false;
        }
        zzx.zzac(z);
        return client.zza(new zzl.zzc<zze>(Places.zzaPN, client) {
            /* access modifiers changed from: protected */
            public void zza(zze zze) throws RemoteException {
                zze.zza(new zzl((zzl.zzc) this, zze.getContext()), (List<String>) Arrays.asList(placeIds));
            }
        });
    }

    public PendingResult<PlacePhotoMetadataResult> getPlacePhotos(GoogleApiClient client, final String placeId) {
        return client.zza(new zzf.zzb<zze>(Places.zzaPN, client) {
            /* access modifiers changed from: protected */
            public void zza(zze zze) throws RemoteException {
                zze.zza(new zzf((zzf.zzb) this), placeId);
            }
        });
    }
}
