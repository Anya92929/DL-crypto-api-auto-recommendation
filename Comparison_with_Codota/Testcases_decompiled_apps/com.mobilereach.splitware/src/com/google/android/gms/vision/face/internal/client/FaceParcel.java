package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class FaceParcel implements SafeParcelable {
    public static final zza CREATOR = new zza();
    public final float centerX;
    public final float centerY;
    public final float height;

    /* renamed from: id */
    public final int f17id;
    public final int versionCode;
    public final float width;
    public final float zzbnP;
    public final float zzbnQ;
    public final LandmarkParcel[] zzbnR;
    public final float zzbnS;
    public final float zzbnT;
    public final float zzbnU;

    public FaceParcel(int versionCode2, int id, float centerX2, float centerY2, float width2, float height2, float eulerY, float eulerZ, LandmarkParcel[] landmarkParcels, float isLeftEyeOpenScore, float isRightEyeOpenScore, float isSmilingScore) {
        this.versionCode = versionCode2;
        this.f17id = id;
        this.centerX = centerX2;
        this.centerY = centerY2;
        this.width = width2;
        this.height = height2;
        this.zzbnP = eulerY;
        this.zzbnQ = eulerZ;
        this.zzbnR = landmarkParcels;
        this.zzbnS = isLeftEyeOpenScore;
        this.zzbnT = isRightEyeOpenScore;
        this.zzbnU = isSmilingScore;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zza.zza(this, parcel, flags);
    }
}
