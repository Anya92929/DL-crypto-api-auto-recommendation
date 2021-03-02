package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.wearable.internal.m */
public class C2309m implements SafeParcelable, DataItem {
    public static final Parcelable.Creator<C2309m> CREATOR = new C2310n();

    /* renamed from: BR */
    final int f4689BR;
    private byte[] acw;
    private final Map<String, DataItemAsset> avk;
    private final Uri mUri;

    C2309m(int i, Uri uri, Bundle bundle, byte[] bArr) {
        this.f4689BR = i;
        this.mUri = uri;
        HashMap hashMap = new HashMap();
        bundle.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
        for (String str : bundle.keySet()) {
            hashMap.put(str, (DataItemAssetParcelable) bundle.getParcelable(str));
        }
        this.avk = hashMap;
        this.acw = bArr;
    }

    public int describeContents() {
        return 0;
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

    /* renamed from: m */
    public C2309m setData(byte[] bArr) {
        this.acw = bArr;
        return this;
    }

    /* renamed from: pR */
    public Bundle mo12499pR() {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
        for (Map.Entry next : this.avk.entrySet()) {
            bundle.putParcelable((String) next.getKey(), new DataItemAssetParcelable((DataItemAsset) next.getValue()));
        }
        return bundle;
    }

    /* renamed from: pX */
    public C2309m freeze() {
        return this;
    }

    public String toString() {
        return toString(Log.isLoggable("DataItem", 3));
    }

    public String toString(boolean verbose) {
        StringBuilder sb = new StringBuilder("DataItemParcelable[");
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

    public void writeToParcel(Parcel dest, int flags) {
        C2310n.m7740a(this, dest, flags);
    }
}
