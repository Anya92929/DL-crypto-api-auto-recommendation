package com.google.android.gms.measurement.internal;

import android.os.IBinder;
import android.os.Parcel;
import java.util.List;

/* renamed from: com.google.android.gms.measurement.internal.am */
class C1895am implements zzm {

    /* renamed from: a */
    private IBinder f7097a;

    C1895am(IBinder iBinder) {
        this.f7097a = iBinder;
    }

    public IBinder asBinder() {
        return this.f7097a;
    }

    public List zza(AppMetadata appMetadata, boolean z) {
        int i = 1;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
            if (appMetadata != null) {
                obtain.writeInt(1);
                appMetadata.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (!z) {
                i = 0;
            }
            obtain.writeInt(i);
            this.f7097a.transact(7, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.createTypedArrayList(UserAttributeParcel.CREATOR);
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void zza(AppMetadata appMetadata) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
            if (appMetadata != null) {
                obtain.writeInt(1);
                appMetadata.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f7097a.transact(4, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void zza(EventParcel eventParcel, AppMetadata appMetadata) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
            if (eventParcel != null) {
                obtain.writeInt(1);
                eventParcel.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (appMetadata != null) {
                obtain.writeInt(1);
                appMetadata.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f7097a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void zza(EventParcel eventParcel, String str, String str2) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
            if (eventParcel != null) {
                obtain.writeInt(1);
                eventParcel.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeString(str);
            obtain.writeString(str2);
            this.f7097a.transact(5, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void zza(UserAttributeParcel userAttributeParcel, AppMetadata appMetadata) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
            if (userAttributeParcel != null) {
                obtain.writeInt(1);
                userAttributeParcel.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (appMetadata != null) {
                obtain.writeInt(1);
                appMetadata.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f7097a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public byte[] zza(EventParcel eventParcel, String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
            if (eventParcel != null) {
                obtain.writeInt(1);
                eventParcel.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeString(str);
            this.f7097a.transact(9, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.createByteArray();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void zzb(AppMetadata appMetadata) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
            if (appMetadata != null) {
                obtain.writeInt(1);
                appMetadata.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f7097a.transact(6, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
