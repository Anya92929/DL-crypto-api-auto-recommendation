package android.support.p000v4.p002os;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: android.support.v4.os.ParcelableCompatCreatorHoneycombMR2 */
class ParcelableCompatCreatorHoneycombMR2 implements Parcelable.ClassLoaderCreator {
    private final ParcelableCompatCreatorCallbacks mCallbacks;

    public ParcelableCompatCreatorHoneycombMR2(ParcelableCompatCreatorCallbacks parcelableCompatCreatorCallbacks) {
        this.mCallbacks = parcelableCompatCreatorCallbacks;
    }

    public Object createFromParcel(Parcel parcel) {
        return this.mCallbacks.createFromParcel(parcel, (ClassLoader) null);
    }

    public Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return this.mCallbacks.createFromParcel(parcel, classLoader);
    }

    public Object[] newArray(int i) {
        return this.mCallbacks.newArray(i);
    }
}
