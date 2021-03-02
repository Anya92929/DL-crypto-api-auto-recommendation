package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.internal.C0316d;
import com.google.android.gms.common.internal.C0339k;
import com.google.android.gms.internal.C1173fm;

@C1130ez
/* renamed from: com.google.android.gms.internal.fh */
public class C1167fh extends C0316d<C1173fm> {

    /* renamed from: pP */
    final int f3527pP;

    public C1167fh(Context context, GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener, int i) {
        super(context, connectionCallbacks, onConnectionFailedListener, new String[0]);
        this.f3527pP = i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: C */
    public C1173fm mo3832j(IBinder iBinder) {
        return C1173fm.C1174a.m4465D(iBinder);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3827a(C0339k kVar, C0316d.C0321e eVar) throws RemoteException {
        kVar.mo4526g(eVar, this.f3527pP, getContext().getPackageName(), new Bundle());
    }

    /* renamed from: cF */
    public C1173fm mo8494cF() {
        return (C1173fm) super.mo4435gS();
    }

    /* access modifiers changed from: protected */
    public String getServiceDescriptor() {
        return "com.google.android.gms.ads.internal.request.IAdRequestService";
    }

    /* access modifiers changed from: protected */
    public String getStartServiceAction() {
        return "com.google.android.gms.ads.service.START";
    }
}
