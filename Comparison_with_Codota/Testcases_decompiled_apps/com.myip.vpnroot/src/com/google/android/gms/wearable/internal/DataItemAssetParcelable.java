package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.DataItemAsset;

public class DataItemAssetParcelable implements SafeParcelable, DataItemAsset {
    public static final Parcelable.Creator<DataItemAssetParcelable> CREATOR = new C2306j();

    /* renamed from: BL */
    private final String f4662BL;

    /* renamed from: BR */
    final int f4663BR;

    /* renamed from: JH */
    private final String f4664JH;

    DataItemAssetParcelable(int versionCode, String id, String key) {
        this.f4663BR = versionCode;
        this.f4662BL = id;
        this.f4664JH = key;
    }

    public DataItemAssetParcelable(DataItemAsset value) {
        this.f4663BR = 1;
        this.f4662BL = (String) C0348n.m861i(value.getId());
        this.f4664JH = (String) C0348n.m861i(value.getDataItemKey());
    }

    public int describeContents() {
        return 0;
    }

    public String getDataItemKey() {
        return this.f4664JH;
    }

    public String getId() {
        return this.f4662BL;
    }

    public boolean isDataValid() {
        return true;
    }

    /* renamed from: pV */
    public DataItemAsset freeze() {
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DataItemAssetParcelable[");
        sb.append("@");
        sb.append(Integer.toHexString(hashCode()));
        if (this.f4662BL == null) {
            sb.append(",noid");
        } else {
            sb.append(",");
            sb.append(this.f4662BL);
        }
        sb.append(", key=");
        sb.append(this.f4664JH);
        sb.append("]");
        return sb.toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        C2306j.m7732a(this, dest, flags);
    }
}
