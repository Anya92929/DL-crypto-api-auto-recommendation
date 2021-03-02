package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0594d;

/* renamed from: com.google.android.gms.internal.br */
public interface C0957br extends IInterface {

    /* renamed from: com.google.android.gms.internal.br$a */
    public static abstract class C0958a extends Binder implements C0957br {
        public C0958a() {
            attachInterface(this, "com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            IBinder iBinder = null;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    mo8147i(data.readInt());
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    mo8138as();
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    String bt = mo8139bt();
                    reply.writeNoException();
                    reply.writeString(bt);
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    C0594d bu = mo8140bu();
                    reply.writeNoException();
                    if (bu != null) {
                        iBinder = bu.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    String body = getBody();
                    reply.writeNoException();
                    reply.writeString(body);
                    return true;
                case 6:
                    data.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    C0594d bv = mo8141bv();
                    reply.writeNoException();
                    if (bv != null) {
                        iBinder = bv.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 7:
                    data.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    String bw = mo8142bw();
                    reply.writeNoException();
                    reply.writeString(bw);
                    return true;
                case 8:
                    data.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    double bx = mo8143bx();
                    reply.writeNoException();
                    reply.writeDouble(bx);
                    return true;
                case 9:
                    data.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    String by = mo8144by();
                    reply.writeNoException();
                    reply.writeString(by);
                    return true;
                case 10:
                    data.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    String bz = mo8145bz();
                    reply.writeNoException();
                    reply.writeString(bz);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: as */
    void mo8138as() throws RemoteException;

    /* renamed from: bt */
    String mo8139bt() throws RemoteException;

    /* renamed from: bu */
    C0594d mo8140bu() throws RemoteException;

    /* renamed from: bv */
    C0594d mo8141bv() throws RemoteException;

    /* renamed from: bw */
    String mo8142bw() throws RemoteException;

    /* renamed from: bx */
    double mo8143bx() throws RemoteException;

    /* renamed from: by */
    String mo8144by() throws RemoteException;

    /* renamed from: bz */
    String mo8145bz() throws RemoteException;

    String getBody() throws RemoteException;

    /* renamed from: i */
    void mo8147i(int i) throws RemoteException;
}
