package android.support.p000v4.p002os;

import android.os.Parcel;

/* renamed from: android.support.v4.os.ParcelableCompatCreatorCallbacks */
public interface ParcelableCompatCreatorCallbacks {
    Object createFromParcel(Parcel parcel, ClassLoader classLoader);

    Object[] newArray(int i);
}
