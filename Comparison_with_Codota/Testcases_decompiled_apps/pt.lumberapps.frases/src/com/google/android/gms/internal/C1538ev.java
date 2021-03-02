package com.google.android.gms.internal;

import android.net.Uri;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.zzd;

/* renamed from: com.google.android.gms.internal.ev */
class C1538ev implements zzdr {

    /* renamed from: a */
    private IBinder f4977a;

    C1538ev(IBinder iBinder) {
        this.f4977a = iBinder;
    }

    public IBinder asBinder() {
        return this.f4977a;
    }

    public double getScale() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
            this.f4977a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readDouble();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public Uri getUri() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
            this.f4977a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(obtain2) : null;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public zzd zzkt() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
            this.f4977a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return zzd.zza.zzfc(obtain2.readStrongBinder());
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
