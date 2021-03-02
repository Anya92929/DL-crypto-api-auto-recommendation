package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.C1117es;

/* renamed from: com.google.android.gms.internal.et */
public interface C1120et extends IInterface {

    /* renamed from: com.google.android.gms.internal.et$a */
    public static abstract class C1121a extends Binder implements C1120et {

        /* renamed from: com.google.android.gms.internal.et$a$a */
        private static class C1122a implements C1120et {

            /* renamed from: lb */
            private IBinder f3262lb;

            C1122a(IBinder iBinder) {
                this.f3262lb = iBinder;
            }

            /* renamed from: a */
            public void mo8449a(C1117es esVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlPublisherAdViewListener");
                    obtain.writeStrongBinder(esVar != null ? esVar.asBinder() : null);
                    this.f3262lb.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f3262lb;
            }

            /* renamed from: e */
            public boolean mo8450e(String str, String str2) throws RemoteException {
                boolean z = true;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlPublisherAdViewListener");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f3262lb.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C1121a() {
            attachInterface(this, "com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlPublisherAdViewListener");
        }

        /* renamed from: A */
        public static C1120et m4368A(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlPublisherAdViewListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C1120et)) ? new C1122a(iBinder) : (C1120et) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlPublisherAdViewListener");
                    boolean e = mo8450e(data.readString(), data.readString());
                    reply.writeNoException();
                    reply.writeInt(e ? 1 : 0);
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlPublisherAdViewListener");
                    mo8449a(C1117es.C1118a.m4360z(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlPublisherAdViewListener");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    void mo8449a(C1117es esVar) throws RemoteException;

    /* renamed from: e */
    boolean mo8450e(String str, String str2) throws RemoteException;
}
