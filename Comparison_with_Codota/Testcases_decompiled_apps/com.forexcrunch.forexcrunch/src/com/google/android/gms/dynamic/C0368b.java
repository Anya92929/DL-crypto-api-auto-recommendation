package com.google.android.gms.dynamic;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.google.android.gms.dynamic.b */
public interface C0368b extends IInterface {

    /* renamed from: com.google.android.gms.dynamic.b$a */
    public static abstract class C0369a extends Binder implements C0368b {

        /* renamed from: com.google.android.gms.dynamic.b$a$a */
        private static class C0370a implements C0368b {

            /* renamed from: a */
            private IBinder f870a;

            C0370a(IBinder iBinder) {
                this.f870a = iBinder;
            }

            public IBinder asBinder() {
                return this.f870a;
            }
        }

        public C0369a() {
            attachInterface(this, "com.google.android.gms.dynamic.IObjectWrapper");
        }

        /* renamed from: l */
        public static C0368b m700l(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0368b)) ? new C0370a(iBinder) : (C0368b) queryLocalInterface;
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
