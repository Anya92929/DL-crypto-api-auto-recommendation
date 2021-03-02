package com.google.android.gms.dynamic;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.google.android.gms.dynamic.d */
public interface C0594d extends IInterface {

    /* renamed from: com.google.android.gms.dynamic.d$a */
    public static abstract class C0595a extends Binder implements C0594d {

        /* renamed from: com.google.android.gms.dynamic.d$a$a */
        private static class C0596a implements C0594d {

            /* renamed from: lb */
            private IBinder f1267lb;

            C0596a(IBinder iBinder) {
                this.f1267lb = iBinder;
            }

            public IBinder asBinder() {
                return this.f1267lb;
            }
        }

        public C0595a() {
            attachInterface(this, "com.google.android.gms.dynamic.IObjectWrapper");
        }

        /* renamed from: am */
        public static C0594d m1741am(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0594d)) ? new C0596a(iBinder) : (C0594d) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1598968902:
                    reply.writeString("com.google.android.gms.dynamic.IObjectWrapper");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }
}
