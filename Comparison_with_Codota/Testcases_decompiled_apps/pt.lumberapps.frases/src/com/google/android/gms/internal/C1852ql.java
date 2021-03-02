package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;

/* renamed from: com.google.android.gms.internal.ql */
class C1852ql implements zzrk {

    /* renamed from: a */
    private IBinder f5520a;

    C1852ql(IBinder iBinder) {
        this.f5520a = iBinder;
    }

    public IBinder asBinder() {
        return this.f5520a;
    }

    public void zza(zzrj zzrj) {
        IBinder iBinder = null;
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.common.internal.service.ICommonService");
            if (zzrj != null) {
                iBinder = zzrj.asBinder();
            }
            obtain.writeStrongBinder(iBinder);
            this.f5520a.transact(1, obtain, (Parcel) null, 1);
        } finally {
            obtain.recycle();
        }
    }
}
