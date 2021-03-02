package com.google.android.gms.vision.internal.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.vision.Frame;

public class FrameMetadataParcel implements SafeParcelable {
    public static final zza CREATOR = new zza();
    public int height;

    /* renamed from: id */
    public int f20id;
    public int rotation;
    final int versionCode;
    public int width;
    public long zzboe;

    public FrameMetadataParcel() {
        this.versionCode = 1;
    }

    public FrameMetadataParcel(int versionCode2, int width2, int height2, int id, long timestampMillis, int rotation2) {
        this.versionCode = versionCode2;
        this.width = width2;
        this.height = height2;
        this.f20id = id;
        this.zzboe = timestampMillis;
        this.rotation = rotation2;
    }

    public static FrameMetadataParcel zzc(Frame frame) {
        FrameMetadataParcel frameMetadataParcel = new FrameMetadataParcel();
        frameMetadataParcel.width = frame.getMetadata().getWidth();
        frameMetadataParcel.height = frame.getMetadata().getHeight();
        frameMetadataParcel.rotation = frame.getMetadata().getRotation();
        frameMetadataParcel.f20id = frame.getMetadata().getId();
        frameMetadataParcel.zzboe = frame.getMetadata().getTimestampMillis();
        return frameMetadataParcel;
    }

    public int describeContents() {
        zza zza = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zza zza = CREATOR;
        zza.zza(this, parcel, flags);
    }
}
