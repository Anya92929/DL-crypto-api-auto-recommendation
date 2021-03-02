package com.google.android.gms.dynamic;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.google.android.gms.dynamic.b */
public interface C0164b extends IInterface {

    /* renamed from: com.google.android.gms.dynamic.b$a */
    public static abstract class C0165a extends Binder implements C0164b {

        /* renamed from: com.google.android.gms.dynamic.b$a$a */
        private static class C0166a implements C0164b {

            /* renamed from: dG */
            private IBinder f444dG;

            C0166a(IBinder iBinder) {
                this.f444dG = iBinder;
            }

            public IBinder asBinder() {
                return this.f444dG;
            }
        }

        public C0165a() {
            attachInterface(this, "com.google.android.gms.dynamic.IObjectWrapper");
        }

        /* renamed from: z */
        public static C0164b m377z(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0164b)) ? new C0166a(iBinder) : (C0164b) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1598968902:
                    reply.writeString("com.google.android.gms.dynamic.IObjectWrapper");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }
}
