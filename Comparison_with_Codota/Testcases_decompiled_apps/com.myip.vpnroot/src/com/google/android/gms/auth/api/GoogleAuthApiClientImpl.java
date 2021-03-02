package com.google.android.gms.auth.api;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.auth.api.IGoogleAuthService;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.C0316d;
import com.google.android.gms.common.internal.C0339k;
import com.google.android.gms.common.internal.ClientSettings;

public final class GoogleAuthApiClientImpl extends C0316d<IGoogleAuthService> {
    public static final String ACTION_START_SERVICE = "com.google.android.gms.auth.service.START";
    public static final String SERVICE_DESCRIPTOR = "com.google.android.gms.auth.api.IGoogleAuthService";

    /* renamed from: Dd */
    private final String f373Dd;

    /* renamed from: Ds */
    private String[] f374Ds;

    public GoogleAuthApiClientImpl(Context context, Looper looper, ClientSettings settings, GoogleApiClient.ConnectionCallbacks connectedListener, GoogleApiClient.OnConnectionFailedListener connectionFailedListener, String accountName, String[] scopes) {
        super(context, looper, connectedListener, connectionFailedListener, scopes);
        this.f373Dd = accountName;
        this.f374Ds = scopes;
    }

    public GoogleAuthApiClientImpl(Context context, ClientSettings settings, GoogleApiClient.ConnectionCallbacks connectedListener, GoogleApiClient.OnConnectionFailedListener connectionFailedListener, String accountName, String[] scopes) {
        this(context, context.getMainLooper(), settings, connectedListener, connectionFailedListener, accountName, scopes);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3827a(C0339k kVar, C0316d.C0321e eVar) throws RemoteException {
        kVar.mo4516b(eVar, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), this.f373Dd, mo4434gR());
    }

    /* access modifiers changed from: protected */
    /* renamed from: createServiceInterface */
    public IGoogleAuthService mo3832j(IBinder iBinder) {
        return IGoogleAuthService.Stub.asInterface(iBinder);
    }

    public String getAccountName() {
        return this.f373Dd;
    }

    /* access modifiers changed from: protected */
    public String getServiceDescriptor() {
        return SERVICE_DESCRIPTOR;
    }

    /* access modifiers changed from: protected */
    public String getStartServiceAction() {
        return ACTION_START_SERVICE;
    }
}
