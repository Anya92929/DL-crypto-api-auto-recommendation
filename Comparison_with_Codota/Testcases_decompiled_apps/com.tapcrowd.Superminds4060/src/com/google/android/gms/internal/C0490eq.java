package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.data.C0140d;
import com.google.android.gms.games.GamesClient;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage;

/* renamed from: com.google.android.gms.internal.eq */
public interface C0490eq extends IInterface {

    /* renamed from: com.google.android.gms.internal.eq$a */
    public static abstract class C0491a extends Binder implements C0490eq {

        /* renamed from: com.google.android.gms.internal.eq$a$a */
        private static class C0492a implements C0490eq {

            /* renamed from: dG */
            private IBinder f1266dG;

            C0492a(IBinder iBinder) {
                this.f1266dG = iBinder;
            }

            /* renamed from: M */
            public void mo4503M(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    this.f1266dG.transact(5013, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: N */
            public void mo4504N(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    this.f1266dG.transact(5015, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: O */
            public void mo4505O(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    this.f1266dG.transact(5036, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: P */
            public void mo4506P(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    this.f1266dG.transact(5040, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4507a(int i, int i2, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    this.f1266dG.transact(5033, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4508a(int i, String str, boolean z) throws RemoteException {
                int i2 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (z) {
                        i2 = 1;
                    }
                    obtain.writeInt(i2);
                    this.f1266dG.transact(5034, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4509a(C0140d dVar, C0140d dVar2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dVar != null) {
                        obtain.writeInt(1);
                        dVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (dVar2 != null) {
                        obtain.writeInt(1);
                        dVar2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1266dG.transact(5005, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4510a(C0140d dVar, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dVar != null) {
                        obtain.writeInt(1);
                        dVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStringArray(strArr);
                    this.f1266dG.transact(5026, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f1266dG;
            }

            /* renamed from: b */
            public void mo4511b(C0140d dVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dVar != null) {
                        obtain.writeInt(1);
                        dVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1266dG.transact(5002, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo4512b(C0140d dVar, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dVar != null) {
                        obtain.writeInt(1);
                        dVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStringArray(strArr);
                    this.f1266dG.transact(5027, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo4513c(int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.f1266dG.transact(5001, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo4514c(C0140d dVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dVar != null) {
                        obtain.writeInt(1);
                        dVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1266dG.transact(5004, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo4515c(C0140d dVar, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dVar != null) {
                        obtain.writeInt(1);
                        dVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStringArray(strArr);
                    this.f1266dG.transact(5028, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public void mo4516d(C0140d dVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dVar != null) {
                        obtain.writeInt(1);
                        dVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1266dG.transact(5006, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public void mo4517d(C0140d dVar, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dVar != null) {
                        obtain.writeInt(1);
                        dVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStringArray(strArr);
                    this.f1266dG.transact(5029, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: e */
            public void mo4518e(C0140d dVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dVar != null) {
                        obtain.writeInt(1);
                        dVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1266dG.transact(5007, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: e */
            public void mo4519e(C0140d dVar, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dVar != null) {
                        obtain.writeInt(1);
                        dVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStringArray(strArr);
                    this.f1266dG.transact(5030, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: f */
            public void mo4520f(C0140d dVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dVar != null) {
                        obtain.writeInt(1);
                        dVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1266dG.transact(5008, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: f */
            public void mo4521f(C0140d dVar, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dVar != null) {
                        obtain.writeInt(1);
                        dVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStringArray(strArr);
                    this.f1266dG.transact(5031, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: g */
            public void mo4522g(C0140d dVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dVar != null) {
                        obtain.writeInt(1);
                        dVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1266dG.transact(5009, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: h */
            public void mo4523h(C0140d dVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dVar != null) {
                        obtain.writeInt(1);
                        dVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1266dG.transact(5010, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: i */
            public void mo4524i(C0140d dVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dVar != null) {
                        obtain.writeInt(1);
                        dVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1266dG.transact(5011, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: j */
            public void mo4525j(C0140d dVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dVar != null) {
                        obtain.writeInt(1);
                        dVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1266dG.transact(5017, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: k */
            public void mo4526k(C0140d dVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dVar != null) {
                        obtain.writeInt(1);
                        dVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1266dG.transact(5037, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: l */
            public void mo4527l(C0140d dVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dVar != null) {
                        obtain.writeInt(1);
                        dVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1266dG.transact(5012, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: m */
            public void mo4528m(C0140d dVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dVar != null) {
                        obtain.writeInt(1);
                        dVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1266dG.transact(5014, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: n */
            public void mo4529n(C0140d dVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dVar != null) {
                        obtain.writeInt(1);
                        dVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1266dG.transact(5018, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: o */
            public void mo4530o(C0140d dVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dVar != null) {
                        obtain.writeInt(1);
                        dVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1266dG.transact(5019, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onAchievementUpdated(int statusCode, String achievementId) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(statusCode);
                    obtain.writeString(achievementId);
                    this.f1266dG.transact(5003, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onLeftRoom(int statusCode, String roomId) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(statusCode);
                    obtain.writeString(roomId);
                    this.f1266dG.transact(5020, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onP2PConnected(String participantId) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeString(participantId);
                    this.f1266dG.transact(GamesClient.STATUS_MULTIPLAYER_ERROR_NOT_TRUSTED_TESTER, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onP2PDisconnected(String participantId) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeString(participantId);
                    this.f1266dG.transact(6002, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onRealTimeMessageReceived(RealTimeMessage message) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (message != null) {
                        obtain.writeInt(1);
                        message.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1266dG.transact(5032, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onSignOutComplete() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    this.f1266dG.transact(5016, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: p */
            public void mo4537p(C0140d dVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dVar != null) {
                        obtain.writeInt(1);
                        dVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1266dG.transact(5021, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: q */
            public void mo4538q(C0140d dVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dVar != null) {
                        obtain.writeInt(1);
                        dVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1266dG.transact(5022, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: r */
            public void mo4539r(C0140d dVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dVar != null) {
                        obtain.writeInt(1);
                        dVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1266dG.transact(5023, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: s */
            public void mo4540s(C0140d dVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dVar != null) {
                        obtain.writeInt(1);
                        dVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1266dG.transact(5024, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: t */
            public void mo4541t(C0140d dVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dVar != null) {
                        obtain.writeInt(1);
                        dVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1266dG.transact(5025, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: u */
            public void mo4542u(C0140d dVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dVar != null) {
                        obtain.writeInt(1);
                        dVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1266dG.transact(5038, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: v */
            public void mo4543v(C0140d dVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dVar != null) {
                        obtain.writeInt(1);
                        dVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1266dG.transact(5035, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: w */
            public void mo4544w(C0140d dVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dVar != null) {
                        obtain.writeInt(1);
                        dVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1266dG.transact(5039, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C0491a() {
            attachInterface(this, "com.google.android.gms.games.internal.IGamesCallbacks");
        }

        /* renamed from: B */
        public static C0490eq m1280B(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0490eq)) ? new C0492a(iBinder) : (C0490eq) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: com.google.android.gms.common.data.d} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: com.google.android.gms.common.data.d} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v15, resolved type: com.google.android.gms.common.data.d} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v25, resolved type: com.google.android.gms.games.multiplayer.realtime.RealTimeMessage} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v29, resolved type: com.google.android.gms.common.data.d} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v32, resolved type: com.google.android.gms.common.data.d} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v35, resolved type: com.google.android.gms.common.data.d} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v38, resolved type: com.google.android.gms.common.data.d} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v41, resolved type: com.google.android.gms.common.data.d} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v44, resolved type: com.google.android.gms.common.data.d} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v47, resolved type: com.google.android.gms.common.data.d} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v50, resolved type: com.google.android.gms.common.data.d} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v53, resolved type: com.google.android.gms.common.data.d} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v56, resolved type: com.google.android.gms.common.data.d} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v59, resolved type: com.google.android.gms.common.data.d} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v64, resolved type: com.google.android.gms.common.data.d} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v67, resolved type: com.google.android.gms.common.data.d} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v70, resolved type: com.google.android.gms.common.data.d} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v73, resolved type: com.google.android.gms.common.data.d} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v79, resolved type: com.google.android.gms.common.data.d} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v84, resolved type: com.google.android.gms.common.data.d} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v87, resolved type: com.google.android.gms.common.data.d} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v90, resolved type: com.google.android.gms.common.data.d} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v93, resolved type: com.google.android.gms.common.data.d} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v96, resolved type: com.google.android.gms.common.data.d} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v99, resolved type: com.google.android.gms.common.data.d} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v102, resolved type: com.google.android.gms.common.data.d} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v105, resolved type: com.google.android.gms.common.data.d} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v108, resolved type: com.google.android.gms.common.data.d} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v113, resolved type: com.google.android.gms.common.data.d} */
        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v119 */
        /* JADX WARNING: type inference failed for: r0v120 */
        /* JADX WARNING: type inference failed for: r0v121 */
        /* JADX WARNING: type inference failed for: r0v122 */
        /* JADX WARNING: type inference failed for: r0v123 */
        /* JADX WARNING: type inference failed for: r0v124 */
        /* JADX WARNING: type inference failed for: r0v125 */
        /* JADX WARNING: type inference failed for: r0v126 */
        /* JADX WARNING: type inference failed for: r0v127 */
        /* JADX WARNING: type inference failed for: r0v128 */
        /* JADX WARNING: type inference failed for: r0v129 */
        /* JADX WARNING: type inference failed for: r0v130 */
        /* JADX WARNING: type inference failed for: r0v131 */
        /* JADX WARNING: type inference failed for: r0v132 */
        /* JADX WARNING: type inference failed for: r0v133 */
        /* JADX WARNING: type inference failed for: r0v134 */
        /* JADX WARNING: type inference failed for: r0v135 */
        /* JADX WARNING: type inference failed for: r0v136 */
        /* JADX WARNING: type inference failed for: r0v137 */
        /* JADX WARNING: type inference failed for: r0v138 */
        /* JADX WARNING: type inference failed for: r0v139 */
        /* JADX WARNING: type inference failed for: r0v140 */
        /* JADX WARNING: type inference failed for: r0v141 */
        /* JADX WARNING: type inference failed for: r0v142 */
        /* JADX WARNING: type inference failed for: r0v143 */
        /* JADX WARNING: type inference failed for: r0v144 */
        /* JADX WARNING: type inference failed for: r0v145 */
        /* JADX WARNING: type inference failed for: r0v146 */
        /* JADX WARNING: type inference failed for: r0v147 */
        /* JADX WARNING: type inference failed for: r0v148 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r5, android.os.Parcel r6, android.os.Parcel r7, int r8) throws android.os.RemoteException {
            /*
                r4 = this;
                r0 = 0
                r2 = 1
                switch(r5) {
                    case 5001: goto L_0x0010;
                    case 5002: goto L_0x0024;
                    case 5003: goto L_0x003c;
                    case 5004: goto L_0x0050;
                    case 5005: goto L_0x0068;
                    case 5006: goto L_0x008f;
                    case 5007: goto L_0x00a8;
                    case 5008: goto L_0x00c1;
                    case 5009: goto L_0x00da;
                    case 5010: goto L_0x00f3;
                    case 5011: goto L_0x010c;
                    case 5012: goto L_0x0125;
                    case 5013: goto L_0x013e;
                    case 5014: goto L_0x014f;
                    case 5015: goto L_0x0168;
                    case 5016: goto L_0x0179;
                    case 5017: goto L_0x0186;
                    case 5018: goto L_0x01b8;
                    case 5019: goto L_0x01d1;
                    case 5020: goto L_0x01ea;
                    case 5021: goto L_0x01ff;
                    case 5022: goto L_0x0218;
                    case 5023: goto L_0x0231;
                    case 5024: goto L_0x024a;
                    case 5025: goto L_0x0263;
                    case 5026: goto L_0x027c;
                    case 5027: goto L_0x0299;
                    case 5028: goto L_0x02b6;
                    case 5029: goto L_0x02d3;
                    case 5030: goto L_0x02f0;
                    case 5031: goto L_0x030d;
                    case 5032: goto L_0x032a;
                    case 5033: goto L_0x0345;
                    case 5034: goto L_0x035e;
                    case 5035: goto L_0x0395;
                    case 5036: goto L_0x03ae;
                    case 5037: goto L_0x019f;
                    case 5038: goto L_0x037c;
                    case 5039: goto L_0x03bf;
                    case 5040: goto L_0x03d8;
                    case 6001: goto L_0x03e9;
                    case 6002: goto L_0x03fa;
                    case 1598968902: goto L_0x000a;
                    default: goto L_0x0005;
                }
            L_0x0005:
                boolean r2 = super.onTransact(r5, r6, r7, r8)
            L_0x0009:
                return r2
            L_0x000a:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r7.writeString(r0)
                goto L_0x0009
            L_0x0010:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r6.enforceInterface(r0)
                int r0 = r6.readInt()
                java.lang.String r1 = r6.readString()
                r4.mo4513c((int) r0, (java.lang.String) r1)
                r7.writeNoException()
                goto L_0x0009
            L_0x0024:
                java.lang.String r1 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r6.enforceInterface(r1)
                int r1 = r6.readInt()
                if (r1 == 0) goto L_0x0035
                com.google.android.gms.common.data.e r0 = com.google.android.gms.common.data.C0140d.CREATOR
                com.google.android.gms.common.data.d r0 = r0.createFromParcel(r6)
            L_0x0035:
                r4.mo4511b(r0)
                r7.writeNoException()
                goto L_0x0009
            L_0x003c:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r6.enforceInterface(r0)
                int r0 = r6.readInt()
                java.lang.String r1 = r6.readString()
                r4.onAchievementUpdated(r0, r1)
                r7.writeNoException()
                goto L_0x0009
            L_0x0050:
                java.lang.String r1 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r6.enforceInterface(r1)
                int r1 = r6.readInt()
                if (r1 == 0) goto L_0x0061
                com.google.android.gms.common.data.e r0 = com.google.android.gms.common.data.C0140d.CREATOR
                com.google.android.gms.common.data.d r0 = r0.createFromParcel(r6)
            L_0x0061:
                r4.mo4514c(r0)
                r7.writeNoException()
                goto L_0x0009
            L_0x0068:
                java.lang.String r1 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r6.enforceInterface(r1)
                int r1 = r6.readInt()
                if (r1 == 0) goto L_0x008d
                com.google.android.gms.common.data.e r1 = com.google.android.gms.common.data.C0140d.CREATOR
                com.google.android.gms.common.data.d r1 = r1.createFromParcel(r6)
            L_0x0079:
                int r3 = r6.readInt()
                if (r3 == 0) goto L_0x0085
                com.google.android.gms.common.data.e r0 = com.google.android.gms.common.data.C0140d.CREATOR
                com.google.android.gms.common.data.d r0 = r0.createFromParcel(r6)
            L_0x0085:
                r4.mo4509a((com.google.android.gms.common.data.C0140d) r1, (com.google.android.gms.common.data.C0140d) r0)
                r7.writeNoException()
                goto L_0x0009
            L_0x008d:
                r1 = r0
                goto L_0x0079
            L_0x008f:
                java.lang.String r1 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r6.enforceInterface(r1)
                int r1 = r6.readInt()
                if (r1 == 0) goto L_0x00a0
                com.google.android.gms.common.data.e r0 = com.google.android.gms.common.data.C0140d.CREATOR
                com.google.android.gms.common.data.d r0 = r0.createFromParcel(r6)
            L_0x00a0:
                r4.mo4516d(r0)
                r7.writeNoException()
                goto L_0x0009
            L_0x00a8:
                java.lang.String r1 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r6.enforceInterface(r1)
                int r1 = r6.readInt()
                if (r1 == 0) goto L_0x00b9
                com.google.android.gms.common.data.e r0 = com.google.android.gms.common.data.C0140d.CREATOR
                com.google.android.gms.common.data.d r0 = r0.createFromParcel(r6)
            L_0x00b9:
                r4.mo4518e(r0)
                r7.writeNoException()
                goto L_0x0009
            L_0x00c1:
                java.lang.String r1 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r6.enforceInterface(r1)
                int r1 = r6.readInt()
                if (r1 == 0) goto L_0x00d2
                com.google.android.gms.common.data.e r0 = com.google.android.gms.common.data.C0140d.CREATOR
                com.google.android.gms.common.data.d r0 = r0.createFromParcel(r6)
            L_0x00d2:
                r4.mo4520f(r0)
                r7.writeNoException()
                goto L_0x0009
            L_0x00da:
                java.lang.String r1 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r6.enforceInterface(r1)
                int r1 = r6.readInt()
                if (r1 == 0) goto L_0x00eb
                com.google.android.gms.common.data.e r0 = com.google.android.gms.common.data.C0140d.CREATOR
                com.google.android.gms.common.data.d r0 = r0.createFromParcel(r6)
            L_0x00eb:
                r4.mo4522g(r0)
                r7.writeNoException()
                goto L_0x0009
            L_0x00f3:
                java.lang.String r1 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r6.enforceInterface(r1)
                int r1 = r6.readInt()
                if (r1 == 0) goto L_0x0104
                com.google.android.gms.common.data.e r0 = com.google.android.gms.common.data.C0140d.CREATOR
                com.google.android.gms.common.data.d r0 = r0.createFromParcel(r6)
            L_0x0104:
                r4.mo4523h(r0)
                r7.writeNoException()
                goto L_0x0009
            L_0x010c:
                java.lang.String r1 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r6.enforceInterface(r1)
                int r1 = r6.readInt()
                if (r1 == 0) goto L_0x011d
                com.google.android.gms.common.data.e r0 = com.google.android.gms.common.data.C0140d.CREATOR
                com.google.android.gms.common.data.d r0 = r0.createFromParcel(r6)
            L_0x011d:
                r4.mo4524i(r0)
                r7.writeNoException()
                goto L_0x0009
            L_0x0125:
                java.lang.String r1 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r6.enforceInterface(r1)
                int r1 = r6.readInt()
                if (r1 == 0) goto L_0x0136
                com.google.android.gms.common.data.e r0 = com.google.android.gms.common.data.C0140d.CREATOR
                com.google.android.gms.common.data.d r0 = r0.createFromParcel(r6)
            L_0x0136:
                r4.mo4527l(r0)
                r7.writeNoException()
                goto L_0x0009
            L_0x013e:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r6.enforceInterface(r0)
                int r0 = r6.readInt()
                r4.mo4503M(r0)
                r7.writeNoException()
                goto L_0x0009
            L_0x014f:
                java.lang.String r1 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r6.enforceInterface(r1)
                int r1 = r6.readInt()
                if (r1 == 0) goto L_0x0160
                com.google.android.gms.common.data.e r0 = com.google.android.gms.common.data.C0140d.CREATOR
                com.google.android.gms.common.data.d r0 = r0.createFromParcel(r6)
            L_0x0160:
                r4.mo4528m(r0)
                r7.writeNoException()
                goto L_0x0009
            L_0x0168:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r6.enforceInterface(r0)
                int r0 = r6.readInt()
                r4.mo4504N(r0)
                r7.writeNoException()
                goto L_0x0009
            L_0x0179:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r6.enforceInterface(r0)
                r4.onSignOutComplete()
                r7.writeNoException()
                goto L_0x0009
            L_0x0186:
                java.lang.String r1 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r6.enforceInterface(r1)
                int r1 = r6.readInt()
                if (r1 == 0) goto L_0x0197
                com.google.android.gms.common.data.e r0 = com.google.android.gms.common.data.C0140d.CREATOR
                com.google.android.gms.common.data.d r0 = r0.createFromParcel(r6)
            L_0x0197:
                r4.mo4525j(r0)
                r7.writeNoException()
                goto L_0x0009
            L_0x019f:
                java.lang.String r1 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r6.enforceInterface(r1)
                int r1 = r6.readInt()
                if (r1 == 0) goto L_0x01b0
                com.google.android.gms.common.data.e r0 = com.google.android.gms.common.data.C0140d.CREATOR
                com.google.android.gms.common.data.d r0 = r0.createFromParcel(r6)
            L_0x01b0:
                r4.mo4526k(r0)
                r7.writeNoException()
                goto L_0x0009
            L_0x01b8:
                java.lang.String r1 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r6.enforceInterface(r1)
                int r1 = r6.readInt()
                if (r1 == 0) goto L_0x01c9
                com.google.android.gms.common.data.e r0 = com.google.android.gms.common.data.C0140d.CREATOR
                com.google.android.gms.common.data.d r0 = r0.createFromParcel(r6)
            L_0x01c9:
                r4.mo4529n(r0)
                r7.writeNoException()
                goto L_0x0009
            L_0x01d1:
                java.lang.String r1 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r6.enforceInterface(r1)
                int r1 = r6.readInt()
                if (r1 == 0) goto L_0x01e2
                com.google.android.gms.common.data.e r0 = com.google.android.gms.common.data.C0140d.CREATOR
                com.google.android.gms.common.data.d r0 = r0.createFromParcel(r6)
            L_0x01e2:
                r4.mo4530o(r0)
                r7.writeNoException()
                goto L_0x0009
            L_0x01ea:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r6.enforceInterface(r0)
                int r0 = r6.readInt()
                java.lang.String r1 = r6.readString()
                r4.onLeftRoom(r0, r1)
                r7.writeNoException()
                goto L_0x0009
            L_0x01ff:
                java.lang.String r1 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r6.enforceInterface(r1)
                int r1 = r6.readInt()
                if (r1 == 0) goto L_0x0210
                com.google.android.gms.common.data.e r0 = com.google.android.gms.common.data.C0140d.CREATOR
                com.google.android.gms.common.data.d r0 = r0.createFromParcel(r6)
            L_0x0210:
                r4.mo4537p(r0)
                r7.writeNoException()
                goto L_0x0009
            L_0x0218:
                java.lang.String r1 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r6.enforceInterface(r1)
                int r1 = r6.readInt()
                if (r1 == 0) goto L_0x0229
                com.google.android.gms.common.data.e r0 = com.google.android.gms.common.data.C0140d.CREATOR
                com.google.android.gms.common.data.d r0 = r0.createFromParcel(r6)
            L_0x0229:
                r4.mo4538q(r0)
                r7.writeNoException()
                goto L_0x0009
            L_0x0231:
                java.lang.String r1 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r6.enforceInterface(r1)
                int r1 = r6.readInt()
                if (r1 == 0) goto L_0x0242
                com.google.android.gms.common.data.e r0 = com.google.android.gms.common.data.C0140d.CREATOR
                com.google.android.gms.common.data.d r0 = r0.createFromParcel(r6)
            L_0x0242:
                r4.mo4539r(r0)
                r7.writeNoException()
                goto L_0x0009
            L_0x024a:
                java.lang.String r1 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r6.enforceInterface(r1)
                int r1 = r6.readInt()
                if (r1 == 0) goto L_0x025b
                com.google.android.gms.common.data.e r0 = com.google.android.gms.common.data.C0140d.CREATOR
                com.google.android.gms.common.data.d r0 = r0.createFromParcel(r6)
            L_0x025b:
                r4.mo4540s(r0)
                r7.writeNoException()
                goto L_0x0009
            L_0x0263:
                java.lang.String r1 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r6.enforceInterface(r1)
                int r1 = r6.readInt()
                if (r1 == 0) goto L_0x0274
                com.google.android.gms.common.data.e r0 = com.google.android.gms.common.data.C0140d.CREATOR
                com.google.android.gms.common.data.d r0 = r0.createFromParcel(r6)
            L_0x0274:
                r4.mo4541t(r0)
                r7.writeNoException()
                goto L_0x0009
            L_0x027c:
                java.lang.String r1 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r6.enforceInterface(r1)
                int r1 = r6.readInt()
                if (r1 == 0) goto L_0x028d
                com.google.android.gms.common.data.e r0 = com.google.android.gms.common.data.C0140d.CREATOR
                com.google.android.gms.common.data.d r0 = r0.createFromParcel(r6)
            L_0x028d:
                java.lang.String[] r1 = r6.createStringArray()
                r4.mo4510a((com.google.android.gms.common.data.C0140d) r0, (java.lang.String[]) r1)
                r7.writeNoException()
                goto L_0x0009
            L_0x0299:
                java.lang.String r1 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r6.enforceInterface(r1)
                int r1 = r6.readInt()
                if (r1 == 0) goto L_0x02aa
                com.google.android.gms.common.data.e r0 = com.google.android.gms.common.data.C0140d.CREATOR
                com.google.android.gms.common.data.d r0 = r0.createFromParcel(r6)
            L_0x02aa:
                java.lang.String[] r1 = r6.createStringArray()
                r4.mo4512b(r0, r1)
                r7.writeNoException()
                goto L_0x0009
            L_0x02b6:
                java.lang.String r1 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r6.enforceInterface(r1)
                int r1 = r6.readInt()
                if (r1 == 0) goto L_0x02c7
                com.google.android.gms.common.data.e r0 = com.google.android.gms.common.data.C0140d.CREATOR
                com.google.android.gms.common.data.d r0 = r0.createFromParcel(r6)
            L_0x02c7:
                java.lang.String[] r1 = r6.createStringArray()
                r4.mo4515c((com.google.android.gms.common.data.C0140d) r0, (java.lang.String[]) r1)
                r7.writeNoException()
                goto L_0x0009
            L_0x02d3:
                java.lang.String r1 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r6.enforceInterface(r1)
                int r1 = r6.readInt()
                if (r1 == 0) goto L_0x02e4
                com.google.android.gms.common.data.e r0 = com.google.android.gms.common.data.C0140d.CREATOR
                com.google.android.gms.common.data.d r0 = r0.createFromParcel(r6)
            L_0x02e4:
                java.lang.String[] r1 = r6.createStringArray()
                r4.mo4517d(r0, r1)
                r7.writeNoException()
                goto L_0x0009
            L_0x02f0:
                java.lang.String r1 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r6.enforceInterface(r1)
                int r1 = r6.readInt()
                if (r1 == 0) goto L_0x0301
                com.google.android.gms.common.data.e r0 = com.google.android.gms.common.data.C0140d.CREATOR
                com.google.android.gms.common.data.d r0 = r0.createFromParcel(r6)
            L_0x0301:
                java.lang.String[] r1 = r6.createStringArray()
                r4.mo4519e(r0, r1)
                r7.writeNoException()
                goto L_0x0009
            L_0x030d:
                java.lang.String r1 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r6.enforceInterface(r1)
                int r1 = r6.readInt()
                if (r1 == 0) goto L_0x031e
                com.google.android.gms.common.data.e r0 = com.google.android.gms.common.data.C0140d.CREATOR
                com.google.android.gms.common.data.d r0 = r0.createFromParcel(r6)
            L_0x031e:
                java.lang.String[] r1 = r6.createStringArray()
                r4.mo4521f(r0, r1)
                r7.writeNoException()
                goto L_0x0009
            L_0x032a:
                java.lang.String r1 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r6.enforceInterface(r1)
                int r1 = r6.readInt()
                if (r1 == 0) goto L_0x033d
                android.os.Parcelable$Creator<com.google.android.gms.games.multiplayer.realtime.RealTimeMessage> r0 = com.google.android.gms.games.multiplayer.realtime.RealTimeMessage.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r6)
                com.google.android.gms.games.multiplayer.realtime.RealTimeMessage r0 = (com.google.android.gms.games.multiplayer.realtime.RealTimeMessage) r0
            L_0x033d:
                r4.onRealTimeMessageReceived(r0)
                r7.writeNoException()
                goto L_0x0009
            L_0x0345:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r6.enforceInterface(r0)
                int r0 = r6.readInt()
                int r1 = r6.readInt()
                java.lang.String r3 = r6.readString()
                r4.mo4507a((int) r0, (int) r1, (java.lang.String) r3)
                r7.writeNoException()
                goto L_0x0009
            L_0x035e:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r6.enforceInterface(r0)
                int r1 = r6.readInt()
                java.lang.String r3 = r6.readString()
                int r0 = r6.readInt()
                if (r0 == 0) goto L_0x037a
                r0 = r2
            L_0x0372:
                r4.mo4508a((int) r1, (java.lang.String) r3, (boolean) r0)
                r7.writeNoException()
                goto L_0x0009
            L_0x037a:
                r0 = 0
                goto L_0x0372
            L_0x037c:
                java.lang.String r1 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r6.enforceInterface(r1)
                int r1 = r6.readInt()
                if (r1 == 0) goto L_0x038d
                com.google.android.gms.common.data.e r0 = com.google.android.gms.common.data.C0140d.CREATOR
                com.google.android.gms.common.data.d r0 = r0.createFromParcel(r6)
            L_0x038d:
                r4.mo4542u(r0)
                r7.writeNoException()
                goto L_0x0009
            L_0x0395:
                java.lang.String r1 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r6.enforceInterface(r1)
                int r1 = r6.readInt()
                if (r1 == 0) goto L_0x03a6
                com.google.android.gms.common.data.e r0 = com.google.android.gms.common.data.C0140d.CREATOR
                com.google.android.gms.common.data.d r0 = r0.createFromParcel(r6)
            L_0x03a6:
                r4.mo4543v(r0)
                r7.writeNoException()
                goto L_0x0009
            L_0x03ae:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r6.enforceInterface(r0)
                int r0 = r6.readInt()
                r4.mo4505O(r0)
                r7.writeNoException()
                goto L_0x0009
            L_0x03bf:
                java.lang.String r1 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r6.enforceInterface(r1)
                int r1 = r6.readInt()
                if (r1 == 0) goto L_0x03d0
                com.google.android.gms.common.data.e r0 = com.google.android.gms.common.data.C0140d.CREATOR
                com.google.android.gms.common.data.d r0 = r0.createFromParcel(r6)
            L_0x03d0:
                r4.mo4544w(r0)
                r7.writeNoException()
                goto L_0x0009
            L_0x03d8:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r6.enforceInterface(r0)
                int r0 = r6.readInt()
                r4.mo4506P(r0)
                r7.writeNoException()
                goto L_0x0009
            L_0x03e9:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r6.enforceInterface(r0)
                java.lang.String r0 = r6.readString()
                r4.onP2PConnected(r0)
                r7.writeNoException()
                goto L_0x0009
            L_0x03fa:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r6.enforceInterface(r0)
                java.lang.String r0 = r6.readString()
                r4.onP2PDisconnected(r0)
                r7.writeNoException()
                goto L_0x0009
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.C0490eq.C0491a.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    /* renamed from: M */
    void mo4503M(int i) throws RemoteException;

    /* renamed from: N */
    void mo4504N(int i) throws RemoteException;

    /* renamed from: O */
    void mo4505O(int i) throws RemoteException;

    /* renamed from: P */
    void mo4506P(int i) throws RemoteException;

    /* renamed from: a */
    void mo4507a(int i, int i2, String str) throws RemoteException;

    /* renamed from: a */
    void mo4508a(int i, String str, boolean z) throws RemoteException;

    /* renamed from: a */
    void mo4509a(C0140d dVar, C0140d dVar2) throws RemoteException;

    /* renamed from: a */
    void mo4510a(C0140d dVar, String[] strArr) throws RemoteException;

    /* renamed from: b */
    void mo4511b(C0140d dVar) throws RemoteException;

    /* renamed from: b */
    void mo4512b(C0140d dVar, String[] strArr) throws RemoteException;

    /* renamed from: c */
    void mo4513c(int i, String str) throws RemoteException;

    /* renamed from: c */
    void mo4514c(C0140d dVar) throws RemoteException;

    /* renamed from: c */
    void mo4515c(C0140d dVar, String[] strArr) throws RemoteException;

    /* renamed from: d */
    void mo4516d(C0140d dVar) throws RemoteException;

    /* renamed from: d */
    void mo4517d(C0140d dVar, String[] strArr) throws RemoteException;

    /* renamed from: e */
    void mo4518e(C0140d dVar) throws RemoteException;

    /* renamed from: e */
    void mo4519e(C0140d dVar, String[] strArr) throws RemoteException;

    /* renamed from: f */
    void mo4520f(C0140d dVar) throws RemoteException;

    /* renamed from: f */
    void mo4521f(C0140d dVar, String[] strArr) throws RemoteException;

    /* renamed from: g */
    void mo4522g(C0140d dVar) throws RemoteException;

    /* renamed from: h */
    void mo4523h(C0140d dVar) throws RemoteException;

    /* renamed from: i */
    void mo4524i(C0140d dVar) throws RemoteException;

    /* renamed from: j */
    void mo4525j(C0140d dVar) throws RemoteException;

    /* renamed from: k */
    void mo4526k(C0140d dVar) throws RemoteException;

    /* renamed from: l */
    void mo4527l(C0140d dVar) throws RemoteException;

    /* renamed from: m */
    void mo4528m(C0140d dVar) throws RemoteException;

    /* renamed from: n */
    void mo4529n(C0140d dVar) throws RemoteException;

    /* renamed from: o */
    void mo4530o(C0140d dVar) throws RemoteException;

    void onAchievementUpdated(int i, String str) throws RemoteException;

    void onLeftRoom(int i, String str) throws RemoteException;

    void onP2PConnected(String str) throws RemoteException;

    void onP2PDisconnected(String str) throws RemoteException;

    void onRealTimeMessageReceived(RealTimeMessage realTimeMessage) throws RemoteException;

    void onSignOutComplete() throws RemoteException;

    /* renamed from: p */
    void mo4537p(C0140d dVar) throws RemoteException;

    /* renamed from: q */
    void mo4538q(C0140d dVar) throws RemoteException;

    /* renamed from: r */
    void mo4539r(C0140d dVar) throws RemoteException;

    /* renamed from: s */
    void mo4540s(C0140d dVar) throws RemoteException;

    /* renamed from: t */
    void mo4541t(C0140d dVar) throws RemoteException;

    /* renamed from: u */
    void mo4542u(C0140d dVar) throws RemoteException;

    /* renamed from: v */
    void mo4543v(C0140d dVar) throws RemoteException;

    /* renamed from: w */
    void mo4544w(C0140d dVar) throws RemoteException;
}
