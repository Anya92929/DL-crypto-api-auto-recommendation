package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.clearcut.LogEventParcelable;

/* renamed from: com.google.android.gms.internal.nz */
class C1785nz implements zzpf {

    /* renamed from: a */
    private IBinder f5411a;

    C1785nz(IBinder iBinder) {
        this.f5411a = iBinder;
    }

    public IBinder asBinder() {
        return this.f5411a;
    }

    public void zza(zzpe zzpe, LogEventParcelable logEventParcelable) {
        IBinder iBinder = null;
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
            if (zzpe != null) {
                iBinder = zzpe.asBinder();
            }
            obtain.writeStrongBinder(iBinder);
            if (logEventParcelable != null) {
                obtain.writeInt(1);
                logEventParcelable.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f5411a.transact(1, obtain, (Parcel) null, 1);
        } finally {
            obtain.recycle();
        }
    }
}
