package com.google.android.gms.location.places.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.places.AddPlaceRequest;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.PlacesOptions;
import com.google.android.gms.location.places.internal.zzg;
import com.google.android.gms.location.places.zzl;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

public class zze extends zzj<zzg> {
    private final PlacesParams zzaQq;
    private final Locale zzaQr = Locale.getDefault();

    public static class zza extends Api.zza<zze, PlacesOptions> {
        private final String zzaQs;

        public zza(String str) {
            this.zzaQs = str;
        }

        public zze zza(Context context, Looper looper, zzf zzf, PlacesOptions placesOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zze(context, looper, zzf, connectionCallbacks, onConnectionFailedListener, this.zzaQs != null ? this.zzaQs : context.getPackageName(), placesOptions == null ? new PlacesOptions.Builder().build() : placesOptions);
        }
    }

    public zze(Context context, Looper looper, zzf zzf, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, String str, PlacesOptions placesOptions) {
        super(context, looper, 65, zzf, connectionCallbacks, onConnectionFailedListener);
        this.zzaQq = new PlacesParams(str, this.zzaQr, zzf.getAccount() != null ? zzf.getAccount().name : null, placesOptions.zzaPU, placesOptions.zzaPV);
    }

    public void zza(com.google.android.gms.location.places.zzf zzf, String str) throws RemoteException {
        zzx.zzb(str, (Object) "placeId cannot be null");
        ((zzg) zzqJ()).zza(str, this.zzaQq, (zzh) zzf);
    }

    public void zza(com.google.android.gms.location.places.zzf zzf, String str, int i, int i2, int i3) throws RemoteException {
        boolean z = true;
        zzx.zzb(str, (Object) "fifeUrl cannot be null");
        zzx.zzb(i > 0, (Object) "width should be > 0");
        if (i <= 0) {
            z = false;
        }
        zzx.zzb(z, (Object) "height should be > 0");
        ((zzg) zzqJ()).zza(str, i, i2, i3, this.zzaQq, (zzh) zzf);
    }

    public void zza(zzl zzl, AddPlaceRequest addPlaceRequest) throws RemoteException {
        zzx.zzb(addPlaceRequest, (Object) "userAddedPlace == null");
        ((zzg) zzqJ()).zza(addPlaceRequest, this.zzaQq, (zzi) zzl);
    }

    public void zza(zzl zzl, String str, @Nullable LatLngBounds latLngBounds, @Nullable AutocompleteFilter autocompleteFilter) throws RemoteException {
        zzx.zzb(zzl, (Object) "callback == null");
        ((zzg) zzqJ()).zza(str == null ? "" : str, latLngBounds, autocompleteFilter == null ? AutocompleteFilter.create((Collection<Integer>) null) : autocompleteFilter, this.zzaQq, (zzi) zzl);
    }

    public void zza(zzl zzl, List<String> list) throws RemoteException {
        ((zzg) zzqJ()).zzb(list, this.zzaQq, (zzi) zzl);
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzcl */
    public zzg zzW(IBinder iBinder) {
        return zzg.zza.zzcn(iBinder);
    }

    /* access modifiers changed from: protected */
    public String zzgu() {
        return "com.google.android.gms.location.places.GeoDataApi";
    }

    /* access modifiers changed from: protected */
    public String zzgv() {
        return "com.google.android.gms.location.places.internal.IGooglePlacesService";
    }
}
