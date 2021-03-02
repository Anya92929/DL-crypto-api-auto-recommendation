package android.support.p001v4.media;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.p001v4.media.session.MediaSessionCompat;
import java.util.List;

/* renamed from: android.support.v4.media.IMediaBrowserServiceCompatCallbacks */
public interface IMediaBrowserServiceCompatCallbacks extends IInterface {
    void onConnect(String str, MediaSessionCompat.Token token, Bundle bundle) throws RemoteException;

    void onConnectFailed() throws RemoteException;

    void onLoadChildren(String str, List list) throws RemoteException;

    /* renamed from: android.support.v4.media.IMediaBrowserServiceCompatCallbacks$Stub */
    public static abstract class Stub extends Binder implements IMediaBrowserServiceCompatCallbacks {
        public Stub() {
            attachInterface(this, "android.support.v4.media.IMediaBrowserServiceCompatCallbacks");
        }

        public static IMediaBrowserServiceCompatCallbacks asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("android.support.v4.media.IMediaBrowserServiceCompatCallbacks");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IMediaBrowserServiceCompatCallbacks)) {
                return new C0151a(iBinder);
            }
            return (IMediaBrowserServiceCompatCallbacks) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            MediaSessionCompat.Token token;
            Bundle bundle;
            switch (i) {
                case 1:
                    parcel.enforceInterface("android.support.v4.media.IMediaBrowserServiceCompatCallbacks");
                    String readString = parcel.readString();
                    if (parcel.readInt() != 0) {
                        token = MediaSessionCompat.Token.CREATOR.createFromParcel(parcel);
                    } else {
                        token = null;
                    }
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    } else {
                        bundle = null;
                    }
                    onConnect(readString, token, bundle);
                    return true;
                case 2:
                    parcel.enforceInterface("android.support.v4.media.IMediaBrowserServiceCompatCallbacks");
                    onConnectFailed();
                    return true;
                case 3:
                    parcel.enforceInterface("android.support.v4.media.IMediaBrowserServiceCompatCallbacks");
                    onLoadChildren(parcel.readString(), parcel.readArrayList(getClass().getClassLoader()));
                    return true;
                case 1598968902:
                    parcel2.writeString("android.support.v4.media.IMediaBrowserServiceCompatCallbacks");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* renamed from: android.support.v4.media.IMediaBrowserServiceCompatCallbacks$Stub$a */
        static class C0151a implements IMediaBrowserServiceCompatCallbacks {

            /* renamed from: a */
            private IBinder f520a;

            C0151a(IBinder iBinder) {
                this.f520a = iBinder;
            }

            public IBinder asBinder() {
                return this.f520a;
            }

            public void onConnect(String str, MediaSessionCompat.Token token, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.IMediaBrowserServiceCompatCallbacks");
                    obtain.writeString(str);
                    if (token != null) {
                        obtain.writeInt(1);
                        token.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f520a.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void onConnectFailed() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.IMediaBrowserServiceCompatCallbacks");
                    this.f520a.transact(2, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void onLoadChildren(String str, List list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.IMediaBrowserServiceCompatCallbacks");
                    obtain.writeString(str);
                    obtain.writeList(list);
                    this.f520a.transact(3, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }
    }
}
