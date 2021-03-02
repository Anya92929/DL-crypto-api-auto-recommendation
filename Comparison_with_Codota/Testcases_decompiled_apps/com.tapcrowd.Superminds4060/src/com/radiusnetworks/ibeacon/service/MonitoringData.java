package com.radiusnetworks.ibeacon.service;

import android.os.Parcel;
import android.os.Parcelable;
import com.radiusnetworks.ibeacon.Region;

public class MonitoringData implements Parcelable {
    public static final Parcelable.Creator<MonitoringData> CREATOR = new Parcelable.Creator<MonitoringData>() {
        public MonitoringData createFromParcel(Parcel in) {
            return new MonitoringData(in);
        }

        public MonitoringData[] newArray(int size) {
            return new MonitoringData[size];
        }
    };
    private static final String TAG = "MonitoringData";
    private boolean inside;
    private RegionData regionData;

    public MonitoringData(boolean inside2, Region region) {
        this.inside = inside2;
        this.regionData = new RegionData(region);
    }

    public boolean isInside() {
        return this.inside;
    }

    public Region getRegion() {
        return this.regionData;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeByte((byte) (this.inside ? 1 : 0));
        out.writeParcelable(this.regionData, flags);
    }

    private MonitoringData(Parcel in) {
        this.inside = in.readByte() != 1 ? false : true;
        this.regionData = (RegionData) in.readParcelable(getClass().getClassLoader());
    }
}
