package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;

/* renamed from: com.google.android.gms.ads.internal.client.c */
class C1230c implements zzac {

    /* renamed from: a */
    private IBinder f3456a;

    C1230c(IBinder iBinder) {
        this.f3456a = iBinder;
    }

    public IBinder asBinder() {
        return this.f3456a;
    }

    public void onVideoEnd() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
            this.f3456a.transact(4, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void zzjb() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
            this.f3456a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void zzjc() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
            this.f3456a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void zzjd() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
            this.f3456a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
