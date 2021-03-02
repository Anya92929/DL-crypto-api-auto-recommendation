package com.google.android.gms.wearable.internal;

import android.net.Uri;
import com.google.android.gms.common.data.C0297d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.wearable.internal.o */
public final class C2311o extends C0297d implements DataItem {
    private final int aaz;

    public C2311o(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.aaz = i2;
    }

    public Map<String, DataItemAsset> getAssets() {
        HashMap hashMap = new HashMap(this.aaz);
        for (int i = 0; i < this.aaz; i++) {
            C2307k kVar = new C2307k(this.f693IC, this.f694JQ + i);
            if (kVar.getDataItemKey() != null) {
                hashMap.put(kVar.getDataItemKey(), kVar);
            }
        }
        return hashMap;
    }

    public byte[] getData() {
        return getByteArray("data");
    }

    public Uri getUri() {
        return Uri.parse(getString("path"));
    }

    /* renamed from: pW */
    public DataItem freeze() {
        return new C2308l(this);
    }

    public DataItem setData(byte[] data) {
        throw new UnsupportedOperationException();
    }
}
