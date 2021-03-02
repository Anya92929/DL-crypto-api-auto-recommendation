package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.data.C0297d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataItemAsset;

/* renamed from: com.google.android.gms.wearable.internal.k */
public class C2307k extends C0297d implements DataItemAsset {
    public C2307k(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public String getDataItemKey() {
        return getString("asset_key");
    }

    public String getId() {
        return getString("asset_id");
    }

    /* renamed from: pV */
    public DataItemAsset freeze() {
        return new C2305i(this);
    }
}
