package android.support.p000v4.p002os;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: android.support.v4.os.ParcelableCompat */
public class ParcelableCompat {

    /* renamed from: android.support.v4.os.ParcelableCompat$CompatCreator */
    class CompatCreator<T> implements Parcelable.Creator<T> {

        /* renamed from: a */
        final ParcelableCompatCreatorCallbacks<T> f1010a;

        public CompatCreator(ParcelableCompatCreatorCallbacks<T> parcelableCompatCreatorCallbacks) {
            this.f1010a = parcelableCompatCreatorCallbacks;
        }

        public T createFromParcel(Parcel parcel) {
            return this.f1010a.createFromParcel(parcel, (ClassLoader) null);
        }

        public T[] newArray(int i) {
            return this.f1010a.newArray(i);
        }
    }

    public static <T> Parcelable.Creator<T> newCreator(ParcelableCompatCreatorCallbacks<T> parcelableCompatCreatorCallbacks) {
        return Build.VERSION.SDK_INT >= 13 ? ParcelableCompatCreatorHoneycombMR2Stub.m750a(parcelableCompatCreatorCallbacks) : new CompatCreator(parcelableCompatCreatorCallbacks);
    }
}
