package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.wearable.internal.l */
public class C2308l implements DataItem {
    private byte[] acw;
    private Map<String, DataItemAsset> avk;
    private Uri mUri;

    public C2308l(DataItem dataItem) {
        this.mUri = dataItem.getUri();
        this.acw = dataItem.getData();
        HashMap hashMap = new HashMap();
        for (Map.Entry next : dataItem.getAssets().entrySet()) {
            if (next.getKey() != null) {
                hashMap.put(next.getKey(), ((DataItemAsset) next.getValue()).freeze());
            }
        }
        this.avk = Collections.unmodifiableMap(hashMap);
    }

    public Map<String, DataItemAsset> getAssets() {
        return this.avk;
    }

    public byte[] getData() {
        return this.acw;
    }

    public Uri getUri() {
        return this.mUri;
    }

    public boolean isDataValid() {
        return true;
    }

    /* renamed from: pW */
    public DataItem freeze() {
        return this;
    }

    public DataItem setData(byte[] data) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return toString(Log.isLoggable("DataItem", 3));
    }

    public String toString(boolean verbose) {
        StringBuilder sb = new StringBuilder("DataItemEntity[");
        sb.append("@");
        sb.append(Integer.toHexString(hashCode()));
        sb.append(",dataSz=" + (this.acw == null ? "null" : Integer.valueOf(this.acw.length)));
        sb.append(", numAssets=" + this.avk.size());
        sb.append(", uri=" + this.mUri);
        if (!verbose) {
            sb.append("]");
            return sb.toString();
        }
        sb.append("]\n  assets: ");
        for (String next : this.avk.keySet()) {
            sb.append("\n    " + next + ": " + this.avk.get(next));
        }
        sb.append("\n  ]");
        return sb.toString();
    }
}
