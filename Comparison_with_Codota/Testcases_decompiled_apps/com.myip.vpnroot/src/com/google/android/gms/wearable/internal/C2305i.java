package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.DataItemAsset;

/* renamed from: com.google.android.gms.wearable.internal.i */
public class C2305i implements DataItemAsset {

    /* renamed from: BL */
    private final String f4687BL;

    /* renamed from: JH */
    private final String f4688JH;

    public C2305i(DataItemAsset dataItemAsset) {
        this.f4687BL = dataItemAsset.getId();
        this.f4688JH = dataItemAsset.getDataItemKey();
    }

    public String getDataItemKey() {
        return this.f4688JH;
    }

    public String getId() {
        return this.f4687BL;
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
        sb.append("DataItemAssetEntity[");
        sb.append("@");
        sb.append(Integer.toHexString(hashCode()));
        if (this.f4687BL == null) {
            sb.append(",noid");
        } else {
            sb.append(",");
            sb.append(this.f4687BL);
        }
        sb.append(", key=");
        sb.append(this.f4688JH);
        sb.append("]");
        return sb.toString();
    }
}
