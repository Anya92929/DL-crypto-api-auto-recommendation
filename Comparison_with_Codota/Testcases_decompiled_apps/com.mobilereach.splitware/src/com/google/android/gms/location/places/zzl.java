package com.google.android.gms.location.places;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzng;
import com.google.android.gms.location.places.internal.zzi;

public class zzl extends zzi.zza {
    private static final String TAG = zzl.class.getSimpleName();
    private final Context mContext;
    private final zzd zzaPP;
    private final zza zzaPQ;
    private final zze zzaPR;
    private final zzf zzaPS;
    private final zzc zzaPT;

    public static abstract class zza<A extends Api.zzb> extends zzb<AutocompletePredictionBuffer, A> {
        public zza(Api.zzc<A> zzc, GoogleApiClient googleApiClient) {
            super(zzc, googleApiClient);
        }

        /* access modifiers changed from: protected */
        /* renamed from: zzaV */
        public AutocompletePredictionBuffer zzc(Status status) {
            return new AutocompletePredictionBuffer(DataHolder.zzbI(status.getStatusCode()));
        }
    }

    public static abstract class zzb<R extends Result, A extends Api.zzb> extends zza.C0426zza<R, A> {
        public zzb(Api.zzc<A> zzc, GoogleApiClient googleApiClient) {
            super(zzc, googleApiClient);
        }
    }

    public static abstract class zzc<A extends Api.zzb> extends zzb<PlaceBuffer, A> {
        public zzc(Api.zzc<A> zzc, GoogleApiClient googleApiClient) {
            super(zzc, googleApiClient);
        }

        /* access modifiers changed from: protected */
        /* renamed from: zzaW */
        public PlaceBuffer zzc(Status status) {
            return new PlaceBuffer(DataHolder.zzbI(status.getStatusCode()), (Context) null);
        }
    }

    public static abstract class zzd<A extends Api.zzb> extends zzb<PlaceLikelihoodBuffer, A> {
        public zzd(Api.zzc<A> zzc, GoogleApiClient googleApiClient) {
            super(zzc, googleApiClient);
        }

        /* access modifiers changed from: protected */
        /* renamed from: zzaX */
        public PlaceLikelihoodBuffer zzc(Status status) {
            return new PlaceLikelihoodBuffer(DataHolder.zzbI(status.getStatusCode()), 100, (Context) null);
        }
    }

    public static abstract class zze<A extends Api.zzb> extends zzb<com.google.android.gms.location.places.personalized.zzd, A> {
        /* access modifiers changed from: protected */
        /* renamed from: zzaY */
        public com.google.android.gms.location.places.personalized.zzd zzc(Status status) {
            return com.google.android.gms.location.places.personalized.zzd.zzaZ(status);
        }
    }

    public static abstract class zzf<A extends Api.zzb> extends zzb<Status, A> {
        public zzf(Api.zzc<A> zzc, GoogleApiClient googleApiClient) {
            super(zzc, googleApiClient);
        }

        /* access modifiers changed from: protected */
        /* renamed from: zzb */
        public Status zzc(Status status) {
            return status;
        }
    }

    public zzl(zza zza2) {
        this.zzaPP = null;
        this.zzaPQ = zza2;
        this.zzaPR = null;
        this.zzaPS = null;
        this.zzaPT = null;
        this.mContext = null;
    }

    public zzl(zzc zzc2, Context context) {
        this.zzaPP = null;
        this.zzaPQ = null;
        this.zzaPR = null;
        this.zzaPS = null;
        this.zzaPT = zzc2;
        this.mContext = context.getApplicationContext();
    }

    public zzl(zzd zzd2, Context context) {
        this.zzaPP = zzd2;
        this.zzaPQ = null;
        this.zzaPR = null;
        this.zzaPS = null;
        this.zzaPT = null;
        this.mContext = context.getApplicationContext();
    }

    public zzl(zzf zzf2) {
        this.zzaPP = null;
        this.zzaPQ = null;
        this.zzaPR = null;
        this.zzaPS = zzf2;
        this.zzaPT = null;
        this.mContext = null;
    }

    public void zzaU(Status status) throws RemoteException {
        this.zzaPS.zza(status);
    }

    public void zzac(DataHolder dataHolder) throws RemoteException {
        zzx.zza(this.zzaPP != null, (Object) "placeEstimator cannot be null");
        if (dataHolder == null) {
            if (Log.isLoggable(TAG, 6)) {
                Log.e(TAG, "onPlaceEstimated received null DataHolder: " + zzng.zzso());
            }
            this.zzaPP.zzw(Status.zzagE);
            return;
        }
        Bundle zzpZ = dataHolder.zzpZ();
        this.zzaPP.zza(new PlaceLikelihoodBuffer(dataHolder, zzpZ == null ? 100 : PlaceLikelihoodBuffer.zzH(zzpZ), this.mContext));
    }

    public void zzad(DataHolder dataHolder) throws RemoteException {
        if (dataHolder == null) {
            if (Log.isLoggable(TAG, 6)) {
                Log.e(TAG, "onAutocompletePrediction received null DataHolder: " + zzng.zzso());
            }
            this.zzaPQ.zzw(Status.zzagE);
            return;
        }
        this.zzaPQ.zza(new AutocompletePredictionBuffer(dataHolder));
    }

    public void zzae(DataHolder dataHolder) throws RemoteException {
        if (dataHolder == null) {
            if (Log.isLoggable(TAG, 6)) {
                Log.e(TAG, "onPlaceUserDataFetched received null DataHolder: " + zzng.zzso());
            }
            this.zzaPR.zzw(Status.zzagE);
            return;
        }
        this.zzaPR.zza(new com.google.android.gms.location.places.personalized.zzd(dataHolder));
    }

    public void zzaf(DataHolder dataHolder) throws RemoteException {
        this.zzaPT.zza(new PlaceBuffer(dataHolder, this.mContext));
    }
}
