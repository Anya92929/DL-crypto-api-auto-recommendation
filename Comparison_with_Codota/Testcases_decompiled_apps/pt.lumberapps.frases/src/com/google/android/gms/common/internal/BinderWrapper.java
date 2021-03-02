package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepName;

@KeepName
public final class BinderWrapper implements Parcelable {
    public static final Parcelable.Creator CREATOR = new C1358a();

    /* renamed from: a */
    private IBinder f4449a;

    public BinderWrapper() {
        this.f4449a = null;
    }

    public BinderWrapper(IBinder iBinder) {
        this.f4449a = null;
        this.f4449a = iBinder;
    }

    private BinderWrapper(Parcel parcel) {
        this.f4449a = null;
        this.f4449a = parcel.readStrongBinder();
    }

    /* synthetic */ BinderWrapper(Parcel parcel, C1358a aVar) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.f4449a);
    }
}
