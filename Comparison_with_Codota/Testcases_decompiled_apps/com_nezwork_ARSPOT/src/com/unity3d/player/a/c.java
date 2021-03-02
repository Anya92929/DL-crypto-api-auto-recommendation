package com.unity3d.player.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface c extends IInterface {

    public static abstract class a extends Binder implements c {

        /* renamed from: com.unity3d.player.a.c$a$a  reason: collision with other inner class name */
        static class C0005a implements c {
            private IBinder a;

            C0005a(IBinder iBinder) {
                this.a = iBinder;
            }

            public final void a(int i, String str, String str2) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(new String(e.a));
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
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
            attachInterface(this, new String(e.a));
        }

        public static c a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(new String(e.a));
            return (queryLocalInterface == null || !(queryLocalInterface instanceof c)) ? new C0005a(iBinder) : (c) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface(new String(e.a));
                    a(parcel.readInt(), parcel.readString(), parcel.readString());
                    return true;
                case 1598968902:
                    parcel2.writeString(new String(e.a));
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void a(int i, String str, String str2);
}
