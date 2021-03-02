package com.radiusnetworks.ibeacon.service;

import android.os.Parcel;
import android.os.Parcelable;

public class StartRMData implements Parcelable {
    public static final Parcelable.Creator<StartRMData> CREATOR = new Parcelable.Creator<StartRMData>() {
        public StartRMData createFromParcel(Parcel in) {
            return new StartRMData(in);
        }

        public StartRMData[] newArray(int size) {
            return new StartRMData[size];
        }
    };
    private long betweenScanPeriod;
    private String callbackPackageName;
    private RegionData regionData;
    private long scanPeriod;

    public StartRMData(RegionData regionData2, String callbackPackageName2) {
        this.regionData = regionData2;
        this.callbackPackageName = callbackPackageName2;
    }

    public StartRMData(long scanPeriod2, long betweenScanPeriod2) {
        this.scanPeriod = scanPeriod2;
        this.betweenScanPeriod = betweenScanPeriod2;
    }

    public StartRMData(RegionData regionData2, String callbackPackageName2, long scanPeriod2, long betweenScanPeriod2) {
        this.scanPeriod = scanPeriod2;
        this.betweenScanPeriod = betweenScanPeriod2;
        this.regionData = regionData2;
        this.callbackPackageName = callbackPackageName2;
    }

    public long getScanPeriod() {
        return this.scanPeriod;
    }

    public long getBetweenScanPeriod() {
        return this.betweenScanPeriod;
    }

    public RegionData getRegionData() {
        return this.regionData;
    }

    public String getCallbackPackageName() {
        return this.callbackPackageName;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeParcelable(this.regionData, flags);
        out.writeString(this.callbackPackageName);
        out.writeLong(this.scanPeriod);
        out.writeLong(this.betweenScanPeriod);
    }

    private StartRMData(Parcel in) {
        this.regionData = (RegionData) in.readParcelable(getClass().getClassLoader());
        this.callbackPackageName = in.readString();
        this.scanPeriod = in.readLong();
        this.betweenScanPeriod = in.readLong();
    }
}
