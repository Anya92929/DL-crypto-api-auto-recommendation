package com.google.android.gms.maps.model.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.maps.model.Tile;

/* renamed from: com.google.android.gms.maps.model.internal.j */
class C1228j implements zzi {

    /* renamed from: a */
    private IBinder f5222a;

    C1228j(IBinder iBinder) {
        this.f5222a = iBinder;
    }

    public IBinder asBinder() {
        return this.f5222a;
    }

    public Tile getTile(int i, int i2, int i3) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
            obtain.writeInt(i);
            obtain.writeInt(i2);
            obtain.writeInt(i3);
            this.f5222a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0 ? Tile.CREATOR.createFromParcel(obtain2) : null;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
