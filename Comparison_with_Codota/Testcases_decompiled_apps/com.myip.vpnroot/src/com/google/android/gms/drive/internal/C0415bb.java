package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.drive.internal.bb */
public class C0415bb extends C0418c {

    /* renamed from: De */
    private final BaseImplementation.C0270b<Status> f989De;

    public C0415bb(BaseImplementation.C0270b<Status> bVar) {
        this.f989De = bVar;
    }

    /* renamed from: o */
    public void mo4903o(Status status) throws RemoteException {
        this.f989De.mo4196b(status);
    }

    public void onSuccess() throws RemoteException {
        this.f989De.mo4196b(Status.f591Jo);
    }
}
