package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.internal.C0318by;
import com.google.android.gms.internal.C0387de;

/* renamed from: com.google.android.gms.internal.bt */
public class C0312bt extends C0387de<C0318by> {

    /* renamed from: gz */
    private final int f910gz;

    public C0312bt(Context context, GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener, int i) {
        super(context, connectionCallbacks, onConnectionFailedListener, new String[0]);
        this.f910gz = i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4163a(C0402dj djVar, C0387de.C0391d dVar) throws RemoteException {
        djVar.mo4379g(dVar, this.f910gz, getContext().getPackageName(), new Bundle());
    }

    /* access modifiers changed from: protected */
    /* renamed from: ag */
    public String mo4164ag() {
        return "com.google.android.gms.ads.service.START";
    }

    /* access modifiers changed from: protected */
    /* renamed from: ah */
    public String mo4165ah() {
        return "com.google.android.gms.ads.internal.request.IAdRequestService";
    }

    /* renamed from: ai */
    public C0318by mo4166ai() {
        return (C0318by) super.mo4332bd();
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public C0318by mo4168p(IBinder iBinder) {
        return C0318by.C0319a.m651q(iBinder);
    }
}
