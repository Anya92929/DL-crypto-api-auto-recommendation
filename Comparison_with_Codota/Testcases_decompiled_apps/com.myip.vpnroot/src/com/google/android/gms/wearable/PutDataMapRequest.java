package com.google.android.gms.wearable;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.internal.C1702pb;
import com.google.android.gms.internal.C1718pm;

public class PutDataMapRequest {
    private final DataMap auM = new DataMap();
    private final PutDataRequest auN;

    private PutDataMapRequest(PutDataRequest putDataRequest, DataMap dataMap) {
        this.auN = putDataRequest;
        if (dataMap != null) {
            this.auM.putAll(dataMap);
        }
    }

    public static PutDataMapRequest create(String path) {
        return new PutDataMapRequest(PutDataRequest.create(path), (DataMap) null);
    }

    public static PutDataMapRequest createFromDataMapItem(DataMapItem source) {
        return new PutDataMapRequest(PutDataRequest.m7465k(source.getUri()), source.getDataMap());
    }

    public static PutDataMapRequest createWithAutoAppendedId(String pathPrefix) {
        return new PutDataMapRequest(PutDataRequest.createWithAutoAppendedId(pathPrefix), (DataMap) null);
    }

    public PutDataRequest asPutDataRequest() {
        C1702pb.C1703a a = C1702pb.m5933a(this.auM);
        this.auN.setData(C1718pm.m6092f(a.avQ));
        int size = a.avR.size();
        int i = 0;
        while (i < size) {
            String num = Integer.toString(i);
            Asset asset = a.avR.get(i);
            if (num == null) {
                throw new IllegalStateException("asset key cannot be null: " + asset);
            } else if (asset == null) {
                throw new IllegalStateException("asset cannot be null: key=" + num);
            } else {
                if (Log.isLoggable(DataMap.TAG, 3)) {
                    Log.d(DataMap.TAG, "asPutDataRequest: adding asset: " + num + " " + asset);
                }
                this.auN.putAsset(num, asset);
                i++;
            }
        }
        return this.auN;
    }

    public DataMap getDataMap() {
        return this.auM;
    }

    public Uri getUri() {
        return this.auN.getUri();
    }
}
