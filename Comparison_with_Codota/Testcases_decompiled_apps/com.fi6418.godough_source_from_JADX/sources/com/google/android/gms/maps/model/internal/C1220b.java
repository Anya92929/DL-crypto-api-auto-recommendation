package com.google.android.gms.maps.model.internal;

import android.graphics.Bitmap;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.p017b.C0605j;
import com.google.android.gms.p017b.C0606k;

/* renamed from: com.google.android.gms.maps.model.internal.b */
class C1220b implements zza {

    /* renamed from: a */
    private IBinder f5214a;

    C1220b(IBinder iBinder) {
        this.f5214a = iBinder;
    }

    public IBinder asBinder() {
        return this.f5214a;
    }

    public C0605j zzb(Bitmap bitmap) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            if (bitmap != null) {
                obtain.writeInt(1);
                bitmap.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f5214a.transact(6, obtain, obtain2, 0);
            obtain2.readException();
            return C0606k.m3535a(obtain2.readStrongBinder());
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public C0605j zzdF(String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            obtain.writeString(str);
            this.f5214a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            return C0606k.m3535a(obtain2.readStrongBinder());
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public C0605j zzdG(String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            obtain.writeString(str);
            this.f5214a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            return C0606k.m3535a(obtain2.readStrongBinder());
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public C0605j zzdH(String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            obtain.writeString(str);
            this.f5214a.transact(7, obtain, obtain2, 0);
            obtain2.readException();
            return C0606k.m3535a(obtain2.readStrongBinder());
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public C0605j zzh(float f) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            obtain.writeFloat(f);
            this.f5214a.transact(5, obtain, obtain2, 0);
            obtain2.readException();
            return C0606k.m3535a(obtain2.readStrongBinder());
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public C0605j zzhM(int i) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            obtain.writeInt(i);
            this.f5214a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return C0606k.m3535a(obtain2.readStrongBinder());
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public C0605j zzxg() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            this.f5214a.transact(4, obtain, obtain2, 0);
            obtain2.readException();
            return C0606k.m3535a(obtain2.readStrongBinder());
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
