package com.radiusnetworks.ibeacon.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.radiusnetworks.ibeacon.IBeacon;
import com.radiusnetworks.ibeacon.IBeaconManager;
import com.radiusnetworks.ibeacon.Region;
import java.util.ArrayList;
import java.util.Collection;

public class RangingData implements Parcelable {
    public static final Parcelable.Creator<RangingData> CREATOR = new Parcelable.Creator<RangingData>() {
        public RangingData createFromParcel(Parcel in) {
            return new RangingData(in);
        }

        public RangingData[] newArray(int size) {
            return new RangingData[size];
        }
    };
    private static final String TAG = "RangingData";
    private Collection<IBeaconData> iBeaconDatas;
    private RegionData regionData;

    public RangingData(Collection<IBeacon> iBeacons, Region region) {
        this.iBeaconDatas = IBeaconData.fromIBeacons(iBeacons);
        this.regionData = new RegionData(region);
    }

    public RangingData(Collection<IBeaconData> iBeacons, RegionData region) {
        this.iBeaconDatas = iBeacons;
        this.regionData = region;
    }

    public Collection<IBeaconData> getIBeacons() {
        return this.iBeaconDatas;
    }

    public RegionData getRegion() {
        return this.regionData;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        if (IBeaconManager.LOG_DEBUG) {
            Log.d(TAG, "writing RangingData");
        }
        out.writeParcelableArray((Parcelable[]) this.iBeaconDatas.toArray(new Parcelable[0]), flags);
        out.writeParcelable(this.regionData, flags);
        if (IBeaconManager.LOG_DEBUG) {
            Log.d(TAG, "done writing RangingData");
        }
    }

    private RangingData(Parcel in) {
        if (IBeaconManager.LOG_DEBUG) {
            Log.d(TAG, "parsing RangingData");
        }
        Parcelable[] parcelables = in.readParcelableArray(getClass().getClassLoader());
        this.iBeaconDatas = new ArrayList(parcelables.length);
        for (Parcelable parcelable : parcelables) {
            this.iBeaconDatas.add((IBeaconData) parcelable);
        }
        this.regionData = (RegionData) in.readParcelable(getClass().getClassLoader());
    }
}
