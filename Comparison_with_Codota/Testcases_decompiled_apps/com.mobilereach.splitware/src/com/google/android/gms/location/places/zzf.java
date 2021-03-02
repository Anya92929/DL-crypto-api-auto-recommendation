package com.google.android.gms.location.places;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.internal.zzh;
import com.google.android.gms.location.places.zzl;

public class zzf extends zzh.zza {
    private final zzb zzaPw;
    private final zza zzaPx;

    public static abstract class zza<A extends Api.zzb> extends zzl.zzb<PlacePhotoResult, A> {
        public zza(Api.zzc<A> zzc, GoogleApiClient googleApiClient) {
            super(zzc, googleApiClient);
        }

        /* access modifiers changed from: protected */
        /* renamed from: zzaS */
        public PlacePhotoResult zzc(Status status) {
            return new PlacePhotoResult(status, (BitmapTeleporter) null);
        }
    }

    public static abstract class zzb<A extends Api.zzb> extends zzl.zzb<PlacePhotoMetadataResult, A> {
        public zzb(Api.zzc<A> zzc, GoogleApiClient googleApiClient) {
            super(zzc, googleApiClient);
        }

        /* access modifiers changed from: protected */
        /* renamed from: zzaT */
        public PlacePhotoMetadataResult zzc(Status status) {
            return new PlacePhotoMetadataResult(status, (DataHolder) null);
        }
    }

    public zzf(zza zza2) {
        this.zzaPw = null;
        this.zzaPx = zza2;
    }

    public zzf(zzb zzb2) {
        this.zzaPw = zzb2;
        this.zzaPx = null;
    }

    public void zza(PlacePhotoMetadataResult placePhotoMetadataResult) throws RemoteException {
        this.zzaPw.zza(placePhotoMetadataResult);
    }

    public void zza(PlacePhotoResult placePhotoResult) throws RemoteException {
        this.zzaPx.zza(placePhotoResult);
    }
}
