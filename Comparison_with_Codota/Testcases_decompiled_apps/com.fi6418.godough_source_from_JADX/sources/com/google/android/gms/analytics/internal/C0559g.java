package com.google.android.gms.analytics.internal;

import android.os.IBinder;
import android.os.Parcel;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.analytics.internal.g */
class C0559g implements C0557e {

    /* renamed from: a */
    private IBinder f3860a;

    C0559g(IBinder iBinder) {
        this.f3860a = iBinder;
    }

    /* renamed from: a */
    public void mo6796a() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.analytics.internal.IAnalyticsService");
            this.f3860a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    /* renamed from: a */
    public void mo6797a(Map map, long j, String str, List<Command> list) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.analytics.internal.IAnalyticsService");
            obtain.writeMap(map);
            obtain.writeLong(j);
            obtain.writeString(str);
            obtain.writeTypedList(list);
            this.f3860a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f3860a;
    }

    /* renamed from: b */
    public String mo6798b() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.analytics.internal.IAnalyticsService");
            this.f3860a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readString();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
