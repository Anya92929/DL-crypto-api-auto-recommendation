package android.support.p001v4.p003os;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: android.support.v4.os.ParcelableCompat */
public class ParcelableCompat {
    public static <T> Parcelable.Creator<T> newCreator(ParcelableCompatCreatorCallbacks<T> parcelableCompatCreatorCallbacks) {
        if (Build.VERSION.SDK_INT >= 13) {
            return C0659ci.m3583a(parcelableCompatCreatorCallbacks);
        }
        return new C0226a(parcelableCompatCreatorCallbacks);
    }

    /* renamed from: android.support.v4.os.ParcelableCompat$a */
    static class C0226a<T> implements Parcelable.Creator<T> {

        /* renamed from: a */
        final ParcelableCompatCreatorCallbacks<T> f772a;

        public C0226a(ParcelableCompatCreatorCallbacks<T> parcelableCompatCreatorCallbacks) {
            this.f772a = parcelableCompatCreatorCallbacks;
        }

        public T createFromParcel(Parcel parcel) {
            return this.f772a.createFromParcel(parcel, (ClassLoader) null);
        }

        public T[] newArray(int i) {
            return this.f772a.newArray(i);
        }
    }
}
