package com.google.android.gms.location.places.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.places.PlaceFilter;
import com.google.android.gms.location.places.PlaceReport;
import com.google.android.gms.location.places.PlacesOptions;
import com.google.android.gms.location.places.internal.zzf;
import com.google.android.gms.location.places.zzl;
import java.util.Locale;

public class zzk extends zzj<zzf> {
    private final PlacesParams zzaQq;
    private final Locale zzaQr = Locale.getDefault();

    public static class zza extends Api.zza<zzk, PlacesOptions> {
        private final String zzaQs;

        public zza(String str) {
            this.zzaQs = str;
        }

        /* renamed from: zzb */
        public zzk zza(Context context, Looper looper, zzf zzf, PlacesOptions placesOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzk(context, looper, zzf, connectionCallbacks, onConnectionFailedListener, this.zzaQs != null ? this.zzaQs : context.getPackageName(), placesOptions == null ? new PlacesOptions.Builder().build() : placesOptions);
        }
    }

    public zzk(Context context, Looper looper, zzf zzf, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, String str, PlacesOptions placesOptions) {
        super(context, looper, 67, zzf, connectionCallbacks, onConnectionFailedListener);
        this.zzaQq = new PlacesParams(str, this.zzaQr, zzf.getAccount() != null ? zzf.getAccount().name : null, placesOptions.zzaPU, placesOptions.zzaPV);
    }

    public void zza(zzl zzl, PlaceFilter placeFilter) throws RemoteException {
        if (placeFilter == null) {
            placeFilter = PlaceFilter.zzzd();
        }
        ((zzf) zzqJ()).zza(placeFilter, this.zzaQq, (zzi) zzl);
    }

    public void zza(zzl zzl, PlaceReport placeReport) throws RemoteException {
        zzx.zzz(placeReport);
        ((zzf) zzqJ()).zza(placeReport, this.zzaQq, (zzi) zzl);
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzcq */
    public zzf zzW(IBinder iBinder) {
        return zzf.zza.zzcm(iBinder);
    }

    /* access modifiers changed from: protected */
    public String zzgu() {
        return "com.google.android.gms.location.places.PlaceDetectionApi";
    }

    /* access modifiers changed from: protected */
    public String zzgv() {
        return "com.google.android.gms.location.places.internal.IGooglePlaceDetectionService";
    }
}
