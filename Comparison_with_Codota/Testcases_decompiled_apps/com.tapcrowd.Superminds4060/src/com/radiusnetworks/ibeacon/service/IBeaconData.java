package com.radiusnetworks.ibeacon.service;

import android.os.Parcel;
import android.os.Parcelable;
import com.radiusnetworks.ibeacon.IBeacon;
import java.util.ArrayList;
import java.util.Collection;

public class IBeaconData extends IBeacon implements Parcelable {
    public static final Parcelable.Creator<IBeaconData> CREATOR = new Parcelable.Creator<IBeaconData>() {
        public IBeaconData createFromParcel(Parcel in) {
            return new IBeaconData(in);
        }

        public IBeaconData[] newArray(int size) {
            return new IBeaconData[size];
        }
    };

    public IBeaconData(IBeacon iBeacon) {
        super(iBeacon);
    }

    public static Collection<IBeaconData> fromIBeacons(Collection<IBeacon> iBeacons) {
        ArrayList<IBeaconData> iBeaconDatas = new ArrayList<>();
        for (IBeacon iBeaconData : iBeacons) {
            iBeaconDatas.add(new IBeaconData(iBeaconData));
        }
        return iBeaconDatas;
    }

    public static Collection<IBeacon> fromIBeaconDatas(Collection<IBeaconData> iBeaconDatas) {
        ArrayList<IBeacon> iBeacons = new ArrayList<>();
        if (iBeaconDatas != null) {
            for (IBeaconData add : iBeaconDatas) {
                iBeacons.add(add);
            }
        }
        return iBeacons;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(this.major);
        out.writeInt(this.minor);
        out.writeString(this.proximityUuid);
        out.writeInt(getProximity());
        out.writeDouble(getAccuracy());
        out.writeInt(this.rssi);
        out.writeInt(this.txPower);
    }

    private IBeaconData(Parcel in) {
        this.major = in.readInt();
        this.minor = in.readInt();
        this.proximityUuid = in.readString();
        this.proximity = Integer.valueOf(in.readInt());
        this.accuracy = Double.valueOf(in.readDouble());
        this.rssi = in.readInt();
        this.txPower = in.readInt();
    }
}
