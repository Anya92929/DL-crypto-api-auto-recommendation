package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.zzgk;

/* renamed from: com.google.android.gms.internal.ip */
class C1640ip implements zzgj {

    /* renamed from: a */
    private IBinder f5150a;

    C1640ip(IBinder iBinder) {
        this.f5150a = iBinder;
    }

    public IBinder asBinder() {
        return this.f5150a;
    }

    public zzgk zzbm(String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
            obtain.writeString(str);
            this.f5150a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return zzgk.zza.zzak(obtain2.readStrongBinder());
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public boolean zzbn(String str) {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
            obtain.writeString(str);
            this.f5150a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                z = true;
            }
            return z;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
