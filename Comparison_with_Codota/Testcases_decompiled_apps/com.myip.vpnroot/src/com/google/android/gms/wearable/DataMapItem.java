package com.google.android.gms.wearable;

import android.net.Uri;
import com.google.android.gms.internal.C1702pb;
import com.google.android.gms.internal.C1704pc;
import com.google.android.gms.internal.C1717pl;
import java.util.ArrayList;

public class DataMapItem {
    private final DataMap auM;
    private final Uri mUri;

    private DataMapItem(DataItem source) {
        this.mUri = source.getUri();
        this.auM = m7463a((DataItem) source.freeze());
    }

    /* renamed from: a */
    private DataMap m7463a(DataItem dataItem) {
        if (dataItem.getData() == null && dataItem.getAssets().size() > 0) {
            throw new IllegalArgumentException("Cannot create DataMapItem from a DataItem  that wasn't made with DataMapItem.");
        } else if (dataItem.getData() == null) {
            return new DataMap();
        } else {
            try {
                ArrayList arrayList = new ArrayList();
                int size = dataItem.getAssets().size();
                for (int i = 0; i < size; i++) {
                    DataItemAsset dataItemAsset = dataItem.getAssets().get(Integer.toString(i));
                    if (dataItemAsset == null) {
                        throw new IllegalStateException("Cannot find DataItemAsset referenced in data at " + i + " for " + dataItem);
                    }
                    arrayList.add(Asset.createFromRef(dataItemAsset.getId()));
                }
                return C1702pb.m5935a(new C1702pb.C1703a(C1704pc.m5939n(dataItem.getData()), arrayList));
            } catch (C1717pl e) {
                throw new IllegalStateException("Unable to parse. Not a DataItem.");
            }
        }
    }

    public static DataMapItem fromDataItem(DataItem dataItem) {
        if (dataItem != null) {
            return new DataMapItem(dataItem);
        }
        throw new IllegalStateException("provided dataItem is null");
    }

    public DataMap getDataMap() {
        return this.auM;
    }

    public Uri getUri() {
        return this.mUri;
    }
}
