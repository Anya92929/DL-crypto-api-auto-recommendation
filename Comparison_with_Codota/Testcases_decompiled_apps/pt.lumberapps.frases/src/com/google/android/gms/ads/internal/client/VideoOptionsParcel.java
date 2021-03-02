package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.zzin;

@zzin
public class VideoOptionsParcel extends AbstractSafeParcelable {
    public static final zzaq CREATOR = new zzaq();
    public final int versionCode;
    public final boolean zzaxm;

    public VideoOptionsParcel(int i, boolean z) {
        this.versionCode = i;
        this.zzaxm = z;
    }

    public VideoOptionsParcel(VideoOptions videoOptions) {
        this(1, videoOptions.getStartMuted());
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzaq.m5597a(this, parcel, i);
    }
}
