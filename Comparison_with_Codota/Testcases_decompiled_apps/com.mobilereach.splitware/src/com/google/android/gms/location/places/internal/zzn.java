package com.google.android.gms.location.places.internal;

import android.content.Context;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlaceLikelihood;

public class zzn extends zzt implements PlaceLikelihood {
    private final Context mContext;

    public zzn(DataHolder dataHolder, int i, Context context) {
        super(dataHolder, i);
        this.mContext = context;
    }

    public float getLikelihood() {
        return zzb("place_likelihood", -1.0f);
    }

    public Place getPlace() {
        return new zzr(this.zzahi, this.zzaje, this.mContext);
    }

    /* renamed from: zzzy */
    public PlaceLikelihood freeze() {
        return PlaceLikelihoodEntity.zza((PlaceImpl) getPlace().freeze(), getLikelihood());
    }
}
