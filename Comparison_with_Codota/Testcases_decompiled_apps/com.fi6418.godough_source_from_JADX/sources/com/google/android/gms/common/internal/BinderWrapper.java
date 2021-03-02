package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

public final class BinderWrapper implements Parcelable {
    public static final Parcelable.Creator<BinderWrapper> CREATOR = new C0976a();

    /* renamed from: a */
    private IBinder f4652a;

    public BinderWrapper() {
        this.f4652a = null;
    }

    public BinderWrapper(IBinder iBinder) {
        this.f4652a = null;
        this.f4652a = iBinder;
    }

    private BinderWrapper(Parcel parcel) {
        this.f4652a = null;
        this.f4652a = parcel.readStrongBinder();
    }

    /* synthetic */ BinderWrapper(Parcel parcel, C0976a aVar) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.f4652a);
    }
}
