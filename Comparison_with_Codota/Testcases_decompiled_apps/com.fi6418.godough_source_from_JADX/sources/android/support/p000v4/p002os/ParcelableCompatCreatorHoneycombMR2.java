package android.support.p000v4.p002os;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: android.support.v4.os.ParcelableCompatCreatorHoneycombMR2 */
class ParcelableCompatCreatorHoneycombMR2<T> implements Parcelable.ClassLoaderCreator<T> {

    /* renamed from: a */
    private final ParcelableCompatCreatorCallbacks<T> f1011a;

    public ParcelableCompatCreatorHoneycombMR2(ParcelableCompatCreatorCallbacks<T> parcelableCompatCreatorCallbacks) {
        this.f1011a = parcelableCompatCreatorCallbacks;
    }

    public T createFromParcel(Parcel parcel) {
        return this.f1011a.createFromParcel(parcel, (ClassLoader) null);
    }

    public T createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return this.f1011a.createFromParcel(parcel, classLoader);
    }

    public T[] newArray(int i) {
        return this.f1011a.newArray(i);
    }
}
