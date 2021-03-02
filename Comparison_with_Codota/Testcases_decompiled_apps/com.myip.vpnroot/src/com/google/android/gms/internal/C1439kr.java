package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.SessionStopResult;

/* renamed from: com.google.android.gms.internal.kr */
public interface C1439kr extends IInterface {

    /* renamed from: com.google.android.gms.internal.kr$a */
    public static abstract class C1440a extends Binder implements C1439kr {

        /* renamed from: com.google.android.gms.internal.kr$a$a */
        private static class C1441a implements C1439kr {

            /* renamed from: lb */
            private IBinder f4194lb;

            C1441a(IBinder iBinder) {
                this.f4194lb = iBinder;
            }

            /* renamed from: a */
            public void mo9147a(SessionStopResult sessionStopResult) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.ISessionStopCallback");
                    if (sessionStopResult != null) {
                        obtain.writeInt(1);
                        sessionStopResult.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4194lb.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f4194lb;
            }
        }

        public C1440a() {
            attachInterface(this, "com.google.android.gms.fitness.internal.ISessionStopCallback");
        }

        /* renamed from: av */
        public static C1439kr m5328av(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.ISessionStopCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C1439kr)) ? new C1441a(iBinder) : (C1439kr) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.fitness.internal.ISessionStopCallback");
                    mo9147a(data.readInt() != 0 ? SessionStopResult.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.fitness.internal.ISessionStopCallback");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    void mo9147a(SessionStopResult sessionStopResult) throws RemoteException;
}
