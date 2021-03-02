package com.google.android.gms.gcm;

import android.os.Parcel;
import android.os.Parcelable;

public abstract class Task implements Parcelable {
    private final String adq = null;
    private final boolean adr = false;
    private final boolean ads = false;
    private final String mTag = null;

    Task() {
    }

    public int describeContents() {
        return 0;
    }

    public String getServiceName() {
        return this.adq;
    }

    public String getTag() {
        return this.mTag;
    }

    public boolean isPersisted() {
        return this.ads;
    }

    public boolean isUpdateCurrent() {
        return this.adr;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeString(this.adq);
        parcel.writeString(this.mTag);
        parcel.writeInt(this.adr ? 1 : 0);
        if (!this.ads) {
            i2 = 0;
        }
        parcel.writeInt(i2);
    }
}
