package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.clearcut.LogEventParcelable;
import com.google.android.gms.internal.zzlx;

public interface zzly extends IInterface {

    public static abstract class zza extends Binder implements zzly {

        /* renamed from: com.google.android.gms.internal.zzly$zza$zza  reason: collision with other inner class name */
        private static class C0444zza implements zzly {
            private IBinder zzoz;

            C0444zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public void zza(zzlx zzlx, LogEventParcelable logEventParcelable) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
                    if (zzlx != null) {
                        iBinder = zzlx.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (logEventParcelable != null) {
                        obtain.writeInt(1);
                        logEventParcelable.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zzly zzaM(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzly)) ? new C0444zza(iBinder) : (zzly) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
                    zza(zzlx.zza.zzaL(data.readStrongBinder()), data.readInt() != 0 ? LogEventParcelable.CREATOR.createFromParcel(data) : null);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(zzlx zzlx, LogEventParcelable logEventParcelable) throws RemoteException;
}
