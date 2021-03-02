package android.support.p000v4.p002os;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: android.support.v4.os.ParcelableCompat */
public class ParcelableCompat {

    /* renamed from: android.support.v4.os.ParcelableCompat$CompatCreator */
    class CompatCreator implements Parcelable.Creator {
        final ParcelableCompatCreatorCallbacks mCallbacks;

        public CompatCreator(ParcelableCompatCreatorCallbacks parcelableCompatCreatorCallbacks) {
            this.mCallbacks = parcelableCompatCreatorCallbacks;
        }

        public Object createFromParcel(Parcel parcel) {
            return this.mCallbacks.createFromParcel(parcel, (ClassLoader) null);
        }

        public Object[] newArray(int i) {
            return this.mCallbacks.newArray(i);
        }
    }

    public static Parcelable.Creator newCreator(ParcelableCompatCreatorCallbacks parcelableCompatCreatorCallbacks) {
        return Build.VERSION.SDK_INT >= 13 ? ParcelableCompatCreatorHoneycombMR2Stub.instantiate(parcelableCompatCreatorCallbacks) : new CompatCreator(parcelableCompatCreatorCallbacks);
    }
}
