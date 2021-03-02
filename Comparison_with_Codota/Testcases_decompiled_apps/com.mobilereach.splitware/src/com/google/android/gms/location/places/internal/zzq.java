package com.google.android.gms.location.places.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.PlacePhotoMetadata;
import com.google.android.gms.location.places.PlacePhotoResult;

public class zzq extends zzt implements PlacePhotoMetadata {
    private final String zzaQR = getString("photo_fife_url");

    public zzq(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public CharSequence getAttributions() {
        return zzG("photo_attributions", (String) null);
    }

    public int getMaxHeight() {
        return zzz("photo_max_height", 0);
    }

    public int getMaxWidth() {
        return zzz("photo_max_width", 0);
    }

    public PendingResult<PlacePhotoResult> getPhoto(GoogleApiClient client) {
        return getScaledPhoto(client, getMaxWidth(), getMaxHeight());
    }

    public PendingResult<PlacePhotoResult> getScaledPhoto(GoogleApiClient client, int width, int height) {
        return freeze().getScaledPhoto(client, width, height);
    }

    /* renamed from: zzzz */
    public PlacePhotoMetadata freeze() {
        return new zzp(this.zzaQR, getMaxWidth(), getMaxHeight(), getAttributions(), this.zzaje);
    }
}
