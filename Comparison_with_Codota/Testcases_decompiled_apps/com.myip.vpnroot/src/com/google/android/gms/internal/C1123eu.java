package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.C1117es;

/* renamed from: com.google.android.gms.internal.eu */
public interface C1123eu extends IInterface {

    /* renamed from: com.google.android.gms.internal.eu$a */
    public static abstract class C1124a extends Binder implements C1123eu {

        /* renamed from: com.google.android.gms.internal.eu$a$a */
        private static class C1125a implements C1123eu {

            /* renamed from: lb */
            private IBinder f3263lb;

            C1125a(IBinder iBinder) {
                this.f3263lb = iBinder;
            }

            /* renamed from: a */
            public void mo8454a(C1117es esVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlPublisherInterstitialAdListener");
                    obtain.writeStrongBinder(esVar != null ? esVar.asBinder() : null);
                    this.f3263lb.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f3263lb;
            }

            /* renamed from: e */
            public boolean mo8455e(String str, String str2) throws RemoteException {
                boolean z = true;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlPublisherInterstitialAdListener");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f3263lb.transact(1, obtain, obtain2, 0);
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

        public C1124a() {
            attachInterface(this, "com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlPublisherInterstitialAdListener");
        }

        /* renamed from: B */
        public static C1123eu m4373B(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlPublisherInterstitialAdListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C1123eu)) ? new C1125a(iBinder) : (C1123eu) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlPublisherInterstitialAdListener");
                    boolean e = mo8455e(data.readString(), data.readString());
                    reply.writeNoException();
                    reply.writeInt(e ? 1 : 0);
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlPublisherInterstitialAdListener");
                    mo8454a(C1117es.C1118a.m4360z(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlPublisherInterstitialAdListener");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    void mo8454a(C1117es esVar) throws RemoteException;

    /* renamed from: e */
    boolean mo8455e(String str, String str2) throws RemoteException;
}
