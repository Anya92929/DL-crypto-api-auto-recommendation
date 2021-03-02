package android.support.p001v4.media;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.p001v4.p003os.ResultReceiver;

/* renamed from: android.support.v4.media.IMediaBrowserServiceCompat */
public interface IMediaBrowserServiceCompat extends IInterface {
    void addSubscription(String str, IMediaBrowserServiceCompatCallbacks iMediaBrowserServiceCompatCallbacks) throws RemoteException;

    void connect(String str, Bundle bundle, IMediaBrowserServiceCompatCallbacks iMediaBrowserServiceCompatCallbacks) throws RemoteException;

    void disconnect(IMediaBrowserServiceCompatCallbacks iMediaBrowserServiceCompatCallbacks) throws RemoteException;

    void getMediaItem(String str, ResultReceiver resultReceiver) throws RemoteException;

    void removeSubscription(String str, IMediaBrowserServiceCompatCallbacks iMediaBrowserServiceCompatCallbacks) throws RemoteException;

    /* renamed from: android.support.v4.media.IMediaBrowserServiceCompat$Stub */
    public static abstract class Stub extends Binder implements IMediaBrowserServiceCompat {
        public Stub() {
            attachInterface(this, "android.support.v4.media.IMediaBrowserServiceCompat");
        }

        public static IMediaBrowserServiceCompat asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("android.support.v4.media.IMediaBrowserServiceCompat");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IMediaBrowserServiceCompat)) {
                return new C0150a(iBinder);
            }
            return (IMediaBrowserServiceCompat) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v16, resolved type: android.os.Bundle} */
        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v1, types: [android.support.v4.os.ResultReceiver] */
        /* JADX WARNING: type inference failed for: r0v24 */
        /* JADX WARNING: type inference failed for: r0v25 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r5, android.os.Parcel r6, android.os.Parcel r7, int r8) throws android.os.RemoteException {
            /*
                r4 = this;
                r0 = 0
                r1 = 1
                switch(r5) {
                    case 1: goto L_0x0011;
                    case 2: goto L_0x0035;
                    case 3: goto L_0x0047;
                    case 4: goto L_0x005d;
                    case 5: goto L_0x0073;
                    case 1598968902: goto L_0x000a;
                    default: goto L_0x0005;
                }
            L_0x0005:
                boolean r0 = super.onTransact(r5, r6, r7, r8)
            L_0x0009:
                return r0
            L_0x000a:
                java.lang.String r0 = "android.support.v4.media.IMediaBrowserServiceCompat"
                r7.writeString(r0)
                r0 = r1
                goto L_0x0009
            L_0x0011:
                java.lang.String r2 = "android.support.v4.media.IMediaBrowserServiceCompat"
                r6.enforceInterface(r2)
                java.lang.String r2 = r6.readString()
                int r3 = r6.readInt()
                if (r3 == 0) goto L_0x0028
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r6)
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x0028:
                android.os.IBinder r3 = r6.readStrongBinder()
                android.support.v4.media.IMediaBrowserServiceCompatCallbacks r3 = android.support.p001v4.media.IMediaBrowserServiceCompatCallbacks.Stub.asInterface(r3)
                r4.connect(r2, r0, r3)
                r0 = r1
                goto L_0x0009
            L_0x0035:
                java.lang.String r0 = "android.support.v4.media.IMediaBrowserServiceCompat"
                r6.enforceInterface(r0)
                android.os.IBinder r0 = r6.readStrongBinder()
                android.support.v4.media.IMediaBrowserServiceCompatCallbacks r0 = android.support.p001v4.media.IMediaBrowserServiceCompatCallbacks.Stub.asInterface(r0)
                r4.disconnect(r0)
                r0 = r1
                goto L_0x0009
            L_0x0047:
                java.lang.String r0 = "android.support.v4.media.IMediaBrowserServiceCompat"
                r6.enforceInterface(r0)
                java.lang.String r0 = r6.readString()
                android.os.IBinder r2 = r6.readStrongBinder()
                android.support.v4.media.IMediaBrowserServiceCompatCallbacks r2 = android.support.p001v4.media.IMediaBrowserServiceCompatCallbacks.Stub.asInterface(r2)
                r4.addSubscription(r0, r2)
                r0 = r1
                goto L_0x0009
            L_0x005d:
                java.lang.String r0 = "android.support.v4.media.IMediaBrowserServiceCompat"
                r6.enforceInterface(r0)
                java.lang.String r0 = r6.readString()
                android.os.IBinder r2 = r6.readStrongBinder()
                android.support.v4.media.IMediaBrowserServiceCompatCallbacks r2 = android.support.p001v4.media.IMediaBrowserServiceCompatCallbacks.Stub.asInterface(r2)
                r4.removeSubscription(r0, r2)
                r0 = r1
                goto L_0x0009
            L_0x0073:
                java.lang.String r2 = "android.support.v4.media.IMediaBrowserServiceCompat"
                r6.enforceInterface(r2)
                java.lang.String r2 = r6.readString()
                int r3 = r6.readInt()
                if (r3 == 0) goto L_0x008a
                android.os.Parcelable$Creator<android.support.v4.os.ResultReceiver> r0 = android.support.p001v4.p003os.ResultReceiver.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r6)
                android.support.v4.os.ResultReceiver r0 = (android.support.p001v4.p003os.ResultReceiver) r0
            L_0x008a:
                r4.getMediaItem(r2, r0)
                r0 = r1
                goto L_0x0009
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.p001v4.media.IMediaBrowserServiceCompat.Stub.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }

        /* renamed from: android.support.v4.media.IMediaBrowserServiceCompat$Stub$a */
        static class C0150a implements IMediaBrowserServiceCompat {

            /* renamed from: a */
            private IBinder f519a;

            C0150a(IBinder iBinder) {
                this.f519a = iBinder;
            }

            public IBinder asBinder() {
                return this.f519a;
            }

            public void connect(String str, Bundle bundle, IMediaBrowserServiceCompatCallbacks iMediaBrowserServiceCompatCallbacks) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.IMediaBrowserServiceCompat");
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (iMediaBrowserServiceCompatCallbacks != null) {
                        iBinder = iMediaBrowserServiceCompatCallbacks.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f519a.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void disconnect(IMediaBrowserServiceCompatCallbacks iMediaBrowserServiceCompatCallbacks) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.IMediaBrowserServiceCompat");
                    if (iMediaBrowserServiceCompatCallbacks != null) {
                        iBinder = iMediaBrowserServiceCompatCallbacks.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f519a.transact(2, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void addSubscription(String str, IMediaBrowserServiceCompatCallbacks iMediaBrowserServiceCompatCallbacks) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.IMediaBrowserServiceCompat");
                    obtain.writeString(str);
                    if (iMediaBrowserServiceCompatCallbacks != null) {
                        iBinder = iMediaBrowserServiceCompatCallbacks.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f519a.transact(3, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void removeSubscription(String str, IMediaBrowserServiceCompatCallbacks iMediaBrowserServiceCompatCallbacks) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.IMediaBrowserServiceCompat");
                    obtain.writeString(str);
                    if (iMediaBrowserServiceCompatCallbacks != null) {
                        iBinder = iMediaBrowserServiceCompatCallbacks.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f519a.transact(4, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void getMediaItem(String str, ResultReceiver resultReceiver) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.IMediaBrowserServiceCompat");
                    obtain.writeString(str);
                    if (resultReceiver != null) {
                        obtain.writeInt(1);
                        resultReceiver.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f519a.transact(5, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }
    }
}
