package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.C0336j;
import com.google.android.gms.fitness.FitnessActivities;

/* renamed from: com.google.android.gms.common.internal.k */
public interface C0339k extends IInterface {

    /* renamed from: com.google.android.gms.common.internal.k$a */
    public static abstract class C0340a extends Binder implements C0339k {

        /* renamed from: com.google.android.gms.common.internal.k$a$a */
        private static class C0341a implements C0339k {

            /* renamed from: lb */
            private IBinder f792lb;

            C0341a(IBinder iBinder) {
                this.f792lb = iBinder;
            }

            /* renamed from: a */
            public void mo4503a(C0336j jVar, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    obtain.writeInt(i);
                    this.f792lb.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4504a(C0336j jVar, int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.f792lb.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4505a(C0336j jVar, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f792lb.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4506a(C0336j jVar, int i, String str, IBinder iBinder, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iBinder);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f792lb.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4507a(C0336j jVar, int i, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f792lb.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4508a(C0336j jVar, int i, String str, String str2, String str3, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeStringArray(strArr);
                    this.f792lb.transact(33, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4509a(C0336j jVar, int i, String str, String str2, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStringArray(strArr);
                    this.f792lb.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4510a(C0336j jVar, int i, String str, String str2, String[] strArr, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStringArray(strArr);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f792lb.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4511a(C0336j jVar, int i, String str, String str2, String[] strArr, String str3, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStringArray(strArr);
                    obtain.writeString(str3);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f792lb.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4512a(C0336j jVar, int i, String str, String str2, String[] strArr, String str3, IBinder iBinder, String str4, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStringArray(strArr);
                    obtain.writeString(str3);
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str4);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f792lb.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4513a(C0336j jVar, int i, String str, String[] strArr, String str2, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    obtain.writeString(str2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f792lb.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f792lb;
            }

            /* renamed from: b */
            public void mo4514b(C0336j jVar, int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.f792lb.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo4515b(C0336j jVar, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f792lb.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo4516b(C0336j jVar, int i, String str, String str2, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStringArray(strArr);
                    this.f792lb.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo4517c(C0336j jVar, int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.f792lb.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo4518c(C0336j jVar, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f792lb.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public void mo4519d(C0336j jVar, int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.f792lb.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public void mo4520d(C0336j jVar, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f792lb.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: e */
            public void mo4521e(C0336j jVar, int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.f792lb.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: e */
            public void mo4522e(C0336j jVar, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f792lb.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: f */
            public void mo4523f(C0336j jVar, int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.f792lb.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: f */
            public void mo4524f(C0336j jVar, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f792lb.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: g */
            public void mo4525g(C0336j jVar, int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.f792lb.transact(32, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: g */
            public void mo4526g(C0336j jVar, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f792lb.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: h */
            public void mo4527h(C0336j jVar, int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.f792lb.transact(35, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: h */
            public void mo4528h(C0336j jVar, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f792lb.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: i */
            public void mo4529i(C0336j jVar, int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.f792lb.transact(36, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: i */
            public void mo4530i(C0336j jVar, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f792lb.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: j */
            public void mo4531j(C0336j jVar, int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.f792lb.transact(40, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: j */
            public void mo4532j(C0336j jVar, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f792lb.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: k */
            public void mo4533k(C0336j jVar, int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.f792lb.transact(42, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: k */
            public void mo4534k(C0336j jVar, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f792lb.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: l */
            public void mo4535l(C0336j jVar, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f792lb.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: m */
            public void mo4536m(C0336j jVar, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f792lb.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: n */
            public void mo4537n(C0336j jVar, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f792lb.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: o */
            public void mo4538o(C0336j jVar, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f792lb.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: p */
            public void mo4539p(C0336j jVar, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f792lb.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: q */
            public void mo4540q(C0336j jVar, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f792lb.transact(37, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: r */
            public void mo4541r(C0336j jVar, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f792lb.transact(38, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: s */
            public void mo4542s(C0336j jVar, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f792lb.transact(41, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: t */
            public void mo4543t(C0336j jVar, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f792lb.transact(43, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        /* renamed from: Q */
        public static C0339k m803Q(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0339k)) ? new C0341a(iBinder) : (C0339k) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            Bundle bundle = null;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    mo4511a(C0336j.C0337a.m760P(data.readStrongBinder()), data.readInt(), data.readString(), data.readString(), data.createStringArray(), data.readString(), data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    C0336j P = C0336j.C0337a.m760P(data.readStrongBinder());
                    int readInt = data.readInt();
                    String readString = data.readString();
                    if (data.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    mo4505a(P, readInt, readString, bundle);
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    mo4504a(C0336j.C0337a.m760P(data.readStrongBinder()), data.readInt(), data.readString());
                    reply.writeNoException();
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    mo4503a(C0336j.C0337a.m760P(data.readStrongBinder()), data.readInt());
                    reply.writeNoException();
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    C0336j P2 = C0336j.C0337a.m760P(data.readStrongBinder());
                    int readInt2 = data.readInt();
                    String readString2 = data.readString();
                    if (data.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    mo4515b(P2, readInt2, readString2, bundle);
                    reply.writeNoException();
                    return true;
                case 6:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    C0336j P3 = C0336j.C0337a.m760P(data.readStrongBinder());
                    int readInt3 = data.readInt();
                    String readString3 = data.readString();
                    if (data.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    mo4518c(P3, readInt3, readString3, bundle);
                    reply.writeNoException();
                    return true;
                case 7:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    C0336j P4 = C0336j.C0337a.m760P(data.readStrongBinder());
                    int readInt4 = data.readInt();
                    String readString4 = data.readString();
                    if (data.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    mo4520d(P4, readInt4, readString4, bundle);
                    reply.writeNoException();
                    return true;
                case 8:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    C0336j P5 = C0336j.C0337a.m760P(data.readStrongBinder());
                    int readInt5 = data.readInt();
                    String readString5 = data.readString();
                    if (data.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    mo4522e(P5, readInt5, readString5, bundle);
                    reply.writeNoException();
                    return true;
                case 9:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    mo4512a(C0336j.C0337a.m760P(data.readStrongBinder()), data.readInt(), data.readString(), data.readString(), data.createStringArray(), data.readString(), data.readStrongBinder(), data.readString(), data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 10:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    mo4509a(C0336j.C0337a.m760P(data.readStrongBinder()), data.readInt(), data.readString(), data.readString(), data.createStringArray());
                    reply.writeNoException();
                    return true;
                case 11:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    C0336j P6 = C0336j.C0337a.m760P(data.readStrongBinder());
                    int readInt6 = data.readInt();
                    String readString6 = data.readString();
                    if (data.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    mo4524f(P6, readInt6, readString6, bundle);
                    reply.writeNoException();
                    return true;
                case 12:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    C0336j P7 = C0336j.C0337a.m760P(data.readStrongBinder());
                    int readInt7 = data.readInt();
                    String readString7 = data.readString();
                    if (data.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    mo4526g(P7, readInt7, readString7, bundle);
                    reply.writeNoException();
                    return true;
                case 13:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    C0336j P8 = C0336j.C0337a.m760P(data.readStrongBinder());
                    int readInt8 = data.readInt();
                    String readString8 = data.readString();
                    if (data.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    mo4528h(P8, readInt8, readString8, bundle);
                    reply.writeNoException();
                    return true;
                case 14:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    C0336j P9 = C0336j.C0337a.m760P(data.readStrongBinder());
                    int readInt9 = data.readInt();
                    String readString9 = data.readString();
                    if (data.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    mo4530i(P9, readInt9, readString9, bundle);
                    reply.writeNoException();
                    return true;
                case 15:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    C0336j P10 = C0336j.C0337a.m760P(data.readStrongBinder());
                    int readInt10 = data.readInt();
                    String readString10 = data.readString();
                    if (data.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    mo4532j(P10, readInt10, readString10, bundle);
                    reply.writeNoException();
                    return true;
                case 16:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    C0336j P11 = C0336j.C0337a.m760P(data.readStrongBinder());
                    int readInt11 = data.readInt();
                    String readString11 = data.readString();
                    if (data.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    mo4534k(P11, readInt11, readString11, bundle);
                    reply.writeNoException();
                    return true;
                case 17:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    C0336j P12 = C0336j.C0337a.m760P(data.readStrongBinder());
                    int readInt12 = data.readInt();
                    String readString12 = data.readString();
                    if (data.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    mo4535l(P12, readInt12, readString12, bundle);
                    reply.writeNoException();
                    return true;
                case 18:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    C0336j P13 = C0336j.C0337a.m760P(data.readStrongBinder());
                    int readInt13 = data.readInt();
                    String readString13 = data.readString();
                    if (data.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    mo4536m(P13, readInt13, readString13, bundle);
                    reply.writeNoException();
                    return true;
                case 19:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    mo4506a(C0336j.C0337a.m760P(data.readStrongBinder()), data.readInt(), data.readString(), data.readStrongBinder(), data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case FitnessActivities.BOXING /*20*/:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    mo4513a(C0336j.C0337a.m760P(data.readStrongBinder()), data.readInt(), data.readString(), data.createStringArray(), data.readString(), data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 21:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    mo4514b(C0336j.C0337a.m760P(data.readStrongBinder()), data.readInt(), data.readString());
                    reply.writeNoException();
                    return true;
                case FitnessActivities.CIRCUIT_TRAINING /*22*/:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    mo4517c(C0336j.C0337a.m760P(data.readStrongBinder()), data.readInt(), data.readString());
                    reply.writeNoException();
                    return true;
                case FitnessActivities.CRICKET /*23*/:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    C0336j P14 = C0336j.C0337a.m760P(data.readStrongBinder());
                    int readInt14 = data.readInt();
                    String readString14 = data.readString();
                    if (data.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    mo4537n(P14, readInt14, readString14, bundle);
                    reply.writeNoException();
                    return true;
                case FitnessActivities.DANCING /*24*/:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    mo4519d(C0336j.C0337a.m760P(data.readStrongBinder()), data.readInt(), data.readString());
                    reply.writeNoException();
                    return true;
                case FitnessActivities.ELLIPTICAL /*25*/:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    C0336j P15 = C0336j.C0337a.m760P(data.readStrongBinder());
                    int readInt15 = data.readInt();
                    String readString15 = data.readString();
                    if (data.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    mo4538o(P15, readInt15, readString15, bundle);
                    reply.writeNoException();
                    return true;
                case FitnessActivities.FENCING /*26*/:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    mo4521e(C0336j.C0337a.m760P(data.readStrongBinder()), data.readInt(), data.readString());
                    reply.writeNoException();
                    return true;
                case FitnessActivities.FOOTBALL_AMERICAN /*27*/:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    C0336j P16 = C0336j.C0337a.m760P(data.readStrongBinder());
                    int readInt16 = data.readInt();
                    String readString16 = data.readString();
                    if (data.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    mo4539p(P16, readInt16, readString16, bundle);
                    reply.writeNoException();
                    return true;
                case FitnessActivities.FOOTBALL_AUSTRALIAN /*28*/:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    mo4516b(C0336j.C0337a.m760P(data.readStrongBinder()), data.readInt(), data.readString(), data.readString(), data.createStringArray());
                    reply.writeNoException();
                    return true;
                case FitnessActivities.FRISBEE_DISC /*30*/:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    mo4510a(C0336j.C0337a.m760P(data.readStrongBinder()), data.readInt(), data.readString(), data.readString(), data.createStringArray(), data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 31:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    mo4523f(C0336j.C0337a.m760P(data.readStrongBinder()), data.readInt(), data.readString());
                    reply.writeNoException();
                    return true;
                case 32:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    mo4525g(C0336j.C0337a.m760P(data.readStrongBinder()), data.readInt(), data.readString());
                    reply.writeNoException();
                    return true;
                case FitnessActivities.GYMNASTICS /*33*/:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    mo4508a(C0336j.C0337a.m760P(data.readStrongBinder()), data.readInt(), data.readString(), data.readString(), data.readString(), data.createStringArray());
                    reply.writeNoException();
                    return true;
                case FitnessActivities.HANDBALL /*34*/:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    mo4507a(C0336j.C0337a.m760P(data.readStrongBinder()), data.readInt(), data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case FitnessActivities.HIKING /*35*/:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    mo4527h(C0336j.C0337a.m760P(data.readStrongBinder()), data.readInt(), data.readString());
                    reply.writeNoException();
                    return true;
                case FitnessActivities.HOCKEY /*36*/:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    mo4529i(C0336j.C0337a.m760P(data.readStrongBinder()), data.readInt(), data.readString());
                    reply.writeNoException();
                    return true;
                case FitnessActivities.HORSEBACK_RIDING /*37*/:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    C0336j P17 = C0336j.C0337a.m760P(data.readStrongBinder());
                    int readInt17 = data.readInt();
                    String readString17 = data.readString();
                    if (data.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    mo4540q(P17, readInt17, readString17, bundle);
                    reply.writeNoException();
                    return true;
                case FitnessActivities.HOUSEWORK /*38*/:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    C0336j P18 = C0336j.C0337a.m760P(data.readStrongBinder());
                    int readInt18 = data.readInt();
                    String readString18 = data.readString();
                    if (data.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    mo4541r(P18, readInt18, readString18, bundle);
                    reply.writeNoException();
                    return true;
                case FitnessActivities.KAYAKING /*40*/:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    mo4531j(C0336j.C0337a.m760P(data.readStrongBinder()), data.readInt(), data.readString());
                    reply.writeNoException();
                    return true;
                case FitnessActivities.KETTLEBELL_TRAINING /*41*/:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    C0336j P19 = C0336j.C0337a.m760P(data.readStrongBinder());
                    int readInt19 = data.readInt();
                    String readString19 = data.readString();
                    if (data.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    mo4542s(P19, readInt19, readString19, bundle);
                    reply.writeNoException();
                    return true;
                case FitnessActivities.KICKBOXING /*42*/:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    mo4533k(C0336j.C0337a.m760P(data.readStrongBinder()), data.readInt(), data.readString());
                    reply.writeNoException();
                    return true;
                case FitnessActivities.KITESURFING /*43*/:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    C0336j P20 = C0336j.C0337a.m760P(data.readStrongBinder());
                    int readInt20 = data.readInt();
                    String readString20 = data.readString();
                    if (data.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    mo4543t(P20, readInt20, readString20, bundle);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.common.internal.IGmsServiceBroker");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    void mo4503a(C0336j jVar, int i) throws RemoteException;

    /* renamed from: a */
    void mo4504a(C0336j jVar, int i, String str) throws RemoteException;

    /* renamed from: a */
    void mo4505a(C0336j jVar, int i, String str, Bundle bundle) throws RemoteException;

    /* renamed from: a */
    void mo4506a(C0336j jVar, int i, String str, IBinder iBinder, Bundle bundle) throws RemoteException;

    /* renamed from: a */
    void mo4507a(C0336j jVar, int i, String str, String str2) throws RemoteException;

    /* renamed from: a */
    void mo4508a(C0336j jVar, int i, String str, String str2, String str3, String[] strArr) throws RemoteException;

    /* renamed from: a */
    void mo4509a(C0336j jVar, int i, String str, String str2, String[] strArr) throws RemoteException;

    /* renamed from: a */
    void mo4510a(C0336j jVar, int i, String str, String str2, String[] strArr, Bundle bundle) throws RemoteException;

    /* renamed from: a */
    void mo4511a(C0336j jVar, int i, String str, String str2, String[] strArr, String str3, Bundle bundle) throws RemoteException;

    /* renamed from: a */
    void mo4512a(C0336j jVar, int i, String str, String str2, String[] strArr, String str3, IBinder iBinder, String str4, Bundle bundle) throws RemoteException;

    /* renamed from: a */
    void mo4513a(C0336j jVar, int i, String str, String[] strArr, String str2, Bundle bundle) throws RemoteException;

    /* renamed from: b */
    void mo4514b(C0336j jVar, int i, String str) throws RemoteException;

    /* renamed from: b */
    void mo4515b(C0336j jVar, int i, String str, Bundle bundle) throws RemoteException;

    /* renamed from: b */
    void mo4516b(C0336j jVar, int i, String str, String str2, String[] strArr) throws RemoteException;

    /* renamed from: c */
    void mo4517c(C0336j jVar, int i, String str) throws RemoteException;

    /* renamed from: c */
    void mo4518c(C0336j jVar, int i, String str, Bundle bundle) throws RemoteException;

    /* renamed from: d */
    void mo4519d(C0336j jVar, int i, String str) throws RemoteException;

    /* renamed from: d */
    void mo4520d(C0336j jVar, int i, String str, Bundle bundle) throws RemoteException;

    /* renamed from: e */
    void mo4521e(C0336j jVar, int i, String str) throws RemoteException;

    /* renamed from: e */
    void mo4522e(C0336j jVar, int i, String str, Bundle bundle) throws RemoteException;

    /* renamed from: f */
    void mo4523f(C0336j jVar, int i, String str) throws RemoteException;

    /* renamed from: f */
    void mo4524f(C0336j jVar, int i, String str, Bundle bundle) throws RemoteException;

    /* renamed from: g */
    void mo4525g(C0336j jVar, int i, String str) throws RemoteException;

    /* renamed from: g */
    void mo4526g(C0336j jVar, int i, String str, Bundle bundle) throws RemoteException;

    /* renamed from: h */
    void mo4527h(C0336j jVar, int i, String str) throws RemoteException;

    /* renamed from: h */
    void mo4528h(C0336j jVar, int i, String str, Bundle bundle) throws RemoteException;

    /* renamed from: i */
    void mo4529i(C0336j jVar, int i, String str) throws RemoteException;

    /* renamed from: i */
    void mo4530i(C0336j jVar, int i, String str, Bundle bundle) throws RemoteException;

    /* renamed from: j */
    void mo4531j(C0336j jVar, int i, String str) throws RemoteException;

    /* renamed from: j */
    void mo4532j(C0336j jVar, int i, String str, Bundle bundle) throws RemoteException;

    /* renamed from: k */
    void mo4533k(C0336j jVar, int i, String str) throws RemoteException;

    /* renamed from: k */
    void mo4534k(C0336j jVar, int i, String str, Bundle bundle) throws RemoteException;

    /* renamed from: l */
    void mo4535l(C0336j jVar, int i, String str, Bundle bundle) throws RemoteException;

    /* renamed from: m */
    void mo4536m(C0336j jVar, int i, String str, Bundle bundle) throws RemoteException;

    /* renamed from: n */
    void mo4537n(C0336j jVar, int i, String str, Bundle bundle) throws RemoteException;

    /* renamed from: o */
    void mo4538o(C0336j jVar, int i, String str, Bundle bundle) throws RemoteException;

    /* renamed from: p */
    void mo4539p(C0336j jVar, int i, String str, Bundle bundle) throws RemoteException;

    /* renamed from: q */
    void mo4540q(C0336j jVar, int i, String str, Bundle bundle) throws RemoteException;

    /* renamed from: r */
    void mo4541r(C0336j jVar, int i, String str, Bundle bundle) throws RemoteException;

    /* renamed from: s */
    void mo4542s(C0336j jVar, int i, String str, Bundle bundle) throws RemoteException;

    /* renamed from: t */
    void mo4543t(C0336j jVar, int i, String str, Bundle bundle) throws RemoteException;
}
