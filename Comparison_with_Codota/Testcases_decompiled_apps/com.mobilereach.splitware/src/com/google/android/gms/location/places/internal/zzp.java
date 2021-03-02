package com.google.android.gms.location.places.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.location.places.PlacePhotoMetadata;
import com.google.android.gms.location.places.PlacePhotoResult;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.zzf;

public class zzp implements PlacePhotoMetadata {
    /* access modifiers changed from: private */
    public int mIndex;
    private final int zzDF;
    private final int zzDG;
    /* access modifiers changed from: private */
    public final String zzaQR;
    private final CharSequence zzaQS;

    public zzp(String str, int i, int i2, CharSequence charSequence, int i3) {
        this.zzaQR = str;
        this.zzDF = i;
        this.zzDG = i2;
        this.zzaQS = charSequence;
        this.mIndex = i3;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof zzp)) {
            return false;
        }
        zzp zzp = (zzp) other;
        return zzp.zzDF == this.zzDF && zzp.zzDG == this.zzDG && zzw.equal(zzp.zzaQR, this.zzaQR) && zzw.equal(zzp.zzaQS, this.zzaQS);
    }

    public CharSequence getAttributions() {
        return this.zzaQS;
    }

    public int getMaxHeight() {
        return this.zzDG;
    }

    public int getMaxWidth() {
        return this.zzDF;
    }

    public PendingResult<PlacePhotoResult> getPhoto(GoogleApiClient client) {
        return getScaledPhoto(client, getMaxWidth(), getMaxHeight());
    }

    public PendingResult<PlacePhotoResult> getScaledPhoto(GoogleApiClient client, int width, int height) {
        final int i = width;
        final int i2 = height;
        return client.zza(new zzf.zza<zze>(Places.zzaPN, client) {
            /* access modifiers changed from: protected */
            public void zza(zze zze) throws RemoteException {
                zze.zza(new zzf((zzf.zza) this), zzp.this.zzaQR, i, i2, zzp.this.mIndex);
            }
        });
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.zzDF), Integer.valueOf(this.zzDG), this.zzaQR, this.zzaQS);
    }

    public boolean isDataValid() {
        return true;
    }

    /* renamed from: zzzz */
    public PlacePhotoMetadata freeze() {
        return this;
    }
}
