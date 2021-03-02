package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0594d;

/* renamed from: com.google.android.gms.internal.bs */
public interface C0959bs extends IInterface {

    /* renamed from: com.google.android.gms.internal.bs$a */
    public static abstract class C0960a extends Binder implements C0959bs {
        public C0960a() {
            attachInterface(this, "com.google.android.gms.ads.internal.formats.client.INativeContentAd");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            IBinder iBinder = null;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    mo8155i(data.readInt());
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    mo8148as();
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    String bt = mo8151bt();
                    reply.writeNoException();
                    reply.writeString(bt);
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    C0594d bu = mo8152bu();
                    reply.writeNoException();
                    if (bu != null) {
                        iBinder = bu.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    String body = getBody();
                    reply.writeNoException();
                    reply.writeString(body);
                    return true;
                case 6:
                    data.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    C0594d bA = mo8149bA();
                    reply.writeNoException();
                    if (bA != null) {
                        iBinder = bA.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 7:
                    data.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    String bw = mo8153bw();
                    reply.writeNoException();
                    reply.writeString(bw);
                    return true;
                case 8:
                    data.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    String bB = mo8150bB();
                    reply.writeNoException();
                    reply.writeString(bB);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: as */
    void mo8148as() throws RemoteException;

    /* renamed from: bA */
    C0594d mo8149bA() throws RemoteException;

    /* renamed from: bB */
    String mo8150bB() throws RemoteException;

    /* renamed from: bt */
    String mo8151bt() throws RemoteException;

    /* renamed from: bu */
    C0594d mo8152bu() throws RemoteException;

    /* renamed from: bw */
    String mo8153bw() throws RemoteException;

    String getBody() throws RemoteException;

    /* renamed from: i */
    void mo8155i(int i) throws RemoteException;
}
