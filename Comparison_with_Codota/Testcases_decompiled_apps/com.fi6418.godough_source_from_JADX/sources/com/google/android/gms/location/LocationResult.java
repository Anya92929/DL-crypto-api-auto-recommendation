package com.google.android.gms.location;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class LocationResult implements SafeParcelable {
    public static final Parcelable.Creator<LocationResult> CREATOR = new C1153s();

    /* renamed from: a */
    static final List<Location> f4904a = Collections.emptyList();

    /* renamed from: b */
    private final int f4905b;

    /* renamed from: c */
    private final List<Location> f4906c;

    LocationResult(int i, List<Location> list) {
        this.f4905b = i;
        this.f4906c = list;
    }

    /* renamed from: a */
    public List<Location> mo7749a() {
        return this.f4906c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo7750b() {
        return this.f4905b;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof LocationResult)) {
            return false;
        }
        LocationResult locationResult = (LocationResult) obj;
        if (locationResult.f4906c.size() != this.f4906c.size()) {
            return false;
        }
        Iterator<Location> it = this.f4906c.iterator();
        for (Location time : locationResult.f4906c) {
            if (it.next().getTime() != time.getTime()) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = 17;
        Iterator<Location> it = this.f4906c.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            long time = it.next().getTime();
            i = ((int) (time ^ (time >>> 32))) + (i2 * 31);
        }
    }

    public String toString() {
        return "LocationResult[locations: " + this.f4906c + "]";
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1153s.m4983a(this, parcel, i);
    }
}
