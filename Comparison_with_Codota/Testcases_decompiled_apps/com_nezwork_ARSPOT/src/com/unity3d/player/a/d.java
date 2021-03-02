package com.unity3d.player.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.unity3d.player.a.c;

public interface d extends IInterface {

    public static abstract class a extends Binder implements d {

        /* renamed from: com.unity3d.player.a.d$a$a  reason: collision with other inner class name */
        static class C0006a implements d {
            private IBinder a;

            C0006a(IBinder iBinder) {
                this.a = iBinder;
            }

            public final void a(long j, String str, c cVar) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(new String(e.b));
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    if (cVar != null) {
                        iBinder = cVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.a.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public final IBinder asBinder() {
                return this.a;
            }
        }

        public a() {
            attachInterface(this, new String(e.b));
        }

        public static d a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(new String(e.b));
            return (queryLocalInterface == null || !(queryLocalInterface instanceof d)) ? new C0006a(iBinder) : (d) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface(new String(e.b));
                    a(parcel.readLong(), parcel.readString(), c.a.a(parcel.readStrongBinder()));
                    return true;
                case 1598968902:
                    parcel2.writeString(new String(e.b));
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void a(long j, String str, c cVar);
}
