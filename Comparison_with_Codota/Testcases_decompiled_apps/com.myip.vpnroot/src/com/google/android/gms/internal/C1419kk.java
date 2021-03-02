package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.C0316d;
import com.google.android.gms.common.internal.C0336j;
import com.google.android.gms.common.internal.C0339k;
import com.google.android.gms.internal.C1430ko;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.kk */
public class C1419kk extends C0316d<C1430ko> implements C1415kj {

    /* renamed from: Tm */
    private static final Set<String> f4186Tm = Collections.unmodifiableSet(new HashSet<String>() {
        {
            add("https://www.googleapis.com/auth/fitness.activity.read");
            add("https://www.googleapis.com/auth/fitness.activity.write");
            add("https://www.googleapis.com/auth/fitness.body.read");
            add("https://www.googleapis.com/auth/fitness.body.write");
            add("https://www.googleapis.com/auth/fitness.location.read");
            add("https://www.googleapis.com/auth/fitness.location.write");
        }
    });

    /* renamed from: Dd */
    private final String f4187Dd;

    public C1419kk(Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, String str, String[] strArr) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, strArr);
        this.f4187Dd = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3827a(C0339k kVar, C0316d.C0321e eVar) throws RemoteException {
        kVar.mo4510a((C0336j) eVar, (int) GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), this.f4187Dd, mo4434gR(), new Bundle());
    }

    /* access modifiers changed from: protected */
    /* renamed from: ao */
    public C1430ko mo3832j(IBinder iBinder) {
        return C1430ko.C1431a.m5296as(iBinder);
    }

    /* access modifiers changed from: protected */
    public String getServiceDescriptor() {
        return "com.google.android.gms.fitness.internal.IGoogleFitnessService";
    }

    /* access modifiers changed from: protected */
    public String getStartServiceAction() {
        return "com.google.android.gms.fitness.GoogleFitnessService.START";
    }

    /* renamed from: iT */
    public C1430ko mo9097iT() {
        return (C1430ko) mo4435gS();
    }
}
