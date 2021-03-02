package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.internal.C0316d;
import com.google.android.gms.common.internal.C0339k;
import com.google.android.gms.internal.C0996ch;

@C1130ez
/* renamed from: com.google.android.gms.internal.cg */
public class C0995cg extends C0316d<C0996ch> {

    /* renamed from: pP */
    final int f3017pP;

    public C0995cg(Context context, GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener, int i) {
        super(context, connectionCallbacks, onConnectionFailedListener, new String[0]);
        this.f3017pP = i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3827a(C0339k kVar, C0316d.C0321e eVar) throws RemoteException {
        kVar.mo4526g(eVar, this.f3017pP, getContext().getPackageName(), new Bundle());
    }

    /* renamed from: bC */
    public C0996ch mo8208bC() {
        return (C0996ch) super.mo4435gS();
    }

    /* access modifiers changed from: protected */
    public String getServiceDescriptor() {
        return "com.google.android.gms.ads.internal.gservice.IGservicesValueService";
    }

    /* access modifiers changed from: protected */
    public String getStartServiceAction() {
        return "com.google.android.gms.ads.gservice.START";
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public C0996ch mo3832j(IBinder iBinder) {
        return C0996ch.C0997a.m4123k(iBinder);
    }
}
