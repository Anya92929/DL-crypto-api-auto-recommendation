package com.google.android.gms.location.places;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.places.internal.zzn;

public class PlaceLikelihoodBuffer extends AbstractDataBuffer<PlaceLikelihood> implements Result {
    private final Context mContext;
    private final Status zzUX;
    private final String zzaPy;
    private final int zzvr;

    public static class zza {
        static int zzhP(int i) {
            switch (i) {
                case 100:
                case 101:
                case LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY:
                case 103:
                case 104:
                case 105:
                case SktSsiProtocol.kSsiDataOptionSuffix2:
                case 107:
                case 108:
                    return i;
                default:
                    throw new IllegalArgumentException("invalid source: " + i);
            }
        }
    }

    public PlaceLikelihoodBuffer(DataHolder dataHolder, int source, Context context) {
        super(dataHolder);
        this.mContext = context;
        this.zzUX = PlacesStatusCodes.zzhU(dataHolder.getStatusCode());
        this.zzvr = zza.zzhP(source);
        if (dataHolder == null || dataHolder.zzpZ() == null) {
            this.zzaPy = null;
        } else {
            this.zzaPy = dataHolder.zzpZ().getString("com.google.android.gms.location.places.PlaceLikelihoodBuffer.ATTRIBUTIONS_EXTRA_KEY");
        }
    }

    public static int zzH(Bundle bundle) {
        return bundle.getInt("com.google.android.gms.location.places.PlaceLikelihoodBuffer.SOURCE_EXTRA_KEY");
    }

    public PlaceLikelihood get(int position) {
        return new zzn(this.zzahi, position, this.mContext);
    }

    @Nullable
    public CharSequence getAttributions() {
        return this.zzaPy;
    }

    public Status getStatus() {
        return this.zzUX;
    }

    public String toString() {
        return zzw.zzy(this).zzg("status", getStatus()).zzg("attributions", this.zzaPy).toString();
    }
}
