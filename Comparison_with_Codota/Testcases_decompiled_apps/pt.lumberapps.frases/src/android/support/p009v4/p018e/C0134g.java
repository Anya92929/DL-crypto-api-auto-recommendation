package android.support.p009v4.p018e;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: android.support.v4.e.g */
class C0134g implements Parcelable.ClassLoaderCreator {

    /* renamed from: a */
    private final C0133f f185a;

    public C0134g(C0133f fVar) {
        this.f185a = fVar;
    }

    public Object createFromParcel(Parcel parcel) {
        return this.f185a.mo1031a(parcel, (ClassLoader) null);
    }

    public Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return this.f185a.mo1031a(parcel, classLoader);
    }

    public Object[] newArray(int i) {
        return this.f185a.mo1032a(i);
    }
}
