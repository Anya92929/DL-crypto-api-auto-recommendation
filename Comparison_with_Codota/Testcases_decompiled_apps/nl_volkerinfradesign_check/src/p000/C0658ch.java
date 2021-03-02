package p000;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.p001v4.p003os.ParcelableCompatCreatorCallbacks;

/* renamed from: ch */
class C0658ch<T> implements Parcelable.ClassLoaderCreator<T> {

    /* renamed from: a */
    private final ParcelableCompatCreatorCallbacks<T> f2437a;

    public C0658ch(ParcelableCompatCreatorCallbacks<T> parcelableCompatCreatorCallbacks) {
        this.f2437a = parcelableCompatCreatorCallbacks;
    }

    public T createFromParcel(Parcel parcel) {
        return this.f2437a.createFromParcel(parcel, (ClassLoader) null);
    }

    public T createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return this.f2437a.createFromParcel(parcel, classLoader);
    }

    public T[] newArray(int i) {
        return this.f2437a.newArray(i);
    }
}
