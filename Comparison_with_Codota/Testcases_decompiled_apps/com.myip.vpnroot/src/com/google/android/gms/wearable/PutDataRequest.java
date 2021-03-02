package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.DataItemAssetParcelable;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class PutDataRequest implements SafeParcelable {
    public static final Parcelable.Creator<PutDataRequest> CREATOR = new C2229e();
    public static final String WEAR_URI_SCHEME = "wear";
    private static final Random auO = new SecureRandom();

    /* renamed from: BR */
    final int f4653BR;
    private byte[] acw;
    private final Bundle auP;
    private final Uri mUri;

    private PutDataRequest(int versionCode, Uri uri) {
        this(versionCode, uri, new Bundle(), (byte[]) null);
    }

    PutDataRequest(int versionCode, Uri uri, Bundle assets, byte[] data) {
        this.f4653BR = versionCode;
        this.mUri = uri;
        this.auP = assets;
        this.auP.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
        this.acw = data;
    }

    public static PutDataRequest create(String path) {
        return m7465k(m7464dd(path));
    }

    public static PutDataRequest createFromDataItem(DataItem source) {
        PutDataRequest k = m7465k(source.getUri());
        for (Map.Entry next : source.getAssets().entrySet()) {
            if (((DataItemAsset) next.getValue()).getId() == null) {
                throw new IllegalStateException("Cannot create an asset for a put request without a digest: " + ((String) next.getKey()));
            }
            k.putAsset((String) next.getKey(), Asset.createFromRef(((DataItemAsset) next.getValue()).getId()));
        }
        k.setData(source.getData());
        return k;
    }

    public static PutDataRequest createWithAutoAppendedId(String pathPrefix) {
        StringBuilder sb = new StringBuilder(pathPrefix);
        if (!pathPrefix.endsWith("/")) {
            sb.append("/");
        }
        sb.append("PN").append(auO.nextLong());
        return new PutDataRequest(1, m7464dd(sb.toString()));
    }

    /* renamed from: dd */
    private static Uri m7464dd(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("An empty path was supplied.");
        } else if (!str.startsWith("/")) {
            throw new IllegalArgumentException("A path must start with a single / .");
        } else if (!str.startsWith("//")) {
            return new Uri.Builder().scheme(WEAR_URI_SCHEME).path(str).build();
        } else {
            throw new IllegalArgumentException("A path must start with a single / .");
        }
    }

    /* renamed from: k */
    public static PutDataRequest m7465k(Uri uri) {
        return new PutDataRequest(1, uri);
    }

    public int describeContents() {
        return 0;
    }

    public Asset getAsset(String key) {
        return (Asset) this.auP.getParcelable(key);
    }

    public Map<String, Asset> getAssets() {
        HashMap hashMap = new HashMap();
        for (String str : this.auP.keySet()) {
            hashMap.put(str, (Asset) this.auP.getParcelable(str));
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public byte[] getData() {
        return this.acw;
    }

    public Uri getUri() {
        return this.mUri;
    }

    public boolean hasAsset(String key) {
        return this.auP.containsKey(key);
    }

    /* renamed from: pR */
    public Bundle mo12278pR() {
        return this.auP;
    }

    public PutDataRequest putAsset(String key, Asset value) {
        C0348n.m861i(key);
        C0348n.m861i(value);
        this.auP.putParcelable(key, value);
        return this;
    }

    public PutDataRequest removeAsset(String key) {
        this.auP.remove(key);
        return this;
    }

    public PutDataRequest setData(byte[] data) {
        this.acw = data;
        return this;
    }

    public String toString() {
        return toString(Log.isLoggable(DataMap.TAG, 3));
    }

    public String toString(boolean verbose) {
        StringBuilder sb = new StringBuilder("PutDataRequest[");
        sb.append("dataSz=" + (this.acw == null ? "null" : Integer.valueOf(this.acw.length)));
        sb.append(", numAssets=" + this.auP.size());
        sb.append(", uri=" + this.mUri);
        if (!verbose) {
            sb.append("]");
            return sb.toString();
        }
        sb.append("]\n  assets: ");
        for (String str : this.auP.keySet()) {
            sb.append("\n    " + str + ": " + this.auP.getParcelable(str));
        }
        sb.append("\n  ]");
        return sb.toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        C2229e.m7487a(this, dest, flags);
    }
}
