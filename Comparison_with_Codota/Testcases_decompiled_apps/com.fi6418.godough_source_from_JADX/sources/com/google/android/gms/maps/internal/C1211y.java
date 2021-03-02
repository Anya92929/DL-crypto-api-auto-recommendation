package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.p017b.C0605j;

/* renamed from: com.google.android.gms.maps.internal.y */
class C1211y implements zzp {

    /* renamed from: a */
    private IBinder f5110a;

    C1211y(IBinder iBinder) {
        this.f5110a = iBinder;
    }

    public IBinder asBinder() {
        return this.f5110a;
    }

    public void zzq(C0605j jVar) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnMyLocationChangeListener");
            obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
            this.f5110a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
