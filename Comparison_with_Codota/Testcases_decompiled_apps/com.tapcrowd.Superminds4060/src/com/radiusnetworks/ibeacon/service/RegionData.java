package com.radiusnetworks.ibeacon.service;

import android.os.Parcel;
import android.os.Parcelable;
import com.radiusnetworks.ibeacon.Region;

public class RegionData extends Region implements Parcelable {
    public static final Parcelable.Creator<RegionData> CREATOR = new Parcelable.Creator<RegionData>() {
        public RegionData createFromParcel(Parcel in) {
            return new RegionData(in);
        }

        public RegionData[] newArray(int size) {
            return new RegionData[size];
        }
    };

    public RegionData(String uniqueId, String proximityUuid, Integer major, Integer minor) {
        super(uniqueId, proximityUuid, major, minor);
    }

    public RegionData(Region region) {
        super(region);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        int i = -1;
        out.writeInt(this.major == null ? -1 : this.major.intValue());
        if (this.minor != null) {
            i = this.minor.intValue();
        }
        out.writeInt(i);
        out.writeString(this.proximityUuid);
        out.writeString(this.uniqueId);
    }

    private RegionData(Parcel in) {
        this.major = Integer.valueOf(in.readInt());
        if (this.major.intValue() == -1) {
            this.major = null;
        }
        this.minor = Integer.valueOf(in.readInt());
        if (this.minor.intValue() == -1) {
            this.minor = null;
        }
        this.proximityUuid = in.readString();
        this.uniqueId = in.readString();
    }
}
